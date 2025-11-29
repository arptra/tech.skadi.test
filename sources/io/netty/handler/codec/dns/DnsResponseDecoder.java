package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.CorruptedFrameException;
import io.netty.util.internal.ObjectUtil;
import java.net.SocketAddress;

abstract class DnsResponseDecoder<A extends SocketAddress> {
    private final DnsRecordDecoder recordDecoder;

    public DnsResponseDecoder(DnsRecordDecoder dnsRecordDecoder) {
        this.recordDecoder = (DnsRecordDecoder) ObjectUtil.checkNotNull(dnsRecordDecoder, "recordDecoder");
    }

    private void decodeQuestions(DnsResponse dnsResponse, ByteBuf byteBuf, int i) throws Exception {
        while (i > 0) {
            dnsResponse.addRecord(DnsSection.QUESTION, this.recordDecoder.decodeQuestion(byteBuf));
            i--;
        }
    }

    private boolean decodeRecords(DnsResponse dnsResponse, DnsSection dnsSection, ByteBuf byteBuf, int i) throws Exception {
        while (i > 0) {
            DnsRecord decodeRecord = this.recordDecoder.decodeRecord(byteBuf);
            if (decodeRecord == null) {
                return false;
            }
            dnsResponse.addRecord(dnsSection, decodeRecord);
            i--;
        }
        return true;
    }

    public final DnsResponse decode(A a2, A a3, ByteBuf byteBuf) throws Exception {
        int readUnsignedShort = byteBuf.readUnsignedShort();
        int readUnsignedShort2 = byteBuf.readUnsignedShort();
        if ((readUnsignedShort2 >> 15) != 0) {
            DnsResponse newResponse = newResponse(a2, a3, readUnsignedShort, DnsOpCode.valueOf((byte) ((readUnsignedShort2 >> 11) & 15)), DnsResponseCode.valueOf((byte) (readUnsignedShort2 & 15)));
            boolean z = true;
            newResponse.setRecursionDesired(((readUnsignedShort2 >> 8) & 1) == 1);
            newResponse.setAuthoritativeAnswer(((readUnsignedShort2 >> 10) & 1) == 1);
            newResponse.setTruncated(((readUnsignedShort2 >> 9) & 1) == 1);
            if (((readUnsignedShort2 >> 7) & 1) != 1) {
                z = false;
            }
            newResponse.setRecursionAvailable(z);
            newResponse.setZ((readUnsignedShort2 >> 4) & 7);
            try {
                int readUnsignedShort3 = byteBuf.readUnsignedShort();
                int readUnsignedShort4 = byteBuf.readUnsignedShort();
                int readUnsignedShort5 = byteBuf.readUnsignedShort();
                int readUnsignedShort6 = byteBuf.readUnsignedShort();
                decodeQuestions(newResponse, byteBuf, readUnsignedShort3);
                if (!decodeRecords(newResponse, DnsSection.ANSWER, byteBuf, readUnsignedShort4) || !decodeRecords(newResponse, DnsSection.AUTHORITY, byteBuf, readUnsignedShort5)) {
                    return newResponse;
                }
                decodeRecords(newResponse, DnsSection.ADDITIONAL, byteBuf, readUnsignedShort6);
                return newResponse;
            } catch (Throwable th) {
                newResponse.release();
                throw th;
            }
        } else {
            throw new CorruptedFrameException("not a response");
        }
    }

    public abstract DnsResponse newResponse(A a2, A a3, int i, DnsOpCode dnsOpCode, DnsResponseCode dnsResponseCode) throws Exception;
}
