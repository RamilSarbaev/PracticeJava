package com.student.strings;

import java.util.Scanner;

public class StringConverter {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter a hexadecimal string: ");
        String hex = in.nextLine();

        try {
            int decimal = Integer.parseInt(hex, 16);

            System.out.println("Decimal value is " + decimal);
        } catch (NumberFormatException ex) {
            System.out.println("Error!" + ex);
        }
    }
}
