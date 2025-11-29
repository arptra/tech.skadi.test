package io.netty.channel.kqueue;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.kqueue.AbstractKQueueChannel;
import io.netty.channel.kqueue.AbstractKQueueStreamChannel;
import io.netty.channel.socket.InternetProtocolFamily;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.unix.IovArray;
import io.netty.util.concurrent.GlobalEventExecutor;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.concurrent.Executor;

public final class KQueueSocketChannel extends AbstractKQueueStreamChannel implements SocketChannel {
    private final KQueueSocketChannelConfig config = new KQueueSocketChannelConfig(this);

    public final class KQueueSocketChannelUnsafe extends AbstractKQueueStreamChannel.KQueueStreamUnsafe {
        private KQueueSocketChannelUnsafe() {
            super();
        }

        public Executor prepareToClose() {
            try {
                if (!KQueueSocketChannel.this.isOpen() || KQueueSocketChannel.this.config().getSoLinger() <= 0) {
                    return null;
                }
                ((KQueueEventLoop) KQueueSocketChannel.this.eventLoop()).remove(KQueueSocketChannel.this);
                return GlobalEventExecutor.INSTANCE;
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    public KQueueSocketChannel() {
        super((Channel) null, BsdSocket.newSocketStream(), false);
    }

    public boolean doConnect0(SocketAddress socketAddress, SocketAddress socketAddress2) throws Exception {
        if (this.config.isTcpFastOpenConnect()) {
            ChannelOutboundBuffer outboundBuffer = unsafe().outboundBuffer();
            outboundBuffer.addFlush();
            Object current = outboundBuffer.current();
            if (current instanceof ByteBuf) {
                ByteBuf byteBuf = (ByteBuf) current;
                if (byteBuf.isReadable()) {
                    IovArray iovArray = new IovArray(this.config.getAllocator().directBuffer());
                    try {
                        iovArray.add(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes());
                        boolean z = true;
                        int connectx = this.socket.connectx((InetSocketAddress) socketAddress2, (InetSocketAddress) socketAddress, iovArray, true);
                        writeFilter(true);
                        outboundBuffer.removeBytes((long) Math.abs(connectx));
                        if (connectx <= 0) {
                            z = false;
                        }
                        return z;
                    } finally {
                        iovArray.release();
                    }
                }
            }
        }
        return super.doConnect0(socketAddress, socketAddress2);
    }

    public InetSocketAddress localAddress() {
        return (InetSocketAddress) super.localAddress();
    }

    public AbstractKQueueChannel.AbstractKQueueUnsafe newUnsafe() {
        return new KQueueSocketChannelUnsafe();
    }

    public ServerSocketChannel parent() {
        return (ServerSocketChannel) super.parent();
    }

    public InetSocketAddress remoteAddress() {
        return (InetSocketAddress) super.remoteAddress();
    }

    public KQueueSocketChannel(InternetProtocolFamily internetProtocolFamily) {
        super((Channel) null, BsdSocket.newSocketStream(internetProtocolFamily), false);
    }

    public KQueueSocketChannelConfig config() {
        return this.config;
    }

    public KQueueSocketChannel(int i) {
        super(new BsdSocket(i));
    }

    public KQueueSocketChannel(Channel channel, BsdSocket bsdSocket, InetSocketAddress inetSocketAddress) {
        super(channel, bsdSocket, (SocketAddress) inetSocketAddress);
    }
}
