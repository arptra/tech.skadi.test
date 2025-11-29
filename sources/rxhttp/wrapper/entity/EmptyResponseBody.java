package rxhttp.wrapper.entity;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.BufferedSource;

public final class EmptyResponseBody extends ResponseBody {

    /* renamed from: a  reason: collision with root package name */
    public final MediaType f3551a;
    public final long b;

    public EmptyResponseBody(MediaType mediaType, long j) {
        this.f3551a = mediaType;
        this.b = j;
    }

    public long contentLength() {
        return this.b;
    }

    public MediaType contentType() {
        return this.f3551a;
    }

    public BufferedSource source() {
        throw new IllegalStateException("Cannot read raw response body of a converted body.");
    }
}
