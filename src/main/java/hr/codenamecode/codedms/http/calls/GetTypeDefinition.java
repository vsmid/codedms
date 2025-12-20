package hr.codenamecode.codedms.http.calls;

import hr.codenamecode.codedms.data.repositoryinfo.TypeDefinition;
import hr.codenamecode.codedms.http.Call;
import hr.codenamecode.codedms.http.CmisSelector;
import hr.codenamecode.codedms.service.RepositoryInfoService;
import hr.codenamecode.codedms.utils.HttpUtils;
import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Objects;

import static hr.codenamecode.codedms.utils.HttpUtils.*;
import static jakarta.servlet.http.HttpServletResponse.SC_OK;

@CmisSelector("typeDefinition")
public class GetTypeDefinition extends Call {

    @Inject
    private RepositoryInfoService repositoryInfoService;

    @Override
    public void serve(HttpServletRequest req, HttpServletResponse resp) {
        String repositoryId = getRepositoryId(req);
        String typeId = getStringParameter(req, "typeId", Objects::nonNull);

        TypeDefinition typeDefinition = repositoryInfoService.getTypeDefinition(repositoryId, typeId, null);

        writeJSON(SC_OK, typeDefinition, resp);
    }
}
