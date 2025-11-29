package io.netty.channel.kqueue;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelOption;
import io.netty.channel.FixedRecvByteBufAllocator;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import io.netty.channel.unix.DomainDatagramChannelConfig;
import java.io.IOException;
import java.util.Map;

public final class KQueueDomainDatagramChannelConfig extends KQueueChannelConfig implements DomainDatagramChannelConfig {
    private boolean activeOnOpen;

    public KQueueDomainDatagramChannelConfig(KQueueDomainDatagramChannel kQueueDomainDatagramChannel) {
        super(kQueueDomainDatagramChannel);
        setRecvByteBufAllocator((RecvByteBufAllocator) new FixedRecvByteBufAllocator(2048));
    }

    private void setActiveOnOpen(boolean z) {
        if (!this.channel.isRegistered()) {
            this.activeOnOpen = z;
            return;
        }
        throw new IllegalStateException("Can only changed before channel was registered");
    }

    public boolean getActiveOnOpen() {
        return this.activeOnOpen;
    }

    public <T> T getOption(ChannelOption<T> channelOption) {
        return channelOption == ChannelOption.DATAGRAM_CHANNEL_ACTIVE_ON_REGISTRATION ? Boolean.valueOf(this.activeOnOpen) : channelOption == ChannelOption.SO_SNDBUF ? Integer.valueOf(getSendBufferSize()) : super.getOption(channelOption);
    }

    public Map<ChannelOption<?>, Object> getOptions() {
        return getOptions(super.getOptions(), ChannelOption.DATAGRAM_CHANNEL_ACTIVE_ON_REGISTRATION, ChannelOption.SO_SNDBUF);
    }

    public int getSendBufferSize() {
        try {
            return ((KQueueDomainDatagramChannel) this.channel).socket.getSendBufferSize();
        } catch (IOException e) {
            throw new ChannelException((Throwable) e);
        }
    }

    public <T> boolean setOption(ChannelOption<T> channelOption, T t) {
        validate(channelOption, t);
        if (channelOption == ChannelOption.DATAGRAM_CHANNEL_ACTIVE_ON_REGISTRATION) {
            setActiveOnOpen(((Boolean) t).booleanValue());
            return true;
        } else if (channelOption != ChannelOption.SO_SNDBUF) {
            return super.setOption(channelOption, t);
        } else {
            setSendBufferSize(((Integer) t).intValue());
            return true;
        }
    }

    public KQueueDomainDatagramChannelConfig setMaxMessagesPerWrite(int i) {
        super.setMaxMessagesPerWrite(i);
        return this;
    }

    public KQueueDomainDatagramChannelConfig setRcvAllocTransportProvidesGuess(boolean z) {
        super.setRcvAllocTransportProvidesGuess(z);
        return this;
    }

    public KQueueDomainDatagramChannelConfig setSendBufferSize(int i) {
        try {
            ((KQueueDomainDatagramChannel) this.channel).socket.setSendBufferSize(i);
            return this;
        } catch (IOException e) {
            throw new ChannelException((Throwable) e);
        }
    }

    public KQueueDomainDatagramChannelConfig setAutoClose(boolean z) {
        super.setAutoClose(z);
        return this;
    }

    public KQueueDomainDatagramChannelConfig setAllocator(ByteBufAllocator byteBufAllocator) {
        super.setAllocator(byteBufAllocator);
        return this;
    }

    public KQueueDomainDatagramChannelConfig setAutoRead(boolean z) {
        super.setAutoRead(z);
        return this;
    }

    public KQueueDomainDatagramChannelConfig setConnectTimeoutMillis(int i) {
        super.setConnectTimeoutMillis(i);
        return this;
    }

    @Deprecated
    public KQueueDomainDatagramChannelConfig setMaxMessagesPerRead(int i) {
        super.setMaxMessagesPerRead(i);
        return this;
    }

    public KQueueDomainDatagramChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator) {
        super.setMessageSizeEstimator(messageSizeEstimator);
        return this;
    }

    public KQueueDomainDatagramChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator) {
        super.setRecvByteBufAllocator(recvByteBufAllocator);
        return this;
    }

    public KQueueDomainDatagramChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark) {
        super.setWriteBufferWaterMark(writeBufferWaterMark);
        return this;
    }

    public KQueueDomainDatagramChannelConfig setWriteSpinCount(int i) {
        super.setWriteSpinCount(i);
        return this;
    }
}
