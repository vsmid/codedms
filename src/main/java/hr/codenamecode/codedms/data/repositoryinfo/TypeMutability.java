package hr.codenamecode.codedms.data.repositoryinfo;

import hr.codenamecode.codedms.data.extensions.ExtensionData;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class TypeMutability extends ExtensionData {
    private boolean create;
    private boolean delete;
    private boolean update;
}