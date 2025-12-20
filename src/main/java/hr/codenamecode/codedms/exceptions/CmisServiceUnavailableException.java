package hr.codenamecode.codedms.exceptions;

import java.math.BigInteger;
import java.util.Map;

import static jakarta.servlet.http.HttpServletResponse.SC_SERVICE_UNAVAILABLE;

public class CmisServiceUnavailableException extends CmisRuntimeException {


    public CmisServiceUnavailableException() {
        super();
    }


    public CmisServiceUnavailableException(String message, BigInteger code, Throwable cause) {
        super(message, code, cause);
    }


    public CmisServiceUnavailableException(String message, String errorContent) {
        super(message, errorContent);
    }


    public CmisServiceUnavailableException(String message, BigInteger code) {
        super(message, code);
    }


    public CmisServiceUnavailableException(String message, BigInteger code, String errorContent) {
        super(message, code, errorContent);
    }


    public CmisServiceUnavailableException(
            String message, BigInteger code, String errorContent, Map<String, String> additionalData) {
        super(message, code, errorContent, additionalData);
    }


    public CmisServiceUnavailableException(
            String message, String errorContent, Map<String, String> additionalData, Throwable cause) {
        super(message, errorContent, additionalData, cause);
    }


    public CmisServiceUnavailableException(String message, String errorContent, Throwable cause) {
        super(message, errorContent, cause);
    }


    public CmisServiceUnavailableException(String message, Throwable cause) {
        super(message, BigInteger.ZERO, cause);
    }


    public CmisServiceUnavailableException(String message) {
        super(message, BigInteger.ZERO);
    }

    @Override
    public BigInteger getCode() {
        return BigInteger.valueOf(SC_SERVICE_UNAVAILABLE);
    }
}
