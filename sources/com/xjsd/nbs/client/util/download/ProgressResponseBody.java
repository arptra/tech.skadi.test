package com.xjsd.nbs.client.util.download;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

public class ProgressResponseBody extends ResponseBody {

    /* renamed from: a  reason: collision with root package name */
    public final ResponseBody f8711a;
    public BufferedSource b;

    public final Source a(Source source) {
        return new ForwardingSource(source) {

            /* renamed from: a  reason: collision with root package name */
            public long f8712a = 0;

            public long read(Buffer buffer, long j) {
                long read = super.read(buffer, j);
                this.f8712a += read != -1 ? read : 0;
                return read;
            }
        };
    }

    public long contentLength() {
        return this.f8711a.contentLength();
    }

    public MediaType contentType() {
        return this.f8711a.contentType();
    }

    public BufferedSource source() {
        if (this.b == null) {
            this.b = Okio.buffer(a(this.f8711a.source()));
        }
        return this.b;
    }
}
