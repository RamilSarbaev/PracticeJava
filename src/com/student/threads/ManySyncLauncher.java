package com.student.threads;


public class ManySyncLauncher implements Runnable{

    public static void main(String[] args) {
        ManySyncLauncher launcher = new ManySyncLauncher();
        Thread t = new Thread(launcher);

        t.start();
    }

    @Override
    public void run() {
        doSomething1();
    }

    public synchronized void doSomething1() {
        doSomething2();

        System.out.println("Inside doSomething1 method.");
    }

    public synchronized void doSomething2() {
        doSomething3();

        System.out.println("Inside doSomething2 method.");
    }

    public synchronized void doSomething3() {
        System.out.println("Inside doSomething3 method.");
    }
}
