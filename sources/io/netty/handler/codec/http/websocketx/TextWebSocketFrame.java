package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;

public class TextWebSocketFrame extends WebSocketFrame {
    public TextWebSocketFrame() {
        super(Unpooled.buffer(0));
    }

    private static ByteBuf fromText(String str) {
        return (str == null || str.isEmpty()) ? Unpooled.EMPTY_BUFFER : Unpooled.copiedBuffer((CharSequence) str, CharsetUtil.UTF_8);
    }

    public String text() {
        return content().toString(CharsetUtil.UTF_8);
    }

    public TextWebSocketFrame(String str) {
        super(fromText(str));
    }

    public TextWebSocketFrame(ByteBuf byteBuf) {
        super(byteBuf);
    }

    public TextWebSocketFrame copy() {
        return (TextWebSocketFrame) super.copy();
    }

    public TextWebSocketFrame duplicate() {
        return (TextWebSocketFrame) super.duplicate();
    }

    public TextWebSocketFrame replace(ByteBuf byteBuf) {
        return new TextWebSocketFrame(isFinalFragment(), rsv(), byteBuf);
    }

    public TextWebSocketFrame retainedDuplicate() {
        return (TextWebSocketFrame) super.retainedDuplicate();
    }

    public TextWebSocketFrame(boolean z, int i, String str) {
        super(z, i, fromText(str));
    }

    public TextWebSocketFrame(boolean z, int i, ByteBuf byteBuf) {
        super(z, i, byteBuf);
    }

    public TextWebSocketFrame retain() {
        super.retain();
        return this;
    }

    public TextWebSocketFrame touch() {
        super.touch();
        return this;
    }

    public TextWebSocketFrame retain(int i) {
        super.retain(i);
        return this;
    }

    public TextWebSocketFrame touch(Object obj) {
        super.touch(obj);
        return this;
    }
}
