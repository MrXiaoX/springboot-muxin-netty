package com.cardlan.springboot.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThreadPoolDemo {



    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());

            AtomicInteger atomicInteger = new AtomicInteger(5);
            System.out.println(atomicInteger.compareAndSet(5, 2019)+"\t current"+atomicInteger.get());
            System.out.println(atomicInteger.compareAndSet(5, 2014)+"\t current"+atomicInteger.get());
    }
}
