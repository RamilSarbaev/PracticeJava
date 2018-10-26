package com.student.strings;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GetCharByIndex {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the string: ");
        String string = in.nextLine();

        if (string.isEmpty()) {
            System.out.println("String is empty!");
            System.exit(1);
        }

        System.out.print("Enter index of character (0 - " + (string.length() - 1) + "): ");

        try {
            int index = in.nextInt();

            System.out.println("The character at given index - " + string.charAt(index));
        } catch (InputMismatchException | StringIndexOutOfBoundsException ex) {
            System.out.println("Error! " + ex);
        }

    }
}
