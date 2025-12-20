package hr.codenamecode.codedms.data.repositoryinfo;

import hr.codenamecode.codedms.data.extensions.ExtensionData;
import jakarta.json.bind.annotation.JsonbProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class PermissionMapping extends ExtensionData {
    public static final String CAN_GET_DESCENDENTS_FOLDER = "canGetDescendents.Folder";
    public static final String CAN_GET_CHILDREN_FOLDER = "canGetChildren.Folder";
    public static final String CAN_GET_PARENTS_FOLDER = "canGetParents.Folder";
    public static final String CAN_GET_FOLDER_PARENT_OBJECT = "canGetFolderParent.Object";
    public static final String CAN_CREATE_DOCUMENT_FOLDER = "canCreateDocument.Folder";
    public static final String CAN_CREATE_FOLDER_FOLDER = "canCreateFolder.Folder";
    public static final String CAN_CREATE_POLICY_FOLDER = "canCreatePolicy.Folder";
    public static final String CAN_CREATE_RELATIONSHIP_SOURCE = "canCreateRelationship.Source";
    public static final String CAN_CREATE_RELATIONSHIP_TARGET = "canCreateRelationship.Target";
    public static final String CAN_GET_PROPERTIES_OBJECT = "canGetProperties.Object";
    public static final String CAN_VIEW_CONTENT_OBJECT = "canViewContent.Object";
    public static final String CAN_UPDATE_PROPERTIES_OBJECT = "canUpdateProperties.Object";
    public static final String CAN_MOVE_OBJECT = "canMove.Object";
    public static final String CAN_MOVE_TARGET = "canMove.Target";
    public static final String CAN_MOVE_SOURCE = "canMove.Source";
    public static final String CAN_DELETE_OBJECT = "canDelete.Object";
    public static final String CAN_DELETE_TREE_FOLDER = "canDeleteTree.Folder";
    public static final String CAN_SET_CONTENT_DOCUMENT = "canSetContent.Document";
    public static final String CAN_DELETE_CONTENT_DOCUMENT = "canDeleteContent.Document";
    public static final String CAN_ADD_TO_FOLDER_OBJECT = "canAddToFolder.Object";
    public static final String CAN_ADD_TO_FOLDER_FOLDER = "canAddToFolder.Folder";
    public static final String CAN_REMOVE_FROM_FOLDER_OBJECT = "canRemoveFromFolder.Object";
    public static final String CAN_REMOVE_FROM_FOLDER_FOLDER = "canRemoveFromFolder.Folder";
    public static final String CAN_CHECKOUT_DOCUMENT = "canCheckout.Document";
    public static final String CAN_CANCEL_CHECKOUT_DOCUMENT = "canCancelCheckout.Document";
    public static final String CAN_CHECKIN_DOCUMENT = "canCheckin.Document";
    public static final String CAN_GET_ALL_VERSIONS_VERSION_SERIES = "canGetAllVersions.VersionSeries";
    public static final String CAN_GET_OBJECT_RELATIONSHIPS_OBJECT = "canGetObjectRelationships.Object";
    public static final String CAN_ADD_POLICY_OBJECT = "canAddPolicy.Object";
    public static final String CAN_ADD_POLICY_POLICY = "canAddPolicy.Policy";
    public static final String CAN_REMOVE_POLICY_OBJECT = "canRemovePolicy.Object";
    public static final String CAN_REMOVE_POLICY_POLICY = "canRemovePolicy.Policy";
    public static final String CAN_GET_APPLIED_POLICIES_OBJECT = "canGetAppliedPolicies.Object";
    public static final String CAN_GET_ACL_OBJECT = "canGetACL.Object";
    public static final String CAN_APPLY_ACL_OBJECT = "canApplyACL.Object";
    
    private String key;

    @JsonbProperty("permission")
    private List<String> permissions = new ArrayList<>(0);
}