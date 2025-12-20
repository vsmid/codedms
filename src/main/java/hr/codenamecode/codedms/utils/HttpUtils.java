package hr.codenamecode.codedms.utils;

import hr.codenamecode.codedms.exceptions.CmisInvalidArgumentException;
import jakarta.servlet.http.HttpServletRequest;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.function.Function;
import java.util.function.Predicate;

public final class HttpUtils {

    private static final String MIME_SPECIALS = "()<>@,;:\\\"/[]?=" + "\t ";
    private static final String RFC2231_SPECIALS = "*'%" + MIME_SPECIALS;
    private static final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();

    private HttpUtils() {
    }

    public static String getRepositoryId(HttpServletRequest req) {
        String pathInfo = req.getPathInfo();
        if (pathInfo == null || pathInfo.length() <= 1) {
            return null;
        }
        int secondSlash = pathInfo.indexOf('/', 1);
        if (secondSlash == -1) {
            return pathInfo.substring(1);
        }
        return pathInfo.substring(1, secondSlash);
    }

    public static String getStringParameter(HttpServletRequest request, String name) {
        return request.getParameter(name);
    }

    public static String getStringParameter(HttpServletRequest request, String name, Predicate<String> predicate) {
        String s = request.getParameter(name);
        if (predicate.test(s)) {
            return s;
        }
        throw new CmisInvalidArgumentException("invalid parameter '" + name + "'");
    }

    public static String getStringParameter(HttpServletRequest request, String name, String defaultValue) {
        String s = request.getParameter(name);
        return s == null ? defaultValue : s;
    }

    public static String getStringParameter(HttpServletRequest request, String name,
                                            Function<String, String> transformer) {
        return transformer.apply(getStringParameter(request, name));
    }

    public static boolean getBooleanParameter(HttpServletRequest request, String name, boolean def) {
        String value = getStringParameter(request, name);
        if (value == null || value.isEmpty()) {
            return def;
        }

        return Boolean.parseBoolean(value);
    }

    public static Boolean getBooleanParameter(HttpServletRequest request, String name) {
        String value = getStringParameter(request, name);
        if (value == null || value.isEmpty()) {
            return null;
        }

        return Boolean.valueOf(value);
    }

    public static BigInteger getBigIntegerParameter(HttpServletRequest request, String name, long def) {
        BigInteger result = getBigIntegerParameter(request, name);
        if (result == null) {
            return BigInteger.valueOf(def);
        }

        return result;
    }

    public static BigInteger getBigIntegerParameter(HttpServletRequest request, String name) {
        String value = getStringParameter(request, name);
        if (value == null || value.isEmpty()) {
            return null;
        }

        try {
            return new BigInteger(value);
        } catch (NumberFormatException e) {
            throw new CmisInvalidArgumentException("invalid parameter '" + name + "'", e);
        }
    }

    public static BigInteger getBigIntegerParameter(
            HttpServletRequest request, String name, Function<BigInteger, BigInteger> transformer) {
        return transformer.apply(getBigIntegerParameter(request, name));
    }

    public static String encodeContentDisposition(String disposition, String filename) {
        if (disposition == null) {
            disposition = "attachment";
        }
        return disposition + encodeRFC2231("filename", filename);
    }

    private static String encodeRFC2231(String key, String value) {
        StringBuilder buf = new StringBuilder(32);
        boolean encoded = encodeRFC2231value(value, buf);
        if (encoded) {
            return "; " + key + "*=" + buf;
        } else {
            return "; " + key + "=" + value;
        }
    }

    private static boolean encodeRFC2231value(String value, StringBuilder buf) {
        String charset = StandardCharsets.UTF_8.name();
        buf.append(charset);
        buf.append("''"); // no language
        byte[] bytes = value.getBytes(StandardCharsets.UTF_8);

        boolean encoded = false;
        for (byte aByte : bytes) {
            int ch = aByte & 0xff;
            if (ch <= 32 || ch >= 127 || RFC2231_SPECIALS.indexOf(ch) != -1) {
                buf.append('%');
                buf.append(HEX_DIGITS[ch >> 4]);
                buf.append(HEX_DIGITS[ch & 0xf]);
                encoded = true;
            } else {
                buf.append((char) ch);
            }
        }
        return encoded;
    }
}
