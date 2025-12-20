package hr.codenamecode.codedms.data.enums;

public enum ExtensionLevel {
    OBJECT("object"),
    PROPERTIES("properties"),
    ALLOWABLE_ACTIONS("allowableActions"),
    ACL("acl"),
    POLICIES("policies"),
    CHANGE_EVENT("changeEvent");
    private final String value;

    ExtensionLevel(String v) {
        value = v;
    }

    public static ExtensionLevel fromValue(String v) {
        for (ExtensionLevel c : ExtensionLevel.values()) {
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
