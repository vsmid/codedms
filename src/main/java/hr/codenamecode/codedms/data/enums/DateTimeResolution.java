package hr.codenamecode.codedms.data.enums;

public enum DateTimeResolution {
    YEAR("year"),
    DATE("date"),
    TIME("time");
    private final String value;

    DateTimeResolution(String v) {
        value = v;
    }

    public static DateTimeResolution fromValue(String v) {
        for (DateTimeResolution c : DateTimeResolution.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

    public String value() {
        return value;
    }
}
