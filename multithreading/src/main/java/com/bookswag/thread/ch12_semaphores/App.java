package com.bookswag.thread.ch12_semaphores;

import java.util.concurrent.Semaphore;

public class App {
    public static void main(String[] args) throws Exception {
        Semaphore semaphore = new Semaphore(2);

        semaphore.acquire();
        semaphore.release();
        
        System.out.println("Available permits: " + semaphore.availablePermits());
    }
}
