package com.github.ununmul.files;

import com.github.ununmul.model.PasswordEntry;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.emptyList;

public class FilesFacade {
    private FileReader fileReader;

    private CsvWriter passwordEntryFileWriter;

    public FilesFacade() {
        fileReader = new LinesFileReader();
        passwordEntryFileWriter = new CsvWriter();
    }

    public List<String> readFile (String path) {
        try {
            return fileReader.read(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return emptyList();
    }


    public List<PasswordEntry> getEntries(String path) {
        try {
            return fileReader.getPasswordEntries(path);
        } catch (IOException e) {
            return emptyList();
        }
    }

    public void writeToFile(String fileName, List<PasswordEntry> passwordEntries) {
        try {
            passwordEntryFileWriter.csvWriter(fileName, passwordEntries);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
