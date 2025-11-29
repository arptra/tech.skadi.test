package com.upuphone.xr.sapp.utils;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;

public class CountingRequestBody extends RequestBody {

    /* renamed from: a  reason: collision with root package name */
    public RequestBody f7861a;
    public Listener b;
    public CountingSink c;

    public final class CountingSink extends ForwardingSink {

        /* renamed from: a  reason: collision with root package name */
        public long f7862a;

        public CountingSink(Sink sink) {
            super(sink);
        }

        public void write(Buffer buffer, long j) {
            super.write(buffer, j);
            this.f7862a += j;
            CountingRequestBody.this.b.a(this.f7862a, CountingRequestBody.this.contentLength());
        }
    }

    public interface Listener {
        void a(long j, long j2);
    }

    public CountingRequestBody(RequestBody requestBody, Listener listener) {
        this.f7861a = requestBody;
        this.b = listener;
    }

    public long contentLength() {
        try {
            return this.f7861a.contentLength();
        } catch (IOException unused) {
            return -1;
        }
    }

    public MediaType contentType() {
        return this.f7861a.contentType();
    }

    public void writeTo(BufferedSink bufferedSink) {
        CountingSink countingSink = new CountingSink(bufferedSink);
        this.c = countingSink;
        BufferedSink buffer = Okio.buffer((Sink) countingSink);
        this.f7861a.writeTo(buffer);
        buffer.flush();
    }
}
