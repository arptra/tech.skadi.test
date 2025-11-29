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
import kotlinx.coroutines.channels.SendChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nDefaultWebSocketSession.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DefaultWebSocketSession.kt\nio/ktor/websocket/DefaultWebSocketSessionImpl$runIncomingProcessor$1\n+ 2 Channels.common.kt\nkotlinx/coroutines/channels/ChannelsKt__Channels_commonKt\n*L\n1#1,344:1\n105#2:345\n82#2,6:346\n106#2:352\n92#2:353\n107#2:354\n88#2,3:355\n*S KotlinDebug\n*F\n+ 1 DefaultWebSocketSession.kt\nio/ktor/websocket/DefaultWebSocketSessionImpl$runIncomingProcessor$1\n*L\n167#1:345\n167#1:346,6\n167#1:352\n167#1:353\n167#1:354\n167#1:355,3\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.DefaultWebSocketSessionImpl$runIncomingProcessor$1", f = "DefaultWebSocketSession.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7}, l = {352, 172, 226, 178, 179, 181, 196, 211, 226, 226, 226, 226}, m = "invokeSuspend", n = {"$this$launch", "firstFrame", "frameBody", "closeFramePresented", "$this$consume$iv$iv", "frameBody", "closeFramePresented", "$this$consume$iv$iv", "$this$launch", "firstFrame", "frameBody", "closeFramePresented", "$this$consume$iv$iv", "$this$launch", "firstFrame", "frameBody", "closeFramePresented", "$this$consume$iv$iv", "$this$launch", "firstFrame", "frameBody", "closeFramePresented", "$this$consume$iv$iv", "frame", "$this$launch", "firstFrame", "frameBody", "closeFramePresented", "$this$consume$iv$iv", "$this$launch", "firstFrame", "frameBody", "closeFramePresented", "$this$consume$iv$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$6", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$6", "L$0", "L$1", "L$2", "L$3", "L$6", "L$0", "L$1", "L$2", "L$3", "L$6", "L$8", "L$0", "L$1", "L$2", "L$3", "L$6", "L$0", "L$1", "L$2", "L$3", "L$6"})
public final class DefaultWebSocketSessionImpl$runIncomingProcessor$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SendChannel<Frame.Ping> $ponger;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    int label;
    final /* synthetic */ DefaultWebSocketSessionImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DefaultWebSocketSessionImpl$runIncomingProcessor$1(DefaultWebSocketSessionImpl defaultWebSocketSessionImpl, SendChannel<? super Frame.Ping> sendChannel, Continuation<? super DefaultWebSocketSessionImpl$runIncomingProcessor$1> continuation) {
        super(2, continuation);
        this.this$0 = defaultWebSocketSessionImpl;
        this.$ponger = sendChannel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        DefaultWebSocketSessionImpl$runIncomingProcessor$1 defaultWebSocketSessionImpl$runIncomingProcessor$1 = new DefaultWebSocketSessionImpl$runIncomingProcessor$1(this.this$0, this.$ponger, continuation);
        defaultWebSocketSessionImpl$runIncomingProcessor$1.L$0 = obj;
        return defaultWebSocketSessionImpl$runIncomingProcessor$1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v70, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v29, resolved type: kotlinx.coroutines.channels.ReceiveChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v71, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v16, resolved type: kotlin.jvm.internal.Ref$BooleanRef} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v72, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v16, resolved type: kotlin.jvm.internal.Ref$ObjectRef} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x039c, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x039d, code lost:
        r4 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:?, code lost:
        r0 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:?, code lost:
        kotlinx.coroutines.channels.ChannelsKt.b(r6, (java.lang.Throwable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x03a5, code lost:
        kotlinx.coroutines.channels.SendChannel.DefaultImpls.a(r1.$ponger, (java.lang.Throwable) null, 1, (java.lang.Object) null);
        r0 = r10.element;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x03af, code lost:
        if (r0 == null) goto L_0x03b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x03b1, code lost:
        r0.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x03b4, code lost:
        kotlinx.coroutines.channels.SendChannel.DefaultImpls.a(r1.this$0.c, (java.lang.Throwable) null, 1, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x004b, code lost:
        r4 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x03bf, code lost:
        if (r9.element != false) goto L_0x04cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x03c1, code lost:
        r0 = r1.this$0;
        r4 = new io.ktor.websocket.CloseReason(io.ktor.websocket.CloseReason.Codes.CLOSED_ABNORMALLY, "Connection was closed without close frame");
        r1.L$0 = null;
        r1.L$1 = null;
        r1.L$2 = null;
        r1.L$3 = null;
        r1.L$4 = null;
        r1.L$5 = null;
        r1.L$6 = null;
        r1.L$7 = null;
        r1.label = 9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x03e2, code lost:
        if (io.ktor.websocket.WebSocketSessionKt.a(r0, r4, r1) != r2) goto L_0x04cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x03e4, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x04cd, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:?, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:?, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0150, code lost:
        r1.L$0 = r0;
        r1.L$1 = r6;
        r1.L$2 = r10;
        r1.L$3 = r9;
        r1.L$4 = r8;
        r1.L$5 = r11;
        r1.L$6 = r7;
        r1.L$7 = r12;
        r1.L$8 = null;
        r1.label = r4;
        r13 = r12.a(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0168, code lost:
        if (r13 != r2) goto L_0x016b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x016a, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x016b, code lost:
        r29 = r12;
        r12 = r0;
        r0 = r29;
        r30 = r11;
        r11 = r6;
        r6 = r7;
        r7 = r30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x017c, code lost:
        if (((java.lang.Boolean) r13).booleanValue() == false) goto L_0x03a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x017e, code lost:
        r13 = (io.ktor.websocket.Frame) r0.next();
        r14 = io.ktor.websocket.DefaultWebSocketSessionKt.e();
        r14.trace("WebSocketSession(" + r12 + ") receiving frame " + r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x01a6, code lost:
        if ((r13 instanceof io.ktor.websocket.Frame.Close) == false) goto L_0x022b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x01b0, code lost:
        if (r8.o().A() != false) goto L_0x01e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x01b2, code lost:
        r0 = r8.o();
        r7 = io.ktor.websocket.FrameCommonKt.a((io.ktor.websocket.Frame.Close) r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x01be, code lost:
        if (r7 != null) goto L_0x01c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x01c0, code lost:
        r7 = io.ktor.websocket.DefaultWebSocketSessionKt.d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x01c4, code lost:
        r4 = new io.ktor.websocket.Frame.Close(r7);
        r1.L$0 = r10;
        r1.L$1 = r9;
        r1.L$2 = r6;
        r1.L$3 = null;
        r1.L$4 = null;
        r1.L$5 = null;
        r1.L$6 = null;
        r1.L$7 = null;
        r1.label = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x01de, code lost:
        if (r0.L(r4, r1) != r2) goto L_0x01e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x01e0, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x01e1, code lost:
        r9.element = true;
        r0 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        kotlinx.coroutines.channels.ChannelsKt.b(r6, (java.lang.Throwable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x01e9, code lost:
        kotlinx.coroutines.channels.SendChannel.DefaultImpls.a(r1.$ponger, (java.lang.Throwable) null, 1, (java.lang.Object) null);
        r6 = r10.element;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x01f2, code lost:
        if (r6 == null) goto L_0x01f7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01f4, code lost:
        r6.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x01f7, code lost:
        kotlinx.coroutines.channels.SendChannel.DefaultImpls.a(r1.this$0.c, (java.lang.Throwable) null, 1, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0202, code lost:
        if (r9.element != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0204, code lost:
        r4 = r1.this$0;
        r6 = new io.ktor.websocket.CloseReason(io.ktor.websocket.CloseReason.Codes.CLOSED_ABNORMALLY, "Connection was closed without close frame");
        r1.L$0 = r0;
        r1.L$1 = null;
        r1.L$2 = null;
        r1.L$3 = null;
        r1.L$4 = null;
        r1.L$5 = null;
        r1.L$6 = null;
        r1.L$7 = null;
        r1.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0224, code lost:
        if (io.ktor.websocket.WebSocketSessionKt.a(r4, r6, r1) != r2) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0226, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x022d, code lost:
        if ((r13 instanceof io.ktor.websocket.Frame.Pong) == false) goto L_0x025e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x022f, code lost:
        r4 = (kotlinx.coroutines.channels.SendChannel) r8.pinger;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0233, code lost:
        if (r4 == null) goto L_0x0251;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0235, code lost:
        r1.L$0 = r12;
        r1.L$1 = r11;
        r1.L$2 = r10;
        r1.L$3 = r9;
        r1.L$4 = r8;
        r1.L$5 = r7;
        r1.L$6 = r6;
        r1.L$7 = r0;
        r1.label = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x024c, code lost:
        if (r4.L(r13, r1) != r2) goto L_0x024f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x024e, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x024f, code lost:
        r4 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0251, code lost:
        r29 = r12;
        r12 = r0;
        r0 = r29;
        r30 = r7;
        r7 = r6;
        r6 = r11;
        r11 = r30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0260, code lost:
        if ((r13 instanceof io.ktor.websocket.Frame.Ping) == false) goto L_0x027c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0262, code lost:
        r1.L$0 = r12;
        r1.L$1 = r11;
        r1.L$2 = r10;
        r1.L$3 = r9;
        r1.L$4 = r8;
        r1.L$5 = r7;
        r1.L$6 = r6;
        r1.L$7 = r0;
        r1.label = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0279, code lost:
        if (r7.L(r13, r1) != r2) goto L_0x0251;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x027b, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x027c, code lost:
        r1.L$0 = r12;
        r1.L$1 = r11;
        r1.L$2 = r10;
        r1.L$3 = r9;
        r1.L$4 = r8;
        r1.L$5 = r7;
        r1.L$6 = r6;
        r1.L$7 = r0;
        r1.L$8 = r13;
        r1.label = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0299, code lost:
        if (r8.j(r10.element, r13, r1) != r2) goto L_0x029c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x029b, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x029c, code lost:
        r29 = r6;
        r6 = r0;
        r0 = r13;
        r13 = r12;
        r12 = r11;
        r11 = r10;
        r10 = r9;
        r9 = r8;
        r8 = r7;
        r7 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x02ac, code lost:
        if (r0.c() != false) goto L_0x02e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x02b0, code lost:
        if (r12.element != null) goto L_0x02b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x02b2, code lost:
        r12.element = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x02b6, code lost:
        if (r11.element != null) goto L_0x02c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        kotlin.ResultKt.throwOnFailure(r32);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x02b8, code lost:
        r11.element = new io.ktor.utils.io.core.BytePacketBuilder((io.ktor.utils.io.pool.ObjectPool) null, 1, (kotlin.jvm.internal.DefaultConstructorMarker) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x02c0, code lost:
        r4 = r11.element;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r4);
        io.ktor.utils.io.core.OutputKt.d(r4, r0.b(), 0, 0, 6, (java.lang.Object) null);
        r0 = r13;
        r29 = r12;
        r12 = r6;
        r6 = r29;
        r30 = r11;
        r11 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x02e9, code lost:
        if (r12.element != null) goto L_0x0319;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x02eb, code lost:
        r4 = r9.c;
        r0 = r9.p(r0);
        r1.L$0 = r13;
        r1.L$1 = r12;
        r1.L$2 = r11;
        r1.L$3 = r10;
        r1.L$4 = r9;
        r1.L$5 = r8;
        r1.L$6 = r7;
        r1.L$7 = r6;
        r1.L$8 = null;
        r1.label = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x030c, code lost:
        if (r4.L(r0, r1) != r2) goto L_0x030f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x030e, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x030f, code lost:
        r0 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0319, code lost:
        r4 = r11.element;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r4);
        io.ktor.utils.io.core.OutputKt.d(r4, r0.b(), 0, 0, 6, (java.lang.Object) null);
        r22 = io.ktor.websocket.Frame.i;
        r0 = r12.element;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r0);
        r24 = r0.d();
        r0 = r11.element;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r0);
        r25 = io.ktor.utils.io.core.StringsKt.d(r0.F0(), 0, 1, (java.lang.Object) null);
        r0 = r12.element;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r0);
        r26 = r0.e();
        r0 = r12.element;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r0);
        r27 = r0.f();
        r0 = r12.element;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r0);
        r0 = r22.a(true, r24, r25, r26, r27, r0.g());
        r12.element = null;
        r4 = r9.c;
        r0 = r9.p(r0);
        r1.L$0 = r13;
        r1.L$1 = r12;
        r1.L$2 = r11;
        r1.L$3 = r10;
        r1.L$4 = r9;
        r1.L$5 = r8;
        r1.L$6 = r7;
        r1.L$7 = r6;
        r1.L$8 = null;
        r1.label = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x039a, code lost:
        if (r4.L(r0, r1) != r2) goto L_0x030f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x004a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r32) {
        /*
            r31 = this;
            r1 = r31
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r1.label
            java.lang.String r3 = "Connection was closed without close frame"
            r4 = 1
            r5 = 0
            switch(r0) {
                case 0: goto L_0x0128;
                case 1: goto L_0x0102;
                case 2: goto L_0x00ee;
                case 3: goto L_0x00e5;
                case 4: goto L_0x00c0;
                case 5: goto L_0x009f;
                case 6: goto L_0x006f;
                case 7: goto L_0x004e;
                case 8: goto L_0x0025;
                case 9: goto L_0x0020;
                case 10: goto L_0x0020;
                case 11: goto L_0x0020;
                case 12: goto L_0x0017;
                default: goto L_0x000f;
            }
        L_0x000f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0017:
            java.lang.Object r0 = r1.L$0
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            kotlin.ResultKt.throwOnFailure(r32)
            goto L_0x0486
        L_0x0020:
            kotlin.ResultKt.throwOnFailure(r32)
            goto L_0x04cb
        L_0x0025:
            java.lang.Object r0 = r1.L$7
            kotlinx.coroutines.channels.ChannelIterator r0 = (kotlinx.coroutines.channels.ChannelIterator) r0
            java.lang.Object r6 = r1.L$6
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            java.lang.Object r7 = r1.L$5
            kotlinx.coroutines.channels.SendChannel r7 = (kotlinx.coroutines.channels.SendChannel) r7
            java.lang.Object r8 = r1.L$4
            io.ktor.websocket.DefaultWebSocketSessionImpl r8 = (io.ktor.websocket.DefaultWebSocketSessionImpl) r8
            java.lang.Object r9 = r1.L$3
            kotlin.jvm.internal.Ref$BooleanRef r9 = (kotlin.jvm.internal.Ref.BooleanRef) r9
            java.lang.Object r10 = r1.L$2
            kotlin.jvm.internal.Ref$ObjectRef r10 = (kotlin.jvm.internal.Ref.ObjectRef) r10
            java.lang.Object r11 = r1.L$1
            kotlin.jvm.internal.Ref$ObjectRef r11 = (kotlin.jvm.internal.Ref.ObjectRef) r11
            java.lang.Object r12 = r1.L$0
            kotlinx.coroutines.CoroutineScope r12 = (kotlinx.coroutines.CoroutineScope) r12
        L_0x0045:
            kotlin.ResultKt.throwOnFailure(r32)     // Catch:{ all -> 0x004a }
            goto L_0x0251
        L_0x004a:
            r0 = move-exception
            r4 = r0
            goto L_0x03e8
        L_0x004e:
            java.lang.Object r0 = r1.L$7
            kotlinx.coroutines.channels.ChannelIterator r0 = (kotlinx.coroutines.channels.ChannelIterator) r0
            java.lang.Object r6 = r1.L$6
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            java.lang.Object r7 = r1.L$5
            kotlinx.coroutines.channels.SendChannel r7 = (kotlinx.coroutines.channels.SendChannel) r7
            java.lang.Object r8 = r1.L$4
            io.ktor.websocket.DefaultWebSocketSessionImpl r8 = (io.ktor.websocket.DefaultWebSocketSessionImpl) r8
            java.lang.Object r9 = r1.L$3
            kotlin.jvm.internal.Ref$BooleanRef r9 = (kotlin.jvm.internal.Ref.BooleanRef) r9
            java.lang.Object r10 = r1.L$2
            kotlin.jvm.internal.Ref$ObjectRef r10 = (kotlin.jvm.internal.Ref.ObjectRef) r10
            java.lang.Object r11 = r1.L$1
            kotlin.jvm.internal.Ref$ObjectRef r11 = (kotlin.jvm.internal.Ref.ObjectRef) r11
            java.lang.Object r12 = r1.L$0
            kotlinx.coroutines.CoroutineScope r12 = (kotlinx.coroutines.CoroutineScope) r12
            goto L_0x0045
        L_0x006f:
            java.lang.Object r0 = r1.L$8
            io.ktor.websocket.Frame r0 = (io.ktor.websocket.Frame) r0
            java.lang.Object r6 = r1.L$7
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r1.L$6
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            java.lang.Object r8 = r1.L$5
            kotlinx.coroutines.channels.SendChannel r8 = (kotlinx.coroutines.channels.SendChannel) r8
            java.lang.Object r9 = r1.L$4
            io.ktor.websocket.DefaultWebSocketSessionImpl r9 = (io.ktor.websocket.DefaultWebSocketSessionImpl) r9
            java.lang.Object r10 = r1.L$3
            kotlin.jvm.internal.Ref$BooleanRef r10 = (kotlin.jvm.internal.Ref.BooleanRef) r10
            java.lang.Object r11 = r1.L$2
            kotlin.jvm.internal.Ref$ObjectRef r11 = (kotlin.jvm.internal.Ref.ObjectRef) r11
            java.lang.Object r12 = r1.L$1
            kotlin.jvm.internal.Ref$ObjectRef r12 = (kotlin.jvm.internal.Ref.ObjectRef) r12
            java.lang.Object r13 = r1.L$0
            kotlinx.coroutines.CoroutineScope r13 = (kotlinx.coroutines.CoroutineScope) r13
            kotlin.ResultKt.throwOnFailure(r32)     // Catch:{ all -> 0x0098 }
            goto L_0x02a8
        L_0x0098:
            r0 = move-exception
            r4 = r0
            r6 = r7
            r9 = r10
            r10 = r11
            goto L_0x03e8
        L_0x009f:
            java.lang.Object r0 = r1.L$7
            kotlinx.coroutines.channels.ChannelIterator r0 = (kotlinx.coroutines.channels.ChannelIterator) r0
            java.lang.Object r6 = r1.L$6
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            java.lang.Object r7 = r1.L$5
            kotlinx.coroutines.channels.SendChannel r7 = (kotlinx.coroutines.channels.SendChannel) r7
            java.lang.Object r8 = r1.L$4
            io.ktor.websocket.DefaultWebSocketSessionImpl r8 = (io.ktor.websocket.DefaultWebSocketSessionImpl) r8
            java.lang.Object r9 = r1.L$3
            kotlin.jvm.internal.Ref$BooleanRef r9 = (kotlin.jvm.internal.Ref.BooleanRef) r9
            java.lang.Object r10 = r1.L$2
            kotlin.jvm.internal.Ref$ObjectRef r10 = (kotlin.jvm.internal.Ref.ObjectRef) r10
            java.lang.Object r11 = r1.L$1
            kotlin.jvm.internal.Ref$ObjectRef r11 = (kotlin.jvm.internal.Ref.ObjectRef) r11
            java.lang.Object r12 = r1.L$0
            kotlinx.coroutines.CoroutineScope r12 = (kotlinx.coroutines.CoroutineScope) r12
            goto L_0x0045
        L_0x00c0:
            java.lang.Object r0 = r1.L$7
            kotlinx.coroutines.channels.ChannelIterator r0 = (kotlinx.coroutines.channels.ChannelIterator) r0
            java.lang.Object r6 = r1.L$6
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            java.lang.Object r7 = r1.L$5
            kotlinx.coroutines.channels.SendChannel r7 = (kotlinx.coroutines.channels.SendChannel) r7
            java.lang.Object r8 = r1.L$4
            io.ktor.websocket.DefaultWebSocketSessionImpl r8 = (io.ktor.websocket.DefaultWebSocketSessionImpl) r8
            java.lang.Object r9 = r1.L$3
            kotlin.jvm.internal.Ref$BooleanRef r9 = (kotlin.jvm.internal.Ref.BooleanRef) r9
            java.lang.Object r10 = r1.L$2
            kotlin.jvm.internal.Ref$ObjectRef r10 = (kotlin.jvm.internal.Ref.ObjectRef) r10
            java.lang.Object r11 = r1.L$1
            kotlin.jvm.internal.Ref$ObjectRef r11 = (kotlin.jvm.internal.Ref.ObjectRef) r11
            java.lang.Object r12 = r1.L$0
            kotlinx.coroutines.CoroutineScope r12 = (kotlinx.coroutines.CoroutineScope) r12
            kotlin.ResultKt.throwOnFailure(r32)     // Catch:{ all -> 0x004a }
            goto L_0x024f
        L_0x00e5:
            java.lang.Object r0 = r1.L$0
            kotlin.Unit r0 = (kotlin.Unit) r0
            kotlin.ResultKt.throwOnFailure(r32)
            goto L_0x0227
        L_0x00ee:
            java.lang.Object r0 = r1.L$2
            r6 = r0
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            java.lang.Object r0 = r1.L$1
            r9 = r0
            kotlin.jvm.internal.Ref$BooleanRef r9 = (kotlin.jvm.internal.Ref.BooleanRef) r9
            java.lang.Object r0 = r1.L$0
            r10 = r0
            kotlin.jvm.internal.Ref$ObjectRef r10 = (kotlin.jvm.internal.Ref.ObjectRef) r10
            kotlin.ResultKt.throwOnFailure(r32)     // Catch:{ all -> 0x004a }
            goto L_0x01e1
        L_0x0102:
            java.lang.Object r0 = r1.L$7
            kotlinx.coroutines.channels.ChannelIterator r0 = (kotlinx.coroutines.channels.ChannelIterator) r0
            java.lang.Object r6 = r1.L$6
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            java.lang.Object r7 = r1.L$5
            kotlinx.coroutines.channels.SendChannel r7 = (kotlinx.coroutines.channels.SendChannel) r7
            java.lang.Object r8 = r1.L$4
            io.ktor.websocket.DefaultWebSocketSessionImpl r8 = (io.ktor.websocket.DefaultWebSocketSessionImpl) r8
            java.lang.Object r9 = r1.L$3
            kotlin.jvm.internal.Ref$BooleanRef r9 = (kotlin.jvm.internal.Ref.BooleanRef) r9
            java.lang.Object r10 = r1.L$2
            kotlin.jvm.internal.Ref$ObjectRef r10 = (kotlin.jvm.internal.Ref.ObjectRef) r10
            java.lang.Object r11 = r1.L$1
            kotlin.jvm.internal.Ref$ObjectRef r11 = (kotlin.jvm.internal.Ref.ObjectRef) r11
            java.lang.Object r12 = r1.L$0
            kotlinx.coroutines.CoroutineScope r12 = (kotlinx.coroutines.CoroutineScope) r12
            kotlin.ResultKt.throwOnFailure(r32)     // Catch:{ all -> 0x004a }
            r13 = r32
            goto L_0x0176
        L_0x0128:
            kotlin.ResultKt.throwOnFailure(r32)
            java.lang.Object r0 = r1.L$0
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            kotlin.jvm.internal.Ref$ObjectRef r6 = new kotlin.jvm.internal.Ref$ObjectRef
            r6.<init>()
            kotlin.jvm.internal.Ref$ObjectRef r10 = new kotlin.jvm.internal.Ref$ObjectRef
            r10.<init>()
            kotlin.jvm.internal.Ref$BooleanRef r9 = new kotlin.jvm.internal.Ref$BooleanRef
            r9.<init>()
            io.ktor.websocket.DefaultWebSocketSessionImpl r7 = r1.this$0     // Catch:{ ClosedSendChannelException -> 0x0487, all -> 0x0228 }
            io.ktor.websocket.WebSocketSession r7 = r7.f9127a     // Catch:{ ClosedSendChannelException -> 0x0487, all -> 0x0228 }
            kotlinx.coroutines.channels.ReceiveChannel r7 = r7.i()     // Catch:{ ClosedSendChannelException -> 0x0487, all -> 0x0228 }
            io.ktor.websocket.DefaultWebSocketSessionImpl r8 = r1.this$0     // Catch:{ ClosedSendChannelException -> 0x0487, all -> 0x0228 }
            kotlinx.coroutines.channels.SendChannel<io.ktor.websocket.Frame$Ping> r11 = r1.$ponger     // Catch:{ ClosedSendChannelException -> 0x0487, all -> 0x0228 }
            kotlinx.coroutines.channels.ChannelIterator r12 = r7.iterator()     // Catch:{ all -> 0x03e5 }
        L_0x0150:
            r1.L$0 = r0     // Catch:{ all -> 0x03e5 }
            r1.L$1 = r6     // Catch:{ all -> 0x03e5 }
            r1.L$2 = r10     // Catch:{ all -> 0x03e5 }
            r1.L$3 = r9     // Catch:{ all -> 0x03e5 }
            r1.L$4 = r8     // Catch:{ all -> 0x03e5 }
            r1.L$5 = r11     // Catch:{ all -> 0x03e5 }
            r1.L$6 = r7     // Catch:{ all -> 0x03e5 }
            r1.L$7 = r12     // Catch:{ all -> 0x03e5 }
            r1.L$8 = r5     // Catch:{ all -> 0x03e5 }
            r1.label = r4     // Catch:{ all -> 0x03e5 }
            java.lang.Object r13 = r12.a(r1)     // Catch:{ all -> 0x03e5 }
            if (r13 != r2) goto L_0x016b
            return r2
        L_0x016b:
            r29 = r12
            r12 = r0
            r0 = r29
            r30 = r11
            r11 = r6
            r6 = r7
            r7 = r30
        L_0x0176:
            java.lang.Boolean r13 = (java.lang.Boolean) r13     // Catch:{ all -> 0x004a }
            boolean r13 = r13.booleanValue()     // Catch:{ all -> 0x004a }
            if (r13 == 0) goto L_0x03a0
            java.lang.Object r13 = r0.next()     // Catch:{ all -> 0x004a }
            io.ktor.websocket.Frame r13 = (io.ktor.websocket.Frame) r13     // Catch:{ all -> 0x004a }
            org.slf4j.Logger r14 = io.ktor.websocket.DefaultWebSocketSessionKt.e()     // Catch:{ all -> 0x004a }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ all -> 0x004a }
            r15.<init>()     // Catch:{ all -> 0x004a }
            java.lang.String r4 = "WebSocketSession("
            r15.append(r4)     // Catch:{ all -> 0x004a }
            r15.append(r12)     // Catch:{ all -> 0x004a }
            java.lang.String r4 = ") receiving frame "
            r15.append(r4)     // Catch:{ all -> 0x004a }
            r15.append(r13)     // Catch:{ all -> 0x004a }
            java.lang.String r4 = r15.toString()     // Catch:{ all -> 0x004a }
            r14.trace(r4)     // Catch:{ all -> 0x004a }
            boolean r4 = r13 instanceof io.ktor.websocket.Frame.Close     // Catch:{ all -> 0x004a }
            if (r4 == 0) goto L_0x022b
            kotlinx.coroutines.channels.SendChannel r0 = r8.o()     // Catch:{ all -> 0x004a }
            boolean r0 = r0.A()     // Catch:{ all -> 0x004a }
            if (r0 != 0) goto L_0x01e1
            kotlinx.coroutines.channels.SendChannel r0 = r8.o()     // Catch:{ all -> 0x004a }
            io.ktor.websocket.Frame$Close r4 = new io.ktor.websocket.Frame$Close     // Catch:{ all -> 0x004a }
            io.ktor.websocket.Frame$Close r13 = (io.ktor.websocket.Frame.Close) r13     // Catch:{ all -> 0x004a }
            io.ktor.websocket.CloseReason r7 = io.ktor.websocket.FrameCommonKt.a(r13)     // Catch:{ all -> 0x004a }
            if (r7 != 0) goto L_0x01c4
            io.ktor.websocket.CloseReason r7 = io.ktor.websocket.DefaultWebSocketSessionKt.d     // Catch:{ all -> 0x004a }
        L_0x01c4:
            r4.<init>((io.ktor.websocket.CloseReason) r7)     // Catch:{ all -> 0x004a }
            r1.L$0 = r10     // Catch:{ all -> 0x004a }
            r1.L$1 = r9     // Catch:{ all -> 0x004a }
            r1.L$2 = r6     // Catch:{ all -> 0x004a }
            r1.L$3 = r5     // Catch:{ all -> 0x004a }
            r1.L$4 = r5     // Catch:{ all -> 0x004a }
            r1.L$5 = r5     // Catch:{ all -> 0x004a }
            r1.L$6 = r5     // Catch:{ all -> 0x004a }
            r1.L$7 = r5     // Catch:{ all -> 0x004a }
            r7 = 2
            r1.label = r7     // Catch:{ all -> 0x004a }
            java.lang.Object r0 = r0.L(r4, r1)     // Catch:{ all -> 0x004a }
            if (r0 != r2) goto L_0x01e1
            return r2
        L_0x01e1:
            r4 = 1
            r9.element = r4     // Catch:{ all -> 0x004a }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x004a }
            kotlinx.coroutines.channels.ChannelsKt.b(r6, r5)     // Catch:{ ClosedSendChannelException -> 0x0487, all -> 0x0228 }
            kotlinx.coroutines.channels.SendChannel<io.ktor.websocket.Frame$Ping> r6 = r1.$ponger
            kotlinx.coroutines.channels.SendChannel.DefaultImpls.a(r6, r5, r4, r5)
            T r6 = r10.element
            io.ktor.utils.io.core.BytePacketBuilder r6 = (io.ktor.utils.io.core.BytePacketBuilder) r6
            if (r6 == 0) goto L_0x01f7
            r6.release()
        L_0x01f7:
            io.ktor.websocket.DefaultWebSocketSessionImpl r6 = r1.this$0
            kotlinx.coroutines.channels.Channel r6 = r6.c
            kotlinx.coroutines.channels.SendChannel.DefaultImpls.a(r6, r5, r4, r5)
            boolean r4 = r9.element
            if (r4 != 0) goto L_0x0227
            io.ktor.websocket.DefaultWebSocketSessionImpl r4 = r1.this$0
            io.ktor.websocket.CloseReason r6 = new io.ktor.websocket.CloseReason
            io.ktor.websocket.CloseReason$Codes r7 = io.ktor.websocket.CloseReason.Codes.CLOSED_ABNORMALLY
            r6.<init>((io.ktor.websocket.CloseReason.Codes) r7, (java.lang.String) r3)
            r1.L$0 = r0
            r1.L$1 = r5
            r1.L$2 = r5
            r1.L$3 = r5
            r1.L$4 = r5
            r1.L$5 = r5
            r1.L$6 = r5
            r1.L$7 = r5
            r3 = 3
            r1.label = r3
            java.lang.Object r1 = io.ktor.websocket.WebSocketSessionKt.a(r4, r6, r1)
            if (r1 != r2) goto L_0x0227
            return r2
        L_0x0227:
            return r0
        L_0x0228:
            r0 = move-exception
            goto L_0x03ef
        L_0x022b:
            boolean r4 = r13 instanceof io.ktor.websocket.Frame.Pong     // Catch:{ all -> 0x004a }
            if (r4 == 0) goto L_0x025e
            java.lang.Object r4 = r8.pinger     // Catch:{ all -> 0x004a }
            kotlinx.coroutines.channels.SendChannel r4 = (kotlinx.coroutines.channels.SendChannel) r4     // Catch:{ all -> 0x004a }
            if (r4 == 0) goto L_0x0251
            r1.L$0 = r12     // Catch:{ all -> 0x004a }
            r1.L$1 = r11     // Catch:{ all -> 0x004a }
            r1.L$2 = r10     // Catch:{ all -> 0x004a }
            r1.L$3 = r9     // Catch:{ all -> 0x004a }
            r1.L$4 = r8     // Catch:{ all -> 0x004a }
            r1.L$5 = r7     // Catch:{ all -> 0x004a }
            r1.L$6 = r6     // Catch:{ all -> 0x004a }
            r1.L$7 = r0     // Catch:{ all -> 0x004a }
            r14 = 4
            r1.label = r14     // Catch:{ all -> 0x004a }
            java.lang.Object r4 = r4.L(r13, r1)     // Catch:{ all -> 0x004a }
            if (r4 != r2) goto L_0x024f
            return r2
        L_0x024f:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x004a }
        L_0x0251:
            r29 = r12
            r12 = r0
            r0 = r29
            r30 = r7
            r7 = r6
            r6 = r11
            r11 = r30
            goto L_0x039d
        L_0x025e:
            boolean r4 = r13 instanceof io.ktor.websocket.Frame.Ping     // Catch:{ all -> 0x004a }
            if (r4 == 0) goto L_0x027c
            r1.L$0 = r12     // Catch:{ all -> 0x004a }
            r1.L$1 = r11     // Catch:{ all -> 0x004a }
            r1.L$2 = r10     // Catch:{ all -> 0x004a }
            r1.L$3 = r9     // Catch:{ all -> 0x004a }
            r1.L$4 = r8     // Catch:{ all -> 0x004a }
            r1.L$5 = r7     // Catch:{ all -> 0x004a }
            r1.L$6 = r6     // Catch:{ all -> 0x004a }
            r1.L$7 = r0     // Catch:{ all -> 0x004a }
            r4 = 5
            r1.label = r4     // Catch:{ all -> 0x004a }
            java.lang.Object r4 = r7.L(r13, r1)     // Catch:{ all -> 0x004a }
            if (r4 != r2) goto L_0x0251
            return r2
        L_0x027c:
            T r4 = r10.element     // Catch:{ all -> 0x004a }
            io.ktor.utils.io.core.BytePacketBuilder r4 = (io.ktor.utils.io.core.BytePacketBuilder) r4     // Catch:{ all -> 0x004a }
            r1.L$0 = r12     // Catch:{ all -> 0x004a }
            r1.L$1 = r11     // Catch:{ all -> 0x004a }
            r1.L$2 = r10     // Catch:{ all -> 0x004a }
            r1.L$3 = r9     // Catch:{ all -> 0x004a }
            r1.L$4 = r8     // Catch:{ all -> 0x004a }
            r1.L$5 = r7     // Catch:{ all -> 0x004a }
            r1.L$6 = r6     // Catch:{ all -> 0x004a }
            r1.L$7 = r0     // Catch:{ all -> 0x004a }
            r1.L$8 = r13     // Catch:{ all -> 0x004a }
            r14 = 6
            r1.label = r14     // Catch:{ all -> 0x004a }
            java.lang.Object r4 = r8.j(r4, r13, r1)     // Catch:{ all -> 0x004a }
            if (r4 != r2) goto L_0x029c
            return r2
        L_0x029c:
            r29 = r6
            r6 = r0
            r0 = r13
            r13 = r12
            r12 = r11
            r11 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            r7 = r29
        L_0x02a8:
            boolean r4 = r0.c()     // Catch:{ all -> 0x0098 }
            if (r4 != 0) goto L_0x02e7
            T r4 = r12.element     // Catch:{ all -> 0x0098 }
            if (r4 != 0) goto L_0x02b4
            r12.element = r0     // Catch:{ all -> 0x0098 }
        L_0x02b4:
            T r4 = r11.element     // Catch:{ all -> 0x0098 }
            if (r4 != 0) goto L_0x02c0
            io.ktor.utils.io.core.BytePacketBuilder r4 = new io.ktor.utils.io.core.BytePacketBuilder     // Catch:{ all -> 0x0098 }
            r14 = 1
            r4.<init>(r5, r14, r5)     // Catch:{ all -> 0x0098 }
            r11.element = r4     // Catch:{ all -> 0x0098 }
        L_0x02c0:
            T r4 = r11.element     // Catch:{ all -> 0x0098 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)     // Catch:{ all -> 0x0098 }
            r16 = r4
            io.ktor.utils.io.core.Output r16 = (io.ktor.utils.io.core.Output) r16     // Catch:{ all -> 0x0098 }
            byte[] r17 = r0.b()     // Catch:{ all -> 0x0098 }
            r20 = 6
            r21 = 0
            r18 = 0
            r19 = 0
            io.ktor.utils.io.core.OutputKt.d(r16, r17, r18, r19, r20, r21)     // Catch:{ all -> 0x0098 }
            r0 = r13
            r29 = r12
            r12 = r6
            r6 = r29
            r30 = r11
            r11 = r8
            r8 = r9
            r9 = r10
            r10 = r30
            goto L_0x039d
        L_0x02e7:
            T r4 = r12.element     // Catch:{ all -> 0x0098 }
            if (r4 != 0) goto L_0x0319
            kotlinx.coroutines.channels.Channel r4 = r9.c     // Catch:{ all -> 0x0098 }
            io.ktor.websocket.Frame r0 = r9.p(r0)     // Catch:{ all -> 0x0098 }
            r1.L$0 = r13     // Catch:{ all -> 0x0098 }
            r1.L$1 = r12     // Catch:{ all -> 0x0098 }
            r1.L$2 = r11     // Catch:{ all -> 0x0098 }
            r1.L$3 = r10     // Catch:{ all -> 0x0098 }
            r1.L$4 = r9     // Catch:{ all -> 0x0098 }
            r1.L$5 = r8     // Catch:{ all -> 0x0098 }
            r1.L$6 = r7     // Catch:{ all -> 0x0098 }
            r1.L$7 = r6     // Catch:{ all -> 0x0098 }
            r1.L$8 = r5     // Catch:{ all -> 0x0098 }
            r14 = 7
            r1.label = r14     // Catch:{ all -> 0x0098 }
            java.lang.Object r0 = r4.L(r0, r1)     // Catch:{ all -> 0x0098 }
            if (r0 != r2) goto L_0x030f
            return r2
        L_0x030f:
            r0 = r6
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r10
            r10 = r11
            r11 = r12
            r12 = r13
            goto L_0x0251
        L_0x0319:
            T r4 = r11.element     // Catch:{ all -> 0x0098 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)     // Catch:{ all -> 0x0098 }
            r16 = r4
            io.ktor.utils.io.core.Output r16 = (io.ktor.utils.io.core.Output) r16     // Catch:{ all -> 0x0098 }
            byte[] r17 = r0.b()     // Catch:{ all -> 0x0098 }
            r20 = 6
            r21 = 0
            r18 = 0
            r19 = 0
            io.ktor.utils.io.core.OutputKt.d(r16, r17, r18, r19, r20, r21)     // Catch:{ all -> 0x0098 }
            io.ktor.websocket.Frame$Companion r22 = io.ktor.websocket.Frame.i     // Catch:{ all -> 0x0098 }
            T r0 = r12.element     // Catch:{ all -> 0x0098 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)     // Catch:{ all -> 0x0098 }
            io.ktor.websocket.Frame r0 = (io.ktor.websocket.Frame) r0     // Catch:{ all -> 0x0098 }
            io.ktor.websocket.FrameType r24 = r0.d()     // Catch:{ all -> 0x0098 }
            T r0 = r11.element     // Catch:{ all -> 0x0098 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)     // Catch:{ all -> 0x0098 }
            io.ktor.utils.io.core.BytePacketBuilder r0 = (io.ktor.utils.io.core.BytePacketBuilder) r0     // Catch:{ all -> 0x0098 }
            io.ktor.utils.io.core.ByteReadPacket r0 = r0.F0()     // Catch:{ all -> 0x0098 }
            r4 = 0
            r14 = 1
            byte[] r25 = io.ktor.utils.io.core.StringsKt.d(r0, r4, r14, r5)     // Catch:{ all -> 0x0098 }
            T r0 = r12.element     // Catch:{ all -> 0x0098 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)     // Catch:{ all -> 0x0098 }
            io.ktor.websocket.Frame r0 = (io.ktor.websocket.Frame) r0     // Catch:{ all -> 0x0098 }
            boolean r26 = r0.e()     // Catch:{ all -> 0x0098 }
            T r0 = r12.element     // Catch:{ all -> 0x0098 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)     // Catch:{ all -> 0x0098 }
            io.ktor.websocket.Frame r0 = (io.ktor.websocket.Frame) r0     // Catch:{ all -> 0x0098 }
            boolean r27 = r0.f()     // Catch:{ all -> 0x0098 }
            T r0 = r12.element     // Catch:{ all -> 0x0098 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)     // Catch:{ all -> 0x0098 }
            io.ktor.websocket.Frame r0 = (io.ktor.websocket.Frame) r0     // Catch:{ all -> 0x0098 }
            boolean r28 = r0.g()     // Catch:{ all -> 0x0098 }
            r23 = 1
            io.ktor.websocket.Frame r0 = r22.a(r23, r24, r25, r26, r27, r28)     // Catch:{ all -> 0x0098 }
            r12.element = r5     // Catch:{ all -> 0x0098 }
            kotlinx.coroutines.channels.Channel r4 = r9.c     // Catch:{ all -> 0x0098 }
            io.ktor.websocket.Frame r0 = r9.p(r0)     // Catch:{ all -> 0x0098 }
            r1.L$0 = r13     // Catch:{ all -> 0x0098 }
            r1.L$1 = r12     // Catch:{ all -> 0x0098 }
            r1.L$2 = r11     // Catch:{ all -> 0x0098 }
            r1.L$3 = r10     // Catch:{ all -> 0x0098 }
            r1.L$4 = r9     // Catch:{ all -> 0x0098 }
            r1.L$5 = r8     // Catch:{ all -> 0x0098 }
            r1.L$6 = r7     // Catch:{ all -> 0x0098 }
            r1.L$7 = r6     // Catch:{ all -> 0x0098 }
            r1.L$8 = r5     // Catch:{ all -> 0x0098 }
            r14 = 8
            r1.label = r14     // Catch:{ all -> 0x0098 }
            java.lang.Object r0 = r4.L(r0, r1)     // Catch:{ all -> 0x0098 }
            if (r0 != r2) goto L_0x030f
            return r2
        L_0x039d:
            r4 = 1
            goto L_0x0150
        L_0x03a0:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x004a }
            kotlinx.coroutines.channels.ChannelsKt.b(r6, r5)     // Catch:{ ClosedSendChannelException -> 0x0487, all -> 0x0228 }
            kotlinx.coroutines.channels.SendChannel<io.ktor.websocket.Frame$Ping> r0 = r1.$ponger
            r4 = 1
            kotlinx.coroutines.channels.SendChannel.DefaultImpls.a(r0, r5, r4, r5)
            T r0 = r10.element
            io.ktor.utils.io.core.BytePacketBuilder r0 = (io.ktor.utils.io.core.BytePacketBuilder) r0
            if (r0 == 0) goto L_0x03b4
            r0.release()
        L_0x03b4:
            io.ktor.websocket.DefaultWebSocketSessionImpl r0 = r1.this$0
            kotlinx.coroutines.channels.Channel r0 = r0.c
            kotlinx.coroutines.channels.SendChannel.DefaultImpls.a(r0, r5, r4, r5)
            boolean r0 = r9.element
            if (r0 != 0) goto L_0x04cb
            io.ktor.websocket.DefaultWebSocketSessionImpl r0 = r1.this$0
            io.ktor.websocket.CloseReason r4 = new io.ktor.websocket.CloseReason
            io.ktor.websocket.CloseReason$Codes r6 = io.ktor.websocket.CloseReason.Codes.CLOSED_ABNORMALLY
            r4.<init>((io.ktor.websocket.CloseReason.Codes) r6, (java.lang.String) r3)
            r1.L$0 = r5
            r1.L$1 = r5
            r1.L$2 = r5
            r1.L$3 = r5
            r1.L$4 = r5
            r1.L$5 = r5
            r1.L$6 = r5
            r1.L$7 = r5
            r3 = 9
            r1.label = r3
            java.lang.Object r0 = io.ktor.websocket.WebSocketSessionKt.a(r0, r4, r1)
            if (r0 != r2) goto L_0x04cb
            return r2
        L_0x03e5:
            r0 = move-exception
            r4 = r0
            r6 = r7
        L_0x03e8:
            throw r4     // Catch:{ all -> 0x03e9 }
        L_0x03e9:
            r0 = move-exception
            r7 = r0
            kotlinx.coroutines.channels.ChannelsKt.b(r6, r4)     // Catch:{ ClosedSendChannelException -> 0x0487, all -> 0x0228 }
            throw r7     // Catch:{ ClosedSendChannelException -> 0x0487, all -> 0x0228 }
        L_0x03ef:
            kotlinx.coroutines.channels.SendChannel<io.ktor.websocket.Frame$Ping> r4 = r1.$ponger     // Catch:{ all -> 0x0441 }
            r6 = 1
            kotlinx.coroutines.channels.SendChannel.DefaultImpls.a(r4, r5, r6, r5)     // Catch:{ all -> 0x0441 }
            io.ktor.websocket.DefaultWebSocketSessionImpl r4 = r1.this$0     // Catch:{ all -> 0x0441 }
            kotlinx.coroutines.channels.Channel r4 = r4.c     // Catch:{ all -> 0x0441 }
            r4.h(r0)     // Catch:{ all -> 0x0441 }
            kotlinx.coroutines.channels.SendChannel<io.ktor.websocket.Frame$Ping> r0 = r1.$ponger
            kotlinx.coroutines.channels.SendChannel.DefaultImpls.a(r0, r5, r6, r5)
            T r0 = r10.element
            io.ktor.utils.io.core.BytePacketBuilder r0 = (io.ktor.utils.io.core.BytePacketBuilder) r0
            if (r0 == 0) goto L_0x040e
            r0.release()
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x040e:
            io.ktor.websocket.DefaultWebSocketSessionImpl r0 = r1.this$0
            kotlinx.coroutines.channels.Channel r0 = r0.c
            kotlinx.coroutines.channels.SendChannel.DefaultImpls.a(r0, r5, r6, r5)
            boolean r0 = r9.element
            if (r0 != 0) goto L_0x04cb
            io.ktor.websocket.DefaultWebSocketSessionImpl r0 = r1.this$0
            io.ktor.websocket.CloseReason r4 = new io.ktor.websocket.CloseReason
            io.ktor.websocket.CloseReason$Codes r6 = io.ktor.websocket.CloseReason.Codes.CLOSED_ABNORMALLY
            r4.<init>((io.ktor.websocket.CloseReason.Codes) r6, (java.lang.String) r3)
            r1.L$0 = r5
            r1.L$1 = r5
            r1.L$2 = r5
            r1.L$3 = r5
            r1.L$4 = r5
            r1.L$5 = r5
            r1.L$6 = r5
            r1.L$7 = r5
            r1.L$8 = r5
            r3 = 11
            r1.label = r3
            java.lang.Object r0 = io.ktor.websocket.WebSocketSessionKt.a(r0, r4, r1)
            if (r0 != r2) goto L_0x04cb
            return r2
        L_0x0441:
            r0 = move-exception
            kotlinx.coroutines.channels.SendChannel<io.ktor.websocket.Frame$Ping> r4 = r1.$ponger
            r6 = 1
            kotlinx.coroutines.channels.SendChannel.DefaultImpls.a(r4, r5, r6, r5)
            T r4 = r10.element
            io.ktor.utils.io.core.BytePacketBuilder r4 = (io.ktor.utils.io.core.BytePacketBuilder) r4
            if (r4 == 0) goto L_0x0453
            r4.release()
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
        L_0x0453:
            io.ktor.websocket.DefaultWebSocketSessionImpl r4 = r1.this$0
            kotlinx.coroutines.channels.Channel r4 = r4.c
            kotlinx.coroutines.channels.SendChannel.DefaultImpls.a(r4, r5, r6, r5)
            boolean r4 = r9.element
            if (r4 != 0) goto L_0x0486
            io.ktor.websocket.DefaultWebSocketSessionImpl r4 = r1.this$0
            io.ktor.websocket.CloseReason r6 = new io.ktor.websocket.CloseReason
            io.ktor.websocket.CloseReason$Codes r7 = io.ktor.websocket.CloseReason.Codes.CLOSED_ABNORMALLY
            r6.<init>((io.ktor.websocket.CloseReason.Codes) r7, (java.lang.String) r3)
            r1.L$0 = r0
            r1.L$1 = r5
            r1.L$2 = r5
            r1.L$3 = r5
            r1.L$4 = r5
            r1.L$5 = r5
            r1.L$6 = r5
            r1.L$7 = r5
            r1.L$8 = r5
            r3 = 12
            r1.label = r3
            java.lang.Object r1 = io.ktor.websocket.WebSocketSessionKt.a(r4, r6, r1)
            if (r1 != r2) goto L_0x0486
            return r2
        L_0x0486:
            throw r0
        L_0x0487:
            kotlinx.coroutines.channels.SendChannel<io.ktor.websocket.Frame$Ping> r0 = r1.$ponger
            r4 = 1
            kotlinx.coroutines.channels.SendChannel.DefaultImpls.a(r0, r5, r4, r5)
            T r0 = r10.element
            io.ktor.utils.io.core.BytePacketBuilder r0 = (io.ktor.utils.io.core.BytePacketBuilder) r0
            if (r0 == 0) goto L_0x0498
            r0.release()
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x0498:
            io.ktor.websocket.DefaultWebSocketSessionImpl r0 = r1.this$0
            kotlinx.coroutines.channels.Channel r0 = r0.c
            kotlinx.coroutines.channels.SendChannel.DefaultImpls.a(r0, r5, r4, r5)
            boolean r0 = r9.element
            if (r0 != 0) goto L_0x04cb
            io.ktor.websocket.DefaultWebSocketSessionImpl r0 = r1.this$0
            io.ktor.websocket.CloseReason r4 = new io.ktor.websocket.CloseReason
            io.ktor.websocket.CloseReason$Codes r6 = io.ktor.websocket.CloseReason.Codes.CLOSED_ABNORMALLY
            r4.<init>((io.ktor.websocket.CloseReason.Codes) r6, (java.lang.String) r3)
            r1.L$0 = r5
            r1.L$1 = r5
            r1.L$2 = r5
            r1.L$3 = r5
            r1.L$4 = r5
            r1.L$5 = r5
            r1.L$6 = r5
            r1.L$7 = r5
            r1.L$8 = r5
            r3 = 10
            r1.label = r3
            java.lang.Object r0 = io.ktor.websocket.WebSocketSessionKt.a(r0, r4, r1)
            if (r0 != r2) goto L_0x04cb
            return r2
        L_0x04cb:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.DefaultWebSocketSessionImpl$runIncomingProcessor$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DefaultWebSocketSessionImpl$runIncomingProcessor$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
