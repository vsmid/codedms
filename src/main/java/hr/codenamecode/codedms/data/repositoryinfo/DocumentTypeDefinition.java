package hr.codenamecode.codedms.data.repositoryinfo;

import hr.codenamecode.codedms.data.enums.ContentStreamAllowed;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true) @Data
public class DocumentTypeDefinition extends TypeDefinition {
    private boolean versionable;
    private ContentStreamAllowed contentStreamAllowed;
}
