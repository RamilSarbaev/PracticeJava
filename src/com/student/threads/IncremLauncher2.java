package com.student.threads;

class Incrementor implements Runnable {
    private static int integer;

    private final Object obj;
    private Thread t;

    public Incrementor(Object obj) {
        this.obj = obj;

        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        synchronized (obj) {
            for (int i = 0; i < 1000000; i++) {
                integer++;
            }

            System.out.println(integer);
        }
    }
}


public class IncremLauncher2 {

    public static void main(String[] args) {
        Object monitor = new Object();

        new Incrementor(monitor);
        new Incrementor(monitor);
    }
}
