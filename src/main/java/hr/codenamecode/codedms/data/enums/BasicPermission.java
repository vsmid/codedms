package hr.codenamecode.codedms.data.enums;

public enum BasicPermission {

    READ("cmis:read"), WRITE("cmis:write"), ALL("cmis:all");

    private final String value;

    BasicPermission(String value) {
        this.value = value;
    }

    public static BasicPermission fromValue(String v) {
        for (BasicPermission c : BasicPermission.values()) {
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
