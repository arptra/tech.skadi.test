package io.ktor.client;

import io.ktor.client.engine.HttpClientEngine;
import io.ktor.client.plugins.HttpClientPluginKt;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.client.request.HttpSendPipeline;
import io.ktor.client.statement.HttpReceivePipeline;
import io.ktor.client.statement.HttpResponsePipeline;
import io.ktor.events.Events;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import java.io.Closeable;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003J\u001b\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001a\u0010 \u001a\u00020\u001c8\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010&\u001a\u00020!8\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010,\u001a\u00020'8\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0017\u00102\u001a\u00020-8\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0017\u00108\u001a\u0002038\u0006¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u0017\u0010>\u001a\u0002098\u0006¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u0017\u0010B\u001a\u00020?8\u0006¢\u0006\f\n\u0004\b6\u0010@\u001a\u0004\b.\u0010AR \u0010H\u001a\b\u0012\u0004\u0012\u00020D0C8\u0000X\u0004¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\b\u0019\u0010G\u0002\u0004\n\u0002\b\u0019¨\u0006I"}, d2 = {"Lio/ktor/client/HttpClient;", "Lkotlinx/coroutines/CoroutineScope;", "Ljava/io/Closeable;", "Lio/ktor/utils/io/core/Closeable;", "Lio/ktor/client/request/HttpRequestBuilder;", "builder", "Lio/ktor/client/call/HttpClientCall;", "a", "(Lio/ktor/client/request/HttpRequestBuilder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "close", "()V", "", "toString", "()Ljava/lang/String;", "Lio/ktor/client/engine/HttpClientEngine;", "Lio/ktor/client/engine/HttpClientEngine;", "d", "()Lio/ktor/client/engine/HttpClientEngine;", "engine", "", "b", "Z", "manageEngine", "Lkotlinx/coroutines/CompletableJob;", "c", "Lkotlinx/coroutines/CompletableJob;", "clientJob", "Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lio/ktor/client/request/HttpRequestPipeline;", "e", "Lio/ktor/client/request/HttpRequestPipeline;", "n", "()Lio/ktor/client/request/HttpRequestPipeline;", "requestPipeline", "Lio/ktor/client/statement/HttpResponsePipeline;", "f", "Lio/ktor/client/statement/HttpResponsePipeline;", "r", "()Lio/ktor/client/statement/HttpResponsePipeline;", "responsePipeline", "Lio/ktor/client/request/HttpSendPipeline;", "g", "Lio/ktor/client/request/HttpSendPipeline;", "s", "()Lio/ktor/client/request/HttpSendPipeline;", "sendPipeline", "Lio/ktor/client/statement/HttpReceivePipeline;", "h", "Lio/ktor/client/statement/HttpReceivePipeline;", "j", "()Lio/ktor/client/statement/HttpReceivePipeline;", "receivePipeline", "Lio/ktor/util/Attributes;", "i", "Lio/ktor/util/Attributes;", "J", "()Lio/ktor/util/Attributes;", "attributes", "Lio/ktor/events/Events;", "Lio/ktor/events/Events;", "()Lio/ktor/events/Events;", "monitor", "Lio/ktor/client/HttpClientConfig;", "Lio/ktor/client/engine/HttpClientEngineConfig;", "k", "Lio/ktor/client/HttpClientConfig;", "()Lio/ktor/client/HttpClientConfig;", "config", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nHttpClient.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HttpClient.kt\nio/ktor/client/HttpClient\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,239:1\n1855#2,2:240\n*S KotlinDebug\n*F\n+ 1 HttpClient.kt\nio/ktor/client/HttpClient\n*L\n222#1:240,2\n*E\n"})
public final class HttpClient implements CoroutineScope, Closeable {
    public static final /* synthetic */ AtomicIntegerFieldUpdater l = AtomicIntegerFieldUpdater.newUpdater(HttpClient.class, "closed");

    /* renamed from: a  reason: collision with root package name */
    public final HttpClientEngine f8815a;
    public boolean b;
    public final CompletableJob c;
    @NotNull
    private volatile /* synthetic */ int closed;
    public final CoroutineContext d;
    public final HttpRequestPipeline e;
    public final HttpResponsePipeline f;
    public final HttpSendPipeline g;
    public final HttpReceivePipeline h;
    public final Attributes i;
    public final Events j;
    public final HttpClientConfig k;

    public final Attributes J() {
        return this.i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(io.ktor.client.request.HttpRequestBuilder r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.client.HttpClient$execute$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            io.ktor.client.HttpClient$execute$1 r0 = (io.ktor.client.HttpClient$execute$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.client.HttpClient$execute$1 r0 = new io.ktor.client.HttpClient$execute$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004c
        L_0x0029:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r6)
            io.ktor.events.Events r6 = r4.j
            io.ktor.events.EventDefinition r2 = io.ktor.client.utils.ClientEventsKt.a()
            r6.a(r2, r5)
            io.ktor.client.request.HttpRequestPipeline r4 = r4.e
            java.lang.Object r6 = r5.d()
            r0.label = r3
            java.lang.Object r6 = r4.d(r5, r6, r0)
            if (r6 != r1) goto L_0x004c
            return r1
        L_0x004c:
            java.lang.String r4 = "null cannot be cast to non-null type io.ktor.client.call.HttpClientCall"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r4)
            io.ktor.client.call.HttpClientCall r6 = (io.ktor.client.call.HttpClientCall) r6
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.HttpClient.a(io.ktor.client.request.HttpRequestBuilder, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final HttpClientConfig c() {
        return this.k;
    }

    public void close() {
        if (l.compareAndSet(this, 0, 1)) {
            Attributes attributes = (Attributes) this.i.f(HttpClientPluginKt.a());
            for (AttributeKey attributeKey : attributes.b()) {
                Intrinsics.checkNotNull(attributeKey, "null cannot be cast to non-null type io.ktor.util.AttributeKey<kotlin.Any>");
                Object f2 = attributes.f(attributeKey);
                if (f2 instanceof Closeable) {
                    ((Closeable) f2).close();
                }
            }
            this.c.complete();
            if (this.b) {
                this.f8815a.close();
            }
        }
    }

    public final HttpClientEngine d() {
        return this.f8815a;
    }

    public final Events g() {
        return this.j;
    }

    public CoroutineContext getCoroutineContext() {
        return this.d;
    }

    public final HttpReceivePipeline j() {
        return this.h;
    }

    public final HttpRequestPipeline n() {
        return this.e;
    }

    public final HttpResponsePipeline r() {
        return this.f;
    }

    public final HttpSendPipeline s() {
        return this.g;
    }

    public String toString() {
        return "HttpClient[" + this.f8815a + ']';
    }
}
