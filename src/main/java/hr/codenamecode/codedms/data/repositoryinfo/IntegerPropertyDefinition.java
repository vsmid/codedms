package hr.codenamecode.codedms.data.repositoryinfo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigInteger;

@EqualsAndHashCode(callSuper = true) @Data
public class IntegerPropertyDefinition extends PropertyDefinition<BigInteger> {
    private BigInteger minValue;
    private BigInteger maxValue;
}
