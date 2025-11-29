package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import java.net.SocketAddress;

public final class TcpDnsResponseDecoder extends LengthFieldBasedFrameDecoder {
    private final DnsResponseDecoder<SocketAddress> responseDecoder;

    public TcpDnsResponseDecoder() {
        this(DnsRecordDecoder.DEFAULT, 65536);
    }

    public Object decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
        ByteBuf byteBuf2 = (ByteBuf) super.decode(channelHandlerContext, byteBuf);
        if (byteBuf2 == null) {
            return null;
        }
        try {
            return this.responseDecoder.decode(channelHandlerContext.channel().remoteAddress(), channelHandlerContext.channel().localAddress(), byteBuf2.slice());
        } finally {
            byteBuf2.release();
        }
    }

    public ByteBuf extractFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, int i, int i2) {
        return byteBuf.copy(i, i2);
    }

    public TcpDnsResponseDecoder(DnsRecordDecoder dnsRecordDecoder, int i) {
        super(i, 0, 2, 0, 2);
        this.responseDecoder = new DnsResponseDecoder<SocketAddress>(dnsRecordDecoder) {
            public DnsResponse newResponse(SocketAddress socketAddress, SocketAddress socketAddress2, int i, DnsOpCode dnsOpCode, DnsResponseCode dnsResponseCode) {
                return new DefaultDnsResponse(i, dnsOpCode, dnsResponseCode);
            }
        };
    }
}
