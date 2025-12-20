package hr.codenamecode.codedms.data.repositoryinfo;

import hr.codenamecode.codedms.data.extensions.ExtensionData;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PermissionDefinition extends ExtensionData {
    private String permission;
    private String description;
}