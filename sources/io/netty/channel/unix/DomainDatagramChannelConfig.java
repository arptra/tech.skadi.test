package io.netty.channel.unix;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelConfig;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;

public interface DomainDatagramChannelConfig extends ChannelConfig {
    int getSendBufferSize();

    DomainDatagramChannelConfig setAllocator(ByteBufAllocator byteBufAllocator);

    DomainDatagramChannelConfig setAutoClose(boolean z);

    DomainDatagramChannelConfig setAutoRead(boolean z);

    DomainDatagramChannelConfig setConnectTimeoutMillis(int i);

    @Deprecated
    DomainDatagramChannelConfig setMaxMessagesPerRead(int i);

    DomainDatagramChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator);

    DomainDatagramChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator);

    DomainDatagramChannelConfig setSendBufferSize(int i);

    DomainDatagramChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark);

    DomainDatagramChannelConfig setWriteSpinCount(int i);
}
