package hr.codenamecode.codedms.http.json.adapters;

import hr.codenamecode.codedms.data.enums.Cardinality;

public class CardinalityAdapter extends GenericEnumAdapter<Cardinality> {
    public CardinalityAdapter() {
        super(Cardinality.class);
    }
}
