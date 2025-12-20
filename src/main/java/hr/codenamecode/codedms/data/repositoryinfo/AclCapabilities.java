package hr.codenamecode.codedms.data.repositoryinfo;

import hr.codenamecode.codedms.data.enums.AclPropagation;
import hr.codenamecode.codedms.data.enums.SupportedPermissions;
import hr.codenamecode.codedms.data.extensions.ExtensionData;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class AclCapabilities extends ExtensionData {
    private SupportedPermissions supportedPermissions;
    private AclPropagation aclPropagation;
    private List<PermissionMapping> permissionMapping = new ArrayList<>(0);
    private List<PermissionDefinition> permissions = new ArrayList<>(0);
}