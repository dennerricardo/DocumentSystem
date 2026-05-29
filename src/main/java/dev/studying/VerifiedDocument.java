package dev.studying;

import java.util.HashMap;
import java.util.Map;

public class VerifiedDocument extends Document {

    private final boolean verified;


    public VerifiedDocument(Map<String, String> attributes) {
        super(attributes);
        this.verified = false ;
    }


    public VerifiedDocument asVerified(){
        Map<String, String> updated = new HashMap<>();
        updated.put("type",   getAttribute("type"));
        updated.put("path", getAttribute("path"));
        updated.put("patient", getAttribute("patient"));
        updated.put("verified", "true") ;
        return new VerifiedDocument(updated, true);
    }

    private VerifiedDocument(Map<String, String> attributes, boolean verified) {
        super(attributes);
        this.verified = verified;
    }

    public boolean isVerified(){
        return verified;
    }
}
