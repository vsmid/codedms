package hr.codenamecode.codedms.http.calls;

import hr.codenamecode.codedms.data.enums.IncludeRelationships;
import hr.codenamecode.codedms.data.objects.ObjectInFolderList;
import hr.codenamecode.codedms.http.Call;
import hr.codenamecode.codedms.http.CmisSelector;
import hr.codenamecode.codedms.service.NavigationService;
import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.math.BigInteger;
import java.util.Objects;

import static hr.codenamecode.codedms.utils.HttpUtils.*;
import static jakarta.servlet.http.HttpServletResponse.SC_OK;

@CmisSelector("children")
public class GetChildren extends Call {

    @Inject
    private NavigationService navigationService;

    @Override
    public void serve(HttpServletRequest req, HttpServletResponse resp) {
        String repositoryId = getRepositoryId(req);
        String folderId = getStringParameter(req, "objectId", Objects::nonNull);
        Boolean includeAllowableActions = getBooleanParameter(req, "includeAllowableActions", false);
        IncludeRelationships includeRelationships = IncludeRelationships.fromValue(getStringParameter(req,
                "includeRelationships", "none"));
        String renditionFilter = getStringParameter(req, "renditionFilter");
        String filter = getStringParameter(req, "filter");
        String orderBy = getStringParameter(req, "orderBy");
        Boolean includePathSegment = getBooleanParameter(req, "includePathSegment", false);
        BigInteger maxItem = getBigIntegerParameter(req, "maxItems", 100);
        BigInteger skipCount = getBigIntegerParameter(req, "skipCount", 0);

        ObjectInFolderList children = navigationService.getChildren(repositoryId, folderId, filter, orderBy,
                includeAllowableActions, includeRelationships, renditionFilter, includePathSegment,
                maxItem, skipCount, null);

        writeJSON(SC_OK, children, resp);
    }
}
