package com.student.files;

import java.io.File;
import java.io.FilenameFilter;

public class ListOfTxtFiles {

    public static final String DIR_NAME = "/Users/Administrator/IdeaProjects/PracticeJavaSarbaev";
    public static final String FILE_NAME = ".txt";

    static class extFilter implements FilenameFilter {
        String ext;

        public extFilter(String ext) {
            this.ext = ext;
        }

        @Override
        public boolean accept(File dir, String name) {
            return name.endsWith(ext);
        }
    }

    public static void main(String[] args) {
        File file = new File(DIR_NAME);

        if (!file.exists()) {
            System.out.println("Directory not exists!");
            System.exit(1);
        }

        File[] fileNames = file.listFiles(new extFilter(FILE_NAME));

        System.out.println("Files with .txt extension in " + DIR_NAME + ": ");

        if (fileNames != null) {
            for (File name : fileNames) {
                System.out.println(name.getName());
            }
        }
    }
}
