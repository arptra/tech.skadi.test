package io.ktor.client.plugins.cache;

import io.ktor.http.HeaderValue;
import io.netty.handler.codec.http.HttpHeaders;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\t\u001a\u00020\u00048\u0000X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\u00048\u0000X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0006\u001a\u0004\b\u0005\u0010\bR\u001a\u0010\r\u001a\u00020\u00048\u0000X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\bR\u001a\u0010\u000e\u001a\u00020\u00048\u0000X\u0004¢\u0006\f\n\u0004\b\f\u0010\u0006\u001a\u0004\b\u000b\u0010\bR\u001a\u0010\u0011\u001a\u00020\u00048\u0000X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u0010\u0010\b¨\u0006\u0012"}, d2 = {"Lio/ktor/client/plugins/cache/CacheControl;", "", "<init>", "()V", "Lio/ktor/http/HeaderValue;", "b", "Lio/ktor/http/HeaderValue;", "c", "()Lio/ktor/http/HeaderValue;", "NO_STORE", "NO_CACHE", "d", "e", "PRIVATE", "ONLY_IF_CACHED", "f", "a", "MUST_REVALIDATE", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
public final class CacheControl {

    /* renamed from: a  reason: collision with root package name */
    public static final CacheControl f8887a = new CacheControl();
    public static final HeaderValue b = new HeaderValue(HttpHeaders.Values.NO_STORE, (List) null, 2, (DefaultConstructorMarker) null);
    public static final HeaderValue c = new HeaderValue("no-cache", (List) null, 2, (DefaultConstructorMarker) null);
    public static final HeaderValue d = new HeaderValue("private", (List) null, 2, (DefaultConstructorMarker) null);
    public static final HeaderValue e = new HeaderValue("only-if-cached", (List) null, 2, (DefaultConstructorMarker) null);
    public static final HeaderValue f = new HeaderValue("must-revalidate", (List) null, 2, (DefaultConstructorMarker) null);

    public final HeaderValue a() {
        return f;
    }

    public final HeaderValue b() {
        return c;
    }

    public final HeaderValue c() {
        return b;
    }

    public final HeaderValue d() {
        return e;
    }

    public final HeaderValue e() {
        return d;
    }
}
