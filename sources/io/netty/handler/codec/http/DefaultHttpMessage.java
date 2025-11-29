package io.netty.handler.codec.http;

import io.netty.util.internal.ObjectUtil;

public abstract class DefaultHttpMessage extends DefaultHttpObject implements HttpMessage {
    private static final int HASH_CODE_PRIME = 31;
    private final HttpHeaders headers;
    private HttpVersion version;

    public DefaultHttpMessage(HttpVersion httpVersion) {
        this(httpVersion, true, false);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DefaultHttpMessage)) {
            return false;
        }
        DefaultHttpMessage defaultHttpMessage = (DefaultHttpMessage) obj;
        return headers().equals(defaultHttpMessage.headers()) && protocolVersion().equals(defaultHttpMessage.protocolVersion()) && super.equals(obj);
    }

    @Deprecated
    public HttpVersion getProtocolVersion() {
        return protocolVersion();
    }

    public int hashCode() {
        return ((((this.headers.hashCode() + 31) * 31) + this.version.hashCode()) * 31) + super.hashCode();
    }

    public HttpHeaders headers() {
        return this.headers;
    }

    public HttpVersion protocolVersion() {
        return this.version;
    }

    public HttpMessage setProtocolVersion(HttpVersion httpVersion) {
        this.version = (HttpVersion) ObjectUtil.checkNotNull(httpVersion, "version");
        return this;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DefaultHttpMessage(HttpVersion httpVersion, boolean z, boolean z2) {
        this(httpVersion, z2 ? new CombinedHttpHeaders(z) : new DefaultHttpHeaders(z));
    }

    public DefaultHttpMessage(HttpVersion httpVersion, HttpHeaders httpHeaders) {
        this.version = (HttpVersion) ObjectUtil.checkNotNull(httpVersion, "version");
        this.headers = (HttpHeaders) ObjectUtil.checkNotNull(httpHeaders, "headers");
    }
}
