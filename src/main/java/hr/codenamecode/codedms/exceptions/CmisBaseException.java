package hr.codenamecode.codedms.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Map;

import static jakarta.servlet.http.HttpServletResponse.SC_INTERNAL_SERVER_ERROR;

public abstract class CmisBaseException extends RuntimeException {

    @Getter
    private BigInteger code = BigInteger.valueOf(SC_INTERNAL_SERVER_ERROR);
    @Getter
    private String errorContent;
    @Getter
    @Setter
    private Map<String, String> additionalData;

    protected CmisBaseException() {
        super();
    }

    protected CmisBaseException(String message, BigInteger code, Throwable cause) {
        super(message, cause);
        if (code != null) {
            this.code = code;
        }
    }

    protected CmisBaseException(
            String message, String errorContent, Map<String, String> additionalData, Throwable cause) {
        super(message, cause);
        this.errorContent = errorContent;
        this.additionalData = additionalData;
    }

    protected CmisBaseException(String message, String errorContent, Throwable cause) {
        this(message, errorContent, null, cause);
    }

    protected CmisBaseException(String message, BigInteger code) {
        super(message);
        this.code = code;
    }

    protected CmisBaseException(String message, BigInteger code, String errorContent) {
        super(message);
        this.code = code;
        this.errorContent = errorContent;
    }

    protected CmisBaseException(
            String message, BigInteger code, String errorContent, Map<String, String> additionalData) {
        this(message, code, errorContent);
        this.additionalData = additionalData;
    }

    protected CmisBaseException(String message, String errorContent) {
        super(message);
        this.errorContent = errorContent;
    }

    protected CmisBaseException(String message, Throwable cause) {
        this(message, (BigInteger) null, cause);
    }

    protected CmisBaseException(String message) {
        this(message, (BigInteger) null);
    }

    public String getAdditionalData(String key) {
        if (additionalData == null) {
            return null;
        }

        return additionalData.get(key);
    }

    public abstract String getExceptionName();
}
