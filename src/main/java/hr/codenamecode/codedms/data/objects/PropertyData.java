package hr.codenamecode.codedms.data.objects;

import hr.codenamecode.codedms.data.extensions.ExtensionData;
import hr.codenamecode.codedms.data.repositoryinfo.PropertyDefinition;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class PropertyData<T> extends ExtensionData {
    private String id;
    private String displayName;
    private String localName;
    private String queryName;
    private PropertyDefinition<T> propertyDefinition;
    private List<T> value = new ArrayList<>();

    public PropertyData(String id, T[] values){
        setId(id);
        Collections.addAll(this.value, values);
    }
}