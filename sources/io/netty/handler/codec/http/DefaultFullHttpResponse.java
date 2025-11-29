package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.internal.ObjectUtil;

public class DefaultFullHttpResponse extends DefaultHttpResponse implements FullHttpResponse {
    private final ByteBuf content;
    private int hash;
    private final HttpHeaders trailingHeaders;

    public DefaultFullHttpResponse(HttpVersion httpVersion, HttpResponseStatus httpResponseStatus) {
        this(httpVersion, httpResponseStatus, Unpooled.buffer(0));
    }

    public ByteBuf content() {
        return this.content;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DefaultFullHttpResponse)) {
            return false;
        }
        DefaultFullHttpResponse defaultFullHttpResponse = (DefaultFullHttpResponse) obj;
        return super.equals(defaultFullHttpResponse) && content().equals(defaultFullHttpResponse.content()) && trailingHeaders().equals(defaultFullHttpResponse.trailingHeaders());
    }

    public int hashCode() {
        int i;
        int i2 = this.hash;
        if (i2 != 0) {
            return i2;
        }
        if (ByteBufUtil.isAccessible(content())) {
            try {
                i = content().hashCode() + 31;
            } catch (IllegalReferenceCountException unused) {
            }
            int hashCode = (((i * 31) + trailingHeaders().hashCode()) * 31) + super.hashCode();
            this.hash = hashCode;
            return hashCode;
        }
        i = 31;
        int hashCode2 = (((i * 31) + trailingHeaders().hashCode()) * 31) + super.hashCode();
        this.hash = hashCode2;
        return hashCode2;
    }

    public int refCnt() {
        return this.content.refCnt();
    }

    public boolean release() {
        return this.content.release();
    }

    public String toString() {
        return HttpMessageUtil.appendFullResponse(new StringBuilder(256), this).toString();
    }

    public HttpHeaders trailingHeaders() {
        return this.trailingHeaders;
    }

    public DefaultFullHttpResponse(HttpVersion httpVersion, HttpResponseStatus httpResponseStatus, ByteBuf byteBuf) {
        this(httpVersion, httpResponseStatus, byteBuf, true);
    }

    public boolean release(int i) {
        return this.content.release(i);
    }

    public FullHttpResponse setStatus(HttpResponseStatus httpResponseStatus) {
        super.setStatus(httpResponseStatus);
        return this;
    }

    public DefaultFullHttpResponse(HttpVersion httpVersion, HttpResponseStatus httpResponseStatus, boolean z) {
        this(httpVersion, httpResponseStatus, Unpooled.buffer(0), z, false);
    }

    public FullHttpResponse setProtocolVersion(HttpVersion httpVersion) {
        super.setProtocolVersion(httpVersion);
        return this;
    }

    public DefaultFullHttpResponse(HttpVersion httpVersion, HttpResponseStatus httpResponseStatus, boolean z, boolean z2) {
        this(httpVersion, httpResponseStatus, Unpooled.buffer(0), z, z2);
    }

    public DefaultFullHttpResponse(HttpVersion httpVersion, HttpResponseStatus httpResponseStatus, ByteBuf byteBuf, boolean z) {
        this(httpVersion, httpResponseStatus, byteBuf, z, false);
    }

    public FullHttpResponse copy() {
        return replace(content().copy());
    }

    public FullHttpResponse duplicate() {
        return replace(content().duplicate());
    }

    public FullHttpResponse replace(ByteBuf byteBuf) {
        DefaultFullHttpResponse defaultFullHttpResponse = new DefaultFullHttpResponse(protocolVersion(), status(), byteBuf, headers().copy(), trailingHeaders().copy());
        defaultFullHttpResponse.setDecoderResult(decoderResult());
        return defaultFullHttpResponse;
    }

    public FullHttpResponse retainedDuplicate() {
        return replace(content().retainedDuplicate());
    }

    public DefaultFullHttpResponse(HttpVersion httpVersion, HttpResponseStatus httpResponseStatus, ByteBuf byteBuf, boolean z, boolean z2) {
        super(httpVersion, httpResponseStatus, z, z2);
        this.content = (ByteBuf) ObjectUtil.checkNotNull(byteBuf, "content");
        this.trailingHeaders = z2 ? new CombinedHttpHeaders(z) : new DefaultHttpHeaders(z);
    }

    public DefaultFullHttpResponse(HttpVersion httpVersion, HttpResponseStatus httpResponseStatus, ByteBuf byteBuf, HttpHeaders httpHeaders, HttpHeaders httpHeaders2) {
        super(httpVersion, httpResponseStatus, httpHeaders);
        this.content = (ByteBuf) ObjectUtil.checkNotNull(byteBuf, "content");
        this.trailingHeaders = (HttpHeaders) ObjectUtil.checkNotNull(httpHeaders2, "trailingHeaders");
    }

    public FullHttpResponse retain() {
        this.content.retain();
        return this;
    }

    public FullHttpResponse touch() {
        this.content.touch();
        return this;
    }

    public FullHttpResponse retain(int i) {
        this.content.retain(i);
        return this;
    }

    public FullHttpResponse touch(Object obj) {
        this.content.touch(obj);
        return this;
    }
}
