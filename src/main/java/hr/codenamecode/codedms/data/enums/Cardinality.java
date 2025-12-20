package hr.codenamecode.codedms.data.enums;

public enum Cardinality {
    SINGLE("single"),
    MULTI("multi");
    private final String value;

    Cardinality(String v) {
        value = v;
    }

    public static Cardinality fromValue(String v) {
        for (Cardinality c : Cardinality.values()) {
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
