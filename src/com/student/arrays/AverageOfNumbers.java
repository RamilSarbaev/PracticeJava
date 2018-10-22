package com.student.arrays;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AverageOfNumbers {

    private int findAverage(int[] arr) {
        int sum = 0;

        for (int a : arr) {
            sum += a;
        }

        return sum / arr.length;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        AverageOfNumbers obj = new AverageOfNumbers();

        System.out.print("Input a count of numbers: ");

        try {
            int n = in.nextInt();
            int[] numbers = new int[n];

            System.out.println("Input a " + n + " numbers: ");

            for (int i = 0; i < n; i++) {
                numbers[i] = in.nextInt();
            }

            System.out.println("The average of all numbers is " + obj.findAverage(numbers));
        } catch (NegativeArraySizeException | InputMismatchException ex) {
            System.out.println("Error!" + ex);
        }
    }
}
