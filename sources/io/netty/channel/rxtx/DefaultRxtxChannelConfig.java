package io.netty.channel.rxtx;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelOption;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.PreferHeapByteBufAllocator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import io.netty.channel.rxtx.RxtxChannelConfig;
import io.netty.util.internal.ObjectUtil;
import java.util.Map;

@Deprecated
final class DefaultRxtxChannelConfig extends DefaultChannelConfig implements RxtxChannelConfig {
    private volatile int baudrate = 115200;
    private volatile RxtxChannelConfig.Databits databits = RxtxChannelConfig.Databits.DATABITS_8;
    private volatile boolean dtr;
    private volatile RxtxChannelConfig.Paritybit paritybit = RxtxChannelConfig.Paritybit.NONE;
    private volatile int readTimeout = 1000;
    private volatile boolean rts;
    private volatile RxtxChannelConfig.Stopbits stopbits = RxtxChannelConfig.Stopbits.STOPBITS_1;
    private volatile int waitTime;

    public DefaultRxtxChannelConfig(RxtxChannel rxtxChannel) {
        super(rxtxChannel);
        setAllocator((ByteBufAllocator) new PreferHeapByteBufAllocator(getAllocator()));
    }

    public int getBaudrate() {
        return this.baudrate;
    }

    public RxtxChannelConfig.Databits getDatabits() {
        return this.databits;
    }

    public <T> T getOption(ChannelOption<T> channelOption) {
        return channelOption == RxtxChannelOption.BAUD_RATE ? Integer.valueOf(getBaudrate()) : channelOption == RxtxChannelOption.DTR ? Boolean.valueOf(isDtr()) : channelOption == RxtxChannelOption.RTS ? Boolean.valueOf(isRts()) : channelOption == RxtxChannelOption.STOP_BITS ? getStopbits() : channelOption == RxtxChannelOption.DATA_BITS ? getDatabits() : channelOption == RxtxChannelOption.PARITY_BIT ? getParitybit() : channelOption == RxtxChannelOption.WAIT_TIME ? Integer.valueOf(getWaitTimeMillis()) : channelOption == RxtxChannelOption.READ_TIMEOUT ? Integer.valueOf(getReadTimeout()) : super.getOption(channelOption);
    }

    public Map<ChannelOption<?>, Object> getOptions() {
        return getOptions(super.getOptions(), RxtxChannelOption.BAUD_RATE, RxtxChannelOption.DTR, RxtxChannelOption.RTS, RxtxChannelOption.STOP_BITS, RxtxChannelOption.DATA_BITS, RxtxChannelOption.PARITY_BIT, RxtxChannelOption.WAIT_TIME);
    }

    public RxtxChannelConfig.Paritybit getParitybit() {
        return this.paritybit;
    }

    public int getReadTimeout() {
        return this.readTimeout;
    }

    public RxtxChannelConfig.Stopbits getStopbits() {
        return this.stopbits;
    }

    public int getWaitTimeMillis() {
        return this.waitTime;
    }

    public boolean isDtr() {
        return this.dtr;
    }

    public boolean isRts() {
        return this.rts;
    }

    public RxtxChannelConfig setBaudrate(int i) {
        this.baudrate = i;
        return this;
    }

    public RxtxChannelConfig setDatabits(RxtxChannelConfig.Databits databits2) {
        this.databits = databits2;
        return this;
    }

    public RxtxChannelConfig setDtr(boolean z) {
        this.dtr = z;
        return this;
    }

    public <T> boolean setOption(ChannelOption<T> channelOption, T t) {
        validate(channelOption, t);
        if (channelOption == RxtxChannelOption.BAUD_RATE) {
            setBaudrate(((Integer) t).intValue());
            return true;
        } else if (channelOption == RxtxChannelOption.DTR) {
            setDtr(((Boolean) t).booleanValue());
            return true;
        } else if (channelOption == RxtxChannelOption.RTS) {
            setRts(((Boolean) t).booleanValue());
            return true;
        } else if (channelOption == RxtxChannelOption.STOP_BITS) {
            setStopbits((RxtxChannelConfig.Stopbits) t);
            return true;
        } else if (channelOption == RxtxChannelOption.DATA_BITS) {
            setDatabits((RxtxChannelConfig.Databits) t);
            return true;
        } else if (channelOption == RxtxChannelOption.PARITY_BIT) {
            setParitybit((RxtxChannelConfig.Paritybit) t);
            return true;
        } else if (channelOption == RxtxChannelOption.WAIT_TIME) {
            setWaitTimeMillis(((Integer) t).intValue());
            return true;
        } else if (channelOption != RxtxChannelOption.READ_TIMEOUT) {
            return super.setOption(channelOption, t);
        } else {
            setReadTimeout(((Integer) t).intValue());
            return true;
        }
    }

    public RxtxChannelConfig setParitybit(RxtxChannelConfig.Paritybit paritybit2) {
        this.paritybit = paritybit2;
        return this;
    }

    public RxtxChannelConfig setReadTimeout(int i) {
        this.readTimeout = ObjectUtil.checkPositiveOrZero(i, "readTimeout");
        return this;
    }

    public RxtxChannelConfig setRts(boolean z) {
        this.rts = z;
        return this;
    }

    public RxtxChannelConfig setStopbits(RxtxChannelConfig.Stopbits stopbits2) {
        this.stopbits = stopbits2;
        return this;
    }

    public RxtxChannelConfig setWaitTimeMillis(int i) {
        this.waitTime = ObjectUtil.checkPositiveOrZero(i, "waitTimeMillis");
        return this;
    }

    public RxtxChannelConfig setAllocator(ByteBufAllocator byteBufAllocator) {
        super.setAllocator(byteBufAllocator);
        return this;
    }

    public RxtxChannelConfig setAutoClose(boolean z) {
        super.setAutoClose(z);
        return this;
    }

    public RxtxChannelConfig setAutoRead(boolean z) {
        super.setAutoRead(z);
        return this;
    }

    public RxtxChannelConfig setConnectTimeoutMillis(int i) {
        super.setConnectTimeoutMillis(i);
        return this;
    }

    @Deprecated
    public RxtxChannelConfig setMaxMessagesPerRead(int i) {
        super.setMaxMessagesPerRead(i);
        return this;
    }

    public RxtxChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator) {
        super.setMessageSizeEstimator(messageSizeEstimator);
        return this;
    }

    public RxtxChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator) {
        super.setRecvByteBufAllocator(recvByteBufAllocator);
        return this;
    }

    public RxtxChannelConfig setWriteBufferHighWaterMark(int i) {
        super.setWriteBufferHighWaterMark(i);
        return this;
    }

    public RxtxChannelConfig setWriteBufferLowWaterMark(int i) {
        super.setWriteBufferLowWaterMark(i);
        return this;
    }

    public RxtxChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark) {
        super.setWriteBufferWaterMark(writeBufferWaterMark);
        return this;
    }

    public RxtxChannelConfig setWriteSpinCount(int i) {
        super.setWriteSpinCount(i);
        return this;
    }
}
