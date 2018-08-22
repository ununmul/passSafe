package com.github.ununmul.files;

import com.github.ununmul.model.PasswordEntry;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

abstract public class AbstractFileReader implements FileReader {

    private static String PATH = "C:\\PasswordManager\\storage";

    File getFile(String path) {
        if (path == null) {
            throw new IllegalArgumentException("May not be null");
        }
        path = PATH + "\\" + path;
        return Paths.get(path).toFile();
    }

    @Override
    public List<PasswordEntry> getPasswordEntries(String path) throws IOException {
        List<PasswordEntry> result = new ArrayList<>();
        List<String> lines = read(path);

        for (String line : lines) {
            String[] splitResult = line.split(";");
            PasswordEntry passwordEntry = new PasswordEntry(splitResult[0], splitResult[1], splitResult[2]);
            result.add(passwordEntry);
        }
        return result;
    }

    @Override
    public abstract List<String> read(String path) throws IOException;
}
