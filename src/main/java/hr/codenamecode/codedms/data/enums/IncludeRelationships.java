package hr.codenamecode.codedms.data.enums;

public enum IncludeRelationships {
    NONE("none"),
    SOURCE("source"),
    TARGET("target"),
    BOTH("both");
    private final String value;

    IncludeRelationships(String v) {
        value = v;
    }

    public static IncludeRelationships fromValue(String v) {
        for (IncludeRelationships c : IncludeRelationships.values()) {
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
