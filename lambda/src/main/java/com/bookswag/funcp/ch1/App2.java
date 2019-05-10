package com.bookswag.funcp.ch1;

import java.util.function.Function;

public class App2 {
    public static void main(String[] args) {
        System.out.println(process("Hello, World!", str -> str.toUpperCase()));
    }

    private static String process(String hello, Function<String, String> processor) {
        return processor.apply(hello);
    }
}