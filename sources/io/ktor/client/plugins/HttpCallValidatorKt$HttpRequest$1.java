package io.ktor.client.plugins;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.Headers;
import io.ktor.http.HttpMethod;
import io.ktor.http.Url;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.Attributes;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

@Metadata(d1 = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u001a\u0010\u0007\u001a\u00020\u00028\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\r\u001a\u00020\b8\u0016X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0013\u001a\u00020\u000e8\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0018\u001a\u00020\u00148\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0003\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198VX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"io/ktor/client/plugins/HttpCallValidatorKt$HttpRequest$1", "Lio/ktor/client/request/HttpRequest;", "Lio/ktor/http/HttpMethod;", "a", "Lio/ktor/http/HttpMethod;", "getMethod", "()Lio/ktor/http/HttpMethod;", "method", "Lio/ktor/http/Url;", "b", "Lio/ktor/http/Url;", "T", "()Lio/ktor/http/Url;", "url", "Lio/ktor/util/Attributes;", "c", "Lio/ktor/util/Attributes;", "J", "()Lio/ktor/util/Attributes;", "attributes", "Lio/ktor/http/Headers;", "d", "Lio/ktor/http/Headers;", "()Lio/ktor/http/Headers;", "headers", "Lio/ktor/client/call/HttpClientCall;", "p0", "()Lio/ktor/client/call/HttpClientCall;", "call", "Lio/ktor/http/content/OutgoingContent;", "getContent", "()Lio/ktor/http/content/OutgoingContent;", "content", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
public final class HttpCallValidatorKt$HttpRequest$1 implements HttpRequest {

    /* renamed from: a  reason: collision with root package name */
    public final HttpMethod f8846a;
    public final Url b;
    public final Attributes c;
    public final Headers d;
    public final /* synthetic */ HttpRequestBuilder e;

    public HttpCallValidatorKt$HttpRequest$1(HttpRequestBuilder httpRequestBuilder) {
        this.e = httpRequestBuilder;
        this.f8846a = httpRequestBuilder.h();
        this.b = httpRequestBuilder.i().b();
        this.c = httpRequestBuilder.c();
        this.d = httpRequestBuilder.a().n();
    }

    public Attributes J() {
        return this.c;
    }

    public Url T() {
        return this.b;
    }

    public Headers a() {
        return this.d;
    }

    public OutgoingContent getContent() {
        Object d2 = this.e.d();
        OutgoingContent outgoingContent = d2 instanceof OutgoingContent ? (OutgoingContent) d2 : null;
        if (outgoingContent != null) {
            return outgoingContent;
        }
        throw new IllegalStateException(("Content was not transformed to OutgoingContent yet. Current body is " + this.e.d()).toString());
    }

    public CoroutineContext getCoroutineContext() {
        return HttpRequest.DefaultImpls.a(this);
    }

    public HttpMethod getMethod() {
        return this.f8846a;
    }

    public HttpClientCall p0() {
        throw new IllegalStateException("Call is not initialized".toString());
    }
}
