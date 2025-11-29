package io.ktor.client.plugins.cache;

import io.ktor.client.call.SavedHttpCall;
import io.ktor.client.statement.HttpResponse;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.util.date.GMTDate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B5\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R#\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001d\u0010\u000eR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u0016\u0010!R\u001a\u0010%\u001a\u00020\"8\u0000X\u0004¢\u0006\f\n\u0004\b\u001b\u0010#\u001a\u0004\b\u001f\u0010$¨\u0006&"}, d2 = {"Lio/ktor/client/plugins/cache/HttpCacheEntry;", "", "Lio/ktor/util/date/GMTDate;", "expires", "", "", "varyKeys", "Lio/ktor/client/statement/HttpResponse;", "response", "", "body", "<init>", "(Lio/ktor/util/date/GMTDate;Ljava/util/Map;Lio/ktor/client/statement/HttpResponse;[B)V", "f", "()Lio/ktor/client/statement/HttpResponse;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "a", "Lio/ktor/util/date/GMTDate;", "b", "()Lio/ktor/util/date/GMTDate;", "Ljava/util/Map;", "e", "()Ljava/util/Map;", "c", "Lio/ktor/client/statement/HttpResponse;", "d", "[B", "()[B", "Lio/ktor/http/Headers;", "Lio/ktor/http/Headers;", "()Lio/ktor/http/Headers;", "responseHeaders", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nHttpCacheEntry.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HttpCacheEntry.kt\nio/ktor/client/plugins/cache/HttpCacheEntry\n+ 2 Headers.kt\nio/ktor/http/Headers$Companion\n*L\n1#1,143:1\n24#2:144\n*S KotlinDebug\n*F\n+ 1 HttpCacheEntry.kt\nio/ktor/client/plugins/cache/HttpCacheEntry\n*L\n32#1:144\n*E\n"})
public final class HttpCacheEntry {

    /* renamed from: a  reason: collision with root package name */
    public final GMTDate f8890a;
    public final Map b;
    public final HttpResponse c;
    public final byte[] d;
    public final Headers e;

    public HttpCacheEntry(GMTDate gMTDate, Map map, HttpResponse httpResponse, byte[] bArr) {
        Intrinsics.checkNotNullParameter(gMTDate, "expires");
        Intrinsics.checkNotNullParameter(map, "varyKeys");
        Intrinsics.checkNotNullParameter(httpResponse, "response");
        Intrinsics.checkNotNullParameter(bArr, "body");
        this.f8890a = gMTDate;
        this.b = map;
        this.c = httpResponse;
        this.d = bArr;
        Headers.Companion companion = Headers.f8962a;
        HeadersBuilder headersBuilder = new HeadersBuilder(0, 1, (DefaultConstructorMarker) null);
        headersBuilder.d(httpResponse.a());
        this.e = headersBuilder.n();
    }

    public final byte[] a() {
        return this.d;
    }

    public final GMTDate b() {
        return this.f8890a;
    }

    public final HttpResponse c() {
        return this.c;
    }

    public final Headers d() {
        return this.e;
    }

    public final Map e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof HttpCacheEntry)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return Intrinsics.areEqual((Object) this.b, (Object) ((HttpCacheEntry) obj).b);
    }

    public final HttpResponse f() {
        return new SavedHttpCall(this.c.p0().e(), this.c.p0().f(), this.c, this.d).g();
    }

    public int hashCode() {
        return this.b.hashCode();
    }
}
