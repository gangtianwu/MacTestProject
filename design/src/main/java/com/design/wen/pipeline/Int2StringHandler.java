package com.design.wen.pipeline;

public class Int2StringHandler implements Handler<Integer,String> {
    @Override
    public String process(Integer input) {
        int value = input.intValue();
        System.out.println("int转换前: " + value);
        return "转换为String的值: "+value ;
    }
}
