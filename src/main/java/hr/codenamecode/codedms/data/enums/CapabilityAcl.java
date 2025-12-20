package hr.codenamecode.codedms.data.enums;

public enum CapabilityAcl {
    NONE("none"),
    DISCOVER("discover"),
    MANAGE("manage");
    private final String value;

    CapabilityAcl(String v) {
        value = v;
    }

    public static CapabilityAcl fromValue(String v) {
        for (CapabilityAcl c : CapabilityAcl.values()) {
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
