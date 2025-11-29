package com.xingin.xhssharesdk.f;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.GzipSink;
import okio.Okio;
import okio.Sink;

public final class a extends RequestBody {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RequestBody f8176a;

    public a(RequestBody requestBody) {
        this.f8176a = requestBody;
    }

    public final long contentLength() {
        return -1;
    }

    public final MediaType contentType() {
        return this.f8176a.contentType();
    }

    public final void writeTo(BufferedSink bufferedSink) {
        BufferedSink buffer = Okio.buffer((Sink) new GzipSink(bufferedSink));
        this.f8176a.writeTo(buffer);
        buffer.close();
    }
}
