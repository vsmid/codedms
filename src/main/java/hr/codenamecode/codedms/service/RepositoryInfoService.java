package hr.codenamecode.codedms.service;

import hr.codenamecode.codedms.data.enums.*;
import hr.codenamecode.codedms.data.extensions.ExtensionData;
import hr.codenamecode.codedms.data.extensions.ExtensionFeatures;
import hr.codenamecode.codedms.data.repositoryinfo.*;
import hr.codenamecode.codedms.utils.TypeCache;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.math.BigInteger;
import java.util.*;

import static hr.codenamecode.codedms.data.enums.BasicPermission.*;
import static hr.codenamecode.codedms.data.repositoryinfo.PermissionMapping.*;

@ApplicationScoped
public class RepositoryInfoService {

    @Inject
    @Named("typeCache")
    private TypeCache typeCache;

    public List<RepositoryInfo> getRepositoryInfos(ExtensionData extension) {
        RepositoryInfo repositoryInfo = new RepositoryInfo();

        repositoryInfo.setProductName("CodeInsights");
        repositoryInfo.setVendorName("codenamecode d.o.o.");
        repositoryInfo.setProductVersion("latest");
        repositoryInfo.setVersionSupported(CmisVersion.CMIS_1_1.value());
        repositoryInfo.setRepositoryId("repo1");
        repositoryInfo.setRepositoryName("repo1");
        repositoryInfo.setRepositoryDescription("repo1");
        repositoryInfo.setPrincipalIdAnonymous("anonymous");
        repositoryInfo.setPrincipalIdAnyone("anyone");
        repositoryInfo.setThinClientUri("");
        repositoryInfo.setRootFolderId(UUID.randomUUID().toString());
        repositoryInfo.setLatestChangeLogToken(null);
        repositoryInfo.setChangesOnType(List.of(BaseTypeId.CMIS_FOLDER, BaseTypeId.CMIS_DOCUMENT));
        repositoryInfo.setChangesIncomplete(true);

        RepositoryCapabilities capabilities = new RepositoryCapabilities();
        capabilities.setCapabilityACL(CapabilityAcl.MANAGE);
        capabilities.setCapabilityChanges(CapabilityChanges.NONE);
        capabilities.setCapabilityJoin(CapabilityJoin.NONE);
        capabilities.setCapabilityQuery(CapabilityQuery.BOTHCOMBINED);
        capabilities.setCapabilityOrderBy(CapabilityOrderBy.CUSTOM);
        capabilities.setCapabilityContentStreamUpdatability(CapabilityContentStreamUpdates.ANYTIME);
        capabilities.setCapabilityRenditions(CapabilityRenditions.NONE);
        capabilities.setCapabilityVersionSpecificFiling(false);
        capabilities.setCapabilityAllVersionsSearchable(false);
        capabilities.setCapabilityPWCSearchable(false);
        capabilities.setCapabilityPWCUpdatable(false);
        capabilities.setCapabilityGetDescendants(false);
        capabilities.setCapabilityUnfiling(false);
        capabilities.setCapabilityMultifiling(false);
        capabilities.setCapabilityGetFolderTree(false);

        NewTypeSettableAttributes newTypeSettableAttributes = new NewTypeSettableAttributes();
        newTypeSettableAttributes.setControllableACL(true);
        newTypeSettableAttributes.setCreatable(true);
        newTypeSettableAttributes.setControllablePolicy(false);
        newTypeSettableAttributes.setDescription(true);
        newTypeSettableAttributes.setId(true);
        newTypeSettableAttributes.setFileable(true);
        newTypeSettableAttributes.setFulltextIndexed(false);
        newTypeSettableAttributes.setIncludedInSupertypeQuery(false);
        newTypeSettableAttributes.setDisplayName(true);
        newTypeSettableAttributes.setLocalName(true);
        newTypeSettableAttributes.setLocalNamespace(true);
        newTypeSettableAttributes.setQueryable(true);
        newTypeSettableAttributes.setQueryable(true);
        capabilities.setCapabilityNewTypeSettableAttributes(newTypeSettableAttributes);

        CreatablePropertyTypes creatablePropertyTypes = new CreatablePropertyTypes();
        creatablePropertyTypes.setCanCreate(new HashSet<>(EnumSet.allOf(PropertyType.class)));
        capabilities.setCapabilityCreatablePropertyTypes(creatablePropertyTypes);

        repositoryInfo.setCapabilities(capabilities);

        AclCapabilities aclCapabilities = new AclCapabilities();
        aclCapabilities.setAclPropagation(AclPropagation.REPOSITORYDETERMINED);
        aclCapabilities.setSupportedPermissions(SupportedPermissions.BASIC);

        List<PermissionMapping> list = new ArrayList<>();
        list.add(createMapping(CAN_GET_DESCENDENTS_FOLDER, READ.value()));
        list.add(createMapping(CAN_GET_CHILDREN_FOLDER, READ.value()));
        list.add(createMapping(CAN_GET_PARENTS_FOLDER, READ.value()));
        list.add(createMapping(CAN_GET_FOLDER_PARENT_OBJECT, READ.value()));
        list.add(createMapping(CAN_CREATE_DOCUMENT_FOLDER, WRITE.value()));
        list.add(createMapping(CAN_CREATE_FOLDER_FOLDER, WRITE.value()));
        list.add(createMapping(CAN_CREATE_RELATIONSHIP_SOURCE, READ.value()));
        list.add(createMapping(CAN_CREATE_RELATIONSHIP_TARGET, READ.value()));
        list.add(createMapping(CAN_GET_PROPERTIES_OBJECT, READ.value()));
        list.add(createMapping(CAN_VIEW_CONTENT_OBJECT, READ.value()));
        list.add(createMapping(CAN_UPDATE_PROPERTIES_OBJECT, WRITE.value()));
        list.add(createMapping(CAN_MOVE_OBJECT, WRITE.value()));
        list.add(createMapping(CAN_MOVE_TARGET, WRITE.value()));
        list.add(createMapping(CAN_MOVE_SOURCE, WRITE.value()));
        list.add(createMapping(CAN_DELETE_OBJECT, WRITE.value()));
        list.add(createMapping(CAN_DELETE_TREE_FOLDER, WRITE.value()));
        list.add(createMapping(CAN_SET_CONTENT_DOCUMENT, WRITE.value()));
        list.add(createMapping(CAN_DELETE_CONTENT_DOCUMENT, WRITE.value()));
        list.add(createMapping(CAN_ADD_TO_FOLDER_OBJECT, WRITE.value()));
        list.add(createMapping(CAN_REMOVE_FROM_FOLDER_OBJECT, WRITE.value()));
        list.add(createMapping(CAN_CHECKOUT_DOCUMENT, WRITE.value()));
        list.add(createMapping(CAN_CANCEL_CHECKOUT_DOCUMENT, WRITE.value()));
        list.add(createMapping(CAN_CHECKIN_DOCUMENT, WRITE.value()));
        list.add(createMapping(CAN_GET_ALL_VERSIONS_VERSION_SERIES, READ.value()));
        list.add(createMapping(CAN_GET_OBJECT_RELATIONSHIPS_OBJECT, READ.value()));
        list.add(createMapping(CAN_ADD_POLICY_OBJECT, WRITE.value()));
        list.add(createMapping(CAN_REMOVE_POLICY_OBJECT, WRITE.value()));
        list.add(createMapping(CAN_GET_APPLIED_POLICIES_OBJECT, READ.value()));
        list.add(createMapping(CAN_GET_ACL_OBJECT, READ.value()));
        list.add(createMapping(CAN_APPLY_ACL_OBJECT, ALL.value()));
        list.add(createMapping(CAN_ADD_TO_FOLDER_FOLDER, WRITE.value()));
        list.add(createMapping(CAN_ADD_TO_FOLDER_OBJECT, WRITE.value()));
        list.add(createMapping(CAN_REMOVE_FROM_FOLDER_FOLDER, WRITE.value()));
        list.add(createMapping(CAN_CREATE_POLICY_FOLDER, WRITE.value()));
        list.add(createMapping(CAN_ADD_POLICY_POLICY, WRITE.value()));
        list.add(createMapping(CAN_REMOVE_POLICY_POLICY, WRITE.value()));

        List<PermissionMapping> mapping = new ArrayList<>(list);
        aclCapabilities.setPermissionMapping(mapping);

        List<PermissionDefinition> permissions = new ArrayList<>();
        permissions.add(createPermission(READ.value(), "Read"));
        permissions.add(createPermission(WRITE.value(), "Write"));
        permissions.add(createPermission(ALL.value(), "All"));
        aclCapabilities.setPermissions(permissions);
        repositoryInfo.setAclCapabilities(aclCapabilities);

        repositoryInfo.setExtendedFeatures(List.of(ExtensionFeatures.EXTENDED_DATETIME_FORMAT));
        repositoryInfo.setRootFolderId(UUID.randomUUID().toString());

        return List.of(repositoryInfo);
    }

    public TypeDefinitionList getTypeChildren(String repositoryId, String typeId, Boolean includePropertyDefinitions,
                                              BigInteger maxItems, BigInteger skipCount, ExtensionData extension) {
        TypeDefinitionList typeDefinitionList = new TypeDefinitionList();
        typeDefinitionList.setTypes(typeCache.values().stream().toList());
        typeDefinitionList.setNumItems(BigInteger.valueOf(2));
        typeDefinitionList.setHasMoreItems(false);
        return typeDefinitionList;
    }

    public TypeDefinition getTypeDefinition(String repositoryId, String typeId, ExtensionData extension) {
        return typeCache.get(typeId);
    }

    private PermissionDefinition createPermission(String permission, String description) {
        PermissionDefinition pd = new PermissionDefinition();
        pd.setPermission(permission);
        pd.setDescription(description);
        return pd;
    }

    private PermissionMapping createMapping(String key, String permission) {
        PermissionMapping pm = new PermissionMapping();
        pm.setKey(key);
        pm.setPermissions(Collections.singletonList(permission));
        return pm;
    }
}
