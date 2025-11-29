package io.ktor.client.plugins.cache;

import io.ktor.client.statement.HttpResponse;
import io.ktor.http.Headers;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.util.date.GMTDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000@\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001f\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007*\u00020\u0002H\u0000¢\u0006\u0004\b\t\u0010\n\u001a+\u0010\u000e\u001a\u00020\f*\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a'\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"", "isShared", "Lio/ktor/client/statement/HttpResponse;", "response", "Lio/ktor/client/plugins/cache/HttpCacheEntry;", "a", "(ZLio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "", "e", "(Lio/ktor/client/statement/HttpResponse;)Ljava/util/Map;", "Lkotlin/Function0;", "Lio/ktor/util/date/GMTDate;", "fallback", "b", "(Lio/ktor/client/statement/HttpResponse;ZLkotlin/jvm/functions/Function0;)Lio/ktor/util/date/GMTDate;", "cacheExpires", "Lio/ktor/http/Headers;", "responseHeaders", "Lio/ktor/client/request/HttpRequestBuilder;", "request", "Lio/ktor/client/plugins/cache/ValidateStatus;", "d", "(Lio/ktor/util/date/GMTDate;Lio/ktor/http/Headers;Lio/ktor/client/request/HttpRequestBuilder;)Lio/ktor/client/plugins/cache/ValidateStatus;", "ktor-client-core"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nHttpCacheEntry.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HttpCacheEntry.kt\nio/ktor/client/plugins/cache/HttpCacheEntryKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,143:1\n1747#2,3:144\n288#2,2:147\n288#2,2:149\n288#2,2:152\n1#3:151\n*S KotlinDebug\n*F\n+ 1 HttpCacheEntry.kt\nio/ktor/client/plugins/cache/HttpCacheEntryKt\n*L\n69#1:144,3\n71#1:147,2\n106#1:149,2\n128#1:152,2\n*E\n"})
public final class HttpCacheEntryKt {
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object a(boolean r8, io.ktor.client.statement.HttpResponse r9, kotlin.coroutines.Continuation r10) {
        /*
            boolean r0 = r10 instanceof io.ktor.client.plugins.cache.HttpCacheEntryKt$HttpCacheEntry$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            io.ktor.client.plugins.cache.HttpCacheEntryKt$HttpCacheEntry$1 r0 = (io.ktor.client.plugins.cache.HttpCacheEntryKt$HttpCacheEntry$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0014
            int r1 = r1 - r2
            r0.label = r1
        L_0x0012:
            r4 = r0
            goto L_0x001a
        L_0x0014:
            io.ktor.client.plugins.cache.HttpCacheEntryKt$HttpCacheEntry$1 r0 = new io.ktor.client.plugins.cache.HttpCacheEntryKt$HttpCacheEntry$1
            r0.<init>(r10)
            goto L_0x0012
        L_0x001a:
            java.lang.Object r10 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r7 = 1
            if (r1 == 0) goto L_0x0039
            if (r1 != r7) goto L_0x0031
            boolean r8 = r4.Z$0
            java.lang.Object r9 = r4.L$0
            io.ktor.client.statement.HttpResponse r9 = (io.ktor.client.statement.HttpResponse) r9
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0051
        L_0x0031:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r10)
            io.ktor.utils.io.ByteReadChannel r1 = r9.c()
            r4.L$0 = r9
            r4.Z$0 = r8
            r4.label = r7
            r2 = 0
            r5 = 1
            r6 = 0
            java.lang.Object r10 = io.ktor.utils.io.ByteReadChannel.DefaultImpls.a(r1, r2, r4, r5, r6)
            if (r10 != r0) goto L_0x0051
            return r0
        L_0x0051:
            io.ktor.utils.io.core.ByteReadPacket r10 = (io.ktor.utils.io.core.ByteReadPacket) r10
            r0 = 0
            r1 = 0
            byte[] r10 = io.ktor.utils.io.core.StringsKt.d(r10, r0, r7, r1)
            io.ktor.client.statement.HttpResponseKt.d(r9)
            io.ktor.client.plugins.cache.HttpCacheEntry r0 = new io.ktor.client.plugins.cache.HttpCacheEntry
            r2 = 2
            io.ktor.util.date.GMTDate r8 = c(r9, r8, r1, r2, r1)
            java.util.Map r1 = e(r9)
            r0.<init>(r8, r1, r9, r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.HttpCacheEntryKt.a(boolean, io.ktor.client.statement.HttpResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0059 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final io.ktor.util.date.GMTDate b(io.ktor.client.statement.HttpResponse r10, boolean r11, kotlin.jvm.functions.Function0 r12) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "fallback"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.util.List r0 = io.ktor.http.HttpMessagePropertiesKt.a(r10)
            r1 = 2
            r2 = 0
            r3 = 0
            if (r11 == 0) goto L_0x003b
            boolean r11 = r0 instanceof java.util.Collection
            if (r11 == 0) goto L_0x001e
            boolean r11 = r0.isEmpty()
            if (r11 == 0) goto L_0x001e
            goto L_0x003b
        L_0x001e:
            java.util.Iterator r11 = r0.iterator()
        L_0x0022:
            boolean r4 = r11.hasNext()
            if (r4 == 0) goto L_0x003b
            java.lang.Object r4 = r11.next()
            io.ktor.http.HeaderValue r4 = (io.ktor.http.HeaderValue) r4
            java.lang.String r4 = r4.c()
            java.lang.String r5 = "s-maxage"
            boolean r4 = kotlin.text.StringsKt.startsWith$default(r4, r5, r2, r1, r3)
            if (r4 == 0) goto L_0x0022
            goto L_0x003d
        L_0x003b:
            java.lang.String r5 = "max-age"
        L_0x003d:
            java.util.Iterator r11 = r0.iterator()
        L_0x0041:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto L_0x0059
            java.lang.Object r0 = r11.next()
            r4 = r0
            io.ktor.http.HeaderValue r4 = (io.ktor.http.HeaderValue) r4
            java.lang.String r4 = r4.c()
            boolean r4 = kotlin.text.StringsKt.startsWith$default(r4, r5, r2, r1, r3)
            if (r4 == 0) goto L_0x0041
            goto L_0x005a
        L_0x0059:
            r0 = r3
        L_0x005a:
            io.ktor.http.HeaderValue r0 = (io.ktor.http.HeaderValue) r0
            if (r0 == 0) goto L_0x0081
            java.lang.String r4 = r0.c()
            if (r4 == 0) goto L_0x0081
            java.lang.String r11 = "="
            java.lang.String[] r5 = new java.lang.String[]{r11}
            r8 = 6
            r9 = 0
            r6 = 0
            r7 = 0
            java.util.List r11 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r4, (java.lang.String[]) r5, (boolean) r6, (int) r7, (int) r8, (java.lang.Object) r9)
            if (r11 == 0) goto L_0x0081
            r0 = 1
            java.lang.Object r11 = r11.get(r0)
            java.lang.String r11 = (java.lang.String) r11
            if (r11 == 0) goto L_0x0081
            java.lang.Long r3 = kotlin.text.StringsKt.toLongOrNull(r11)
        L_0x0081:
            if (r3 == 0) goto L_0x0093
            io.ktor.util.date.GMTDate r10 = r10.d()
            long r11 = r3.longValue()
            r0 = 1000(0x3e8, double:4.94E-321)
            long r11 = r11 * r0
            io.ktor.util.date.GMTDate r10 = io.ktor.util.date.DateKt.a(r10, r11)
            return r10
        L_0x0093:
            io.ktor.http.Headers r10 = r10.a()
            io.ktor.http.HttpHeaders r11 = io.ktor.http.HttpHeaders.f8966a
            java.lang.String r11 = r11.o()
            java.lang.String r10 = r10.get(r11)
            if (r10 == 0) goto L_0x00c5
            java.lang.String r11 = "0"
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r11)
            if (r11 != 0) goto L_0x00be
            boolean r11 = kotlin.text.StringsKt.isBlank(r10)
            if (r11 == 0) goto L_0x00b2
            goto L_0x00be
        L_0x00b2:
            io.ktor.util.date.GMTDate r10 = io.ktor.http.DateUtilsKt.b(r10)     // Catch:{ all -> 0x00b7 }
            goto L_0x00bd
        L_0x00b7:
            java.lang.Object r10 = r12.invoke()
            io.ktor.util.date.GMTDate r10 = (io.ktor.util.date.GMTDate) r10
        L_0x00bd:
            return r10
        L_0x00be:
            java.lang.Object r10 = r12.invoke()
            io.ktor.util.date.GMTDate r10 = (io.ktor.util.date.GMTDate) r10
            return r10
        L_0x00c5:
            java.lang.Object r10 = r12.invoke()
            io.ktor.util.date.GMTDate r10 = (io.ktor.util.date.GMTDate) r10
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.HttpCacheEntryKt.b(io.ktor.client.statement.HttpResponse, boolean, kotlin.jvm.functions.Function0):io.ktor.util.date.GMTDate");
    }

    public static /* synthetic */ GMTDate c(HttpResponse httpResponse, boolean z, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = HttpCacheEntryKt$cacheExpires$1.INSTANCE;
        }
        return b(httpResponse, z, function0);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: io.ktor.http.HeaderValue} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: io.ktor.http.HeaderValue} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: io.ktor.http.HeaderValue} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: io.ktor.http.HeaderValue} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final io.ktor.client.plugins.cache.ValidateStatus d(io.ktor.util.date.GMTDate r17, io.ktor.http.Headers r18, io.ktor.client.request.HttpRequestBuilder r19) {
        /*
            r0 = r18
            java.lang.String r1 = "cacheExpires"
            r2 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)
            java.lang.String r1 = "responseHeaders"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            java.lang.String r1 = "request"
            r3 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r1)
            io.ktor.http.HeadersBuilder r1 = r19.a()
            io.ktor.http.HttpHeaders r4 = io.ktor.http.HttpHeaders.f8966a
            java.lang.String r5 = r4.f()
            java.util.List r6 = r0.a(r5)
            r0 = 0
            if (r6 == 0) goto L_0x0035
            r13 = 62
            r14 = 0
            java.lang.String r7 = ","
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            java.lang.String r5 = kotlin.collections.CollectionsKt.joinToString$default(r6, r7, r8, r9, r10, r11, r12, r13, r14)
            goto L_0x0036
        L_0x0035:
            r5 = r0
        L_0x0036:
            java.util.List r5 = io.ktor.http.HttpHeaderValueParserKt.b(r5)
            java.lang.String r4 = r4.f()
            java.util.List r6 = r1.a(r4)
            if (r6 == 0) goto L_0x0053
            r13 = 62
            r14 = 0
            java.lang.String r7 = ","
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            java.lang.String r1 = kotlin.collections.CollectionsKt.joinToString$default(r6, r7, r8, r9, r10, r11, r12, r13, r14)
            goto L_0x0054
        L_0x0053:
            r1 = r0
        L_0x0054:
            java.util.List r1 = io.ktor.http.HttpHeaderValueParserKt.b(r1)
            io.ktor.client.plugins.cache.CacheControl r4 = io.ktor.client.plugins.cache.CacheControl.f8887a
            io.ktor.http.HeaderValue r4 = r4.b()
            boolean r4 = r1.contains(r4)
            java.lang.String r6 = "\"no-cache\" is set for "
            java.lang.String r7 = ", should validate cached response"
            if (r4 == 0) goto L_0x0088
            org.slf4j.Logger r0 = io.ktor.client.plugins.cache.HttpCacheKt.c()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r6)
            io.ktor.http.URLBuilder r2 = r19.i()
            r1.append(r2)
            r1.append(r7)
            java.lang.String r1 = r1.toString()
            r0.trace(r1)
            io.ktor.client.plugins.cache.ValidateStatus r0 = io.ktor.client.plugins.cache.ValidateStatus.ShouldValidate
            return r0
        L_0x0088:
            java.util.Iterator r4 = r1.iterator()
        L_0x008c:
            boolean r8 = r4.hasNext()
            r9 = 2
            r10 = 0
            if (r8 == 0) goto L_0x00a8
            java.lang.Object r8 = r4.next()
            r11 = r8
            io.ktor.http.HeaderValue r11 = (io.ktor.http.HeaderValue) r11
            java.lang.String r11 = r11.c()
            java.lang.String r12 = "max-age="
            boolean r11 = kotlin.text.StringsKt.startsWith$default(r11, r12, r10, r9, r0)
            if (r11 == 0) goto L_0x008c
            goto L_0x00a9
        L_0x00a8:
            r8 = r0
        L_0x00a9:
            io.ktor.http.HeaderValue r8 = (io.ktor.http.HeaderValue) r8
            if (r8 == 0) goto L_0x00de
            java.lang.String r11 = r8.c()
            if (r11 == 0) goto L_0x00de
            java.lang.String r4 = "="
            java.lang.String[] r12 = new java.lang.String[]{r4}
            r15 = 6
            r16 = 0
            r13 = 0
            r14 = 0
            java.util.List r4 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r11, (java.lang.String[]) r12, (boolean) r13, (int) r14, (int) r15, (java.lang.Object) r16)
            if (r4 == 0) goto L_0x00de
            r8 = 1
            java.lang.Object r4 = r4.get(r8)
            java.lang.String r4 = (java.lang.String) r4
            if (r4 == 0) goto L_0x00de
            java.lang.Integer r4 = kotlin.text.StringsKt.toIntOrNull(r4)
            if (r4 == 0) goto L_0x00d8
            int r4 = r4.intValue()
            goto L_0x00d9
        L_0x00d8:
            r4 = r10
        L_0x00d9:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            goto L_0x00df
        L_0x00de:
            r4 = r0
        L_0x00df:
            if (r4 != 0) goto L_0x00e2
            goto L_0x010a
        L_0x00e2:
            int r4 = r4.intValue()
            if (r4 != 0) goto L_0x010a
            org.slf4j.Logger r0 = io.ktor.client.plugins.cache.HttpCacheKt.c()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "\"max-age\" is not set for "
            r1.append(r2)
            io.ktor.http.URLBuilder r2 = r19.i()
            r1.append(r2)
            r1.append(r7)
            java.lang.String r1 = r1.toString()
            r0.trace(r1)
            io.ktor.client.plugins.cache.ValidateStatus r0 = io.ktor.client.plugins.cache.ValidateStatus.ShouldValidate
            return r0
        L_0x010a:
            io.ktor.client.plugins.cache.CacheControl r4 = io.ktor.client.plugins.cache.CacheControl.f8887a
            io.ktor.http.HeaderValue r8 = r4.b()
            boolean r8 = r5.contains(r8)
            if (r8 == 0) goto L_0x0136
            org.slf4j.Logger r0 = io.ktor.client.plugins.cache.HttpCacheKt.c()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r6)
            io.ktor.http.URLBuilder r2 = r19.i()
            r1.append(r2)
            r1.append(r7)
            java.lang.String r1 = r1.toString()
            r0.trace(r1)
            io.ktor.client.plugins.cache.ValidateStatus r0 = io.ktor.client.plugins.cache.ValidateStatus.ShouldValidate
            return r0
        L_0x0136:
            long r11 = r17.d()
            long r13 = io.ktor.util.date.DateJvmKt.d()
            long r11 = r11 - r13
            r13 = 0
            int r2 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r2 <= 0) goto L_0x0169
            org.slf4j.Logger r0 = io.ktor.client.plugins.cache.HttpCacheKt.c()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Cached response is valid for "
            r1.append(r2)
            io.ktor.http.URLBuilder r2 = r19.i()
            r1.append(r2)
            java.lang.String r2 = ", should not validate"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.trace(r1)
            io.ktor.client.plugins.cache.ValidateStatus r0 = io.ktor.client.plugins.cache.ValidateStatus.ShouldNotValidate
            return r0
        L_0x0169:
            io.ktor.http.HeaderValue r2 = r4.a()
            boolean r2 = r5.contains(r2)
            if (r2 == 0) goto L_0x0195
            org.slf4j.Logger r0 = io.ktor.client.plugins.cache.HttpCacheKt.c()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "\"must-revalidate\" is set for "
            r1.append(r2)
            io.ktor.http.URLBuilder r2 = r19.i()
            r1.append(r2)
            r1.append(r7)
            java.lang.String r1 = r1.toString()
            r0.trace(r1)
            io.ktor.client.plugins.cache.ValidateStatus r0 = io.ktor.client.plugins.cache.ValidateStatus.ShouldValidate
            return r0
        L_0x0195:
            java.util.Iterator r1 = r1.iterator()
        L_0x0199:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x01b3
            java.lang.Object r2 = r1.next()
            r4 = r2
            io.ktor.http.HeaderValue r4 = (io.ktor.http.HeaderValue) r4
            java.lang.String r4 = r4.c()
            java.lang.String r5 = "max-stale="
            boolean r4 = kotlin.text.StringsKt.startsWith$default(r4, r5, r10, r9, r0)
            if (r4 == 0) goto L_0x0199
            r0 = r2
        L_0x01b3:
            io.ktor.http.HeaderValue r0 = (io.ktor.http.HeaderValue) r0
            if (r0 == 0) goto L_0x01d5
            java.lang.String r0 = r0.c()
            if (r0 == 0) goto L_0x01d5
            r1 = 10
            java.lang.String r0 = r0.substring(r1)
            java.lang.String r1 = "this as java.lang.String).substring(startIndex)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            if (r0 == 0) goto L_0x01d5
            java.lang.Integer r0 = kotlin.text.StringsKt.toIntOrNull(r0)
            if (r0 == 0) goto L_0x01d5
            int r10 = r0.intValue()
        L_0x01d5:
            long r0 = (long) r10
            r4 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 * r4
            long r11 = r11 + r0
            int r0 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            java.lang.String r1 = "Cached response is stale for "
            if (r0 <= 0) goto L_0x0202
            org.slf4j.Logger r0 = io.ktor.client.plugins.cache.HttpCacheKt.c()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            io.ktor.http.URLBuilder r1 = r19.i()
            r2.append(r1)
            java.lang.String r1 = " but less than max-stale, should warn"
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.trace(r1)
            io.ktor.client.plugins.cache.ValidateStatus r0 = io.ktor.client.plugins.cache.ValidateStatus.ShouldWarn
            return r0
        L_0x0202:
            org.slf4j.Logger r0 = io.ktor.client.plugins.cache.HttpCacheKt.c()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            io.ktor.http.URLBuilder r1 = r19.i()
            r2.append(r1)
            r2.append(r7)
            java.lang.String r1 = r2.toString()
            r0.trace(r1)
            io.ktor.client.plugins.cache.ValidateStatus r0 = io.ktor.client.plugins.cache.ValidateStatus.ShouldValidate
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.HttpCacheEntryKt.d(io.ktor.util.date.GMTDate, io.ktor.http.Headers, io.ktor.client.request.HttpRequestBuilder):io.ktor.client.plugins.cache.ValidateStatus");
    }

    public static final Map e(HttpResponse httpResponse) {
        Intrinsics.checkNotNullParameter(httpResponse, "<this>");
        List<String> h = HttpMessagePropertiesKt.h(httpResponse);
        if (h == null) {
            return MapsKt.emptyMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Headers a2 = httpResponse.p0().f().a();
        for (String str : h) {
            String str2 = a2.get(str);
            if (str2 == null) {
                str2 = "";
            }
            linkedHashMap.put(str, str2);
        }
        return linkedHashMap;
    }
}
