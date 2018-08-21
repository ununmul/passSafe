package com.github.ununmul.files;

import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.*;

public class BufferedFileReaderTest {

    @Test
    public void ifFileIsReadThenPrint() {
        Path path = Paths.get("C:\\Users\\RENT\\IdeaProjects\\passSafe\\src\\main\\resources", "test.txt");
        Charset charset = Charset.forName("ISO-8859-1");

        try {
            List<String> lines = Files.readAllLines(path, charset);

            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}