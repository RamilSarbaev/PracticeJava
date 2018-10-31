package com.student.threads;

public class IncrementingInteger3 extends Thread {

    protected static int integer;

    public static void main(String[] args) {
        Object object = new Object();

        IncrementingThread thread1 = new IncrementingThread(object);
        PrintingThread thread2 = new PrintingThread(object);

        thread1.start();
        thread2.start();
    }
}

class IncrementingThread extends IncrementingInteger3 {
    private final Object object;

    public IncrementingThread(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        synchronized (object) {
            for (int i = 0; i < 1000000; i++) {
                integer++;
            }
        }
    }
}

class PrintingThread extends IncrementingInteger3 {
    private final Object object;

    public PrintingThread(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        synchronized (object) {
            System.out.println(integer);
        }
    }
}