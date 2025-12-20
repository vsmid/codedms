package hr.codenamecode.codedms.service;

import hr.codenamecode.codedms.data.enums.IncludeRelationships;
import hr.codenamecode.codedms.data.extensions.ExtensionData;
import hr.codenamecode.codedms.data.objects.ObjectList;
import hr.codenamecode.codedms.exceptions.CmisNotSupportedException;
import jakarta.enterprise.context.ApplicationScoped;

import java.math.BigInteger;

@ApplicationScoped
public class DiscoveryService {

    public ObjectList query(
            String repositoryId,
            String statement,
            Boolean searchAllVersions,
            Boolean includeAllowableActions,
            IncludeRelationships includeRelationships,
            String renditionFilter,
            BigInteger maxItems,
            BigInteger skipCount,
            ExtensionData extension) {
        throw new CmisNotSupportedException();
    }
}
