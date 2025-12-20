package hr.codenamecode.codedms.http.calls;

import hr.codenamecode.codedms.data.enums.VersioningState;
import hr.codenamecode.codedms.data.objects.Acl;
import hr.codenamecode.codedms.data.objects.ContentStream;
import hr.codenamecode.codedms.data.objects.ObjectData;
import hr.codenamecode.codedms.data.objects.Properties;
import hr.codenamecode.codedms.exceptions.CmisRuntimeException;
import hr.codenamecode.codedms.http.Call;
import hr.codenamecode.codedms.http.CmisAction;
import hr.codenamecode.codedms.http.control.ControlAwareHttpServletRequest;
import hr.codenamecode.codedms.service.ObjectService;
import hr.codenamecode.codedms.utils.TypeCache;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

import static hr.codenamecode.codedms.utils.HttpUtils.getRepositoryId;
import static hr.codenamecode.codedms.utils.HttpUtils.getStringParameter;
import static jakarta.servlet.http.HttpServletResponse.SC_CREATED;

@CmisAction("createDocument")
public class CreateDocument extends Call {

    @Inject
    private ObjectService objectService;

    @Inject
    @Named("typeCache")
    private TypeCache typeCache;

    @Override
    public void serve(HttpServletRequest req, HttpServletResponse resp) {
        String repositoryId = getRepositoryId(req);
        String folderId = getStringParameter(req, "objectId", Objects::nonNull);
        VersioningState versioningState = VersioningState.fromValue(getStringParameter(req,
                "versioningState"));
        Properties newProperties = ((ControlAwareHttpServletRequest) req).createNewProperties(typeCache);
        List<String> policies = ((ControlAwareHttpServletRequest) req).createPolicies();
        Acl addAcl = ((ControlAwareHttpServletRequest) req).createAddAcl();
        Acl removeAcl = ((ControlAwareHttpServletRequest) req).createRemoveAcl();

        ContentStream contentStream;
        try {
            Part content = req.getPart("content");
            contentStream = new ContentStream();
            contentStream.setLength(BigInteger.valueOf(content.getSize()));
            contentStream.setMimetype(content.getContentType());
            contentStream.setStream(content.getInputStream());
            contentStream.setFilename(content.getSubmittedFileName());
        } catch (ServletException | IOException e) {
            throw new CmisRuntimeException("invalid content");
        }

        String newDocumentId = objectService.createDocument(repositoryId, newProperties, folderId, contentStream,
                versioningState, policies, addAcl,
                removeAcl, null);
        ObjectData objectData = objectService.getObject(repositoryId, newDocumentId, null, null, null, null, null,
                null, null);

        writeJSON(SC_CREATED, objectData, resp);
    }
}
