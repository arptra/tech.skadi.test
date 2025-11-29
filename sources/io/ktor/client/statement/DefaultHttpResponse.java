package io.ktor.client.statement;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpResponseData;
import io.ktor.http.Headers;
import io.ktor.http.HttpProtocolVersion;
import io.ktor.http.HttpStatusCode;
import io.ktor.util.InternalAPI;
import io.ktor.util.date.GMTDate;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0011\u001a\u00020\f8\u0016X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0017\u001a\u00020\u00128\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001d\u001a\u00020\u00188\u0016X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\"\u001a\u00020\u001e8\u0016X\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u0019\u0010!R\u001a\u0010#\u001a\u00020\u001e8\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010 \u001a\u0004\b\u001f\u0010!R\u001a\u0010'\u001a\u00020$8\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010%\u001a\u0004\b\u0013\u0010&R\u001a\u0010,\u001a\u00020(8\u0016X\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b\b\u0010+¨\u0006-"}, d2 = {"Lio/ktor/client/statement/DefaultHttpResponse;", "Lio/ktor/client/statement/HttpResponse;", "Lio/ktor/client/call/HttpClientCall;", "call", "Lio/ktor/client/request/HttpResponseData;", "responseData", "<init>", "(Lio/ktor/client/call/HttpClientCall;Lio/ktor/client/request/HttpResponseData;)V", "a", "Lio/ktor/client/call/HttpClientCall;", "p0", "()Lio/ktor/client/call/HttpClientCall;", "Lkotlin/coroutines/CoroutineContext;", "b", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lio/ktor/http/HttpStatusCode;", "c", "Lio/ktor/http/HttpStatusCode;", "f", "()Lio/ktor/http/HttpStatusCode;", "status", "Lio/ktor/http/HttpProtocolVersion;", "d", "Lio/ktor/http/HttpProtocolVersion;", "g", "()Lio/ktor/http/HttpProtocolVersion;", "version", "Lio/ktor/util/date/GMTDate;", "e", "Lio/ktor/util/date/GMTDate;", "()Lio/ktor/util/date/GMTDate;", "requestTime", "responseTime", "Lio/ktor/utils/io/ByteReadChannel;", "Lio/ktor/utils/io/ByteReadChannel;", "()Lio/ktor/utils/io/ByteReadChannel;", "content", "Lio/ktor/http/Headers;", "h", "Lio/ktor/http/Headers;", "()Lio/ktor/http/Headers;", "headers", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
@InternalAPI
public final class DefaultHttpResponse extends HttpResponse {

    /* renamed from: a  reason: collision with root package name */
    public final HttpClientCall f8925a;
    public final CoroutineContext b;
    public final HttpStatusCode c;
    public final HttpProtocolVersion d;
    public final GMTDate e;
    public final GMTDate f;
    public final ByteReadChannel g;
    public final Headers h;

    public DefaultHttpResponse(HttpClientCall httpClientCall, HttpResponseData httpResponseData) {
        Intrinsics.checkNotNullParameter(httpClientCall, "call");
        Intrinsics.checkNotNullParameter(httpResponseData, "responseData");
        this.f8925a = httpClientCall;
        this.b = httpResponseData.b();
        this.c = httpResponseData.f();
        this.d = httpResponseData.g();
        this.e = httpResponseData.d();
        this.f = httpResponseData.e();
        Object a2 = httpResponseData.a();
        ByteReadChannel byteReadChannel = a2 instanceof ByteReadChannel ? (ByteReadChannel) a2 : null;
        this.g = byteReadChannel == null ? ByteReadChannel.f9077a.a() : byteReadChannel;
        this.h = httpResponseData.c();
    }

    public Headers a() {
        return this.h;
    }

    public ByteReadChannel c() {
        return this.g;
    }

    public GMTDate d() {
        return this.e;
    }

    public GMTDate e() {
        return this.f;
    }

    public HttpStatusCode f() {
        return this.c;
    }

    public HttpProtocolVersion g() {
        return this.d;
    }

    public CoroutineContext getCoroutineContext() {
        return this.b;
    }

    public HttpClientCall p0() {
        return this.f8925a;
    }
}
