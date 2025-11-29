package io.netty.handler.codec.haproxy;

public enum HAProxyProtocolVersion {
    V1((byte) 16),
    V2((byte) 32);
    
    private static final byte VERSION_MASK = -16;
    private final byte byteValue;

    private HAProxyProtocolVersion(byte b) {
        this.byteValue = b;
    }

    public byte byteValue() {
        return this.byteValue;
    }

    public static HAProxyProtocolVersion valueOf(byte b) {
        byte b2 = b & VERSION_MASK;
        byte b3 = (byte) b2;
        if (b3 == 16) {
            return V1;
        }
        if (b3 == 32) {
            return V2;
        }
        throw new IllegalArgumentException("unknown version: " + b2);
    }
}
