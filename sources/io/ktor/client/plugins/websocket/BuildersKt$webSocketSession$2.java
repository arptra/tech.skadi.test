package io.ktor.client.plugins.websocket;

import io.ktor.client.statement.HttpStatement;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nbuilders.kt\nKotlin\n*S Kotlin\n*F\n+ 1 builders.kt\nio/ktor/client/plugins/websocket/BuildersKt$webSocketSession$2\n+ 2 HttpStatement.kt\nio/ktor/client/statement/HttpStatement\n+ 3 HttpTimeout.kt\nio/ktor/client/plugins/HttpTimeoutKt\n+ 4 HttpClientCall.kt\nio/ktor/client/call/HttpClientCallKt\n+ 5 TypeInfoJvm.kt\nio/ktor/util/reflect/TypeInfoJvmKt\n*L\n1#1,236:1\n90#2:237\n91#2,3:240\n94#2,3:247\n269#3,2:238\n271#3,2:250\n156#4:243\n17#5,3:244\n*S KotlinDebug\n*F\n+ 1 builders.kt\nio/ktor/client/plugins/websocket/BuildersKt$webSocketSession$2\n*L\n41#1:237\n41#1:240,3\n41#1:247,3\n41#1:238,2\n41#1:250,2\n41#1:243\n41#1:244,3\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.websocket.BuildersKt$webSocketSession$2", f = "builders.kt", i = {0, 1, 1, 2, 2}, l = {240, 243, 49, 249, 249}, m = "invokeSuspend", n = {"this_$iv", "this_$iv", "response$iv", "this_$iv", "response$iv"}, s = {"L$0", "L$0", "L$2", "L$0", "L$1"})
final class BuildersKt$webSocketSession$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CompletableDeferred<DefaultClientWebSocketSession> $sessionDeferred;
    final /* synthetic */ HttpStatement $statement;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BuildersKt$webSocketSession$2(HttpStatement httpStatement, CompletableDeferred<DefaultClientWebSocketSession> completableDeferred, Continuation<? super BuildersKt$webSocketSession$2> continuation) {
        super(2, continuation);
        this.$statement = httpStatement;
        this.$sessionDeferred = completableDeferred;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new BuildersKt$webSocketSession$2(this.$statement, this.$sessionDeferred, continuation);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002b, code lost:
        r15 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002e, code lost:
        r15 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0104, code lost:
        throw io.ktor.client.utils.ExceptionUtilsJvmKt.a(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0105, code lost:
        r14.$sessionDeferred.d(r15);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:10:0x0026, B:32:0x0072] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00b3 A[SYNTHETIC, Splitter:B:46:0x00b3] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00e6 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00e7 A[SYNTHETIC, Splitter:B:57:0x00e7] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00fe A[Catch:{ CancellationException -> 0x002e, all -> 0x002b }, RETURN] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.Class<io.ktor.client.plugins.websocket.DefaultClientWebSocketSession> r0 = io.ktor.client.plugins.websocket.DefaultClientWebSocketSession.class
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r14.label
            r3 = 5
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            r8 = 0
            if (r2 == 0) goto L_0x006f
            if (r2 == r7) goto L_0x0060
            if (r2 == r6) goto L_0x004d
            if (r2 == r5) goto L_0x003a
            if (r2 == r4) goto L_0x0031
            if (r2 == r3) goto L_0x0022
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L_0x0022:
            java.lang.Object r0 = r14.L$0
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ CancellationException -> 0x002e }
            goto L_0x00ff
        L_0x002b:
            r15 = move-exception
            goto L_0x0105
        L_0x002e:
            r15 = move-exception
            goto L_0x0100
        L_0x0031:
            java.lang.Object r0 = r14.L$0
            kotlin.Unit r0 = (kotlin.Unit) r0
            kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ CancellationException -> 0x002e }
            goto L_0x010a
        L_0x003a:
            java.lang.Object r0 = r14.L$1
            io.ktor.client.statement.HttpResponse r0 = (io.ktor.client.statement.HttpResponse) r0
            java.lang.Object r2 = r14.L$0
            io.ktor.client.statement.HttpStatement r2 = (io.ktor.client.statement.HttpStatement) r2
            kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ all -> 0x0047 }
            goto L_0x00d8
        L_0x0047:
            r15 = move-exception
        L_0x0048:
            r13 = r0
            r0 = r15
            r15 = r13
            goto L_0x00f0
        L_0x004d:
            java.lang.Object r0 = r14.L$2
            io.ktor.client.statement.HttpResponse r0 = (io.ktor.client.statement.HttpResponse) r0
            java.lang.Object r2 = r14.L$1
            kotlinx.coroutines.CompletableDeferred r2 = (kotlinx.coroutines.CompletableDeferred) r2
            java.lang.Object r6 = r14.L$0
            io.ktor.client.statement.HttpStatement r6 = (io.ktor.client.statement.HttpStatement) r6
            kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ all -> 0x005d }
            goto L_0x00b1
        L_0x005d:
            r15 = move-exception
            r2 = r6
            goto L_0x0048
        L_0x0060:
            java.lang.Object r2 = r14.L$1
            kotlinx.coroutines.CompletableDeferred r2 = (kotlinx.coroutines.CompletableDeferred) r2
            java.lang.Object r9 = r14.L$0
            io.ktor.client.statement.HttpStatement r9 = (io.ktor.client.statement.HttpStatement) r9
            kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ CancellationException -> 0x002e }
            r13 = r9
            r9 = r2
            r2 = r13
            goto L_0x0087
        L_0x006f:
            kotlin.ResultKt.throwOnFailure(r15)
            io.ktor.client.statement.HttpStatement r15 = r14.$statement     // Catch:{ all -> 0x002b }
            kotlinx.coroutines.CompletableDeferred<io.ktor.client.plugins.websocket.DefaultClientWebSocketSession> r2 = r14.$sessionDeferred     // Catch:{ all -> 0x002b }
            r14.L$0 = r15     // Catch:{ CancellationException -> 0x002e }
            r14.L$1 = r2     // Catch:{ CancellationException -> 0x002e }
            r14.label = r7     // Catch:{ CancellationException -> 0x002e }
            java.lang.Object r9 = r15.d(r14)     // Catch:{ CancellationException -> 0x002e }
            if (r9 != r1) goto L_0x0083
            return r1
        L_0x0083:
            r13 = r2
            r2 = r15
            r15 = r9
            r9 = r13
        L_0x0087:
            io.ktor.client.statement.HttpResponse r15 = (io.ktor.client.statement.HttpResponse) r15     // Catch:{ CancellationException -> 0x002e }
            io.ktor.client.call.HttpClientCall r10 = r15.p0()     // Catch:{ all -> 0x00ef }
            kotlin.reflect.KType r11 = kotlin.jvm.internal.Reflection.typeOf((java.lang.Class) r0)     // Catch:{ all -> 0x00ef }
            java.lang.reflect.Type r12 = kotlin.reflect.TypesJVMKt.getJavaType((kotlin.reflect.KType) r11)     // Catch:{ all -> 0x00ef }
            kotlin.reflect.KClass r0 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r0)     // Catch:{ all -> 0x00ef }
            io.ktor.util.reflect.TypeInfo r0 = io.ktor.util.reflect.TypeInfoJvmKt.b(r12, r0, r11)     // Catch:{ all -> 0x00ef }
            r14.L$0 = r2     // Catch:{ all -> 0x00ef }
            r14.L$1 = r9     // Catch:{ all -> 0x00ef }
            r14.L$2 = r15     // Catch:{ all -> 0x00ef }
            r14.label = r6     // Catch:{ all -> 0x00ef }
            java.lang.Object r0 = r10.c(r0, r14)     // Catch:{ all -> 0x00ef }
            if (r0 != r1) goto L_0x00ac
            return r1
        L_0x00ac:
            r6 = r2
            r2 = r9
            r13 = r0
            r0 = r15
            r15 = r13
        L_0x00b1:
            if (r15 == 0) goto L_0x00e7
            io.ktor.client.plugins.websocket.DefaultClientWebSocketSession r15 = (io.ktor.client.plugins.websocket.DefaultClientWebSocketSession) r15     // Catch:{ all -> 0x005d }
            kotlinx.coroutines.CompletableDeferred r7 = kotlinx.coroutines.CompletableDeferredKt.c(r8, r7, r8)     // Catch:{ all -> 0x005d }
            r2.w(r15)     // Catch:{ all -> 0x005d }
            kotlinx.coroutines.channels.SendChannel r15 = r15.o()     // Catch:{ all -> 0x005d }
            io.ktor.client.plugins.websocket.BuildersKt$webSocketSession$2$1$1 r2 = new io.ktor.client.plugins.websocket.BuildersKt$webSocketSession$2$1$1     // Catch:{ all -> 0x005d }
            r2.<init>(r7)     // Catch:{ all -> 0x005d }
            r15.p(r2)     // Catch:{ all -> 0x005d }
            r14.L$0 = r6     // Catch:{ all -> 0x005d }
            r14.L$1 = r0     // Catch:{ all -> 0x005d }
            r14.L$2 = r8     // Catch:{ all -> 0x005d }
            r14.label = r5     // Catch:{ all -> 0x005d }
            java.lang.Object r15 = r7.c(r14)     // Catch:{ all -> 0x005d }
            if (r15 != r1) goto L_0x00d7
            return r1
        L_0x00d7:
            r2 = r6
        L_0x00d8:
            kotlin.Unit r15 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0047 }
            r14.L$0 = r15     // Catch:{ CancellationException -> 0x002e }
            r14.L$1 = r8     // Catch:{ CancellationException -> 0x002e }
            r14.label = r4     // Catch:{ CancellationException -> 0x002e }
            java.lang.Object r14 = r2.b(r0, r14)     // Catch:{ CancellationException -> 0x002e }
            if (r14 != r1) goto L_0x010a
            return r1
        L_0x00e7:
            java.lang.NullPointerException r15 = new java.lang.NullPointerException     // Catch:{ all -> 0x005d }
            java.lang.String r2 = "null cannot be cast to non-null type io.ktor.client.plugins.websocket.DefaultClientWebSocketSession"
            r15.<init>(r2)     // Catch:{ all -> 0x005d }
            throw r15     // Catch:{ all -> 0x005d }
        L_0x00ef:
            r0 = move-exception
        L_0x00f0:
            r14.L$0 = r0     // Catch:{ CancellationException -> 0x002e }
            r14.L$1 = r8     // Catch:{ CancellationException -> 0x002e }
            r14.L$2 = r8     // Catch:{ CancellationException -> 0x002e }
            r14.label = r3     // Catch:{ CancellationException -> 0x002e }
            java.lang.Object r15 = r2.b(r15, r14)     // Catch:{ CancellationException -> 0x002e }
            if (r15 != r1) goto L_0x00ff
            return r1
        L_0x00ff:
            throw r0     // Catch:{ CancellationException -> 0x002e }
        L_0x0100:
            java.lang.Throwable r15 = io.ktor.client.utils.ExceptionUtilsJvmKt.a(r15)     // Catch:{ all -> 0x002b }
            throw r15     // Catch:{ all -> 0x002b }
        L_0x0105:
            kotlinx.coroutines.CompletableDeferred<io.ktor.client.plugins.websocket.DefaultClientWebSocketSession> r14 = r14.$sessionDeferred
            r14.d(r15)
        L_0x010a:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.websocket.BuildersKt$webSocketSession$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((BuildersKt$webSocketSession$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
