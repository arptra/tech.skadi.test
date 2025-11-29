package com.upuphone.runasone.channel.proxy.server.socks;

import android.text.TextUtils;
import com.upuphone.runasone.channel.proxy.client.util.DebugLog;
import com.upuphone.runasone.channel.proxy.server.base.ChannelServerUtils;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.socksx.SocksMessage;
import io.netty.handler.codec.socksx.SocksVersion;
import io.netty.handler.codec.socksx.v5.DefaultSocks5CommandResponse;
import io.netty.handler.codec.socksx.v5.DefaultSocks5InitialResponse;
import io.netty.handler.codec.socksx.v5.DefaultSocks5PasswordAuthResponse;
import io.netty.handler.codec.socksx.v5.Socks5AddressType;
import io.netty.handler.codec.socksx.v5.Socks5AuthMethod;
import io.netty.handler.codec.socksx.v5.Socks5CommandRequest;
import io.netty.handler.codec.socksx.v5.Socks5CommandRequestDecoder;
import io.netty.handler.codec.socksx.v5.Socks5CommandStatus;
import io.netty.handler.codec.socksx.v5.Socks5CommandType;
import io.netty.handler.codec.socksx.v5.Socks5InitialRequest;
import io.netty.handler.codec.socksx.v5.Socks5PasswordAuthRequest;
import io.netty.handler.codec.socksx.v5.Socks5PasswordAuthStatus;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

@ChannelHandler.Sharable
public final class SocksServerHandler extends SimpleChannelInboundHandler<SocksMessage> {
    public static final SocksServerHandler INSTANCE = new SocksServerHandler();
    private static final String TAG = "SocksServerHandler";

    private SocksServerHandler() {
    }

    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.flush();
    }

    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) {
        ChannelServerUtils.closeOnFlush(channelHandlerContext.channel());
    }

    public void channelRead0(ChannelHandlerContext channelHandlerContext, SocksMessage socksMessage) throws Exception {
        String str;
        if (!socksMessage.version().equals(SocksVersion.SOCKS5)) {
            DebugLog.e("%s SocksVersion error", TAG);
            channelHandlerContext.writeAndFlush(Unpooled.wrappedBuffer("protocol version illegal!".getBytes()));
        } else if (socksMessage instanceof Socks5InitialRequest) {
            DebugLog.d("%s get new socks auth req. And send no auth.", TAG);
            channelHandlerContext.pipeline().addFirst(new Socks5CommandRequestDecoder());
            channelHandlerContext.write(new DefaultSocks5InitialResponse(Socks5AuthMethod.NO_AUTH));
        } else if (socksMessage instanceof Socks5PasswordAuthRequest) {
            Socks5PasswordAuthRequest socks5PasswordAuthRequest = (Socks5PasswordAuthRequest) socksMessage;
            if (!TextUtils.equals("", socks5PasswordAuthRequest.password()) || !TextUtils.equals("", socks5PasswordAuthRequest.username())) {
                ChannelServerUtils.closeOnFlush(channelHandlerContext.channel());
                return;
            }
            channelHandlerContext.pipeline().addFirst(new Socks5CommandRequestDecoder());
            channelHandlerContext.write(new DefaultSocks5PasswordAuthResponse(Socks5PasswordAuthStatus.SUCCESS));
        } else if (socksMessage instanceof Socks5CommandRequest) {
            Socks5CommandRequest socks5CommandRequest = (Socks5CommandRequest) socksMessage;
            if (socks5CommandRequest.type() == Socks5CommandType.CONNECT) {
                DebugLog.d("%s get new client cmd: CONNECT to->%s:%d", TAG, socks5CommandRequest.dstAddr(), Integer.valueOf(socks5CommandRequest.dstPort()));
                channelHandlerContext.pipeline().addLast(new SocksServerConnectHandler());
                channelHandlerContext.pipeline().remove((ChannelHandler) this);
                channelHandlerContext.fireChannelRead(socksMessage);
            } else if (socks5CommandRequest.type() == Socks5CommandType.UDP_ASSOCIATE) {
                DebugLog.d("%s UDP_ASSOCIATE", TAG);
                SocketAddress localAddress = channelHandlerContext.channel().localAddress();
                int port = UDPServer.getPort();
                try {
                    str = ((InetSocketAddress) localAddress).getAddress().getHostAddress();
                } catch (Exception unused) {
                    str = null;
                }
                DebugLog.d("%s request=%s:%d", TAG, socks5CommandRequest.dstAddr(), Integer.valueOf(socks5CommandRequest.dstPort()));
                if (port == 0 || TextUtils.isEmpty(str)) {
                    channelHandlerContext.close();
                    return;
                }
                channelHandlerContext.pipeline().addFirst(new Socks5CommandRequestDecoder());
                channelHandlerContext.write(new DefaultSocks5CommandResponse(Socks5CommandStatus.SUCCESS, Socks5AddressType.IPv4, str, port));
            } else {
                channelHandlerContext.close();
            }
        } else {
            channelHandlerContext.close();
        }
    }
}
