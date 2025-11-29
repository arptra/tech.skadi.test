package io.netty.handler.codec.socksx.v4;

import io.netty.util.internal.ObjectUtil;

public class Socks4CommandType implements Comparable<Socks4CommandType> {
    public static final Socks4CommandType BIND = new Socks4CommandType(2, "BIND");
    public static final Socks4CommandType CONNECT = new Socks4CommandType(1, "CONNECT");
    private final byte byteValue;
    private final String name;
    private String text;

    public Socks4CommandType(int i) {
        this(i, "UNKNOWN");
    }

    public static Socks4CommandType valueOf(byte b) {
        return b != 1 ? b != 2 ? new Socks4CommandType(b) : BIND : CONNECT;
    }

    public byte byteValue() {
        return this.byteValue;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Socks4CommandType) && this.byteValue == ((Socks4CommandType) obj).byteValue;
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

    public Socks4CommandType(int i, String str) {
        this.name = (String) ObjectUtil.checkNotNull(str, "name");
        this.byteValue = (byte) i;
    }

    public int compareTo(Socks4CommandType socks4CommandType) {
        return this.byteValue - socks4CommandType.byteValue;
    }
}
