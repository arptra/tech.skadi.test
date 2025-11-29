package io.netty.handler.codec.http2;

public final class DefaultHttp2PriorityFrame extends AbstractHttp2StreamFrame implements Http2PriorityFrame {
    private final boolean exclusive;
    private final int streamDependency;
    private final short weight;

    public DefaultHttp2PriorityFrame(int i, short s, boolean z) {
        this.streamDependency = i;
        this.weight = s;
        this.exclusive = z;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DefaultHttp2PriorityFrame)) {
            return false;
        }
        DefaultHttp2PriorityFrame defaultHttp2PriorityFrame = (DefaultHttp2PriorityFrame) obj;
        return super.equals(defaultHttp2PriorityFrame) && this.streamDependency == defaultHttp2PriorityFrame.streamDependency && this.weight == defaultHttp2PriorityFrame.weight && this.exclusive == defaultHttp2PriorityFrame.exclusive;
    }

    public boolean exclusive() {
        return this.exclusive;
    }

    public int hashCode() {
        return (((((super.hashCode() * 31) + this.streamDependency) * 31) + this.weight) * 31) + (this.exclusive ? 1 : 0);
    }

    public String name() {
        return "PRIORITY_FRAME";
    }

    public int streamDependency() {
        return this.streamDependency;
    }

    public String toString() {
        return "DefaultHttp2PriorityFrame(stream=" + stream() + ", streamDependency=" + this.streamDependency + ", weight=" + this.weight + ", exclusive=" + this.exclusive + ')';
    }

    public short weight() {
        return this.weight;
    }

    public DefaultHttp2PriorityFrame stream(Http2FrameStream http2FrameStream) {
        super.stream(http2FrameStream);
        return this;
    }
}
