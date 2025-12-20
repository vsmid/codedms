package hr.codenamecode.codedms.http.json.adapters;

import hr.codenamecode.codedms.data.enums.PropertyType;

public class PropertyTypeAdapter extends GenericEnumAdapter<PropertyType> {
    public PropertyTypeAdapter() {
        super(PropertyType.class);
    }
}
