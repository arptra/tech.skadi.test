package io.netty.handler.codec.dns;

import com.upuphone.starrynet.strategy.discovery.advertiser.codec.AdvCodes;
import io.netty.buffer.ByteBuf;
import io.netty.channel.socket.InternetProtocolFamily;
import io.netty.handler.codec.UnsupportedMessageTypeException;
import io.netty.util.internal.StringUtil;

public class DefaultDnsRecordEncoder implements DnsRecordEncoder {
    private static final int PREFIX_MASK = 7;

    public static int calculateEcsAddressLength(int i, int i2) {
        return (i >>> 3) + (i2 != 0 ? 1 : 0);
    }

    private void encodeOptEcsRecord(DnsOptEcsRecord dnsOptEcsRecord, ByteBuf byteBuf) throws Exception {
        encodeRecord0(dnsOptEcsRecord, byteBuf);
        int sourcePrefixLength = dnsOptEcsRecord.sourcePrefixLength();
        int scopePrefixLength = dnsOptEcsRecord.scopePrefixLength();
        int i = sourcePrefixLength & 7;
        byte[] address = dnsOptEcsRecord.address();
        int length = address.length << 3;
        if (length < sourcePrefixLength || sourcePrefixLength < 0) {
            throw new IllegalArgumentException(sourcePrefixLength + ": " + sourcePrefixLength + " (expected: 0 >= " + length + ')');
        }
        short addressNumber = (short) (address.length == 4 ? InternetProtocolFamily.IPv4 : InternetProtocolFamily.IPv6).addressNumber();
        int calculateEcsAddressLength = calculateEcsAddressLength(sourcePrefixLength, i);
        byteBuf.writeShort(calculateEcsAddressLength + 8);
        byteBuf.writeShort(8);
        byteBuf.writeShort(calculateEcsAddressLength + 4);
        byteBuf.writeShort(addressNumber);
        byteBuf.writeByte(sourcePrefixLength);
        byteBuf.writeByte(scopePrefixLength);
        if (i > 0) {
            int i2 = calculateEcsAddressLength - 1;
            byteBuf.writeBytes(address, 0, i2);
            byteBuf.writeByte(padWithZeros(address[i2], i));
            return;
        }
        byteBuf.writeBytes(address, 0, calculateEcsAddressLength);
    }

    private void encodeOptPseudoRecord(DnsOptPseudoRecord dnsOptPseudoRecord, ByteBuf byteBuf) throws Exception {
        encodeRecord0(dnsOptPseudoRecord, byteBuf);
        byteBuf.writeShort(0);
    }

    private void encodePtrRecord(DnsPtrRecord dnsPtrRecord, ByteBuf byteBuf) throws Exception {
        encodeRecord0(dnsPtrRecord, byteBuf);
        encodeName(dnsPtrRecord.hostname(), byteBuf);
    }

    private void encodeRawRecord(DnsRawRecord dnsRawRecord, ByteBuf byteBuf) throws Exception {
        encodeRecord0(dnsRawRecord, byteBuf);
        ByteBuf content = dnsRawRecord.content();
        int readableBytes = content.readableBytes();
        byteBuf.writeShort(readableBytes);
        byteBuf.writeBytes(content, content.readerIndex(), readableBytes);
    }

    private void encodeRecord0(DnsRecord dnsRecord, ByteBuf byteBuf) throws Exception {
        encodeName(dnsRecord.name(), byteBuf);
        byteBuf.writeShort(dnsRecord.type().intValue());
        byteBuf.writeShort(dnsRecord.dnsClass());
        byteBuf.writeInt((int) dnsRecord.timeToLive());
    }

    private static byte padWithZeros(byte b, int i) {
        byte b2;
        switch (i) {
            case 0:
                return 0;
            case 1:
                b2 = b & 128;
                break;
            case 2:
                b2 = b & 192;
                break;
            case 3:
                b2 = b & 224;
                break;
            case 4:
                b2 = b & 240;
                break;
            case 5:
                b2 = b & 248;
                break;
            case 6:
                b2 = b & 252;
                break;
            case 7:
                b2 = b & AdvCodes.ITEM_TYPE_NOT_SUPPORT;
                break;
            case 8:
                return b;
            default:
                throw new IllegalArgumentException("lowOrderBitsToPreserve: " + i);
        }
        return (byte) b2;
    }

    public void encodeName(String str, ByteBuf byteBuf) throws Exception {
        DnsCodecUtil.encodeDomainName(str, byteBuf);
    }

    public final void encodeQuestion(DnsQuestion dnsQuestion, ByteBuf byteBuf) throws Exception {
        encodeName(dnsQuestion.name(), byteBuf);
        byteBuf.writeShort(dnsQuestion.type().intValue());
        byteBuf.writeShort(dnsQuestion.dnsClass());
    }

    public void encodeRecord(DnsRecord dnsRecord, ByteBuf byteBuf) throws Exception {
        if (dnsRecord instanceof DnsQuestion) {
            encodeQuestion((DnsQuestion) dnsRecord, byteBuf);
        } else if (dnsRecord instanceof DnsPtrRecord) {
            encodePtrRecord((DnsPtrRecord) dnsRecord, byteBuf);
        } else if (dnsRecord instanceof DnsOptEcsRecord) {
            encodeOptEcsRecord((DnsOptEcsRecord) dnsRecord, byteBuf);
        } else if (dnsRecord instanceof DnsOptPseudoRecord) {
            encodeOptPseudoRecord((DnsOptPseudoRecord) dnsRecord, byteBuf);
        } else if (dnsRecord instanceof DnsRawRecord) {
            encodeRawRecord((DnsRawRecord) dnsRecord, byteBuf);
        } else {
            throw new UnsupportedMessageTypeException(StringUtil.simpleClassName((Object) dnsRecord));
        }
    }
}
