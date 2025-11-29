package com.upuphone.runasone.channel.proxy.server;

import android.os.Handler;
import android.os.Looper;
import com.honey.account.x5.a;
import com.honey.account.x5.b;
import com.upuphone.runasone.channel.proxy.client.util.DebugLog;
import com.upuphone.runasone.channel.proxy.server.socks.SocksServerInitializer;
import com.upuphone.runasone.channel.proxy.server.socks.UDPServer;
import com.upuphone.runasone.channel.proxy.server.socks.UDPServerTest;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.concurrent.Future;
import java.net.InetSocketAddress;

public class Socks5Server {
    private static final String TAG = "Socks5Server";
    private static Socks5Server instance = new Socks5Server();
    private boolean isRunning = false;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private ServerBootstrap serverBootstrap;
    private Channel serverChannel;
    private EventLoopGroup serverEventLoopGroup;

    public static synchronized Socks5Server getInstance() {
        Socks5Server socks5Server;
        synchronized (Socks5Server.class) {
            socks5Server = instance;
        }
        return socks5Server;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$start$0() {
        this.isRunning = false;
        UDPServer.stop();
        UDPServerTest.stop();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$start$1(Future future) throws Exception {
        this.mHandler.post(new a(this));
    }

    public int getTcpServerPort() {
        Channel channel = this.serverChannel;
        if (channel == null || !channel.isActive()) {
            return 0;
        }
        return ((InetSocketAddress) this.serverChannel.localAddress()).getPort();
    }

    public int getUdpServerPort() {
        return UDPServer.getPort();
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    public void start(int i) {
        DebugLog.i("%s start port(%d)", TAG, Integer.valueOf(i));
        this.serverEventLoopGroup = new NioEventLoopGroup(4);
        ServerBootstrap group = ((ServerBootstrap) new ServerBootstrap().channel(NioServerSocketChannel.class)).childHandler(new SocksServerInitializer()).group(this.serverEventLoopGroup);
        this.serverBootstrap = group;
        Channel channel = group.bind(i).syncUninterruptibly().channel();
        this.serverChannel = channel;
        channel.closeFuture().addListener(new b(this));
        UDPServer.start();
        UDPServerTest.start();
        this.isRunning = true;
    }

    public void stop() {
        UDPServer.stop();
        UDPServerTest.stop();
        try {
            this.serverChannel.close();
            this.serverChannel = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            this.serverEventLoopGroup.shutdownGracefully();
            this.serverEventLoopGroup = null;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
