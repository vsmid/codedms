package hr.codenamecode.codedms.data.enums;

public enum CapabilityQuery {
    NONE("none"),
    METADATAONLY("metadataonly"),
    FULLTEXTONLY("fulltextonly"),
    BOTHSEPARATE("bothseparate"),
    BOTHCOMBINED("bothcombined");
    private final String value;

    CapabilityQuery(String v) {
        value = v;
    }

    public static CapabilityQuery fromValue(String v) {
        for (CapabilityQuery c : CapabilityQuery.values()) {
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
