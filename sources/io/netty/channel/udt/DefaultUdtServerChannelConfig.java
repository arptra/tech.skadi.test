package io.netty.channel.udt;

import com.barchart.udt.nio.ChannelUDT;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelOption;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import java.io.IOException;
import java.util.Map;

@Deprecated
public class DefaultUdtServerChannelConfig extends DefaultUdtChannelConfig implements UdtServerChannelConfig {
    private volatile int backlog = 64;

    public DefaultUdtServerChannelConfig(UdtChannel udtChannel, ChannelUDT channelUDT, boolean z) throws IOException {
        super(udtChannel, channelUDT, z);
        if (z) {
            apply(channelUDT);
        }
    }

    public void apply(ChannelUDT channelUDT) throws IOException {
    }

    public int getBacklog() {
        return this.backlog;
    }

    public <T> T getOption(ChannelOption<T> channelOption) {
        return channelOption == ChannelOption.SO_BACKLOG ? Integer.valueOf(getBacklog()) : super.getOption(channelOption);
    }

    public Map<ChannelOption<?>, Object> getOptions() {
        return getOptions(super.getOptions(), ChannelOption.SO_BACKLOG);
    }

    public UdtServerChannelConfig setBacklog(int i) {
        this.backlog = i;
        return this;
    }

    public <T> boolean setOption(ChannelOption<T> channelOption, T t) {
        validate(channelOption, t);
        if (channelOption != ChannelOption.SO_BACKLOG) {
            return super.setOption(channelOption, t);
        }
        setBacklog(((Integer) t).intValue());
        return true;
    }

    public UdtServerChannelConfig setProtocolReceiveBufferSize(int i) {
        super.setProtocolReceiveBufferSize(i);
        return this;
    }

    public UdtServerChannelConfig setProtocolSendBufferSize(int i) {
        super.setProtocolSendBufferSize(i);
        return this;
    }

    public UdtServerChannelConfig setReceiveBufferSize(int i) {
        super.setReceiveBufferSize(i);
        return this;
    }

    public UdtServerChannelConfig setReuseAddress(boolean z) {
        super.setReuseAddress(z);
        return this;
    }

    public UdtServerChannelConfig setSendBufferSize(int i) {
        super.setSendBufferSize(i);
        return this;
    }

    public UdtServerChannelConfig setSoLinger(int i) {
        super.setSoLinger(i);
        return this;
    }

    public UdtServerChannelConfig setSystemReceiveBufferSize(int i) {
        super.setSystemReceiveBufferSize(i);
        return this;
    }

    public UdtServerChannelConfig setSystemSendBufferSize(int i) {
        super.setSystemSendBufferSize(i);
        return this;
    }

    public UdtServerChannelConfig setAllocator(ByteBufAllocator byteBufAllocator) {
        super.setAllocator(byteBufAllocator);
        return this;
    }

    public UdtServerChannelConfig setAutoClose(boolean z) {
        super.setAutoClose(z);
        return this;
    }

    public UdtServerChannelConfig setAutoRead(boolean z) {
        super.setAutoRead(z);
        return this;
    }

    public UdtServerChannelConfig setConnectTimeoutMillis(int i) {
        super.setConnectTimeoutMillis(i);
        return this;
    }

    @Deprecated
    public UdtServerChannelConfig setMaxMessagesPerRead(int i) {
        super.setMaxMessagesPerRead(i);
        return this;
    }

    public UdtServerChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator) {
        super.setMessageSizeEstimator(messageSizeEstimator);
        return this;
    }

    public UdtServerChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator) {
        super.setRecvByteBufAllocator(recvByteBufAllocator);
        return this;
    }

    public UdtServerChannelConfig setWriteBufferHighWaterMark(int i) {
        super.setWriteBufferHighWaterMark(i);
        return this;
    }

    public UdtServerChannelConfig setWriteBufferLowWaterMark(int i) {
        super.setWriteBufferLowWaterMark(i);
        return this;
    }

    public UdtServerChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark) {
        super.setWriteBufferWaterMark(writeBufferWaterMark);
        return this;
    }

    public UdtServerChannelConfig setWriteSpinCount(int i) {
        super.setWriteSpinCount(i);
        return this;
    }
}
