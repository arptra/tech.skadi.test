package io.netty.channel.epoll;

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
import io.netty.handler.codec.rtsp.RtspHeaders;
import io.netty.util.internal.ObjectUtil;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Map;

public class EpollChannelConfig extends DefaultChannelConfig {
    private volatile long maxBytesPerGatheringWrite = Limits.SSIZE_MAX;

    /* renamed from: io.netty.channel.epoll.EpollChannelConfig$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$channel$epoll$EpollMode;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                io.netty.channel.epoll.EpollMode[] r0 = io.netty.channel.epoll.EpollMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$netty$channel$epoll$EpollMode = r0
                io.netty.channel.epoll.EpollMode r1 = io.netty.channel.epoll.EpollMode.EDGE_TRIGGERED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$netty$channel$epoll$EpollMode     // Catch:{ NoSuchFieldError -> 0x001d }
                io.netty.channel.epoll.EpollMode r1 = io.netty.channel.epoll.EpollMode.LEVEL_TRIGGERED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.epoll.EpollChannelConfig.AnonymousClass1.<clinit>():void");
        }
    }

    public EpollChannelConfig(AbstractEpollChannel abstractEpollChannel) {
        super(abstractEpollChannel);
    }

    private void checkChannelNotRegistered() {
        if (this.channel.isRegistered()) {
            throw new IllegalStateException("EpollMode can only be changed before channel is registered");
        }
    }

    public final void autoReadCleared() {
        ((AbstractEpollChannel) this.channel).clearEpollIn();
    }

    public EpollMode getEpollMode() {
        return ((AbstractEpollChannel) this.channel).isFlagSet(Native.EPOLLET) ? EpollMode.EDGE_TRIGGERED : EpollMode.LEVEL_TRIGGERED;
    }

    public final long getMaxBytesPerGatheringWrite() {
        return this.maxBytesPerGatheringWrite;
    }

    public <T> T getOption(ChannelOption<T> channelOption) {
        if (channelOption == EpollChannelOption.EPOLL_MODE) {
            return getEpollMode();
        }
        try {
            if (channelOption instanceof IntegerUnixChannelOption) {
                IntegerUnixChannelOption integerUnixChannelOption = (IntegerUnixChannelOption) channelOption;
                return Integer.valueOf(((AbstractEpollChannel) this.channel).socket.getIntOpt(integerUnixChannelOption.level(), integerUnixChannelOption.optname()));
            } else if (!(channelOption instanceof RawUnixChannelOption)) {
                return super.getOption(channelOption);
            } else {
                RawUnixChannelOption rawUnixChannelOption = (RawUnixChannelOption) channelOption;
                ByteBuffer allocate = ByteBuffer.allocate(rawUnixChannelOption.length());
                ((AbstractEpollChannel) this.channel).socket.getRawOpt(rawUnixChannelOption.level(), rawUnixChannelOption.optname(), allocate);
                return allocate.flip();
            }
        } catch (IOException e) {
            throw new ChannelException((Throwable) e);
        }
    }

    public Map<ChannelOption<?>, Object> getOptions() {
        return getOptions(super.getOptions(), EpollChannelOption.EPOLL_MODE);
    }

    public EpollChannelConfig setEpollMode(EpollMode epollMode) {
        ObjectUtil.checkNotNull(epollMode, RtspHeaders.Values.MODE);
        try {
            int i = AnonymousClass1.$SwitchMap$io$netty$channel$epoll$EpollMode[epollMode.ordinal()];
            if (i == 1) {
                checkChannelNotRegistered();
                ((AbstractEpollChannel) this.channel).setFlag(Native.EPOLLET);
            } else if (i == 2) {
                checkChannelNotRegistered();
                ((AbstractEpollChannel) this.channel).clearFlag(Native.EPOLLET);
            } else {
                throw new Error();
            }
            return this;
        } catch (IOException e) {
            throw new ChannelException((Throwable) e);
        }
    }

    public final void setMaxBytesPerGatheringWrite(long j) {
        this.maxBytesPerGatheringWrite = j;
    }

    public <T> boolean setOption(ChannelOption<T> channelOption, T t) {
        validate(channelOption, t);
        if (channelOption == EpollChannelOption.EPOLL_MODE) {
            setEpollMode((EpollMode) t);
            return true;
        }
        try {
            if (channelOption instanceof IntegerUnixChannelOption) {
                IntegerUnixChannelOption integerUnixChannelOption = (IntegerUnixChannelOption) channelOption;
                ((AbstractEpollChannel) this.channel).socket.setIntOpt(integerUnixChannelOption.level(), integerUnixChannelOption.optname(), ((Integer) t).intValue());
                return true;
            } else if (!(channelOption instanceof RawUnixChannelOption)) {
                return super.setOption(channelOption, t);
            } else {
                RawUnixChannelOption rawUnixChannelOption = (RawUnixChannelOption) channelOption;
                ((AbstractEpollChannel) this.channel).socket.setRawOpt(rawUnixChannelOption.level(), rawUnixChannelOption.optname(), (ByteBuffer) t);
                return true;
            }
        } catch (IOException e) {
            throw new ChannelException((Throwable) e);
        }
    }

    public EpollChannelConfig setAllocator(ByteBufAllocator byteBufAllocator) {
        super.setAllocator(byteBufAllocator);
        return this;
    }

    public EpollChannelConfig setAutoRead(boolean z) {
        super.setAutoRead(z);
        return this;
    }

    public EpollChannelConfig setConnectTimeoutMillis(int i) {
        super.setConnectTimeoutMillis(i);
        return this;
    }

    @Deprecated
    public EpollChannelConfig setMaxMessagesPerRead(int i) {
        super.setMaxMessagesPerRead(i);
        return this;
    }

    public EpollChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator) {
        super.setMessageSizeEstimator(messageSizeEstimator);
        return this;
    }

    public EpollChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator) {
        if (recvByteBufAllocator.newHandle() instanceof RecvByteBufAllocator.ExtendedHandle) {
            super.setRecvByteBufAllocator(recvByteBufAllocator);
            return this;
        }
        throw new IllegalArgumentException("allocator.newHandle() must return an object of type: " + RecvByteBufAllocator.ExtendedHandle.class);
    }

    @Deprecated
    public EpollChannelConfig setWriteBufferHighWaterMark(int i) {
        super.setWriteBufferHighWaterMark(i);
        return this;
    }

    @Deprecated
    public EpollChannelConfig setWriteBufferLowWaterMark(int i) {
        super.setWriteBufferLowWaterMark(i);
        return this;
    }

    public EpollChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark) {
        super.setWriteBufferWaterMark(writeBufferWaterMark);
        return this;
    }

    public EpollChannelConfig setWriteSpinCount(int i) {
        super.setWriteSpinCount(i);
        return this;
    }

    public EpollChannelConfig(AbstractEpollChannel abstractEpollChannel, RecvByteBufAllocator recvByteBufAllocator) {
        super(abstractEpollChannel, recvByteBufAllocator);
    }
}
