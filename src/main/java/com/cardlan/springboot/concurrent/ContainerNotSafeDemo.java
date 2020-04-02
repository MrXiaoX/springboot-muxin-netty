package com.cardlan.springboot.concurrent;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class ContainerNotSafeDemo {

    public static void main(String[] args) {

        Map<String,Object> map=new ConcurrentHashMap<>();

        for (int i = 1; i <=30 ; i++) {
            new Thread(()->{
                map.put(UUID.randomUUID().toString().substring(0,8),null);
                System.out.println(map);
            },String.valueOf(i)).start();
        }

        Set<String> set=new CopyOnWriteArraySet<>();


//                Collections.synchronizedList(new ArrayList<>());
        for (int i = 1; i <=30 ; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(set);
            },String.valueOf(i)).start();
        }


        List<String> list=new CopyOnWriteArrayList<>();


//                Collections.synchronizedList(new ArrayList<>());
        for (int i = 1; i <=30 ; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }

        /**
         *
         * 1.故障现象
         *   java.util.ConcurrentModificationException
         *
         * 2.导致原因
         *  并发争取修改导致，一个写入，一个抢夺资源，导致数据不一致，并发修改异常。
         *
         * 3.解决方案
         *   1.new Vector
         *   2.Collections.synchronizedList(new ArrayList<>())
         *   3.new CopyOnWriteArrayList<>();
         *
         * 4.优化建议(同样的错误不犯第二次)
         *
         */
    }

}
