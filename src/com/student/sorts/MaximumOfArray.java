package com.student.sorts;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MaximumOfArray {

    private int findMaximum(int[] arr) {
        Arrays.sort(arr);

        return arr[arr.length - 1];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        MaximumOfArray obj = new MaximumOfArray();

        System.out.print("Input a count of numbers: ");

        try {
            int n = in.nextInt();
            int[] numbers = new int[n];

            System.out.println("Input a " + n + " numbers: ");

            for (int i = 0; i < n; i++) {
                numbers[i] = in.nextInt();
            }

            System.out.println("The maximum element of an array is " + obj.findMaximum(numbers) );
        } catch (NegativeArraySizeException | InputMismatchException ex) {
            System.out.println("Error!" + ex);
        }
    }
}
