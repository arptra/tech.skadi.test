package io.netty.handler.codec.stomp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.ObjectUtil;

public class DefaultStompFrame extends DefaultStompHeadersSubframe implements StompFrame {
    private final ByteBuf content;

    public DefaultStompFrame(StompCommand stompCommand) {
        this(stompCommand, Unpooled.buffer(0));
    }

    public ByteBuf content() {
        return this.content;
    }

    public int refCnt() {
        return this.content.refCnt();
    }

    public boolean release() {
        return this.content.release();
    }

    public String toString() {
        return "DefaultStompFrame{command=" + this.command + ", headers=" + this.headers + ", content=" + this.content.toString(CharsetUtil.UTF_8) + '}';
    }

    public DefaultStompFrame(StompCommand stompCommand, ByteBuf byteBuf) {
        this(stompCommand, byteBuf, (DefaultStompHeaders) null);
    }

    public boolean release(int i) {
        return this.content.release(i);
    }

    public DefaultStompFrame(StompCommand stompCommand, ByteBuf byteBuf, DefaultStompHeaders defaultStompHeaders) {
        super(stompCommand, defaultStompHeaders);
        this.content = (ByteBuf) ObjectUtil.checkNotNull(byteBuf, "content");
    }

    public StompFrame copy() {
        return replace(this.content.copy());
    }

    public StompFrame duplicate() {
        return replace(this.content.duplicate());
    }

    public StompFrame replace(ByteBuf byteBuf) {
        return new DefaultStompFrame(this.command, byteBuf, this.headers.copy());
    }

    public StompFrame retainedDuplicate() {
        return replace(this.content.retainedDuplicate());
    }

    public StompFrame retain() {
        this.content.retain();
        return this;
    }

    public StompFrame touch() {
        this.content.touch();
        return this;
    }

    public StompFrame retain(int i) {
        this.content.retain(i);
        return this;
    }

    public StompFrame touch(Object obj) {
        this.content.touch(obj);
        return this;
    }
}
