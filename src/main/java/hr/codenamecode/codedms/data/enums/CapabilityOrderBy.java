package hr.codenamecode.codedms.data.enums;

public enum CapabilityOrderBy {
    NONE("none"),
    COMMON("common"),
    CUSTOM("custom");
    private final String value;

    CapabilityOrderBy(String v) {
        value = v;
    }

    public static CapabilityOrderBy fromValue(String v) {
        for (CapabilityOrderBy c : CapabilityOrderBy.values()) {
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
