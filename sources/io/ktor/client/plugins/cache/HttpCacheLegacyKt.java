package io.ktor.client.plugins.cache;

import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.cache.storage.HttpCacheStorage;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestData;
import io.ktor.client.request.HttpResponseData;
import io.ktor.client.statement.HttpResponse;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.date.GMTDate;
import io.ktor.util.pipeline.PipelineContext;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a;\u0010\n\u001a\u00020\t*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a;\u0010\u000e\u001a\u00020\t*\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u00002\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a3\u0010\u0012\u001a\u00020\t*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001f\u0010\u0014\u001a\u00020\f*\u00020\u00032\u0006\u0010\r\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a%\u0010\u0018\u001a\u0004\u0018\u00010\f*\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0018\u0010\u0019\u001aA\u0010\"\u001a\u0004\u0018\u00010!*\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001a2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\"\u0010#\u001a%\u0010%\u001a\u0004\u0018\u00010!*\u00020\u00032\u0006\u0010$\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b%\u0010&\u0002\u0004\n\u0002\b\u0019¨\u0006'"}, d2 = {"Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "Lio/ktor/client/plugins/cache/HttpCache;", "plugin", "Lio/ktor/http/content/OutgoingContent;", "content", "Lio/ktor/client/HttpClient;", "scope", "", "g", "(Lio/ktor/util/pipeline/PipelineContext;Lio/ktor/client/plugins/cache/HttpCache;Lio/ktor/http/content/OutgoingContent;Lio/ktor/client/HttpClient;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/client/statement/HttpResponse;", "response", "f", "(Lio/ktor/util/pipeline/PipelineContext;Lio/ktor/client/statement/HttpResponse;Lio/ktor/client/plugins/cache/HttpCache;Lio/ktor/client/HttpClient;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/client/call/HttpClientCall;", "cachedCall", "h", "(Lio/ktor/util/pipeline/PipelineContext;Lio/ktor/client/call/HttpClientCall;Lio/ktor/client/HttpClient;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "b", "(Lio/ktor/client/plugins/cache/HttpCache;Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/client/request/HttpRequest;", "request", "c", "(Lio/ktor/client/plugins/cache/HttpCache;Lio/ktor/client/request/HttpRequest;Lio/ktor/client/statement/HttpResponse;)Lio/ktor/client/statement/HttpResponse;", "Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;", "storage", "", "", "varyKeys", "Lio/ktor/http/Url;", "url", "Lio/ktor/client/plugins/cache/HttpCacheEntry;", "d", "(Lio/ktor/client/plugins/cache/HttpCache;Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;Ljava/util/Map;Lio/ktor/http/Url;Lio/ktor/client/request/HttpRequest;)Lio/ktor/client/plugins/cache/HttpCacheEntry;", "context", "e", "(Lio/ktor/client/plugins/cache/HttpCache;Lio/ktor/client/request/HttpRequestBuilder;Lio/ktor/http/content/OutgoingContent;)Lio/ktor/client/plugins/cache/HttpCacheEntry;", "ktor-client-core"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nHttpCacheLegacy.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HttpCacheLegacy.kt\nio/ktor/client/plugins/cache/HttpCacheLegacyKt\n+ 2 Headers.kt\nio/ktor/http/Headers$Companion\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,162:1\n24#2:163\n1#3:164\n1054#4:165\n288#4:166\n289#4:170\n167#5,3:167\n167#5,3:171\n*S KotlinDebug\n*F\n+ 1 HttpCacheLegacy.kt\nio/ktor/client/plugins/cache/HttpCacheLegacyKt\n*L\n86#1:163\n141#1:165\n142#1:166\n142#1:170\n143#1:167,3\n155#1:171,3\n*E\n"})
public final class HttpCacheLegacyKt {
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object b(io.ktor.client.plugins.cache.HttpCache r8, io.ktor.client.statement.HttpResponse r9, kotlin.coroutines.Continuation r10) {
        /*
            boolean r0 = r10 instanceof io.ktor.client.plugins.cache.HttpCacheLegacyKt$cacheResponse$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            io.ktor.client.plugins.cache.HttpCacheLegacyKt$cacheResponse$1 r0 = (io.ktor.client.plugins.cache.HttpCacheLegacyKt$cacheResponse$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.client.plugins.cache.HttpCacheLegacyKt$cacheResponse$1 r0 = new io.ktor.client.plugins.cache.HttpCacheLegacyKt$cacheResponse$1
            r0.<init>(r10)
        L_0x0018:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x007f
        L_0x0029:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r10)
            io.ktor.client.call.HttpClientCall r10 = r9.p0()
            io.ktor.client.request.HttpRequest r10 = r10.f()
            java.util.List r2 = io.ktor.http.HttpMessagePropertiesKt.a(r9)
            java.util.List r4 = io.ktor.http.HttpMessagePropertiesKt.a(r10)
            io.ktor.client.plugins.cache.CacheControl r5 = io.ktor.client.plugins.cache.CacheControl.f8887a
            io.ktor.http.HeaderValue r6 = r5.e()
            boolean r6 = r2.contains(r6)
            if (r6 == 0) goto L_0x0055
            io.ktor.client.plugins.cache.storage.HttpCacheStorage r6 = r8.l()
            goto L_0x0059
        L_0x0055:
            io.ktor.client.plugins.cache.storage.HttpCacheStorage r6 = r8.m()
        L_0x0059:
            io.ktor.http.HeaderValue r7 = r5.c()
            boolean r2 = r2.contains(r7)
            if (r2 != 0) goto L_0x0086
            io.ktor.http.HeaderValue r2 = r5.c()
            boolean r2 = r4.contains(r2)
            if (r2 == 0) goto L_0x006e
            goto L_0x0086
        L_0x006e:
            io.ktor.http.Url r10 = r10.T()
            boolean r8 = r8.n()
            r0.label = r3
            java.lang.Object r10 = io.ktor.client.plugins.cache.storage.HttpCacheStorageKt.c(r6, r10, r9, r8, r0)
            if (r10 != r1) goto L_0x007f
            return r1
        L_0x007f:
            io.ktor.client.plugins.cache.HttpCacheEntry r10 = (io.ktor.client.plugins.cache.HttpCacheEntry) r10
            io.ktor.client.statement.HttpResponse r8 = r10.f()
            return r8
        L_0x0086:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.HttpCacheLegacyKt.b(io.ktor.client.plugins.cache.HttpCache, io.ktor.client.statement.HttpResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final HttpResponse c(HttpCache httpCache, HttpRequest httpRequest, HttpResponse httpResponse) {
        Url T = httpResponse.p0().f().T();
        HttpCacheStorage l = HttpMessagePropertiesKt.a(httpResponse).contains(CacheControl.f8887a.e()) ? httpCache.l() : httpCache.m();
        Map e = HttpCacheEntryKt.e(httpResponse);
        HttpCacheEntry d = d(httpCache, l, e, T, httpRequest);
        if (d == null) {
            return null;
        }
        if (e.isEmpty()) {
            e = d.e();
        }
        l.d(T, new HttpCacheEntry(HttpCacheEntryKt.c(httpResponse, httpCache.n(), (Function0) null, 2, (Object) null), e, d.c(), d.a()));
        return d.f();
    }

    public static final HttpCacheEntry d(HttpCache httpCache, HttpCacheStorage httpCacheStorage, Map map, Url url, HttpRequest httpRequest) {
        Object obj;
        if (!map.isEmpty()) {
            return httpCacheStorage.b(url, map);
        }
        Function1 d = HttpCacheKt.d(httpRequest.getContent(), new HttpCacheLegacyKt$findResponse$requestHeaders$1(httpRequest.a()), new HttpCacheLegacyKt$findResponse$requestHeaders$2(httpRequest.a()));
        Iterator it = CollectionsKt.sortedWith(httpCacheStorage.c(url), new HttpCacheLegacyKt$findResponse$$inlined$sortedByDescending$1()).iterator();
        loop0:
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            Map e = ((HttpCacheEntry) obj).e();
            if (!e.isEmpty()) {
                Iterator it2 = e.entrySet().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break loop0;
                    }
                    Map.Entry entry = (Map.Entry) it2.next();
                    if (!Intrinsics.areEqual(d.invoke((String) entry.getKey()), (Object) (String) entry.getValue())) {
                    }
                }
            } else {
                break;
            }
        }
        return (HttpCacheEntry) obj;
    }

    public static final HttpCacheEntry e(HttpCache httpCache, HttpRequestBuilder httpRequestBuilder, OutgoingContent outgoingContent) {
        Url c = URLUtilsKt.c(httpRequestBuilder.i());
        Function1 d = HttpCacheKt.d(outgoingContent, new HttpCacheLegacyKt$findResponse$lookup$1(httpRequestBuilder.a()), new HttpCacheLegacyKt$findResponse$lookup$2(httpRequestBuilder.a()));
        loop0:
        for (HttpCacheEntry httpCacheEntry : SetsKt.plus(httpCache.l().c(c), httpCache.m().c(c))) {
            Map e = httpCacheEntry.e();
            if (!e.isEmpty() && !e.isEmpty()) {
                Iterator it = e.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break loop0;
                    }
                    Map.Entry entry = (Map.Entry) it.next();
                    if (!Intrinsics.areEqual(d.invoke((String) entry.getKey()), (Object) (String) entry.getValue())) {
                    }
                }
            }
            return httpCacheEntry;
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0069 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object f(io.ktor.util.pipeline.PipelineContext r6, io.ktor.client.statement.HttpResponse r7, io.ktor.client.plugins.cache.HttpCache r8, io.ktor.client.HttpClient r9, kotlin.coroutines.Continuation r10) {
        /*
            boolean r0 = r10 instanceof io.ktor.client.plugins.cache.HttpCacheLegacyKt$interceptReceiveLegacy$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            io.ktor.client.plugins.cache.HttpCacheLegacyKt$interceptReceiveLegacy$1 r0 = (io.ktor.client.plugins.cache.HttpCacheLegacyKt$interceptReceiveLegacy$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.client.plugins.cache.HttpCacheLegacyKt$interceptReceiveLegacy$1 r0 = new io.ktor.client.plugins.cache.HttpCacheLegacyKt$interceptReceiveLegacy$1
            r0.<init>(r10)
        L_0x0018:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0044
            if (r2 == r5) goto L_0x003c
            if (r2 == r4) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x00a4
        L_0x0030:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x006a
        L_0x003c:
            java.lang.Object r6 = r0.L$0
            io.ktor.util.pipeline.PipelineContext r6 = (io.ktor.util.pipeline.PipelineContext) r6
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x005c
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r10)
            io.ktor.http.HttpStatusCode r10 = r7.f()
            boolean r10 = io.ktor.http.HttpStatusCodeKt.b(r10)
            if (r10 == 0) goto L_0x006d
            r0.L$0 = r6
            r0.label = r5
            java.lang.Object r10 = b(r8, r7, r0)
            if (r10 != r1) goto L_0x005c
            return r1
        L_0x005c:
            io.ktor.client.statement.HttpResponse r10 = (io.ktor.client.statement.HttpResponse) r10
            r7 = 0
            r0.L$0 = r7
            r0.label = r4
            java.lang.Object r6 = r6.g(r10, r0)
            if (r6 != r1) goto L_0x006a
            return r1
        L_0x006a:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x006d:
            io.ktor.http.HttpStatusCode r10 = r7.f()
            io.ktor.http.HttpStatusCode$Companion r2 = io.ktor.http.HttpStatusCode.c
            io.ktor.http.HttpStatusCode r2 = r2.z()
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r2)
            if (r10 == 0) goto L_0x00b9
            io.ktor.client.statement.HttpResponseKt.d(r7)
            io.ktor.client.call.HttpClientCall r10 = r7.p0()
            io.ktor.client.request.HttpRequest r10 = r10.f()
            io.ktor.client.statement.HttpResponse r8 = c(r8, r10, r7)
            if (r8 == 0) goto L_0x00a7
            io.ktor.events.Events r7 = r9.g()
            io.ktor.client.plugins.cache.HttpCache$Companion r9 = io.ktor.client.plugins.cache.HttpCache.g
            io.ktor.events.EventDefinition r9 = r9.d()
            r7.a(r9, r8)
            r0.label = r3
            java.lang.Object r6 = r6.g(r8, r0)
            if (r6 != r1) goto L_0x00a4
            return r1
        L_0x00a4:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x00a7:
            io.ktor.client.plugins.cache.InvalidCacheStateException r6 = new io.ktor.client.plugins.cache.InvalidCacheStateException
            io.ktor.client.call.HttpClientCall r7 = r7.p0()
            io.ktor.client.request.HttpRequest r7 = r7.f()
            io.ktor.http.Url r7 = r7.T()
            r6.<init>(r7)
            throw r6
        L_0x00b9:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.HttpCacheLegacyKt.f(io.ktor.util.pipeline.PipelineContext, io.ktor.client.statement.HttpResponse, io.ktor.client.plugins.cache.HttpCache, io.ktor.client.HttpClient, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0030, code lost:
        r3 = io.ktor.client.plugins.cache.HttpCache.g.h(r3, r6, r7);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object g(io.ktor.util.pipeline.PipelineContext r3, io.ktor.client.plugins.cache.HttpCache r4, io.ktor.http.content.OutgoingContent r5, io.ktor.client.HttpClient r6, kotlin.coroutines.Continuation r7) {
        /*
            java.lang.Object r0 = r3.d()
            io.ktor.client.request.HttpRequestBuilder r0 = (io.ktor.client.request.HttpRequestBuilder) r0
            io.ktor.client.plugins.cache.HttpCacheEntry r4 = e(r4, r0, r5)
            if (r4 != 0) goto L_0x0040
            java.lang.Object r4 = r3.d()
            io.ktor.client.request.HttpRequestBuilder r4 = (io.ktor.client.request.HttpRequestBuilder) r4
            io.ktor.http.HeadersBuilder r4 = r4.a()
            io.ktor.http.HttpHeaders r5 = io.ktor.http.HttpHeaders.f8966a
            java.lang.String r5 = r5.f()
            java.lang.String r4 = r4.h(r5)
            java.util.List r4 = io.ktor.http.HttpHeaderValueParserKt.b(r4)
            io.ktor.client.plugins.cache.CacheControl r5 = io.ktor.client.plugins.cache.CacheControl.f8887a
            io.ktor.http.HeaderValue r5 = r5.d()
            boolean r4 = r4.contains(r5)
            if (r4 == 0) goto L_0x003d
            io.ktor.client.plugins.cache.HttpCache$Companion r4 = io.ktor.client.plugins.cache.HttpCache.g
            java.lang.Object r3 = r4.h(r3, r6, r7)
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r3 != r4) goto L_0x003d
            return r3
        L_0x003d:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            return r3
        L_0x0040:
            io.ktor.client.statement.HttpResponse r5 = r4.f()
            io.ktor.client.call.HttpClientCall r5 = r5.p0()
            io.ktor.util.date.GMTDate r0 = r4.b()
            io.ktor.client.statement.HttpResponse r1 = r4.c()
            io.ktor.http.Headers r1 = r1.a()
            java.lang.Object r2 = r3.d()
            io.ktor.client.request.HttpRequestBuilder r2 = (io.ktor.client.request.HttpRequestBuilder) r2
            io.ktor.client.plugins.cache.ValidateStatus r0 = io.ktor.client.plugins.cache.HttpCacheEntryKt.d(r0, r1, r2)
            io.ktor.client.plugins.cache.ValidateStatus r1 = io.ktor.client.plugins.cache.ValidateStatus.ShouldNotValidate
            if (r0 != r1) goto L_0x0072
            io.ktor.client.plugins.cache.HttpCache$Companion r4 = io.ktor.client.plugins.cache.HttpCache.g
            java.lang.Object r3 = r4.g(r3, r6, r5, r7)
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r3 != r4) goto L_0x006f
            return r3
        L_0x006f:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            return r3
        L_0x0072:
            io.ktor.client.plugins.cache.ValidateStatus r1 = io.ktor.client.plugins.cache.ValidateStatus.ShouldWarn
            if (r0 != r1) goto L_0x0084
            java.lang.Object r3 = h(r3, r5, r6, r7)
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r3 != r4) goto L_0x0081
            return r3
        L_0x0081:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            return r3
        L_0x0084:
            io.ktor.http.Headers r5 = r4.d()
            io.ktor.http.HttpHeaders r6 = io.ktor.http.HttpHeaders.f8966a
            java.lang.String r7 = r6.n()
            java.lang.String r5 = r5.get(r7)
            if (r5 == 0) goto L_0x00a1
            java.lang.Object r7 = r3.d()
            io.ktor.http.HttpMessageBuilder r7 = (io.ktor.http.HttpMessageBuilder) r7
            java.lang.String r0 = r6.q()
            io.ktor.client.request.UtilsKt.b(r7, r0, r5)
        L_0x00a1:
            io.ktor.http.Headers r4 = r4.d()
            java.lang.String r5 = r6.s()
            java.lang.String r4 = r4.get(r5)
            if (r4 == 0) goto L_0x00bc
            java.lang.Object r3 = r3.d()
            io.ktor.http.HttpMessageBuilder r3 = (io.ktor.http.HttpMessageBuilder) r3
            java.lang.String r5 = r6.p()
            io.ktor.client.request.UtilsKt.b(r3, r5, r4)
        L_0x00bc:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.HttpCacheLegacyKt.g(io.ktor.util.pipeline.PipelineContext, io.ktor.client.plugins.cache.HttpCache, io.ktor.http.content.OutgoingContent, io.ktor.client.HttpClient, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Object h(PipelineContext pipelineContext, HttpClientCall httpClientCall, HttpClient httpClient, Continuation continuation) {
        HttpRequestData b = ((HttpRequestBuilder) pipelineContext.d()).b();
        HttpStatusCode f = httpClientCall.g().f();
        GMTDate d = httpClientCall.g().d();
        Headers.Companion companion = Headers.f8962a;
        HeadersBuilder headersBuilder = new HeadersBuilder(0, 1, (DefaultConstructorMarker) null);
        headersBuilder.d(httpClientCall.g().a());
        headersBuilder.e(HttpHeaders.f8966a.D(), "110");
        Unit unit = Unit.INSTANCE;
        HttpClientCall httpClientCall2 = new HttpClientCall(httpClient, b, new HttpResponseData(f, d, headersBuilder.n(), httpClientCall.g().g(), httpClientCall.g().c(), httpClientCall.g().getCoroutineContext()));
        pipelineContext.c();
        httpClient.g().a(HttpCache.g.d(), httpClientCall2.g());
        Object g = pipelineContext.g(httpClientCall2, continuation);
        return g == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? g : Unit.INSTANCE;
    }
}
