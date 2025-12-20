package hr.codenamecode.codedms.utils;

import hr.codenamecode.codedms.data.repositoryinfo.DocumentTypeDefinition;
import hr.codenamecode.codedms.data.repositoryinfo.FolderTypeDefinition;
import hr.codenamecode.codedms.data.repositoryinfo.TypeDefinition;

import java.util.concurrent.ConcurrentHashMap;

public final class TypeCache extends ConcurrentHashMap<String, TypeDefinition> {
    public TypeCache() {
        FolderTypeDefinition folderTypeDefinition = TypeDefinitionFactory.createFolderTypeDefinition(null);
        DocumentTypeDefinition documentTypeDefinition = TypeDefinitionFactory.createDocumentTypeDefinition(null);

        put(folderTypeDefinition.getId(), folderTypeDefinition);
        put(documentTypeDefinition.getId(), documentTypeDefinition);
    }
}
