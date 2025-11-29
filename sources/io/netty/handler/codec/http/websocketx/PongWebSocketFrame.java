package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class PongWebSocketFrame extends WebSocketFrame {
    public PongWebSocketFrame() {
        super(Unpooled.buffer(0));
    }

    public PongWebSocketFrame(ByteBuf byteBuf) {
        super(byteBuf);
    }

    public PongWebSocketFrame(boolean z, int i, ByteBuf byteBuf) {
        super(z, i, byteBuf);
    }

    public PongWebSocketFrame copy() {
        return (PongWebSocketFrame) super.copy();
    }

    public PongWebSocketFrame duplicate() {
        return (PongWebSocketFrame) super.duplicate();
    }

    public PongWebSocketFrame replace(ByteBuf byteBuf) {
        return new PongWebSocketFrame(isFinalFragment(), rsv(), byteBuf);
    }

    public PongWebSocketFrame retainedDuplicate() {
        return (PongWebSocketFrame) super.retainedDuplicate();
    }

    public PongWebSocketFrame retain() {
        super.retain();
        return this;
    }

    public PongWebSocketFrame touch() {
        super.touch();
        return this;
    }

    public PongWebSocketFrame retain(int i) {
        super.retain(i);
        return this;
    }

    public PongWebSocketFrame touch(Object obj) {
        super.touch(obj);
        return this;
    }
}
