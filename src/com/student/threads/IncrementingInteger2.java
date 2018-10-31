package com.student.threads;

class SomeThread2 extends Thread {
    private static int integer;

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 1000000; i++) {
                integer++;
            }

            System.out.println(integer);
        }
    }
}


public class IncrementingInteger2 {

    public static void main(String[] args) {
        SomeThread2 thread1 = new SomeThread2();
        SomeThread2 thread2 = new SomeThread2();

        thread1.start();
        thread2.start();
    }
}
