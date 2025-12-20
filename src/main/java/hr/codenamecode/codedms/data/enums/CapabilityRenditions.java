package hr.codenamecode.codedms.data.enums;

public enum CapabilityRenditions {
    NONE("none"),
    READ("read");

    private final String value;

    CapabilityRenditions(String v) {
        value = v;
    }

    public static CapabilityRenditions fromValue(String v) {
        for (CapabilityRenditions c : CapabilityRenditions.values()) {
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
