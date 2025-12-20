package hr.codenamecode.codedms.utils;

import hr.codenamecode.codedms.data.enums.*;
import hr.codenamecode.codedms.data.extensions.CmisExtensionElement;
import hr.codenamecode.codedms.data.extensions.ExtensionData;
import hr.codenamecode.codedms.data.repositoryinfo.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TypeDefinitionFactory {

    public static DocumentTypeDefinition createDocumentTypeDefinition(String parentId) {
        DocumentTypeDefinition documentType = new DocumentTypeDefinition();
        documentType.setParentTypeId(parentId);
        documentType.setControllableACL(true);
        documentType.setControllablePolicy(true);
        documentType.setCreatable(true);
        documentType.setDescription("Document");
        documentType.setDisplayName("Document");
        documentType.setFileable(true);
        documentType.setFulltextIndexed(true);
        documentType.setIncludedInSupertypeQuery(true);
        documentType.setLocalName("Document");
        documentType.setLocalNamespace("https://codenamecode.hr/codedms");
        documentType.setQueryable(true);
        documentType.setQueryName(BaseTypeId.CMIS_DOCUMENT.value());
        documentType.setId(BaseTypeId.CMIS_DOCUMENT.value());
        documentType.setBaseId(BaseTypeId.CMIS_DOCUMENT);
        documentType.setVersionable(false);
        documentType.setContentStreamAllowed(ContentStreamAllowed.ALLOWED);
        documentType.setTypeMutability(new TypeMutability());

        documentType.setPropertyDefinitions(new HashMap<>());

        addBasePropertyDefinitions(documentType, parentId != null);
        addDocumentPropertyDefinitions(documentType, parentId != null);

        ((IdPropertyDefinition) documentType.getPropertyDefinitions().get(PropertyIds.BASE_TYPE_ID)).getDefaultValue().add(BaseTypeId.CMIS_DOCUMENT.value());

        return documentType;
    }

    public static FolderTypeDefinition createFolderTypeDefinition(String parentId) {
        FolderTypeDefinition folderType = new FolderTypeDefinition();
        folderType.setParentTypeId(parentId);
        folderType.setControllableACL(true);
        folderType.setControllablePolicy(true);
        folderType.setCreatable(true);
        folderType.setDescription("Folder");
        folderType.setDisplayName("Folder");
        folderType.setFileable(true);
        folderType.setFulltextIndexed(true);
        folderType.setIncludedInSupertypeQuery(true);
        folderType.setLocalName("Folder");
        folderType.setLocalNamespace("https://codenamecode.hr/codedms");
        folderType.setQueryable(true);
        folderType.setQueryName(BaseTypeId.CMIS_FOLDER.value());
        folderType.setId(BaseTypeId.CMIS_FOLDER.value());
        folderType.setBaseId(BaseTypeId.CMIS_FOLDER);
        folderType.setTypeMutability(new TypeMutability());

        folderType.setPropertyDefinitions(new HashMap<>());

        addBasePropertyDefinitions(folderType, parentId != null);
        addFolderPropertyDefinitions(folderType, parentId != null);

        ((IdPropertyDefinition) folderType.getPropertyDefinitions().get(PropertyIds.BASE_TYPE_ID)).getDefaultValue().add(BaseTypeId.CMIS_FOLDER.value());

        return folderType;
    }

    private static void addProperty(TypeDefinition type, String id, String displayName, String description,
                                    PropertyType datatype, Cardinality cardinality, Updatability updateability,
                                    boolean inherited, boolean required, boolean queryable, boolean orderable) {
        PropertyDefinition<?> prop = createPropertyDefinition(id, displayName, description, datatype, cardinality,
                updateability, inherited, required, queryable, orderable);
        type.getPropertyDefinitions().put(prop.getId(), prop);
    }

    private static void addBasePropertyDefinitions(TypeDefinition type, boolean inherited) {
        addProperty(type, PropertyIds.NAME, "Name", "Name", PropertyType.STRING, Cardinality.SINGLE,
                Updatability.READWRITE, inherited, true, true, true);
        addProperty(type, PropertyIds.DESCRIPTION, "Description", "Description", PropertyType.STRING,
                Cardinality.SINGLE, Updatability.READWRITE, inherited, false, false, false);
        addProperty(type, PropertyIds.OBJECT_ID, "Object Id", "Object Id", PropertyType.ID, Cardinality.SINGLE,
                Updatability.READONLY, inherited, false, true, false);
        addProperty(type, PropertyIds.BASE_TYPE_ID, "Base Type Id", "Base Type Id", PropertyType.ID,
                Cardinality.SINGLE, Updatability.READONLY, inherited, false, true, false);
        addProperty(type, PropertyIds.OBJECT_TYPE_ID, "Object Type Id", "Object Type Id", PropertyType.ID,
                Cardinality.SINGLE, Updatability.ONCREATE, inherited, true, true, false);
        addProperty(type, PropertyIds.SECONDARY_OBJECT_TYPE_IDS, "Secondary Type Ids", "Secondary Type Ids",
                PropertyType.ID, Cardinality.MULTI, Updatability.READONLY, inherited, false, true, false);
        addProperty(type, PropertyIds.CREATED_BY, "Created By", "Created By", PropertyType.STRING,
                Cardinality.SINGLE, Updatability.READONLY, inherited, false, true, true);
        addProperty(type, PropertyIds.CREATION_DATE, "Creation Date", "Creation Date", PropertyType.DATETIME,
                Cardinality.SINGLE, Updatability.READONLY, inherited, false, true, true);
        addProperty(type, PropertyIds.LAST_MODIFIED_BY, "Last Modified By", "Last Modified By", PropertyType.STRING,
                Cardinality.SINGLE, Updatability.READONLY, inherited, false, true, true);
        addProperty(type, PropertyIds.LAST_MODIFICATION_DATE, "Last Modification Date", "Last Modification Date",
                PropertyType.DATETIME, Cardinality.SINGLE, Updatability.READONLY, inherited, false, true, true);
        addProperty(type, PropertyIds.CHANGE_TOKEN, "Change Token", "Change Token", PropertyType.STRING,
                Cardinality.SINGLE, Updatability.READONLY, inherited, false, false, false);
    }

    private static void addDocumentPropertyDefinitions(TypeDefinition type, boolean inherited) {
        addProperty(type, PropertyIds.IS_IMMUTABLE, "Is Immutable", "Is Immutable", PropertyType.BOOLEAN,
                Cardinality.SINGLE, Updatability.READONLY, inherited, false, false, false);
        addProperty(type, PropertyIds.IS_LATEST_VERSION, "Is Latest Version", "Is Latest Version",
                PropertyType.BOOLEAN, Cardinality.SINGLE, Updatability.READONLY, inherited, false, false, false);
        addProperty(type, PropertyIds.IS_MAJOR_VERSION, "Is Major Version", "Is Major Version", PropertyType.BOOLEAN,
                Cardinality.SINGLE, Updatability.READONLY, inherited, false, false, false);
        addProperty(type, PropertyIds.IS_LATEST_MAJOR_VERSION, "Is Latest Major Version", "Is Latest Major Version",
                PropertyType.BOOLEAN, Cardinality.SINGLE, Updatability.READONLY, inherited, false, false, false);
        addProperty(type, PropertyIds.IS_PRIVATE_WORKING_COPY, "Is Private Working Copy", "Is Private Working Copy",
                PropertyType.BOOLEAN, Cardinality.SINGLE, Updatability.READONLY, inherited, false, true, false);
        addProperty(type, PropertyIds.VERSION_LABEL, "Version Label", "Version Label", PropertyType.STRING,
                Cardinality.SINGLE, Updatability.READONLY, inherited, false, true, false);
        addProperty(type, PropertyIds.VERSION_SERIES_ID, "Version Series Id", "Version Series Id", PropertyType.ID,
                Cardinality.SINGLE, Updatability.READONLY, inherited, false, true, false);
        addProperty(type, PropertyIds.IS_VERSION_SERIES_CHECKED_OUT, "Is Verison Series Checked Out",
                "Is Verison Series Checked Out", PropertyType.BOOLEAN, Cardinality.SINGLE, Updatability.READONLY,
                inherited, false, true, false);
        addProperty(type, PropertyIds.VERSION_SERIES_CHECKED_OUT_BY, "Version Series Checked Out By",
                "Version Series Checked Out By", PropertyType.STRING, Cardinality.SINGLE, Updatability.READONLY,
                inherited, false, false, false);
        addProperty(type, PropertyIds.VERSION_SERIES_CHECKED_OUT_ID, "Version Series Checked Out Id",
                "Version Series Checked Out Id", PropertyType.ID, Cardinality.SINGLE, Updatability.READONLY,
                inherited, false, false, false);
        addProperty(type, PropertyIds.CHECKIN_COMMENT, "Checkin Comment", "Checkin Comment", PropertyType.STRING,
                Cardinality.SINGLE, Updatability.READONLY, inherited, false, false, false);
        addProperty(type, PropertyIds.CONTENT_STREAM_LENGTH, "Content Stream Length", "Content Stream Length",
                PropertyType.INTEGER, Cardinality.SINGLE, Updatability.READONLY, inherited, false, false, false);
        addProperty(type, PropertyIds.CONTENT_STREAM_MIME_TYPE, "MIME Type", "MIME Type", PropertyType.STRING,
                Cardinality.SINGLE, Updatability.READONLY, inherited, false, false, false);
        addProperty(type, PropertyIds.CONTENT_STREAM_FILE_NAME, "Filename", "Filename", PropertyType.STRING,
                Cardinality.SINGLE, Updatability.READONLY, inherited, false, false, false);
        addProperty(type, PropertyIds.CONTENT_STREAM_ID, "Content Stream Id", "Content Stream Id", PropertyType.ID,
                Cardinality.SINGLE, Updatability.READONLY, inherited, false, false, false);
    }

    private static void addFolderPropertyDefinitions(TypeDefinition type, boolean inherited) {
        addProperty(type, PropertyIds.PARENT_ID, "Parent Id", "Parent Id", PropertyType.ID, Cardinality.SINGLE,
                Updatability.READONLY, inherited, false, false, false);
        addProperty(type, PropertyIds.PATH, "Path", "Path", PropertyType.STRING, Cardinality.SINGLE,
                Updatability.READONLY, inherited, false, false, false);
        addProperty(type, PropertyIds.ALLOWED_CHILD_OBJECT_TYPE_IDS, "Allowed Child Object Type Ids",
                "Allowed Child Object Type Ids", PropertyType.ID, Cardinality.MULTI, Updatability.READONLY,
                inherited, false, false, false);
    }

    public static PropertyDefinition<?> createPropertyDefinition(String id, String displayName, String description,
                                                                 PropertyType datatype, Cardinality cardinality,
                                                                 Updatability updateability, boolean inherited,
                                                                 boolean required, boolean queryable,
                                                                 boolean orderable) {
        if (id == null) {
            throw new IllegalArgumentException("id must be set");
        }
        if (datatype == null) {
            throw new IllegalArgumentException("datatype must be set");
        }
        if (cardinality == null) {
            throw new IllegalArgumentException("cardinality must be set");
        }
        if (updateability == null) {
            throw new IllegalArgumentException("updateability must be set");
        }

        PropertyDefinition<?> result = switch (datatype) {
            case BOOLEAN -> new BooleanPropertyDefinition();
            case DATETIME -> new DateTimePropertyDefinition();
            case DECIMAL -> new DecimalPropertyDefinition();
            case HTML -> new HtmlPropertyDefinition();
            case ID -> new IdPropertyDefinition();
            case INTEGER -> new IntegerPropertyDefinition();
            case STRING -> {
                StringPropertyDefinition pDef = new StringPropertyDefinition();
                pDef.setMaxLength(BigInteger.valueOf(100)); // TODO Externalize as property
                yield pDef;
            }
            case URI -> new UriPropertyDefinition();
        };

        result.setId(id);
        result.setLocalName(id);
        result.setDisplayName(displayName);
        result.setDescription(description);
        result.setCardinality(cardinality);
        result.setUpdatability(updateability);
        result.setInherited(inherited);
        result.setRequired(required);
        result.setQueryable(queryable);
        result.setOrderable(orderable);
        result.setQueryName(id);
        result.setPropertyType(datatype);

        return result;
    }

    public void inheritProperties(TypeDefinition type, Map<String, TypeDefinition> typeCache) {
        String parentId = type.getParentTypeId();
        if (parentId != null) {
            TypeDefinition parent = typeCache.get(parentId);
            if (parent != null) {
                Map<String, PropertyDefinition<?>> propertyDefinitions = type.getPropertyDefinitions();
                for (PropertyDefinition<?> property : parent.getPropertyDefinitions().values()) {
                    propertyDefinitions.computeIfAbsent(property.getId(), k -> {
                        PropertyDefinition<?> copy = copy(property);
                        copy.setInherited(true);
                        return copy;
                    });
                }
                inheritProperties(parent, typeCache);
            }
        }
    }

    public PropertyDefinition<?> copy(PropertyDefinition<?> source) {
        if (source == null) {
            throw new IllegalArgumentException("Source definition must be set");
        }

        if (source.getPropertyType() == null) {
            throw new IllegalArgumentException("Source definition property type must be set");
        }

        PropertyDefinition<?> result = switch (source) {
            case BooleanPropertyDefinition b -> {
                BooleanPropertyDefinition res = new BooleanPropertyDefinition();
                res.setDefaultValue(copyDefaultValue(b));
                res.setChoices(copyChoices(b));
                yield res;
            }
            case DateTimePropertyDefinition dt -> {
                DateTimePropertyDefinition res = new DateTimePropertyDefinition();
                res.setDateTimeResolution(dt.getDateTimeResolution());
                res.setDefaultValue(copyDefaultValue(dt));
                res.setChoices(copyChoices(dt));
                yield res;
            }
            case DecimalPropertyDefinition d -> {
                DecimalPropertyDefinition res = new DecimalPropertyDefinition();
                res.setMinValue(d.getMinValue());
                res.setMaxValue(d.getMaxValue());
                res.setPrecision(d.getPrecision());
                res.setDefaultValue(copyDefaultValue(d));
                res.setChoices(copyChoices(d));
                yield res;
            }
            case HtmlPropertyDefinition h -> {
                HtmlPropertyDefinition res = new HtmlPropertyDefinition();
                res.setDefaultValue(copyDefaultValue(h));
                yield res;
            }
            case IdPropertyDefinition id -> {
                IdPropertyDefinition res = new IdPropertyDefinition();
                res.setDefaultValue(copyDefaultValue(id));
                res.setChoices(copyChoices(id));
                yield res;
            }
            case IntegerPropertyDefinition i -> {
                IntegerPropertyDefinition res = new IntegerPropertyDefinition();
                res.setMinValue(i.getMinValue());
                res.setMaxValue(i.getMaxValue());
                res.setDefaultValue(copyDefaultValue(i));
                res.setChoices(copyChoices(i));
                yield res;
            }
            case StringPropertyDefinition s -> {
                StringPropertyDefinition res = new StringPropertyDefinition();
                res.setMaxLength((s.getMaxLength()));
                res.setDefaultValue(copyDefaultValue(s));
                res.setChoices(copyChoices(s));
                yield res;
            }
            case UriPropertyDefinition u -> {
                UriPropertyDefinition res = new UriPropertyDefinition();
                res.setDefaultValue(copyDefaultValue(u));
                res.setChoices(copyChoices(u));
                yield res;
            }
            default -> throw new RuntimeException("unknown datatype");
        };

        result.setId(source.getId());
        result.setLocalName(source.getLocalName());
        result.setLocalNamespace(source.getLocalNamespace());
        result.setDisplayName(source.getDisplayName());
        result.setDescription(source.getDescription());
        result.setPropertyType(source.getPropertyType());
        result.setCardinality(source.getCardinality());
        result.setUpdatability(source.getUpdatability());
        result.setInherited(source.isInherited());
        result.setRequired(source.isRequired());
        result.setQueryable(source.isQueryable());
        result.setOrderable(source.isOrderable());
        result.setQueryName(source.getQueryName());
        result.setOpenChoice(source.getOpenChoice());

        copyExtensions(source, result);

        return result;
    }

    private <T> List<T> copyDefaultValue(PropertyDefinition<T> source) {
        if (source == null || source.getDefaultValue() == null) {
            return null;
        }

        return new ArrayList<>(source.getDefaultValue());
    }

    private <T> List<Choice<T>> copyChoices(PropertyDefinition<T> source) {
        if (source == null || source.getChoices() == null) {
            return null;
        }

        List<Choice<T>> result = new ArrayList<>(0);

        for (Choice<T> c : source.getChoices()) {
            result.add(copyChoice(c));
        }

        return result;
    }

    private <T> Choice<T> copyChoice(Choice<T> source) {
        if (source == null) {
            return null;
        }

        Choice<T> result = new Choice<>();

        result.setDisplayName(source.getDisplayName());
        if (source.getValue() != null) {
            result.setValue(new ArrayList<>(source.getValue()));
        }

        if (source.getChoice() != null) {
            List<Choice<T>> choices = new ArrayList<>();
            for (Choice<T> c : source.getChoice()) {
                choices.add(copyChoice(c));
            }
            result.setChoice(choices);
        }

        return result;
    }

    private void copyExtensions(ExtensionData source, ExtensionData target) {
        if (source == null || target == null) {
            return;
        }

        if (source.getExtensions() == null) {
            target.setExtensions(null);
            return;
        }

        List<CmisExtensionElement> elementList = new ArrayList<>();
        for (CmisExtensionElement element : source.getExtensions()) {
            elementList.add(copy(element));
        }

        target.setExtensions(elementList);
    }

    private CmisExtensionElement copy(CmisExtensionElement element) {
        if (element == null) {
            return null;
        }

        Map<String, String> attrs =
                (element.getAttributes() != null ? new HashMap<>(element.getAttributes()) : null);

        List<CmisExtensionElement> children = element.getChildren();
        if (children != null && !children.isEmpty()) {
            List<CmisExtensionElement> copyChildren = new ArrayList<>(children.size());

            for (CmisExtensionElement child : children) {
                copyChildren.add(copy(child));
            }

            return new CmisExtensionElement(element.getNamespace(), element.getName(), attrs, copyChildren);
        } else {
            return new CmisExtensionElement(element.getNamespace(), element.getName(), attrs, element.getValue());
        }
    }
}
