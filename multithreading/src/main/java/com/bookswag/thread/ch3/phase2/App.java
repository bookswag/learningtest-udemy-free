package com.bookswag.thread.ch3.phase2;

public class App {

    private int count = 0; // volatile doesn't work

    public static void main(String[] args) {
        App app = new App();
        app.doWork();
    }

    public void doWork() {
        Thread t1 = new Thread(() -> {
           for(int i=0 ; i<10_000 ;i++) {
               count++;
           }
        });

        Thread t2 = new Thread(() -> {
            for(int i=0 ; i<10_000 ;i++) {
                count++;
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
