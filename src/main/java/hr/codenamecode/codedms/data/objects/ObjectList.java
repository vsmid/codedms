package hr.codenamecode.codedms.data.objects;

import hr.codenamecode.codedms.data.extensions.ExtensionData;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigInteger;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class ObjectList extends ExtensionData {
    private List<ObjectData> objects;
    private Boolean hasMoreItems = Boolean.FALSE;
    private BigInteger numItems;
}
