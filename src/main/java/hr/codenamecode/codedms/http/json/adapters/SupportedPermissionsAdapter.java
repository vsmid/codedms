package hr.codenamecode.codedms.http.json.adapters;

import hr.codenamecode.codedms.data.enums.SupportedPermissions;

public class SupportedPermissionsAdapter extends GenericEnumAdapter<SupportedPermissions> {
    public SupportedPermissionsAdapter() {
        super(SupportedPermissions.class);
    }
}
