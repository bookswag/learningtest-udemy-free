package com.bookswag.thread.ch12_semaphores;

public class Connection {
    private static Connection instance = new Connection();
    private int connections = 0;

    private Connection() {}

    public static Connection getInstance() {
        return instance;
    }

    public void connect() {
        synchronized (this) {
            connections++;
            System.out.println("Current connections: " + connections);
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (this) {
            connections--;
        }
    }
}
