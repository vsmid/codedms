package hr.codenamecode.codedms.data.enums;

public enum CapabilityContentStreamUpdates {
    ANYTIME("anytime"),
    PWCONLY("pwconly"),
    NONE("none");
    private final String value;

    CapabilityContentStreamUpdates(String v) {
        value = v;
    }

    public static CapabilityContentStreamUpdates fromValue(String v) {
        for (CapabilityContentStreamUpdates c : CapabilityContentStreamUpdates.values()) {
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
