package com.bookswag.funcp.ch1;

public class App2 {
    public static void main(String[] args) {
        System.out.println(process("Hello, World!", new Processor() {
            public String process(String str) {
                return str.toUpperCase();
            }
        }));
    }

    private static String process(String hello, Processor processor) {
        return processor.process(hello);
    }
}

interface Processor {
    String process(String str);
}