package hr.codenamecode.codedms.utils;

import hr.codenamecode.codedms.data.objects.*;
import hr.codenamecode.codedms.data.repositoryinfo.PropertyDefinition;
import hr.codenamecode.codedms.data.repositoryinfo.TypeDefinition;
import hr.codenamecode.codedms.exceptions.CmisRuntimeException;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ObjectDataFactory {

    private ObjectDataFactory() {
    }

    public static Ace createAce(String principal, List<String> permissions) {
        Ace ace = new Ace();
        ace.setPrincipal(new AcePrincipal(principal));
        ace.setPermissions(permissions);
        return ace;
    }

    public static Acl createAcl(List<Ace> aces, boolean exact) {
        Acl acl = new Acl();
        acl.setAces(aces);
        acl.setExact(exact);
        return acl;
    }

    public static Map<String, PropertyData<?>> createProperties(List<PropertyData<?>> properties) {
        Map<String, PropertyData<?>> map = new HashMap<>();
        properties.forEach(p -> map.put(p.getId(), p));
        return map;
    }

    @SuppressWarnings("unchecked")
    public static <I extends PropertyData<T>, T> PropertyData<T> createPropertyData(PropertyDefinition<T> pd,
                                                                                    List<T> value,
                                                                                    Class<I> clazz) {
        try {
            I instance = clazz.getDeclaredConstructor().newInstance();
            instance.setId(pd.getId());
            instance.setQueryName(pd.getQueryName());
            instance.setDisplayName(pd.getDisplayName());
            instance.setLocalName(pd.getLocalName());
            instance.setPropertyDefinition(pd);
            instance.getValue().addAll(value);
            return instance;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new CmisRuntimeException();
        }
    }

    @SuppressWarnings("unchecked")
    public static ObjectData createBaseObjectData(String objectTypeId, TypeCache typeCache) {
        ObjectData objectData = new ObjectData();

        TypeDefinition typeDefinition = typeCache.get(objectTypeId);

        for (PropertyDefinition<?> pDef : typeDefinition.getPropertyDefinitions().values()) {
            PropertyData<?> propertyData = createPropertyData((PropertyDefinition<Object>) pDef,
                    (List<Object>) pDef.getDefaultValue(),
                    (Class<? extends PropertyData<Object>>) pDef.getPropertyType().getDataClass());

            objectData.getProperties().put(propertyData.getId(), propertyData);
        }

        return objectData;
    }
}