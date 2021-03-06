package com.cardlan.springboot.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

public class WebSocketServerInitialize extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline channelPipeline=socketChannel.pipeline();

        //websocket基于http,所以要有http解码器
        channelPipeline.addLast(new HttpServerCodec());
        //对写大数据流的支持
        channelPipeline.addLast(new ChunkedWriteHandler());
        // 对httpMessage进行聚合，聚合成FullHttpRequest或FullHttpResponse
        // 几乎在netty中的编程，都会使用到此hanler
        channelPipeline.addLast(new HttpObjectAggregator(1024*64));

        // ====================== 以上是用于支持http协议    ======================

        // ====================== 以下是支持httpWebsocket ======================

        /**
         * websocekt 服务器处理的协议，用于指定客户端访问的路由:/ws
         * 本handler会处理一下繁重复杂的事
         * 会帮你处理握手动作： handshaking（close, ping, pong） ping + pong = 心跳
         * 对于websocket来讲，都是以frames进行传输的，不同的数据类型对应的frames也不同
         */
        channelPipeline.addLast(new WebSocketServerProtocolHandler("/ws"));
        channelPipeline.addLast(new ChatHandler());
    }
}
