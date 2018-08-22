package com.github.ununmul.files;

import com.github.ununmul.model.PasswordEntry;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import static com.opencsv.ICSVParser.DEFAULT_ESCAPE_CHARACTER;
import static com.opencsv.ICSVWriter.DEFAULT_LINE_END;
import static com.opencsv.ICSVWriter.DEFAULT_QUOTE_CHARACTER;

public class CsvWriter {

    private static String PATH = "C:\\PasswordManager\\storage";

    public void csvWriter(String path, List<PasswordEntry> passwordEntries) throws IOException {

        CSVWriter writer = new CSVWriter(
                new FileWriter(Paths.get(PATH + "\\" + path).toFile(), true), ';',
                DEFAULT_QUOTE_CHARACTER,
                DEFAULT_ESCAPE_CHARACTER,
                DEFAULT_LINE_END);

        for (PasswordEntry passwordEntry : passwordEntries) {
            writer.writeNext(passwordEntry.toArray());
        }

        writer.close();
    }

}
