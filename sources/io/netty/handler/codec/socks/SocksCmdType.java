package io.netty.handler.codec.socks;

public enum SocksCmdType {
    CONNECT((byte) 1),
    BIND((byte) 2),
    UDP((byte) 3),
    UNKNOWN((byte) -1);
    
    private final byte b;

    private SocksCmdType(byte b2) {
        this.b = b2;
    }

    @Deprecated
    public static SocksCmdType fromByte(byte b2) {
        return valueOf(b2);
    }

    public byte byteValue() {
        return this.b;
    }

    public static SocksCmdType valueOf(byte b2) {
        for (SocksCmdType socksCmdType : values()) {
            if (socksCmdType.b == b2) {
                return socksCmdType;
            }
        }
        return UNKNOWN;
    }
}
