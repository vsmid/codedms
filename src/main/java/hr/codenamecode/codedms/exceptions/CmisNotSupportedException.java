package hr.codenamecode.codedms.exceptions;

import java.math.BigInteger;
import java.util.Map;

import static jakarta.servlet.http.HttpServletResponse.SC_METHOD_NOT_ALLOWED;


public class CmisNotSupportedException extends CmisBaseException {

    public static final String EXCEPTION_NAME = "notSupported";


    public CmisNotSupportedException() {
        super();
    }


    public CmisNotSupportedException(String message, BigInteger code, Throwable cause) {
        super(message, code, cause);
    }


    public CmisNotSupportedException(String message, String errorContent) {
        super(message, errorContent);
    }


    public CmisNotSupportedException(String message, BigInteger code) {
        super(message, code);
    }


    public CmisNotSupportedException(String message, BigInteger code, String errorContent) {
        super(message, code, errorContent);
    }


    public CmisNotSupportedException(
            String message, BigInteger code, String errorContent, Map<String, String> additionalData) {
        super(message, code, errorContent, additionalData);
    }


    public CmisNotSupportedException(
            String message, String errorContent, Map<String, String> additionalData, Throwable cause) {
        super(message, errorContent, additionalData, cause);
    }


    public CmisNotSupportedException(String message, String errorContent, Throwable cause) {
        super(message, errorContent, cause);
    }


    public CmisNotSupportedException(String message, Throwable cause) {
        super(message, BigInteger.ZERO, cause);
    }


    public CmisNotSupportedException(String message) {
        super(message, BigInteger.ZERO);
    }

    @Override
    public final String getExceptionName() {
        return EXCEPTION_NAME;
    }

    @Override
    public BigInteger getCode() {
        return BigInteger.valueOf(SC_METHOD_NOT_ALLOWED);
    }
}
