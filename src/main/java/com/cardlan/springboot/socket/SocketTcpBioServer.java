package com.cardlan.springboot.socket;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SocketTcpBioServer {
    static byte[]  bytes=new byte[1024];

    static ExecutorService threadPool=new ThreadPoolExecutor(50, 100,
            1L, TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(10));

//    ThreadPoolExecutor(100,
//    150,
//    1,
//                       TimeUnit.SECONDS,
//    new BlockingQueue<Runnable>());

    public static void main(String[] args) {
        try {
            final ServerSocket serverSocket=new ServerSocket();
            serverSocket.bind(new InetSocketAddress(8801));

            while (true){
                System.out.println("开始等待接收数据。。。");
                final Socket accept = serverSocket.accept();
                new Thread(()->{
                    try {
                        int read = accept.getInputStream().read(bytes);
                        String result=new String(bytes);
                        System.out.println("服务器端获取数据"+result);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
