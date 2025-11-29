package io.netty.handler.codec.socks;

public enum SocksAuthScheme {
    NO_AUTH((byte) 0),
    AUTH_GSSAPI((byte) 1),
    AUTH_PASSWORD((byte) 2),
    UNKNOWN((byte) -1);
    
    private final byte b;

    private SocksAuthScheme(byte b2) {
        this.b = b2;
    }

    @Deprecated
    public static SocksAuthScheme fromByte(byte b2) {
        return valueOf(b2);
    }

    public byte byteValue() {
        return this.b;
    }

    public static SocksAuthScheme valueOf(byte b2) {
        for (SocksAuthScheme socksAuthScheme : values()) {
            if (socksAuthScheme.b == b2) {
                return socksAuthScheme;
            }
        }
        return UNKNOWN;
    }
}
