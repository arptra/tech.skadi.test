package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class BinaryWebSocketFrame extends WebSocketFrame {
    public BinaryWebSocketFrame() {
        super(Unpooled.buffer(0));
    }

    public BinaryWebSocketFrame(ByteBuf byteBuf) {
        super(byteBuf);
    }

    public BinaryWebSocketFrame(boolean z, int i, ByteBuf byteBuf) {
        super(z, i, byteBuf);
    }

    public BinaryWebSocketFrame copy() {
        return (BinaryWebSocketFrame) super.copy();
    }

    public BinaryWebSocketFrame duplicate() {
        return (BinaryWebSocketFrame) super.duplicate();
    }

    public BinaryWebSocketFrame replace(ByteBuf byteBuf) {
        return new BinaryWebSocketFrame(isFinalFragment(), rsv(), byteBuf);
    }

    public BinaryWebSocketFrame retainedDuplicate() {
        return (BinaryWebSocketFrame) super.retainedDuplicate();
    }

    public BinaryWebSocketFrame retain() {
        super.retain();
        return this;
    }

    public BinaryWebSocketFrame touch() {
        super.touch();
        return this;
    }

    public BinaryWebSocketFrame retain(int i) {
        super.retain(i);
        return this;
    }

    public BinaryWebSocketFrame touch(Object obj) {
        super.touch(obj);
        return this;
    }
}
