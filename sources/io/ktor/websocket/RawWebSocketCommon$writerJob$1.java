package io.ktor.websocket;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.RawWebSocketCommon$writerJob$1", f = "RawWebSocketCommon.kt", i = {1}, l = {58, 60}, m = "invokeSuspend", n = {"message"}, s = {"L$0"})
final class RawWebSocketCommon$writerJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ RawWebSocketCommon this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RawWebSocketCommon$writerJob$1(RawWebSocketCommon rawWebSocketCommon, Continuation<? super RawWebSocketCommon$writerJob$1> continuation) {
        super(2, continuation);
        this.this$0 = rawWebSocketCommon;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RawWebSocketCommon$writerJob$1(this.this$0, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x005b A[Catch:{ ChannelWriteException -> 0x001a, all -> 0x0017, all -> 0x00b5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0069 A[Catch:{ ChannelWriteException -> 0x001a, all -> 0x0017, all -> 0x00b5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x008d A[Catch:{ ChannelWriteException -> 0x001a, all -> 0x0017, all -> 0x00b5 }] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 2
            r3 = 1
            java.lang.String r4 = "WebSocket closed."
            r5 = 0
            if (r1 == 0) goto L_0x0029
            if (r1 == r3) goto L_0x0025
            if (r1 != r2) goto L_0x001d
            java.lang.Object r1 = r8.L$0
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ ChannelWriteException -> 0x001a, all -> 0x0017 }
            goto L_0x005c
        L_0x0017:
            r9 = move-exception
            goto L_0x00ab
        L_0x001a:
            r9 = move-exception
            goto L_0x00b7
        L_0x001d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0025:
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ ChannelWriteException -> 0x001a, all -> 0x0017 }
            goto L_0x003d
        L_0x0029:
            kotlin.ResultKt.throwOnFailure(r9)
        L_0x002c:
            io.ktor.websocket.RawWebSocketCommon r9 = r8.this$0     // Catch:{ ChannelWriteException -> 0x001a, all -> 0x0017 }
            kotlinx.coroutines.channels.Channel r9 = r9.f     // Catch:{ ChannelWriteException -> 0x001a, all -> 0x0017 }
            r8.L$0 = r5     // Catch:{ ChannelWriteException -> 0x001a, all -> 0x0017 }
            r8.label = r3     // Catch:{ ChannelWriteException -> 0x001a, all -> 0x0017 }
            java.lang.Object r9 = r9.K(r8)     // Catch:{ ChannelWriteException -> 0x001a, all -> 0x0017 }
            if (r9 != r0) goto L_0x003d
            return r0
        L_0x003d:
            boolean r1 = r9 instanceof io.ktor.websocket.Frame     // Catch:{ ChannelWriteException -> 0x001a, all -> 0x0017 }
            if (r1 == 0) goto L_0x0089
            io.ktor.websocket.RawWebSocketCommon r1 = r8.this$0     // Catch:{ ChannelWriteException -> 0x001a, all -> 0x0017 }
            io.ktor.utils.io.ByteWriteChannel r1 = r1.b     // Catch:{ ChannelWriteException -> 0x001a, all -> 0x0017 }
            r6 = r9
            io.ktor.websocket.Frame r6 = (io.ktor.websocket.Frame) r6     // Catch:{ ChannelWriteException -> 0x001a, all -> 0x0017 }
            io.ktor.websocket.RawWebSocketCommon r7 = r8.this$0     // Catch:{ ChannelWriteException -> 0x001a, all -> 0x0017 }
            boolean r7 = r7.h()     // Catch:{ ChannelWriteException -> 0x001a, all -> 0x0017 }
            r8.L$0 = r9     // Catch:{ ChannelWriteException -> 0x001a, all -> 0x0017 }
            r8.label = r2     // Catch:{ ChannelWriteException -> 0x001a, all -> 0x0017 }
            java.lang.Object r1 = io.ktor.websocket.RawWebSocketCommonKt.c(r1, r6, r7, r8)     // Catch:{ ChannelWriteException -> 0x001a, all -> 0x0017 }
            if (r1 != r0) goto L_0x005b
            return r0
        L_0x005b:
            r1 = r9
        L_0x005c:
            io.ktor.websocket.RawWebSocketCommon r9 = r8.this$0     // Catch:{ ChannelWriteException -> 0x001a, all -> 0x0017 }
            io.ktor.utils.io.ByteWriteChannel r9 = r9.b     // Catch:{ ChannelWriteException -> 0x001a, all -> 0x0017 }
            r9.flush()     // Catch:{ ChannelWriteException -> 0x001a, all -> 0x0017 }
            boolean r9 = r1 instanceof io.ktor.websocket.Frame.Close     // Catch:{ ChannelWriteException -> 0x001a, all -> 0x0017 }
            if (r9 == 0) goto L_0x002c
            io.ktor.websocket.RawWebSocketCommon r9 = r8.this$0     // Catch:{ ChannelWriteException -> 0x001a, all -> 0x0017 }
            kotlinx.coroutines.channels.Channel r9 = r9.f     // Catch:{ ChannelWriteException -> 0x001a, all -> 0x0017 }
            kotlinx.coroutines.channels.SendChannel.DefaultImpls.a(r9, r5, r3, r5)     // Catch:{ ChannelWriteException -> 0x001a, all -> 0x0017 }
        L_0x0072:
            io.ktor.websocket.RawWebSocketCommon r9 = r8.this$0
            kotlinx.coroutines.channels.Channel r9 = r9.f
            java.util.concurrent.CancellationException r0 = kotlinx.coroutines.ExceptionsKt.a(r4, r5)
            r9.h(r0)
            io.ktor.websocket.RawWebSocketCommon r9 = r8.this$0
            io.ktor.utils.io.ByteWriteChannel r9 = r9.b
            io.ktor.utils.io.ByteWriteChannelKt.a(r9)
            goto L_0x00c7
        L_0x0089:
            boolean r1 = r9 instanceof io.ktor.websocket.RawWebSocketCommon.FlushRequest     // Catch:{ ChannelWriteException -> 0x001a, all -> 0x0017 }
            if (r1 == 0) goto L_0x0093
            io.ktor.websocket.RawWebSocketCommon$FlushRequest r9 = (io.ktor.websocket.RawWebSocketCommon.FlushRequest) r9     // Catch:{ ChannelWriteException -> 0x001a, all -> 0x0017 }
            r9.b()     // Catch:{ ChannelWriteException -> 0x001a, all -> 0x0017 }
            goto L_0x002c
        L_0x0093:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ ChannelWriteException -> 0x001a, all -> 0x0017 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ ChannelWriteException -> 0x001a, all -> 0x0017 }
            r1.<init>()     // Catch:{ ChannelWriteException -> 0x001a, all -> 0x0017 }
            java.lang.String r2 = "unknown message "
            r1.append(r2)     // Catch:{ ChannelWriteException -> 0x001a, all -> 0x0017 }
            r1.append(r9)     // Catch:{ ChannelWriteException -> 0x001a, all -> 0x0017 }
            java.lang.String r9 = r1.toString()     // Catch:{ ChannelWriteException -> 0x001a, all -> 0x0017 }
            r0.<init>(r9)     // Catch:{ ChannelWriteException -> 0x001a, all -> 0x0017 }
            throw r0     // Catch:{ ChannelWriteException -> 0x001a, all -> 0x0017 }
        L_0x00ab:
            io.ktor.websocket.RawWebSocketCommon r0 = r8.this$0     // Catch:{ all -> 0x00b5 }
            kotlinx.coroutines.channels.Channel r0 = r0.f     // Catch:{ all -> 0x00b5 }
            r0.h(r9)     // Catch:{ all -> 0x00b5 }
            goto L_0x0072
        L_0x00b5:
            r9 = move-exception
            goto L_0x00e4
        L_0x00b7:
            io.ktor.websocket.RawWebSocketCommon r0 = r8.this$0     // Catch:{ all -> 0x00b5 }
            kotlinx.coroutines.channels.Channel r0 = r0.f     // Catch:{ all -> 0x00b5 }
            java.lang.String r1 = "Failed to write to WebSocket."
            java.util.concurrent.CancellationException r9 = kotlinx.coroutines.ExceptionsKt.a(r1, r9)     // Catch:{ all -> 0x00b5 }
            r0.h(r9)     // Catch:{ all -> 0x00b5 }
            goto L_0x0072
        L_0x00c7:
            io.ktor.websocket.RawWebSocketCommon r9 = r8.this$0
            kotlinx.coroutines.channels.Channel r9 = r9.f
            java.lang.Object r9 = r9.x()
            java.lang.Object r9 = kotlinx.coroutines.channels.ChannelResult.f(r9)
            if (r9 != 0) goto L_0x00da
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L_0x00da:
            boolean r0 = r9 instanceof io.ktor.websocket.RawWebSocketCommon.FlushRequest
            if (r0 == 0) goto L_0x00c7
            io.ktor.websocket.RawWebSocketCommon$FlushRequest r9 = (io.ktor.websocket.RawWebSocketCommon.FlushRequest) r9
            r9.b()
            goto L_0x00c7
        L_0x00e4:
            io.ktor.websocket.RawWebSocketCommon r0 = r8.this$0
            kotlinx.coroutines.channels.Channel r0 = r0.f
            java.util.concurrent.CancellationException r1 = kotlinx.coroutines.ExceptionsKt.a(r4, r5)
            r0.h(r1)
            io.ktor.websocket.RawWebSocketCommon r8 = r8.this$0
            io.ktor.utils.io.ByteWriteChannel r8 = r8.b
            io.ktor.utils.io.ByteWriteChannelKt.a(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.RawWebSocketCommon$writerJob$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RawWebSocketCommon$writerJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
