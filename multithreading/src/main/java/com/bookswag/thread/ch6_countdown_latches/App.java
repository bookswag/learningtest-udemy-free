package com.bookswag.thread.ch6_countdown_latches;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3); // gets thread safety
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i=0; i<3; i++) {
            executor.submit(new Processor(latch));
        }

        try {
            latch.await(); // count down to 0
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Completed.");
    }
}
