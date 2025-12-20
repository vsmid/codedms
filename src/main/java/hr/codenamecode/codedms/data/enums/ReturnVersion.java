package hr.codenamecode.codedms.data.enums;

public enum ReturnVersion {
    THIS("this"),
    LATEST("latest"),
    LASTESTMAJOR("latestmajor");
    private final String value;

    ReturnVersion(String v) {
        value = v;
    }

    public static ReturnVersion fromValue(String v) {
        for (ReturnVersion c : ReturnVersion.values()) {
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
