package hr.codenamecode.codedms.data.repositoryinfo;

import hr.codenamecode.codedms.data.enums.BaseTypeId;
import hr.codenamecode.codedms.data.enums.CmisVersion;
import hr.codenamecode.codedms.data.extensions.ExtensionData;
import hr.codenamecode.codedms.data.extensions.ExtensionFeature;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class RepositoryInfo extends ExtensionData {
    private String repositoryId;
    private String repositoryName;
    private String repositoryDescription;
    private String versionSupported;
    private RepositoryCapabilities capabilities;
    private String rootFolderId;
    private AclCapabilities aclCapabilities;
    private String principalIdAnonymous;
    private String principalIdAnyone;
    private String thinClientUri;
    private Boolean changesIncomplete;
    private List<BaseTypeId> changesOnType = new ArrayList<>(0);
    private String latestChangeLogToken;
    private String vendorName;
    private String productName;
    private String productVersion;
    private String repositoryUrl;
    private String rootFolderUrl;
    private List<ExtensionFeature> extendedFeatures;
    private CmisVersion cmisVersionSupported = CmisVersion.CMIS_1_1;
}