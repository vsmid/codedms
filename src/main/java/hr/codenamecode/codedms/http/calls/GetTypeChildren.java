package hr.codenamecode.codedms.http.calls;

import hr.codenamecode.codedms.data.repositoryinfo.TypeDefinitionList;
import hr.codenamecode.codedms.http.Call;
import hr.codenamecode.codedms.http.CmisSelector;
import hr.codenamecode.codedms.service.RepositoryInfoService;
import hr.codenamecode.codedms.utils.HttpUtils;
import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.math.BigInteger;
import java.util.Objects;

import static hr.codenamecode.codedms.utils.HttpUtils.*;
import static jakarta.servlet.http.HttpServletResponse.SC_OK;

@CmisSelector("typeChildren")
public class GetTypeChildren extends Call {

    @Inject
    private RepositoryInfoService repositoryInfoService;

    @Override
    public void serve(HttpServletRequest req, HttpServletResponse resp) {
        String repositoryId = getRepositoryId(req);
        String typeId = getStringParameter(req, "typeId", Objects::nonNull);
        Boolean includePropertyDefinitions = getBooleanParameter(req, "includePropertyDefinitions", false);
        BigInteger maxItem = getBigIntegerParameter(req, "maxItems", 100);
        BigInteger skipCount = getBigIntegerParameter(req, "skipCount", 0);

        TypeDefinitionList typeChildren = repositoryInfoService.getTypeChildren(repositoryId, typeId,
                includePropertyDefinitions, maxItem, skipCount, null);

        writeJSON(SC_OK, typeChildren, resp);
    }
}
