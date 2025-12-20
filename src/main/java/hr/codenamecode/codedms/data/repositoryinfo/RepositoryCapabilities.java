package hr.codenamecode.codedms.data.repositoryinfo;

import hr.codenamecode.codedms.data.enums.*;
import hr.codenamecode.codedms.data.extensions.ExtensionData;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class RepositoryCapabilities extends ExtensionData {
    private Boolean capabilityAllVersionsSearchable;
    private CapabilityAcl capabilityACL;
    private CapabilityChanges capabilityChanges;
    private CapabilityContentStreamUpdates capabilityContentStreamUpdatability;
    private CapabilityJoin capabilityJoin;
    private CapabilityQuery capabilityQuery;
    private CapabilityRenditions capabilityRenditions;
    private Boolean capabilityPWCSearchable;
    private Boolean capabilityPWCUpdatable;
    private Boolean capabilityGetDescendants;
    private Boolean capabilityGetFolderTree;
    private CapabilityOrderBy capabilityOrderBy;
    private Boolean capabilityMultifiling;
    private Boolean capabilityUnfiling;
    private Boolean capabilityVersionSpecificFiling;
    private CreatablePropertyTypes capabilityCreatablePropertyTypes;
    private NewTypeSettableAttributes capabilityNewTypeSettableAttributes;
}
