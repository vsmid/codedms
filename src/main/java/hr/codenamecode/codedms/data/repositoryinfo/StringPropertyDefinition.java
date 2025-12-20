
package hr.codenamecode.codedms.data.repositoryinfo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigInteger;

@EqualsAndHashCode(callSuper = true) @Data
public class StringPropertyDefinition extends PropertyDefinition<String> {
    private BigInteger maxLength;
}
