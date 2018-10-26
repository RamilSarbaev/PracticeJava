package com.student.strings;

import java.util.Scanner;

public class Initials {

    private void print(String[] names) {
        for (String name : names) {
            if (!name.isEmpty()) {
                System.out.print(name.substring(0, 1) + ".");
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter your first name and last name: ");

        String[] names = in.nextLine().split("\\s+");

        System.out.print("Your initials is ");

        Initials initials = new Initials();
        initials.print(names);
    }
}
