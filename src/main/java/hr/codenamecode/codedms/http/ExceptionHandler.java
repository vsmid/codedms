package hr.codenamecode.codedms.http;

import hr.codenamecode.codedms.exceptions.CmisBaseException;
import hr.codenamecode.codedms.exceptions.CmisRuntimeException;
import jakarta.json.Json;
import jakarta.json.JsonObjectBuilder;
import jakarta.json.JsonValue;
import jakarta.json.bind.Jsonb;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class ExceptionHandler {

    private static final Logger LOGGER = Logger.getLogger(ExceptionHandler.class.getName());

    private final Jsonb jsonb;

    public ExceptionHandler(Jsonb jsonb) {
        this.jsonb = jsonb;
    }

    public void handleError(Exception e, HttpServletResponse resp) {
        LOGGER.log(Level.SEVERE, "Error handling request", e);

        int statusCode = e instanceof CmisBaseException cex
                ? cex.getCode().intValue()
                : HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
        String exceptionName =
                e instanceof CmisBaseException cex ? cex.getExceptionName() : CmisRuntimeException.EXCEPTION_NAME;
        String message = e instanceof CmisBaseException cex ? cex.getMessage() : "Unknown error";

        JsonObjectBuilder error = Json.createObjectBuilder();
        error.add("exception", exceptionName);
        error.add("message", message == null ? JsonValue.NULL : Json.createValue(message));

        resp.setStatus(statusCode);
        resp.setContentType("application/json");

        try {
            resp.getWriter().write(jsonb.toJson(error.build()));
        } catch (IOException ex) {
            try {
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            } catch (IOException ignored) {
                // something went wrong, can't do anything about it
            }
        }
    }
}
