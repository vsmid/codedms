package hr.codenamecode.codedms.http.json.adapters;

import hr.codenamecode.codedms.data.enums.Updatability;

public class UpdatabilityAdapter extends GenericEnumAdapter<Updatability> {
    public UpdatabilityAdapter() {
        super(Updatability.class);
    }
}
