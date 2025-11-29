package io.netty.handler.codec.dns;

import io.netty.util.internal.StringUtil;

public abstract class AbstractDnsOptPseudoRrRecord extends AbstractDnsRecord implements DnsOptPseudoRecord {
    public AbstractDnsOptPseudoRrRecord(int i, int i2, int i3) {
        super("", DnsRecordType.OPT, i, packIntoLong(i2, i3));
    }

    private static long packIntoLong(int i, int i2) {
        return (((long) ((i2 & 255) << 16)) | ((((long) i) & 255) << 24)) & 4294967295L;
    }

    public int extendedRcode() {
        return (short) ((((int) timeToLive()) >> 24) & 255);
    }

    public int flags() {
        return (short) (((short) ((int) timeToLive())) & 255);
    }

    public String toString() {
        return toStringBuilder().toString();
    }

    public final StringBuilder toStringBuilder() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(StringUtil.simpleClassName((Object) this));
        sb.append('(');
        sb.append("OPT flags:");
        sb.append(flags());
        sb.append(" version:");
        sb.append(version());
        sb.append(" extendedRecode:");
        sb.append(extendedRcode());
        sb.append(" udp:");
        sb.append(dnsClass());
        sb.append(')');
        return sb;
    }

    public int version() {
        return (short) ((((int) timeToLive()) >> 16) & 255);
    }

    public AbstractDnsOptPseudoRrRecord(int i) {
        super("", DnsRecordType.OPT, i, 0);
    }
}
