package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

@ChannelHandler.Sharable
public final class TcpDnsResponseEncoder extends MessageToMessageEncoder<DnsResponse> {
    private final DnsRecordEncoder encoder;

    public TcpDnsResponseEncoder() {
        this(DnsRecordEncoder.DEFAULT);
    }

    public TcpDnsResponseEncoder(DnsRecordEncoder dnsRecordEncoder) {
        this.encoder = (DnsRecordEncoder) ObjectUtil.checkNotNull(dnsRecordEncoder, "encoder");
    }

    public void encode(ChannelHandlerContext channelHandlerContext, DnsResponse dnsResponse, List<Object> list) throws Exception {
        ByteBuf ioBuffer = channelHandlerContext.alloc().ioBuffer(1024);
        ioBuffer.writerIndex(ioBuffer.writerIndex() + 2);
        DnsMessageUtil.encodeDnsResponse(this.encoder, dnsResponse, ioBuffer);
        ioBuffer.setShort(0, ioBuffer.readableBytes() - 2);
        list.add(ioBuffer);
    }
}
