package hr.codenamecode.codedms.http.json.serializers;

import hr.codenamecode.codedms.data.repositoryinfo.DocumentTypeDefinition;
import hr.codenamecode.codedms.data.repositoryinfo.TypeDefinition;
import jakarta.inject.Inject;
import jakarta.inject.Provider;
import jakarta.json.bind.serializer.JsonbSerializer;
import jakarta.json.bind.serializer.SerializationContext;
import jakarta.json.stream.JsonGenerator;
import jakarta.servlet.http.HttpServletRequest;

import java.util.function.Supplier;

public class TypeDefinitionSerializer implements JsonbSerializer<TypeDefinition> {

    private final Supplier<Boolean> includePropertyDefinitions;

    @Inject
    public TypeDefinitionSerializer(Provider<HttpServletRequest> request) {
        this.includePropertyDefinitions = () -> request != null && Boolean.parseBoolean(request.get().getParameter(
                "includePropertyDefinitions"));
    }

    public TypeDefinitionSerializer(boolean includePropertyDefinitions) {
        this.includePropertyDefinitions = () -> includePropertyDefinitions;
    }

    @Override
    public void serialize(TypeDefinition obj, JsonGenerator gen, SerializationContext ctx) {
        gen.writeStartObject();

        gen.write("id", obj.getId());
        gen.write("baseId", obj.getBaseId().value());
        gen.write("controllableACL", obj.isControllableACL());
        gen.write("controllablePolicy", obj.isControllablePolicy());
        gen.write("creatable", obj.isCreatable());
        if (obj.getDescription() != null) {
            gen.write("description", obj.getDescription());
        }
        if (obj.getDisplayName() != null) {
            gen.write("displayName", obj.getDisplayName());
        }
        gen.write("fileable", obj.isFileable());
        gen.write("fulltextIndexed", obj.isFulltextIndexed());
        gen.write("includedInSupertypeQuery", obj.isIncludedInSupertypeQuery());
        gen.write("localName", obj.getLocalName());
        gen.write("localNamespace", obj.getLocalNamespace());
        if (obj.getParentTypeId() != null) {
            gen.write("parentId", obj.getParentTypeId());
        }
        if (obj.getQueryName() != null) {
            gen.write("queryName", obj.getQueryName());
        }
        gen.write("queryable", obj.isQueryable());

        if (obj instanceof DocumentTypeDefinition doc) {
            gen.write("versionable", doc.isVersionable());
            gen.write("contentStreamAllowed", doc.getContentStreamAllowed().value());
        }

        ctx.serialize("typeMutability", obj.getTypeMutability(), gen);

        if (includePropertyDefinitions.get()) {
            ctx.serialize("propertyDefinitions", obj.getPropertyDefinitions(), gen);
        }

        gen.writeEnd();
    }
}
