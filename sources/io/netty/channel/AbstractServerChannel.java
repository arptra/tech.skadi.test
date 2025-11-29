package io.netty.channel;

import io.netty.channel.AbstractChannel;
import java.net.SocketAddress;

public abstract class AbstractServerChannel extends AbstractChannel implements ServerChannel {
    private static final ChannelMetadata METADATA = new ChannelMetadata(false, 16);

    public final class DefaultServerUnsafe extends AbstractChannel.AbstractUnsafe {
        private DefaultServerUnsafe() {
            super();
        }

        public void connect(SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
            safeSetFailure(channelPromise, new UnsupportedOperationException());
        }
    }

    public AbstractServerChannel() {
        super((Channel) null);
    }

    public void doDisconnect() throws Exception {
        throw new UnsupportedOperationException();
    }

    public void doWrite(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        throw new UnsupportedOperationException();
    }

    public final Object filterOutboundMessage(Object obj) {
        throw new UnsupportedOperationException();
    }

    public ChannelMetadata metadata() {
        return METADATA;
    }

    public AbstractChannel.AbstractUnsafe newUnsafe() {
        return new DefaultServerUnsafe();
    }

    public SocketAddress remoteAddress() {
        return null;
    }

    public SocketAddress remoteAddress0() {
        return null;
    }
}
