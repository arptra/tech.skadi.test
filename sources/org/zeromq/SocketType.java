package org.zeromq;

public enum SocketType {
    PAIR(0),
    PUB(1),
    SUB(2),
    REQ(3),
    REP(4),
    DEALER(5),
    ROUTER(6),
    PULL(7),
    PUSH(8),
    XPUB(9),
    XSUB(10),
    STREAM(11),
    CLIENT(13),
    SERVER(12),
    RADIO(14),
    DISH(15),
    CHANNEL(16),
    PEER(17),
    RAW(18),
    SCATTER(19),
    GATHER(20);
    
    public final int type;

    private SocketType(int i) {
        this.type = i;
    }

    public static SocketType type(int i) {
        for (SocketType socketType : values()) {
            if (socketType.type == i) {
                return socketType;
            }
        }
        throw new IllegalArgumentException("no socket type found with value " + i);
    }

    public int type() {
        return this.type;
    }
}
