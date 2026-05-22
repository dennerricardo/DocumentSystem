package dev.studying;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class BadReportImporter implements Importer{

    @Override
    public Document importFile(File file) throws Exception{
        Map<String, String > attrs = new HashMap<>();
        attrs.put("type", "REPORT");
        attrs.put("path", file.getAbsolutePath());
        attrs.put("patient", file.getName().replaceAll("\\.[^.]+$",""));

        MutableDocument doc = new MutableDocument(attrs);
        return doc;

    }
}
