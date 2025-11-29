package io.netty.handler.codec.socks;

public enum SocksSubnegotiationVersion {
    AUTH_PASSWORD((byte) 1),
    UNKNOWN((byte) -1);
    
    private final byte b;

    private SocksSubnegotiationVersion(byte b2) {
        this.b = b2;
    }

    @Deprecated
    public static SocksSubnegotiationVersion fromByte(byte b2) {
        return valueOf(b2);
    }

    public byte byteValue() {
        return this.b;
    }

    public static SocksSubnegotiationVersion valueOf(byte b2) {
        for (SocksSubnegotiationVersion socksSubnegotiationVersion : values()) {
            if (socksSubnegotiationVersion.b == b2) {
                return socksSubnegotiationVersion;
            }
        }
        return UNKNOWN;
    }
}
