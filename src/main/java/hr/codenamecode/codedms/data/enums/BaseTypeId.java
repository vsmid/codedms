package hr.codenamecode.codedms.data.enums;

public enum BaseTypeId {

    CMIS_DOCUMENT("cmis:document"),

    CMIS_FOLDER("cmis:folder"),

    CMIS_RELATIONSHIP("cmis:relationship"),

    CMIS_POLICY("cmis:policy"),

    CMIS_ITEM("cmis:item"),

    CMIS_SECONDARY("cmis:secondary");

    private final String value;

    BaseTypeId(String v) {
        value = v;
    }

    public static BaseTypeId fromValue(String v) {
        for (BaseTypeId c : BaseTypeId.values()) {
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
