package hr.codenamecode.codedms.data.objects;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.OffsetDateTime;
import java.util.LinkedHashMap;
import java.util.List;

public class Properties extends LinkedHashMap<String, PropertyData<?>> {

    @SuppressWarnings("unchecked")
    public <T> T getValue(String id) {
        List<?> value = getValues(id);
        return value.isEmpty() ? null : (T) value.getFirst();
    }

    @SuppressWarnings("unchecked")
    public <T> List<T> getValues(String id) {
        return (List<T>) get(id).getValue();
    }

    @SuppressWarnings("unchecked")
    public <T> PropertyData<T> setValue(String id, T... values) {
        if (!containsKey(id)) {
            return null;
        }

        get(id).getValue().clear();

        if (values != null) {
            for (T value : values) {
                switch (get(id).getPropertyDefinition().getPropertyType()) {
                    case STRING -> ((StringPropertyData) get(id)).getValue().add((String) value);
                    case ID -> ((IdPropertyData) get(id)).getValue().add((String) value);
                    case HTML -> ((HtmlPropertyData) get(id)).getValue().add((String) value);
                    case URI -> ((UriPropertyData) get(id)).getValue().add((String) value);
                    case BOOLEAN -> ((BooleanPropertyData) get(id)).getValue().add((Boolean) value);
                    case INTEGER -> ((IntegerPropertyData) get(id)).getValue().add((BigInteger) value);
                    case DECIMAL -> ((DecimalPropertyData) get(id)).getValue().add((BigDecimal) value);
                    case DATETIME -> ((DateTimePropertyData) get(id)).getValue().add((OffsetDateTime) value);
                }
            }
        }

        return (PropertyData<T>) get(id);
    }
}
