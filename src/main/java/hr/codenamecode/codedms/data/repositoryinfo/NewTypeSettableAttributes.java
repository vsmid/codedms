package hr.codenamecode.codedms.data.repositoryinfo;

import hr.codenamecode.codedms.data.extensions.ExtensionData;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class NewTypeSettableAttributes extends ExtensionData {
    private Boolean id;
    private Boolean localName;
    private Boolean localNamespace;
    private Boolean displayName;
    private Boolean queryName;
    private Boolean description;
    private Boolean creatable;
    private Boolean fileable;
    private Boolean queryable;
    private Boolean fulltextIndexed;
    private Boolean includedInSupertypeQuery;
    private Boolean controllablePolicy;
    private Boolean controllableACL;
}