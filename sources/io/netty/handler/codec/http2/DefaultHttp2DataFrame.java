package io.netty.handler.codec.http2;

import com.here.posclient.UpdateOptions;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

public final class DefaultHttp2DataFrame extends AbstractHttp2StreamFrame implements Http2DataFrame {
    private final ByteBuf content;
    private final boolean endStream;
    private final int initialFlowControlledBytes;
    private final int padding;

    public DefaultHttp2DataFrame(ByteBuf byteBuf) {
        this(byteBuf, false);
    }

    public ByteBuf content() {
        return ByteBufUtil.ensureAccessible(this.content);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DefaultHttp2DataFrame)) {
            return false;
        }
        DefaultHttp2DataFrame defaultHttp2DataFrame = (DefaultHttp2DataFrame) obj;
        return super.equals(defaultHttp2DataFrame) && this.content.equals(defaultHttp2DataFrame.content()) && this.endStream == defaultHttp2DataFrame.endStream && this.padding == defaultHttp2DataFrame.padding;
    }

    public int hashCode() {
        return (((((super.hashCode() * 31) + this.content.hashCode()) * 31) + (this.endStream ^ true ? 1 : 0)) * 31) + this.padding;
    }

    public int initialFlowControlledBytes() {
        return this.initialFlowControlledBytes;
    }

    public boolean isEndStream() {
        return this.endStream;
    }

    public String name() {
        return "DATA";
    }

    public int padding() {
        return this.padding;
    }

    public int refCnt() {
        return this.content.refCnt();
    }

    public boolean release() {
        return this.content.release();
    }

    public String toString() {
        return StringUtil.simpleClassName((Object) this) + "(stream=" + stream() + ", content=" + this.content + ", endStream=" + this.endStream + ", padding=" + this.padding + ')';
    }

    public DefaultHttp2DataFrame(boolean z) {
        this(Unpooled.EMPTY_BUFFER, z);
    }

    public boolean release(int i) {
        return this.content.release(i);
    }

    public DefaultHttp2DataFrame(ByteBuf byteBuf, boolean z) {
        this(byteBuf, z, 0);
    }

    public DefaultHttp2DataFrame copy() {
        return replace(content().copy());
    }

    public DefaultHttp2DataFrame duplicate() {
        return replace(content().duplicate());
    }

    public DefaultHttp2DataFrame replace(ByteBuf byteBuf) {
        return new DefaultHttp2DataFrame(byteBuf, this.endStream, this.padding);
    }

    public DefaultHttp2DataFrame retainedDuplicate() {
        return replace(content().retainedDuplicate());
    }

    public DefaultHttp2DataFrame stream(Http2FrameStream http2FrameStream) {
        super.stream(http2FrameStream);
        return this;
    }

    public DefaultHttp2DataFrame(ByteBuf byteBuf, boolean z, int i) {
        this.content = (ByteBuf) ObjectUtil.checkNotNull(byteBuf, "content");
        this.endStream = z;
        Http2CodecUtil.verifyPadding(i);
        this.padding = i;
        if (((long) content().readableBytes()) + ((long) i) <= UpdateOptions.SOURCE_ANY) {
            this.initialFlowControlledBytes = content().readableBytes() + i;
            return;
        }
        throw new IllegalArgumentException("content + padding must be <= Integer.MAX_VALUE");
    }

    public DefaultHttp2DataFrame retain() {
        this.content.retain();
        return this;
    }

    public DefaultHttp2DataFrame touch() {
        this.content.touch();
        return this;
    }

    public DefaultHttp2DataFrame retain(int i) {
        this.content.retain(i);
        return this;
    }

    public DefaultHttp2DataFrame touch(Object obj) {
        this.content.touch(obj);
        return this;
    }
}
