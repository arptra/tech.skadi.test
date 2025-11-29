package io.netty.channel.udt;

import com.barchart.udt.OptionUDT;
import com.barchart.udt.SocketUDT;
import com.barchart.udt.nio.ChannelUDT;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelOption;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import java.io.IOException;
import java.util.Map;

@Deprecated
public class DefaultUdtChannelConfig extends DefaultChannelConfig implements UdtChannelConfig {
    private static final int K = 1024;
    private static final int M = 1048576;
    private volatile int allocatorReceiveBufferSize = 131072;
    private volatile int allocatorSendBufferSize = 131072;
    private volatile int protocolReceiveBufferSize = 10485760;
    private volatile int protocolSendBufferSize = 10485760;
    private volatile boolean reuseAddress = true;
    private volatile int soLinger;
    private volatile int systemReceiveBufferSize = 1048576;
    private volatile int systemSendBufferSize = 1048576;

    public DefaultUdtChannelConfig(UdtChannel udtChannel, ChannelUDT channelUDT, boolean z) throws IOException {
        super(udtChannel);
        if (z) {
            apply(channelUDT);
        }
    }

    public void apply(ChannelUDT channelUDT) throws IOException {
        SocketUDT socketUDT = channelUDT.socketUDT();
        socketUDT.setReuseAddress(isReuseAddress());
        socketUDT.setSendBufferSize(getSendBufferSize());
        if (getSoLinger() <= 0) {
            socketUDT.setSoLinger(false, 0);
        } else {
            socketUDT.setSoLinger(true, getSoLinger());
        }
        socketUDT.setOption(OptionUDT.Protocol_Receive_Buffer_Size, Integer.valueOf(getProtocolReceiveBufferSize()));
        socketUDT.setOption(OptionUDT.Protocol_Send_Buffer_Size, Integer.valueOf(getProtocolSendBufferSize()));
        socketUDT.setOption(OptionUDT.System_Receive_Buffer_Size, Integer.valueOf(getSystemReceiveBufferSize()));
        socketUDT.setOption(OptionUDT.System_Send_Buffer_Size, Integer.valueOf(getSystemSendBufferSize()));
    }

    public <T> T getOption(ChannelOption<T> channelOption) {
        return channelOption == UdtChannelOption.PROTOCOL_RECEIVE_BUFFER_SIZE ? Integer.valueOf(getProtocolReceiveBufferSize()) : channelOption == UdtChannelOption.PROTOCOL_SEND_BUFFER_SIZE ? Integer.valueOf(getProtocolSendBufferSize()) : channelOption == UdtChannelOption.SYSTEM_RECEIVE_BUFFER_SIZE ? Integer.valueOf(getSystemReceiveBufferSize()) : channelOption == UdtChannelOption.SYSTEM_SEND_BUFFER_SIZE ? Integer.valueOf(getSystemSendBufferSize()) : channelOption == ChannelOption.SO_RCVBUF ? Integer.valueOf(getReceiveBufferSize()) : channelOption == ChannelOption.SO_SNDBUF ? Integer.valueOf(getSendBufferSize()) : channelOption == ChannelOption.SO_REUSEADDR ? Boolean.valueOf(isReuseAddress()) : channelOption == ChannelOption.SO_LINGER ? Integer.valueOf(getSoLinger()) : super.getOption(channelOption);
    }

    public Map<ChannelOption<?>, Object> getOptions() {
        return getOptions(super.getOptions(), UdtChannelOption.PROTOCOL_RECEIVE_BUFFER_SIZE, UdtChannelOption.PROTOCOL_SEND_BUFFER_SIZE, UdtChannelOption.SYSTEM_RECEIVE_BUFFER_SIZE, UdtChannelOption.SYSTEM_SEND_BUFFER_SIZE, ChannelOption.SO_RCVBUF, ChannelOption.SO_SNDBUF, ChannelOption.SO_REUSEADDR, ChannelOption.SO_LINGER);
    }

    public int getProtocolReceiveBufferSize() {
        return this.protocolReceiveBufferSize;
    }

    public int getProtocolSendBufferSize() {
        return this.protocolSendBufferSize;
    }

    public int getReceiveBufferSize() {
        return this.allocatorReceiveBufferSize;
    }

    public int getSendBufferSize() {
        return this.allocatorSendBufferSize;
    }

    public int getSoLinger() {
        return this.soLinger;
    }

    public int getSystemReceiveBufferSize() {
        return this.systemReceiveBufferSize;
    }

    public int getSystemSendBufferSize() {
        return this.systemSendBufferSize;
    }

    public boolean isReuseAddress() {
        return this.reuseAddress;
    }

    public <T> boolean setOption(ChannelOption<T> channelOption, T t) {
        validate(channelOption, t);
        if (channelOption == UdtChannelOption.PROTOCOL_RECEIVE_BUFFER_SIZE) {
            setProtocolReceiveBufferSize(((Integer) t).intValue());
            return true;
        } else if (channelOption == UdtChannelOption.PROTOCOL_SEND_BUFFER_SIZE) {
            setProtocolSendBufferSize(((Integer) t).intValue());
            return true;
        } else if (channelOption == UdtChannelOption.SYSTEM_RECEIVE_BUFFER_SIZE) {
            setSystemReceiveBufferSize(((Integer) t).intValue());
            return true;
        } else if (channelOption == UdtChannelOption.SYSTEM_SEND_BUFFER_SIZE) {
            setSystemSendBufferSize(((Integer) t).intValue());
            return true;
        } else if (channelOption == ChannelOption.SO_RCVBUF) {
            setReceiveBufferSize(((Integer) t).intValue());
            return true;
        } else if (channelOption == ChannelOption.SO_SNDBUF) {
            setSendBufferSize(((Integer) t).intValue());
            return true;
        } else if (channelOption == ChannelOption.SO_REUSEADDR) {
            setReuseAddress(((Boolean) t).booleanValue());
            return true;
        } else if (channelOption != ChannelOption.SO_LINGER) {
            return super.setOption(channelOption, t);
        } else {
            setSoLinger(((Integer) t).intValue());
            return true;
        }
    }

    public UdtChannelConfig setProtocolReceiveBufferSize(int i) {
        this.protocolReceiveBufferSize = i;
        return this;
    }

    public UdtChannelConfig setProtocolSendBufferSize(int i) {
        this.protocolSendBufferSize = i;
        return this;
    }

    public UdtChannelConfig setReceiveBufferSize(int i) {
        this.allocatorReceiveBufferSize = i;
        return this;
    }

    public UdtChannelConfig setReuseAddress(boolean z) {
        this.reuseAddress = z;
        return this;
    }

    public UdtChannelConfig setSendBufferSize(int i) {
        this.allocatorSendBufferSize = i;
        return this;
    }

    public UdtChannelConfig setSoLinger(int i) {
        this.soLinger = i;
        return this;
    }

    public UdtChannelConfig setSystemReceiveBufferSize(int i) {
        this.systemSendBufferSize = i;
        return this;
    }

    public UdtChannelConfig setSystemSendBufferSize(int i) {
        this.systemReceiveBufferSize = i;
        return this;
    }

    public UdtChannelConfig setAllocator(ByteBufAllocator byteBufAllocator) {
        super.setAllocator(byteBufAllocator);
        return this;
    }

    public UdtChannelConfig setAutoClose(boolean z) {
        super.setAutoClose(z);
        return this;
    }

    public UdtChannelConfig setAutoRead(boolean z) {
        super.setAutoRead(z);
        return this;
    }

    public UdtChannelConfig setConnectTimeoutMillis(int i) {
        super.setConnectTimeoutMillis(i);
        return this;
    }

    @Deprecated
    public UdtChannelConfig setMaxMessagesPerRead(int i) {
        super.setMaxMessagesPerRead(i);
        return this;
    }

    public UdtChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator) {
        super.setMessageSizeEstimator(messageSizeEstimator);
        return this;
    }

    public UdtChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator) {
        super.setRecvByteBufAllocator(recvByteBufAllocator);
        return this;
    }

    public UdtChannelConfig setWriteBufferHighWaterMark(int i) {
        super.setWriteBufferHighWaterMark(i);
        return this;
    }

    public UdtChannelConfig setWriteBufferLowWaterMark(int i) {
        super.setWriteBufferLowWaterMark(i);
        return this;
    }

    public UdtChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark) {
        super.setWriteBufferWaterMark(writeBufferWaterMark);
        return this;
    }

    public UdtChannelConfig setWriteSpinCount(int i) {
        super.setWriteSpinCount(i);
        return this;
    }
}
