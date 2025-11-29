package io.ktor.client.plugins.cache;

import io.ktor.client.HttpClient;
import io.ktor.client.statement.HttpResponse;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H@"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "Lio/ktor/client/statement/HttpResponse;", "response"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.cache.HttpCache$Companion$install$2", f = "HttpCache.kt", i = {1, 1, 3, 3}, l = {188, 194, 198, 206, 210}, m = "invokeSuspend", n = {"$this$intercept", "response", "$this$intercept", "response"}, s = {"L$0", "L$1", "L$0", "L$1"})
public final class HttpCache$Companion$install$2 extends SuspendLambda implements Function3<PipelineContext<HttpResponse, Unit>, HttpResponse, Continuation<? super Unit>, Object> {
    final /* synthetic */ HttpCache $plugin;
    final /* synthetic */ HttpClient $scope;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HttpCache$Companion$install$2(HttpCache httpCache, HttpClient httpClient, Continuation<? super HttpCache$Companion$install$2> continuation) {
        super(3, continuation);
        this.$plugin = httpCache;
        this.$scope = httpClient;
    }

    @Nullable
    public final Object invoke(@NotNull PipelineContext<HttpResponse, Unit> pipelineContext, @NotNull HttpResponse httpResponse, @Nullable Continuation<? super Unit> continuation) {
        HttpCache$Companion$install$2 httpCache$Companion$install$2 = new HttpCache$Companion$install$2(this.$plugin, this.$scope, continuation);
        httpCache$Companion$install$2.L$0 = pipelineContext;
        httpCache$Companion$install$2.L$1 = httpResponse;
        return httpCache$Companion$install$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0161  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            r7 = 0
            if (r1 == 0) goto L_0x0048
            if (r1 == r6) goto L_0x0044
            if (r1 == r5) goto L_0x0037
            if (r1 == r4) goto L_0x0032
            if (r1 == r3) goto L_0x0025
            if (r1 != r2) goto L_0x001d
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0173
        L_0x001d:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0025:
            java.lang.Object r1 = r11.L$1
            io.ktor.client.statement.HttpResponse r1 = (io.ktor.client.statement.HttpResponse) r1
            java.lang.Object r3 = r11.L$0
            io.ktor.util.pipeline.PipelineContext r3 = (io.ktor.util.pipeline.PipelineContext) r3
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0141
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x00e7
        L_0x0037:
            java.lang.Object r1 = r11.L$1
            io.ktor.client.statement.HttpResponse r1 = (io.ktor.client.statement.HttpResponse) r1
            java.lang.Object r5 = r11.L$0
            io.ktor.util.pipeline.PipelineContext r5 = (io.ktor.util.pipeline.PipelineContext) r5
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x00c8
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0085
        L_0x0048:
            kotlin.ResultKt.throwOnFailure(r12)
            java.lang.Object r12 = r11.L$0
            io.ktor.util.pipeline.PipelineContext r12 = (io.ktor.util.pipeline.PipelineContext) r12
            java.lang.Object r1 = r11.L$1
            io.ktor.client.statement.HttpResponse r1 = (io.ktor.client.statement.HttpResponse) r1
            io.ktor.client.call.HttpClientCall r8 = r1.p0()
            io.ktor.client.request.HttpRequest r8 = r8.f()
            io.ktor.http.HttpMethod r8 = r8.getMethod()
            io.ktor.http.HttpMethod$Companion r9 = io.ktor.http.HttpMethod.b
            io.ktor.http.HttpMethod r9 = r9.a()
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r9)
            if (r8 != 0) goto L_0x006e
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L_0x006e:
            io.ktor.client.plugins.cache.HttpCache r8 = r11.$plugin
            boolean r8 = r8.e
            if (r8 == 0) goto L_0x0088
            io.ktor.client.plugins.cache.HttpCache r2 = r11.$plugin
            io.ktor.client.HttpClient r3 = r11.$scope
            r11.L$0 = r7
            r11.label = r6
            java.lang.Object r11 = io.ktor.client.plugins.cache.HttpCacheLegacyKt.f(r12, r1, r2, r3, r11)
            if (r11 != r0) goto L_0x0085
            return r0
        L_0x0085:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L_0x0088:
            io.ktor.http.HttpStatusCode r6 = r1.f()
            boolean r6 = io.ktor.http.HttpStatusCodeKt.b(r6)
            if (r6 == 0) goto L_0x00eb
            org.slf4j.Logger r6 = io.ktor.client.plugins.cache.HttpCacheKt.c()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Caching response for "
            r8.append(r9)
            io.ktor.client.call.HttpClientCall r9 = r1.p0()
            io.ktor.client.request.HttpRequest r9 = r9.f()
            io.ktor.http.Url r9 = r9.T()
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r6.trace(r8)
            io.ktor.client.plugins.cache.HttpCache r6 = r11.$plugin
            r11.L$0 = r12
            r11.L$1 = r1
            r11.label = r5
            java.lang.Object r5 = r6.h(r1, r11)
            if (r5 != r0) goto L_0x00c5
            return r0
        L_0x00c5:
            r10 = r5
            r5 = r12
            r12 = r10
        L_0x00c8:
            io.ktor.client.plugins.cache.storage.CachedResponseData r12 = (io.ktor.client.plugins.cache.storage.CachedResponseData) r12
            if (r12 == 0) goto L_0x00ea
            io.ktor.client.HttpClient r2 = r11.$scope
            io.ktor.client.request.HttpRequest r3 = io.ktor.client.statement.HttpResponseKt.e(r1)
            kotlin.coroutines.CoroutineContext r1 = r1.getCoroutineContext()
            io.ktor.client.statement.HttpResponse r12 = io.ktor.client.plugins.cache.storage.HttpCacheStorageKt.a(r12, r2, r3, r1)
            r11.L$0 = r7
            r11.L$1 = r7
            r11.label = r4
            java.lang.Object r11 = r5.g(r12, r11)
            if (r11 != r0) goto L_0x00e7
            return r0
        L_0x00e7:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L_0x00ea:
            r12 = r5
        L_0x00eb:
            io.ktor.http.HttpStatusCode r4 = r1.f()
            io.ktor.http.HttpStatusCode$Companion r5 = io.ktor.http.HttpStatusCode.c
            io.ktor.http.HttpStatusCode r5 = r5.z()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 == 0) goto L_0x0173
            org.slf4j.Logger r4 = io.ktor.client.plugins.cache.HttpCacheKt.c()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Not modified response for "
            r5.append(r6)
            io.ktor.client.call.HttpClientCall r6 = r1.p0()
            io.ktor.client.request.HttpRequest r6 = r6.f()
            io.ktor.http.Url r6 = r6.T()
            r5.append(r6)
            java.lang.String r6 = ", replying from cache"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            r4.trace(r5)
            io.ktor.client.statement.HttpResponseKt.d(r1)
            io.ktor.client.plugins.cache.HttpCache r4 = r11.$plugin
            io.ktor.client.call.HttpClientCall r5 = r1.p0()
            io.ktor.client.request.HttpRequest r5 = r5.f()
            r11.L$0 = r12
            r11.L$1 = r1
            r11.label = r3
            java.lang.Object r3 = r4.i(r5, r1, r11)
            if (r3 != r0) goto L_0x013e
            return r0
        L_0x013e:
            r10 = r3
            r3 = r12
            r12 = r10
        L_0x0141:
            io.ktor.client.statement.HttpResponse r12 = (io.ktor.client.statement.HttpResponse) r12
            if (r12 == 0) goto L_0x0161
            io.ktor.client.HttpClient r1 = r11.$scope
            io.ktor.events.Events r1 = r1.g()
            io.ktor.client.plugins.cache.HttpCache$Companion r4 = io.ktor.client.plugins.cache.HttpCache.g
            io.ktor.events.EventDefinition r4 = r4.d()
            r1.a(r4, r12)
            r11.L$0 = r7
            r11.L$1 = r7
            r11.label = r2
            java.lang.Object r11 = r3.g(r12, r11)
            if (r11 != r0) goto L_0x0173
            return r0
        L_0x0161:
            io.ktor.client.plugins.cache.InvalidCacheStateException r11 = new io.ktor.client.plugins.cache.InvalidCacheStateException
            io.ktor.client.call.HttpClientCall r12 = r1.p0()
            io.ktor.client.request.HttpRequest r12 = r12.f()
            io.ktor.http.Url r12 = r12.T()
            r11.<init>(r12)
            throw r11
        L_0x0173:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.HttpCache$Companion$install$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
