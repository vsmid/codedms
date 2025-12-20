package hr.codenamecode.codedms.http.json.adapters;

import hr.codenamecode.codedms.data.enums.CmisVersion;

public class CmisVersionAdapter extends GenericEnumAdapter<CmisVersion> {
    public CmisVersionAdapter() {
        super(CmisVersion.class);
    }
}
