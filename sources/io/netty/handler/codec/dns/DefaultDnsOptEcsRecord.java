package io.netty.handler.codec.dns;

import io.netty.channel.socket.InternetProtocolFamily;
import java.util.Arrays;

public final class DefaultDnsOptEcsRecord extends AbstractDnsOptPseudoRrRecord implements DnsOptEcsRecord {
    private final byte[] address;
    private final int srcPrefixLength;

    public DefaultDnsOptEcsRecord(int i, int i2, int i3, int i4, byte[] bArr) {
        super(i, i2, i3);
        this.srcPrefixLength = i4;
        this.address = (byte[]) verifyAddress(bArr).clone();
    }

    private static byte[] verifyAddress(byte[] bArr) {
        if (bArr.length == 4 || bArr.length == 16) {
            return bArr;
        }
        throw new IllegalArgumentException("bytes.length must either 4 or 16");
    }

    public byte[] address() {
        return (byte[]) this.address.clone();
    }

    public int scopePrefixLength() {
        return 0;
    }

    public int sourcePrefixLength() {
        return this.srcPrefixLength;
    }

    public String toString() {
        StringBuilder stringBuilder = toStringBuilder();
        stringBuilder.setLength(stringBuilder.length() - 1);
        stringBuilder.append(" address:");
        stringBuilder.append(Arrays.toString(this.address));
        stringBuilder.append(" sourcePrefixLength:");
        stringBuilder.append(sourcePrefixLength());
        stringBuilder.append(" scopePrefixLength:");
        stringBuilder.append(scopePrefixLength());
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    public DefaultDnsOptEcsRecord(int i, int i2, byte[] bArr) {
        this(i, 0, 0, i2, bArr);
    }

    public DefaultDnsOptEcsRecord(int i, InternetProtocolFamily internetProtocolFamily) {
        this(i, 0, 0, 0, internetProtocolFamily.localhost().getAddress());
    }
}
