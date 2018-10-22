package com.student.arrays;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SmallestDistance {

    private int findSmallestDistance(int[] arr) {
        int index = 0;
        int min = Math.abs(arr[0] - arr[1]);

        for (int i = 1; i < arr.length - 1; i++) {
            int tmp = Math.abs(arr[i] - arr[i + 1]);

            if (tmp < min) {
                min = tmp;
                index = i;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        SmallestDistance obj = new SmallestDistance();

        System.out.println("Input a count of elements: ");

        try {
            int n = in.nextInt();
            int[] array = new int[n];

            System.out.println("Input " + n + " digits: ");

            for (int i = 0; i < n; i++) {
                array[i] = in.nextInt();
            }

            System.out.println("The index of smallest distance is " + obj.findSmallestDistance(array));
        } catch (NegativeArraySizeException | InputMismatchException ex) {
            System.out.println("Error!" + ex);
        }

    }
}
