
package hr.codenamecode.codedms.data.repositoryinfo;

import hr.codenamecode.codedms.data.enums.DateTimeResolution;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.OffsetDateTime;

@EqualsAndHashCode(callSuper = true) @Data
public class DateTimePropertyDefinition extends PropertyDefinition<OffsetDateTime> {
    private DateTimeResolution dateTimeResolution;
}
