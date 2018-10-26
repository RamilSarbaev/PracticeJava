package com.student.files;

import java.io.*;

public class Copy {

    public static final String SOURCE_NAME = "test1.txt";
    public static final String DESTINATION_NAME = "test2.txt";

    private void copyFiles(File source, File dest) throws IOException {
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
        File source = new File(SOURCE_NAME);
        File destination = new File(DESTINATION_NAME);

        Copy obj = new Copy();

        try {
            obj.copyFiles(source, destination);
        } catch (IOException ex) {
            System.out.println("Error!" + ex);
        }

    }
}
