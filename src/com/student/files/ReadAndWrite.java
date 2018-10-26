package com.student.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadAndWrite {

    private static void modifyText(Path source, Path dest) throws IOException {
        byte[] bytes = Files.readAllBytes(source);

        String text = new String(bytes);
        text = text.toUpperCase().replaceAll(" ", "  ");

        Files.write(dest, text.getBytes());
    }

    public static void main(String[] args) {
        Path source = Paths.get("test1.txt");
        Path destination = Paths.get("test2.txt");

        try {
            modifyText(source, destination);
        } catch (IOException ex) {
            System.out.println("Error! " + ex);
        }
    }
}
