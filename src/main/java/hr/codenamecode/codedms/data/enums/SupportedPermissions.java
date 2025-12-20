package hr.codenamecode.codedms.data.enums;

public enum SupportedPermissions {
    BASIC("basic"),
    REPOSITORY("repository"),
    BOTH("both");
    private final String value;

    SupportedPermissions(String v) {
        value = v;
    }

    public static SupportedPermissions fromValue(String v) {
        for (SupportedPermissions c : SupportedPermissions.values()) {
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
