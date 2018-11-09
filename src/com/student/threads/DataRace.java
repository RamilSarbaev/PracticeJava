package com.student.threads;

public class DataRace implements Runnable {
    private static int count;

    public static void main(String[] args) {
        DataRace dataRace = new DataRace();

        new Thread(dataRace).start();
        new Thread(dataRace).start();
        new Thread(dataRace).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            count++;
        }

        System.out.println(count);
    }
}
