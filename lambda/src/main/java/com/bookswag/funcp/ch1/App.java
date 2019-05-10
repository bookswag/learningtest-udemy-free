package com.bookswag.funcp.ch1;

public class App {
    public static void main(String[] args) {
        System.out.println(process("Hello, World!"));
    }

    private static String process(String hello) {
        return hello.toUpperCase();
    }
}
