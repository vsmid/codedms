package hr.codenamecode.codedms.service;

import hr.codenamecode.codedms.data.enums.BaseTypeId;
import hr.codenamecode.codedms.data.enums.IncludeRelationships;
import hr.codenamecode.codedms.data.enums.VersioningState;
import hr.codenamecode.codedms.data.extensions.ExtensionData;
import hr.codenamecode.codedms.data.objects.Acl;
import hr.codenamecode.codedms.data.objects.ContentStream;
import hr.codenamecode.codedms.data.objects.ObjectData;
import hr.codenamecode.codedms.data.objects.Properties;
import hr.codenamecode.codedms.exceptions.CmisNotSupportedException;
import hr.codenamecode.codedms.mapper.ObjectDataMapper;
import hr.codenamecode.codedms.security.PreAuthorize;
import hr.codenamecode.codedms.utils.ObjectDataFactory;
import hr.codenamecode.codedms.utils.TypeCache;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.math.BigInteger;
import java.util.List;

import static hr.codenamecode.codedms.data.enums.BasicPermission.READ;
import static hr.codenamecode.codedms.data.enums.BasicPermission.WRITE;
import static hr.codenamecode.codedms.data.repositoryinfo.PropertyIds.*;

@ApplicationScoped
public class ObjectService {

    @Inject
    private ObjectDataMapper m;

    @Inject
    @Named("typeCache")
    private TypeCache typeCache;

    @PreAuthorize(
            objectIdArgIndex = 1,
            permission = READ
    )
    public ObjectData getObject(
            String repositoryId,
            String objectId,
            String filter,
            Boolean includeAllowableActions,
            IncludeRelationships includeRelationships,
            String renditionFilter,
            Boolean includePolicyIds,
            Boolean includeAcl,
            ExtensionData extension) {
        ObjectData objectData = ObjectDataFactory.createBaseObjectData(BaseTypeId.CMIS_FOLDER.value(), typeCache);

        objectData.getProperties().getValue(OBJECT_ID);

        objectData.getProperties().setValue(OBJECT_ID, objectId);
        objectData.getProperties().setValue(OBJECT_TYPE_ID, BaseTypeId.CMIS_FOLDER.value());
        objectData.getProperties().setValue(PATH, "/");

        return objectData;
    }

    @PreAuthorize(
            objectIdArgIndex = 2,
            permission = WRITE
    )
    public String createDocument(
            String repositoryId,
            Properties properties,
            String folderId,
            ContentStream contentStream,
            VersioningState versioningState,
            List<String> policies,
            Acl addAces,
            Acl removeAces,
            ExtensionData extension) {
        throw new CmisNotSupportedException();
    }

    @PreAuthorize(
            objectIdArgIndex = 2,
            permission = WRITE
    )
    public String createFolder(
            String repositoryId,
            Properties properties,
            String folderId,
            List<String> policies,
            Acl addAces,
            Acl removeAces,
            ExtensionData extension) {
        throw new CmisNotSupportedException();
    }

    @PreAuthorize(
            objectIdArgIndex = 1,
            permission = WRITE
    )
    public void deleteObject(String repositoryId, String objectId, Boolean allVersions, ExtensionData extension) {
        throw new CmisNotSupportedException();
    }

    @PreAuthorize(
            objectIdArgIndex = 1,
            permission = READ
    )
    public ContentStream getContentStream(String repositoryId, String objectId, String streamId, BigInteger offset,
                                          BigInteger length, ExtensionData extension) {
        throw new CmisNotSupportedException();
    }

}
