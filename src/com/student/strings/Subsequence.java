package com.student.strings;

import java.util.Scanner;

public class Subsequence {

    private void isSubstring(String string, String substring) {
        boolean isSubstring = string.contains(substring);

        System.out.println(isSubstring ? "String CONTAINS a given substring." :
                "String NOT CONTAINS a given substring.");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter a string: ");
        String string = in.nextLine();

        System.out.println("Enter a substring: ");
        String substring = in.nextLine();

        Subsequence s = new Subsequence();
        s.isSubstring(string, substring);
    }
}
