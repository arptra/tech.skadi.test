package com.upuphone.runasone.channel.proxy.server.socks;

import com.upuphone.runasone.channel.proxy.client.util.DebugLog;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

public class SocksProxyUDPHandlerTest extends SimpleChannelInboundHandler<DatagramPacket> {
    private static final String TAG = "SocksProxyUDPHandlerTest";

    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        super.channelInactive(channelHandlerContext);
    }

    public void channelRead0(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket) {
        DebugLog.d("%s: 收到的信息回复开始1：", TAG);
        ByteBuf byteBuf = (ByteBuf) datagramPacket.content();
        CharSequence readCharSequence = byteBuf.readCharSequence(byteBuf.readableBytes(), Charset.defaultCharset());
        DebugLog.d("%s: 收到的信息回复开始2：%s", TAG, readCharSequence.toString());
        channelHandlerContext.channel().writeAndFlush(new DatagramPacket(Unpooled.wrappedBuffer("abc".getBytes()), (InetSocketAddress) datagramPacket.sender()));
        DebugLog.d("%s: 收到的信息回复开始3：%s", TAG, readCharSequence.toString());
    }
}
