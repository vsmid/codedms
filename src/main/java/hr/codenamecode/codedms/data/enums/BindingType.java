package hr.codenamecode.codedms.data.enums;

public enum BindingType {
    WEBSERVICES("webservices"),
    ATOMPUB("atompub"),
    BROWSER("browser"),
    LOCAL("local"),
    CUSTOM("custom");

    private final String value;

    BindingType(String v) {
        value = v;
    }

    public static BindingType fromValue(String v) {
        for (BindingType c : BindingType.values()) {
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
