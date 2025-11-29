package com.upuphone.runasone.channel.proxy.server.socks;

import com.upuphone.runasone.channel.proxy.client.util.DebugLog;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;
import java.net.InetSocketAddress;
import org.eclipse.jetty.util.StringUtil;

public class UDPServer {
    private static final String TAG = "UDPServer";
    private static NioEventLoopGroup bossGroup;
    private static boolean isRunning;
    private static Channel serverChannel;

    public static int getPort() {
        Channel channel = serverChannel;
        if (channel == null || !channel.isActive()) {
            return 0;
        }
        return ((InetSocketAddress) serverChannel.localAddress()).getPort();
    }

    public static void start() {
        try {
            startReal();
        } catch (Exception unused) {
            isRunning = false;
        }
    }

    private static void startReal() {
        DebugLog.i("%s startReal", TAG);
        if (!isRunning) {
            Bootstrap bootstrap = new Bootstrap();
            NioEventLoopGroup nioEventLoopGroup = new NioEventLoopGroup(4);
            bossGroup = nioEventLoopGroup;
            serverChannel = ((Bootstrap) ((Bootstrap) ((Bootstrap) ((Bootstrap) bootstrap.group(nioEventLoopGroup)).channel(NioDatagramChannel.class)).option(ChannelOption.SO_BROADCAST, Boolean.TRUE)).handler(new ChannelInitializer<NioDatagramChannel>() {
                public void initChannel(NioDatagramChannel nioDatagramChannel) throws Exception {
                    nioDatagramChannel.pipeline().addLast(new SocksProxyUDPHandler());
                }
            })).bind(StringUtil.ALL_INTERFACES, 0).syncUninterruptibly().channel();
            isRunning = true;
            DebugLog.i("%s port=%d", TAG, Integer.valueOf(getPort()));
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:0|1|2|3|4|5|7) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void stop() {
        /*
            com.upuphone.runasone.channel.proxy.server.socks.SocksProxyUDPHandler.clear()
            r0 = 0
            io.netty.channel.Channel r1 = serverChannel     // Catch:{ Exception -> 0x000b }
            r1.close()     // Catch:{ Exception -> 0x000b }
            serverChannel = r0     // Catch:{ Exception -> 0x000b }
        L_0x000b:
            io.netty.channel.nio.NioEventLoopGroup r1 = bossGroup     // Catch:{ Exception -> 0x0012 }
            r1.shutdownGracefully()     // Catch:{ Exception -> 0x0012 }
            bossGroup = r0     // Catch:{ Exception -> 0x0012 }
        L_0x0012:
            r0 = 0
            isRunning = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.runasone.channel.proxy.server.socks.UDPServer.stop():void");
    }
}
