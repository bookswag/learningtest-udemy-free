package com.bookswag.thread.ch11_deadlock;

public class Account {
    private int balance = 10_000 ;

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }

    public static void transfer(Account sender, Account receiver, int amount) {
        sender.withdraw(amount);
        receiver.deposit(amount);
    }
}
