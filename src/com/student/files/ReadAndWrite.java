package com.student.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadAndWrite {

    public static final String FILE_NAME1 = "test1.txt";
    public static final String FILE_NAME2 = "test2.txt";

    private void modifyText(Path source, Path dest) throws IOException {
        byte[] bytes = Files.readAllBytes(source);

        String text = new String(bytes);
        text = text.toUpperCase().replaceAll(" ", "  ");

        Files.write(dest, text.getBytes());
    }

    public static void main(String[] args) {
        Path source = Paths.get(FILE_NAME1);
        Path destination = Paths.get(FILE_NAME2);

        ReadAndWrite obj = new ReadAndWrite();

        try {
            obj.modifyText(source, destination);
        } catch (IOException ex) {
            System.out.println("Error! " + ex);
        }
    }
}
