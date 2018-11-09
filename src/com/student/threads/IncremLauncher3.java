package com.student.threads;

public abstract class IncremLauncher3 implements Runnable {
    Thread t;
    static int integer;

    public IncremLauncher3() {
        t = new Thread(this);
        t.start();
    }

    public static void main(String[] args) {
        Object monitor = new Object();

        new IncrementingThread(monitor);
        new PrintingThread(monitor);
    }
}

class IncrementingThread extends IncremLauncher3 {
    private final Object monitor;

    IncrementingThread(Object monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        synchronized (monitor) {
            for (int i = 0; i < 1000000; i++) {
                integer++;
            }
        }
    }
}

class PrintingThread extends IncremLauncher3 {
    private final Object monitor;

    PrintingThread(Object monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        synchronized (monitor) {
            System.out.println(integer);
        }
    }
}