package io.netty.handler.codec.haproxy;

public enum HAProxyProxiedProtocol {
    UNKNOWN((byte) 0, AddressFamily.AF_UNSPEC, TransportProtocol.UNSPEC),
    TCP4((byte) 17, r0, r12),
    TCP6((byte) 33, r4, r12),
    UDP4((byte) 18, r0, r12),
    UDP6((byte) 34, r4, r12),
    UNIX_STREAM((byte) 49, r11, r2),
    UNIX_DGRAM((byte) 50, r11, r13);
    
    private final AddressFamily addressFamily;
    private final byte byteValue;
    private final TransportProtocol transportProtocol;

    public enum AddressFamily {
        AF_UNSPEC((byte) 0),
        AF_IPv4((byte) 16),
        AF_IPv6((byte) 32),
        AF_UNIX((byte) 48);
        
        private static final byte FAMILY_MASK = -16;
        private final byte byteValue;

        private AddressFamily(byte b) {
            this.byteValue = b;
        }

        public byte byteValue() {
            return this.byteValue;
        }

        public static AddressFamily valueOf(byte b) {
            byte b2 = b & FAMILY_MASK;
            byte b3 = (byte) b2;
            if (b3 == 0) {
                return AF_UNSPEC;
            }
            if (b3 == 16) {
                return AF_IPv4;
            }
            if (b3 == 32) {
                return AF_IPv6;
            }
            if (b3 == 48) {
                return AF_UNIX;
            }
            throw new IllegalArgumentException("unknown address family: " + b2);
        }
    }

    public enum TransportProtocol {
        UNSPEC((byte) 0),
        STREAM((byte) 1),
        DGRAM((byte) 2);
        
        private static final byte TRANSPORT_MASK = 15;
        private final byte transportByte;

        private TransportProtocol(byte b) {
            this.transportByte = b;
        }

        public byte byteValue() {
            return this.transportByte;
        }

        public static TransportProtocol valueOf(byte b) {
            byte b2 = b & 15;
            byte b3 = (byte) b2;
            if (b3 == 0) {
                return UNSPEC;
            }
            if (b3 == 1) {
                return STREAM;
            }
            if (b3 == 2) {
                return DGRAM;
            }
            throw new IllegalArgumentException("unknown transport protocol: " + b2);
        }
    }

    private HAProxyProxiedProtocol(byte b, AddressFamily addressFamily2, TransportProtocol transportProtocol2) {
        this.byteValue = b;
        this.addressFamily = addressFamily2;
        this.transportProtocol = transportProtocol2;
    }

    public AddressFamily addressFamily() {
        return this.addressFamily;
    }

    public byte byteValue() {
        return this.byteValue;
    }

    public TransportProtocol transportProtocol() {
        return this.transportProtocol;
    }

    public static HAProxyProxiedProtocol valueOf(byte b) {
        if (b == 0) {
            return UNKNOWN;
        }
        if (b == 17) {
            return TCP4;
        }
        if (b == 18) {
            return UDP4;
        }
        if (b == 33) {
            return TCP6;
        }
        if (b == 34) {
            return UDP6;
        }
        if (b == 49) {
            return UNIX_STREAM;
        }
        if (b == 50) {
            return UNIX_DGRAM;
        }
        throw new IllegalArgumentException("unknown transport protocol + address family: " + (b & 255));
    }
}
