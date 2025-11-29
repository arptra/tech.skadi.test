package io.netty.handler.codec.socks;

public enum SocksCmdStatus {
    SUCCESS((byte) 0),
    FAILURE((byte) 1),
    FORBIDDEN((byte) 2),
    NETWORK_UNREACHABLE((byte) 3),
    HOST_UNREACHABLE((byte) 4),
    REFUSED((byte) 5),
    TTL_EXPIRED((byte) 6),
    COMMAND_NOT_SUPPORTED((byte) 7),
    ADDRESS_NOT_SUPPORTED((byte) 8),
    UNASSIGNED((byte) -1);
    
    private final byte b;

    private SocksCmdStatus(byte b2) {
        this.b = b2;
    }

    @Deprecated
    public static SocksCmdStatus fromByte(byte b2) {
        return valueOf(b2);
    }

    public byte byteValue() {
        return this.b;
    }

    public static SocksCmdStatus valueOf(byte b2) {
        for (SocksCmdStatus socksCmdStatus : values()) {
            if (socksCmdStatus.b == b2) {
                return socksCmdStatus;
            }
        }
        return UNASSIGNED;
    }
}
