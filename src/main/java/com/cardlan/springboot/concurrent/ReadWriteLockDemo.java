package com.cardlan.springboot.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyCache{
    private volatile Map<String,Object> map=new HashMap<>();

    private ReentrantReadWriteLock writeLock=new ReentrantReadWriteLock();

    public void put(String key,Object value){
        writeLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t 正在写入"+key);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"\t 写入完成"+value);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            writeLock.writeLock().unlock();
        }

    }

    public void get(String key){
        writeLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t 正在读取" + key);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t 读取完成" + result);
        }catch  (Exception e) {
            e.printStackTrace();
        }finally {
            writeLock.readLock().unlock();
        }
    }
}

/**
 * 多线程同时读取一个资源类没有任何问题时，为了满足需求，读取共享资源应该同时进行
 *  但是如果有一个线程去写共享资源，就不应该有其他线程对资源读或写
 *  小总结:
 *        读-读 能共存
 *        读-写 不能共存
 *        写-写 不能共存
 *        写操作：原子+独占，整个过程必须是一个完整体，中间不能被分割打断
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache myCache=new MyCache();

        for (int i = 1; i <=5 ; i++) {
            final int temp=i;
            new Thread(()->{
                myCache.put(temp+"",temp+"");
            },String.valueOf(i)).start();
        }

        for (int i = 1; i <=5 ; i++) {
            final int temp=i;
            new Thread(()->{
                myCache.get(temp+"");
            },String.valueOf(i)).start();
        }

    }
}
