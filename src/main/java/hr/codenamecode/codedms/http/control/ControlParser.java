package hr.codenamecode.codedms.http.control;

import hr.codenamecode.codedms.data.objects.*;
import hr.codenamecode.codedms.data.objects.Properties;
import hr.codenamecode.codedms.data.repositoryinfo.PropertyDefinition;
import hr.codenamecode.codedms.data.repositoryinfo.PropertyIds;
import hr.codenamecode.codedms.data.repositoryinfo.TypeDefinition;
import hr.codenamecode.codedms.exceptions.CmisInvalidArgumentException;
import hr.codenamecode.codedms.utils.ObjectDataFactory;
import hr.codenamecode.codedms.utils.TypeCache;
import lombok.Getter;

import java.util.*;

public class ControlParser {

    protected static final String CONTROL_PROP_ID_LOWER = "propertyid";
    protected static final String CONTROL_PROP_VALUE_LOWER = "propertyvalue";

    private final Map<String, String> zeroDim = new HashMap<>();
    private final Map<String, Map<Integer, String>> oneDim = new HashMap<>();
    private final Map<String, Map<Integer, Map<Integer, String>>> twoDim = new HashMap<>();

    @Getter
    private final Map<String, String[]> parameterMap = new HashMap<>();

    public ControlParser(Map<String, String[]> parameterMap) {
        if (parameterMap != null) {
            this.parameterMap.putAll(parameterMap);
            parse();
        }
    }

    private static int getFirstIndex(String controlName) {
        int open = controlName.indexOf('[');
        int close = controlName.indexOf(']');

        if (open == -1 || close == -1 || close < open) {
            return -1;
        }

        String indexStr = controlName.substring(open + 1, close);
        try {
            int result = Integer.parseInt(indexStr);
            return result < 0 ? -1 : result;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static int getSecondIndex(String controlName) {
        int open = controlName.indexOf("][");
        int close = controlName.lastIndexOf(']');

        if (open == -1 || close == -1 || close < open) {
            return -1;
        }

        String indexStr = controlName.substring(open + 2, close);
        try {
            int result = Integer.parseInt(indexStr);
            return result < 0 ? -1 : result;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static List<String> convertToList(String controlName, Map<Integer, String> map) {
        if (map == null) {
            return null;
        }

        int count = map.size();
        List<String> result = new ArrayList<>(count);

        for (int i = 0; i < count; i++) {
            String value = map.get(i);
            if (value == null) {
                throw new CmisInvalidArgumentException(controlName + " has gaps");
            }
            result.add(value);
        }

        return result;
    }

    protected void parse() {
        if (parameterMap.isEmpty()) {
            return;
        }

        for (Map.Entry<String, String[]> control : parameterMap.entrySet()) {
            String controlName = control.getKey().trim().toLowerCase(Locale.ENGLISH);
            String[] values = control.getValue();
            if (values == null || values.length == 0) {
                continue;
            }
            String value = values[0];

            int firstIndex = getFirstIndex(controlName);

            if (firstIndex == -1) {
                zeroDim.put(controlName, value);
            } else {
                String strippedControlName = controlName.substring(0, controlName.indexOf('['));
                int secondIndex = getSecondIndex(controlName);

                if (secondIndex == -1) {
                    oneDim.computeIfAbsent(strippedControlName, k -> new HashMap<>())
                            .put(firstIndex, value);
                } else {
                    twoDim.computeIfAbsent(strippedControlName, k -> new HashMap<>())
                            .computeIfAbsent(firstIndex, k -> new HashMap<>())
                            .put(secondIndex, value);
                }
            }
        }
    }

    public String getValue(String controlName) {
        if (controlName == null) {
            throw new IllegalArgumentException("controlName must not be null");
        }

        return zeroDim.get(controlName.toLowerCase(Locale.ENGLISH));
    }

    public List<String> getValues(String controlName) {
        if (controlName == null) {
            throw new IllegalArgumentException("controlName must not be null");
        }

        return convertToList(controlName, oneDim.get(controlName.toLowerCase(Locale.ENGLISH)));
    }

    public List<String> getValues(String controlName, int index) {
        if (controlName == null) {
            throw new IllegalArgumentException("controlName must not be null");
        }

        Map<Integer, Map<Integer, String>> map = twoDim.get(controlName.toLowerCase(Locale.ENGLISH));
        if (map == null) {
            return null;
        }

        return convertToList(controlName, map.get(index));
    }

    public Map<Integer, String> getOneDimMap(String controlName) {
        if (controlName == null) {
            throw new IllegalArgumentException("controlName must not be null");
        }

        return oneDim.get(controlName.toLowerCase(Locale.ENGLISH));
    }

    public Map<Integer, Map<Integer, String>> getTwoDimMap(String controlName) {
        if (controlName == null) {
            throw new IllegalArgumentException("controlName must not be null");
        }

        return twoDim.get(controlName.toLowerCase(Locale.ENGLISH));
    }

    private Map<String, List<String>> getProperties() {
        Map<Integer, String> propertyIds = oneDim.get(CONTROL_PROP_ID_LOWER);
        if (propertyIds == null) {
            return null;
        }

        Map<Integer, String> oneDimPropValues = oneDim.get(CONTROL_PROP_VALUE_LOWER);
        Map<Integer, Map<Integer, String>> twoDimPropValues = twoDim.get(CONTROL_PROP_VALUE_LOWER);

        int count = propertyIds.size();
        Map<String, List<String>> result = new LinkedHashMap<>();

        for (int i = 0; i < count; i++) {
            String propertyId = propertyIds.get(i);
            if (propertyId == null) {
                throw new CmisInvalidArgumentException(CONTROL_PROP_ID_LOWER + " has gaps");
            }

            List<String> values = null;
            if (oneDimPropValues != null && oneDimPropValues.containsKey(i)) {
                values = Collections.singletonList(oneDimPropValues.get(i));
            } else if (twoDimPropValues != null && twoDimPropValues.containsKey(i)) {
                values = new ArrayList<>();

                Map<Integer, String> valuesMap = twoDimPropValues.get(i);
                if (valuesMap != null) {
                    int valueCount = valuesMap.size();

                    for (int j = 0; j < valueCount; j++) {
                        String value = valuesMap.get(j);
                        if (value == null) {
                            throw new CmisInvalidArgumentException(CONTROL_PROP_VALUE_LOWER + "[" + i + "] has " +
                                    "gaps");
                        }

                        values.add(value);
                    }
                }
            }

            result.put(propertyId, values);
        }

        return result;
    }

    // -- Data builders

    @SuppressWarnings("unchecked")
    public Properties createNewProperties(TypeCache typeCache) {
        Map<String, List<String>> properties = getProperties();
        if (properties == null) {
            return null;
        }

        // load primary type
        List<String> objectTypeIdsValues = properties.get(PropertyIds.OBJECT_TYPE_ID);
        TypeDefinition typeDef = null;
        if (objectTypeIdsValues != null && !objectTypeIdsValues.isEmpty()) {
            String typeId = objectTypeIdsValues.getFirst();
            typeDef = typeCache.get(typeId);
            if (typeDef == null) {
                throw new CmisInvalidArgumentException("Invalid type: " + typeId);
            }
        }

        // load secondary types - not supported currently
        List<String> secondaryObjectTypeIdsValues = properties.get(PropertyIds.SECONDARY_OBJECT_TYPE_IDS);
        TypeDefinition secondaryTypeDef = null;
        if (secondaryObjectTypeIdsValues != null && !secondaryObjectTypeIdsValues.isEmpty()) {
            for (String secTypeId : secondaryObjectTypeIdsValues) {
                secondaryTypeDef = typeCache.get(secTypeId);
                if (secondaryTypeDef == null) {
                    throw new CmisInvalidArgumentException("Invalid type: " + secTypeId);
                }
            }
        }

        // create properties
        Properties result = new Properties();
        for (Map.Entry<String, List<String>> property : properties.entrySet()) {
            PropertyDefinition<?> propDef = typeDef.getPropertyDefinitions().get(property.getKey());
            if (propDef == null) {
                throw new CmisInvalidArgumentException(property.getKey() + " is unknown");
            }

            PropertyData<?> propertyData =
                    ObjectDataFactory.createPropertyData((PropertyDefinition<Object>) propDef,
                            new ArrayList<>(property.getValue()),
                            (Class<? extends PropertyData<Object>>) propDef.getPropertyType().getDataClass());

            result.put(propDef.getId(), propertyData);
        }

        return result;
    }

    public List<String> createPolicies() {
        return getValues("policy");
    }

    public Acl createAddAcl() {
        return createAcl(true);
    }

    public Acl createRemoveAcl() {
        return createAcl(false);
    }

    private Acl createAcl(boolean add) {
        String controlPrefix = (add ? "add" : "remove");
        List<String> principals = getValues(controlPrefix + "ACEPrincipal");
        if (principals == null) {
            return null;
        }

        List<Ace> aces = new ArrayList<>();

        int i = 0;
        for (String principalId : principals) {
            Ace ace = new Ace();
            ace.setPrincipal(new AcePrincipal(principalId));
            ace.setPermissions(getValues(controlPrefix + "ACEPermission", i++));
            aces.add(ace);
        }

        Acl acl = new Acl();
        acl.setExact(true);
        acl.setAces(aces);

        return acl;
    }
}