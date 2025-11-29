package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H@"}, d2 = {"<anonymous>", "Lio/ktor/client/call/HttpClientCall;", "Lio/ktor/client/plugins/Sender;", "request", "Lio/ktor/client/request/HttpRequestBuilder;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.HttpRequestRetry$intercept$1", f = "HttpRequestRetry.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {298, 314}, m = "invokeSuspend", n = {"$this$intercept", "request", "shouldRetry", "shouldRetryOnException", "delayMillis", "modifyRequest", "subRequest", "retryCount", "maxRetries", "$this$intercept", "request", "shouldRetry", "shouldRetryOnException", "delayMillis", "modifyRequest", "lastRetryData", "retryCount", "maxRetries"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1"})
public final class HttpRequestRetry$intercept$1 extends SuspendLambda implements Function3<Sender, HttpRequestBuilder, Continuation<? super HttpClientCall>, Object> {
    final /* synthetic */ HttpClient $client;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    final /* synthetic */ HttpRequestRetry this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HttpRequestRetry$intercept$1(HttpRequestRetry httpRequestRetry, HttpClient httpClient, Continuation<? super HttpRequestRetry$intercept$1> continuation) {
        super(3, continuation);
        this.this$0 = httpRequestRetry;
        this.$client = httpClient;
    }

    @Nullable
    public final Object invoke(@NotNull Sender sender, @NotNull HttpRequestBuilder httpRequestBuilder, @Nullable Continuation<? super HttpClientCall> continuation) {
        HttpRequestRetry$intercept$1 httpRequestRetry$intercept$1 = new HttpRequestRetry$intercept$1(this.this$0, this.$client, continuation);
        httpRequestRetry$intercept$1.L$0 = sender;
        httpRequestRetry$intercept$1.L$1 = httpRequestBuilder;
        return httpRequestRetry$intercept$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v17, resolved type: io.ktor.client.request.HttpRequestBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v17, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v17, resolved type: kotlin.jvm.functions.Function2} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v18, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v15, resolved type: kotlin.jvm.functions.Function2} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v19, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v16, resolved type: kotlin.jvm.functions.Function3} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v20, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v11, resolved type: kotlin.jvm.functions.Function3} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v21, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v9, resolved type: io.ktor.client.request.HttpRequestBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v22, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v11, resolved type: io.ktor.client.plugins.Sender} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x010d A[SYNTHETIC, Splitter:B:32:0x010d] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x013b A[Catch:{ all -> 0x0078 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0146 A[Catch:{ all -> 0x0078 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0147 A[Catch:{ all -> 0x0078 }] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r24) {
        /*
            r23 = this;
            r1 = r23
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r1.label
            r3 = 2
            r5 = 1
            if (r0 == 0) goto L_0x007b
            if (r0 == r5) goto L_0x004a
            if (r0 != r3) goto L_0x0042
            int r0 = r1.I$1
            int r6 = r1.I$0
            java.lang.Object r7 = r1.L$6
            io.ktor.client.plugins.HttpRequestRetry$RetryEventData r7 = (io.ktor.client.plugins.HttpRequestRetry.RetryEventData) r7
            java.lang.Object r8 = r1.L$5
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            java.lang.Object r9 = r1.L$4
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            java.lang.Object r10 = r1.L$3
            kotlin.jvm.functions.Function3 r10 = (kotlin.jvm.functions.Function3) r10
            java.lang.Object r11 = r1.L$2
            kotlin.jvm.functions.Function3 r11 = (kotlin.jvm.functions.Function3) r11
            java.lang.Object r12 = r1.L$1
            io.ktor.client.request.HttpRequestBuilder r12 = (io.ktor.client.request.HttpRequestBuilder) r12
            java.lang.Object r13 = r1.L$0
            io.ktor.client.plugins.Sender r13 = (io.ktor.client.plugins.Sender) r13
            kotlin.ResultKt.throwOnFailure(r24)
            r14 = r3
        L_0x0034:
            r3 = r13
            r13 = r12
            r12 = r11
            r11 = r10
            r10 = r9
            r9 = r8
            r22 = r6
            r6 = r0
            r0 = r7
            r7 = r22
            goto L_0x01cd
        L_0x0042:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x004a:
            int r6 = r1.I$1
            int r7 = r1.I$0
            java.lang.Object r0 = r1.L$6
            r8 = r0
            io.ktor.client.request.HttpRequestBuilder r8 = (io.ktor.client.request.HttpRequestBuilder) r8
            java.lang.Object r0 = r1.L$5
            r9 = r0
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            java.lang.Object r0 = r1.L$4
            r10 = r0
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            java.lang.Object r0 = r1.L$3
            r11 = r0
            kotlin.jvm.functions.Function3 r11 = (kotlin.jvm.functions.Function3) r11
            java.lang.Object r0 = r1.L$2
            r12 = r0
            kotlin.jvm.functions.Function3 r12 = (kotlin.jvm.functions.Function3) r12
            java.lang.Object r0 = r1.L$1
            r13 = r0
            io.ktor.client.request.HttpRequestBuilder r13 = (io.ktor.client.request.HttpRequestBuilder) r13
            java.lang.Object r0 = r1.L$0
            r14 = r0
            io.ktor.client.plugins.Sender r14 = (io.ktor.client.plugins.Sender) r14
            kotlin.ResultKt.throwOnFailure(r24)     // Catch:{ all -> 0x0078 }
            r0 = r24
            goto L_0x013c
        L_0x0078:
            r0 = move-exception
            goto L_0x015e
        L_0x007b:
            kotlin.ResultKt.throwOnFailure(r24)
            java.lang.Object r0 = r1.L$0
            io.ktor.client.plugins.Sender r0 = (io.ktor.client.plugins.Sender) r0
            java.lang.Object r6 = r1.L$1
            io.ktor.client.request.HttpRequestBuilder r6 = (io.ktor.client.request.HttpRequestBuilder) r6
            io.ktor.util.Attributes r7 = r6.c()
            io.ktor.util.AttributeKey r8 = io.ktor.client.plugins.HttpRequestRetryKt.c
            java.lang.Object r7 = r7.e(r8)
            kotlin.jvm.functions.Function3 r7 = (kotlin.jvm.functions.Function3) r7
            if (r7 != 0) goto L_0x009c
            io.ktor.client.plugins.HttpRequestRetry r7 = r1.this$0
            kotlin.jvm.functions.Function3 r7 = r7.f8856a
        L_0x009c:
            io.ktor.util.Attributes r8 = r6.c()
            io.ktor.util.AttributeKey r9 = io.ktor.client.plugins.HttpRequestRetryKt.d
            java.lang.Object r8 = r8.e(r9)
            kotlin.jvm.functions.Function3 r8 = (kotlin.jvm.functions.Function3) r8
            if (r8 != 0) goto L_0x00b2
            io.ktor.client.plugins.HttpRequestRetry r8 = r1.this$0
            kotlin.jvm.functions.Function3 r8 = r8.b
        L_0x00b2:
            io.ktor.util.Attributes r9 = r6.c()
            io.ktor.util.AttributeKey r10 = io.ktor.client.plugins.HttpRequestRetryKt.b
            java.lang.Object r9 = r9.e(r10)
            java.lang.Integer r9 = (java.lang.Integer) r9
            if (r9 == 0) goto L_0x00c7
            int r9 = r9.intValue()
            goto L_0x00cd
        L_0x00c7:
            io.ktor.client.plugins.HttpRequestRetry r9 = r1.this$0
            int r9 = r9.e
        L_0x00cd:
            io.ktor.util.Attributes r10 = r6.c()
            io.ktor.util.AttributeKey r11 = io.ktor.client.plugins.HttpRequestRetryKt.f
            java.lang.Object r10 = r10.e(r11)
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            if (r10 != 0) goto L_0x00e3
            io.ktor.client.plugins.HttpRequestRetry r10 = r1.this$0
            kotlin.jvm.functions.Function2 r10 = r10.c
        L_0x00e3:
            io.ktor.util.Attributes r11 = r6.c()
            io.ktor.util.AttributeKey r12 = io.ktor.client.plugins.HttpRequestRetryKt.e
            java.lang.Object r11 = r11.e(r12)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            if (r11 != 0) goto L_0x00f9
            io.ktor.client.plugins.HttpRequestRetry r11 = r1.this$0
            kotlin.jvm.functions.Function2 r11 = r11.f
        L_0x00f9:
            r12 = 0
            r14 = r0
            r13 = r6
            r6 = r9
            r9 = r11
            r0 = 0
            r11 = r8
            r22 = r12
            r12 = r7
            r7 = r22
        L_0x0105:
            io.ktor.client.plugins.HttpRequestRetry r8 = r1.this$0
            io.ktor.client.request.HttpRequestBuilder r8 = r8.m(r13)
            if (r0 == 0) goto L_0x0121
            io.ktor.client.plugins.HttpRequestRetry$ModifyRequestContext r15 = new io.ktor.client.plugins.HttpRequestRetry$ModifyRequestContext     // Catch:{ all -> 0x0078 }
            io.ktor.client.statement.HttpResponse r3 = r0.c()     // Catch:{ all -> 0x0078 }
            java.lang.Throwable r4 = r0.a()     // Catch:{ all -> 0x0078 }
            int r0 = r0.d()     // Catch:{ all -> 0x0078 }
            r15.<init>(r13, r3, r4, r0)     // Catch:{ all -> 0x0078 }
            r9.invoke(r15, r8)     // Catch:{ all -> 0x0078 }
        L_0x0121:
            r1.L$0 = r14     // Catch:{ all -> 0x0078 }
            r1.L$1 = r13     // Catch:{ all -> 0x0078 }
            r1.L$2 = r12     // Catch:{ all -> 0x0078 }
            r1.L$3 = r11     // Catch:{ all -> 0x0078 }
            r1.L$4 = r10     // Catch:{ all -> 0x0078 }
            r1.L$5 = r9     // Catch:{ all -> 0x0078 }
            r1.L$6 = r8     // Catch:{ all -> 0x0078 }
            r1.I$0 = r7     // Catch:{ all -> 0x0078 }
            r1.I$1 = r6     // Catch:{ all -> 0x0078 }
            r1.label = r5     // Catch:{ all -> 0x0078 }
            java.lang.Object r0 = r14.a(r8, r1)     // Catch:{ all -> 0x0078 }
            if (r0 != r2) goto L_0x013c
            return r2
        L_0x013c:
            io.ktor.client.call.HttpClientCall r0 = (io.ktor.client.call.HttpClientCall) r0     // Catch:{ all -> 0x0078 }
            io.ktor.client.plugins.HttpRequestRetry r3 = r1.this$0     // Catch:{ all -> 0x0078 }
            boolean r3 = r3.n(r7, r6, r12, r0)     // Catch:{ all -> 0x0078 }
            if (r3 != 0) goto L_0x0147
            return r0
        L_0x0147:
            io.ktor.client.plugins.HttpRequestRetry$RetryEventData r3 = new io.ktor.client.plugins.HttpRequestRetry$RetryEventData     // Catch:{ all -> 0x0078 }
            int r7 = r7 + 1
            io.ktor.client.statement.HttpResponse r0 = r0.g()     // Catch:{ all -> 0x0078 }
            r4 = 0
            r3.<init>(r8, r7, r0, r4)     // Catch:{ all -> 0x0078 }
            r0 = r6
            r6 = r7
            r8 = r9
            r9 = r10
            r10 = r11
            r11 = r12
            r12 = r13
            r13 = r14
            r4 = 0
        L_0x015c:
            r7 = r3
            goto L_0x0183
        L_0x015e:
            io.ktor.client.plugins.HttpRequestRetry r3 = r1.this$0
            r16 = r3
            r17 = r7
            r18 = r6
            r19 = r11
            r20 = r8
            r21 = r0
            boolean r3 = r16.o(r17, r18, r19, r20, r21)
            if (r3 == 0) goto L_0x01f8
            io.ktor.client.plugins.HttpRequestRetry$RetryEventData r3 = new io.ktor.client.plugins.HttpRequestRetry$RetryEventData
            int r7 = r7 + 1
            r4 = 0
            r3.<init>(r8, r7, r4, r0)
            r0 = r6
            r6 = r7
            r8 = r9
            r9 = r10
            r10 = r11
            r11 = r12
            r12 = r13
            r13 = r14
            goto L_0x015c
        L_0x0183:
            io.ktor.client.HttpClient r3 = r1.$client
            io.ktor.events.Events r3 = r3.g()
            io.ktor.client.plugins.HttpRequestRetry$Plugin r14 = io.ktor.client.plugins.HttpRequestRetry.g
            io.ktor.events.EventDefinition r14 = r14.c()
            r3.a(r14, r7)
            io.ktor.client.plugins.HttpRequestRetry$DelayContext r3 = new io.ktor.client.plugins.HttpRequestRetry$DelayContext
            io.ktor.client.request.HttpRequestBuilder r14 = r7.b()
            io.ktor.client.statement.HttpResponse r15 = r7.c()
            java.lang.Throwable r4 = r7.a()
            r3.<init>(r14, r15, r4)
            io.ktor.client.plugins.HttpRequestRetry r4 = r1.this$0
            kotlin.jvm.functions.Function2 r4 = r4.d
            java.lang.Integer r14 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)
            java.lang.Object r3 = r9.invoke(r3, r14)
            r1.L$0 = r13
            r1.L$1 = r12
            r1.L$2 = r11
            r1.L$3 = r10
            r1.L$4 = r9
            r1.L$5 = r8
            r1.L$6 = r7
            r1.I$0 = r6
            r1.I$1 = r0
            r14 = 2
            r1.label = r14
            java.lang.Object r3 = r4.invoke(r3, r1)
            if (r3 != r2) goto L_0x0034
            return r2
        L_0x01cd:
            org.slf4j.Logger r4 = io.ktor.client.plugins.HttpRequestRetryKt.f8862a
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r15 = "Retrying request "
            r8.append(r15)
            io.ktor.http.URLBuilder r15 = r13.i()
            r8.append(r15)
            java.lang.String r15 = " attempt: "
            r8.append(r15)
            r8.append(r7)
            java.lang.String r8 = r8.toString()
            r4.trace(r8)
            r22 = r14
            r14 = r3
            r3 = r22
            goto L_0x0105
        L_0x01f8:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.HttpRequestRetry$intercept$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
