package io.netty.bootstrap;

import io.netty.channel.AbstractChannel;
import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.EventLoop;
import java.net.SocketAddress;

final class FailedChannel extends AbstractChannel {
    private static final ChannelMetadata METADATA = new ChannelMetadata(false);
    private final ChannelConfig config = new DefaultChannelConfig(this);

    public final class FailedChannelUnsafe extends AbstractChannel.AbstractUnsafe {
        private FailedChannelUnsafe() {
            super();
        }

        public void connect(SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
            channelPromise.setFailure(new UnsupportedOperationException());
        }
    }

    public FailedChannel() {
        super((Channel) null);
    }

    public ChannelConfig config() {
        return this.config;
    }

    public void doBeginRead() {
        throw new UnsupportedOperationException();
    }

    public void doBind(SocketAddress socketAddress) {
        throw new UnsupportedOperationException();
    }

    public void doClose() {
        throw new UnsupportedOperationException();
    }

    public void doDisconnect() {
        throw new UnsupportedOperationException();
    }

    public void doWrite(ChannelOutboundBuffer channelOutboundBuffer) {
        throw new UnsupportedOperationException();
    }

    public boolean isActive() {
        return false;
    }

    public boolean isCompatible(EventLoop eventLoop) {
        return false;
    }

    public boolean isOpen() {
        return false;
    }

    public SocketAddress localAddress0() {
        return null;
    }

    public ChannelMetadata metadata() {
        return METADATA;
    }

    public AbstractChannel.AbstractUnsafe newUnsafe() {
        return new FailedChannelUnsafe();
    }

    public SocketAddress remoteAddress0() {
        return null;
    }
}
