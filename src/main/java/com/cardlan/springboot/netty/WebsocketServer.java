package com.cardlan.springboot.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.stereotype.Component;

@Component
public class WebsocketServer {

    private  static class SingletionWSServer{
        static final WebsocketServer instance=new WebsocketServer();
    }

    public static WebsocketServer getInstance(){
        return SingletionWSServer.instance;
    }

    private EventLoopGroup mainGroup;
    private EventLoopGroup subGroup;
    private ServerBootstrap serverBootstrap;
    private ChannelFuture future;

    public WebsocketServer(){
        mainGroup=new NioEventLoopGroup();
        subGroup=new NioEventLoopGroup();
        serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(mainGroup, subGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new WebSocketServerInitialize());
    }

    public void start(){
        this.future=serverBootstrap.bind(8088);
        System.err.println("netty websocket 启动完毕");
    }

//    public static void main(String[] args) throws Exception {
//        EventLoopGroup mainGroup=new NioEventLoopGroup();
//        EventLoopGroup subGroup=new NioEventLoopGroup();
//
//        try {
//            ServerBootstrap serverBootstrap = new ServerBootstrap();
//            serverBootstrap.group(mainGroup, subGroup)
//                    .channel(NioServerSocketChannel.class)
//                    .childHandler(new WebSocketServerInitialize());
//
//            ChannelFuture future = serverBootstrap.bind(8088).sync();
//            future.channel().closeFuture().sync();
//        }finally {
//            mainGroup.shutdownGracefully();
//            subGroup.shutdownGracefully();
//        }
//    }
}
