package com.design.wen.pipeline;

public class String2CharHandler implements Handler<String,char[]> {
    @Override
    public char[] process(String input) {
        char[] chars = input.toCharArray();
        System.out.println("String 转换前: " +input);
        return chars;
    }
}
