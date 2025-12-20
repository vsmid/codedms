package hr.codenamecode.codedms.exceptions;

import java.math.BigInteger;
import java.util.Map;


public class CmisProxyAuthenticationException extends CmisRuntimeException {


    public CmisProxyAuthenticationException() {
        super();
    }


    public CmisProxyAuthenticationException(String message, BigInteger code, Throwable cause) {
        super(message, code, cause);
    }


    public CmisProxyAuthenticationException(String message, String errorContent) {
        super(message, errorContent);
    }


    public CmisProxyAuthenticationException(String message, BigInteger code) {
        super(message, code);
    }


    public CmisProxyAuthenticationException(String message, BigInteger code, String errorContent) {
        super(message, code, errorContent);
    }


    public CmisProxyAuthenticationException(
            String message, BigInteger code, String errorContent, Map<String, String> additionalData) {
        super(message, code, errorContent, additionalData);
    }


    public CmisProxyAuthenticationException(
            String message, String errorContent, Map<String, String> additionalData, Throwable cause) {
        super(message, errorContent, additionalData, cause);
    }


    public CmisProxyAuthenticationException(String message, String errorContent, Throwable cause) {
        super(message, errorContent, cause);
    }


    public CmisProxyAuthenticationException(String message, Throwable cause) {
        super(message, BigInteger.ZERO, cause);
    }


    public CmisProxyAuthenticationException(String message) {
        super(message, BigInteger.ZERO);
    }
}
