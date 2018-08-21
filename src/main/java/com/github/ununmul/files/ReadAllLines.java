package com.github.ununmul.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadAllLines extends AbstractFileReader {

    @Override
    public List<String> read(String path) throws IOException {

        File file = getFile(path);
        List<String> list = new ArrayList<String>();
        Path path1 = file.toPath();
        Charset charset = Charset.forName("ISO-8859-1");

        try {
            list = Files.readAllLines(path1, charset);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

}
