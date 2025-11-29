package io.netty.handler.codec.http2;

import io.netty.handler.codec.EmptyHeaders;
import io.netty.handler.codec.http2.Http2Headers;
import java.util.Iterator;

public final class EmptyHttp2Headers extends EmptyHeaders<CharSequence, CharSequence, Http2Headers> implements Http2Headers {
    public static final EmptyHttp2Headers INSTANCE = new EmptyHttp2Headers();

    private EmptyHttp2Headers() {
    }

    public boolean contains(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        return false;
    }

    public /* bridge */ /* synthetic */ Iterator valueIterator(CharSequence charSequence) {
        return super.valueIterator(charSequence);
    }

    public EmptyHttp2Headers authority(CharSequence charSequence) {
        throw new UnsupportedOperationException();
    }

    public EmptyHttp2Headers method(CharSequence charSequence) {
        throw new UnsupportedOperationException();
    }

    public EmptyHttp2Headers path(CharSequence charSequence) {
        throw new UnsupportedOperationException();
    }

    public EmptyHttp2Headers scheme(CharSequence charSequence) {
        throw new UnsupportedOperationException();
    }

    public EmptyHttp2Headers status(CharSequence charSequence) {
        throw new UnsupportedOperationException();
    }

    public CharSequence authority() {
        return (CharSequence) get(Http2Headers.PseudoHeaderName.AUTHORITY.value());
    }

    public CharSequence method() {
        return (CharSequence) get(Http2Headers.PseudoHeaderName.METHOD.value());
    }

    public CharSequence path() {
        return (CharSequence) get(Http2Headers.PseudoHeaderName.PATH.value());
    }

    public CharSequence scheme() {
        return (CharSequence) get(Http2Headers.PseudoHeaderName.SCHEME.value());
    }

    public CharSequence status() {
        return (CharSequence) get(Http2Headers.PseudoHeaderName.STATUS.value());
    }
}
