package rxhttp.wrapper.progress;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;
import rxhttp.wrapper.callback.ProgressCallbackHelper;

public class ProgressRequestBody extends RequestBody {

    /* renamed from: a  reason: collision with root package name */
    public final RequestBody f3566a;
    public final ProgressCallbackHelper b;

    public ProgressRequestBody(RequestBody requestBody, ProgressCallbackHelper progressCallbackHelper) {
        this.f3566a = requestBody;
        this.b = progressCallbackHelper;
    }

    public RequestBody b() {
        return this.f3566a;
    }

    public final Sink c(Sink sink) {
        this.b.b(0);
        return new ForwardingSink(sink) {

            /* renamed from: a  reason: collision with root package name */
            public long f3567a = Long.MIN_VALUE;

            public void write(Buffer buffer, long j) {
                super.write(buffer, j);
                if (this.f3567a == Long.MIN_VALUE) {
                    this.f3567a = ProgressRequestBody.this.contentLength();
                }
                ProgressRequestBody.this.b.a(j, this.f3567a);
            }
        };
    }

    public long contentLength() {
        return this.f3566a.contentLength();
    }

    public MediaType contentType() {
        return this.f3566a.contentType();
    }

    public void writeTo(BufferedSink bufferedSink) {
        if ((bufferedSink instanceof Buffer) || bufferedSink.toString().contains("com.android.tools.profiler.support.network.HttpTracker$OutputStreamTracker")) {
            this.f3566a.writeTo(bufferedSink);
            return;
        }
        BufferedSink buffer = Okio.buffer(c(bufferedSink));
        this.f3566a.writeTo(buffer);
        buffer.close();
    }
}
