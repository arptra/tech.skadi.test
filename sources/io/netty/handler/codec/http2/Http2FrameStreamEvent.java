package io.netty.handler.codec.http2;

public final class Http2FrameStreamEvent {
    private final Http2FrameStream stream;
    private final Type type;

    public enum Type {
        State,
        Writability
    }

    private Http2FrameStreamEvent(Http2FrameStream http2FrameStream, Type type2) {
        this.stream = http2FrameStream;
        this.type = type2;
    }

    public static Http2FrameStreamEvent stateChanged(Http2FrameStream http2FrameStream) {
        return new Http2FrameStreamEvent(http2FrameStream, Type.State);
    }

    public static Http2FrameStreamEvent writabilityChanged(Http2FrameStream http2FrameStream) {
        return new Http2FrameStreamEvent(http2FrameStream, Type.Writability);
    }

    public Http2FrameStream stream() {
        return this.stream;
    }

    public Type type() {
        return this.type;
    }
}
