package hr.codenamecode.codedms.data.enums;

public enum UnfileObject {
    UNFILE("unfile"),
    DELETESINGLEFILED("deletesinglefiled"),
    DELETE("delete");
    private final String value;

    UnfileObject(String v) {
        value = v;
    }

    public static UnfileObject fromValue(String v) {
        for (UnfileObject c : UnfileObject.values()) {
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
