package io.netty.channel.epoll;

import io.netty.channel.Channel;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.channel.EventLoop;
import io.netty.channel.ServerChannel;
import io.netty.channel.epoll.AbstractEpollChannel;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

public abstract class AbstractEpollServerChannel extends AbstractEpollChannel implements ServerChannel {
    private static final ChannelMetadata METADATA = new ChannelMetadata(false, 16);

    public final class EpollServerSocketUnsafe extends AbstractEpollChannel.AbstractEpollUnsafe {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final byte[] acceptedAddress = new byte[26];

        public EpollServerSocketUnsafe() {
            super();
        }

        public void connect(SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
            channelPromise.setFailure(new UnsupportedOperationException());
        }

        public void epollInReady() {
            EpollChannelConfig config = AbstractEpollServerChannel.this.config();
            if (AbstractEpollServerChannel.this.shouldBreakEpollInReady(config)) {
                clearEpollIn0();
                return;
            }
            EpollRecvByteAllocatorHandle recvBufAllocHandle = recvBufAllocHandle();
            recvBufAllocHandle.edgeTriggered(AbstractEpollServerChannel.this.isFlagSet(Native.EPOLLET));
            ChannelPipeline pipeline = AbstractEpollServerChannel.this.pipeline();
            recvBufAllocHandle.reset(config);
            recvBufAllocHandle.attemptedBytesRead(1);
            epollInBefore();
            while (true) {
                try {
                    recvBufAllocHandle.lastBytesRead(AbstractEpollServerChannel.this.socket.accept(this.acceptedAddress));
                    if (recvBufAllocHandle.lastBytesRead() != -1) {
                        recvBufAllocHandle.incMessagesRead(1);
                        this.readPending = false;
                        AbstractEpollServerChannel abstractEpollServerChannel = AbstractEpollServerChannel.this;
                        int lastBytesRead = recvBufAllocHandle.lastBytesRead();
                        byte[] bArr = this.acceptedAddress;
                        pipeline.fireChannelRead(abstractEpollServerChannel.newChildChannel(lastBytesRead, bArr, 1, bArr[0]));
                        if (!recvBufAllocHandle.continueReading()) {
                            break;
                        }
                    } else {
                        break;
                    }
                } catch (Throwable th) {
                    th = th;
                }
            }
            th = null;
            try {
                recvBufAllocHandle.readComplete();
                pipeline.fireChannelReadComplete();
                if (th != null) {
                    pipeline.fireExceptionCaught(th);
                }
            } finally {
                epollInFinally(config);
            }
        }
    }

    public AbstractEpollServerChannel(int i) {
        this(new LinuxSocket(i), false);
    }

    public boolean doConnect(SocketAddress socketAddress, SocketAddress socketAddress2) throws Exception {
        throw new UnsupportedOperationException();
    }

    public void doWrite(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        throw new UnsupportedOperationException();
    }

    public Object filterOutboundMessage(Object obj) throws Exception {
        throw new UnsupportedOperationException();
    }

    public /* bridge */ /* synthetic */ boolean isActive() {
        return super.isActive();
    }

    public boolean isCompatible(EventLoop eventLoop) {
        return eventLoop instanceof EpollEventLoop;
    }

    public /* bridge */ /* synthetic */ boolean isOpen() {
        return super.isOpen();
    }

    public ChannelMetadata metadata() {
        return METADATA;
    }

    public abstract Channel newChildChannel(int i, byte[] bArr, int i2, int i3) throws Exception;

    public InetSocketAddress remoteAddress0() {
        return null;
    }

    public AbstractEpollServerChannel(LinuxSocket linuxSocket) {
        this(linuxSocket, AbstractEpollChannel.isSoErrorZero(linuxSocket));
    }

    public AbstractEpollChannel.AbstractEpollUnsafe newUnsafe() {
        return new EpollServerSocketUnsafe();
    }

    public AbstractEpollServerChannel(LinuxSocket linuxSocket, boolean z) {
        super((Channel) null, linuxSocket, z);
    }
}
