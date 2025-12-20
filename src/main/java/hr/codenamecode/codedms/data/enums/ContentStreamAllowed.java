package hr.codenamecode.codedms.data.enums;

public enum ContentStreamAllowed {
    NOTALLOWED("notallowed"),
    ALLOWED("allowed"),
    REQUIRED("required");
    private final String value;

    ContentStreamAllowed(String v) {
        value = v;
    }

    public static ContentStreamAllowed fromValue(String v) {
        for (ContentStreamAllowed c : ContentStreamAllowed.values()) {
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
