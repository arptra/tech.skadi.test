package io.netty.handler.codec.socksx;

public enum SocksVersion {
    SOCKS4a((byte) 4),
    SOCKS5((byte) 5),
    UNKNOWN((byte) -1);
    
    private final byte b;

    private SocksVersion(byte b2) {
        this.b = b2;
    }

    public byte byteValue() {
        return this.b;
    }

    public static SocksVersion valueOf(byte b2) {
        SocksVersion socksVersion = SOCKS4a;
        if (b2 == socksVersion.byteValue()) {
            return socksVersion;
        }
        SocksVersion socksVersion2 = SOCKS5;
        if (b2 == socksVersion2.byteValue()) {
            return socksVersion2;
        }
        return UNKNOWN;
    }
}
