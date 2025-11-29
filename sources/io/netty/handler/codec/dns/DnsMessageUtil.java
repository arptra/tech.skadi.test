package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;
import io.netty.channel.AddressedEnvelope;
import io.netty.handler.codec.CorruptedFrameException;
import io.netty.util.internal.StringUtil;
import java.net.SocketAddress;
import org.eclipse.jetty.util.security.Constraint;

final class DnsMessageUtil {

    public interface DnsQueryFactory {
        DnsQuery newQuery(int i, DnsOpCode dnsOpCode);
    }

    private DnsMessageUtil() {
    }

    private static StringBuilder appendAddresses(StringBuilder sb, DnsMessage dnsMessage) {
        if (!(dnsMessage instanceof AddressedEnvelope)) {
            return sb;
        }
        AddressedEnvelope addressedEnvelope = (AddressedEnvelope) dnsMessage;
        SocketAddress sender = addressedEnvelope.sender();
        if (sender != null) {
            sb.append("from: ");
            sb.append(sender);
            sb.append(", ");
        }
        SocketAddress recipient = addressedEnvelope.recipient();
        if (recipient != null) {
            sb.append("to: ");
            sb.append(recipient);
            sb.append(", ");
        }
        return sb;
    }

    private static void appendAllRecords(StringBuilder sb, DnsMessage dnsMessage) {
        appendRecords(sb, dnsMessage, DnsSection.QUESTION);
        appendRecords(sb, dnsMessage, DnsSection.ANSWER);
        appendRecords(sb, dnsMessage, DnsSection.AUTHORITY);
        appendRecords(sb, dnsMessage, DnsSection.ADDITIONAL);
    }

    public static StringBuilder appendQuery(StringBuilder sb, DnsQuery dnsQuery) {
        appendQueryHeader(sb, dnsQuery);
        appendAllRecords(sb, dnsQuery);
        return sb;
    }

    private static void appendQueryHeader(StringBuilder sb, DnsQuery dnsQuery) {
        sb.append(StringUtil.simpleClassName((Object) dnsQuery));
        sb.append('(');
        StringBuilder appendAddresses = appendAddresses(sb, dnsQuery);
        appendAddresses.append(dnsQuery.id());
        appendAddresses.append(", ");
        appendAddresses.append(dnsQuery.opCode());
        if (dnsQuery.isRecursionDesired()) {
            sb.append(", RD");
        }
        if (dnsQuery.z() != 0) {
            sb.append(", Z: ");
            sb.append(dnsQuery.z());
        }
        sb.append(')');
    }

    public static StringBuilder appendRecordClass(StringBuilder sb, int i) {
        int i2 = i & 65535;
        String str = i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 254 ? i2 != 255 ? null : "ANY" : Constraint.NONE : "HESIOD" : "CHAOS" : "CSNET" : "IN";
        if (str != null) {
            sb.append(str);
        } else {
            sb.append("UNKNOWN(");
            sb.append(i2);
            sb.append(')');
        }
        return sb;
    }

    private static void appendRecords(StringBuilder sb, DnsMessage dnsMessage, DnsSection dnsSection) {
        int count = dnsMessage.count(dnsSection);
        for (int i = 0; i < count; i++) {
            sb.append(StringUtil.NEWLINE);
            sb.append(9);
            sb.append(dnsMessage.recordAt(dnsSection, i));
        }
    }

    public static StringBuilder appendResponse(StringBuilder sb, DnsResponse dnsResponse) {
        appendResponseHeader(sb, dnsResponse);
        appendAllRecords(sb, dnsResponse);
        return sb;
    }

    private static void appendResponseHeader(StringBuilder sb, DnsResponse dnsResponse) {
        boolean z;
        sb.append(StringUtil.simpleClassName((Object) dnsResponse));
        sb.append('(');
        StringBuilder appendAddresses = appendAddresses(sb, dnsResponse);
        appendAddresses.append(dnsResponse.id());
        appendAddresses.append(", ");
        appendAddresses.append(dnsResponse.opCode());
        appendAddresses.append(", ");
        appendAddresses.append(dnsResponse.code());
        appendAddresses.append(StringUtil.COMMA);
        boolean z2 = false;
        if (dnsResponse.isRecursionDesired()) {
            sb.append(" RD");
            z = false;
        } else {
            z = true;
        }
        if (dnsResponse.isAuthoritativeAnswer()) {
            sb.append(" AA");
            z = false;
        }
        if (dnsResponse.isTruncated()) {
            sb.append(" TC");
            z = false;
        }
        if (dnsResponse.isRecursionAvailable()) {
            sb.append(" RA");
        } else {
            z2 = z;
        }
        if (dnsResponse.z() != 0) {
            if (!z2) {
                sb.append(StringUtil.COMMA);
            }
            sb.append(" Z: ");
            sb.append(dnsResponse.z());
        }
        if (z2) {
            sb.setCharAt(sb.length() - 1, ')');
        } else {
            sb.append(')');
        }
    }

    public static DnsQuery decodeDnsQuery(DnsRecordDecoder dnsRecordDecoder, ByteBuf byteBuf, DnsQueryFactory dnsQueryFactory) throws Exception {
        DnsQuery newQuery = newQuery(byteBuf, dnsQueryFactory);
        try {
            int readUnsignedShort = byteBuf.readUnsignedShort();
            int readUnsignedShort2 = byteBuf.readUnsignedShort();
            int readUnsignedShort3 = byteBuf.readUnsignedShort();
            int readUnsignedShort4 = byteBuf.readUnsignedShort();
            decodeQuestions(dnsRecordDecoder, newQuery, byteBuf, readUnsignedShort);
            decodeRecords(dnsRecordDecoder, newQuery, DnsSection.ANSWER, byteBuf, readUnsignedShort2);
            decodeRecords(dnsRecordDecoder, newQuery, DnsSection.AUTHORITY, byteBuf, readUnsignedShort3);
            decodeRecords(dnsRecordDecoder, newQuery, DnsSection.ADDITIONAL, byteBuf, readUnsignedShort4);
            return newQuery;
        } catch (Throwable th) {
            newQuery.release();
            throw th;
        }
    }

    private static void decodeQuestions(DnsRecordDecoder dnsRecordDecoder, DnsQuery dnsQuery, ByteBuf byteBuf, int i) throws Exception {
        while (i > 0) {
            dnsQuery.addRecord(DnsSection.QUESTION, dnsRecordDecoder.decodeQuestion(byteBuf));
            i--;
        }
    }

    private static void decodeRecords(DnsRecordDecoder dnsRecordDecoder, DnsQuery dnsQuery, DnsSection dnsSection, ByteBuf byteBuf, int i) throws Exception {
        while (i > 0) {
            DnsRecord decodeRecord = dnsRecordDecoder.decodeRecord(byteBuf);
            if (decodeRecord != null) {
                dnsQuery.addRecord(dnsSection, decodeRecord);
                i--;
            } else {
                return;
            }
        }
    }

    public static void encodeDnsResponse(DnsRecordEncoder dnsRecordEncoder, DnsResponse dnsResponse, ByteBuf byteBuf) throws Exception {
        try {
            encodeHeader(dnsResponse, byteBuf);
            encodeQuestions(dnsRecordEncoder, dnsResponse, byteBuf);
            encodeRecords(dnsRecordEncoder, dnsResponse, DnsSection.ANSWER, byteBuf);
            encodeRecords(dnsRecordEncoder, dnsResponse, DnsSection.AUTHORITY, byteBuf);
            encodeRecords(dnsRecordEncoder, dnsResponse, DnsSection.ADDITIONAL, byteBuf);
        } catch (Throwable th) {
            byteBuf.release();
            throw th;
        }
    }

    private static void encodeHeader(DnsResponse dnsResponse, ByteBuf byteBuf) {
        byteBuf.writeShort(dnsResponse.id());
        int byteValue = (dnsResponse.opCode().byteValue() & 255) << 11;
        int i = 32768 | byteValue;
        if (dnsResponse.isAuthoritativeAnswer()) {
            i = 33792 | byteValue;
        }
        if (dnsResponse.isTruncated()) {
            i |= 512;
        }
        if (dnsResponse.isRecursionDesired()) {
            i |= 256;
        }
        if (dnsResponse.isRecursionAvailable()) {
            i |= 128;
        }
        byteBuf.writeShort((dnsResponse.z() << 4) | i | dnsResponse.code().intValue());
        byteBuf.writeShort(dnsResponse.count(DnsSection.QUESTION));
        byteBuf.writeShort(dnsResponse.count(DnsSection.ANSWER));
        byteBuf.writeShort(dnsResponse.count(DnsSection.AUTHORITY));
        byteBuf.writeShort(dnsResponse.count(DnsSection.ADDITIONAL));
    }

    private static void encodeQuestions(DnsRecordEncoder dnsRecordEncoder, DnsResponse dnsResponse, ByteBuf byteBuf) throws Exception {
        int count = dnsResponse.count(DnsSection.QUESTION);
        for (int i = 0; i < count; i++) {
            dnsRecordEncoder.encodeQuestion((DnsQuestion) dnsResponse.recordAt(DnsSection.QUESTION, i), byteBuf);
        }
    }

    private static void encodeRecords(DnsRecordEncoder dnsRecordEncoder, DnsResponse dnsResponse, DnsSection dnsSection, ByteBuf byteBuf) throws Exception {
        int count = dnsResponse.count(dnsSection);
        for (int i = 0; i < count; i++) {
            dnsRecordEncoder.encodeRecord(dnsResponse.recordAt(dnsSection, i), byteBuf);
        }
    }

    private static DnsQuery newQuery(ByteBuf byteBuf, DnsQueryFactory dnsQueryFactory) {
        int readUnsignedShort = byteBuf.readUnsignedShort();
        int readUnsignedShort2 = byteBuf.readUnsignedShort();
        boolean z = true;
        if ((readUnsignedShort2 >> 15) != 1) {
            DnsQuery newQuery = dnsQueryFactory.newQuery(readUnsignedShort, DnsOpCode.valueOf((byte) ((readUnsignedShort2 >> 11) & 15)));
            if (((readUnsignedShort2 >> 8) & 1) != 1) {
                z = false;
            }
            newQuery.setRecursionDesired(z);
            newQuery.setZ((readUnsignedShort2 >> 4) & 7);
            return newQuery;
        }
        throw new CorruptedFrameException("not a query");
    }
}
