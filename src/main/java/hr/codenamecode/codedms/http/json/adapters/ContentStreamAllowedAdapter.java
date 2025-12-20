package hr.codenamecode.codedms.http.json.adapters;

import hr.codenamecode.codedms.data.enums.ContentStreamAllowed;

public class ContentStreamAllowedAdapter extends GenericEnumAdapter<ContentStreamAllowed> {
    public ContentStreamAllowedAdapter() {
        super(ContentStreamAllowed.class);
    }
}
