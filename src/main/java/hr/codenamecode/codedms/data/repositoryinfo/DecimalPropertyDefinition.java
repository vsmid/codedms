package hr.codenamecode.codedms.data.repositoryinfo;

import hr.codenamecode.codedms.data.enums.DecimalPrecision;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true) @Data
public class DecimalPropertyDefinition extends PropertyDefinition<BigDecimal> {
    private BigDecimal minValue;
    private BigDecimal maxValue;
    private DecimalPrecision precision;
}
