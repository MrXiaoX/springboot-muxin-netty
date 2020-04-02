package com.cardlan.springboot.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class NioServerTcp {

    static ByteBuffer byteBuffer=ByteBuffer.allocate(512);

    public static void main(String[] args) {
        try {
            ServerSocketChannel socketChannel=ServerSocketChannel.open();
            socketChannel.bind(new InetSocketAddress(8012));
            socketChannel.configureBlocking(false);
            SocketChannel socketChannel1=socketChannel.accept();
            if(socketChannel1!=null)
            {
                int read = socketChannel1.read(byteBuffer);
                if(read>0)
                {
                    byteBuffer.flip();
                    Charset charset=Charset.forName("UTF-8");
                    String receiver = charset.newDecoder().decode(byteBuffer.asReadOnlyBuffer()).toString();
                    System.out.println(receiver);
                }
            }
            System.out.println("程序已结束");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
