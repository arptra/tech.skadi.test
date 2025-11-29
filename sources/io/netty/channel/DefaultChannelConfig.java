package io.netty.channel;

import com.honey.account.i.a;
import io.netty.buffer.ByteBufAllocator;
import io.netty.util.internal.ObjectUtil;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class DefaultChannelConfig implements ChannelConfig {
    private static final AtomicIntegerFieldUpdater<DefaultChannelConfig> AUTOREAD_UPDATER;
    private static final int DEFAULT_CONNECT_TIMEOUT = 30000;
    private static final MessageSizeEstimator DEFAULT_MSG_SIZE_ESTIMATOR = DefaultMessageSizeEstimator.DEFAULT;
    private static final AtomicReferenceFieldUpdater<DefaultChannelConfig, WriteBufferWaterMark> WATERMARK_UPDATER;
    private volatile ByteBufAllocator allocator;
    private volatile boolean autoClose;
    private volatile int autoRead;
    protected final Channel channel;
    private volatile int connectTimeoutMillis;
    private volatile int maxMessagesPerWrite;
    private volatile MessageSizeEstimator msgSizeEstimator;
    private volatile boolean pinEventExecutor;
    private volatile RecvByteBufAllocator rcvBufAllocator;
    private volatile WriteBufferWaterMark writeBufferWaterMark;
    private volatile int writeSpinCount;

    static {
        Class<DefaultChannelConfig> cls = DefaultChannelConfig.class;
        AUTOREAD_UPDATER = AtomicIntegerFieldUpdater.newUpdater(cls, "autoRead");
        WATERMARK_UPDATER = AtomicReferenceFieldUpdater.newUpdater(cls, WriteBufferWaterMark.class, "writeBufferWaterMark");
    }

    public DefaultChannelConfig(Channel channel2) {
        this(channel2, new AdaptiveRecvByteBufAllocator());
    }

    private boolean getPinEventExecutorPerGroup() {
        return this.pinEventExecutor;
    }

    private ChannelConfig setPinEventExecutorPerGroup(boolean z) {
        this.pinEventExecutor = z;
        return this;
    }

    public void autoReadCleared() {
    }

    public ByteBufAllocator getAllocator() {
        return this.allocator;
    }

    public int getConnectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    @Deprecated
    public int getMaxMessagesPerRead() {
        try {
            return ((MaxMessagesRecvByteBufAllocator) getRecvByteBufAllocator()).maxMessagesPerRead();
        } catch (ClassCastException e) {
            throw new IllegalStateException("getRecvByteBufAllocator() must return an object of type MaxMessagesRecvByteBufAllocator", e);
        }
    }

    public int getMaxMessagesPerWrite() {
        return this.maxMessagesPerWrite;
    }

    public MessageSizeEstimator getMessageSizeEstimator() {
        return this.msgSizeEstimator;
    }

    public <T> T getOption(ChannelOption<T> channelOption) {
        ObjectUtil.checkNotNull(channelOption, "option");
        if (channelOption == ChannelOption.CONNECT_TIMEOUT_MILLIS) {
            return Integer.valueOf(getConnectTimeoutMillis());
        }
        if (channelOption == ChannelOption.MAX_MESSAGES_PER_READ) {
            return Integer.valueOf(getMaxMessagesPerRead());
        }
        if (channelOption == ChannelOption.WRITE_SPIN_COUNT) {
            return Integer.valueOf(getWriteSpinCount());
        }
        if (channelOption == ChannelOption.ALLOCATOR) {
            return getAllocator();
        }
        if (channelOption == ChannelOption.RCVBUF_ALLOCATOR) {
            return getRecvByteBufAllocator();
        }
        if (channelOption == ChannelOption.AUTO_READ) {
            return Boolean.valueOf(isAutoRead());
        }
        if (channelOption == ChannelOption.AUTO_CLOSE) {
            return Boolean.valueOf(isAutoClose());
        }
        if (channelOption == ChannelOption.WRITE_BUFFER_HIGH_WATER_MARK) {
            return Integer.valueOf(getWriteBufferHighWaterMark());
        }
        if (channelOption == ChannelOption.WRITE_BUFFER_LOW_WATER_MARK) {
            return Integer.valueOf(getWriteBufferLowWaterMark());
        }
        if (channelOption == ChannelOption.WRITE_BUFFER_WATER_MARK) {
            return getWriteBufferWaterMark();
        }
        if (channelOption == ChannelOption.MESSAGE_SIZE_ESTIMATOR) {
            return getMessageSizeEstimator();
        }
        if (channelOption == ChannelOption.SINGLE_EVENTEXECUTOR_PER_GROUP) {
            return Boolean.valueOf(getPinEventExecutorPerGroup());
        }
        if (channelOption == ChannelOption.MAX_MESSAGES_PER_WRITE) {
            return Integer.valueOf(getMaxMessagesPerWrite());
        }
        return null;
    }

    public Map<ChannelOption<?>, Object> getOptions() {
        return getOptions((Map<ChannelOption<?>, Object>) null, ChannelOption.CONNECT_TIMEOUT_MILLIS, ChannelOption.MAX_MESSAGES_PER_READ, ChannelOption.WRITE_SPIN_COUNT, ChannelOption.ALLOCATOR, ChannelOption.AUTO_READ, ChannelOption.AUTO_CLOSE, ChannelOption.RCVBUF_ALLOCATOR, ChannelOption.WRITE_BUFFER_HIGH_WATER_MARK, ChannelOption.WRITE_BUFFER_LOW_WATER_MARK, ChannelOption.WRITE_BUFFER_WATER_MARK, ChannelOption.MESSAGE_SIZE_ESTIMATOR, ChannelOption.SINGLE_EVENTEXECUTOR_PER_GROUP, ChannelOption.MAX_MESSAGES_PER_WRITE);
    }

    public <T extends RecvByteBufAllocator> T getRecvByteBufAllocator() {
        return this.rcvBufAllocator;
    }

    public int getWriteBufferHighWaterMark() {
        return this.writeBufferWaterMark.high();
    }

    public int getWriteBufferLowWaterMark() {
        return this.writeBufferWaterMark.low();
    }

    public WriteBufferWaterMark getWriteBufferWaterMark() {
        return this.writeBufferWaterMark;
    }

    public int getWriteSpinCount() {
        return this.writeSpinCount;
    }

    public boolean isAutoClose() {
        return this.autoClose;
    }

    public boolean isAutoRead() {
        return this.autoRead == 1;
    }

    public ChannelConfig setAllocator(ByteBufAllocator byteBufAllocator) {
        this.allocator = (ByteBufAllocator) ObjectUtil.checkNotNull(byteBufAllocator, "allocator");
        return this;
    }

    public ChannelConfig setAutoClose(boolean z) {
        this.autoClose = z;
        return this;
    }

    public ChannelConfig setAutoRead(boolean z) {
        boolean z2 = true;
        if (AUTOREAD_UPDATER.getAndSet(this, z ? 1 : 0) != 1) {
            z2 = false;
        }
        if (z && !z2) {
            this.channel.read();
        } else if (!z && z2) {
            autoReadCleared();
        }
        return this;
    }

    public ChannelConfig setConnectTimeoutMillis(int i) {
        ObjectUtil.checkPositiveOrZero(i, "connectTimeoutMillis");
        this.connectTimeoutMillis = i;
        return this;
    }

    @Deprecated
    public ChannelConfig setMaxMessagesPerRead(int i) {
        try {
            ((MaxMessagesRecvByteBufAllocator) getRecvByteBufAllocator()).maxMessagesPerRead(i);
            return this;
        } catch (ClassCastException e) {
            throw new IllegalStateException("getRecvByteBufAllocator() must return an object of type MaxMessagesRecvByteBufAllocator", e);
        }
    }

    public ChannelConfig setMaxMessagesPerWrite(int i) {
        this.maxMessagesPerWrite = ObjectUtil.checkPositive(i, "maxMessagesPerWrite");
        return this;
    }

    public ChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator) {
        this.msgSizeEstimator = (MessageSizeEstimator) ObjectUtil.checkNotNull(messageSizeEstimator, "estimator");
        return this;
    }

    public <T> boolean setOption(ChannelOption<T> channelOption, T t) {
        validate(channelOption, t);
        if (channelOption == ChannelOption.CONNECT_TIMEOUT_MILLIS) {
            setConnectTimeoutMillis(((Integer) t).intValue());
            return true;
        } else if (channelOption == ChannelOption.MAX_MESSAGES_PER_READ) {
            setMaxMessagesPerRead(((Integer) t).intValue());
            return true;
        } else if (channelOption == ChannelOption.WRITE_SPIN_COUNT) {
            setWriteSpinCount(((Integer) t).intValue());
            return true;
        } else if (channelOption == ChannelOption.ALLOCATOR) {
            setAllocator((ByteBufAllocator) t);
            return true;
        } else if (channelOption == ChannelOption.RCVBUF_ALLOCATOR) {
            setRecvByteBufAllocator((RecvByteBufAllocator) t);
            return true;
        } else if (channelOption == ChannelOption.AUTO_READ) {
            setAutoRead(((Boolean) t).booleanValue());
            return true;
        } else if (channelOption == ChannelOption.AUTO_CLOSE) {
            setAutoClose(((Boolean) t).booleanValue());
            return true;
        } else if (channelOption == ChannelOption.WRITE_BUFFER_HIGH_WATER_MARK) {
            setWriteBufferHighWaterMark(((Integer) t).intValue());
            return true;
        } else if (channelOption == ChannelOption.WRITE_BUFFER_LOW_WATER_MARK) {
            setWriteBufferLowWaterMark(((Integer) t).intValue());
            return true;
        } else if (channelOption == ChannelOption.WRITE_BUFFER_WATER_MARK) {
            setWriteBufferWaterMark((WriteBufferWaterMark) t);
            return true;
        } else if (channelOption == ChannelOption.MESSAGE_SIZE_ESTIMATOR) {
            setMessageSizeEstimator((MessageSizeEstimator) t);
            return true;
        } else if (channelOption == ChannelOption.SINGLE_EVENTEXECUTOR_PER_GROUP) {
            setPinEventExecutorPerGroup(((Boolean) t).booleanValue());
            return true;
        } else if (channelOption != ChannelOption.MAX_MESSAGES_PER_WRITE) {
            return false;
        } else {
            setMaxMessagesPerWrite(((Integer) t).intValue());
            return true;
        }
    }

    public boolean setOptions(Map<ChannelOption<?>, ?> map) {
        ObjectUtil.checkNotNull(map, "options");
        boolean z = true;
        for (Map.Entry next : map.entrySet()) {
            if (!setOption((ChannelOption) next.getKey(), next.getValue())) {
                z = false;
            }
        }
        return z;
    }

    public ChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator) {
        this.rcvBufAllocator = (RecvByteBufAllocator) ObjectUtil.checkNotNull(recvByteBufAllocator, "allocator");
        return this;
    }

    public ChannelConfig setWriteBufferHighWaterMark(int i) {
        WriteBufferWaterMark writeBufferWaterMark2;
        ObjectUtil.checkPositiveOrZero(i, "writeBufferHighWaterMark");
        do {
            writeBufferWaterMark2 = this.writeBufferWaterMark;
            if (i < writeBufferWaterMark2.low()) {
                throw new IllegalArgumentException("writeBufferHighWaterMark cannot be less than writeBufferLowWaterMark (" + writeBufferWaterMark2.low() + "): " + i);
            }
        } while (!a.a(WATERMARK_UPDATER, this, writeBufferWaterMark2, new WriteBufferWaterMark(writeBufferWaterMark2.low(), i, false)));
        return this;
    }

    public ChannelConfig setWriteBufferLowWaterMark(int i) {
        WriteBufferWaterMark writeBufferWaterMark2;
        ObjectUtil.checkPositiveOrZero(i, "writeBufferLowWaterMark");
        do {
            writeBufferWaterMark2 = this.writeBufferWaterMark;
            if (i > writeBufferWaterMark2.high()) {
                throw new IllegalArgumentException("writeBufferLowWaterMark cannot be greater than writeBufferHighWaterMark (" + writeBufferWaterMark2.high() + "): " + i);
            }
        } while (!a.a(WATERMARK_UPDATER, this, writeBufferWaterMark2, new WriteBufferWaterMark(i, writeBufferWaterMark2.high(), false)));
        return this;
    }

    public ChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark2) {
        this.writeBufferWaterMark = (WriteBufferWaterMark) ObjectUtil.checkNotNull(writeBufferWaterMark2, "writeBufferWaterMark");
        return this;
    }

    public ChannelConfig setWriteSpinCount(int i) {
        ObjectUtil.checkPositive(i, "writeSpinCount");
        if (i == Integer.MAX_VALUE) {
            i--;
        }
        this.writeSpinCount = i;
        return this;
    }

    public <T> void validate(ChannelOption<T> channelOption, T t) {
        ((ChannelOption) ObjectUtil.checkNotNull(channelOption, "option")).validate(t);
    }

    public DefaultChannelConfig(Channel channel2, RecvByteBufAllocator recvByteBufAllocator) {
        this.allocator = ByteBufAllocator.DEFAULT;
        this.msgSizeEstimator = DEFAULT_MSG_SIZE_ESTIMATOR;
        this.connectTimeoutMillis = 30000;
        this.writeSpinCount = 16;
        this.maxMessagesPerWrite = Integer.MAX_VALUE;
        this.autoRead = 1;
        this.autoClose = true;
        this.writeBufferWaterMark = WriteBufferWaterMark.DEFAULT;
        this.pinEventExecutor = true;
        setRecvByteBufAllocator(recvByteBufAllocator, channel2.metadata());
        this.channel = channel2;
    }

    private void setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator, ChannelMetadata channelMetadata) {
        ObjectUtil.checkNotNull(recvByteBufAllocator, "allocator");
        ObjectUtil.checkNotNull(channelMetadata, "metadata");
        if (recvByteBufAllocator instanceof MaxMessagesRecvByteBufAllocator) {
            ((MaxMessagesRecvByteBufAllocator) recvByteBufAllocator).maxMessagesPerRead(channelMetadata.defaultMaxMessagesPerRead());
        }
        setRecvByteBufAllocator(recvByteBufAllocator);
    }

    public Map<ChannelOption<?>, Object> getOptions(Map<ChannelOption<?>, Object> map, ChannelOption<?>... channelOptionArr) {
        if (map == null) {
            map = new IdentityHashMap<>();
        }
        for (ChannelOption<?> channelOption : channelOptionArr) {
            map.put(channelOption, getOption(channelOption));
        }
        return map;
    }
}
