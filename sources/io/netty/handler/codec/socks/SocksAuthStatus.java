package io.netty.handler.codec.socks;

public enum SocksAuthStatus {
    SUCCESS((byte) 0),
    FAILURE((byte) -1);
    
    private final byte b;

    private SocksAuthStatus(byte b2) {
        this.b = b2;
    }

    @Deprecated
    public static SocksAuthStatus fromByte(byte b2) {
        return valueOf(b2);
    }

    public byte byteValue() {
        return this.b;
    }

    public static SocksAuthStatus valueOf(byte b2) {
        for (SocksAuthStatus socksAuthStatus : values()) {
            if (socksAuthStatus.b == b2) {
                return socksAuthStatus;
            }
        }
        return FAILURE;
    }
}
