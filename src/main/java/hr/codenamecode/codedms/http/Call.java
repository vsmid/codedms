package hr.codenamecode.codedms.http;

import hr.codenamecode.codedms.exceptions.CmisRuntimeException;
import jakarta.inject.Inject;
import jakarta.json.bind.Jsonb;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;

import java.io.IOException;

public abstract class Call {

    @Inject
    private @Getter Jsonb jsonb;

    public abstract void serve(HttpServletRequest req, HttpServletResponse resp);

    protected void writeJSON(int status, Object data, HttpServletResponse resp) {
        resp.setContentType("application/json");
        resp.setStatus(status);
        try {
            resp.getWriter().println(jsonb.toJson(data));
        } catch (IOException e) {
            throw new CmisRuntimeException("error while writing response");
        }
    }

    protected void writeEmpty(int status, HttpServletResponse resp) {
        resp.setStatus(status);
    }
}