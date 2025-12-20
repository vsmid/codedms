package hr.codenamecode.codedms.data.objects;

import hr.codenamecode.codedms.data.enums.BaseTypeId;
import hr.codenamecode.codedms.data.extensions.ExtensionData;
import hr.codenamecode.codedms.data.repositoryinfo.PropertyIds;
import hr.codenamecode.codedms.http.json.serializers.ObjectDataSerializer;
import jakarta.json.bind.annotation.JsonbTypeSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@JsonbTypeSerializer(ObjectDataSerializer.class)
@EqualsAndHashCode(callSuper = true)
@Data
public class ObjectData extends ExtensionData {

    private final Properties properties = new Properties();
    private ChangeEventInfo changeEventInfo;
    private List<ObjectData> relationships;
    private List<RenditionData> renditions;
    private PolicyIdList policyIds;
    private Map<String, Boolean> allowableActions;
    private Acl acl;
    private Boolean exactACL;

    public String getId() {
        if (properties.containsKey(PropertyIds.OBJECT_ID)) {
            PropertyData<?> propertyData = properties.get(PropertyIds.OBJECT_ID);
            if (propertyData instanceof StringPropertyData spd) {
                return spd.getValue().getFirst();
            }
        }
        return null;
    }

    public BaseTypeId getBaseTypeId() {
        if (properties.containsKey(PropertyIds.BASE_TYPE_ID)) {
            PropertyData<?> propertyData = properties.get(PropertyIds.BASE_TYPE_ID);
            if (propertyData instanceof StringPropertyData spd) {
                return BaseTypeId.fromValue(spd.getValue().getFirst());
            }
        }
        return null;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public void fillProperties(Map<String, PropertyData<?>> properties) {
        if (properties == null) {
            return;
        }

        for (Map.Entry<String, PropertyData<?>> entry : properties.entrySet()) {
            PropertyData<?> target = getProperties().get(entry.getKey());
            if (target != null) {
                List<?> targetValues = target.getValue();
                targetValues.clear();
                List<?> sourceValues = entry.getValue().getValue();
                if (sourceValues != null) {
                    targetValues.addAll((Collection) sourceValues);
                }
            }
        }
    }
}
