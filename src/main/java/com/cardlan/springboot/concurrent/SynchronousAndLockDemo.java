package com.cardlan.springboot.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareReoucse{

    private int num=1;

    private Lock lock=new ReentrantLock();

    private Condition condition1=lock.newCondition();
    private Condition condition2=lock.newCondition();
    private Condition condition3=lock.newCondition();

    public void print5() throws InterruptedException {
        lock.lock();;
        try {
            //1.判断
            while (num!=1){
                condition1.await();
            }
            //2.执行操作
            for (int i = 1; i <=5 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t  "+i);
            }
            num=2;
            //3.通知唤醒
            condition1.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void print10() throws InterruptedException {
        lock.lock();;
        try {
            //1.判断
            while (num!=2){
                condition2.await();
            }
            //2.执行操作
            for (int i = 1; i <=10 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t  "+i);
            }
            num=3;
            //3.通知唤醒
            condition3.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


    public void print15() throws InterruptedException {
        lock.lock();;
        try {
            //1.判断
            while (num!=3){
                condition3.await();
            }
            //2.执行操作
            for (int i = 1; i <=15 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t  "+i);
            }
            num=1;
            //3.通知唤醒
            condition1.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}

public class SynchronousAndLockDemo {

    public static void main(String[] args) {
        ShareReoucse shareReoucse=new ShareReoucse();

        new Thread(()->{
            for (int i = 1; i <=10 ; i++) {
                try {
                    shareReoucse.print5();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"AA").start();

        new Thread(()->{
            for (int i = 1; i <=10 ; i++) {
                try {
                    shareReoucse.print10();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"BB").start();

        new Thread(()->{
            for (int i = 1; i <=10 ; i++) {
                try {
                    shareReoucse.print15();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"CC").start();


    }
}
