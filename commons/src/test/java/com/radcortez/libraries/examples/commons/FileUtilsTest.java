package com.radcortez.libraries.examples.commons;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileUtilsTest {
    @Test
    void files(@TempDir File tempDir) throws Exception {
        InputStream inputStream = IOUtils.toInputStream("Roberto Cortez", StandardCharsets.UTF_8);
        FileUtils.copyToFile(inputStream, FileUtils.getFile(tempDir, "names.txt"));
        IOUtils.closeQuietly(inputStream, e -> {});

        Collection<File> files = FileUtils.listFiles(tempDir, new String[]{"txt"}, true);
        assertEquals(1, files.size());

        FileInputStream fileInputStream = FileUtils.openInputStream(FileUtils.getFile(tempDir, "names.txt"));
        LineIterator lineIterator = IOUtils.lineIterator(fileInputStream, StandardCharsets.UTF_8);

        while (lineIterator.hasNext()) {
            System.out.println("next = " + lineIterator.next());
        }

        IOUtils.closeQuietly(lineIterator, e -> {});
        IOUtils.closeQuietly(fileInputStream, e -> {});
    }
}
