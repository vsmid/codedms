package hr.codenamecode.codedms.data.objects;

import hr.codenamecode.codedms.data.extensions.ExtensionData;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.InputStream;
import java.math.BigInteger;

@EqualsAndHashCode(callSuper = true)
@Data
public class ContentStream extends ExtensionData {
    private String filename;
    private BigInteger length;
    private String mimetype;
    private transient InputStream stream;
}
