package hr.codenamecode.codedms.data.extensions;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
public class ExtensionFeature extends ExtensionData {
    private String id;
    private String url;
    private String commonName;
    private String versionLabel;
    private String description;
    private Map<String, String> featureData = new HashMap<>(2);
}