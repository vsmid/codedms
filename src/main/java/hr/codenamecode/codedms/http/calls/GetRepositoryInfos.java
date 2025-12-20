package hr.codenamecode.codedms.http.calls;

import hr.codenamecode.codedms.data.repositoryinfo.RepositoryInfo;
import hr.codenamecode.codedms.http.Call;
import hr.codenamecode.codedms.http.CmisSelector;
import hr.codenamecode.codedms.service.RepositoryInfoService;
import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static jakarta.servlet.http.HttpServletResponse.SC_OK;

@CmisSelector("repositoryInfos")
public class GetRepositoryInfos extends Call {

    @Inject
    private RepositoryInfoService repositoryInfoService;

    @Override
    public void serve(HttpServletRequest req, HttpServletResponse resp) {
        List<RepositoryInfo> repositoryInfos = repositoryInfoService.getRepositoryInfos(null);

        // Set url dependant properties
        String baseUri = req.getRequestURL().toString();
        Map<String, RepositoryInfo> map = repositoryInfos.stream().peek(ri -> {
            ri.setRepositoryUrl(baseUri + ri.getRepositoryId());
            ri.setRootFolderUrl(ri.getRepositoryUrl() + "/root");
        }).collect(Collectors.toMap(RepositoryInfo::getRepositoryId, ri -> ri));

        writeJSON(SC_OK, map, resp);
    }
}
