package com.student.strings;

import java.util.Arrays;
import java.util.Scanner;

public class Anagrams {

    private boolean isAnagram(String str1, String str2) {

        char[] a = str1.toLowerCase().replaceAll("\\s+", "").toCharArray();
        char[] b = str2.toLowerCase().replaceAll("\\s+", "").toCharArray();

        if (a.length != b.length) {
            return false;
        }

        Arrays.sort(a);
        Arrays.sort(b);

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter a first string: ");
        String str1 = in.nextLine();

        System.out.println("Enter a second string: ");
        String str2 = in.nextLine();

        Anagrams obj = new Anagrams();
        boolean res = obj.isAnagram(str1, str2);

        System.out.println( res ? "Anagram." : "Non Anagram.");
    }
}
