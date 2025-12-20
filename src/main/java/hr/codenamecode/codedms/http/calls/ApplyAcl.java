package hr.codenamecode.codedms.http.calls;

import hr.codenamecode.codedms.data.enums.AclPropagation;
import hr.codenamecode.codedms.data.objects.Acl;
import hr.codenamecode.codedms.http.Call;
import hr.codenamecode.codedms.http.CmisAction;
import hr.codenamecode.codedms.http.control.ControlAwareHttpServletRequest;
import hr.codenamecode.codedms.service.AclService;
import jakarta.inject.Inject;
import jakarta.json.Json;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Objects;

import static hr.codenamecode.codedms.utils.HttpUtils.getRepositoryId;
import static hr.codenamecode.codedms.utils.HttpUtils.getStringParameter;
import static jakarta.servlet.http.HttpServletResponse.SC_CREATED;

@CmisAction("applyAcl")
public class ApplyAcl extends Call {

    @Inject
    private AclService aclService;

    @Override
    public void serve(HttpServletRequest req, HttpServletResponse resp) {
        String repositoryId = getRepositoryId(req);
        String objectId = getStringParameter(req, "objectId", Objects::nonNull);
        AclPropagation aclPropagation = AclPropagation.fromValue(getStringParameter(req, "aclPropagation"));
        Acl addAcl = ((ControlAwareHttpServletRequest) req).createAddAcl();
        Acl removeAcl = ((ControlAwareHttpServletRequest) req).createRemoveAcl();

        Acl acl = aclService.applyAcl(repositoryId, objectId, addAcl, removeAcl, aclPropagation, null);

        writeJSON(SC_CREATED, acl == null ? Json.createObjectBuilder().build() : acl, resp);

    }
}
