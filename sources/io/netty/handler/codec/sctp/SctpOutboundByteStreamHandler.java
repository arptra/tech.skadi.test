package io.netty.handler.codec.sctp;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.sctp.SctpMessage;
import io.netty.handler.codec.MessageToMessageEncoder;
import java.util.List;

public class SctpOutboundByteStreamHandler extends MessageToMessageEncoder<ByteBuf> {
    private final int protocolIdentifier;
    private final int streamIdentifier;
    private final boolean unordered;

    public SctpOutboundByteStreamHandler(int i, int i2) {
        this(i, i2, false);
    }

    public SctpOutboundByteStreamHandler(int i, int i2, boolean z) {
        this.streamIdentifier = i;
        this.protocolIdentifier = i2;
        this.unordered = z;
    }

    public void encode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        list.add(new SctpMessage(this.protocolIdentifier, this.streamIdentifier, this.unordered, byteBuf.retain()));
    }
}
