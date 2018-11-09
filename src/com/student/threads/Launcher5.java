package com.student.threads;

class WaitingThread extends Thread {

    @Override
    public void run() {
        synchronized (this) {
            System.out.println("Waiting thread is running!");

            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("Interrupted!");
            }

            System.out.println("Waiting thread is completed!");
        }
    }
}

class NotifyingThread extends Thread {
    private final Thread monitor;

    public NotifyingThread(Thread monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        synchronized (monitor) {
            System.out.println("NotifyingThread run.");

            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("Interrupted!");
            }

            monitor.notifyAll();

            System.out.println("notifyAll is called.");
        }
    }
}

public class Launcher5 {

    public static void main(String[] args) {
        Thread t1 = new WaitingThread();
        Thread t2 = new NotifyingThread(t1);

        t1.start();
        t2.start();
    }
}
