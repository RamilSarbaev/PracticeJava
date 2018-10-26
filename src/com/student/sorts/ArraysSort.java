package com.student.sorts;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ArraysSort {

    private int[] sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean isSwapped = false;

            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;

                    isSwapped = true;
                }
            }

            if (!isSwapped)
                break;
        }

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
