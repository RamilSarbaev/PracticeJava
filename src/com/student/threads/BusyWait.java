package com.student.threads;

class SleepingThread extends BusyWait {
    private final Object monitor;

    public SleepingThread(Object monitor) {
        this.monitor = monitor;

        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("SleepingThread is running!");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            System.out.println("Interrupted!");
        }

        //synchronized (monitor) {
        flag = true;
        //    monitor.notifyAll();

        System.out.println("FLAG sets to TRUE.");
        //}
    }
}

class WatchingThread extends BusyWait {
    private final Object monitor;

    public WatchingThread(Object monitor) {
        this.monitor = monitor;

        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("WatchingThread is running!");

        while (true) {
            if (flag) {
                flag = false;
                break;
            }
        }

        System.out.println("FLAG sets back to FALSE.");
    }

/*    @Override
    public void run() {
        System.out.println("WatchingThread is running!");

        synchronized (monitor) {
            try {
                monitor.wait();
            } catch (InterruptedException ex) {
                System.out.println("Interrupted!");
            }
        }

        flag = false;

        System.out.println("FLAG sets back to FALSE.");
    }*/
}

public abstract class BusyWait implements Runnable {
    volatile static boolean flag;

    public static void main(String[] args) {
        Object monitor = new Object();

        new WatchingThread(monitor);
        new SleepingThread(monitor);
    }
}
