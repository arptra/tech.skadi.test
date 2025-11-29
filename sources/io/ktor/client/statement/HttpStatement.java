package io.ktor.client.statement;

import io.ktor.client.HttpClient;
import io.ktor.client.engine.HttpClientEngineCapabilityKt;
import io.ktor.client.plugins.HttpClientPlugin;
import io.ktor.client.plugins.HttpClientPluginKt;
import io.ktor.client.request.HttpRequestBuilder;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007JL\u0010\u0010\u001a\u00028\u0000\"\u0004\b\u0000\u0010\b21\u0010\u000f\u001a-\b\u0001\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tH@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u0014*\u00020\nH@ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001cR \u0010\u0005\u001a\u00020\u00048\u0000X\u0004¢\u0006\u0012\n\u0004\b\u0015\u0010\u001d\u0012\u0004\b \u0010\u001b\u001a\u0004\b\u001e\u0010\u001f\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"Lio/ktor/client/statement/HttpStatement;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "builder", "Lio/ktor/client/HttpClient;", "client", "<init>", "(Lio/ktor/client/request/HttpRequestBuilder;Lio/ktor/client/HttpClient;)V", "T", "Lkotlin/Function2;", "Lio/ktor/client/statement/HttpResponse;", "Lkotlin/ParameterName;", "name", "response", "Lkotlin/coroutines/Continuation;", "block", "c", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "d", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "b", "(Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", "a", "()V", "Lio/ktor/client/request/HttpRequestBuilder;", "Lio/ktor/client/HttpClient;", "getClient", "()Lio/ktor/client/HttpClient;", "getClient$annotations", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nHttpStatement.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HttpStatement.kt\nio/ktor/client/statement/HttpStatement\n+ 2 HttpTimeout.kt\nio/ktor/client/plugins/HttpTimeoutKt\n+ 3 HttpClientCall.kt\nio/ktor/client/call/HttpClientCallKt\n+ 4 TypeInfoJvm.kt\nio/ktor/util/reflect/TypeInfoJvmKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,145:1\n269#2,4:146\n269#2,2:150\n271#2,2:156\n269#2,2:158\n271#2,2:164\n269#2,4:166\n156#3:152\n156#3:160\n17#4,3:153\n17#4,3:161\n800#5,11:170\n1855#5,2:181\n*S KotlinDebug\n*F\n+ 1 HttpStatement.kt\nio/ktor/client/statement/HttpStatement\n*L\n46#1:146,4\n74#1:150,2\n74#1:156,2\n90#1:158,2\n90#1:164,2\n105#1:166,4\n77#1:152\n93#1:160\n77#1:153,3\n93#1:161,3\n135#1:170,11\n136#1:181,2\n*E\n"})
public final class HttpStatement {

    /* renamed from: a  reason: collision with root package name */
    public final HttpRequestBuilder f8927a;
    public final HttpClient b;

    public HttpStatement(HttpRequestBuilder httpRequestBuilder, HttpClient httpClient) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "builder");
        Intrinsics.checkNotNullParameter(httpClient, "client");
        this.f8927a = httpRequestBuilder;
        this.b = httpClient;
        a();
    }

    public final void a() {
        Set keySet;
        Map map = (Map) this.f8927a.c().e(HttpClientEngineCapabilityKt.a());
        if (map != null && (keySet = map.keySet()) != null) {
            ArrayList<HttpClientPlugin> arrayList = new ArrayList<>();
            for (Object next : keySet) {
                if (next instanceof HttpClientPlugin) {
                    arrayList.add(next);
                }
            }
            for (HttpClientPlugin httpClientPlugin : arrayList) {
                if (HttpClientPluginKt.c(this.b, httpClientPlugin) == null) {
                    throw new IllegalArgumentException(("Consider installing " + httpClientPlugin + " plugin because the request requires it to be installed").toString());
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(io.ktor.client.statement.HttpResponse r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.client.statement.HttpStatement$cleanup$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            io.ktor.client.statement.HttpStatement$cleanup$1 r0 = (io.ktor.client.statement.HttpStatement$cleanup$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.client.statement.HttpStatement$cleanup$1 r0 = new io.ktor.client.statement.HttpStatement$cleanup$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r4 = r0.result
            java.lang.Object r6 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L_0x0035
            if (r1 != r2) goto L_0x002d
            java.lang.Object r5 = r0.L$0
            kotlinx.coroutines.CompletableJob r5 = (kotlinx.coroutines.CompletableJob) r5
            kotlin.ResultKt.throwOnFailure(r4)
            goto L_0x005c
        L_0x002d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r4)
            kotlin.coroutines.CoroutineContext r4 = r5.getCoroutineContext()
            kotlinx.coroutines.Job$Key r1 = kotlinx.coroutines.Job.b0
            kotlin.coroutines.CoroutineContext$Element r4 = r4.get(r1)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            kotlinx.coroutines.CompletableJob r4 = (kotlinx.coroutines.CompletableJob) r4
            r4.complete()
            io.ktor.utils.io.ByteReadChannel r5 = r5.c()     // Catch:{ all -> 0x0051 }
            io.ktor.utils.io.ByteReadChannelKt.a(r5)     // Catch:{ all -> 0x0051 }
        L_0x0051:
            r0.L$0 = r4
            r0.label = r2
            java.lang.Object r4 = r4.i0(r0)
            if (r4 != r6) goto L_0x005c
            return r6
        L_0x005c:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.statement.HttpStatement.b(io.ktor.client.statement.HttpResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v9, resolved type: kotlin.jvm.functions.Function2} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0085 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0096 A[Catch:{ CancellationException -> 0x0040 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0097 A[Catch:{ CancellationException -> 0x0040 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object c(kotlin.jvm.functions.Function2 r10, kotlin.coroutines.Continuation r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof io.ktor.client.statement.HttpStatement$execute$1
            if (r0 == 0) goto L_0x0013
            r0 = r11
            io.ktor.client.statement.HttpStatement$execute$1 r0 = (io.ktor.client.statement.HttpStatement$execute$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.client.statement.HttpStatement$execute$1 r0 = new io.ktor.client.statement.HttpStatement$execute$1
            r0.<init>(r9, r11)
        L_0x0018:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            if (r2 == 0) goto L_0x0067
            if (r2 == r7) goto L_0x005a
            if (r2 == r6) goto L_0x0049
            if (r2 == r5) goto L_0x0043
            if (r2 == r4) goto L_0x0037
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0037:
            java.lang.Object r9 = r0.L$0
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ CancellationException -> 0x0040 }
            goto L_0x00aa
        L_0x0040:
            r9 = move-exception
            goto L_0x00ab
        L_0x0043:
            java.lang.Object r9 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ CancellationException -> 0x0040 }
            goto L_0x0098
        L_0x0049:
            java.lang.Object r9 = r0.L$1
            io.ktor.client.statement.HttpResponse r9 = (io.ktor.client.statement.HttpResponse) r9
            java.lang.Object r10 = r0.L$0
            io.ktor.client.statement.HttpStatement r10 = (io.ktor.client.statement.HttpStatement) r10
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x0055 }
            goto L_0x008a
        L_0x0055:
            r11 = move-exception
            r8 = r11
            r11 = r9
        L_0x0058:
            r9 = r8
            goto L_0x009d
        L_0x005a:
            java.lang.Object r9 = r0.L$1
            r10 = r9
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            java.lang.Object r9 = r0.L$0
            io.ktor.client.statement.HttpStatement r9 = (io.ktor.client.statement.HttpStatement) r9
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ CancellationException -> 0x0040 }
            goto L_0x0077
        L_0x0067:
            kotlin.ResultKt.throwOnFailure(r11)
            r0.L$0 = r9     // Catch:{ CancellationException -> 0x0040 }
            r0.L$1 = r10     // Catch:{ CancellationException -> 0x0040 }
            r0.label = r7     // Catch:{ CancellationException -> 0x0040 }
            java.lang.Object r11 = r9.d(r0)     // Catch:{ CancellationException -> 0x0040 }
            if (r11 != r1) goto L_0x0077
            return r1
        L_0x0077:
            io.ktor.client.statement.HttpResponse r11 = (io.ktor.client.statement.HttpResponse) r11     // Catch:{ CancellationException -> 0x0040 }
            r0.L$0 = r9     // Catch:{ all -> 0x0099 }
            r0.L$1 = r11     // Catch:{ all -> 0x0099 }
            r0.label = r6     // Catch:{ all -> 0x0099 }
            java.lang.Object r10 = r10.invoke(r11, r0)     // Catch:{ all -> 0x0099 }
            if (r10 != r1) goto L_0x0086
            return r1
        L_0x0086:
            r8 = r10
            r10 = r9
            r9 = r11
            r11 = r8
        L_0x008a:
            r0.L$0 = r11     // Catch:{ CancellationException -> 0x0040 }
            r0.L$1 = r3     // Catch:{ CancellationException -> 0x0040 }
            r0.label = r5     // Catch:{ CancellationException -> 0x0040 }
            java.lang.Object r9 = r10.b(r9, r0)     // Catch:{ CancellationException -> 0x0040 }
            if (r9 != r1) goto L_0x0097
            return r1
        L_0x0097:
            r9 = r11
        L_0x0098:
            return r9
        L_0x0099:
            r10 = move-exception
            r8 = r10
            r10 = r9
            goto L_0x0058
        L_0x009d:
            r0.L$0 = r9     // Catch:{ CancellationException -> 0x0040 }
            r0.L$1 = r3     // Catch:{ CancellationException -> 0x0040 }
            r0.label = r4     // Catch:{ CancellationException -> 0x0040 }
            java.lang.Object r10 = r10.b(r11, r0)     // Catch:{ CancellationException -> 0x0040 }
            if (r10 != r1) goto L_0x00aa
            return r1
        L_0x00aa:
            throw r9     // Catch:{ CancellationException -> 0x0040 }
        L_0x00ab:
            java.lang.Throwable r9 = io.ktor.client.utils.ExceptionUtilsJvmKt.a(r9)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.statement.HttpStatement.c(kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object d(kotlin.coroutines.Continuation r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof io.ktor.client.statement.HttpStatement$executeUnsafe$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            io.ktor.client.statement.HttpStatement$executeUnsafe$1 r0 = (io.ktor.client.statement.HttpStatement$executeUnsafe$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.client.statement.HttpStatement$executeUnsafe$1 r0 = new io.ktor.client.statement.HttpStatement$executeUnsafe$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0033
            if (r2 != r3) goto L_0x002b
            kotlin.ResultKt.throwOnFailure(r5)     // Catch:{ CancellationException -> 0x0029 }
            goto L_0x004c
        L_0x0029:
            r4 = move-exception
            goto L_0x0053
        L_0x002b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0033:
            kotlin.ResultKt.throwOnFailure(r5)
            io.ktor.client.request.HttpRequestBuilder r5 = new io.ktor.client.request.HttpRequestBuilder     // Catch:{ CancellationException -> 0x0029 }
            r5.<init>()     // Catch:{ CancellationException -> 0x0029 }
            io.ktor.client.request.HttpRequestBuilder r2 = r4.f8927a     // Catch:{ CancellationException -> 0x0029 }
            io.ktor.client.request.HttpRequestBuilder r5 = r5.p(r2)     // Catch:{ CancellationException -> 0x0029 }
            io.ktor.client.HttpClient r4 = r4.b     // Catch:{ CancellationException -> 0x0029 }
            r0.label = r3     // Catch:{ CancellationException -> 0x0029 }
            java.lang.Object r5 = r4.a(r5, r0)     // Catch:{ CancellationException -> 0x0029 }
            if (r5 != r1) goto L_0x004c
            return r1
        L_0x004c:
            io.ktor.client.call.HttpClientCall r5 = (io.ktor.client.call.HttpClientCall) r5     // Catch:{ CancellationException -> 0x0029 }
            io.ktor.client.statement.HttpResponse r4 = r5.g()     // Catch:{ CancellationException -> 0x0029 }
            return r4
        L_0x0053:
            java.lang.Throwable r4 = io.ktor.client.utils.ExceptionUtilsJvmKt.a(r4)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.statement.HttpStatement.d(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public String toString() {
        return "HttpStatement[" + this.f8927a.i() + ']';
    }
}
