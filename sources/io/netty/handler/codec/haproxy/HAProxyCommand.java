package io.netty.handler.codec.haproxy;

public enum HAProxyCommand {
    LOCAL((byte) 0),
    PROXY((byte) 1);
    
    private static final byte COMMAND_MASK = 15;
    private final byte byteValue;

    private HAProxyCommand(byte b) {
        this.byteValue = b;
    }

    public byte byteValue() {
        return this.byteValue;
    }

    public static HAProxyCommand valueOf(byte b) {
        byte b2 = b & 15;
        byte b3 = (byte) b2;
        if (b3 == 0) {
            return LOCAL;
        }
        if (b3 == 1) {
            return PROXY;
        }
        throw new IllegalArgumentException("unknown command: " + b2);
    }
}
