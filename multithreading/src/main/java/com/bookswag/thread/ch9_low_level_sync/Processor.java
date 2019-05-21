package com.bookswag.thread.ch9_low_level_sync;

import java.util.LinkedList;
import java.util.Random;

public class Processor {

    private LinkedList<Integer> list = new LinkedList<>();
    private final int LIMIT = 10;
    private Object lock = new Object();

    public void produce() throws InterruptedException {
        int value = 0;

        while(true) {
            synchronized (lock) {
                while(list.size() == LIMIT) {
                    lock.wait();
                } // it gonna sleep until notified by consume()
                list.add(value++);
                lock.notify();
            }
        }
    }

    public void consume() throws InterruptedException {
        Random random = new Random();

        while(true) {
            synchronized (lock) {
                while(list.size() == 0) {
                    lock.wait();
                }
                System.out.print("List size is : " + list.size());
                int value = list.removeFirst();
                System.out.println(", value is : " + value);
                lock.notify();
            }

            Thread.sleep(random.nextInt(1000));
        }
    }
}
