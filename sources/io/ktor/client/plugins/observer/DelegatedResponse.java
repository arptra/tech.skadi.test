package io.ktor.client.plugins.observer;

import com.google.common.net.HttpHeaders;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.statement.HttpResponse;
import io.ktor.http.Headers;
import io.ktor.http.HttpProtocolVersion;
import io.ktor.http.HttpStatusCode;
import io.ktor.util.InternalAPI;
import io.ktor.util.date.GMTDate;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0006\u001a\u00020\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0011R\u001a\u0010\u0017\u001a\u00020\u00128\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\"\u001a\u00020 8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010!R\u0014\u0010$\u001a\u00020 8VX\u0004¢\u0006\u0006\u001a\u0004\b#\u0010!R\u0014\u0010'\u001a\u00020%8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010&¨\u0006("}, d2 = {"Lio/ktor/client/plugins/observer/DelegatedResponse;", "Lio/ktor/client/statement/HttpResponse;", "Lio/ktor/client/call/HttpClientCall;", "call", "Lio/ktor/utils/io/ByteReadChannel;", "content", "origin", "<init>", "(Lio/ktor/client/call/HttpClientCall;Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/client/statement/HttpResponse;)V", "a", "Lio/ktor/client/call/HttpClientCall;", "p0", "()Lio/ktor/client/call/HttpClientCall;", "b", "Lio/ktor/utils/io/ByteReadChannel;", "c", "()Lio/ktor/utils/io/ByteReadChannel;", "Lio/ktor/client/statement/HttpResponse;", "Lkotlin/coroutines/CoroutineContext;", "d", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lio/ktor/http/HttpStatusCode;", "f", "()Lio/ktor/http/HttpStatusCode;", "status", "Lio/ktor/http/HttpProtocolVersion;", "g", "()Lio/ktor/http/HttpProtocolVersion;", "version", "Lio/ktor/util/date/GMTDate;", "()Lio/ktor/util/date/GMTDate;", "requestTime", "e", "responseTime", "Lio/ktor/http/Headers;", "()Lio/ktor/http/Headers;", "headers", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
@InternalAPI
public final class DelegatedResponse extends HttpResponse {

    /* renamed from: a  reason: collision with root package name */
    public final HttpClientCall f8904a;
    public final ByteReadChannel b;
    public final HttpResponse c;
    public final CoroutineContext d;

    public DelegatedResponse(HttpClientCall httpClientCall, ByteReadChannel byteReadChannel, HttpResponse httpResponse) {
        Intrinsics.checkNotNullParameter(httpClientCall, "call");
        Intrinsics.checkNotNullParameter(byteReadChannel, "content");
        Intrinsics.checkNotNullParameter(httpResponse, HttpHeaders.ReferrerPolicyValues.ORIGIN);
        this.f8904a = httpClientCall;
        this.b = byteReadChannel;
        this.c = httpResponse;
        this.d = httpResponse.getCoroutineContext();
    }

    public Headers a() {
        return this.c.a();
    }

    public ByteReadChannel c() {
        return this.b;
    }

    public GMTDate d() {
        return this.c.d();
    }

    public GMTDate e() {
        return this.c.e();
    }

    public HttpStatusCode f() {
        return this.c.f();
    }

    public HttpProtocolVersion g() {
        return this.c.g();
    }

    public CoroutineContext getCoroutineContext() {
        return this.d;
    }

    public HttpClientCall p0() {
        return this.f8904a;
    }
}
