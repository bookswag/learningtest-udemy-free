package com.bookswag.funcp.ch2;

import java.util.function.BiFunction;
import java.util.function.Function;

public class App {
    public static void main(String[] args) {
        String prefix = "MR. ";
        System.out.println(process("Hello, World!", String::toUpperCase));
        System.out.println(process("Hello, World!", prefix::concat));
        System.out.println(process2("Hello, World!", 5, String::substring));
    }

    private static String process(String hello, Function<String, String> processor) {
        return processor.apply(hello);
    }

    private static String process2(String hello, Integer i, BiFunction<String, Integer, String> processor) {
        return processor.apply(hello, i);
    }
}
