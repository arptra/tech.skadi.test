package io.netty.channel.kqueue;

import io.netty.channel.Channel;
import io.netty.channel.EventLoop;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.unix.NativeInetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

public final class KQueueServerSocketChannel extends AbstractKQueueServerChannel implements ServerSocketChannel {
    private final KQueueServerSocketChannelConfig config;

    public KQueueServerSocketChannel() {
        super(BsdSocket.newSocketStream(), false);
        this.config = new KQueueServerSocketChannelConfig(this);
    }

    public void doBind(SocketAddress socketAddress) throws Exception {
        super.doBind(socketAddress);
        this.socket.listen(this.config.getBacklog());
        if (this.config.isTcpFastOpen()) {
            this.socket.setTcpFastOpen(true);
        }
        this.active = true;
    }

    public boolean isCompatible(EventLoop eventLoop) {
        return eventLoop instanceof KQueueEventLoop;
    }

    public Channel newChildChannel(int i, byte[] bArr, int i2, int i3) throws Exception {
        return new KQueueSocketChannel(this, new BsdSocket(i), NativeInetAddress.address(bArr, i2, i3));
    }

    public InetSocketAddress localAddress() {
        return (InetSocketAddress) super.localAddress();
    }

    public InetSocketAddress remoteAddress() {
        return (InetSocketAddress) super.remoteAddress();
    }

    public KQueueServerSocketChannel(int i) {
        this(new BsdSocket(i));
    }

    public KQueueServerSocketChannel(BsdSocket bsdSocket) {
        super(bsdSocket);
        this.config = new KQueueServerSocketChannelConfig(this);
    }

    public KQueueServerSocketChannelConfig config() {
        return this.config;
    }

    public KQueueServerSocketChannel(BsdSocket bsdSocket, boolean z) {
        super(bsdSocket, z);
        this.config = new KQueueServerSocketChannelConfig(this);
    }
}
