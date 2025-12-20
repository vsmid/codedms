package hr.codenamecode.codedms.data.objects;

import hr.codenamecode.codedms.data.extensions.ExtensionData;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class Ace extends ExtensionData {
    private List<String> permissions;
    private AcePrincipal principal;
    private boolean isDirect = true;
}
