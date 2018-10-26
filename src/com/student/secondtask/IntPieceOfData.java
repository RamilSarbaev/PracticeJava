package com.student.secondtask;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IntPieceOfData {

    public static final String FILE_NAME = "int_piece_file.txt";

    private void getIntPiece(File source) throws IOException {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(source))) {
            long off = dis.readLong();

            List<Integer> list = new ArrayList<>();

            dis.skipBytes((int) off);

            while (dis.available() > 0) {
                int num = dis.readInt();
                list.add(num);
            }

            System.out.println(list);
        }
    }

    public static void main(String[] args) {
        File source = new File(FILE_NAME);

        IntPieceOfData obj = new IntPieceOfData();
        try {
            obj.getIntPiece(source);
        } catch (IOException ex) {
            System.out.println("Error! " + ex);
        }


    }
}
