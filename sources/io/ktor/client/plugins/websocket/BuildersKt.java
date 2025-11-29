package io.ktor.client.plugins.websocket;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u001aY\u0010\u000b\u001a\u00020\u0003*\u00020\u00002\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u00042'\u0010\n\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006¢\u0006\u0002\b\u0004H@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lio/ktor/client/HttpClient;", "Lkotlin/Function1;", "Lio/ktor/client/request/HttpRequestBuilder;", "", "Lkotlin/ExtensionFunctionType;", "request", "Lkotlin/Function2;", "Lio/ktor/client/plugins/websocket/DefaultClientWebSocketSession;", "Lkotlin/coroutines/Continuation;", "", "block", "a", "(Lio/ktor/client/HttpClient;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-client-core"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nbuilders.kt\nKotlin\n*S Kotlin\n*F\n+ 1 builders.kt\nio/ktor/client/plugins/websocket/BuildersKt\n+ 2 builders.kt\nio/ktor/client/request/BuildersKt\n+ 3 HttpStatement.kt\nio/ktor/client/statement/HttpStatement\n+ 4 HttpTimeout.kt\nio/ktor/client/plugins/HttpTimeoutKt\n+ 5 HttpClientCall.kt\nio/ktor/client/call/HttpClientCallKt\n+ 6 TypeInfoJvm.kt\nio/ktor/util/reflect/TypeInfoJvmKt\n*L\n1#1,236:1\n43#2:237\n29#2:238\n43#2:239\n29#2:240\n90#3:241\n91#3,3:244\n94#3,3:251\n269#4,2:242\n271#4,2:254\n156#5:247\n17#6,3:248\n*S KotlinDebug\n*F\n+ 1 builders.kt\nio/ktor/client/plugins/websocket/BuildersKt\n*L\n31#1:237\n31#1:238\n92#1:239\n92#1:240\n99#1:241\n99#1:244,3\n99#1:251,3\n99#1:242,2\n99#1:254,2\n99#1:247\n99#1:248,3\n*E\n"})
public final class BuildersKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v10, resolved type: kotlin.jvm.functions.Function2} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v23, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v12, resolved type: io.ktor.client.statement.HttpResponse} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v24, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: io.ktor.client.statement.HttpStatement} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v18, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v18, resolved type: io.ktor.client.statement.HttpResponse} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v19, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: io.ktor.client.statement.HttpStatement} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00d0, code lost:
        r8 = (io.ktor.client.statement.HttpResponse) r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        r10 = r8.p0();
        r3 = kotlin.jvm.internal.Reflection.typeOf((java.lang.Class) r0);
        r0 = io.ktor.util.reflect.TypeInfoJvmKt.b(kotlin.reflect.TypesJVMKt.getJavaType(r3), kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r0), r3);
        r1.L$0 = r9;
        r1.L$1 = r7;
        r1.L$2 = r8;
        r1.label = 2;
        r10 = r10.c(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00f4, code lost:
        if (r10 != r2) goto L_0x00f7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00f6, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00f7, code lost:
        r0 = r7;
        r7 = r9;
        r9 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00fa, code lost:
        if (r10 == null) goto L_0x0157;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        r10 = (io.ktor.client.plugins.websocket.DefaultClientWebSocketSession) r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        r1.L$0 = r0;
        r1.L$1 = r9;
        r1.L$2 = r10;
        r1.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x010b, code lost:
        if (r7.invoke(r10, r1) != r2) goto L_0x010e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x010d, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x010e, code lost:
        r7 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        r1.L$0 = r0;
        r1.L$1 = r9;
        r1.L$2 = r7;
        r1.label = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x011c, code lost:
        if (io.ktor.websocket.WebSocketSessionKt.b(r7, (io.ktor.websocket.CloseReason) null, r1, 1, (java.lang.Object) null) != r2) goto L_0x011f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x011e, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x011f, code lost:
        kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.a(r7.i(), (java.util.concurrent.CancellationException) null, 1, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
        r1.L$0 = kotlin.Unit.INSTANCE;
        r1.L$1 = null;
        r1.L$2 = null;
        r1.label = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0135, code lost:
        if (r0.b(r9, r1) != r2) goto L_0x0138;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0137, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x013a, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x013b, code lost:
        r7 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x013c, code lost:
        r8 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x015e, code lost:
        throw new java.lang.NullPointerException("null cannot be cast to non-null type io.ktor.client.plugins.websocket.DefaultClientWebSocketSession");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x015f, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0160, code lost:
        r0 = r7;
        r7 = r9;
        r9 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:?, code lost:
        r1.L$0 = r7;
        r1.L$1 = null;
        r1.L$2 = null;
        r1.L$3 = null;
        r1.label = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0172, code lost:
        if (r0.b(r9, r1) == r2) goto L_0x0174;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0174, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0175, code lost:
        throw r7;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x014e A[Catch:{ all -> 0x0059 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:69:0x013d=Splitter:B:69:0x013d, B:56:0x010f=Splitter:B:56:0x010f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object a(io.ktor.client.HttpClient r7, kotlin.jvm.functions.Function1 r8, kotlin.jvm.functions.Function2 r9, kotlin.coroutines.Continuation r10) {
        /*
            java.lang.Class<io.ktor.client.plugins.websocket.DefaultClientWebSocketSession> r0 = io.ktor.client.plugins.websocket.DefaultClientWebSocketSession.class
            boolean r1 = r10 instanceof io.ktor.client.plugins.websocket.BuildersKt$webSocket$1
            if (r1 == 0) goto L_0x0015
            r1 = r10
            io.ktor.client.plugins.websocket.BuildersKt$webSocket$1 r1 = (io.ktor.client.plugins.websocket.BuildersKt$webSocket$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0015
            int r2 = r2 - r3
            r1.label = r2
            goto L_0x001a
        L_0x0015:
            io.ktor.client.plugins.websocket.BuildersKt$webSocket$1 r1 = new io.ktor.client.plugins.websocket.BuildersKt$webSocket$1
            r1.<init>(r10)
        L_0x001a:
            java.lang.Object r10 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r4 = 1
            r5 = 0
            switch(r3) {
                case 0: goto L_0x00a8;
                case 1: goto L_0x009b;
                case 2: goto L_0x0089;
                case 3: goto L_0x006f;
                case 4: goto L_0x005c;
                case 5: goto L_0x0044;
                case 6: goto L_0x003b;
                case 7: goto L_0x002f;
                default: goto L_0x0027;
            }
        L_0x0027:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x002f:
            java.lang.Object r7 = r1.L$0
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ CancellationException -> 0x0038 }
            goto L_0x0175
        L_0x0038:
            r7 = move-exception
            goto L_0x0176
        L_0x003b:
            java.lang.Object r7 = r1.L$0
            kotlin.Unit r7 = (kotlin.Unit) r7
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ CancellationException -> 0x0038 }
            goto L_0x0138
        L_0x0044:
            java.lang.Object r7 = r1.L$3
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            java.lang.Object r8 = r1.L$2
            io.ktor.client.plugins.websocket.DefaultClientWebSocketSession r8 = (io.ktor.client.plugins.websocket.DefaultClientWebSocketSession) r8
            java.lang.Object r9 = r1.L$1
            io.ktor.client.statement.HttpResponse r9 = (io.ktor.client.statement.HttpResponse) r9
            java.lang.Object r0 = r1.L$0
            io.ktor.client.statement.HttpStatement r0 = (io.ktor.client.statement.HttpStatement) r0
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x0059 }
            goto L_0x014f
        L_0x0059:
            r7 = move-exception
            goto L_0x0163
        L_0x005c:
            java.lang.Object r7 = r1.L$2
            io.ktor.client.plugins.websocket.DefaultClientWebSocketSession r7 = (io.ktor.client.plugins.websocket.DefaultClientWebSocketSession) r7
            java.lang.Object r8 = r1.L$1
            r9 = r8
            io.ktor.client.statement.HttpResponse r9 = (io.ktor.client.statement.HttpResponse) r9
            java.lang.Object r8 = r1.L$0
            r0 = r8
            io.ktor.client.statement.HttpStatement r0 = (io.ktor.client.statement.HttpStatement) r0
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x0059 }
            goto L_0x011f
        L_0x006f:
            java.lang.Object r7 = r1.L$2
            io.ktor.client.plugins.websocket.DefaultClientWebSocketSession r7 = (io.ktor.client.plugins.websocket.DefaultClientWebSocketSession) r7
            java.lang.Object r8 = r1.L$1
            io.ktor.client.statement.HttpResponse r8 = (io.ktor.client.statement.HttpResponse) r8
            java.lang.Object r9 = r1.L$0
            io.ktor.client.statement.HttpStatement r9 = (io.ktor.client.statement.HttpStatement) r9
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x0082 }
            r0 = r9
            r9 = r8
            goto L_0x010f
        L_0x0082:
            r10 = move-exception
            r0 = r9
            r9 = r8
            r8 = r7
            r7 = r10
            goto L_0x013d
        L_0x0089:
            java.lang.Object r7 = r1.L$2
            r9 = r7
            io.ktor.client.statement.HttpResponse r9 = (io.ktor.client.statement.HttpResponse) r9
            java.lang.Object r7 = r1.L$1
            r0 = r7
            io.ktor.client.statement.HttpStatement r0 = (io.ktor.client.statement.HttpStatement) r0
            java.lang.Object r7 = r1.L$0
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x0059 }
            goto L_0x00fa
        L_0x009b:
            java.lang.Object r7 = r1.L$1
            io.ktor.client.statement.HttpStatement r7 = (io.ktor.client.statement.HttpStatement) r7
            java.lang.Object r8 = r1.L$0
            r9 = r8
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ CancellationException -> 0x0038 }
            goto L_0x00d0
        L_0x00a8:
            kotlin.ResultKt.throwOnFailure(r10)
            io.ktor.client.plugins.websocket.WebSockets$Plugin r10 = io.ktor.client.plugins.websocket.WebSockets.e
            io.ktor.client.plugins.HttpClientPluginKt.b(r7, r10)
            io.ktor.client.request.HttpRequestBuilder r10 = new io.ktor.client.request.HttpRequestBuilder
            r10.<init>()
            io.ktor.client.plugins.websocket.BuildersKt$webSocket$session$1$1 r3 = io.ktor.client.plugins.websocket.BuildersKt$webSocket$session$1$1.INSTANCE
            r10.q(r3)
            r8.invoke(r10)
            io.ktor.client.statement.HttpStatement r8 = new io.ktor.client.statement.HttpStatement
            r8.<init>(r10, r7)
            r1.L$0 = r9     // Catch:{ CancellationException -> 0x0038 }
            r1.L$1 = r8     // Catch:{ CancellationException -> 0x0038 }
            r1.label = r4     // Catch:{ CancellationException -> 0x0038 }
            java.lang.Object r10 = r8.d(r1)     // Catch:{ CancellationException -> 0x0038 }
            if (r10 != r2) goto L_0x00cf
            return r2
        L_0x00cf:
            r7 = r8
        L_0x00d0:
            r8 = r10
            io.ktor.client.statement.HttpResponse r8 = (io.ktor.client.statement.HttpResponse) r8     // Catch:{ CancellationException -> 0x0038 }
            io.ktor.client.call.HttpClientCall r10 = r8.p0()     // Catch:{ all -> 0x015f }
            kotlin.reflect.KType r3 = kotlin.jvm.internal.Reflection.typeOf((java.lang.Class) r0)     // Catch:{ all -> 0x015f }
            java.lang.reflect.Type r6 = kotlin.reflect.TypesJVMKt.getJavaType((kotlin.reflect.KType) r3)     // Catch:{ all -> 0x015f }
            kotlin.reflect.KClass r0 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r0)     // Catch:{ all -> 0x015f }
            io.ktor.util.reflect.TypeInfo r0 = io.ktor.util.reflect.TypeInfoJvmKt.b(r6, r0, r3)     // Catch:{ all -> 0x015f }
            r1.L$0 = r9     // Catch:{ all -> 0x015f }
            r1.L$1 = r7     // Catch:{ all -> 0x015f }
            r1.L$2 = r8     // Catch:{ all -> 0x015f }
            r3 = 2
            r1.label = r3     // Catch:{ all -> 0x015f }
            java.lang.Object r10 = r10.c(r0, r1)     // Catch:{ all -> 0x015f }
            if (r10 != r2) goto L_0x00f7
            return r2
        L_0x00f7:
            r0 = r7
            r7 = r9
            r9 = r8
        L_0x00fa:
            if (r10 == 0) goto L_0x0157
            io.ktor.client.plugins.websocket.DefaultClientWebSocketSession r10 = (io.ktor.client.plugins.websocket.DefaultClientWebSocketSession) r10     // Catch:{ all -> 0x0059 }
            r1.L$0 = r0     // Catch:{ all -> 0x013b }
            r1.L$1 = r9     // Catch:{ all -> 0x013b }
            r1.L$2 = r10     // Catch:{ all -> 0x013b }
            r8 = 3
            r1.label = r8     // Catch:{ all -> 0x013b }
            java.lang.Object r7 = r7.invoke(r10, r1)     // Catch:{ all -> 0x013b }
            if (r7 != r2) goto L_0x010e
            return r2
        L_0x010e:
            r7 = r10
        L_0x010f:
            r1.L$0 = r0     // Catch:{ all -> 0x0059 }
            r1.L$1 = r9     // Catch:{ all -> 0x0059 }
            r1.L$2 = r7     // Catch:{ all -> 0x0059 }
            r8 = 4
            r1.label = r8     // Catch:{ all -> 0x0059 }
            java.lang.Object r8 = io.ktor.websocket.WebSocketSessionKt.b(r7, r5, r1, r4, r5)     // Catch:{ all -> 0x0059 }
            if (r8 != r2) goto L_0x011f
            return r2
        L_0x011f:
            kotlinx.coroutines.channels.ReceiveChannel r7 = r7.i()     // Catch:{ all -> 0x0059 }
            kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.a(r7, r5, r4, r5)     // Catch:{ all -> 0x0059 }
            kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0059 }
            r1.L$0 = r7     // Catch:{ CancellationException -> 0x0038 }
            r1.L$1 = r5     // Catch:{ CancellationException -> 0x0038 }
            r1.L$2 = r5     // Catch:{ CancellationException -> 0x0038 }
            r7 = 6
            r1.label = r7     // Catch:{ CancellationException -> 0x0038 }
            java.lang.Object r7 = r0.b(r9, r1)     // Catch:{ CancellationException -> 0x0038 }
            if (r7 != r2) goto L_0x0138
            return r2
        L_0x0138:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L_0x013b:
            r7 = move-exception
            r8 = r10
        L_0x013d:
            r1.L$0 = r0     // Catch:{ all -> 0x0059 }
            r1.L$1 = r9     // Catch:{ all -> 0x0059 }
            r1.L$2 = r8     // Catch:{ all -> 0x0059 }
            r1.L$3 = r7     // Catch:{ all -> 0x0059 }
            r10 = 5
            r1.label = r10     // Catch:{ all -> 0x0059 }
            java.lang.Object r10 = io.ktor.websocket.WebSocketSessionKt.b(r8, r5, r1, r4, r5)     // Catch:{ all -> 0x0059 }
            if (r10 != r2) goto L_0x014f
            return r2
        L_0x014f:
            kotlinx.coroutines.channels.ReceiveChannel r8 = r8.i()     // Catch:{ all -> 0x0059 }
            kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.a(r8, r5, r4, r5)     // Catch:{ all -> 0x0059 }
            throw r7     // Catch:{ all -> 0x0059 }
        L_0x0157:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException     // Catch:{ all -> 0x0059 }
            java.lang.String r8 = "null cannot be cast to non-null type io.ktor.client.plugins.websocket.DefaultClientWebSocketSession"
            r7.<init>(r8)     // Catch:{ all -> 0x0059 }
            throw r7     // Catch:{ all -> 0x0059 }
        L_0x015f:
            r9 = move-exception
            r0 = r7
            r7 = r9
            r9 = r8
        L_0x0163:
            r1.L$0 = r7     // Catch:{ CancellationException -> 0x0038 }
            r1.L$1 = r5     // Catch:{ CancellationException -> 0x0038 }
            r1.L$2 = r5     // Catch:{ CancellationException -> 0x0038 }
            r1.L$3 = r5     // Catch:{ CancellationException -> 0x0038 }
            r8 = 7
            r1.label = r8     // Catch:{ CancellationException -> 0x0038 }
            java.lang.Object r8 = r0.b(r9, r1)     // Catch:{ CancellationException -> 0x0038 }
            if (r8 != r2) goto L_0x0175
            return r2
        L_0x0175:
            throw r7     // Catch:{ CancellationException -> 0x0038 }
        L_0x0176:
            java.lang.Throwable r7 = io.ktor.client.utils.ExceptionUtilsJvmKt.a(r7)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.websocket.BuildersKt.a(io.ktor.client.HttpClient, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
