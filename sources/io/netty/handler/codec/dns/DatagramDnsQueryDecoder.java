package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.handler.codec.dns.DnsMessageUtil;
import io.netty.util.internal.ObjectUtil;
import java.net.InetSocketAddress;
import java.util.List;

@ChannelHandler.Sharable
public class DatagramDnsQueryDecoder extends MessageToMessageDecoder<DatagramPacket> {
    private final DnsRecordDecoder recordDecoder;

    public DatagramDnsQueryDecoder() {
        this(DnsRecordDecoder.DEFAULT);
    }

    public DatagramDnsQueryDecoder(DnsRecordDecoder dnsRecordDecoder) {
        this.recordDecoder = (DnsRecordDecoder) ObjectUtil.checkNotNull(dnsRecordDecoder, "recordDecoder");
    }

    public void decode(ChannelHandlerContext channelHandlerContext, final DatagramPacket datagramPacket, List<Object> list) throws Exception {
        list.add(DnsMessageUtil.decodeDnsQuery(this.recordDecoder, (ByteBuf) datagramPacket.content(), new DnsMessageUtil.DnsQueryFactory() {
            public DnsQuery newQuery(int i, DnsOpCode dnsOpCode) {
                return new DatagramDnsQuery((InetSocketAddress) datagramPacket.sender(), (InetSocketAddress) datagramPacket.recipient(), i, dnsOpCode);
            }
        }));
    }
}
