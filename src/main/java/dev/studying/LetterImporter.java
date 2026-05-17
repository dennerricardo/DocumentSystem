package dev.studying;

import java.io.File;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

public class LetterImporter implements Importer{
    @Override
    public Document importFile(File file) throws Exception {
        Map<String, String> attributes = new HashMap<>();

        // Always populate the full set of attributes the contract requires
        attributes.put("type", "LETTER");
        attributes.put("path", file.getAbsolutePath());
        attributes.put("patient", file.getName().replaceAll("\\.[^.]+$", ""));


//        String content = Files.readString(file.toPath());
//        attributes.put("body", content);


        attributes.put("body", "[simulated letter content for " + file.getName() + "]");


        return new Document(attributes);

    }
}
