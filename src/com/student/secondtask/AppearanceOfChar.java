package com.student.secondtask;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AppearanceOfChar {

    public static final String FILE_NAME = "test.txt";

    //returns number of appearances by char C in Source file
    private int computeAppearances(Path source, char c) throws IOException {
        byte[] bytes = Files.readAllBytes(source);
        String text = new String(bytes);

        int count = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == c)
                count++;
        }

        return count;
    }

    public static void main(String[] args) {
        char character = args[0].charAt(0);

        Path source = Paths.get(FILE_NAME);

        AppearanceOfChar obj = new AppearanceOfChar();

        try {
            int count = obj.computeAppearances(source, character);

            System.out.println("Count of an appearances by character '" + character + "' is " + count);
        } catch (IOException ex) {
            System.out.println("Error! " + ex);
        }
    }
}
