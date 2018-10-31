package com.student.secondtask;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AppendingString {

    public void append(String fileName, String text, String position) throws IOException {
        Path path = Paths.get(fileName);

        int offset = Integer.parseInt(position) - 1;

        byte[] bytes = Files.readAllBytes(path);
        String string = new String(bytes);

        String substr1 = string.substring(0, offset);
        String substr2 = string.substring(offset);

        string = substr1 + text + substr2;

        Files.write(path, string.getBytes());
    }

    public static void main(String[] args) {
        AppendingString string = new AppendingString();

        try {
            string.append(args[0], args[1], args[2]);
        } catch (IOException ex) {
            System.out.println("Error! " + ex);
        }
    }
}
