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

@SourceDebugExtension({"SMAP\nPingPong.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PingPong.kt\nio/ktor/websocket/PingPongKt$pinger$1$rc$1\n+ 2 Strings.kt\nio/ktor/utils/io/core/StringsKt\n+ 3 StringsJVM.kt\nio/ktor/utils/io/core/StringsJVMKt\n*L\n1#1,111:1\n8#2,3:112\n10#3,6:115\n*S KotlinDebug\n*F\n+ 1 PingPong.kt\nio/ktor/websocket/PingPongKt$pinger$1$rc$1\n*L\n75#1:112,3\n80#1:115,6\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.PingPongKt$pinger$1$rc$1", f = "PingPong.kt", i = {}, l = {75, 79}, m = "invokeSuspend", n = {}, s = {})
public final class PingPongKt$pinger$1$rc$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Channel<Frame.Pong> $channel;
    final /* synthetic */ SendChannel<Frame> $outgoing;
    final /* synthetic */ String $pingMessage;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PingPongKt$pinger$1$rc$1(SendChannel<? super Frame> sendChannel, String str, Channel<Frame.Pong> channel, Continuation<? super PingPongKt$pinger$1$rc$1> continuation) {
        super(2, continuation);
        this.$outgoing = sendChannel;
        this.$pingMessage = str;
        this.$channel = channel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PingPongKt$pinger$1$rc$1(this.$outgoing, this.$pingMessage, this.$channel, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0099  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 0
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x001f
            if (r1 == r4) goto L_0x001b
            if (r1 != r3) goto L_0x0013
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0068
        L_0x0013:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x001b:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x005d
        L_0x001f:
            kotlin.ResultKt.throwOnFailure(r9)
            org.slf4j.Logger r9 = io.ktor.websocket.DefaultWebSocketSessionKt.e()
            java.lang.String r1 = "WebSocket Pinger: sending ping frame"
            r9.trace(r1)
            kotlinx.coroutines.channels.SendChannel<io.ktor.websocket.Frame> r9 = r8.$outgoing
            io.ktor.websocket.Frame$Ping r1 = new io.ktor.websocket.Frame$Ping
            java.lang.String r5 = r8.$pingMessage
            java.nio.charset.Charset r6 = kotlin.text.Charsets.ISO_8859_1
            java.nio.charset.Charset r7 = kotlin.text.Charsets.UTF_8
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r7 == 0) goto L_0x0040
            byte[] r5 = kotlin.text.StringsKt.encodeToByteArray(r5)
            goto L_0x0051
        L_0x0040:
            java.nio.charset.CharsetEncoder r6 = r6.newEncoder()
            java.lang.String r7 = "charset.newEncoder()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            int r7 = r5.length()
            byte[] r5 = io.ktor.utils.io.charsets.CharsetJVMKt.g(r6, r5, r2, r7)
        L_0x0051:
            r1.<init>(r5)
            r8.label = r4
            java.lang.Object r9 = r9.L(r1, r8)
            if (r9 != r0) goto L_0x005d
            return r0
        L_0x005d:
            kotlinx.coroutines.channels.Channel<io.ktor.websocket.Frame$Pong> r9 = r8.$channel
            r8.label = r3
            java.lang.Object r9 = r9.K(r8)
            if (r9 != r0) goto L_0x0068
            return r0
        L_0x0068:
            io.ktor.websocket.Frame$Pong r9 = (io.ktor.websocket.Frame.Pong) r9
            byte[] r1 = r9.b()
            java.nio.charset.Charset r4 = kotlin.text.Charsets.ISO_8859_1
            int r5 = r1.length
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2, r5, r4)
            java.lang.String r1 = r8.$pingMessage
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r1)
            if (r1 == 0) goto L_0x0099
            org.slf4j.Logger r8 = io.ktor.websocket.DefaultWebSocketSessionKt.e()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "WebSocket Pinger: received valid pong frame "
            r0.append(r1)
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            r8.trace(r9)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L_0x0099:
            org.slf4j.Logger r1 = io.ktor.websocket.DefaultWebSocketSessionKt.e()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "WebSocket Pinger: received invalid pong frame "
            r4.append(r5)
            r4.append(r9)
            java.lang.String r9 = ", continue waiting"
            r4.append(r9)
            java.lang.String r9 = r4.toString()
            r1.trace(r9)
            goto L_0x005d
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.PingPongKt$pinger$1$rc$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((PingPongKt$pinger$1$rc$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
