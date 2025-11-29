package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class PingWebSocketFrame extends WebSocketFrame {
    public PingWebSocketFrame() {
        super(true, 0, Unpooled.buffer(0));
    }

    public PingWebSocketFrame(ByteBuf byteBuf) {
        super(byteBuf);
    }

    public PingWebSocketFrame(boolean z, int i, ByteBuf byteBuf) {
        super(z, i, byteBuf);
    }

    public PingWebSocketFrame copy() {
        return (PingWebSocketFrame) super.copy();
    }

    public PingWebSocketFrame duplicate() {
        return (PingWebSocketFrame) super.duplicate();
    }

    public PingWebSocketFrame replace(ByteBuf byteBuf) {
        return new PingWebSocketFrame(isFinalFragment(), rsv(), byteBuf);
    }

    public PingWebSocketFrame retainedDuplicate() {
        return (PingWebSocketFrame) super.retainedDuplicate();
    }

    public PingWebSocketFrame retain() {
        super.retain();
        return this;
    }

    public PingWebSocketFrame touch() {
        super.touch();
        return this;
    }

    public PingWebSocketFrame retain(int i) {
        super.retain(i);
        return this;
    }

    public PingWebSocketFrame touch(Object obj) {
        super.touch(obj);
        return this;
    }
}
