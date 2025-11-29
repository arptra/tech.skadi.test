package io.ktor.client.plugins.cache.storage;

import io.ktor.http.Headers;
import io.ktor.http.HttpProtocolVersion;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.Url;
import io.ktor.util.date.GMTDate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001c\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ+\u0010\u001c\u001a\u00020\u00002\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u000b\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0017\u0010\b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b)\u0010&\u001a\u0004\b*\u0010(R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b'\u0010+\u001a\u0004\b,\u0010-R\u0017\u0010\u000b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b*\u0010&\u001a\u0004\b%\u0010(R\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b#\u0010.\u001a\u0004\b)\u0010/R#\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006¢\u0006\f\n\u0004\b\u001f\u00100\u001a\u0004\b1\u00102R\u0017\u0010\u0012\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b1\u00103\u001a\u0004\b!\u00104¨\u00065"}, d2 = {"Lio/ktor/client/plugins/cache/storage/CachedResponseData;", "", "Lio/ktor/http/Url;", "url", "Lio/ktor/http/HttpStatusCode;", "statusCode", "Lio/ktor/util/date/GMTDate;", "requestTime", "responseTime", "Lio/ktor/http/HttpProtocolVersion;", "version", "expires", "Lio/ktor/http/Headers;", "headers", "", "", "varyKeys", "", "body", "<init>", "(Lio/ktor/http/Url;Lio/ktor/http/HttpStatusCode;Lio/ktor/util/date/GMTDate;Lio/ktor/util/date/GMTDate;Lio/ktor/http/HttpProtocolVersion;Lio/ktor/util/date/GMTDate;Lio/ktor/http/Headers;Ljava/util/Map;[B)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "a", "(Ljava/util/Map;Lio/ktor/util/date/GMTDate;)Lio/ktor/client/plugins/cache/storage/CachedResponseData;", "Lio/ktor/http/Url;", "h", "()Lio/ktor/http/Url;", "b", "Lio/ktor/http/HttpStatusCode;", "g", "()Lio/ktor/http/HttpStatusCode;", "c", "Lio/ktor/util/date/GMTDate;", "e", "()Lio/ktor/util/date/GMTDate;", "d", "f", "Lio/ktor/http/HttpProtocolVersion;", "j", "()Lio/ktor/http/HttpProtocolVersion;", "Lio/ktor/http/Headers;", "()Lio/ktor/http/Headers;", "Ljava/util/Map;", "i", "()Ljava/util/Map;", "[B", "()[B", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
public final class CachedResponseData {

    /* renamed from: a  reason: collision with root package name */
    public final Url f8895a;
    public final HttpStatusCode b;
    public final GMTDate c;
    public final GMTDate d;
    public final HttpProtocolVersion e;
    public final GMTDate f;
    public final Headers g;
    public final Map h;
    public final byte[] i;

    public CachedResponseData(Url url, HttpStatusCode httpStatusCode, GMTDate gMTDate, GMTDate gMTDate2, HttpProtocolVersion httpProtocolVersion, GMTDate gMTDate3, Headers headers, Map map, byte[] bArr) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(httpStatusCode, "statusCode");
        Intrinsics.checkNotNullParameter(gMTDate, "requestTime");
        Intrinsics.checkNotNullParameter(gMTDate2, "responseTime");
        Intrinsics.checkNotNullParameter(httpProtocolVersion, "version");
        Intrinsics.checkNotNullParameter(gMTDate3, "expires");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(map, "varyKeys");
        Intrinsics.checkNotNullParameter(bArr, "body");
        this.f8895a = url;
        this.b = httpStatusCode;
        this.c = gMTDate;
        this.d = gMTDate2;
        this.e = httpProtocolVersion;
        this.f = gMTDate3;
        this.g = headers;
        this.h = map;
        this.i = bArr;
    }

    public final CachedResponseData a(Map map, GMTDate gMTDate) {
        Intrinsics.checkNotNullParameter(map, "varyKeys");
        Intrinsics.checkNotNullParameter(gMTDate, "expires");
        return new CachedResponseData(this.f8895a, this.b, this.c, this.d, this.e, gMTDate, this.g, map, this.i);
    }

    public final byte[] b() {
        return this.i;
    }

    public final GMTDate c() {
        return this.f;
    }

    public final Headers d() {
        return this.g;
    }

    public final GMTDate e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CachedResponseData)) {
            return false;
        }
        CachedResponseData cachedResponseData = (CachedResponseData) obj;
        return Intrinsics.areEqual((Object) this.f8895a, (Object) cachedResponseData.f8895a) && Intrinsics.areEqual((Object) this.h, (Object) cachedResponseData.h);
    }

    public final GMTDate f() {
        return this.d;
    }

    public final HttpStatusCode g() {
        return this.b;
    }

    public final Url h() {
        return this.f8895a;
    }

    public int hashCode() {
        return (this.f8895a.hashCode() * 31) + this.h.hashCode();
    }

    public final Map i() {
        return this.h;
    }

    public final HttpProtocolVersion j() {
        return this.e;
    }
}
