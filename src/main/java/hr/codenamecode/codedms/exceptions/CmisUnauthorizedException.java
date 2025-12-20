package hr.codenamecode.codedms.exceptions;

import java.math.BigInteger;
import java.util.Map;

public class CmisUnauthorizedException extends CmisRuntimeException {

    public CmisUnauthorizedException() {
        super();
    }

    public CmisUnauthorizedException(String message, BigInteger code, Throwable cause) {
        super(message, code, cause);
    }

    public CmisUnauthorizedException(String message, String errorContent) {
        super(message, errorContent);
    }

    public CmisUnauthorizedException(String message, BigInteger code) {
        super(message, code);
    }

    public CmisUnauthorizedException(String message, BigInteger code, String errorContent) {
        super(message, code, errorContent);
    }

    public CmisUnauthorizedException(
            String message, BigInteger code, String errorContent, Map<String, String> additionalData) {
        super(message, code, errorContent, additionalData);
    }

    public CmisUnauthorizedException(
            String message, String errorContent, Map<String, String> additionalData, Throwable cause) {
        super(message, errorContent, additionalData, cause);
    }

    public CmisUnauthorizedException(String message, String errorContent, Throwable cause) {
        super(message, errorContent, cause);
    }

    public CmisUnauthorizedException(String message, Throwable cause) {
        super(message, BigInteger.ZERO, cause);
    }

    public CmisUnauthorizedException(String message) {
        super(message, BigInteger.ZERO);
    }
}
