package com.student.sorts;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ArraysSort {

    private int[] sort(int[] arr) {


        return arr;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArraysSort obj = new ArraysSort();

        System.out.print("Input a count of numbers: ");

        try {
            int n = in.nextInt();
            int[] numbers = new int[n];

            System.out.println("Input a " + n + " numbers: ");

            for (int i = 0; i < n; i++) {
                numbers[i] = in.nextInt();
            }

            System.out.println("Sorted array: " + Arrays.toString(obj.sort(numbers)));
        } catch (NegativeArraySizeException | InputMismatchException ex) {
            System.out.println("Error!" + ex);
        }
    }
}
