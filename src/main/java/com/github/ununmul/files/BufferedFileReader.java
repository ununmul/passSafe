package com.github.ununmul.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BufferedFileReader extends AbstractFileReader {

    @Override
    public List<String> read(String path) throws IOException {
        File file = getFile(path);

        List<String> result = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
            String line = reader.readLine();
            while (line != null) {
                result.add(line);
                line = reader.readLine();
            }
        }
        return result;
    }
    /*
    @Override
    public List<String> read(String path) throws IOException {
        File file = getFile(path);
        List<String> list = new ArrayList<String>();

        try (Scanner skaner = new Scanner(file)) {
            String linia;
            while ((linia = skaner.nextLine()) != null) {
                list.add(linia);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    } */
}
