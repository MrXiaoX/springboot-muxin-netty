package com.cardlan.springboot.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class MyCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("**** 欢迎 Callable");
        return 1024;
    }
}

public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //两个线程，一个main线程，一个AAfutrueTask
        // FutureTask(Callable<V> callable)
        FutureTask<Integer> future=new FutureTask<>(new MyCallable());

        Thread thread= new Thread(future,"callable");
        thread.start();

        System.out.println(Thread.currentThread().getName()+"\t main");

        int result=100;



//        while (!future.isDone()){
//
//        }

            int result01=future.get();

        //要求获得Callable线程计算的结果，如果没有计算完成就去强求，会被堵塞
        System.out.println("计算结果:>>"+(result+result01));
    }
}
