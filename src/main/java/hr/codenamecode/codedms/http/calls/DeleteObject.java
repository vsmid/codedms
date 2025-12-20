package hr.codenamecode.codedms.http.calls;

import hr.codenamecode.codedms.http.Call;
import hr.codenamecode.codedms.http.CmisAction;
import hr.codenamecode.codedms.service.ObjectService;
import hr.codenamecode.codedms.utils.HttpUtils;
import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Objects;

import static hr.codenamecode.codedms.utils.HttpUtils.*;
import static jakarta.servlet.http.HttpServletResponse.SC_OK;

@CmisAction("deleteObject")
public class DeleteObject extends Call {

    @Inject
    private ObjectService objectService;

    @Override
    public void serve(HttpServletRequest req, HttpServletResponse resp) {
        String repositoryId = getRepositoryId(req);
        String objectId = getStringParameter(req, "objectId", Objects::nonNull);
        Boolean allVersions = getBooleanParameter(req, "allVersions");

        objectService.deleteObject(repositoryId, objectId, allVersions, null);

        writeEmpty(SC_OK, resp);
    }
}
