package com.student.secondtask;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class FilesInFolder {

    //returns list of String that contains all files in directory
    public List<String> get(String fileName) throws IOException {
        DirectoryStream<Path> directory = Files.newDirectoryStream(Paths.get(fileName));
        List<String> files = new LinkedList<>();

        for (Path path : directory) {
            files.add(path.getFileName().toString());
        }

        files.sort(Comparator.reverseOrder());

        return files;
    }

    public static void main(String[] args) {
        FilesInFolder files = new FilesInFolder();
        String folderName = args[0];

        System.out.println("Files and Folders in " + folderName);

        try {
            for (String s : files.get(folderName)) {
                System.out.println(s);
            }
        } catch (IOException ex) {
            System.out.println("Error! " + ex);
        }
    }
}
