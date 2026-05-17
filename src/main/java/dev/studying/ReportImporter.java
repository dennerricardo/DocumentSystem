package dev.studying;

import java.io.File;
import java.util.Map;

public class ReportImporter implements Importer{
    @Override
    public Document importFile(File file) throws Exception {
        return new Document(Map.of("type","LETTER","path", file.getAbsolutePath()));
    }
}
