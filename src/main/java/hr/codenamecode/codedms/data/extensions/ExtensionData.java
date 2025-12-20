package hr.codenamecode.codedms.data.extensions;

import jakarta.json.bind.annotation.JsonbNillable;
import lombok.Data;

import java.util.List;

@Data
public abstract class ExtensionData {
    @JsonbNillable(false)
    private List<CmisExtensionElement> extensions;
}