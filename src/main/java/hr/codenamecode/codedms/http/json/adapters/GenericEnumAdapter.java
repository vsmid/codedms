package hr.codenamecode.codedms.http.json.adapters;

import jakarta.json.bind.adapter.JsonbAdapter;

import java.lang.reflect.Method;

public class GenericEnumAdapter<E extends Enum<E>> implements JsonbAdapter<E, String> {

    private final Class<E> enumClass;
    private final Method getValueMethod;

    public GenericEnumAdapter(Class<E> enumClass) {
        this.enumClass = enumClass;
        try {
            this.getValueMethod = enumClass.getMethod("value");
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("Enum " + enumClass.getName() + " must have a value() method returning" +
                    " String", e);
        }
    }

    @Override
    public String adaptToJson(E obj) throws Exception {
        if (obj == null) {
            return null;
        }
        return (String) getValueMethod.invoke(obj);
    }

    @Override
    public E adaptFromJson(String value) throws Exception {
        if (value == null) {
            return null;
        }
        for (E constant : enumClass.getEnumConstants()) {
            String enumValue = (String) getValueMethod.invoke(constant);
            if (enumValue.equalsIgnoreCase(value)) {
                return constant;
            }
        }
        throw new IllegalArgumentException();
    }
}