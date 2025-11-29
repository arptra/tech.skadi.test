package io.ktor.client.plugins.cache.storage;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.statement.HttpResponse;
import io.ktor.http.Headers;
import io.ktor.http.HttpProtocolVersion;
import io.ktor.http.HttpStatusCode;
import io.ktor.util.date.GMTDate;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

@Metadata(d1 = {"\u0000A\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u001a\u0010\u0007\u001a\u00020\u00028\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\r\u001a\u00020\b8\u0016X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0013\u001a\u00020\u000e8\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0015\u001a\u00020\u000e8\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\u00168\u0016X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0017\u001a\u0004\b\u0003\u0010\u0018R\u001a\u0010\u001e\u001a\u00020\u001a8\u0016X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8VX\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u001a\u0010'\u001a\u00020#8VX\u0004¢\u0006\f\u0012\u0004\b%\u0010&\u001a\u0004\b\u000f\u0010$¨\u0006("}, d2 = {"io/ktor/client/plugins/cache/storage/HttpCacheStorageKt$createResponse$response$1", "Lio/ktor/client/statement/HttpResponse;", "Lio/ktor/http/HttpStatusCode;", "a", "Lio/ktor/http/HttpStatusCode;", "f", "()Lio/ktor/http/HttpStatusCode;", "status", "Lio/ktor/http/HttpProtocolVersion;", "b", "Lio/ktor/http/HttpProtocolVersion;", "g", "()Lio/ktor/http/HttpProtocolVersion;", "version", "Lio/ktor/util/date/GMTDate;", "c", "Lio/ktor/util/date/GMTDate;", "d", "()Lio/ktor/util/date/GMTDate;", "requestTime", "e", "responseTime", "Lio/ktor/http/Headers;", "Lio/ktor/http/Headers;", "()Lio/ktor/http/Headers;", "headers", "Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lio/ktor/client/call/HttpClientCall;", "p0", "()Lio/ktor/client/call/HttpClientCall;", "call", "Lio/ktor/utils/io/ByteReadChannel;", "()Lio/ktor/utils/io/ByteReadChannel;", "getContent$annotations", "()V", "content", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
public final class HttpCacheStorageKt$createResponse$response$1 extends HttpResponse {

    /* renamed from: a  reason: collision with root package name */
    public final HttpStatusCode f8897a;
    public final HttpProtocolVersion b;
    public final GMTDate c;
    public final GMTDate d;
    public final Headers e;
    public final CoroutineContext f;

    public HttpCacheStorageKt$createResponse$response$1(CachedResponseData cachedResponseData, CoroutineContext coroutineContext) {
        this.f8897a = cachedResponseData.g();
        this.b = cachedResponseData.j();
        this.c = cachedResponseData.e();
        this.d = cachedResponseData.f();
        this.e = cachedResponseData.d();
        this.f = coroutineContext;
    }

    public Headers a() {
        return this.e;
    }

    public ByteReadChannel c() {
        throw new IllegalStateException("This is a fake response");
    }

    public GMTDate d() {
        return this.c;
    }

    public GMTDate e() {
        return this.d;
    }

    public HttpStatusCode f() {
        return this.f8897a;
    }

    public HttpProtocolVersion g() {
        return this.b;
    }

    public CoroutineContext getCoroutineContext() {
        return this.f;
    }

    public HttpClientCall p0() {
        throw new IllegalStateException("This is a fake response");
    }
}
