package io.netty.handler.codec.socks;

public enum SocksProtocolVersion {
    SOCKS4a((byte) 4),
    SOCKS5((byte) 5),
    UNKNOWN((byte) -1);
    
    private final byte b;

    private SocksProtocolVersion(byte b2) {
        this.b = b2;
    }

    @Deprecated
    public static SocksProtocolVersion fromByte(byte b2) {
        return valueOf(b2);
    }

    public byte byteValue() {
        return this.b;
    }

    public static SocksProtocolVersion valueOf(byte b2) {
        for (SocksProtocolVersion socksProtocolVersion : values()) {
            if (socksProtocolVersion.b == b2) {
                return socksProtocolVersion;
            }
        }
        return UNKNOWN;
    }
}
