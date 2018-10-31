package com.student.threads;

class SomeThread extends Thread {

    public SomeThread() {
        System.out.println("Start-up message in SomeThread.");
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Run method in SomeThread.");

            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("Error! " + ex);
            }
        }
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Shut-down message in SomeThread.");
    }
}

public class ThreadWithGC extends Thread {

    @Override
    public void run() {
        System.gc();
        System.runFinalization();

        System.out.println("Called gc() and runFinalization() in ThreadWithGC");
    }

    public static void main(String[] args) {
        SomeThread someThread = new SomeThread();
        ThreadWithGC threadWithGC = new ThreadWithGC();

        someThread.start();
        threadWithGC.start();
    }
}
