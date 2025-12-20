package hr.codenamecode.codedms.data.enums;

public enum RelationshipDirection {
    SOURCE("source"),
    TARGET("target"),
    EITHER("either");
    private final String value;

    RelationshipDirection(String v) {
        value = v;
    }

    public static RelationshipDirection fromValue(String v) {
        for (RelationshipDirection c : RelationshipDirection.values()) {
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
