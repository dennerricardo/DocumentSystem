package dev.studying;

import java.io.File;
import java.util.*;

public class DocumentManagementSystem {
    private final Map<String, Importer> extensionToImporter = new HashMap<>();
    private final List<Document> documents = new ArrayList<>();

    public DocumentManagementSystem() {
        extensionToImporter.put("jpg", new ImageImporter());  // only .jpg reaches here
        extensionToImporter.put("letter", new LetterImporter());  // only .letter reaches here
        extensionToImporter.put("report", new ReportImporter()); // only .report reaches here
    }

    public void importFile(String path) throws Exception{
        File file = new File(path);
        String ext = getExtension(file.getName());
        Importer  importer = extensionToImporter.get(ext);
        if(importer == null) throw new IllegalArgumentException("Unknown file type: " + path);
        documents.add(importer.importFile(file));
    }

    public List<Document> getDocuments(){
        return Collections.unmodifiableList(documents);
    }

    private String getExtension(String name){
        int dot = name.lastIndexOf('.');
        return dot == - 1 ? "" : name.substring(dot+1).toLowerCase();
    }
}
