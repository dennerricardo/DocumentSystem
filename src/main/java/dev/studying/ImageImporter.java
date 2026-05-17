package dev.studying;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ImageImporter implements Importer{
    @Override
    public Document importFile(File file) throws Exception {
        /*
        - VIOLATION: strengthened precondition
        - The interface says "any File". We are adding a new restriction.

        if(!file.getName().endsWith(".jpg")){
            throw new IllegalArgumentException(
                    "Image importer only accepts .jpg files! Got: " + file.getName()
            );
        }
        */


        // No precondition check. The system routes correctly.
        // This method trusts that it will only be called with appropriate files.

        Map<String, String> attributes = new HashMap<>();
        attributes.put("type","IMAGE");
        attributes.put("path", file.getAbsolutePath());
        //This is a regular expression that removes the extension vvvvvvvvvvv
        attributes.put("patient", file.getName().replaceAll("\\.[^.]+$",""));
        return new Document(attributes);
    }
}
