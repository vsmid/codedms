package hr.codenamecode.codedms.data.enums;

public enum DateTimeFormat {
    SIMPLE("simple"),
    EXTENDED("extended");
    private final String value;

    DateTimeFormat(String v) {
        value = v;
    }

    public static DateTimeFormat fromValue(String v) {
        for (DateTimeFormat c : DateTimeFormat.values()) {
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
