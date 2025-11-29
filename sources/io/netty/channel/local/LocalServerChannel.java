package io.netty.channel.local;

import io.netty.channel.AbstractServerChannel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.EventLoop;
import io.netty.channel.PreferHeapByteBufAllocator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.ServerChannelRecvByteBufAllocator;
import io.netty.channel.SingleThreadEventLoop;
import io.netty.util.concurrent.SingleThreadEventExecutor;
import java.net.SocketAddress;
import java.util.ArrayDeque;
import java.util.Queue;

public class LocalServerChannel extends AbstractServerChannel {
    private volatile boolean acceptInProgress;
    private final ChannelConfig config;
    private final Queue<Object> inboundBuffer = new ArrayDeque();
    private volatile LocalAddress localAddress;
    private final Runnable shutdownHook = new Runnable() {
        public void run() {
            LocalServerChannel.this.unsafe().close(LocalServerChannel.this.unsafe().voidPromise());
        }
    };
    private volatile int state;

    public LocalServerChannel() {
        AnonymousClass1 r0 = new DefaultChannelConfig(this, new ServerChannelRecvByteBufAllocator()) {
        };
        this.config = r0;
        config().setAllocator(new PreferHeapByteBufAllocator(r0.getAllocator()));
    }

    private void readInbound() {
        RecvByteBufAllocator.Handle recvBufAllocHandle = unsafe().recvBufAllocHandle();
        recvBufAllocHandle.reset(config());
        ChannelPipeline pipeline = pipeline();
        do {
            Object poll = this.inboundBuffer.poll();
            if (poll == null) {
                break;
            }
            pipeline.fireChannelRead(poll);
        } while (recvBufAllocHandle.continueReading());
        recvBufAllocHandle.readComplete();
        pipeline.fireChannelReadComplete();
    }

    /* access modifiers changed from: private */
    public void serve0(LocalChannel localChannel) {
        this.inboundBuffer.add(localChannel);
        if (this.acceptInProgress) {
            this.acceptInProgress = false;
            readInbound();
        }
    }

    public ChannelConfig config() {
        return this.config;
    }

    public void doBeginRead() throws Exception {
        if (!this.acceptInProgress) {
            if (this.inboundBuffer.isEmpty()) {
                this.acceptInProgress = true;
            } else {
                readInbound();
            }
        }
    }

    public void doBind(SocketAddress socketAddress) throws Exception {
        this.localAddress = LocalChannelRegistry.register(this, this.localAddress, socketAddress);
        this.state = 1;
    }

    public void doClose() throws Exception {
        if (this.state <= 1) {
            if (this.localAddress != null) {
                LocalChannelRegistry.unregister(this.localAddress);
                this.localAddress = null;
            }
            this.state = 2;
        }
    }

    public void doDeregister() throws Exception {
        ((SingleThreadEventExecutor) eventLoop()).removeShutdownHook(this.shutdownHook);
    }

    public void doRegister() throws Exception {
        ((SingleThreadEventExecutor) eventLoop()).addShutdownHook(this.shutdownHook);
    }

    public boolean isActive() {
        return this.state == 1;
    }

    public boolean isCompatible(EventLoop eventLoop) {
        return eventLoop instanceof SingleThreadEventLoop;
    }

    public boolean isOpen() {
        return this.state < 2;
    }

    public SocketAddress localAddress0() {
        return this.localAddress;
    }

    public LocalChannel newLocalChannel(LocalChannel localChannel) {
        return new LocalChannel(this, localChannel);
    }

    public LocalChannel serve(LocalChannel localChannel) {
        final LocalChannel newLocalChannel = newLocalChannel(localChannel);
        if (eventLoop().inEventLoop()) {
            serve0(newLocalChannel);
        } else {
            eventLoop().execute(new Runnable() {
                public void run() {
                    LocalServerChannel.this.serve0(newLocalChannel);
                }
            });
        }
        return newLocalChannel;
    }

    public LocalAddress localAddress() {
        return (LocalAddress) super.localAddress();
    }

    public LocalAddress remoteAddress() {
        return (LocalAddress) super.remoteAddress();
    }
}
