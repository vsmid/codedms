package hr.codenamecode.codedms.data.repositoryinfo;

import hr.codenamecode.codedms.data.enums.BaseTypeId;
import hr.codenamecode.codedms.data.extensions.ExtensionData;
import hr.codenamecode.codedms.http.json.serializers.TypeDefinitionSerializer;
import jakarta.json.bind.annotation.JsonbTypeSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
@JsonbTypeSerializer(TypeDefinitionSerializer.class)
public abstract class TypeDefinition extends ExtensionData {
    private BaseTypeId baseId;
    private boolean controllableACL;
    private boolean controllablePolicy;
    private boolean creatable;
    private String description;
    private String displayName;
    private boolean fileable;
    private boolean inherited;
    private boolean fulltextIndexed;
    private String id;
    private boolean includedInSupertypeQuery;
    private String localName;
    private String localNamespace;
    private String parentTypeId;
    private Map<String, PropertyDefinition<?>> propertyDefinitions;
    private String queryName;
    private boolean queryable;
    private TypeMutability typeMutability;
}