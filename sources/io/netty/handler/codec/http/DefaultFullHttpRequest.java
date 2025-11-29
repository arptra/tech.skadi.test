package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.internal.ObjectUtil;

public class DefaultFullHttpRequest extends DefaultHttpRequest implements FullHttpRequest {
    private final ByteBuf content;
    private int hash;
    private final HttpHeaders trailingHeader;

    public DefaultFullHttpRequest(HttpVersion httpVersion, HttpMethod httpMethod, String str) {
        this(httpVersion, httpMethod, str, Unpooled.buffer(0));
    }

    public ByteBuf content() {
        return this.content;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DefaultFullHttpRequest)) {
            return false;
        }
        DefaultFullHttpRequest defaultFullHttpRequest = (DefaultFullHttpRequest) obj;
        return super.equals(defaultFullHttpRequest) && content().equals(defaultFullHttpRequest.content()) && trailingHeaders().equals(defaultFullHttpRequest.trailingHeaders());
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
        return HttpMessageUtil.appendFullRequest(new StringBuilder(256), this).toString();
    }

    public HttpHeaders trailingHeaders() {
        return this.trailingHeader;
    }

    public DefaultFullHttpRequest(HttpVersion httpVersion, HttpMethod httpMethod, String str, ByteBuf byteBuf) {
        this(httpVersion, httpMethod, str, byteBuf, true);
    }

    public boolean release(int i) {
        return this.content.release(i);
    }

    public FullHttpRequest setMethod(HttpMethod httpMethod) {
        super.setMethod(httpMethod);
        return this;
    }

    public FullHttpRequest setUri(String str) {
        super.setUri(str);
        return this;
    }

    public DefaultFullHttpRequest(HttpVersion httpVersion, HttpMethod httpMethod, String str, boolean z) {
        this(httpVersion, httpMethod, str, Unpooled.buffer(0), z);
    }

    public FullHttpRequest setProtocolVersion(HttpVersion httpVersion) {
        super.setProtocolVersion(httpVersion);
        return this;
    }

    public DefaultFullHttpRequest(HttpVersion httpVersion, HttpMethod httpMethod, String str, ByteBuf byteBuf, boolean z) {
        super(httpVersion, httpMethod, str, z);
        this.content = (ByteBuf) ObjectUtil.checkNotNull(byteBuf, "content");
        this.trailingHeader = new DefaultHttpHeaders(z);
    }

    public FullHttpRequest copy() {
        return replace(content().copy());
    }

    public FullHttpRequest duplicate() {
        return replace(content().duplicate());
    }

    public FullHttpRequest replace(ByteBuf byteBuf) {
        DefaultFullHttpRequest defaultFullHttpRequest = new DefaultFullHttpRequest(protocolVersion(), method(), uri(), byteBuf, headers().copy(), trailingHeaders().copy());
        defaultFullHttpRequest.setDecoderResult(decoderResult());
        return defaultFullHttpRequest;
    }

    public FullHttpRequest retainedDuplicate() {
        return replace(content().retainedDuplicate());
    }

    public DefaultFullHttpRequest(HttpVersion httpVersion, HttpMethod httpMethod, String str, ByteBuf byteBuf, HttpHeaders httpHeaders, HttpHeaders httpHeaders2) {
        super(httpVersion, httpMethod, str, httpHeaders);
        this.content = (ByteBuf) ObjectUtil.checkNotNull(byteBuf, "content");
        this.trailingHeader = (HttpHeaders) ObjectUtil.checkNotNull(httpHeaders2, "trailingHeader");
    }

    public FullHttpRequest retain() {
        this.content.retain();
        return this;
    }

    public FullHttpRequest touch() {
        this.content.touch();
        return this;
    }

    public FullHttpRequest retain(int i) {
        this.content.retain(i);
        return this;
    }

    public FullHttpRequest touch(Object obj) {
        this.content.touch(obj);
        return this;
    }
}
