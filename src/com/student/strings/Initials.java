package com.student.strings;

import java.util.Scanner;

public class Initials {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter your first name and last name: ");

        String[] names = in.nextLine().split("\\s+");

        System.out.print("Your initials is ");

        for (String name : names) {
            if (!name.isEmpty())
                System.out.print(name.substring(0, 1) + ".");
        }
    }
}
