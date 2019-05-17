package com.bookswag.thread.ch8_wait_n_notify;

import java.util.Scanner;

public class Processor {
    public void produce() throws InterruptedException {
        synchronized (this) {
            System.out.println("Producer thread running ....");
            wait(); // until notify on consume()
            System.out.println("Resumed.");
        }
    }

    public void consume() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Thread.sleep(2000);

        synchronized (this) { // using same lock with produce()
            System.out.println("Waiting for return key.");
            scanner.nextLine();
            System.out.println("Return key pressed.");
            notify();
            Thread.sleep(5000);
        }
    }
}
