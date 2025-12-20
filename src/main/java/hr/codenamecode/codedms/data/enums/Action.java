package hr.codenamecode.codedms.data.enums;

import hr.codenamecode.codedms.data.repositoryinfo.PermissionMapping;

import java.util.List;

public enum Action {

    CAN_DELETE_OBJECT("canDeleteObject") {
        @Override
        public List<String> getPermissionMappingKeys() {
            return List.of(PermissionMapping.CAN_DELETE_OBJECT);
        }
    },

    CAN_UPDATE_PROPERTIES("canUpdateProperties") {
        @Override
        public List<String> getPermissionMappingKeys() {
            return List.of(PermissionMapping.CAN_UPDATE_PROPERTIES_OBJECT);
        }
    },

    CAN_GET_FOLDER_TREE("canGetFolderTree") {
        @Override
        public List<String> getPermissionMappingKeys() {
            return List.of(PermissionMapping.CAN_GET_DESCENDENTS_FOLDER);
        }
    },

    CAN_GET_PROPERTIES("canGetProperties") {
        @Override
        public List<String> getPermissionMappingKeys() {
            return List.of(PermissionMapping.CAN_GET_PROPERTIES_OBJECT);
        }
    },

    CAN_GET_OBJECT_RELATIONSHIPS("canGetObjectRelationships") {
        @Override
        public List<String> getPermissionMappingKeys() {
            return List.of(PermissionMapping.CAN_GET_OBJECT_RELATIONSHIPS_OBJECT);
        }
    },

    CAN_GET_OBJECT_PARENTS("canGetObjectParents") {
        @Override
        public List<String> getPermissionMappingKeys() {
            return List.of(PermissionMapping.CAN_GET_PARENTS_FOLDER);
        }
    },

    CAN_GET_FOLDER_PARENT("canGetFolderParent") {
        @Override
        public List<String> getPermissionMappingKeys() {
            return List.of(PermissionMapping.CAN_GET_FOLDER_PARENT_OBJECT);
        }
    },

    CAN_GET_DESCENDANTS("canGetDescendants") {
        @Override
        public List<String> getPermissionMappingKeys() {
            return List.of(PermissionMapping.CAN_GET_DESCENDENTS_FOLDER);
        }
    },

    CAN_MOVE_OBJECT("canMoveObject") {
        @Override
        public List<String> getPermissionMappingKeys() {
            return List.of(
                    PermissionMapping.CAN_MOVE_OBJECT,
                    PermissionMapping.CAN_MOVE_SOURCE,
                    PermissionMapping.CAN_MOVE_TARGET);
        }
    },

    CAN_DELETE_CONTENT_STREAM("canDeleteContentStream") {
        @Override
        public List<String> getPermissionMappingKeys() {
            return List.of(PermissionMapping.CAN_DELETE_CONTENT_DOCUMENT);
        }
    },

    CAN_CHECK_OUT("canCheckOut") {
        @Override
        public List<String> getPermissionMappingKeys() {
            return List.of(PermissionMapping.CAN_CHECKOUT_DOCUMENT);
        }
    },

    CAN_CANCEL_CHECK_OUT("canCancelCheckOut") {
        @Override
        public List<String> getPermissionMappingKeys() {
            return List.of(PermissionMapping.CAN_CANCEL_CHECKOUT_DOCUMENT);
        }
    },

    CAN_CHECK_IN("canCheckIn") {
        @Override
        public List<String> getPermissionMappingKeys() {
            return List.of(PermissionMapping.CAN_CHECKIN_DOCUMENT);
        }
    },

    CAN_SET_CONTENT_STREAM("canSetContentStream") {
        @Override
        public List<String> getPermissionMappingKeys() {
            return List.of(PermissionMapping.CAN_SET_CONTENT_DOCUMENT);
        }
    },

    CAN_GET_ALL_VERSIONS("canGetAllVersions") {
        @Override
        public List<String> getPermissionMappingKeys() {
            return List.of(PermissionMapping.CAN_GET_ALL_VERSIONS_VERSION_SERIES);
        }
    },

    CAN_ADD_OBJECT_TO_FOLDER("canAddObjectToFolder") {
        @Override
        public List<String> getPermissionMappingKeys() {
            return List.of(PermissionMapping.CAN_ADD_TO_FOLDER_OBJECT, PermissionMapping.CAN_ADD_TO_FOLDER_FOLDER);
        }
    },

    CAN_REMOVE_OBJECT_FROM_FOLDER("canRemoveObjectFromFolder") {
        @Override
        public List<String> getPermissionMappingKeys() {
            return List.of(
                    PermissionMapping.CAN_REMOVE_FROM_FOLDER_OBJECT, PermissionMapping.CAN_REMOVE_FROM_FOLDER_FOLDER);
        }
    },

    CAN_GET_CONTENT_STREAM("canGetContentStream") {
        @Override
        public List<String> getPermissionMappingKeys() {
            return List.of(PermissionMapping.CAN_VIEW_CONTENT_OBJECT);
        }
    },

    CAN_APPLY_POLICY("canApplyPolicy") {
        @Override
        public List<String> getPermissionMappingKeys() {
            return List.of(PermissionMapping.CAN_ADD_POLICY_OBJECT, PermissionMapping.CAN_ADD_POLICY_POLICY);
        }
    },

    CAN_GET_APPLIED_POLICIES("canGetAppliedPolicies") {
        @Override
        public List<String> getPermissionMappingKeys() {
            return List.of(PermissionMapping.CAN_GET_APPLIED_POLICIES_OBJECT);
        }
    },

    CAN_REMOVE_POLICY("canRemovePolicy") {
        @Override
        public List<String> getPermissionMappingKeys() {
            return List.of(PermissionMapping.CAN_REMOVE_POLICY_OBJECT, PermissionMapping.CAN_REMOVE_POLICY_POLICY);
        }
    },

    CAN_GET_CHILDREN("canGetChildren") {
        @Override
        public List<String> getPermissionMappingKeys() {
            return List.of(PermissionMapping.CAN_GET_CHILDREN_FOLDER);
        }
    },

    CAN_CREATE_DOCUMENT("canCreateDocument") {
        @Override
        public List<String> getPermissionMappingKeys() {
            return List.of(PermissionMapping.CAN_CREATE_DOCUMENT_FOLDER);
        }
    },

    CAN_CREATE_FOLDER("canCreateFolder") {
        @Override
        public List<String> getPermissionMappingKeys() {
            return List.of(PermissionMapping.CAN_CREATE_FOLDER_FOLDER);
        }
    },

    CAN_CREATE_RELATIONSHIP("canCreateRelationship") {
        @Override
        public List<String> getPermissionMappingKeys() {
            return List.of(
                    PermissionMapping.CAN_CREATE_RELATIONSHIP_SOURCE, PermissionMapping.CAN_CREATE_RELATIONSHIP_TARGET);
        }
    },

    CAN_CREATE_ITEM("canCreateItem") {
        @Override
        public List<String> getPermissionMappingKeys() {
            return List.of();
        }
    },

    CAN_DELETE_TREE("canDeleteTree") {
        @Override
        public List<String> getPermissionMappingKeys() {
            return List.of(PermissionMapping.CAN_DELETE_TREE_FOLDER);
        }
    },

    CAN_GET_RENDITIONS("canGetRenditions") {
        @Override
        public List<String> getPermissionMappingKeys() {
            return List.of();
        }
    },

    CAN_GET_ACL("canGetACL") {
        @Override
        public List<String> getPermissionMappingKeys() {
            return List.of(PermissionMapping.CAN_GET_ACL_OBJECT);
        }
    },

    CAN_APPLY_ACL("canApplyACL") {
        @Override
        public List<String> getPermissionMappingKeys() {
            return List.of(PermissionMapping.CAN_APPLY_ACL_OBJECT);
        }
    };

    private final String value;

    Action(String v) {
        value = v;
    }

    public static Action fromValue(String v) {
        for (Action c : Action.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

    public String value() {
        return value;
    }

    public abstract List<String> getPermissionMappingKeys();
}
