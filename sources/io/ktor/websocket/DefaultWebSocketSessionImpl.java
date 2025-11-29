package io.ktor.websocket;

import io.ktor.websocket.DefaultWebSocketSession;
import io.ktor.websocket.Frame;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0000\u0018\u0000 ^2\u00020\u00012\u00020\u0002:\u0001eB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\r\u001a\u00020\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0012\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J)\u0010\u0018\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016H@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ%\u0010#\u001a\u00020\u00112\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\"\u001a\u00020!H@ø\u0001\u0000¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020!2\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020!2\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b'\u0010&J!\u0010+\u001a\u00020\u00112\u0010\u0010*\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030)0(H\u0016¢\u0006\u0004\b+\u0010,J\u0013\u0010-\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0004\b-\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u001a\u00103\u001a\b\u0012\u0004\u0012\u00020\u0014008\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u001a\u00107\u001a\b\u0012\u0004\u0012\u00020!048\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u001a\u00109\u001a\b\u0012\u0004\u0012\u00020!048\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00106R\u0014\u0010=\u001a\u00020:8\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u001e\u0010A\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030)0>8\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u001a\u0010G\u001a\u00020B8\u0016X\u0004¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR*\u0010O\u001a\u00020\u00042\u0006\u0010H\u001a\u00020\u00048\u0016@VX\u000e¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR*\u0010\u0006\u001a\u00020\u00042\u0006\u0010H\u001a\u00020\u00048\u0016@VX\u000e¢\u0006\u0012\n\u0004\bP\u0010J\u001a\u0004\bQ\u0010L\"\u0004\bR\u0010NR\"\u0010W\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140S8\u0016X\u0004¢\u0006\f\n\u0004\b#\u0010T\u001a\u0004\bU\u0010VR\u001a\u0010Z\u001a\b\u0012\u0004\u0012\u00020!0X8VX\u0004¢\u0006\u0006\u001a\u0004\bP\u0010YR\u001a\u0010]\u001a\b\u0012\u0004\u0012\u00020!0\t8VX\u0004¢\u0006\u0006\u001a\u0004\b[\u0010\\R\u001e\u0010`\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030)0(8VX\u0004¢\u0006\u0006\u001a\u0004\b^\u0010_R$\u0010d\u001a\u00020\u00042\u0006\u0010a\u001a\u00020\u00048V@VX\u000e¢\u0006\f\u001a\u0004\bb\u0010L\"\u0004\bc\u0010N\u0002\u0004\n\u0002\b\u0019¨\u0006f"}, d2 = {"Lio/ktor/websocket/DefaultWebSocketSessionImpl;", "Lio/ktor/websocket/DefaultWebSocketSession;", "Lio/ktor/websocket/WebSocketSession;", "raw", "", "pingInterval", "timeoutMillis", "<init>", "(Lio/ktor/websocket/WebSocketSession;JJ)V", "Lkotlinx/coroutines/channels/SendChannel;", "Lio/ktor/websocket/Frame$Ping;", "ponger", "Lkotlinx/coroutines/Job;", "r", "(Lkotlinx/coroutines/channels/SendChannel;)Lkotlinx/coroutines/Job;", "t", "()Lkotlinx/coroutines/Job;", "", "n", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/websocket/CloseReason;", "reason", "", "exception", "v", "(Lio/ktor/websocket/CloseReason;Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "x", "()Z", "s", "()V", "Lio/ktor/utils/io/core/BytePacketBuilder;", "packet", "Lio/ktor/websocket/Frame;", "frame", "j", "(Lio/ktor/utils/io/core/BytePacketBuilder;Lio/ktor/websocket/Frame;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "p", "(Lio/ktor/websocket/Frame;)Lio/ktor/websocket/Frame;", "q", "", "Lio/ktor/websocket/WebSocketExtension;", "negotiatedExtensions", "r0", "(Ljava/util/List;)V", "u", "a", "Lio/ktor/websocket/WebSocketSession;", "Lkotlinx/coroutines/CompletableDeferred;", "b", "Lkotlinx/coroutines/CompletableDeferred;", "closeReasonRef", "Lkotlinx/coroutines/channels/Channel;", "c", "Lkotlinx/coroutines/channels/Channel;", "filtered", "d", "outgoingToBeProcessed", "Lkotlinx/coroutines/CompletableJob;", "e", "Lkotlinx/coroutines/CompletableJob;", "context", "", "f", "Ljava/util/List;", "_extensions", "Lkotlin/coroutines/CoroutineContext;", "g", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "newValue", "h", "J", "l", "()J", "setPingIntervalMillis", "(J)V", "pingIntervalMillis", "i", "m", "setTimeoutMillis", "Lkotlinx/coroutines/Deferred;", "Lkotlinx/coroutines/Deferred;", "getCloseReason", "()Lkotlinx/coroutines/Deferred;", "closeReason", "Lkotlinx/coroutines/channels/ReceiveChannel;", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "incoming", "o", "()Lkotlinx/coroutines/channels/SendChannel;", "outgoing", "k", "()Ljava/util/List;", "extensions", "value", "z", "d0", "maxFrameSize", "Companion", "ktor-websockets"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nDefaultWebSocketSession.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DefaultWebSocketSession.kt\nio/ktor/websocket/DefaultWebSocketSessionImpl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,344:1\n1789#2,3:345\n1789#2,3:348\n*S KotlinDebug\n*F\n+ 1 DefaultWebSocketSession.kt\nio/ktor/websocket/DefaultWebSocketSessionImpl\n*L\n333#1:345,3\n336#1:348,3\n*E\n"})
public final class DefaultWebSocketSessionImpl implements DefaultWebSocketSession, WebSocketSession {
    public static final Companion k = new Companion((DefaultConstructorMarker) null);
    public static final /* synthetic */ AtomicReferenceFieldUpdater l;
    public static final /* synthetic */ AtomicIntegerFieldUpdater m;
    public static final /* synthetic */ AtomicIntegerFieldUpdater n;
    public static final Frame.Pong o = new Frame.Pong(new byte[0], NonDisposableHandle.f9131a);

    /* renamed from: a  reason: collision with root package name */
    public final WebSocketSession f9127a;
    public final CompletableDeferred b;
    public final Channel c;
    @NotNull
    private volatile /* synthetic */ int closed;
    public final Channel d;
    public final CompletableJob e;
    public final List f;
    public final CoroutineContext g;
    public long h;
    public long i;
    public final Deferred j;
    @NotNull
    volatile /* synthetic */ Object pinger = null;
    @NotNull
    private volatile /* synthetic */ int started;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lio/ktor/websocket/DefaultWebSocketSessionImpl$Companion;", "", "()V", "EmptyPong", "Lio/ktor/websocket/Frame$Pong;", "ktor-websockets"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    static {
        Class<DefaultWebSocketSessionImpl> cls = DefaultWebSocketSessionImpl.class;
        l = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "pinger");
        m = AtomicIntegerFieldUpdater.newUpdater(cls, "closed");
        n = AtomicIntegerFieldUpdater.newUpdater(cls, "started");
    }

    public DefaultWebSocketSessionImpl(WebSocketSession webSocketSession, long j2, long j3) {
        Intrinsics.checkNotNullParameter(webSocketSession, "raw");
        this.f9127a = webSocketSession;
        CompletableDeferred c2 = CompletableDeferredKt.c((Job) null, 1, (Object) null);
        this.b = c2;
        this.c = ChannelKt.b(8, (BufferOverflow) null, (Function1) null, 6, (Object) null);
        this.d = ChannelKt.b(UtilsKt.a(), (BufferOverflow) null, (Function1) null, 6, (Object) null);
        this.closed = 0;
        CompletableJob a2 = JobKt.a((Job) webSocketSession.getCoroutineContext().get(Job.b0));
        this.e = a2;
        this.f = new ArrayList();
        this.started = 0;
        this.g = webSocketSession.getCoroutineContext().plus(a2).plus(new CoroutineName("ws-default"));
        this.h = j2;
        this.i = j3;
        this.j = c2;
    }

    public static /* synthetic */ Object w(DefaultWebSocketSessionImpl defaultWebSocketSessionImpl, CloseReason closeReason, Throwable th, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            th = null;
        }
        return defaultWebSocketSessionImpl.v(closeReason, th, continuation);
    }

    public void d0(long j2) {
        this.f9127a.d0(j2);
    }

    public CoroutineContext getCoroutineContext() {
        return this.g;
    }

    public ReceiveChannel i() {
        return this.c;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object j(io.ktor.utils.io.core.BytePacketBuilder r9, io.ktor.websocket.Frame r10, kotlin.coroutines.Continuation r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof io.ktor.websocket.DefaultWebSocketSessionImpl$checkMaxFrameSize$1
            if (r0 == 0) goto L_0x0013
            r0 = r11
            io.ktor.websocket.DefaultWebSocketSessionImpl$checkMaxFrameSize$1 r0 = (io.ktor.websocket.DefaultWebSocketSessionImpl$checkMaxFrameSize$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.websocket.DefaultWebSocketSessionImpl$checkMaxFrameSize$1 r0 = new io.ktor.websocket.DefaultWebSocketSessionImpl$checkMaxFrameSize$1
            r0.<init>(r8, r11)
        L_0x0018:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0033
            if (r2 == r3) goto L_0x002d
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x002d:
            int r8 = r0.I$0
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0082
        L_0x0033:
            kotlin.ResultKt.throwOnFailure(r11)
            byte[] r10 = r10.b()
            int r10 = r10.length
            if (r9 == 0) goto L_0x0042
            int r11 = r9.G0()
            goto L_0x0043
        L_0x0042:
            r11 = 0
        L_0x0043:
            int r10 = r10 + r11
            long r4 = (long) r10
            long r6 = r8.z()
            int r11 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r11 <= 0) goto L_0x0089
            if (r9 == 0) goto L_0x0052
            r9.release()
        L_0x0052:
            io.ktor.websocket.CloseReason r9 = new io.ktor.websocket.CloseReason
            io.ktor.websocket.CloseReason$Codes r11 = io.ktor.websocket.CloseReason.Codes.TOO_BIG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "Frame is too big: "
            r2.append(r4)
            r2.append(r10)
            java.lang.String r4 = ". Max size is "
            r2.append(r4)
            long r4 = r8.z()
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r9.<init>((io.ktor.websocket.CloseReason.Codes) r11, (java.lang.String) r2)
            r0.I$0 = r10
            r0.label = r3
            java.lang.Object r8 = io.ktor.websocket.WebSocketSessionKt.a(r8, r9, r0)
            if (r8 != r1) goto L_0x0081
            return r1
        L_0x0081:
            r8 = r10
        L_0x0082:
            io.ktor.websocket.FrameTooBigException r9 = new io.ktor.websocket.FrameTooBigException
            long r10 = (long) r8
            r9.<init>(r10)
            throw r9
        L_0x0089:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.DefaultWebSocketSessionImpl.j(io.ktor.utils.io.core.BytePacketBuilder, io.ktor.websocket.Frame, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public List k() {
        return this.f;
    }

    public long l() {
        return this.h;
    }

    public long m() {
        return this.i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object n(kotlin.coroutines.Continuation r13) {
        /*
            r12 = this;
            boolean r0 = r13 instanceof io.ktor.websocket.DefaultWebSocketSessionImpl$outgoingProcessorLoop$1
            if (r0 == 0) goto L_0x0013
            r0 = r13
            io.ktor.websocket.DefaultWebSocketSessionImpl$outgoingProcessorLoop$1 r0 = (io.ktor.websocket.DefaultWebSocketSessionImpl$outgoingProcessorLoop$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.websocket.DefaultWebSocketSessionImpl$outgoingProcessorLoop$1 r0 = new io.ktor.websocket.DefaultWebSocketSessionImpl$outgoingProcessorLoop$1
            r0.<init>(r12, r13)
        L_0x0018:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0054
            if (r2 == r5) goto L_0x0046
            if (r2 == r4) goto L_0x0041
            if (r2 != r3) goto L_0x0039
            java.lang.Object r12 = r0.L$1
            kotlinx.coroutines.channels.ChannelIterator r12 = (kotlinx.coroutines.channels.ChannelIterator) r12
            java.lang.Object r2 = r0.L$0
            io.ktor.websocket.DefaultWebSocketSessionImpl r2 = (io.ktor.websocket.DefaultWebSocketSessionImpl) r2
            kotlin.ResultKt.throwOnFailure(r13)
            r13 = r12
            r12 = r2
            goto L_0x005d
        L_0x0039:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x00dc
        L_0x0046:
            java.lang.Object r12 = r0.L$1
            kotlinx.coroutines.channels.ChannelIterator r12 = (kotlinx.coroutines.channels.ChannelIterator) r12
            java.lang.Object r2 = r0.L$0
            io.ktor.websocket.DefaultWebSocketSessionImpl r2 = (io.ktor.websocket.DefaultWebSocketSessionImpl) r2
            kotlin.ResultKt.throwOnFailure(r13)
            r9 = r0
            r6 = r2
            goto L_0x006e
        L_0x0054:
            kotlin.ResultKt.throwOnFailure(r13)
            kotlinx.coroutines.channels.Channel r13 = r12.d
            kotlinx.coroutines.channels.ChannelIterator r13 = r13.iterator()
        L_0x005d:
            r0.L$0 = r12
            r0.L$1 = r13
            r0.label = r5
            java.lang.Object r2 = r13.a(r0)
            if (r2 != r1) goto L_0x006a
            return r1
        L_0x006a:
            r6 = r12
            r12 = r13
            r9 = r0
            r13 = r2
        L_0x006e:
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            if (r13 == 0) goto L_0x00dc
            java.lang.Object r13 = r12.next()
            io.ktor.websocket.Frame r13 = (io.ktor.websocket.Frame) r13
            org.slf4j.Logger r0 = io.ktor.websocket.DefaultWebSocketSessionKt.e()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r7 = "Sending "
            r2.append(r7)
            r2.append(r13)
            java.lang.String r7 = " from session "
            r2.append(r7)
            r2.append(r6)
            java.lang.String r2 = r2.toString()
            r0.trace(r2)
            boolean r0 = r13 instanceof io.ktor.websocket.Frame.Close
            if (r0 == 0) goto L_0x00b7
            io.ktor.websocket.Frame$Close r13 = (io.ktor.websocket.Frame.Close) r13
            io.ktor.websocket.CloseReason r7 = io.ktor.websocket.FrameCommonKt.a(r13)
            r12 = 0
            r9.L$0 = r12
            r9.L$1 = r12
            r9.label = r4
            r8 = 0
            r10 = 2
            r11 = 0
            java.lang.Object r12 = w(r6, r7, r8, r9, r10, r11)
            if (r12 != r1) goto L_0x00dc
            return r1
        L_0x00b7:
            boolean r0 = r13 instanceof io.ktor.websocket.Frame.Text
            if (r0 == 0) goto L_0x00bd
            r0 = r5
            goto L_0x00bf
        L_0x00bd:
            boolean r0 = r13 instanceof io.ktor.websocket.Frame.Binary
        L_0x00bf:
            if (r0 == 0) goto L_0x00c5
            io.ktor.websocket.Frame r13 = r6.q(r13)
        L_0x00c5:
            io.ktor.websocket.WebSocketSession r0 = r6.f9127a
            kotlinx.coroutines.channels.SendChannel r0 = r0.o()
            r9.L$0 = r6
            r9.L$1 = r12
            r9.label = r3
            java.lang.Object r13 = r0.L(r13, r9)
            if (r13 != r1) goto L_0x00d8
            return r1
        L_0x00d8:
            r13 = r12
            r12 = r6
            r0 = r9
            goto L_0x005d
        L_0x00dc:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.DefaultWebSocketSessionImpl.n(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public SendChannel o() {
        return this.d;
    }

    public final Frame p(Frame frame) {
        for (WebSocketExtension c2 : k()) {
            frame = c2.c(frame);
        }
        return frame;
    }

    public final Frame q(Frame frame) {
        for (WebSocketExtension b2 : k()) {
            frame = b2.b(frame);
        }
        return frame;
    }

    public Object q0(Frame frame, Continuation continuation) {
        return DefaultWebSocketSession.DefaultImpls.a(this, frame, continuation);
    }

    public final Job r(SendChannel sendChannel) {
        return BuildersKt__Builders_commonKt.d(this, DefaultWebSocketSessionKt.b.plus(Dispatchers.d()), (CoroutineStart) null, new DefaultWebSocketSessionImpl$runIncomingProcessor$1(this, sendChannel, (Continuation<? super DefaultWebSocketSessionImpl$runIncomingProcessor$1>) null), 2, (Object) null);
    }

    public void r0(List list) {
        Intrinsics.checkNotNullParameter(list, "negotiatedExtensions");
        if (n.compareAndSet(this, 0, 1)) {
            Logger e2 = DefaultWebSocketSessionKt.e();
            e2.trace("Starting default WebSocketSession(" + this + ") with negotiated extensions: " + CollectionsKt.joinToString$default(list, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null));
            this.f.addAll(list);
            s();
            r(PingPongKt.b(this, o()));
            t();
            return;
        }
        throw new IllegalStateException(("WebSocket session " + this + " is already started.").toString());
    }

    public final void s() {
        SendChannel sendChannel;
        long l2 = l();
        if (this.closed == 0 && l2 > 0) {
            sendChannel = PingPongKt.a(this, this.f9127a.o(), l2, m(), new DefaultWebSocketSessionImpl$runOrCancelPinger$newPinger$1(this, (Continuation<? super DefaultWebSocketSessionImpl$runOrCancelPinger$newPinger$1>) null));
        } else {
            sendChannel = null;
        }
        SendChannel sendChannel2 = (SendChannel) l.getAndSet(this, sendChannel);
        if (sendChannel2 != null) {
            SendChannel.DefaultImpls.a(sendChannel2, (Throwable) null, 1, (Object) null);
        }
        if (sendChannel != null) {
            ChannelResult.j(sendChannel.q(o));
        }
        if (this.closed != 0 && sendChannel != null) {
            s();
        }
    }

    public final Job t() {
        return BuildersKt.c(this, DefaultWebSocketSessionKt.c.plus(Dispatchers.d()), CoroutineStart.UNDISPATCHED, new DefaultWebSocketSessionImpl$runOutgoingProcessor$1(this, (Continuation<? super DefaultWebSocketSessionImpl$runOutgoingProcessor$1>) null));
    }

    public Object u(Continuation continuation) {
        Object u = this.f9127a.u(continuation);
        return u == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? u : Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: java.lang.Throwable} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object v(io.ktor.websocket.CloseReason r7, java.lang.Throwable r8, kotlin.coroutines.Continuation r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof io.ktor.websocket.DefaultWebSocketSessionImpl$sendCloseSequence$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            io.ktor.websocket.DefaultWebSocketSessionImpl$sendCloseSequence$1 r0 = (io.ktor.websocket.DefaultWebSocketSessionImpl$sendCloseSequence$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.websocket.DefaultWebSocketSessionImpl$sendCloseSequence$1 r0 = new io.ktor.websocket.DefaultWebSocketSessionImpl$sendCloseSequence$1
            r0.<init>(r6, r9)
        L_0x0018:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0048
            if (r2 != r3) goto L_0x0040
            java.lang.Object r6 = r0.L$2
            io.ktor.websocket.CloseReason r6 = (io.ktor.websocket.CloseReason) r6
            java.lang.Object r7 = r0.L$1
            r8 = r7
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            java.lang.Object r7 = r0.L$0
            io.ktor.websocket.DefaultWebSocketSessionImpl r7 = (io.ktor.websocket.DefaultWebSocketSessionImpl) r7
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ all -> 0x003a }
            r5 = r7
            r7 = r6
            r6 = r5
            goto L_0x00b7
        L_0x003a:
            r9 = move-exception
            r5 = r7
            r7 = r6
            r6 = r5
            goto L_0x00cb
        L_0x0040:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0048:
            kotlin.ResultKt.throwOnFailure(r9)
            boolean r9 = r6.x()
            if (r9 != 0) goto L_0x0054
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x0054:
            org.slf4j.Logger r9 = io.ktor.websocket.DefaultWebSocketSessionKt.e()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "Sending Close Sequence for session "
            r2.append(r4)
            r2.append(r6)
            java.lang.String r4 = " with reason "
            r2.append(r4)
            r2.append(r7)
            java.lang.String r4 = " and exception "
            r2.append(r4)
            r2.append(r8)
            java.lang.String r2 = r2.toString()
            r9.trace(r2)
            kotlinx.coroutines.CompletableJob r9 = r6.e
            r9.complete()
            if (r7 != 0) goto L_0x008c
            io.ktor.websocket.CloseReason r7 = new io.ktor.websocket.CloseReason
            io.ktor.websocket.CloseReason$Codes r9 = io.ktor.websocket.CloseReason.Codes.NORMAL
            java.lang.String r2 = ""
            r7.<init>((io.ktor.websocket.CloseReason.Codes) r9, (java.lang.String) r2)
        L_0x008c:
            r6.s()     // Catch:{ all -> 0x00b5 }
            short r9 = r7.a()     // Catch:{ all -> 0x00b5 }
            io.ktor.websocket.CloseReason$Codes r2 = io.ktor.websocket.CloseReason.Codes.CLOSED_ABNORMALLY     // Catch:{ all -> 0x00b5 }
            short r2 = r2.getCode()     // Catch:{ all -> 0x00b5 }
            if (r9 == r2) goto L_0x00b7
            io.ktor.websocket.WebSocketSession r9 = r6.f9127a     // Catch:{ all -> 0x00b5 }
            kotlinx.coroutines.channels.SendChannel r9 = r9.o()     // Catch:{ all -> 0x00b5 }
            io.ktor.websocket.Frame$Close r2 = new io.ktor.websocket.Frame$Close     // Catch:{ all -> 0x00b5 }
            r2.<init>((io.ktor.websocket.CloseReason) r7)     // Catch:{ all -> 0x00b5 }
            r0.L$0 = r6     // Catch:{ all -> 0x00b5 }
            r0.L$1 = r8     // Catch:{ all -> 0x00b5 }
            r0.L$2 = r7     // Catch:{ all -> 0x00b5 }
            r0.label = r3     // Catch:{ all -> 0x00b5 }
            java.lang.Object r9 = r9.L(r2, r0)     // Catch:{ all -> 0x00b5 }
            if (r9 != r1) goto L_0x00b7
            return r1
        L_0x00b5:
            r9 = move-exception
            goto L_0x00cb
        L_0x00b7:
            kotlinx.coroutines.CompletableDeferred r9 = r6.b
            r9.w(r7)
            if (r8 == 0) goto L_0x00c8
            kotlinx.coroutines.channels.Channel r7 = r6.d
            r7.h(r8)
            kotlinx.coroutines.channels.Channel r6 = r6.c
            r6.h(r8)
        L_0x00c8:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x00cb:
            kotlinx.coroutines.CompletableDeferred r0 = r6.b
            r0.w(r7)
            if (r8 == 0) goto L_0x00dc
            kotlinx.coroutines.channels.Channel r7 = r6.d
            r7.h(r8)
            kotlinx.coroutines.channels.Channel r6 = r6.c
            r6.h(r8)
        L_0x00dc:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.DefaultWebSocketSessionImpl.v(io.ktor.websocket.CloseReason, java.lang.Throwable, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final boolean x() {
        return m.compareAndSet(this, 0, 1);
    }

    public long z() {
        return this.f9127a.z();
    }
}
