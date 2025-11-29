package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.dns.DnsMessageUtil;
import io.netty.util.internal.ObjectUtil;

public final class TcpDnsQueryDecoder extends LengthFieldBasedFrameDecoder {
    private final DnsRecordDecoder decoder;

    public TcpDnsQueryDecoder() {
        this(DnsRecordDecoder.DEFAULT, 65535);
    }

    public Object decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
        ByteBuf byteBuf2 = (ByteBuf) super.decode(channelHandlerContext, byteBuf);
        if (byteBuf2 == null) {
            return null;
        }
        return DnsMessageUtil.decodeDnsQuery(this.decoder, byteBuf2.slice(), new DnsMessageUtil.DnsQueryFactory() {
            public DnsQuery newQuery(int i, DnsOpCode dnsOpCode) {
                return new DefaultDnsQuery(i, dnsOpCode);
            }
        });
    }

    public TcpDnsQueryDecoder(DnsRecordDecoder dnsRecordDecoder, int i) {
        super(i, 0, 2, 0, 2);
        this.decoder = (DnsRecordDecoder) ObjectUtil.checkNotNull(dnsRecordDecoder, "decoder");
    }
}
