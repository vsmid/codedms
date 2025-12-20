package hr.codenamecode.codedms.data.enums;

public enum CapabilityJoin {
    NONE("none"),
    INNERONLY("inneronly"),
    INNERANDOUTER("innerandouter");
    private final String value;

    CapabilityJoin(String v) {
        value = v;
    }

    public static CapabilityJoin fromValue(String v) {
        for (CapabilityJoin c : CapabilityJoin.values()) {
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
