package com.student.secondtask;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CounterOfLines {

    //returns number of lines in file
    public int getCount(String fileName) throws IOException {
        Path path = Paths.get(fileName);

        if (!Files.isReadable(path)) {
            return -1;
        }

        return Files.readAllLines(path).size();
    }

    public static void main(String[] args) {
        CounterOfLines counter = new CounterOfLines();

        try {
            for (String fileName : args) {
                int linesCount = counter.getCount(fileName);

                if (linesCount == -1) {
                    System.out.println(fileName + " ERROR! File not readable!");
                } else {
                    System.out.println(fileName + " | lines: " + linesCount);
                }
            }
        } catch (IOException ex) {
            System.out.println("Error! " + ex);
        }
    }
}
