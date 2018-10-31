package com.student.secondtask;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class ListOfWords {

    public static final String FILE_NAME = "test.txt";

    //returns String array of all words in file
    public String[] get() throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(FILE_NAME));
        String[] words = new String(bytes).split("\\s+");

        Arrays.sort(words);

        return words;
    }

    public static void main(String[] args) {
        System.out.println("An alphabetical list of all the words in " + FILE_NAME + ": ");

        ListOfWords listOfWords = new ListOfWords();

        try {
            for (String s : listOfWords.get()) {
                System.out.println(s);
            }
        } catch (IOException ex) {
            System.out.println("Error! " + ex);
        }
    }
}
