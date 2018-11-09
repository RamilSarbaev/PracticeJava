package com.student.threads;

public class MySemaphore {

    public static void main(String[] args) {
        Shared monitor = new Shared();

        new IncThread(monitor, "A");
        new IncThread(monitor, "B");
    }
}

class Shared {
    int count;
    private boolean flag;

    public boolean isWait(String name) {
        if (name.equals("A")) {
            return flag;
        } else {
            return !flag;
        }
    }

    public void reverseFlag() {
        flag = !flag;
    }
}

class IncThread implements Runnable{
    private final Shared monitor;
    private String name;

    IncThread(Shared monitor, String name) {
        this.monitor = monitor;
        this.name = name;

        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Thread " + name + " is running!");

        synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++) {
                    if (monitor.isWait(name)) {
                        monitor.wait();
                    }

                    monitor.count++;
                    System.out.println(name + ": " + monitor.count);

                    monitor.reverseFlag();

                    monitor.notify();
                }
            } catch (InterruptedException ex) {
                System.out.println("Interrupted!");
            }
        }
    }
}
