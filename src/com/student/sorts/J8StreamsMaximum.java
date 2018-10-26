package com.student.sorts;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Stream;

public class J8StreamsMaximum {

    private int findMaximumWStream(Integer[] array) {
        Stream<Integer> intStream = Arrays.stream(array);

        Optional<Integer> max = intStream.max(Integer::compare);

        if (max.isPresent()) {
            return max.get();
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        J8StreamsMaximum obj = new J8StreamsMaximum();

        System.out.print("Input a count of numbers: ");

        try {
            int n = in.nextInt();
            Integer[] numbers = new Integer[n];

            System.out.println("Input a " + n + " numbers: ");

            for (int i = 0; i < n; i++) {
                numbers[i] = in.nextInt();
            }

            System.out.println("The maximum element of an array is " + obj.findMaximumWStream(numbers));
        } catch (NegativeArraySizeException | InputMismatchException ex) {
            System.out.println("Error!" + ex);
        }
    }
}
