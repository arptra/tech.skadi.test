package io.netty.channel.epoll;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.epoll.AbstractEpollChannel;
import io.netty.channel.epoll.AbstractEpollStreamChannel;
import io.netty.channel.socket.InternetProtocolFamily;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.util.concurrent.GlobalEventExecutor;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.Executor;

public final class EpollSocketChannel extends AbstractEpollStreamChannel implements SocketChannel {
    private final EpollSocketChannelConfig config = new EpollSocketChannelConfig(this);
    private volatile Collection<InetAddress> tcpMd5SigAddresses = Collections.emptyList();

    public final class EpollSocketChannelUnsafe extends AbstractEpollStreamChannel.EpollStreamUnsafe {
        private EpollSocketChannelUnsafe() {
            super();
        }

        public Executor prepareToClose() {
            try {
                if (!EpollSocketChannel.this.isOpen() || EpollSocketChannel.this.config().getSoLinger() <= 0) {
                    return null;
                }
                ((EpollEventLoop) EpollSocketChannel.this.eventLoop()).remove(EpollSocketChannel.this);
                return GlobalEventExecutor.INSTANCE;
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    public EpollSocketChannel() {
        super(LinuxSocket.newSocketStream(), false);
    }

    public boolean doConnect0(SocketAddress socketAddress) throws Exception {
        if (Native.IS_SUPPORTING_TCP_FASTOPEN_CLIENT && this.config.isTcpFastOpenConnect()) {
            ChannelOutboundBuffer outboundBuffer = unsafe().outboundBuffer();
            outboundBuffer.addFlush();
            Object current = outboundBuffer.current();
            if (current instanceof ByteBuf) {
                long doWriteOrSendBytes = doWriteOrSendBytes((ByteBuf) current, (InetSocketAddress) socketAddress, true);
                if (doWriteOrSendBytes > 0) {
                    outboundBuffer.removeBytes(doWriteOrSendBytes);
                    return true;
                }
            }
        }
        return super.doConnect0(socketAddress);
    }

    public void setTcpMd5Sig(Map<InetAddress, byte[]> map) throws IOException {
        synchronized (this) {
            this.tcpMd5SigAddresses = TcpMd5Util.newTcpMd5Sigs(this, this.tcpMd5SigAddresses, map);
        }
    }

    public EpollTcpInfo tcpInfo() {
        return tcpInfo(new EpollTcpInfo());
    }

    public InetSocketAddress localAddress() {
        return (InetSocketAddress) super.localAddress();
    }

    public AbstractEpollChannel.AbstractEpollUnsafe newUnsafe() {
        return new EpollSocketChannelUnsafe();
    }

    public ServerSocketChannel parent() {
        return (ServerSocketChannel) super.parent();
    }

    public InetSocketAddress remoteAddress() {
        return (InetSocketAddress) super.remoteAddress();
    }

    public EpollTcpInfo tcpInfo(EpollTcpInfo epollTcpInfo) {
        try {
            this.socket.getTcpInfo(epollTcpInfo);
            return epollTcpInfo;
        } catch (IOException e) {
            throw new ChannelException((Throwable) e);
        }
    }

    public EpollSocketChannel(InternetProtocolFamily internetProtocolFamily) {
        super(LinuxSocket.newSocketStream(internetProtocolFamily), false);
    }

    public EpollSocketChannelConfig config() {
        return this.config;
    }

    public EpollSocketChannel(int i) {
        super(i);
    }

    public EpollSocketChannel(LinuxSocket linuxSocket, boolean z) {
        super(linuxSocket, z);
    }

    public EpollSocketChannel(Channel channel, LinuxSocket linuxSocket, InetSocketAddress inetSocketAddress) {
        super(channel, linuxSocket, inetSocketAddress);
        if (channel instanceof EpollServerSocketChannel) {
            this.tcpMd5SigAddresses = ((EpollServerSocketChannel) channel).tcpMd5SigAddresses();
        }
    }
}
