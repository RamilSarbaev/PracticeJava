package com.student.secondtask;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class IntPieceOfData {

    public static final String FILE_NAME = "int_piece_file.txt";

    //print int piece of data in source file
    private void getIntPiece(File source) throws IOException {
        try (DataInputStream din = new DataInputStream(new FileInputStream(source))) {
            Long offset = din.readLong();
            din.skipBytes(offset.intValue());

            while (din.available() > 0) {
                System.out.print(din.readInt() + " ");
            }
        }
    }

    public static void main(String[] args) {
        File source = new File(FILE_NAME);

        IntPieceOfData obj = new IntPieceOfData();

        System.out.println("Int piece of data in File: ");

        try {
            obj.getIntPiece(source);
        } catch (IOException ex) {
            System.out.println("Error! " + ex);
        }
    }
}
