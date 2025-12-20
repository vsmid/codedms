package hr.codenamecode.codedms.data.repositoryinfo;

import hr.codenamecode.codedms.data.enums.PropertyType;
import hr.codenamecode.codedms.data.extensions.ExtensionData;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.EnumSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
public class CreatablePropertyTypes extends ExtensionData {
    private Set<PropertyType> canCreate = EnumSet.noneOf(PropertyType.class);
}
