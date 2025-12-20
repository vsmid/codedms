package hr.codenamecode.codedms.data.objects;

import hr.codenamecode.codedms.data.extensions.ExtensionData;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class ObjectInFolderList extends ExtensionData {
    private List<ObjectInFolderData> objects = new ArrayList<>(0);
    private Boolean hasMoreItems = Boolean.FALSE;
    private BigInteger numItems;
}
