package dev.studying;

import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception {
        // This is exactly what DocumentManagementSystem does internally —
        // it holds an Importer reference and calls importFile blindly.
        Importer importer = new LetterImporter();

//        // Works fine:
//        System.out.println("Importing patient-xray.jpg...");
//        System.out.println(importer.importFile(new java.io.File("patient-xray.jpg")));
//
//        // NOW: substitute any other file — which the interface contract allows.
//        // The caller knows only about Importer, not ImageImporter.
//        System.out.println("\nImporting patient-notes.letter...");
//        System.out.println(importer.importFile(new java.io.File("patient-notes.letter")));


        Document doc = importer.importFile(new File("john-smith.letter"));
        System.out.println("Type:   "+ doc.getAttribute("type"));
        System.out.println("Path:   "+ doc.getAttribute("path"));
        System.out.println("Patient:   "+ doc.getAttribute("patient"));

        String path = doc.getAttribute("path");
        System.out.println("\nFile name length: "+ path.length());

    }
}
