package dev.studying;

import java.io.File;

public interface Importer {
    Document importFile(File file) throws Exception;
}
