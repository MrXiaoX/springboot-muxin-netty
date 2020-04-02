package com.cardlan.springboot.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue=new ArrayBlockingQueue<>(3);

//        System.out.println(queue.add("a"));
//        System.out.println(queue.add("b"));
//        System.out.println(queue.add("c"));
//
//        System.out.println(queue.element());
//
//        System.out.println(queue.remove());
//        System.out.println(queue.remove());
//        System.out.println(queue.remove());

//        System.out.println(queue.offer("one"));
//        System.out.println(queue.offer("two"));
//        System.out.println(queue.offer("three"));
//        System.out.println(queue.offer("four"));
//
//        System.out.println(queue.peek());
//
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());


        queue.put("b");
        System.out.print("添加了a\n");
        queue.put("b");
        System.out.print("添加了b\n");
        queue.put("c");
        System.out.print("添加了c\n");
//        queue.put("d");
//        System.out.print("添加了d\n");

        queue.take();
        System.out.print("消费了a\n");
        queue.take();
        System.out.print("消费了a\n");
        queue.take();
        System.out.print("消费了a\n");
    }

}
