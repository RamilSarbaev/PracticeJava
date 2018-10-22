package com.student.arrays;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MultiTable {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Input a number N: ");

        try {
            int n = in.nextInt();

            System.out.println("Multiplication table for all numbers from 1 to N: ");

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    System.out.printf("%d\t", i * j);
                }

                System.out.println();
            }
        } catch (InputMismatchException ex) {
            System.out.println("Error!" + ex);
        }
    }
}
