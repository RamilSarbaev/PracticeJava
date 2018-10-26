package com.student.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class LinkedListStore {

    public static final String FILE_NAME = "test.txt";

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        try {
            Scanner in = new Scanner(new File(FILE_NAME));

            while (in.hasNext()) {
                list.add(in.nextLine());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Error! " + ex);
        }

        while (list.size() != 0) {
            System.out.println(list.removeLast());
        }
    }
}
