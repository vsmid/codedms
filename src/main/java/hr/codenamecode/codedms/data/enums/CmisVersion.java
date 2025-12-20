package hr.codenamecode.codedms.data.enums;

public enum CmisVersion {
    CMIS_1_0("1.0"),
    CMIS_1_1("1.1");
    private final String value;

    CmisVersion(String v) {
        value = v;
    }

    public static CmisVersion fromValue(String v) {
        for (CmisVersion c : CmisVersion.values()) {
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
