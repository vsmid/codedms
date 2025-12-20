package hr.codenamecode.codedms.http.calls;

import hr.codenamecode.codedms.data.objects.Acl;
import hr.codenamecode.codedms.data.objects.ObjectData;
import hr.codenamecode.codedms.data.objects.Properties;
import hr.codenamecode.codedms.http.Call;
import hr.codenamecode.codedms.http.CmisAction;
import hr.codenamecode.codedms.http.control.ControlAwareHttpServletRequest;
import hr.codenamecode.codedms.service.ObjectService;
import hr.codenamecode.codedms.utils.TypeCache;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Objects;

import static hr.codenamecode.codedms.utils.HttpUtils.getRepositoryId;
import static hr.codenamecode.codedms.utils.HttpUtils.getStringParameter;
import static jakarta.servlet.http.HttpServletResponse.SC_CREATED;

@CmisAction("createFolder")
public class CreateFolder extends Call {

    @Inject
    private ObjectService objectService;

    @Inject
    @Named("typeCache")
    private TypeCache typeCache;

    @Override
    public void serve(HttpServletRequest req, HttpServletResponse resp) {
        String repositoryId = getRepositoryId(req);
        String folderId = getStringParameter(req, "objectId", Objects::nonNull);
        Properties newProperties = ((ControlAwareHttpServletRequest) req).createNewProperties(typeCache);
        Acl addAcl = ((ControlAwareHttpServletRequest) req).createAddAcl();
        Acl removeAcl = ((ControlAwareHttpServletRequest) req).createRemoveAcl();
        List<String> policies = ((ControlAwareHttpServletRequest) req).createPolicies();

        String newFolderId = objectService.createFolder(repositoryId, newProperties, folderId, policies, addAcl,
                removeAcl, null);
        ObjectData objectData = objectService.getObject(repositoryId, newFolderId, null, null, null, null, null, null
                , null);

        writeJSON(SC_CREATED, objectData, resp);
    }
}
