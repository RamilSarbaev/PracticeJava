package com.student.files;

import java.io.*;

public class Copy {

    private static void copyFiles(File source, File dest) throws IOException {
        try (InputStream is = new FileInputStream(source);
             OutputStream os = new FileOutputStream(dest)) {

            byte[] buffer = new byte[1024];
            int length;

            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        }
    }

    public static void main(String[] args) {
        File source = new File("test1.txt");
        File destination = new File("test2.txt");

        try {
            copyFiles(source, destination);
        } catch (IOException ex) {
            System.out.println("Error!" + ex);
        }

    }
}
