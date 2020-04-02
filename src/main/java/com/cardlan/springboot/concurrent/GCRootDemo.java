package com.cardlan.springboot.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 1.虚拟机栈(栈帧的本地变量表)中引用的对象
 * 2.方法区中类静态属性引用的对象
 * 3.方法区中常量引用的对象
 * 4.本地方法栈中(native)引用的对象
 *
 */
public class GCRootDemo {


    ExecutorService executorService= Executors.newSingleThreadExecutor();

//    private byte[] bytes=new byte[100*1024*1024];

//    private static GCRootDemo2 g2;  方法区中类静态属性引用的对象
//    private static  final GCRootDemo3 g3=new GCRootDemo3();方法区中常量引用的对象

//    public static void m1(){
//        GCRootDemo gcRootDemo=new GCRootDemo();
//        System.gc();
//        System.out.println("第一次GC完成");
//    }

    public static void main(String[] args) {
//        m1();


        System.out.println("JVMC查看GC参数");
        try {
            TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
