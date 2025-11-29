package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;

public class CloseWebSocketFrame extends WebSocketFrame {
    public CloseWebSocketFrame() {
        super(Unpooled.buffer(0));
    }

    private static ByteBuf newBinaryData(int i, String str) {
        if (str == null) {
            str = "";
        }
        ByteBuf buffer = Unpooled.buffer(str.length() + 2);
        buffer.writeShort(i);
        if (!str.isEmpty()) {
            buffer.writeCharSequence(str, CharsetUtil.UTF_8);
        }
        return buffer;
    }

    public static int requireValidStatusCode(int i) {
        if (WebSocketCloseStatus.isValidStatusCode(i)) {
            return i;
        }
        throw new IllegalArgumentException("WebSocket close status code does NOT comply with RFC-6455: " + i);
    }

    public String reasonText() {
        ByteBuf content = content();
        return (content == null || content.readableBytes() <= 2) ? "" : content.toString(content.readerIndex() + 2, content.readableBytes() - 2, CharsetUtil.UTF_8);
    }

    public int statusCode() {
        ByteBuf content = content();
        if (content == null || content.readableBytes() < 2) {
            return -1;
        }
        return content.getShort(content.readerIndex());
    }

    public CloseWebSocketFrame(WebSocketCloseStatus webSocketCloseStatus) {
        this(requireValidStatusCode(webSocketCloseStatus.code()), webSocketCloseStatus.reasonText());
    }

    public CloseWebSocketFrame(WebSocketCloseStatus webSocketCloseStatus, String str) {
        this(requireValidStatusCode(webSocketCloseStatus.code()), str);
    }

    public CloseWebSocketFrame copy() {
        return (CloseWebSocketFrame) super.copy();
    }

    public CloseWebSocketFrame duplicate() {
        return (CloseWebSocketFrame) super.duplicate();
    }

    public CloseWebSocketFrame replace(ByteBuf byteBuf) {
        return new CloseWebSocketFrame(isFinalFragment(), rsv(), byteBuf);
    }

    public CloseWebSocketFrame retainedDuplicate() {
        return (CloseWebSocketFrame) super.retainedDuplicate();
    }

    public CloseWebSocketFrame(int i, String str) {
        this(true, 0, requireValidStatusCode(i), str);
    }

    public CloseWebSocketFrame(boolean z, int i) {
        this(z, i, Unpooled.buffer(0));
    }

    public CloseWebSocketFrame(boolean z, int i, int i2, String str) {
        super(z, i, newBinaryData(requireValidStatusCode(i2), str));
    }

    public CloseWebSocketFrame(boolean z, int i, ByteBuf byteBuf) {
        super(z, i, byteBuf);
    }

    public CloseWebSocketFrame retain() {
        super.retain();
        return this;
    }

    public CloseWebSocketFrame touch() {
        super.touch();
        return this;
    }

    public CloseWebSocketFrame retain(int i) {
        super.retain(i);
        return this;
    }

    public CloseWebSocketFrame touch(Object obj) {
        super.touch(obj);
        return this;
    }
}
