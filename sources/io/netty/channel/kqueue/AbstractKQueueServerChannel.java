package io.netty.channel.kqueue;

import io.netty.channel.Channel;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoop;
import io.netty.channel.ServerChannel;
import io.netty.channel.kqueue.AbstractKQueueChannel;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

public abstract class AbstractKQueueServerChannel extends AbstractKQueueChannel implements ServerChannel {
    private static final ChannelMetadata METADATA = new ChannelMetadata(false, 16);

    public final class KQueueServerSocketUnsafe extends AbstractKQueueChannel.AbstractKQueueUnsafe {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final byte[] acceptedAddress = new byte[26];

        public KQueueServerSocketUnsafe() {
            super();
        }

        public void readReady(KQueueRecvByteAllocatorHandle kQueueRecvByteAllocatorHandle) {
            KQueueChannelConfig config = AbstractKQueueServerChannel.this.config();
            if (AbstractKQueueServerChannel.this.shouldBreakReadReady(config)) {
                clearReadFilter0();
                return;
            }
            ChannelPipeline pipeline = AbstractKQueueServerChannel.this.pipeline();
            kQueueRecvByteAllocatorHandle.reset(config);
            kQueueRecvByteAllocatorHandle.attemptedBytesRead(1);
            readReadyBefore();
            while (true) {
                try {
                    int accept = AbstractKQueueServerChannel.this.socket.accept(this.acceptedAddress);
                    if (accept != -1) {
                        kQueueRecvByteAllocatorHandle.lastBytesRead(1);
                        kQueueRecvByteAllocatorHandle.incMessagesRead(1);
                        this.readPending = false;
                        AbstractKQueueServerChannel abstractKQueueServerChannel = AbstractKQueueServerChannel.this;
                        byte[] bArr = this.acceptedAddress;
                        pipeline.fireChannelRead(abstractKQueueServerChannel.newChildChannel(accept, bArr, 1, bArr[0]));
                        if (!kQueueRecvByteAllocatorHandle.continueReading()) {
                            break;
                        }
                    } else {
                        kQueueRecvByteAllocatorHandle.lastBytesRead(-1);
                        break;
                    }
                } catch (Throwable th) {
                    th = th;
                }
            }
            th = null;
            try {
                kQueueRecvByteAllocatorHandle.readComplete();
                pipeline.fireChannelReadComplete();
                if (th != null) {
                    pipeline.fireExceptionCaught(th);
                }
            } finally {
                readReadyFinally(config);
            }
        }
    }

    public AbstractKQueueServerChannel(BsdSocket bsdSocket) {
        this(bsdSocket, AbstractKQueueChannel.isSoErrorZero(bsdSocket));
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
        return eventLoop instanceof KQueueEventLoop;
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

    public AbstractKQueueServerChannel(BsdSocket bsdSocket, boolean z) {
        super((Channel) null, bsdSocket, z);
    }

    public AbstractKQueueChannel.AbstractKQueueUnsafe newUnsafe() {
        return new KQueueServerSocketUnsafe();
    }
}
