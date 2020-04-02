package com.cardlan.springboot.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Phone implements Runnable{

    public synchronized void sendSMS()throws Exception{
        System.out.println(Thread.currentThread().getName()+"\t 发送短信");
        sendEmail();
    }

    public synchronized void sendEmail()throws Exception{
        System.out.println(Thread.currentThread().getName()+"\t 发送邮件");
    }


    Lock lock=new ReentrantLock();

    @Override
    public void run() {
        getLock();
    }

    void getLock(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t 发送短信");
            setLock();
        }finally {
            lock.unlock();
        }

    }

    void setLock(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t 发送邮件");
        }finally {
            lock.unlock();
        }

    }
}

public class LockDemo {

    public static void main(String[] args) {



        Phone phone=new Phone();

        new Thread(()->{
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"线程一").start();

        new Thread(()->{
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"线程二").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n\n");
        Thread thread3=new Thread(phone,"线程三");
        Thread thread4=new Thread(phone,"线程四");

        thread3.start();
        thread4.start();
    }

}
