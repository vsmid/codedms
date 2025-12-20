package hr.codenamecode.codedms.data.enums;

import hr.codenamecode.codedms.data.objects.*;

public enum PropertyType {
    BOOLEAN("boolean", BooleanPropertyData.class),
    ID("id", IdPropertyData.class),
    INTEGER("integer", IntegerPropertyData.class),
    DATETIME("datetime", DateTimePropertyData.class),
    DECIMAL("decimal", DecimalPropertyData.class),
    HTML("html", HtmlPropertyData.class),
    STRING("string", StringPropertyData.class),
    URI("uri", UriPropertyData.class);

    private final String value;
    private final Class<? extends PropertyData<?>> dataClass;

    PropertyType(String v, Class<? extends PropertyData<?>> dataClass) {
        this.value = v;
        this.dataClass = dataClass;
    }

    public Class<? extends PropertyData<?>> getDataClass() {
        return dataClass;
    }

    public static PropertyType fromValue(String v) {
        for (PropertyType c : PropertyType.values()) {
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
