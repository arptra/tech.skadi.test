package io.netty.channel.oio;

import io.netty.channel.AbstractChannel;
import io.netty.channel.Channel;
import io.netty.channel.ChannelPromise;
import io.netty.channel.EventLoop;
import io.netty.channel.ThreadPerChannelEventLoop;
import java.net.SocketAddress;

@Deprecated
public abstract class AbstractOioChannel extends AbstractChannel {
    protected static final int SO_TIMEOUT = 1000;
    private final Runnable clearReadPendingRunnable = new Runnable() {
        public void run() {
            AbstractOioChannel.this.readPending = false;
        }
    };
    boolean readPending;
    final Runnable readTask = new Runnable() {
        public void run() {
            AbstractOioChannel.this.doRead();
        }
    };
    boolean readWhenInactive;

    public final class DefaultOioUnsafe extends AbstractChannel.AbstractUnsafe {
        private DefaultOioUnsafe() {
            super();
        }

        public void connect(SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
            if (channelPromise.setUncancellable() && ensureOpen(channelPromise)) {
                try {
                    boolean isActive = AbstractOioChannel.this.isActive();
                    AbstractOioChannel.this.doConnect(socketAddress, socketAddress2);
                    boolean isActive2 = AbstractOioChannel.this.isActive();
                    safeSetSuccess(channelPromise);
                    if (!isActive && isActive2) {
                        AbstractOioChannel.this.pipeline().fireChannelActive();
                    }
                } catch (Throwable th) {
                    safeSetFailure(channelPromise, annotateConnectException(th, socketAddress));
                    closeIfClosed();
                }
            }
        }
    }

    public AbstractOioChannel(Channel channel) {
        super(channel);
    }

    public final void clearReadPending() {
        if (isRegistered()) {
            EventLoop eventLoop = eventLoop();
            if (eventLoop.inEventLoop()) {
                this.readPending = false;
            } else {
                eventLoop.execute(this.clearReadPendingRunnable);
            }
        } else {
            this.readPending = false;
        }
    }

    public void doBeginRead() throws Exception {
        if (!this.readPending) {
            if (!isActive()) {
                this.readWhenInactive = true;
                return;
            }
            this.readPending = true;
            eventLoop().execute(this.readTask);
        }
    }

    public abstract void doConnect(SocketAddress socketAddress, SocketAddress socketAddress2) throws Exception;

    public abstract void doRead();

    public boolean isCompatible(EventLoop eventLoop) {
        return eventLoop instanceof ThreadPerChannelEventLoop;
    }

    @Deprecated
    public boolean isReadPending() {
        return this.readPending;
    }

    public AbstractChannel.AbstractUnsafe newUnsafe() {
        return new DefaultOioUnsafe();
    }

    @Deprecated
    public void setReadPending(final boolean z) {
        if (isRegistered()) {
            EventLoop eventLoop = eventLoop();
            if (eventLoop.inEventLoop()) {
                this.readPending = z;
            } else {
                eventLoop.execute(new Runnable() {
                    public void run() {
                        AbstractOioChannel.this.readPending = z;
                    }
                });
            }
        } else {
            this.readPending = z;
        }
    }
}
