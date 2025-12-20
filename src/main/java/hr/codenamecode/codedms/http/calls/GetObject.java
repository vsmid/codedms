package hr.codenamecode.codedms.http.calls;

import hr.codenamecode.codedms.data.enums.IncludeRelationships;
import hr.codenamecode.codedms.data.enums.ReturnVersion;
import hr.codenamecode.codedms.data.objects.ObjectData;
import hr.codenamecode.codedms.http.Call;
import hr.codenamecode.codedms.http.CmisSelector;
import hr.codenamecode.codedms.service.ObjectService;
import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Objects;

import static hr.codenamecode.codedms.utils.HttpUtils.*;
import static jakarta.servlet.http.HttpServletResponse.SC_OK;

@CmisSelector("object")
public class GetObject extends Call {

    @Inject
    private ObjectService objectService;

    @Override
    public void serve(HttpServletRequest req, HttpServletResponse resp) {
        String objectId = getStringParameter(req, "objectId", Objects::nonNull);
        String filter = getStringParameter(req, "filter");
        String renditionFilter = getStringParameter(req, "renditionFilter");
        Boolean includeAllowableActions = getBooleanParameter(req, "includeAllowableActions", false);
        Boolean includePolicyIds = getBooleanParameter(req, "includePolicyIds", false);
        Boolean includeAcl = getBooleanParameter(req, "includeACL", false);
        ReturnVersion returnVersion = ReturnVersion.fromValue(getStringParameter(req, "returnVersion",
                "this"));
        IncludeRelationships includeRelationships = IncludeRelationships.fromValue(getStringParameter(req,
                "includeRelationships", "none"));

        ObjectData objectData = objectService.getObject(getRepositoryId(req), objectId, filter,
                includeAllowableActions, includeRelationships
                , renditionFilter, includePolicyIds, includeAcl, null);

        writeJSON(SC_OK, objectData, resp);
    }
}
