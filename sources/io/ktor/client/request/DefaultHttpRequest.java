package io.ktor.client.request;

import io.ktor.client.call.HttpClientCall;
import io.ktor.http.Headers;
import io.ktor.http.HttpMethod;
import io.ktor.http.Url;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.Attributes;
import io.ktor.util.InternalAPI;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0011\u001a\u00020\f8\u0016X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0017\u001a\u00020\u00128\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001d\u001a\u00020\u00188\u0016X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\"\u001a\u00020\u001e8\u0016X\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\b\u0010!R\u001a\u0010(\u001a\u00020#8\u0016X\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8VX\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u0006-"}, d2 = {"Lio/ktor/client/request/DefaultHttpRequest;", "Lio/ktor/client/request/HttpRequest;", "Lio/ktor/client/call/HttpClientCall;", "call", "Lio/ktor/client/request/HttpRequestData;", "data", "<init>", "(Lio/ktor/client/call/HttpClientCall;Lio/ktor/client/request/HttpRequestData;)V", "a", "Lio/ktor/client/call/HttpClientCall;", "p0", "()Lio/ktor/client/call/HttpClientCall;", "Lio/ktor/http/HttpMethod;", "b", "Lio/ktor/http/HttpMethod;", "getMethod", "()Lio/ktor/http/HttpMethod;", "method", "Lio/ktor/http/Url;", "c", "Lio/ktor/http/Url;", "T", "()Lio/ktor/http/Url;", "url", "Lio/ktor/http/content/OutgoingContent;", "d", "Lio/ktor/http/content/OutgoingContent;", "getContent", "()Lio/ktor/http/content/OutgoingContent;", "content", "Lio/ktor/http/Headers;", "e", "Lio/ktor/http/Headers;", "()Lio/ktor/http/Headers;", "headers", "Lio/ktor/util/Attributes;", "f", "Lio/ktor/util/Attributes;", "J", "()Lio/ktor/util/Attributes;", "attributes", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
@InternalAPI
public class DefaultHttpRequest implements HttpRequest {

    /* renamed from: a  reason: collision with root package name */
    public final HttpClientCall f8915a;
    public final HttpMethod b;
    public final Url c;
    public final OutgoingContent d;
    public final Headers e;
    public final Attributes f;

    public DefaultHttpRequest(HttpClientCall httpClientCall, HttpRequestData httpRequestData) {
        Intrinsics.checkNotNullParameter(httpClientCall, "call");
        Intrinsics.checkNotNullParameter(httpRequestData, "data");
        this.f8915a = httpClientCall;
        this.b = httpRequestData.f();
        this.c = httpRequestData.h();
        this.d = httpRequestData.b();
        this.e = httpRequestData.e();
        this.f = httpRequestData.a();
    }

    public Attributes J() {
        return this.f;
    }

    public Url T() {
        return this.c;
    }

    public Headers a() {
        return this.e;
    }

    public OutgoingContent getContent() {
        return this.d;
    }

    public CoroutineContext getCoroutineContext() {
        return p0().getCoroutineContext();
    }

    public HttpMethod getMethod() {
        return this.b;
    }

    public HttpClientCall p0() {
        return this.f8915a;
    }
}
