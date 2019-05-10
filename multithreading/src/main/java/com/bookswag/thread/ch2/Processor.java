package com.bookswag.thread.ch2;

public class Processor extends Thread {

    private String name;
    private volatile boolean running = true;

    public Processor(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while(running) {
            System.out.println("Hello, I'm "+name);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown() {
        this.running = false;
    }
}
