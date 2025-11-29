package io.netty.handler.codec.http;

import io.netty.util.AsciiString;
import org.eclipse.jetty.util.URIUtil;

public final class HttpScheme {
    public static final HttpScheme HTTP = new HttpScheme(80, URIUtil.HTTP);
    public static final HttpScheme HTTPS = new HttpScheme(443, URIUtil.HTTPS);
    private final AsciiString name;
    private final int port;

    private HttpScheme(int i, String str) {
        this.port = i;
        this.name = AsciiString.cached(str);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof HttpScheme)) {
            return false;
        }
        HttpScheme httpScheme = (HttpScheme) obj;
        return httpScheme.port() == this.port && httpScheme.name().equals(this.name);
    }

    public int hashCode() {
        return (this.port * 31) + this.name.hashCode();
    }

    public AsciiString name() {
        return this.name;
    }

    public int port() {
        return this.port;
    }

    public String toString() {
        return this.name.toString();
    }
}
