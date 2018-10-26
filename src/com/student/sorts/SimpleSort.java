package com.student.sorts;

import java.util.Scanner;

public class SimpleSort {

    private void sort(int a, int b, int c) {
        int tmp;

        if (a > b) {
            tmp = a;
            a = b;
            b = tmp;

            if (b > c) {
                tmp = b;
                b = c;
                c = tmp;

                if (a > b) {
                    tmp = a;
                    a = b;
                    b = tmp;
                }
            }
        } else if (b > c) {
            tmp = b;
            b = c;
            c = tmp;

            if (a > b) {
                tmp = a;
                a = b;
                b = tmp;
            }
        }

        System.out.println(a + " " + b + " " + c);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Input a, b, c: ");

        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        SimpleSort obj = new SimpleSort();
        obj.sort(a, b, c);
    }
}
