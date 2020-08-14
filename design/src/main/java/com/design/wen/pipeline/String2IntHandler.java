package com.design.wen.pipeline;

import java.util.function.IntPredicate;

public class String2IntHandler implements Handler<String,Integer> {
    @Override
    public Integer process(String input) {
        System.out.println("String转换前: " + input);
        return Integer.valueOf(input);
    }
}
