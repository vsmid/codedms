package hr.codenamecode.codedms.http.calls;

import hr.codenamecode.codedms.data.enums.IncludeRelationships;
import hr.codenamecode.codedms.data.objects.ObjectList;
import hr.codenamecode.codedms.http.Call;
import hr.codenamecode.codedms.http.CmisSelector;
import hr.codenamecode.codedms.service.DiscoveryService;
import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.math.BigInteger;

import static hr.codenamecode.codedms.utils.HttpUtils.*;
import static jakarta.servlet.http.HttpServletResponse.SC_OK;

@CmisSelector("query")
public class Query extends Call {

    @Inject
    private DiscoveryService discoveryService;

    @Override
    public void serve(HttpServletRequest req, HttpServletResponse resp) {
        String repositoryId = getRepositoryId(req);
        String statement = getStringParameter(req, "statement");
        if (statement == null || statement.isEmpty()) {
            statement = getStringParameter(req, "q");
        }
        Boolean searchAllVersions = getBooleanParameter(req, "searchAllVersions");
        Boolean includeAllowableActions = getBooleanParameter(req, "includeAllowableActions");
        IncludeRelationships includeRelationships =
                IncludeRelationships.fromValue(getStringParameter(req, "includeRelationships", "none"));
        String renditionFilter = getStringParameter(req, "renditionFilter");
        BigInteger maxItems = getBigIntegerParameter(req, "maxItems", 100);
        BigInteger skipCount = getBigIntegerParameter(req, "skipCount", 0);

        ObjectList objectList = discoveryService.query(repositoryId, statement, searchAllVersions,
                includeAllowableActions,
                includeRelationships, renditionFilter, maxItems, skipCount, null);

        writeJSON(SC_OK, objectList, resp);
    }
}
