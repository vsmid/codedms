package hr.codenamecode.codedms.exceptions;

import java.math.BigInteger;
import java.util.Map;


public class CmisConnectionException extends CmisBaseException {

    public static final String EXCEPTION_NAME = "connection";


    public CmisConnectionException() {
        super();
    }


    public CmisConnectionException(String message, BigInteger code, Throwable cause) {
        super(message, code, cause);
    }


    public CmisConnectionException(String message, String errorContent) {
        super(message, errorContent);
    }


    public CmisConnectionException(String message, BigInteger code) {
        super(message, code);
    }


    public CmisConnectionException(String message, BigInteger code, String errorContent) {
        super(message, code, errorContent);
    }


    public CmisConnectionException(
            String message, BigInteger code, String errorContent, Map<String, String> additionalData) {
        super(message, code, errorContent, additionalData);
    }


    public CmisConnectionException(
            String message, String errorContent, Map<String, String> additionalData, Throwable cause) {
        super(message, errorContent, additionalData, cause);
    }


    public CmisConnectionException(String message, String errorContent, Throwable cause) {
        super(message, errorContent, cause);
    }


    public CmisConnectionException(String message, Throwable cause) {
        super(message, BigInteger.ZERO, cause);
    }


    public CmisConnectionException(String message) {
        super(message, BigInteger.ZERO);
    }


    public CmisConnectionException(String url, int respCode, Throwable cause) {
        super(
                "Cannot access \""
                        + url
                        + "\""
                        + (respCode > 0 ? " (HTTP status code " + respCode + ")" : "")
                        + ": "
                        + formatMessage(cause),
                BigInteger.ZERO,
                cause);
    }

    private static String formatMessage(Throwable cause) {
        if (cause == null) {
            return "(no exception)";
        }

        String msg = cause.getMessage();
        if (msg == null || msg.isEmpty()) {
            msg = cause.getClass().getSimpleName();
        }

        return msg;
    }

    @Override
    public final String getExceptionName() {
        return EXCEPTION_NAME;
    }
}
