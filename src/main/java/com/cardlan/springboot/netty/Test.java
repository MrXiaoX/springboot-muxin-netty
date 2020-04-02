package com.cardlan.springboot.netty;

public class Test {
    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(2 + ":" + i);
            }
        }).start();
    }
}
