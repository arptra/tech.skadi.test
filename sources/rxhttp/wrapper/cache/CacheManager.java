package rxhttp.wrapper.cache;

import com.here.posclient.UpdateOptions;
import com.honey.account.constant.AccountConstantKt;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import okhttp3.CipherSuite;
import okhttp3.Handshake;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.TlsVersion;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.ForwardingSink;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import rxhttp.wrapper.OkHttpCompat;

public class CacheManager implements Closeable, Flushable {

    /* renamed from: a  reason: collision with root package name */
    public final DiskLruCache f3529a;

    /* renamed from: rxhttp.wrapper.cache.CacheManager$1  reason: invalid class name */
    public class AnonymousClass1 implements InternalCache {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CacheManager f3530a;

        public Response a(Response response, String str) {
            return this.f3530a.n(response, str);
        }

        public Response b(Request request, String str) {
            return this.f3530a.i(request, str);
        }
    }

    /* renamed from: rxhttp.wrapper.cache.CacheManager$3  reason: invalid class name */
    class AnonymousClass3 implements Iterator<String> {

        /* renamed from: a  reason: collision with root package name */
        public final Iterator f3532a;
        public String b;
        public boolean c;

        /* renamed from: a */
        public String next() {
            if (hasNext()) {
                String str = this.b;
                this.b = null;
                this.c = true;
                return str;
            }
            throw new NoSuchElementException();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x002d, code lost:
            r4 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x002e, code lost:
            if (r2 != null) goto L_0x0030;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            r2.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0038, code lost:
            throw r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
            continue;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean hasNext() {
            /*
                r5 = this;
                java.lang.String r0 = r5.b
                r1 = 1
                if (r0 == 0) goto L_0x0006
                return r1
            L_0x0006:
                r0 = 0
                r5.c = r0
            L_0x0009:
                java.util.Iterator r2 = r5.f3532a
                boolean r2 = r2.hasNext()
                if (r2 == 0) goto L_0x0039
                java.util.Iterator r2 = r5.f3532a     // Catch:{ IOException -> 0x0009 }
                java.lang.Object r2 = r2.next()     // Catch:{ IOException -> 0x0009 }
                okhttp3.internal.cache.DiskLruCache$Snapshot r2 = (okhttp3.internal.cache.DiskLruCache.Snapshot) r2     // Catch:{ IOException -> 0x0009 }
                okio.Source r3 = r2.getSource(r0)     // Catch:{ all -> 0x002b }
                okio.BufferedSource r3 = okio.Okio.buffer((okio.Source) r3)     // Catch:{ all -> 0x002b }
                java.lang.String r3 = r3.readUtf8LineStrict()     // Catch:{ all -> 0x002b }
                r5.b = r3     // Catch:{ all -> 0x002b }
                r2.close()     // Catch:{ IOException -> 0x0009 }
                return r1
            L_0x002b:
                r3 = move-exception
                throw r3     // Catch:{ all -> 0x002d }
            L_0x002d:
                r4 = move-exception
                if (r2 == 0) goto L_0x0038
                r2.close()     // Catch:{ all -> 0x0034 }
                goto L_0x0038
            L_0x0034:
                r2 = move-exception
                r3.addSuppressed(r2)     // Catch:{ IOException -> 0x0009 }
            L_0x0038:
                throw r4     // Catch:{ IOException -> 0x0009 }
            L_0x0039:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: rxhttp.wrapper.cache.CacheManager.AnonymousClass3.hasNext():boolean");
        }

        public void remove() {
            if (this.c) {
                this.f3532a.remove();
                return;
            }
            throw new IllegalStateException("remove() before next()");
        }
    }

    public final class CacheRequestImpl implements CacheRequest {

        /* renamed from: a  reason: collision with root package name */
        public final DiskLruCache.Editor f3533a;
        public final Sink b;
        public final Sink c;
        public boolean d;

        public CacheRequestImpl(final DiskLruCache.Editor editor) {
            this.f3533a = editor;
            Sink newSink = editor.newSink(1);
            this.b = newSink;
            this.c = new ForwardingSink(newSink, CacheManager.this) {
                public void close() {
                    synchronized (CacheManager.this) {
                        try {
                            CacheRequestImpl cacheRequestImpl = CacheRequestImpl.this;
                            if (!cacheRequestImpl.d) {
                                cacheRequestImpl.d = true;
                                super.close();
                                editor.commit();
                            }
                        } catch (Throwable th) {
                            while (true) {
                                throw th;
                            }
                        }
                    }
                }
            };
        }

        public void abort() {
            synchronized (CacheManager.this) {
                try {
                    if (!this.d) {
                        this.d = true;
                        Util.closeQuietly((Closeable) this.b);
                        try {
                            this.f3533a.abort();
                        } catch (IOException unused) {
                        }
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }

        public Sink body() {
            return this.c;
        }
    }

    public static class CacheResponseBody extends ResponseBody {

        /* renamed from: a  reason: collision with root package name */
        public final DiskLruCache.Snapshot f3535a;
        public final BufferedSource b;
        public final String c;
        public final String d;

        public CacheResponseBody(final DiskLruCache.Snapshot snapshot, String str, String str2) {
            this.f3535a = snapshot;
            this.c = str;
            this.d = str2;
            this.b = Okio.buffer((Source) new ForwardingSource(snapshot.getSource(1)) {
                public void close() {
                    snapshot.close();
                    super.close();
                }
            });
        }

        public long contentLength() {
            try {
                String str = this.d;
                if (str != null) {
                    return Long.parseLong(str);
                }
                return -1;
            } catch (NumberFormatException unused) {
                return -1;
            }
        }

        public MediaType contentType() {
            String str = this.c;
            if (str != null) {
                return MediaType.parse(str);
            }
            return null;
        }

        public BufferedSource source() {
            return this.b;
        }
    }

    public static String j(String str) {
        return ByteString.encodeUtf8(str).md5().hex();
    }

    public static int r(BufferedSource bufferedSource) {
        try {
            long readDecimalLong = bufferedSource.readDecimalLong();
            String readUtf8LineStrict = bufferedSource.readUtf8LineStrict();
            if (readDecimalLong >= 0 && readDecimalLong <= UpdateOptions.SOURCE_ANY && readUtf8LineStrict.isEmpty()) {
                return (int) readDecimalLong;
            }
            throw new IOException("expected an int but was \"" + readDecimalLong + readUtf8LineStrict + "\"");
        } catch (NumberFormatException e) {
            throw new IOException(e.getMessage());
        }
    }

    public final void a(DiskLruCache.Editor editor) {
        if (editor != null) {
            try {
                editor.abort();
            } catch (IOException unused) {
            }
        }
    }

    public void close() {
        this.f3529a.close();
    }

    public void flush() {
        this.f3529a.flush();
    }

    public final Response g(final CacheRequest cacheRequest, Response response) {
        if (cacheRequest == null) {
            return response;
        }
        Sink body = cacheRequest.body();
        ResponseBody body2 = response.body();
        if (body2 == null) {
            return response;
        }
        final BufferedSource source = body2.source();
        final BufferedSink buffer = Okio.buffer(body);
        AnonymousClass2 r2 = new Source() {

            /* renamed from: a  reason: collision with root package name */
            public boolean f3531a;

            public void close() {
                if (!this.f3531a && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    this.f3531a = true;
                    cacheRequest.abort();
                }
                source.close();
            }

            public long read(Buffer buffer, long j) {
                try {
                    long read = source.read(buffer, j);
                    if (read == -1) {
                        if (!this.f3531a) {
                            this.f3531a = true;
                            buffer.close();
                        }
                        return -1;
                    }
                    buffer.copyTo(buffer.buffer(), buffer.size() - read, read);
                    buffer.emitCompleteSegments();
                    return read;
                } catch (IOException e2) {
                    if (!this.f3531a) {
                        this.f3531a = true;
                        cacheRequest.abort();
                    }
                    throw e2;
                }
            }

            public Timeout timeout() {
                return source.timeout();
            }
        };
        return response.newBuilder().body(new RealResponseBody(response.header("Content-Type"), response.body().contentLength(), Okio.buffer((Source) r2))).build();
    }

    public final Response i(Request request, String str) {
        if (str == null) {
            str = request.url().toString();
        }
        try {
            DiskLruCache.Snapshot snapshot = this.f3529a.get(j(str));
            if (snapshot == null) {
                return null;
            }
            try {
                return new Entry(snapshot.getSource(0)).d(request, snapshot);
            } catch (IOException unused) {
                Util.closeQuietly((Closeable) snapshot);
                return null;
            }
        } catch (IOException unused2) {
            return null;
        }
    }

    public final Response n(Response response, String str) {
        return g(o(response, str), response);
    }

    public final CacheRequest o(Response response, String str) {
        DiskLruCache.Editor editor;
        Entry entry = new Entry(response);
        if (str == null) {
            try {
                str = response.request().url().toString();
            } catch (IOException unused) {
                editor = null;
                a(editor);
                return null;
            }
        }
        editor = this.f3529a.edit(j(str));
        if (editor == null) {
            return null;
        }
        try {
            entry.f(editor);
            return new CacheRequestImpl(editor);
        } catch (IOException unused2) {
            a(editor);
            return null;
        }
    }

    public static final class Entry {
        public static final String k = (Platform.get().getPrefix() + "-Sent-Millis");
        public static final String l = (Platform.get().getPrefix() + "-Received-Millis");

        /* renamed from: a  reason: collision with root package name */
        public final String f3537a;
        public final Headers b;
        public final String c;
        public final Protocol d;
        public final int e;
        public final String f;
        public final Headers g;
        public final Handshake h;
        public final long i;
        public final long j;

        public Entry(Source source) {
            try {
                BufferedSource buffer = Okio.buffer(source);
                this.f3537a = buffer.readUtf8LineStrict();
                this.c = buffer.readUtf8LineStrict();
                Headers.Builder builder = new Headers.Builder();
                int d2 = CacheManager.r(buffer);
                for (int i2 = 0; i2 < d2; i2++) {
                    a(builder, buffer.readUtf8LineStrict());
                }
                this.b = builder.build();
                StatusLine k2 = OkHttpCompat.k(buffer.readUtf8LineStrict());
                this.d = k2.protocol;
                this.e = k2.code;
                this.f = k2.message;
                Headers.Builder builder2 = new Headers.Builder();
                int d3 = CacheManager.r(buffer);
                for (int i3 = 0; i3 < d3; i3++) {
                    a(builder2, buffer.readUtf8LineStrict());
                }
                String str = k;
                String str2 = builder2.get(str);
                String str3 = l;
                String str4 = builder2.get(str3);
                builder2.removeAll(str);
                builder2.removeAll(str3);
                long j2 = 0;
                this.i = str2 != null ? Long.parseLong(str2) : 0;
                this.j = str4 != null ? Long.parseLong(str4) : j2;
                this.g = builder2.build();
                if (b()) {
                    String readUtf8LineStrict = buffer.readUtf8LineStrict();
                    if (readUtf8LineStrict.length() <= 0) {
                        this.h = Handshake.get(!buffer.exhausted() ? TlsVersion.forJavaName(buffer.readUtf8LineStrict()) : TlsVersion.SSL_3_0, CipherSuite.forJavaName(buffer.readUtf8LineStrict()), c(buffer), c(buffer));
                    } else {
                        throw new IOException("expected \"\" but was \"" + readUtf8LineStrict + "\"");
                    }
                } else {
                    this.h = null;
                }
            } finally {
                source.close();
            }
        }

        public void a(Headers.Builder builder, String str) {
            int indexOf = str.indexOf(AccountConstantKt.CODE_SEPARTOR, 1);
            if (indexOf != -1) {
                builder.addUnsafeNonAscii(str.substring(0, indexOf), str.substring(indexOf + 1));
            } else if (str.startsWith(AccountConstantKt.CODE_SEPARTOR)) {
                builder.addUnsafeNonAscii("", str.substring(1));
            } else {
                builder.addUnsafeNonAscii("", str);
            }
        }

        public final boolean b() {
            return this.f3537a.startsWith("https://");
        }

        public final List c(BufferedSource bufferedSource) {
            int d2 = CacheManager.r(bufferedSource);
            if (d2 == -1) {
                return Collections.emptyList();
            }
            try {
                CertificateFactory instance = CertificateFactory.getInstance("X.509");
                ArrayList arrayList = new ArrayList(d2);
                for (int i2 = 0; i2 < d2; i2++) {
                    String readUtf8LineStrict = bufferedSource.readUtf8LineStrict();
                    Buffer buffer = new Buffer();
                    buffer.write(ByteString.decodeBase64(readUtf8LineStrict));
                    arrayList.add(instance.generateCertificate(buffer.inputStream()));
                }
                return arrayList;
            } catch (CertificateException e2) {
                throw new IOException(e2.getMessage());
            }
        }

        public Response d(Request request, DiskLruCache.Snapshot snapshot) {
            return new Response.Builder().request(request).protocol(this.d).code(this.e).message(this.f).headers(this.g).body(new CacheResponseBody(snapshot, this.g.get("Content-Type"), this.g.get("Content-Length"))).handshake(this.h).sentRequestAtMillis(this.i).receivedResponseAtMillis(this.j).build();
        }

        public final void e(BufferedSink bufferedSink, List list) {
            try {
                bufferedSink.writeDecimalLong((long) list.size()).writeByte(10);
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    bufferedSink.writeUtf8(ByteString.of(((Certificate) list.get(i2)).getEncoded()).base64()).writeByte(10);
                }
            } catch (CertificateEncodingException e2) {
                throw new IOException(e2.getMessage());
            }
        }

        public void f(DiskLruCache.Editor editor) {
            BufferedSink buffer = Okio.buffer(editor.newSink(0));
            buffer.writeUtf8(this.f3537a).writeByte(10);
            buffer.writeUtf8(this.c).writeByte(10);
            buffer.writeDecimalLong((long) this.b.size()).writeByte(10);
            int size = this.b.size();
            for (int i2 = 0; i2 < size; i2++) {
                buffer.writeUtf8(this.b.name(i2)).writeUtf8(": ").writeUtf8(this.b.value(i2)).writeByte(10);
            }
            buffer.writeUtf8(new StatusLine(this.d, this.e, this.f).toString()).writeByte(10);
            buffer.writeDecimalLong((long) (this.g.size() + 2)).writeByte(10);
            int size2 = this.g.size();
            for (int i3 = 0; i3 < size2; i3++) {
                buffer.writeUtf8(this.g.name(i3)).writeUtf8(": ").writeUtf8(this.g.value(i3)).writeByte(10);
            }
            buffer.writeUtf8(k).writeUtf8(": ").writeDecimalLong(this.i).writeByte(10);
            buffer.writeUtf8(l).writeUtf8(": ").writeDecimalLong(this.j).writeByte(10);
            if (b()) {
                buffer.writeByte(10);
                buffer.writeUtf8(this.h.cipherSuite().javaName()).writeByte(10);
                e(buffer, this.h.peerCertificates());
                e(buffer, this.h.localCertificates());
                buffer.writeUtf8(this.h.tlsVersion().javaName()).writeByte(10);
            }
            buffer.close();
        }

        public Entry(Response response) {
            this.f3537a = response.request().url().toString();
            this.b = HeadersVary.c(response);
            this.c = response.request().method();
            this.d = response.protocol();
            this.e = response.code();
            this.f = response.message();
            this.g = response.headers();
            this.h = response.handshake();
            this.i = response.sentRequestAtMillis();
            this.j = response.receivedResponseAtMillis();
        }
    }
}
