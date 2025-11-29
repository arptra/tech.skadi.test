package io.ktor.client.plugins.cache;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.request.HttpRequestData;
import io.ktor.http.Headers;
import io.ktor.http.HttpMethod;
import io.ktor.http.Url;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.Attributes;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u000b\u001a\u00020\u00068\u0016X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0011\u001a\u00020\f8\u0016X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0017\u001a\u00020\u00128\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001d\u001a\u00020\u00188\u0016X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\"\u001a\u00020\u001e8\u0016X\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u0007\u0010!R\u0014\u0010&\u001a\u00020#8VX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u0006'"}, d2 = {"Lio/ktor/client/plugins/cache/RequestForCache;", "Lio/ktor/client/request/HttpRequest;", "Lio/ktor/client/request/HttpRequestData;", "data", "<init>", "(Lio/ktor/client/request/HttpRequestData;)V", "Lio/ktor/http/HttpMethod;", "a", "Lio/ktor/http/HttpMethod;", "getMethod", "()Lio/ktor/http/HttpMethod;", "method", "Lio/ktor/http/Url;", "b", "Lio/ktor/http/Url;", "T", "()Lio/ktor/http/Url;", "url", "Lio/ktor/util/Attributes;", "c", "Lio/ktor/util/Attributes;", "J", "()Lio/ktor/util/Attributes;", "attributes", "Lio/ktor/http/content/OutgoingContent;", "d", "Lio/ktor/http/content/OutgoingContent;", "getContent", "()Lio/ktor/http/content/OutgoingContent;", "content", "Lio/ktor/http/Headers;", "e", "Lio/ktor/http/Headers;", "()Lio/ktor/http/Headers;", "headers", "Lio/ktor/client/call/HttpClientCall;", "p0", "()Lio/ktor/client/call/HttpClientCall;", "call", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
final class RequestForCache implements HttpRequest {

    /* renamed from: a  reason: collision with root package name */
    public final HttpMethod f8892a;
    public final Url b;
    public final Attributes c;
    public final OutgoingContent d;
    public final Headers e;

    public RequestForCache(HttpRequestData httpRequestData) {
        Intrinsics.checkNotNullParameter(httpRequestData, "data");
        this.f8892a = httpRequestData.f();
        this.b = httpRequestData.h();
        this.c = httpRequestData.a();
        this.d = httpRequestData.b();
        this.e = httpRequestData.e();
    }

    public Attributes J() {
        return this.c;
    }

    public Url T() {
        return this.b;
    }

    public Headers a() {
        return this.e;
    }

    public OutgoingContent getContent() {
        return this.d;
    }

    public CoroutineContext getCoroutineContext() {
        return HttpRequest.DefaultImpls.a(this);
    }

    public HttpMethod getMethod() {
        return this.f8892a;
    }

    public HttpClientCall p0() {
        throw new IllegalStateException("This request has no call");
    }
}
