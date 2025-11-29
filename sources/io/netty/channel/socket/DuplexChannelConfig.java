package io.netty.channel.socket;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelConfig;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;

public interface DuplexChannelConfig extends ChannelConfig {
    boolean isAllowHalfClosure();

    DuplexChannelConfig setAllocator(ByteBufAllocator byteBufAllocator);

    DuplexChannelConfig setAllowHalfClosure(boolean z);

    DuplexChannelConfig setAutoClose(boolean z);

    DuplexChannelConfig setAutoRead(boolean z);

    @Deprecated
    DuplexChannelConfig setMaxMessagesPerRead(int i);

    DuplexChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator);

    DuplexChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator);

    DuplexChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark);

    DuplexChannelConfig setWriteSpinCount(int i);
}
