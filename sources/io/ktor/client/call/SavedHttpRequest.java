package io.ktor.client.call;

import com.google.common.net.HttpHeaders;
import io.ktor.client.request.HttpRequest;
import io.ktor.http.Headers;
import io.ktor.http.HttpMethod;
import io.ktor.http.Url;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.Attributes;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u000b8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138VX\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00178\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lio/ktor/client/call/SavedHttpRequest;", "Lio/ktor/client/request/HttpRequest;", "Lio/ktor/client/call/SavedHttpCall;", "call", "origin", "<init>", "(Lio/ktor/client/call/SavedHttpCall;Lio/ktor/client/request/HttpRequest;)V", "a", "Lio/ktor/client/call/SavedHttpCall;", "c", "()Lio/ktor/client/call/SavedHttpCall;", "Lio/ktor/util/Attributes;", "J", "()Lio/ktor/util/Attributes;", "attributes", "Lio/ktor/http/content/OutgoingContent;", "getContent", "()Lio/ktor/http/content/OutgoingContent;", "content", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lio/ktor/http/Headers;", "()Lio/ktor/http/Headers;", "headers", "Lio/ktor/http/HttpMethod;", "getMethod", "()Lio/ktor/http/HttpMethod;", "method", "Lio/ktor/http/Url;", "T", "()Lio/ktor/http/Url;", "url", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
public final class SavedHttpRequest implements HttpRequest {

    /* renamed from: a  reason: collision with root package name */
    public final SavedHttpCall f8819a;
    public final /* synthetic */ HttpRequest b;

    public SavedHttpRequest(SavedHttpCall savedHttpCall, HttpRequest httpRequest) {
        Intrinsics.checkNotNullParameter(savedHttpCall, "call");
        Intrinsics.checkNotNullParameter(httpRequest, HttpHeaders.ReferrerPolicyValues.ORIGIN);
        this.f8819a = savedHttpCall;
        this.b = httpRequest;
    }

    public Attributes J() {
        return this.b.J();
    }

    public Url T() {
        return this.b.T();
    }

    public Headers a() {
        return this.b.a();
    }

    /* renamed from: c */
    public SavedHttpCall p0() {
        return this.f8819a;
    }

    public OutgoingContent getContent() {
        return this.b.getContent();
    }

    public CoroutineContext getCoroutineContext() {
        return this.b.getCoroutineContext();
    }

    public HttpMethod getMethod() {
        return this.b.getMethod();
    }
}
