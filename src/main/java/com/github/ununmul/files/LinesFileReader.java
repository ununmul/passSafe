package com.github.ununmul.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LinesFileReader extends AbstractFileReader {

    @Override
    public List<String> read(String path) throws IOException {

        File file = getFile(path);
        List<String> list = new ArrayList<String>();

        try (BufferedReader czytnik = new BufferedReader(new FileReader(path))) {
            String linia = czytnik.readLine();
            while ((linia) != null) {
                list.add(linia);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

}
