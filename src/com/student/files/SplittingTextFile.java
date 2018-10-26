package com.student.files;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SplittingTextFile {

    private static void splitTextFile(Path source, Path destFor30, Path destFor70) throws IOException {
        byte[] bytes = Files.readAllBytes(source);
        String text = new String(bytes);

        Double lengthFor30 = (double) text.length() / 100 * 30;

        String textFor30 = text.substring(0, lengthFor30.intValue());
        String textFor70 = text.substring(lengthFor30.intValue());

        Files.write(destFor30, textFor30.getBytes());
        Files.write(destFor70, textFor70.getBytes());
    }

    public static void main(String[] args) {
        Path source = Paths.get("test1.txt");
        Path destFor30 = Paths.get("test2.txt");
        Path destFor70 = Paths.get("test3.txt");

        try {
            splitTextFile(source, destFor30, destFor70);
        } catch (IOException ex) {
            System.out.println("Error! " + ex);
        }
    }
}
