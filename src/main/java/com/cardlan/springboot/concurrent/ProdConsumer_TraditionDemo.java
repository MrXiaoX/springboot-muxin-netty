package com.cardlan.springboot.concurrent;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareData{

    private int num=0;

    private Lock lock=new ReentrantLock();

    private Condition condition=lock.newCondition();

    public void increment() throws InterruptedException {
        lock.lock();;
        try {
            //1.判断
            while (num!=0){
                condition.await();
            }
            //2.z执行操作
            num++;
            System.out.println(Thread.currentThread().getName()+"\t  "+num);
            //3.通知唤醒
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void decrement() throws InterruptedException {
        lock.lock();;
        try {
            //1.判断
            while (num==0){
                condition.await();
            }
            //2.z执行操作
            num--;
            System.out.println(Thread.currentThread().getName()+"\t  "+num);
            //3.通知唤醒
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}

public class ProdConsumer_TraditionDemo {
    public static void main(String[] args) {
         ShareData shareData=new ShareData();

        new Thread(()->{
            for (int i = 1; i <=10 ; i++) {
                try {
                    shareData.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"AA").start();

         new Thread(()->{
             for (int i = 1; i <=10 ; i++) {
                 try {
                     shareData.decrement();
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
         },"BB").start();

        new Thread(()->{
            for (int i = 1; i <=10 ; i++) {
                try {
                    shareData.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"CC").start();

        new Thread(()->{
            for (int i = 1; i <=10 ; i++) {
                try {
                    shareData.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"DD").start();
    }
}
