package rxhttp.wrapper.entity;

import android.content.ContentResolver;
import android.net.Uri;
import java.io.InputStream;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;
import rxhttp.wrapper.OkHttpCompat;
import rxhttp.wrapper.utils.UriUtil;

public class UriRequestBody extends RequestBody {

    /* renamed from: a  reason: collision with root package name */
    public final Uri f3558a;
    public final long b;
    public final MediaType c;
    public final ContentResolver d;

    public long contentLength() {
        long a2 = UriUtil.a(this.f3558a, this.d);
        long j = this.b;
        if (j <= 0 || j <= a2) {
            return a2 - j;
        }
        throw new IllegalArgumentException("skipSize cannot be larger than the file length. The file length is " + a2 + ", but it was " + this.b);
    }

    public MediaType contentType() {
        return this.c;
    }

    public void writeTo(BufferedSink bufferedSink) {
        InputStream inputStream;
        try {
            inputStream = this.d.openInputStream(this.f3558a);
            try {
                long j = this.b;
                if (j > 0) {
                    long skip = inputStream.skip(j);
                    if (skip != this.b) {
                        throw new IllegalArgumentException("Expected to skip " + this.b + " bytes, actually skipped " + skip + " bytes");
                    }
                }
                Source source = Okio.source(inputStream);
                bufferedSink.writeAll(source);
                OkHttpCompat.b(source, inputStream);
            } catch (Throwable th) {
                th = th;
                OkHttpCompat.b(null, inputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
            OkHttpCompat.b(null, inputStream);
            throw th;
        }
    }
}
