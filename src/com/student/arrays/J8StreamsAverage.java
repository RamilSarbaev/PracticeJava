package com.student.arrays;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.OptionalDouble;
import java.util.Scanner;
import java.util.stream.IntStream;

public class J8StreamsAverage {

    private int findAverageWStream(int[] arr) {
        IntStream intStream = Arrays.stream(arr);
        OptionalDouble average = intStream.average();

        if (average.isPresent())
            return (int) average.getAsDouble();

        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        J8StreamsAverage obj = new J8StreamsAverage();

        System.out.print("Input a count of numbers: ");

        try {
            int n = in.nextInt();
            int[] numbers = new int[n];

            System.out.println("Input a " + n + " numbers: ");

            for (int i = 0; i < n; i++) {
                numbers[i] = in.nextInt();
            }

            System.out.println("The average of all numbers is " + obj.findAverageWStream(numbers));
        } catch (NegativeArraySizeException | InputMismatchException ex) {
            System.out.println("Error!" + ex);
        }
    }
}
