package hr.codenamecode.codedms.exceptions;

import java.math.BigInteger;
import java.util.Map;

import static jakarta.servlet.http.HttpServletResponse.SC_BAD_REQUEST;


public class CmisFilterNotValidException extends CmisBaseException {

    public static final String EXCEPTION_NAME = "filterNotValid";


    public CmisFilterNotValidException() {
        super();
    }


    public CmisFilterNotValidException(String message, BigInteger code, Throwable cause) {
        super(message, code, cause);
    }


    public CmisFilterNotValidException(String message, String errorContent) {
        super(message, errorContent);
    }


    public CmisFilterNotValidException(String message, BigInteger code) {
        super(message, code);
    }


    public CmisFilterNotValidException(String message, BigInteger code, String errorContent) {
        super(message, code, errorContent);
    }


    public CmisFilterNotValidException(
            String message, BigInteger code, String errorContent, Map<String, String> additionalData) {
        super(message, code, errorContent, additionalData);
    }


    public CmisFilterNotValidException(
            String message, String errorContent, Map<String, String> additionalData, Throwable cause) {
        super(message, errorContent, additionalData, cause);
    }


    public CmisFilterNotValidException(String message, String errorContent, Throwable cause) {
        super(message, errorContent, cause);
    }


    public CmisFilterNotValidException(String message, Throwable cause) {
        super(message, BigInteger.ZERO, cause);
    }


    public CmisFilterNotValidException(String message) {
        super(message, BigInteger.ZERO);
    }

    @Override
    public final String getExceptionName() {
        return EXCEPTION_NAME;
    }

    @Override
    public BigInteger getCode() {
        return BigInteger.valueOf(SC_BAD_REQUEST);
    }
}
