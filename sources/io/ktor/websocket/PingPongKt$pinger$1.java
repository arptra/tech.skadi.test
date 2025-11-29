package io.ktor.websocket;

import io.ktor.websocket.Frame;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.SendChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.PingPongKt$pinger$1", f = "PingPong.kt", i = {0, 0, 1, 1}, l = {64, 73, 95}, m = "invokeSuspend", n = {"random", "pingIdBytes", "random", "pingIdBytes"}, s = {"L$0", "L$1", "L$0", "L$1"})
public final class PingPongKt$pinger$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Channel<Frame.Pong> $channel;
    final /* synthetic */ Function2<CloseReason, Continuation<? super Unit>, Object> $onTimeout;
    final /* synthetic */ SendChannel<Frame> $outgoing;
    final /* synthetic */ long $periodMillis;
    final /* synthetic */ long $timeoutMillis;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PingPongKt$pinger$1(long j, long j2, Function2<? super CloseReason, ? super Continuation<? super Unit>, ? extends Object> function2, Channel<Frame.Pong> channel, SendChannel<? super Frame> sendChannel, Continuation<? super PingPongKt$pinger$1> continuation) {
        super(2, continuation);
        this.$periodMillis = j;
        this.$timeoutMillis = j2;
        this.$onTimeout = function2;
        this.$channel = channel;
        this.$outgoing = sendChannel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PingPongKt$pinger$1(this.$periodMillis, this.$timeoutMillis, this.$onTimeout, this.$channel, this.$outgoing, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00bb A[Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00e3 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00c0 A[Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00e0 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00e1  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L_0x0038
            if (r1 == r4) goto L_0x002c
            if (r1 == r3) goto L_0x001f
            if (r1 != r2) goto L_0x0017
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00e3 }
            goto L_0x00e3
        L_0x0017:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x001f:
            java.lang.Object r1 = r12.L$1
            byte[] r1 = (byte[]) r1
            java.lang.Object r6 = r12.L$0
            kotlin.random.Random r6 = (kotlin.random.Random) r6
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00e3 }
            goto L_0x00bc
        L_0x002c:
            java.lang.Object r1 = r12.L$1
            byte[] r1 = (byte[]) r1
            java.lang.Object r6 = r12.L$0
            kotlin.random.Random r6 = (kotlin.random.Random) r6
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00e3 }
            goto L_0x0087
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r13)
            org.slf4j.Logger r13 = io.ktor.websocket.DefaultWebSocketSessionKt.e()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r6 = "Starting WebSocket pinger coroutine with period "
            r1.append(r6)
            long r6 = r12.$periodMillis
            r1.append(r6)
            java.lang.String r6 = " ms and timeout "
            r1.append(r6)
            long r6 = r12.$timeoutMillis
            r1.append(r6)
            java.lang.String r6 = " ms"
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            r13.trace(r1)
            long r6 = io.ktor.util.date.DateJvmKt.d()
            kotlin.random.Random r13 = kotlin.random.RandomKt.Random((long) r6)
            r1 = 32
            byte[] r1 = new byte[r1]
        L_0x0070:
            long r6 = r12.$periodMillis     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00e3 }
            io.ktor.websocket.PingPongKt$pinger$1$1 r8 = new io.ktor.websocket.PingPongKt$pinger$1$1     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00e3 }
            kotlinx.coroutines.channels.Channel<io.ktor.websocket.Frame$Pong> r9 = r12.$channel     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00e3 }
            r8.<init>(r9, r5)     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00e3 }
            r12.L$0 = r13     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00e3 }
            r12.L$1 = r1     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00e3 }
            r12.label = r4     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00e3 }
            java.lang.Object r6 = kotlinx.coroutines.TimeoutKt.d(r6, r8, r12)     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00e3 }
            if (r6 != r0) goto L_0x0086
            return r0
        L_0x0086:
            r6 = r13
        L_0x0087:
            r6.nextBytes((byte[]) r1)     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00e3 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00e3 }
            r13.<init>()     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00e3 }
            java.lang.String r7 = "[ping "
            r13.append(r7)     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00e3 }
            java.lang.String r7 = io.ktor.util.CryptoKt.c(r1)     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00e3 }
            r13.append(r7)     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00e3 }
            java.lang.String r7 = " ping]"
            r13.append(r7)     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00e3 }
            java.lang.String r13 = r13.toString()     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00e3 }
            long r7 = r12.$timeoutMillis     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00e3 }
            io.ktor.websocket.PingPongKt$pinger$1$rc$1 r9 = new io.ktor.websocket.PingPongKt$pinger$1$rc$1     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00e3 }
            kotlinx.coroutines.channels.SendChannel<io.ktor.websocket.Frame> r10 = r12.$outgoing     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00e3 }
            kotlinx.coroutines.channels.Channel<io.ktor.websocket.Frame$Pong> r11 = r12.$channel     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00e3 }
            r9.<init>(r10, r13, r11, r5)     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00e3 }
            r12.L$0 = r6     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00e3 }
            r12.L$1 = r1     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00e3 }
            r12.label = r3     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00e3 }
            java.lang.Object r13 = kotlinx.coroutines.TimeoutKt.d(r7, r9, r12)     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00e3 }
            if (r13 != r0) goto L_0x00bc
            return r0
        L_0x00bc:
            kotlin.Unit r13 = (kotlin.Unit) r13     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00e3 }
            if (r13 != 0) goto L_0x00e1
            org.slf4j.Logger r13 = io.ktor.websocket.DefaultWebSocketSessionKt.e()     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00e3 }
            java.lang.String r1 = "WebSocket pinger has timed out"
            r13.trace(r1)     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00e3 }
            kotlin.jvm.functions.Function2<io.ktor.websocket.CloseReason, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r13 = r12.$onTimeout     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00e3 }
            io.ktor.websocket.CloseReason r1 = new io.ktor.websocket.CloseReason     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00e3 }
            io.ktor.websocket.CloseReason$Codes r3 = io.ktor.websocket.CloseReason.Codes.INTERNAL_ERROR     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00e3 }
            java.lang.String r4 = "Ping timeout"
            r1.<init>((io.ktor.websocket.CloseReason.Codes) r3, (java.lang.String) r4)     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00e3 }
            r12.L$0 = r5     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00e3 }
            r12.L$1 = r5     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00e3 }
            r12.label = r2     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00e3 }
            java.lang.Object r12 = r13.invoke(r1, r12)     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00e3 }
            if (r12 != r0) goto L_0x00e3
            return r0
        L_0x00e1:
            r13 = r6
            goto L_0x0070
        L_0x00e3:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.PingPongKt$pinger$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((PingPongKt$pinger$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
