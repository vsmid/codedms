package hr.codenamecode.codedms.data.enums;

public enum ChangeType {
    CREATED("created"),
    UPDATED("updated"),
    DELETED("deleted"),
    SECURITY("security");
    private final String value;

    ChangeType(String v) {
        value = v;
    }

    public static ChangeType fromValue(String v) {
        for (ChangeType c : ChangeType.values()) {
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
