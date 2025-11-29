package io.netty.handler.codec.spdy;

import io.netty.util.internal.ObjectUtil;

public abstract class DefaultSpdyStreamFrame implements SpdyStreamFrame {
    private boolean last;
    private int streamId;

    public DefaultSpdyStreamFrame(int i) {
        setStreamId(i);
    }

    public boolean isLast() {
        return this.last;
    }

    public SpdyStreamFrame setLast(boolean z) {
        this.last = z;
        return this;
    }

    public SpdyStreamFrame setStreamId(int i) {
        ObjectUtil.checkPositive(i, "streamId");
        this.streamId = i;
        return this;
    }

    public int streamId() {
        return this.streamId;
    }
}
