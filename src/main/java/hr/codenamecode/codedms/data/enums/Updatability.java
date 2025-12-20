package hr.codenamecode.codedms.data.enums;

public enum Updatability {
    READONLY("readonly"),
    READWRITE("readwrite"),
    WHENCHECKEDOUT("whencheckedout"),
    ONCREATE("oncreate");
    private final String value;

    Updatability(String v) {
        value = v;
    }

    public static Updatability fromValue(String v) {
        for (Updatability c : Updatability.values()) {
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
