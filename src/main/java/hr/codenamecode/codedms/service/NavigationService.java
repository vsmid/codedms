package hr.codenamecode.codedms.service;

import hr.codenamecode.codedms.data.enums.IncludeRelationships;
import hr.codenamecode.codedms.data.extensions.ExtensionData;
import hr.codenamecode.codedms.data.objects.ObjectInFolderList;
import hr.codenamecode.codedms.security.PreAuthorize;
import jakarta.enterprise.context.ApplicationScoped;

import java.math.BigInteger;
import java.util.List;

import static hr.codenamecode.codedms.data.enums.BasicPermission.READ;

@ApplicationScoped
public class NavigationService {

    @PreAuthorize(
            objectIdArgIndex = 1,
            permission = READ
    )
    public ObjectInFolderList getChildren(
            String repositoryId,
            String folderId,
            String filter,
            String orderBy,
            Boolean includeAllowableActions,
            IncludeRelationships includeRelationships,
            String renditionFilter,
            Boolean includePathSegment,
            BigInteger maxItems,
            BigInteger skipCount,
            ExtensionData extension) {
        ObjectInFolderList objectInFolderList = new ObjectInFolderList();
        objectInFolderList.setObjects(List.of());
        objectInFolderList.setNumItems(BigInteger.ZERO);
        objectInFolderList.setHasMoreItems(false);
        return objectInFolderList;
    }
}
