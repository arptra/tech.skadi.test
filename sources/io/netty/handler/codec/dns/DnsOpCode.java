package io.netty.handler.codec.dns;

import io.netty.util.internal.ObjectUtil;

public class DnsOpCode implements Comparable<DnsOpCode> {
    public static final DnsOpCode IQUERY = new DnsOpCode(1, "IQUERY");
    public static final DnsOpCode NOTIFY = new DnsOpCode(4, "NOTIFY");
    public static final DnsOpCode QUERY = new DnsOpCode(0, "QUERY");
    public static final DnsOpCode STATUS = new DnsOpCode(2, "STATUS");
    public static final DnsOpCode UPDATE = new DnsOpCode(5, "UPDATE");
    private final byte byteValue;
    private final String name;
    private String text;

    private DnsOpCode(int i) {
        this(i, "UNKNOWN");
    }

    public static DnsOpCode valueOf(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 4 ? i != 5 ? new DnsOpCode(i) : UPDATE : NOTIFY : STATUS : IQUERY : QUERY;
    }

    public byte byteValue() {
        return this.byteValue;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DnsOpCode)) {
            return false;
        }
        return this.byteValue == ((DnsOpCode) obj).byteValue;
    }

    public int hashCode() {
        return this.byteValue;
    }

    public String toString() {
        String str = this.text;
        if (str != null) {
            return str;
        }
        String str2 = this.name + '(' + (this.byteValue & 255) + ')';
        this.text = str2;
        return str2;
    }

    public DnsOpCode(int i, String str) {
        this.byteValue = (byte) i;
        this.name = (String) ObjectUtil.checkNotNull(str, "name");
    }

    public int compareTo(DnsOpCode dnsOpCode) {
        return this.byteValue - dnsOpCode.byteValue;
    }
}
