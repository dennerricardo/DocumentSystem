package dev.studying;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Document {

    private final Map<String, String> attributes;

    public Document(Map<String, String> attributes){
        this.attributes = Collections.unmodifiableMap(new HashMap<>(attributes));
    }

    public String getAttribute(String name){
        return attributes.get(name);
    }

    @Override
    public String toString() {
        return "Document" + attributes ;
    }

}
