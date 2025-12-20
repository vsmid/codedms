package hr.codenamecode.codedms.service;

import hr.codenamecode.codedms.data.enums.AclPropagation;
import hr.codenamecode.codedms.data.extensions.ExtensionData;
import hr.codenamecode.codedms.data.objects.Acl;
import hr.codenamecode.codedms.exceptions.CmisNotSupportedException;
import hr.codenamecode.codedms.security.PreAuthorize;
import jakarta.enterprise.context.ApplicationScoped;

import static hr.codenamecode.codedms.data.enums.BasicPermission.WRITE;

@ApplicationScoped
public class AclService {

    @PreAuthorize(
            objectIdArgIndex = 1,
            permission = WRITE
    )
    public Acl applyAcl(
            String repositoryId,
            String objectId,
            Acl addAces,
            Acl removeAces,
            AclPropagation aclPropagation,
            ExtensionData extension) {
        throw new CmisNotSupportedException();
    }
}
