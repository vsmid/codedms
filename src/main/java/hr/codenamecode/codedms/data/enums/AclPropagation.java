package hr.codenamecode.codedms.data.enums;

public enum AclPropagation {
    REPOSITORYDETERMINED("repositorydetermined"),
    OBJECTONLY("objectonly"),
    PROPAGATE("propagate");
    private final String value;

    AclPropagation(String v) {
        value = v;
    }

    public static AclPropagation fromValue(String v) {
        for (AclPropagation c : AclPropagation.values()) {
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
