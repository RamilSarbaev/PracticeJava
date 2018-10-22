package com.student.sorts;

import java.util.Scanner;

public class SimpleSort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Input a, b, c: ");

        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

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
}
