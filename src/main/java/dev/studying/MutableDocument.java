package dev.studying;

import java.util.HashMap;
import java.util.Map;

public class MutableDocument extends Document {
    private final Map<String, String > mutableAttributes = new HashMap<>();

    public MutableDocument(Map<String, String> attributes) {
        super(attributes);
        this.mutableAttributes.putAll(attributes);
    }

    public void setAttribute(String name, String value){
        mutableAttributes.put(name, value);
    }

    @Override
    public String getAttribute(String name){
        return mutableAttributes.get(name);
    }
}
