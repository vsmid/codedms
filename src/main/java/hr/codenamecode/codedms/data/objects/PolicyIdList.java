package hr.codenamecode.codedms.data.objects;

import hr.codenamecode.codedms.data.extensions.ExtensionData;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class PolicyIdList extends ExtensionData {
    private List<String> ids;
}
