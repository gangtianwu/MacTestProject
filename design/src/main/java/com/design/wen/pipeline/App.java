package com.design.wen.pipeline;

public class App {
    public static void main(String[] args) {
//        char[] execute = new Pipeline<>(new String2IntHandler())
//                .addHandler(new Int2StringHandler())
//                .addHandler(new String2CharHandler())
//                .execute("1234");
//        for (int i = 0; i < execute.length; i++) {
//            System.out.println(execute[i]);
//
//        }
//        System.out.println("==========");
//        new Pipeline<>(new String2IntHandler())
//                .addHandler(new Int2StringHandler())
//                .execute("100");


        FooBar fooBar = new FooBar(5);
        new Thread(new Runnable() {
            @Override
            public void run() {
                fooBar.foo();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                fooBar.bar();
            }
        }).start();

    }
}
