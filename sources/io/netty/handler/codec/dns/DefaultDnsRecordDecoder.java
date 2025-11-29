package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;

public class DefaultDnsRecordDecoder implements DnsRecordDecoder {
    static final String ROOT = ".";

    public static String decodeName(ByteBuf byteBuf) {
        return DnsCodecUtil.decodeDomainName(byteBuf);
    }

    public String decodeName0(ByteBuf byteBuf) {
        return decodeName(byteBuf);
    }

    public final DnsQuestion decodeQuestion(ByteBuf byteBuf) throws Exception {
        return new DefaultDnsQuestion(decodeName(byteBuf), DnsRecordType.valueOf(byteBuf.readUnsignedShort()), byteBuf.readUnsignedShort());
    }

    public final <T extends DnsRecord> T decodeRecord(ByteBuf byteBuf) throws Exception {
        int readerIndex = byteBuf.readerIndex();
        String decodeName = decodeName(byteBuf);
        int writerIndex = byteBuf.writerIndex();
        if (writerIndex - byteBuf.readerIndex() < 10) {
            byteBuf.readerIndex(readerIndex);
            return null;
        }
        DnsRecordType valueOf = DnsRecordType.valueOf(byteBuf.readUnsignedShort());
        int readUnsignedShort = byteBuf.readUnsignedShort();
        long readUnsignedInt = byteBuf.readUnsignedInt();
        int readUnsignedShort2 = byteBuf.readUnsignedShort();
        int readerIndex2 = byteBuf.readerIndex();
        if (writerIndex - readerIndex2 < readUnsignedShort2) {
            byteBuf.readerIndex(readerIndex);
            return null;
        }
        T decodeRecord = decodeRecord(decodeName, valueOf, readUnsignedShort, readUnsignedInt, byteBuf, readerIndex2, readUnsignedShort2);
        byteBuf.readerIndex(readerIndex2 + readUnsignedShort2);
        return decodeRecord;
    }

    public DnsRecord decodeRecord(String str, DnsRecordType dnsRecordType, int i, long j, ByteBuf byteBuf, int i2, int i3) throws Exception {
        DnsRecordType dnsRecordType2 = dnsRecordType;
        int i4 = i2;
        if (dnsRecordType2 == DnsRecordType.PTR) {
            return new DefaultDnsPtrRecord(str, i, j, decodeName0(byteBuf.duplicate().setIndex(i2, i4 + i3)));
        } else if (dnsRecordType2 == DnsRecordType.CNAME || dnsRecordType2 == DnsRecordType.NS) {
            return new DefaultDnsRawRecord(str, dnsRecordType, i, j, DnsCodecUtil.decompressDomainName(byteBuf.duplicate().setIndex(i2, i4 + i3)));
        } else {
            return new DefaultDnsRawRecord(str, dnsRecordType, i, j, byteBuf.retainedDuplicate().setIndex(i2, i4 + i3));
        }
    }
}
