package com.cardlan.springboot.netty;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.time.LocalDateTime;

public class ChatHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    private static ChannelGroup clients=new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, TextWebSocketFrame msg) throws Exception {
        //获取客户端传过来的信息
        String content = msg.text();
        System.out.println("接收消息:"+content);
        for (Channel channel: clients) {
            channel.writeAndFlush(
                    new TextWebSocketFrame(
                            "[服务器在]" + LocalDateTime.now()
                                    + "接受到消息, 消息为：" + content));
        }
        // 下面这个方法，和上面的for循环，一致
//            clients.writeAndFlush(
//                    new TextWebSocketFrame(
//                            "[服务器在]" + LocalDateTime.now()
//                                    + "接受到消息, 消息为：" + content));
    }

    /**
     * 当客户端链接服务器端之后（打开链接)
     * 获取客户端的channel，并且放到ChannelGroup中去进行管理
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        clients.add(ctx.channel());
    }


    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        // 当触发handlerRemoved，ChannelGroup会自动移除对应客户端的channel
//		clients.remove(ctx.channel());
        System.out.println("客户端断开，channle对应的长id为："
                + ctx.channel().id().asLongText());
        System.out.println("客户端断开，channle对应的短id为："
                + ctx.channel().id().asShortText());
    }


}
