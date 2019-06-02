package com.bookswag.thread.ch11_deadlock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
    private Account acc1 = new Account();
    private Account acc2 = new Account();

    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    private void acquireLocks(Lock paramLock1, Lock paramLock2) throws InterruptedException { // DON'T CARE ORDER ABOUT LOCK
        while(true) {
            // Acquire locks
            boolean gotFirstLock = false;
            boolean gotSecondLock = false;

            try {
                gotFirstLock = paramLock1.tryLock();
                gotSecondLock = paramLock2.tryLock();
            } finally {
                if (gotFirstLock && gotSecondLock) {
                    return;
                }

                if (gotFirstLock) {
                    paramLock1.unlock();
                }

                if (gotSecondLock) {
                    paramLock2.unlock();
                }
            }

            // Lock
            Thread.sleep(1);
        }
    }

    public void firstThread() throws InterruptedException {
        Random random = new Random();

        for (int i=0; i<10_000 ; i++){
            acquireLocks(lock1, lock2);
            try {
                Account.transfer(acc1, acc2, random.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void secondThread() throws InterruptedException {
        Random random = new Random();

        for (int i=0; i<10_000 ; i++){
            acquireLocks(lock2, lock1);
            try {
                Account.transfer(acc2, acc1, random.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void finished() {
        System.out.println("Account 1's balance : "+acc1.getBalance());
        System.out.println("Account 2's balance : "+acc2.getBalance());
        System.out.println("Total balance : " + (acc1.getBalance()+acc2.getBalance()));
    }
}
