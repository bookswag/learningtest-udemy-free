package com.bookswag.thread.ch3.phase3;

public class App {

    private int count = 0;

    private synchronized void increment() { // it's guarantee correct state
        count++;
    }

    public static void main(String[] args) {
        App app = new App();
        app.doWork();
    }

    public void doWork() {
        Thread t1 = new Thread(() -> {
           for(int i=0 ; i<10_000 ;i++) {
               increment();
           }
        });

        Thread t2 = new Thread(() -> {
            for(int i=0 ; i<10_000 ;i++) {
                increment();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Count is : " + count);
    }
}
