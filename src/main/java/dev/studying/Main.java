package dev.studying;

import java.io.File;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        // This is exactly what DocumentManagementSystem does internally —
        // it holds an Importer reference and calls importFile blindly.
//        Importer importer = new LetterImporter();

//        // Works fine:
//        System.out.println("Importing patient-xray.jpg...");
//        System.out.println(importer.importFile(new java.io.File("patient-xray.jpg")));
//
//        // NOW: substitute any other file — which the interface contract allows.
//        // The caller knows only about Importer, not ImageImporter.
//        System.out.println("\nImporting patient-notes.letter...");
//        System.out.println(importer.importFile(new java.io.File("patient-notes.letter")));

//
//        Document doc = importer.importFile(new File("john-smith.letter"));
//        System.out.println("Type:   "+ doc.getAttribute("type"));
//        System.out.println("Path:   "+ doc.getAttribute("path"));
//        System.out.println("Patient:   "+ doc.getAttribute("patient"));
//
//        String path = doc.getAttribute("path");
//        System.out.println("\nFile name length: "+ path.length());


//        Importer importer = new BadReportImporter();
//
//        // The caller receives what looks like a normal Document
//        Document doc = importer.importFile(new File("annual-checkup.report"));
//        System.out.println("Before: " + doc.getAttribute("patient"));
//
//        // But if someone downstream holds a MutableDocument reference...
//        MutableDocument mutable = (MutableDocument) doc; // compiles!
//        mutable.setAttribute("patient", "TAMPERED");
//
//        // Now any OTHER code holding the same Document reference sees corrupted data
//        System.out.println("After:  " + doc.getAttribute("patient"));
//
//        // The invariant — records are permanent once imported — is broken.
//        // Multiple parts of the system now disagree on what the patient's name is
//        .

        VerifiedDocument unverified = new VerifiedDocument(
                Map.of("type", "LETTER", "path", "/records/jane.letter", "patient", "jane")
        );
        System.out.println("Verified: " + unverified.isVerified()); // false

        // Verification produces a NEW document. The old one is unchanged.
        VerifiedDocument verified = unverified.asVerified();
        System.out.println("Old doc:  " + unverified.isVerified()); // still false — unchanged
        System.out.println("New doc:  " + verified.isVerified());   // true

        // ✅ There is no unverify(). The transition is one-way by design.
        // The history of each object is permanently coherent.
    }
}
