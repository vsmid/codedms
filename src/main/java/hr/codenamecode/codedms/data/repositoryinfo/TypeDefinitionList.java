package hr.codenamecode.codedms.data.repositoryinfo;

import hr.codenamecode.codedms.data.extensions.ExtensionData;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigInteger;
import java.util.List;

@EqualsAndHashCode(callSuper = true) @Data
public class TypeDefinitionList extends ExtensionData {
    private List<TypeDefinition> types;
    private Boolean hasMoreItems;
    private BigInteger numItems;
}