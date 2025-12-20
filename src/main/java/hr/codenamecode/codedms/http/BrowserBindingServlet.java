package hr.codenamecode.codedms.http;

import hr.codenamecode.codedms.exceptions.CmisNotSupportedException;
import hr.codenamecode.codedms.exceptions.CmisObjectNotFoundException;
import hr.codenamecode.codedms.http.control.ControlAwareHttpServletRequest;
import hr.codenamecode.codedms.utils.HttpUtils;
import jakarta.enterprise.inject.UnsatisfiedResolutionException;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.inject.Inject;
import jakarta.json.bind.Jsonb;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/cmis11/*"})
@MultipartConfig
public class BrowserBindingServlet extends HttpServlet {

    private ExceptionHandler exceptionHandler;

    @Inject
    private Jsonb jsonb;

    @Override
    public void init() {
        exceptionHandler = new ExceptionHandler(this.jsonb);
    }

    @Override
    public void destroy() {
        try {
            jsonb.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) {
        try {
            try {
                super.service(req, resp);
            } catch (Exception e) {
                if (e instanceof UnsatisfiedResolutionException) {
                    throw new CmisNotSupportedException("unsupported service call");
                } else {
                    throw e;
                }
            }
        } catch (Exception e) {
            exceptionHandler.handleError(e, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String repositoryId = HttpUtils.getRepositoryId(req);
        String cmisSelector = repositoryId == null || repositoryId.isEmpty() ? "repositoryInfos" : req.getParameter(
                "cmisselector");
        CmisSelector selector = new CmisSelector.CmisSelectorLiteral(cmisSelector);
        CDI.current().select(Call.class, selector).get().serve(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String repositoryId = HttpUtils.getRepositoryId(req);

        if (repositoryId == null) {
            throw new CmisObjectNotFoundException("repository id is missing");
        } else {
            ControlAwareHttpServletRequest controlAwareRequest = new ControlAwareHttpServletRequest(req);
            CmisAction action = new CmisAction.CmisActionLiteral(controlAwareRequest.getParameter("cmisaction"));
            CDI.current().select(Call.class, action).get().serve(controlAwareRequest, resp);
        }
    }
}
