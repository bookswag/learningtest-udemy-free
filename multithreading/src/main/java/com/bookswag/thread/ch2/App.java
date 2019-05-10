package com.bookswag.thread.ch2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Processor proc1 = new Processor("p1");
        Processor proc2 = new Processor("p2");
        proc1.start();
        proc2.start();

        System.out.println("Press return to stop p1 ...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        proc1.shutdown();

        System.out.println("Press return to stop p2 ...");
        Scanner scanner2 = new Scanner(System.in);
        scanner2.nextLine();

        proc2.shutdown();
    }
}
