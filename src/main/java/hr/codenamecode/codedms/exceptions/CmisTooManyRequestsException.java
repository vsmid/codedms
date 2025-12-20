package hr.codenamecode.codedms.exceptions;

import java.math.BigInteger;
import java.util.Map;


public class CmisTooManyRequestsException extends CmisRuntimeException {


    public CmisTooManyRequestsException() {
        super();
    }


    public CmisTooManyRequestsException(String message, BigInteger code, Throwable cause) {
        super(message, code, cause);
    }


    public CmisTooManyRequestsException(String message, String errorContent) {
        super(message, errorContent);
    }


    public CmisTooManyRequestsException(String message, BigInteger code) {
        super(message, code);
    }


    public CmisTooManyRequestsException(String message, BigInteger code, String errorContent) {
        super(message, code, errorContent);
    }


    public CmisTooManyRequestsException(
            String message, BigInteger code, String errorContent, Map<String, String> additionalData) {
        super(message, code, errorContent, additionalData);
    }


    public CmisTooManyRequestsException(
            String message, String errorContent, Map<String, String> additionalData, Throwable cause) {
        super(message, errorContent, additionalData, cause);
    }


    public CmisTooManyRequestsException(String message, String errorContent, Throwable cause) {
        super(message, errorContent, cause);
    }


    public CmisTooManyRequestsException(String message, Throwable cause) {
        super(message, BigInteger.ZERO, cause);
    }


    public CmisTooManyRequestsException(String message) {
        super(message, BigInteger.ZERO);
    }

    @Override
    public BigInteger getCode() {
        return BigInteger.valueOf(429);
    }
}
