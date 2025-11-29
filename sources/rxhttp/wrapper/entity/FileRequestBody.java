package rxhttp.wrapper.entity;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;
import rxhttp.wrapper.OkHttpCompat;

public class FileRequestBody extends RequestBody {

    /* renamed from: a  reason: collision with root package name */
    public final File f3553a;
    public final long b;
    public final MediaType c;

    public long contentLength() {
        return this.f3553a.length() - this.b;
    }

    public MediaType contentType() {
        return this.c;
    }

    public void writeTo(BufferedSink bufferedSink) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(this.f3553a);
            try {
                long j = this.b;
                if (j > 0) {
                    long skip = fileInputStream.skip(j);
                    if (skip != this.b) {
                        throw new IllegalArgumentException("Expected to skip " + this.b + " bytes, actually skipped " + skip + " bytes");
                    }
                }
                Source source = Okio.source((InputStream) fileInputStream);
                bufferedSink.writeAll(source);
                OkHttpCompat.b(source, fileInputStream);
            } catch (Throwable th) {
                th = th;
                OkHttpCompat.b(null, fileInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            OkHttpCompat.b(null, fileInputStream);
            throw th;
        }
    }
}
