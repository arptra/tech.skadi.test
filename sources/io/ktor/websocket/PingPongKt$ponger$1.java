package io.ktor.websocket;

import io.ktor.websocket.Frame;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.SendChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nPingPong.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PingPong.kt\nio/ktor/websocket/PingPongKt$ponger$1\n+ 2 Channels.common.kt\nkotlinx/coroutines/channels/ChannelsKt__Channels_commonKt\n*L\n1#1,111:1\n105#2:112\n82#2,6:113\n106#2,2:119\n92#2:121\n88#2,3:122\n*S KotlinDebug\n*F\n+ 1 PingPong.kt\nio/ktor/websocket/PingPongKt$ponger$1\n*L\n30#1:112\n30#1:113,6\n30#1:119,2\n30#1:121\n30#1:122,3\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.PingPongKt$ponger$1", f = "PingPong.kt", i = {0, 1}, l = {119, 32}, m = "invokeSuspend", n = {"$this$consume$iv$iv", "$this$consume$iv$iv"}, s = {"L$1", "L$1"})
public final class PingPongKt$ponger$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Channel<Frame.Ping> $channel;
    final /* synthetic */ SendChannel<Frame.Pong> $outgoing;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PingPongKt$ponger$1(Channel<Frame.Ping> channel, SendChannel<? super Frame.Pong> sendChannel, Continuation<? super PingPongKt$ponger$1> continuation) {
        super(2, continuation);
        this.$channel = channel;
        this.$outgoing = sendChannel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PingPongKt$ponger$1(this.$channel, this.$outgoing, continuation);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x008d, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        kotlinx.coroutines.channels.ChannelsKt.b(r4, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0091, code lost:
        throw r11;
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0053 A[Catch:{ all -> 0x008d }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005f A[Catch:{ all -> 0x008d }] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r10.label
            r2 = 1
            r3 = 2
            if (r1 == 0) goto L_0x0039
            if (r1 == r2) goto L_0x0029
            if (r1 != r3) goto L_0x0021
            java.lang.Object r1 = r10.L$2
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r4 = r10.L$1
            kotlinx.coroutines.channels.ReceiveChannel r4 = (kotlinx.coroutines.channels.ReceiveChannel) r4
            java.lang.Object r5 = r10.L$0
            kotlinx.coroutines.channels.SendChannel r5 = (kotlinx.coroutines.channels.SendChannel) r5
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x001f }
        L_0x001d:
            r11 = r5
            goto L_0x0044
        L_0x001f:
            r10 = move-exception
            goto L_0x008c
        L_0x0021:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0029:
            java.lang.Object r1 = r10.L$2
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r4 = r10.L$1
            kotlinx.coroutines.channels.ReceiveChannel r4 = (kotlinx.coroutines.channels.ReceiveChannel) r4
            java.lang.Object r5 = r10.L$0
            kotlinx.coroutines.channels.SendChannel r5 = (kotlinx.coroutines.channels.SendChannel) r5
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x001f }
            goto L_0x0056
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r11)
            kotlinx.coroutines.channels.Channel<io.ktor.websocket.Frame$Ping> r4 = r10.$channel     // Catch:{ ClosedSendChannelException -> 0x0092 }
            kotlinx.coroutines.channels.SendChannel<io.ktor.websocket.Frame$Pong> r11 = r10.$outgoing     // Catch:{ ClosedSendChannelException -> 0x0092 }
            kotlinx.coroutines.channels.ChannelIterator r1 = r4.iterator()     // Catch:{ all -> 0x001f }
        L_0x0044:
            r10.L$0 = r11     // Catch:{ all -> 0x001f }
            r10.L$1 = r4     // Catch:{ all -> 0x001f }
            r10.L$2 = r1     // Catch:{ all -> 0x001f }
            r10.label = r2     // Catch:{ all -> 0x001f }
            java.lang.Object r5 = r1.a(r10)     // Catch:{ all -> 0x001f }
            if (r5 != r0) goto L_0x0053
            return r0
        L_0x0053:
            r9 = r5
            r5 = r11
            r11 = r9
        L_0x0056:
            java.lang.Boolean r11 = (java.lang.Boolean) r11     // Catch:{ all -> 0x001f }
            boolean r11 = r11.booleanValue()     // Catch:{ all -> 0x001f }
            r6 = 0
            if (r11 == 0) goto L_0x0086
            java.lang.Object r11 = r1.next()     // Catch:{ all -> 0x001f }
            io.ktor.websocket.Frame$Ping r11 = (io.ktor.websocket.Frame.Ping) r11     // Catch:{ all -> 0x001f }
            org.slf4j.Logger r7 = io.ktor.websocket.DefaultWebSocketSessionKt.e()     // Catch:{ all -> 0x001f }
            java.lang.String r8 = "Received ping message, sending pong message"
            r7.trace(r8)     // Catch:{ all -> 0x001f }
            io.ktor.websocket.Frame$Pong r7 = new io.ktor.websocket.Frame$Pong     // Catch:{ all -> 0x001f }
            byte[] r11 = r11.b()     // Catch:{ all -> 0x001f }
            r7.<init>(r11, r6, r3, r6)     // Catch:{ all -> 0x001f }
            r10.L$0 = r5     // Catch:{ all -> 0x001f }
            r10.L$1 = r4     // Catch:{ all -> 0x001f }
            r10.L$2 = r1     // Catch:{ all -> 0x001f }
            r10.label = r3     // Catch:{ all -> 0x001f }
            java.lang.Object r11 = r5.L(r7, r10)     // Catch:{ all -> 0x001f }
            if (r11 != r0) goto L_0x001d
            return r0
        L_0x0086:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x001f }
            kotlinx.coroutines.channels.ChannelsKt.b(r4, r6)     // Catch:{ ClosedSendChannelException -> 0x0092 }
            goto L_0x0092
        L_0x008c:
            throw r10     // Catch:{ all -> 0x008d }
        L_0x008d:
            r11 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.b(r4, r10)     // Catch:{ ClosedSendChannelException -> 0x0092 }
            throw r11     // Catch:{ ClosedSendChannelException -> 0x0092 }
        L_0x0092:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.PingPongKt$ponger$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((PingPongKt$ponger$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
