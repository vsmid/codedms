package hr.codenamecode.codedms.data.enums;

public enum CapabilityChanges {
    NONE("none"),
    OBJECTIDSONLY("objectidsonly"),
    PROPERTIES("properties"),
    ALL("all");
    private final String value;

    CapabilityChanges(String v) {
        value = v;
    }

    public static CapabilityChanges fromValue(String v) {
        for (CapabilityChanges c : CapabilityChanges.values()) {
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
