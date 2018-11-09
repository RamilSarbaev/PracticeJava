package com.student.threads;

class A {
    public synchronized void first(B b) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " has entered in method A.first()");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println("Interrupted!");
        }

        System.out.println(name + " trying to call method B.last()");
        b.last();
    }

    public synchronized void last() {
        System.out.println("In last() method of A class.");
    }
}

class B {
    public synchronized void first(A a) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " has entered in method B.first()");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println("Interrupted!");
        }

        System.out.println(name + " trying to call method A.last()");
        a.last();
    }

    public synchronized void last() {
        System.out.println("In last() method of B class.");
    }
}

public class Deadlock implements Runnable {
    private A a = new A();
    private B b = new B();

    Deadlock() {
        Thread.currentThread().setName("Main thread");

        Thread t = new Thread(this, "Concurrent thread");
        t.start();

        a.first(b);
        System.out.println("Back in main thread");
    }

    @Override
    public void run() {
        b.first(a);
        System.out.println("Back in other thread");
    }

    public static void main(String[] args) {
        new Deadlock();
    }
}
