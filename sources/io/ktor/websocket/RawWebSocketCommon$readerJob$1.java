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
@DebugMetadata(c = "io.ktor.websocket.RawWebSocketCommon$readerJob$1", f = "RawWebSocketCommon.kt", i = {2, 3}, l = {88, 92, 95, 99}, m = "invokeSuspend", n = {"cause", "cause"}, s = {"L$0", "L$0"})
final class RawWebSocketCommon$readerJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ RawWebSocketCommon this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RawWebSocketCommon$readerJob$1(RawWebSocketCommon rawWebSocketCommon, Continuation<? super RawWebSocketCommon$readerJob$1> continuation) {
        super(2, continuation);
        this.this$0 = rawWebSocketCommon;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RawWebSocketCommon$readerJob$1(this.this$0, continuation);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0062 A[Catch:{ FrameTooBigException -> 0x003e, ProtocolViolationException -> 0x003b, CancellationException -> 0x0038, EOFException | ClosedReceiveChannelException -> 0x00a6, ChannelIOException -> 0x009d, all -> 0x0036, all -> 0x001e }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x006f A[Catch:{ FrameTooBigException -> 0x003e, ProtocolViolationException -> 0x003b, CancellationException -> 0x0038, EOFException | ClosedReceiveChannelException -> 0x00a6, ChannelIOException -> 0x009d, all -> 0x0036, all -> 0x001e }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0092 A[RETURN] */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.label
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r1 == 0) goto L_0x0045
            if (r1 == r5) goto L_0x0041
            if (r1 == r4) goto L_0x0032
            if (r1 == r3) goto L_0x0029
            if (r1 != r2) goto L_0x0021
            java.lang.Object r0 = r9.L$0
            io.ktor.websocket.ProtocolViolationException r0 = (io.ktor.websocket.ProtocolViolationException) r0
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x001e }
            goto L_0x00dc
        L_0x001e:
            r10 = move-exception
            goto L_0x0115
        L_0x0021:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0029:
            java.lang.Object r0 = r9.L$0
            io.ktor.websocket.FrameTooBigException r0 = (io.ktor.websocket.FrameTooBigException) r0
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x001e }
            goto L_0x0108
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ FrameTooBigException -> 0x003e, ProtocolViolationException -> 0x003b, CancellationException -> 0x0038, EOFException | ClosedReceiveChannelException -> 0x00a6, ChannelIOException -> 0x009d, all -> 0x0036 }
            goto L_0x0048
        L_0x0036:
            r10 = move-exception
            goto L_0x0093
        L_0x0038:
            r10 = move-exception
            goto L_0x00b0
        L_0x003b:
            r10 = move-exception
            goto L_0x00ba
        L_0x003e:
            r10 = move-exception
            goto L_0x00e6
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ FrameTooBigException -> 0x003e, ProtocolViolationException -> 0x003b, CancellationException -> 0x0038, EOFException | ClosedReceiveChannelException -> 0x00a6, ChannelIOException -> 0x009d, all -> 0x0036 }
            goto L_0x0063
        L_0x0045:
            kotlin.ResultKt.throwOnFailure(r10)
        L_0x0048:
            io.ktor.websocket.RawWebSocketCommon r10 = r9.this$0     // Catch:{ FrameTooBigException -> 0x003e, ProtocolViolationException -> 0x003b, CancellationException -> 0x0038, EOFException | ClosedReceiveChannelException -> 0x00a6, ChannelIOException -> 0x009d, all -> 0x0036 }
            io.ktor.utils.io.ByteReadChannel r10 = r10.f9133a     // Catch:{ FrameTooBigException -> 0x003e, ProtocolViolationException -> 0x003b, CancellationException -> 0x0038, EOFException | ClosedReceiveChannelException -> 0x00a6, ChannelIOException -> 0x009d, all -> 0x0036 }
            io.ktor.websocket.RawWebSocketCommon r1 = r9.this$0     // Catch:{ FrameTooBigException -> 0x003e, ProtocolViolationException -> 0x003b, CancellationException -> 0x0038, EOFException | ClosedReceiveChannelException -> 0x00a6, ChannelIOException -> 0x009d, all -> 0x0036 }
            long r7 = r1.z()     // Catch:{ FrameTooBigException -> 0x003e, ProtocolViolationException -> 0x003b, CancellationException -> 0x0038, EOFException | ClosedReceiveChannelException -> 0x00a6, ChannelIOException -> 0x009d, all -> 0x0036 }
            io.ktor.websocket.RawWebSocketCommon r1 = r9.this$0     // Catch:{ FrameTooBigException -> 0x003e, ProtocolViolationException -> 0x003b, CancellationException -> 0x0038, EOFException | ClosedReceiveChannelException -> 0x00a6, ChannelIOException -> 0x009d, all -> 0x0036 }
            int r1 = r1.g     // Catch:{ FrameTooBigException -> 0x003e, ProtocolViolationException -> 0x003b, CancellationException -> 0x0038, EOFException | ClosedReceiveChannelException -> 0x00a6, ChannelIOException -> 0x009d, all -> 0x0036 }
            r9.label = r5     // Catch:{ FrameTooBigException -> 0x003e, ProtocolViolationException -> 0x003b, CancellationException -> 0x0038, EOFException | ClosedReceiveChannelException -> 0x00a6, ChannelIOException -> 0x009d, all -> 0x0036 }
            java.lang.Object r10 = io.ktor.websocket.RawWebSocketCommonKt.b(r10, r7, r1, r9)     // Catch:{ FrameTooBigException -> 0x003e, ProtocolViolationException -> 0x003b, CancellationException -> 0x0038, EOFException | ClosedReceiveChannelException -> 0x00a6, ChannelIOException -> 0x009d, all -> 0x0036 }
            if (r10 != r0) goto L_0x0063
            return r0
        L_0x0063:
            io.ktor.websocket.Frame r10 = (io.ktor.websocket.Frame) r10     // Catch:{ FrameTooBigException -> 0x003e, ProtocolViolationException -> 0x003b, CancellationException -> 0x0038, EOFException | ClosedReceiveChannelException -> 0x00a6, ChannelIOException -> 0x009d, all -> 0x0036 }
            io.ktor.websocket.FrameType r1 = r10.d()     // Catch:{ FrameTooBigException -> 0x003e, ProtocolViolationException -> 0x003b, CancellationException -> 0x0038, EOFException | ClosedReceiveChannelException -> 0x00a6, ChannelIOException -> 0x009d, all -> 0x0036 }
            boolean r1 = r1.getControlFrame()     // Catch:{ FrameTooBigException -> 0x003e, ProtocolViolationException -> 0x003b, CancellationException -> 0x0038, EOFException | ClosedReceiveChannelException -> 0x00a6, ChannelIOException -> 0x009d, all -> 0x0036 }
            if (r1 != 0) goto L_0x0084
            io.ktor.websocket.RawWebSocketCommon r1 = r9.this$0     // Catch:{ FrameTooBigException -> 0x003e, ProtocolViolationException -> 0x003b, CancellationException -> 0x0038, EOFException | ClosedReceiveChannelException -> 0x00a6, ChannelIOException -> 0x009d, all -> 0x0036 }
            boolean r7 = r10.c()     // Catch:{ FrameTooBigException -> 0x003e, ProtocolViolationException -> 0x003b, CancellationException -> 0x0038, EOFException | ClosedReceiveChannelException -> 0x00a6, ChannelIOException -> 0x009d, all -> 0x0036 }
            if (r7 == 0) goto L_0x0079
            r7 = 0
            goto L_0x0081
        L_0x0079:
            io.ktor.websocket.FrameType r7 = r10.d()     // Catch:{ FrameTooBigException -> 0x003e, ProtocolViolationException -> 0x003b, CancellationException -> 0x0038, EOFException | ClosedReceiveChannelException -> 0x00a6, ChannelIOException -> 0x009d, all -> 0x0036 }
            int r7 = r7.getOpcode()     // Catch:{ FrameTooBigException -> 0x003e, ProtocolViolationException -> 0x003b, CancellationException -> 0x0038, EOFException | ClosedReceiveChannelException -> 0x00a6, ChannelIOException -> 0x009d, all -> 0x0036 }
        L_0x0081:
            r1.g = r7     // Catch:{ FrameTooBigException -> 0x003e, ProtocolViolationException -> 0x003b, CancellationException -> 0x0038, EOFException | ClosedReceiveChannelException -> 0x00a6, ChannelIOException -> 0x009d, all -> 0x0036 }
        L_0x0084:
            io.ktor.websocket.RawWebSocketCommon r1 = r9.this$0     // Catch:{ FrameTooBigException -> 0x003e, ProtocolViolationException -> 0x003b, CancellationException -> 0x0038, EOFException | ClosedReceiveChannelException -> 0x00a6, ChannelIOException -> 0x009d, all -> 0x0036 }
            kotlinx.coroutines.channels.Channel r1 = r1.e     // Catch:{ FrameTooBigException -> 0x003e, ProtocolViolationException -> 0x003b, CancellationException -> 0x0038, EOFException | ClosedReceiveChannelException -> 0x00a6, ChannelIOException -> 0x009d, all -> 0x0036 }
            r9.label = r4     // Catch:{ FrameTooBigException -> 0x003e, ProtocolViolationException -> 0x003b, CancellationException -> 0x0038, EOFException | ClosedReceiveChannelException -> 0x00a6, ChannelIOException -> 0x009d, all -> 0x0036 }
            java.lang.Object r10 = r1.L(r10, r9)     // Catch:{ FrameTooBigException -> 0x003e, ProtocolViolationException -> 0x003b, CancellationException -> 0x0038, EOFException | ClosedReceiveChannelException -> 0x00a6, ChannelIOException -> 0x009d, all -> 0x0036 }
            if (r10 != r0) goto L_0x0048
            return r0
        L_0x0093:
            io.ktor.websocket.RawWebSocketCommon r0 = r9.this$0     // Catch:{ all -> 0x001e }
            kotlinx.coroutines.channels.Channel r0 = r0.e     // Catch:{ all -> 0x001e }
            r0.h(r10)     // Catch:{ all -> 0x001e }
            throw r10     // Catch:{ all -> 0x001e }
        L_0x009d:
            io.ktor.websocket.RawWebSocketCommon r10 = r9.this$0     // Catch:{ all -> 0x001e }
            kotlinx.coroutines.channels.Channel r10 = r10.e     // Catch:{ all -> 0x001e }
            kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.a(r10, r6, r5, r6)     // Catch:{ all -> 0x001e }
        L_0x00a6:
            io.ktor.websocket.RawWebSocketCommon r9 = r9.this$0
            kotlinx.coroutines.channels.Channel r9 = r9.e
            kotlinx.coroutines.channels.SendChannel.DefaultImpls.a(r9, r6, r5, r6)
            goto L_0x0112
        L_0x00b0:
            io.ktor.websocket.RawWebSocketCommon r0 = r9.this$0     // Catch:{ all -> 0x001e }
            kotlinx.coroutines.channels.Channel r0 = r0.e     // Catch:{ all -> 0x001e }
            r0.a(r10)     // Catch:{ all -> 0x001e }
            goto L_0x00a6
        L_0x00ba:
            io.ktor.websocket.RawWebSocketCommon r1 = r9.this$0     // Catch:{ all -> 0x001e }
            kotlinx.coroutines.channels.SendChannel r1 = r1.o()     // Catch:{ all -> 0x001e }
            io.ktor.websocket.Frame$Close r3 = new io.ktor.websocket.Frame$Close     // Catch:{ all -> 0x001e }
            io.ktor.websocket.CloseReason r4 = new io.ktor.websocket.CloseReason     // Catch:{ all -> 0x001e }
            io.ktor.websocket.CloseReason$Codes r7 = io.ktor.websocket.CloseReason.Codes.PROTOCOL_ERROR     // Catch:{ all -> 0x001e }
            java.lang.String r8 = r10.getMessage()     // Catch:{ all -> 0x001e }
            r4.<init>((io.ktor.websocket.CloseReason.Codes) r7, (java.lang.String) r8)     // Catch:{ all -> 0x001e }
            r3.<init>((io.ktor.websocket.CloseReason) r4)     // Catch:{ all -> 0x001e }
            r9.L$0 = r10     // Catch:{ all -> 0x001e }
            r9.label = r2     // Catch:{ all -> 0x001e }
            java.lang.Object r1 = r1.L(r3, r9)     // Catch:{ all -> 0x001e }
            if (r1 != r0) goto L_0x00db
            return r0
        L_0x00db:
            r0 = r10
        L_0x00dc:
            io.ktor.websocket.RawWebSocketCommon r10 = r9.this$0     // Catch:{ all -> 0x001e }
            kotlinx.coroutines.channels.Channel r10 = r10.e     // Catch:{ all -> 0x001e }
            r10.h(r0)     // Catch:{ all -> 0x001e }
            goto L_0x00a6
        L_0x00e6:
            io.ktor.websocket.RawWebSocketCommon r1 = r9.this$0     // Catch:{ all -> 0x001e }
            kotlinx.coroutines.channels.SendChannel r1 = r1.o()     // Catch:{ all -> 0x001e }
            io.ktor.websocket.Frame$Close r2 = new io.ktor.websocket.Frame$Close     // Catch:{ all -> 0x001e }
            io.ktor.websocket.CloseReason r4 = new io.ktor.websocket.CloseReason     // Catch:{ all -> 0x001e }
            io.ktor.websocket.CloseReason$Codes r7 = io.ktor.websocket.CloseReason.Codes.TOO_BIG     // Catch:{ all -> 0x001e }
            java.lang.String r8 = r10.getMessage()     // Catch:{ all -> 0x001e }
            r4.<init>((io.ktor.websocket.CloseReason.Codes) r7, (java.lang.String) r8)     // Catch:{ all -> 0x001e }
            r2.<init>((io.ktor.websocket.CloseReason) r4)     // Catch:{ all -> 0x001e }
            r9.L$0 = r10     // Catch:{ all -> 0x001e }
            r9.label = r3     // Catch:{ all -> 0x001e }
            java.lang.Object r1 = r1.L(r2, r9)     // Catch:{ all -> 0x001e }
            if (r1 != r0) goto L_0x0107
            return r0
        L_0x0107:
            r0 = r10
        L_0x0108:
            io.ktor.websocket.RawWebSocketCommon r10 = r9.this$0     // Catch:{ all -> 0x001e }
            kotlinx.coroutines.channels.Channel r10 = r10.e     // Catch:{ all -> 0x001e }
            r10.h(r0)     // Catch:{ all -> 0x001e }
            goto L_0x00a6
        L_0x0112:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L_0x0115:
            io.ktor.websocket.RawWebSocketCommon r9 = r9.this$0
            kotlinx.coroutines.channels.Channel r9 = r9.e
            kotlinx.coroutines.channels.SendChannel.DefaultImpls.a(r9, r6, r5, r6)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.RawWebSocketCommon$readerJob$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RawWebSocketCommon$readerJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
