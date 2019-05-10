package com.bookswag.thread.ch1.phase3;

public class App {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
                for(int i=0; i<10; i++) {
                    System.out.println("Hello " + i);

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        });
        thread.start();
    }
}
