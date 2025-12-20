package hr.codenamecode.codedms.http.control;

import hr.codenamecode.codedms.data.objects.Acl;
import hr.codenamecode.codedms.data.objects.Properties;
import hr.codenamecode.codedms.exceptions.CmisNotSupportedException;
import hr.codenamecode.codedms.utils.TypeCache;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ControlAwareHttpServletRequest extends HttpServletRequestWrapper {

    private final Map<String, String[]> parameterMap;
    private final ControlParser controlPa;

    public ControlAwareHttpServletRequest(HttpServletRequest request) throws ServletException, IOException {
        super(request);

        if (request.getContentType().startsWith("multipart/form-data")) {
            controlPa =
                    new MultipartControlParser(request.getParts().stream().toList());
            parameterMap = controlPa.getParameterMap();
        } else if (request.getContentType().equals("application/x-www-form-urlencoded")) {
            controlPa = new ControlParser(request.getParameterMap());
            parameterMap = controlPa.getParameterMap();
        } else {
            throw new CmisNotSupportedException("content type " + request.getContentType() + " is not supported");
        }
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        return Collections.unmodifiableMap(parameterMap);
    }

    public Properties createNewProperties(TypeCache typeCache) {
        return controlPa.createNewProperties(typeCache);
    }

    public Acl createAddAcl() {
        return controlPa.createAddAcl();
    }

    public Acl createRemoveAcl() {
        return controlPa.createRemoveAcl();
    }

    public List<String> createPolicies() {
        return controlPa.createPolicies();
    }
}
