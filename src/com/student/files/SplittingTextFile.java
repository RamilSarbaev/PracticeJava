package com.student.files;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SplittingTextFile {

    public static final String FILE_SOURCE_NAME = "test1.txt";
    public static final String FILE_DESTINATION1_NAME = "test2.txt";
    public static final String FILE_DESTINATION2_NAME = "test3.txt";

    private void splitTextFile(Path source, Path destFor30, Path destFor70) throws IOException {
        byte[] bytes = Files.readAllBytes(source);
        String text = new String(bytes);

        Double lengthFor30 = (double) text.length() / 100 * 30;

        String textFor30 = text.substring(0, lengthFor30.intValue());
        String textFor70 = text.substring(lengthFor30.intValue());

        Files.write(destFor30, textFor30.getBytes());
        Files.write(destFor70, textFor70.getBytes());
    }

    public static void main(String[] args) {
        Path source = Paths.get(FILE_SOURCE_NAME);
        Path destFor30 = Paths.get(FILE_DESTINATION1_NAME);
        Path destFor70 = Paths.get(FILE_DESTINATION2_NAME);

        SplittingTextFile obj = new SplittingTextFile();

        try {
            obj.splitTextFile(source, destFor30, destFor70);
        } catch (IOException ex) {
            System.out.println("Error! " + ex);
        }
    }
}
