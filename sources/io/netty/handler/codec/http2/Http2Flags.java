package io.netty.handler.codec.http2;

public final class Http2Flags {
    public static final short ACK = 1;
    public static final short END_HEADERS = 4;
    public static final short END_STREAM = 1;
    public static final short PADDED = 8;
    public static final short PRIORITY = 32;
    private short value;

    public Http2Flags() {
    }

    public boolean ack() {
        return isFlagSet(1);
    }

    public boolean endOfHeaders() {
        return isFlagSet(4);
    }

    public boolean endOfStream() {
        return isFlagSet(1);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && Http2Flags.class == obj.getClass()) {
            return this.value == ((Http2Flags) obj).value;
        }
        return false;
    }

    public int getNumPriorityBytes() {
        return priorityPresent() ? 5 : 0;
    }

    public int getPaddingPresenceFieldLength() {
        return paddingPresent() ? 1 : 0;
    }

    public int hashCode() {
        return 31 + this.value;
    }

    public boolean isFlagSet(short s) {
        return (this.value & s) != 0;
    }

    public boolean paddingPresent() {
        return isFlagSet(8);
    }

    public boolean priorityPresent() {
        return isFlagSet(32);
    }

    public Http2Flags setFlag(boolean z, short s) {
        if (z) {
            this.value = (short) (this.value | s);
        } else {
            this.value = (short) (this.value & (~s));
        }
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("value = ");
        sb.append(this.value);
        sb.append(" (");
        if (ack()) {
            sb.append("ACK,");
        }
        if (endOfHeaders()) {
            sb.append("END_OF_HEADERS,");
        }
        if (endOfStream()) {
            sb.append("END_OF_STREAM,");
        }
        if (priorityPresent()) {
            sb.append("PRIORITY_PRESENT,");
        }
        if (paddingPresent()) {
            sb.append("PADDING_PRESENT,");
        }
        sb.append(')');
        return sb.toString();
    }

    public short value() {
        return this.value;
    }

    public Http2Flags(short s) {
        this.value = s;
    }

    public Http2Flags ack(boolean z) {
        return setFlag(z, 1);
    }

    public Http2Flags endOfHeaders(boolean z) {
        return setFlag(z, 4);
    }

    public Http2Flags endOfStream(boolean z) {
        return setFlag(z, 1);
    }

    public Http2Flags paddingPresent(boolean z) {
        return setFlag(z, 8);
    }

    public Http2Flags priorityPresent(boolean z) {
        return setFlag(z, 32);
    }
}
