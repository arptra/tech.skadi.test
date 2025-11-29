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
@DebugMetadata(c = "io.ktor.websocket.DefaultWebSocketSessionImpl$runOutgoingProcessor$1", f = "DefaultWebSocketSession.kt", i = {}, l = {236, 247, 247, 247, 240, 247, 247, 244, 247, 247}, m = "invokeSuspend", n = {}, s = {})
public final class DefaultWebSocketSessionImpl$runOutgoingProcessor$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ DefaultWebSocketSessionImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DefaultWebSocketSessionImpl$runOutgoingProcessor$1(DefaultWebSocketSessionImpl defaultWebSocketSessionImpl, Continuation<? super DefaultWebSocketSessionImpl$runOutgoingProcessor$1> continuation) {
        super(2, continuation);
        this.this$0 = defaultWebSocketSessionImpl;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DefaultWebSocketSessionImpl$runOutgoingProcessor$1(this.this$0, continuation);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0031, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0041, code lost:
        kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.a(r10.this$0.d, (java.util.concurrent.CancellationException) null, 1, (java.lang.Object) null);
        r11 = r10.this$0.f9127a;
        r10.label = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0057, code lost:
        if (io.ktor.websocket.WebSocketSessionKt.b(r11, (io.ktor.websocket.CloseReason) null, r10, 1, (java.lang.Object) null) != r0) goto L_0x012f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0059, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r10.this$0.d.a(kotlinx.coroutines.ExceptionsKt.a("Failed to send frame", r11));
        r1 = r10.this$0.f9127a;
        r10.label = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0077, code lost:
        if (io.ktor.websocket.WebSocketSessionKt.c(r1, r11, r10) == r0) goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0079, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007a, code lost:
        kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.a(r10.this$0.d, (java.util.concurrent.CancellationException) null, 1, (java.lang.Object) null);
        r11 = r10.this$0.f9127a;
        r10.label = 9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0091, code lost:
        if (io.ktor.websocket.WebSocketSessionKt.b(r11, (io.ktor.websocket.CloseReason) null, r10, 1, (java.lang.Object) null) != r0) goto L_0x012f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0093, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0094, code lost:
        kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.a(r10.this$0.d, (java.util.concurrent.CancellationException) null, 1, (java.lang.Object) null);
        r11 = r10.this$0.f9127a;
        r10.label = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00aa, code lost:
        if (io.ktor.websocket.WebSocketSessionKt.b(r11, (io.ktor.websocket.CloseReason) null, r10, 1, (java.lang.Object) null) == r0) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00ac, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        r4 = r10.this$0;
        r5 = new io.ktor.websocket.CloseReason(io.ktor.websocket.CloseReason.Codes.NORMAL, "");
        r10.label = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c3, code lost:
        if (io.ktor.websocket.DefaultWebSocketSessionImpl.w(r4, r5, (java.lang.Throwable) null, r10, 2, (java.lang.Object) null) == r0) goto L_0x00c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c5, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00c6, code lost:
        kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.a(r10.this$0.d, (java.util.concurrent.CancellationException) null, 1, (java.lang.Object) null);
        r11 = r10.this$0.f9127a;
        r10.label = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00dc, code lost:
        if (io.ktor.websocket.WebSocketSessionKt.b(r11, (io.ktor.websocket.CloseReason) null, r10, 1, (java.lang.Object) null) != r0) goto L_0x012f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00de, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00df, code lost:
        kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.a(r10.this$0.d, (java.util.concurrent.CancellationException) null, 1, (java.lang.Object) null);
        r1 = r10.this$0.f9127a;
        r10.L$0 = r11;
        r10.label = 10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00f8, code lost:
        if (io.ktor.websocket.WebSocketSessionKt.b(r1, (io.ktor.websocket.CloseReason) null, r10, 1, (java.lang.Object) null) == r0) goto L_0x00fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00fa, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00fb, code lost:
        r10 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00fc, code lost:
        throw r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00fd, code lost:
        kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.a(r10.this$0.d, (java.util.concurrent.CancellationException) null, 1, (java.lang.Object) null);
        r11 = r10.this$0.f9127a;
        r10.label = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0113, code lost:
        if (io.ktor.websocket.WebSocketSessionKt.b(r11, (io.ktor.websocket.CloseReason) null, r10, 1, (java.lang.Object) null) == r0) goto L_0x0115;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0115, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0116, code lost:
        kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.a(r10.this$0.d, (java.util.concurrent.CancellationException) null, 1, (java.lang.Object) null);
        r11 = r10.this$0.f9127a;
        r10.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x012c, code lost:
        if (io.ktor.websocket.WebSocketSessionKt.b(r11, (io.ktor.websocket.CloseReason) null, r10, 1, (java.lang.Object) null) == r0) goto L_0x012e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x012e, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0131, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:5:0x001c, B:11:0x002d, B:33:0x00ad] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00ad */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r10.label
            r2 = 1
            r3 = 0
            switch(r1) {
                case 0: goto L_0x0033;
                case 1: goto L_0x002d;
                case 2: goto L_0x0028;
                case 3: goto L_0x0028;
                case 4: goto L_0x0028;
                case 5: goto L_0x0023;
                case 6: goto L_0x0028;
                case 7: goto L_0x0028;
                case 8: goto L_0x001c;
                case 9: goto L_0x0028;
                case 10: goto L_0x0013;
                default: goto L_0x000b;
            }
        L_0x000b:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0013:
            java.lang.Object r10 = r10.L$0
            java.lang.Throwable r10 = (java.lang.Throwable) r10
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00fc
        L_0x001c:
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x0020 }
            goto L_0x007a
        L_0x0020:
            r11 = move-exception
            goto L_0x00df
        L_0x0023:
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x0020 }
            goto L_0x00c6
        L_0x0028:
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x012f
        L_0x002d:
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ ClosedSendChannelException -> 0x0116, ClosedReceiveChannelException -> 0x00fd, CancellationException -> 0x00ad, ChannelIOException -> 0x0094, all -> 0x0031 }
            goto L_0x0041
        L_0x0031:
            r11 = move-exception
            goto L_0x005a
        L_0x0033:
            kotlin.ResultKt.throwOnFailure(r11)
            io.ktor.websocket.DefaultWebSocketSessionImpl r11 = r10.this$0     // Catch:{ ClosedSendChannelException -> 0x0116, ClosedReceiveChannelException -> 0x00fd, CancellationException -> 0x00ad, ChannelIOException -> 0x0094, all -> 0x0031 }
            r10.label = r2     // Catch:{ ClosedSendChannelException -> 0x0116, ClosedReceiveChannelException -> 0x00fd, CancellationException -> 0x00ad, ChannelIOException -> 0x0094, all -> 0x0031 }
            java.lang.Object r11 = r11.n(r10)     // Catch:{ ClosedSendChannelException -> 0x0116, ClosedReceiveChannelException -> 0x00fd, CancellationException -> 0x00ad, ChannelIOException -> 0x0094, all -> 0x0031 }
            if (r11 != r0) goto L_0x0041
            return r0
        L_0x0041:
            io.ktor.websocket.DefaultWebSocketSessionImpl r11 = r10.this$0
            kotlinx.coroutines.channels.Channel r11 = r11.d
            kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.a(r11, r3, r2, r3)
            io.ktor.websocket.DefaultWebSocketSessionImpl r11 = r10.this$0
            io.ktor.websocket.WebSocketSession r11 = r11.f9127a
            r1 = 2
            r10.label = r1
            java.lang.Object r10 = io.ktor.websocket.WebSocketSessionKt.b(r11, r3, r10, r2, r3)
            if (r10 != r0) goto L_0x012f
            return r0
        L_0x005a:
            io.ktor.websocket.DefaultWebSocketSessionImpl r1 = r10.this$0     // Catch:{ all -> 0x0020 }
            kotlinx.coroutines.channels.Channel r1 = r1.d     // Catch:{ all -> 0x0020 }
            java.lang.String r4 = "Failed to send frame"
            java.util.concurrent.CancellationException r4 = kotlinx.coroutines.ExceptionsKt.a(r4, r11)     // Catch:{ all -> 0x0020 }
            r1.a(r4)     // Catch:{ all -> 0x0020 }
            io.ktor.websocket.DefaultWebSocketSessionImpl r1 = r10.this$0     // Catch:{ all -> 0x0020 }
            io.ktor.websocket.WebSocketSession r1 = r1.f9127a     // Catch:{ all -> 0x0020 }
            r4 = 8
            r10.label = r4     // Catch:{ all -> 0x0020 }
            java.lang.Object r11 = io.ktor.websocket.WebSocketSessionKt.c(r1, r11, r10)     // Catch:{ all -> 0x0020 }
            if (r11 != r0) goto L_0x007a
            return r0
        L_0x007a:
            io.ktor.websocket.DefaultWebSocketSessionImpl r11 = r10.this$0
            kotlinx.coroutines.channels.Channel r11 = r11.d
            kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.a(r11, r3, r2, r3)
            io.ktor.websocket.DefaultWebSocketSessionImpl r11 = r10.this$0
            io.ktor.websocket.WebSocketSession r11 = r11.f9127a
            r1 = 9
            r10.label = r1
            java.lang.Object r10 = io.ktor.websocket.WebSocketSessionKt.b(r11, r3, r10, r2, r3)
            if (r10 != r0) goto L_0x012f
            return r0
        L_0x0094:
            io.ktor.websocket.DefaultWebSocketSessionImpl r11 = r10.this$0
            kotlinx.coroutines.channels.Channel r11 = r11.d
            kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.a(r11, r3, r2, r3)
            io.ktor.websocket.DefaultWebSocketSessionImpl r11 = r10.this$0
            io.ktor.websocket.WebSocketSession r11 = r11.f9127a
            r1 = 7
            r10.label = r1
            java.lang.Object r10 = io.ktor.websocket.WebSocketSessionKt.b(r11, r3, r10, r2, r3)
            if (r10 != r0) goto L_0x012f
            return r0
        L_0x00ad:
            io.ktor.websocket.DefaultWebSocketSessionImpl r4 = r10.this$0     // Catch:{ all -> 0x0020 }
            io.ktor.websocket.CloseReason r5 = new io.ktor.websocket.CloseReason     // Catch:{ all -> 0x0020 }
            io.ktor.websocket.CloseReason$Codes r11 = io.ktor.websocket.CloseReason.Codes.NORMAL     // Catch:{ all -> 0x0020 }
            java.lang.String r1 = ""
            r5.<init>((io.ktor.websocket.CloseReason.Codes) r11, (java.lang.String) r1)     // Catch:{ all -> 0x0020 }
            r11 = 5
            r10.label = r11     // Catch:{ all -> 0x0020 }
            r6 = 0
            r8 = 2
            r9 = 0
            r7 = r10
            java.lang.Object r11 = io.ktor.websocket.DefaultWebSocketSessionImpl.w(r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0020 }
            if (r11 != r0) goto L_0x00c6
            return r0
        L_0x00c6:
            io.ktor.websocket.DefaultWebSocketSessionImpl r11 = r10.this$0
            kotlinx.coroutines.channels.Channel r11 = r11.d
            kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.a(r11, r3, r2, r3)
            io.ktor.websocket.DefaultWebSocketSessionImpl r11 = r10.this$0
            io.ktor.websocket.WebSocketSession r11 = r11.f9127a
            r1 = 6
            r10.label = r1
            java.lang.Object r10 = io.ktor.websocket.WebSocketSessionKt.b(r11, r3, r10, r2, r3)
            if (r10 != r0) goto L_0x012f
            return r0
        L_0x00df:
            io.ktor.websocket.DefaultWebSocketSessionImpl r1 = r10.this$0
            kotlinx.coroutines.channels.Channel r1 = r1.d
            kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.a(r1, r3, r2, r3)
            io.ktor.websocket.DefaultWebSocketSessionImpl r1 = r10.this$0
            io.ktor.websocket.WebSocketSession r1 = r1.f9127a
            r10.L$0 = r11
            r4 = 10
            r10.label = r4
            java.lang.Object r10 = io.ktor.websocket.WebSocketSessionKt.b(r1, r3, r10, r2, r3)
            if (r10 != r0) goto L_0x00fb
            return r0
        L_0x00fb:
            r10 = r11
        L_0x00fc:
            throw r10
        L_0x00fd:
            io.ktor.websocket.DefaultWebSocketSessionImpl r11 = r10.this$0
            kotlinx.coroutines.channels.Channel r11 = r11.d
            kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.a(r11, r3, r2, r3)
            io.ktor.websocket.DefaultWebSocketSessionImpl r11 = r10.this$0
            io.ktor.websocket.WebSocketSession r11 = r11.f9127a
            r1 = 4
            r10.label = r1
            java.lang.Object r10 = io.ktor.websocket.WebSocketSessionKt.b(r11, r3, r10, r2, r3)
            if (r10 != r0) goto L_0x012f
            return r0
        L_0x0116:
            io.ktor.websocket.DefaultWebSocketSessionImpl r11 = r10.this$0
            kotlinx.coroutines.channels.Channel r11 = r11.d
            kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.a(r11, r3, r2, r3)
            io.ktor.websocket.DefaultWebSocketSessionImpl r11 = r10.this$0
            io.ktor.websocket.WebSocketSession r11 = r11.f9127a
            r1 = 3
            r10.label = r1
            java.lang.Object r10 = io.ktor.websocket.WebSocketSessionKt.b(r11, r3, r10, r2, r3)
            if (r10 != r0) goto L_0x012f
            return r0
        L_0x012f:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.DefaultWebSocketSessionImpl$runOutgoingProcessor$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DefaultWebSocketSessionImpl$runOutgoingProcessor$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
