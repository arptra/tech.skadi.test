package io.netty.handler.codec.spdy;

import io.netty.util.internal.StringUtil;

public class DefaultSpdyPingFrame implements SpdyPingFrame {
    private int id;

    public DefaultSpdyPingFrame(int i) {
        setId(i);
    }

    public int id() {
        return this.id;
    }

    public SpdyPingFrame setId(int i) {
        this.id = i;
        return this;
    }

    public String toString() {
        return StringUtil.simpleClassName((Object) this) + StringUtil.NEWLINE + "--> ID = " + id();
    }
}
