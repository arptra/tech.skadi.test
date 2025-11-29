package io.ktor.client.plugins.cache.storage;

import io.ktor.client.HttpClient;
import io.ktor.client.call.SavedHttpCall;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.statement.HttpResponse;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a/\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a=\u0010\u0010\u001a\u00020\u000f*\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\u0006\u001a\u00020\u0005H@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a+\u0010\u0018\u001a\u00020\u0003*\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;", "Lio/ktor/http/Url;", "url", "Lio/ktor/client/statement/HttpResponse;", "value", "", "isShared", "Lio/ktor/client/plugins/cache/HttpCacheEntry;", "c", "(Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;Lio/ktor/http/Url;Lio/ktor/client/statement/HttpResponse;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/client/plugins/cache/storage/CacheStorage;", "response", "", "", "varyKeys", "Lio/ktor/client/plugins/cache/storage/CachedResponseData;", "b", "(Lio/ktor/client/plugins/cache/storage/CacheStorage;Lio/ktor/client/statement/HttpResponse;Ljava/util/Map;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/client/HttpClient;", "client", "Lio/ktor/client/request/HttpRequest;", "request", "Lkotlin/coroutines/CoroutineContext;", "responseContext", "a", "(Lio/ktor/client/plugins/cache/storage/CachedResponseData;Lio/ktor/client/HttpClient;Lio/ktor/client/request/HttpRequest;Lkotlin/coroutines/CoroutineContext;)Lio/ktor/client/statement/HttpResponse;", "ktor-client-core"}, k = 2, mv = {1, 8, 0})
public final class HttpCacheStorageKt {
    public static final HttpResponse a(CachedResponseData cachedResponseData, HttpClient httpClient, HttpRequest httpRequest, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(cachedResponseData, "<this>");
        Intrinsics.checkNotNullParameter(httpClient, "client");
        Intrinsics.checkNotNullParameter(httpRequest, "request");
        Intrinsics.checkNotNullParameter(coroutineContext, "responseContext");
        return new SavedHttpCall(httpClient, httpRequest, new HttpCacheStorageKt$createResponse$response$1(cachedResponseData, coroutineContext), cachedResponseData.b()).g();
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00d3 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object b(io.ktor.client.plugins.cache.storage.CacheStorage r23, io.ktor.client.statement.HttpResponse r24, java.util.Map r25, boolean r26, kotlin.coroutines.Continuation r27) {
        /*
            r0 = r27
            boolean r1 = r0 instanceof io.ktor.client.plugins.cache.storage.HttpCacheStorageKt$store$4
            if (r1 == 0) goto L_0x0015
            r1 = r0
            io.ktor.client.plugins.cache.storage.HttpCacheStorageKt$store$4 r1 = (io.ktor.client.plugins.cache.storage.HttpCacheStorageKt$store$4) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0015
            int r2 = r2 - r3
            r1.label = r2
            goto L_0x001a
        L_0x0015:
            io.ktor.client.plugins.cache.storage.HttpCacheStorageKt$store$4 r1 = new io.ktor.client.plugins.cache.storage.HttpCacheStorageKt$store$4
            r1.<init>(r0)
        L_0x001a:
            java.lang.Object r0 = r1.result
            java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r1.label
            r9 = 2
            r10 = 1
            if (r2 == 0) goto L_0x0056
            if (r2 == r10) goto L_0x003b
            if (r2 != r9) goto L_0x0033
            java.lang.Object r1 = r1.L$0
            io.ktor.client.plugins.cache.storage.CachedResponseData r1 = (io.ktor.client.plugins.cache.storage.CachedResponseData) r1
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x00d5
        L_0x0033:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x003b:
            boolean r2 = r1.Z$0
            java.lang.Object r3 = r1.L$3
            io.ktor.http.Url r3 = (io.ktor.http.Url) r3
            java.lang.Object r4 = r1.L$2
            java.util.Map r4 = (java.util.Map) r4
            java.lang.Object r5 = r1.L$1
            io.ktor.client.statement.HttpResponse r5 = (io.ktor.client.statement.HttpResponse) r5
            java.lang.Object r6 = r1.L$0
            io.ktor.client.plugins.cache.storage.CacheStorage r6 = (io.ktor.client.plugins.cache.storage.CacheStorage) r6
            kotlin.ResultKt.throwOnFailure(r0)
            r14 = r2
            r21 = r4
            r12 = r5
            r11 = r6
            goto L_0x008d
        L_0x0056:
            kotlin.ResultKt.throwOnFailure(r0)
            io.ktor.client.call.HttpClientCall r0 = r24.p0()
            io.ktor.client.request.HttpRequest r0 = r0.f()
            io.ktor.http.Url r0 = r0.T()
            io.ktor.utils.io.ByteReadChannel r2 = r24.c()
            r11 = r23
            r1.L$0 = r11
            r12 = r24
            r1.L$1 = r12
            r13 = r25
            r1.L$2 = r13
            r1.L$3 = r0
            r14 = r26
            r1.Z$0 = r14
            r1.label = r10
            r3 = 0
            r6 = 1
            r7 = 0
            r5 = r1
            java.lang.Object r2 = io.ktor.utils.io.ByteReadChannel.DefaultImpls.a(r2, r3, r5, r6, r7)
            if (r2 != r8) goto L_0x0089
            return r8
        L_0x0089:
            r3 = r0
            r0 = r2
            r21 = r13
        L_0x008d:
            io.ktor.utils.io.core.ByteReadPacket r0 = (io.ktor.utils.io.core.ByteReadPacket) r0
            r2 = 0
            r4 = 0
            byte[] r22 = io.ktor.utils.io.core.StringsKt.d(r0, r2, r10, r4)
            io.ktor.client.statement.HttpResponseKt.d(r12)
            io.ktor.client.call.HttpClientCall r0 = r12.p0()
            io.ktor.client.request.HttpRequest r0 = r0.f()
            io.ktor.http.Url r0 = r0.T()
            io.ktor.http.HttpStatusCode r15 = r12.f()
            io.ktor.util.date.GMTDate r16 = r12.d()
            io.ktor.http.Headers r20 = r12.a()
            io.ktor.http.HttpProtocolVersion r18 = r12.g()
            io.ktor.util.date.GMTDate r17 = r12.e()
            io.ktor.util.date.GMTDate r19 = io.ktor.client.plugins.cache.HttpCacheEntryKt.c(r12, r14, r4, r9, r4)
            io.ktor.client.plugins.cache.storage.CachedResponseData r2 = new io.ktor.client.plugins.cache.storage.CachedResponseData
            r13 = r2
            r14 = r0
            r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21, r22)
            r1.L$0 = r2
            r1.L$1 = r4
            r1.L$2 = r4
            r1.L$3 = r4
            r1.label = r9
            java.lang.Object r0 = r11.a(r3, r2, r1)
            if (r0 != r8) goto L_0x00d4
            return r8
        L_0x00d4:
            r1 = r2
        L_0x00d5:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.storage.HttpCacheStorageKt.b(io.ktor.client.plugins.cache.storage.CacheStorage, io.ktor.client.statement.HttpResponse, java.util.Map, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: io.ktor.http.Url} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object c(io.ktor.client.plugins.cache.storage.HttpCacheStorage r4, io.ktor.http.Url r5, io.ktor.client.statement.HttpResponse r6, boolean r7, kotlin.coroutines.Continuation r8) {
        /*
            boolean r0 = r8 instanceof io.ktor.client.plugins.cache.storage.HttpCacheStorageKt$store$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            io.ktor.client.plugins.cache.storage.HttpCacheStorageKt$store$1 r0 = (io.ktor.client.plugins.cache.storage.HttpCacheStorageKt$store$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.client.plugins.cache.storage.HttpCacheStorageKt$store$1 r0 = new io.ktor.client.plugins.cache.storage.HttpCacheStorageKt$store$1
            r0.<init>(r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r4 = r0.L$1
            r5 = r4
            io.ktor.http.Url r5 = (io.ktor.http.Url) r5
            java.lang.Object r4 = r0.L$0
            io.ktor.client.plugins.cache.storage.HttpCacheStorage r4 = (io.ktor.client.plugins.cache.storage.HttpCacheStorage) r4
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x004a
        L_0x0032:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r8 = io.ktor.client.plugins.cache.HttpCacheEntryKt.a(r7, r6, r0)
            if (r8 != r1) goto L_0x004a
            return r1
        L_0x004a:
            io.ktor.client.plugins.cache.HttpCacheEntry r8 = (io.ktor.client.plugins.cache.HttpCacheEntry) r8
            r4.d(r5, r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.storage.HttpCacheStorageKt.c(io.ktor.client.plugins.cache.storage.HttpCacheStorage, io.ktor.http.Url, io.ktor.client.statement.HttpResponse, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
