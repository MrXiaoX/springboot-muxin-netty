package com.cardlan.springboot.concurrent;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueDemo
{
	public static void main(String[] args)
	{
		final ArrayBlockingQueue<Data> queue = new ArrayBlockingQueue<>(100000000);
        final long startTime = System.currentTimeMillis();
        //向容器中添加元素
        new Thread(()-> {

                long i = 0;
                while (i < Constants.EVENT_NUM_OM) {
                	Data data = new Data(i, "c" + i);
                    try {
                        queue.put(data);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i++;
                }
        }).start();

        new Thread(()-> {
                int k = 0;
                while (k < Constants.EVENT_NUM_OM) {
                    try {
                        queue.take();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    k++;
                }
                long endTime = System.currentTimeMillis();
                System.out.println("ArrayBlockingQueue costTime = " + (endTime - startTime) + "ms");
        }).start();

//        String gateIds=",1,2,3,4,";
//        gateIds=gateIds.trim().substring(gateIds.indexOf(",")+1,gateIds.lastIndexOf(","));
//        System.out.println(gateIds);
	}
}
