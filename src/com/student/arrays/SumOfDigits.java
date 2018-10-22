package com.student.arrays;

import java.util.Scanner;

public class SumOfDigits {

    private long calculateSum(char[] arr) {
        int sum = 0;

        for (char c : arr) {
            int tmp = Character.digit(c, 10);

            if (tmp == -1)
                continue;

            sum += tmp;
        }

        return (long) sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        SumOfDigits obj = new SumOfDigits();

        System.out.println("Input a digits: ");

        char[] array = in.nextLine().trim().toCharArray();

        System.out.println("The sum of digits: " + obj.calculateSum(array));
    }
}
