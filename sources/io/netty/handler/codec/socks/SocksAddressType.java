package io.netty.handler.codec.socks;

public enum SocksAddressType {
    IPv4((byte) 1),
    DOMAIN((byte) 3),
    IPv6((byte) 4),
    UNKNOWN((byte) -1);
    
    private final byte b;

    private SocksAddressType(byte b2) {
        this.b = b2;
    }

    @Deprecated
    public static SocksAddressType fromByte(byte b2) {
        return valueOf(b2);
    }

    public byte byteValue() {
        return this.b;
    }

    public static SocksAddressType valueOf(byte b2) {
        for (SocksAddressType socksAddressType : values()) {
            if (socksAddressType.b == b2) {
                return socksAddressType;
            }
        }
        return UNKNOWN;
    }
}
