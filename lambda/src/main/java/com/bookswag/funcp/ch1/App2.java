package com.bookswag.funcp.ch1;

public class App2 {
    public static void main(String[] args) {
        System.out.println(process("Hello, World!", str -> str.toUpperCase()));
    }

    private static String process(String hello, Processor processor) {
        return processor.process(hello);
    }
}

@FunctionalInterface
interface Processor {
    String process(String str);
}