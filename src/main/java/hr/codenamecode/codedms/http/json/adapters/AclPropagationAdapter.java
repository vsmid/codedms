package hr.codenamecode.codedms.http.json.adapters;

import hr.codenamecode.codedms.data.enums.AclPropagation;

public class AclPropagationAdapter extends GenericEnumAdapter<AclPropagation> {
    public AclPropagationAdapter() {
        super(AclPropagation.class);
    }
}
