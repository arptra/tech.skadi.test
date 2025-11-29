package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.CorruptedFrameException;
import io.netty.handler.codec.MessageToMessageDecoder;
import java.net.InetSocketAddress;
import java.util.List;

@ChannelHandler.Sharable
public class DatagramDnsResponseDecoder extends MessageToMessageDecoder<DatagramPacket> {
    private final DnsResponseDecoder<InetSocketAddress> responseDecoder;

    public DatagramDnsResponseDecoder() {
        this(DnsRecordDecoder.DEFAULT);
    }

    public DnsResponse decodeResponse(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket) throws Exception {
        return this.responseDecoder.decode(datagramPacket.sender(), datagramPacket.recipient(), (ByteBuf) datagramPacket.content());
    }

    public DatagramDnsResponseDecoder(DnsRecordDecoder dnsRecordDecoder) {
        this.responseDecoder = new DnsResponseDecoder<InetSocketAddress>(dnsRecordDecoder) {
            public DnsResponse newResponse(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, int i, DnsOpCode dnsOpCode, DnsResponseCode dnsResponseCode) {
                return new DatagramDnsResponse(inetSocketAddress, inetSocketAddress2, i, dnsOpCode, dnsResponseCode);
            }
        };
    }

    public void decode(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket, List<Object> list) throws Exception {
        try {
            list.add(decodeResponse(channelHandlerContext, datagramPacket));
        } catch (IndexOutOfBoundsException e) {
            throw new CorruptedFrameException("Unable to decode response", e);
        }
    }
}
