package hr.codenamecode.codedms.data.repositoryinfo;

import hr.codenamecode.codedms.data.enums.Cardinality;
import hr.codenamecode.codedms.data.enums.PropertyType;
import hr.codenamecode.codedms.data.enums.Updatability;
import hr.codenamecode.codedms.data.extensions.ExtensionData;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public abstract class PropertyDefinition<T> extends ExtensionData {
    private Cardinality cardinality;
    private PropertyType propertyType;
    private String description;
    private String displayName;
    private String id;
    private boolean inherited;
    private String localName;
    private String localNamespace;
    private boolean orderable;
    private String queryName;
    private boolean queryable;
    private boolean required;
    private Updatability updatability;
    private List<T> defaultValue = new ArrayList<>(0);
    private List<Choice<T>> choices;
    private Boolean openChoice;
}
