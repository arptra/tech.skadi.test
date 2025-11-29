package io.netty.channel.kqueue;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelOption;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import io.netty.channel.unix.IntegerUnixChannelOption;
import io.netty.channel.unix.Limits;
import io.netty.channel.unix.RawUnixChannelOption;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Map;

public class KQueueChannelConfig extends DefaultChannelConfig {
    private volatile long maxBytesPerGatheringWrite = Limits.SSIZE_MAX;
    private volatile boolean transportProvidesGuess;

    public KQueueChannelConfig(AbstractKQueueChannel abstractKQueueChannel) {
        super(abstractKQueueChannel);
    }

    public final void autoReadCleared() {
        ((AbstractKQueueChannel) this.channel).clearReadFilter();
    }

    public final long getMaxBytesPerGatheringWrite() {
        return this.maxBytesPerGatheringWrite;
    }

    public <T> T getOption(ChannelOption<T> channelOption) {
        if (channelOption == KQueueChannelOption.RCV_ALLOC_TRANSPORT_PROVIDES_GUESS) {
            return Boolean.valueOf(getRcvAllocTransportProvidesGuess());
        }
        try {
            if (channelOption instanceof IntegerUnixChannelOption) {
                IntegerUnixChannelOption integerUnixChannelOption = (IntegerUnixChannelOption) channelOption;
                return Integer.valueOf(((AbstractKQueueChannel) this.channel).socket.getIntOpt(integerUnixChannelOption.level(), integerUnixChannelOption.optname()));
            } else if (!(channelOption instanceof RawUnixChannelOption)) {
                return super.getOption(channelOption);
            } else {
                RawUnixChannelOption rawUnixChannelOption = (RawUnixChannelOption) channelOption;
                ByteBuffer allocate = ByteBuffer.allocate(rawUnixChannelOption.length());
                ((AbstractKQueueChannel) this.channel).socket.getRawOpt(rawUnixChannelOption.level(), rawUnixChannelOption.optname(), allocate);
                return allocate.flip();
            }
        } catch (IOException e) {
            throw new ChannelException((Throwable) e);
        }
    }

    public Map<ChannelOption<?>, Object> getOptions() {
        return getOptions(super.getOptions(), KQueueChannelOption.RCV_ALLOC_TRANSPORT_PROVIDES_GUESS);
    }

    public boolean getRcvAllocTransportProvidesGuess() {
        return this.transportProvidesGuess;
    }

    public final void setMaxBytesPerGatheringWrite(long j) {
        this.maxBytesPerGatheringWrite = Math.min(Limits.SSIZE_MAX, j);
    }

    public <T> boolean setOption(ChannelOption<T> channelOption, T t) {
        validate(channelOption, t);
        if (channelOption == KQueueChannelOption.RCV_ALLOC_TRANSPORT_PROVIDES_GUESS) {
            setRcvAllocTransportProvidesGuess(((Boolean) t).booleanValue());
            return true;
        }
        try {
            if (channelOption instanceof IntegerUnixChannelOption) {
                IntegerUnixChannelOption integerUnixChannelOption = (IntegerUnixChannelOption) channelOption;
                ((AbstractKQueueChannel) this.channel).socket.setIntOpt(integerUnixChannelOption.level(), integerUnixChannelOption.optname(), ((Integer) t).intValue());
                return true;
            } else if (!(channelOption instanceof RawUnixChannelOption)) {
                return super.setOption(channelOption, t);
            } else {
                RawUnixChannelOption rawUnixChannelOption = (RawUnixChannelOption) channelOption;
                ((AbstractKQueueChannel) this.channel).socket.setRawOpt(rawUnixChannelOption.level(), rawUnixChannelOption.optname(), (ByteBuffer) t);
                return true;
            }
        } catch (IOException e) {
            throw new ChannelException((Throwable) e);
        }
    }

    public KQueueChannelConfig setRcvAllocTransportProvidesGuess(boolean z) {
        this.transportProvidesGuess = z;
        return this;
    }

    public KQueueChannelConfig setAllocator(ByteBufAllocator byteBufAllocator) {
        super.setAllocator(byteBufAllocator);
        return this;
    }

    public KQueueChannelConfig setAutoRead(boolean z) {
        super.setAutoRead(z);
        return this;
    }

    public KQueueChannelConfig setConnectTimeoutMillis(int i) {
        super.setConnectTimeoutMillis(i);
        return this;
    }

    @Deprecated
    public KQueueChannelConfig setMaxMessagesPerRead(int i) {
        super.setMaxMessagesPerRead(i);
        return this;
    }

    public KQueueChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator) {
        super.setMessageSizeEstimator(messageSizeEstimator);
        return this;
    }

    public KQueueChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator) {
        if (recvByteBufAllocator.newHandle() instanceof RecvByteBufAllocator.ExtendedHandle) {
            super.setRecvByteBufAllocator(recvByteBufAllocator);
            return this;
        }
        throw new IllegalArgumentException("allocator.newHandle() must return an object of type: " + RecvByteBufAllocator.ExtendedHandle.class);
    }

    @Deprecated
    public KQueueChannelConfig setWriteBufferHighWaterMark(int i) {
        super.setWriteBufferHighWaterMark(i);
        return this;
    }

    @Deprecated
    public KQueueChannelConfig setWriteBufferLowWaterMark(int i) {
        super.setWriteBufferLowWaterMark(i);
        return this;
    }

    public KQueueChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark) {
        super.setWriteBufferWaterMark(writeBufferWaterMark);
        return this;
    }

    public KQueueChannelConfig setWriteSpinCount(int i) {
        super.setWriteSpinCount(i);
        return this;
    }

    public KQueueChannelConfig(AbstractKQueueChannel abstractKQueueChannel, RecvByteBufAllocator recvByteBufAllocator) {
        super(abstractKQueueChannel, recvByteBufAllocator);
    }
}
