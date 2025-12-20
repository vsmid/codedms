package hr.codenamecode.codedms.data.objects;

import hr.codenamecode.codedms.data.extensions.ExtensionData;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ObjectParentData extends ExtensionData {
    private ObjectData object;
    private String relativePathSegment;
}
