package io.netty.handler.codec.spdy;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

public class DefaultSpdyDataFrame extends DefaultSpdyStreamFrame implements SpdyDataFrame {
    private final ByteBuf data;

    public DefaultSpdyDataFrame(int i) {
        this(i, Unpooled.buffer(0));
    }

    private static ByteBuf validate(ByteBuf byteBuf) {
        if (byteBuf.readableBytes() <= 16777215) {
            return byteBuf;
        }
        throw new IllegalArgumentException("data payload cannot exceed 16777215 bytes");
    }

    public ByteBuf content() {
        return ByteBufUtil.ensureAccessible(this.data);
    }

    public int refCnt() {
        return this.data.refCnt();
    }

    public boolean release() {
        return this.data.release();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(StringUtil.simpleClassName((Object) this));
        sb.append("(last: ");
        sb.append(isLast());
        sb.append(')');
        String str = StringUtil.NEWLINE;
        sb.append(str);
        sb.append("--> Stream-ID = ");
        sb.append(streamId());
        sb.append(str);
        sb.append("--> Size = ");
        if (refCnt() == 0) {
            sb.append("(freed)");
        } else {
            sb.append(content().readableBytes());
        }
        return sb.toString();
    }

    public DefaultSpdyDataFrame(int i, ByteBuf byteBuf) {
        super(i);
        this.data = validate((ByteBuf) ObjectUtil.checkNotNull(byteBuf, "data"));
    }

    public SpdyDataFrame copy() {
        return replace(content().copy());
    }

    public SpdyDataFrame duplicate() {
        return replace(content().duplicate());
    }

    public boolean release(int i) {
        return this.data.release(i);
    }

    public SpdyDataFrame replace(ByteBuf byteBuf) {
        DefaultSpdyDataFrame defaultSpdyDataFrame = new DefaultSpdyDataFrame(streamId(), byteBuf);
        defaultSpdyDataFrame.setLast(isLast());
        return defaultSpdyDataFrame;
    }

    public SpdyDataFrame retainedDuplicate() {
        return replace(content().retainedDuplicate());
    }

    public SpdyDataFrame setLast(boolean z) {
        super.setLast(z);
        return this;
    }

    public SpdyDataFrame setStreamId(int i) {
        super.setStreamId(i);
        return this;
    }

    public SpdyDataFrame retain() {
        this.data.retain();
        return this;
    }

    public SpdyDataFrame touch() {
        this.data.touch();
        return this;
    }

    public SpdyDataFrame retain(int i) {
        this.data.retain(i);
        return this;
    }

    public SpdyDataFrame touch(Object obj) {
        this.data.touch(obj);
        return this;
    }
}
