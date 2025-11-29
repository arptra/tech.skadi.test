package io.ktor.websocket;

import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.pool.ObjectPool;
import io.ktor.websocket.Frame;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.SendChannel;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u00015J\u0013\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\nJ#\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0005H@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\u00148\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\"\u0010 \u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050!8\u0006¢\u0006\f\n\u0004\b\t\u0010\"\u001a\u0004\b#\u0010$R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020'0&8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010(R\u0014\u0010,\u001a\u00020*8\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010+R\u001a\u00100\u001a\u00020-8\u0002X\u0004¢\u0006\f\n\u0004\b\u001e\u0010.\u0012\u0004\b/\u0010\nR\u0017\u00104\u001a\b\u0012\u0004\u0012\u00020\u000b018F¢\u0006\u0006\u001a\u0004\b2\u00103\u0002\u0004\n\u0002\b\u0019¨\u00066"}, d2 = {"Lio/ktor/websocket/WebSocketWriter;", "Lkotlinx/coroutines/CoroutineScope;", "", "u", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/nio/ByteBuffer;", "buffer", "h", "(Ljava/nio/ByteBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "d", "()V", "Lio/ktor/websocket/Frame;", "firstMsg", "", "e", "(Lio/ktor/websocket/Frame;Ljava/nio/ByteBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/ByteWriteChannel;", "a", "Lio/ktor/utils/io/ByteWriteChannel;", "writeChannel", "Lkotlin/coroutines/CoroutineContext;", "b", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "c", "Z", "getMasking", "()Z", "g", "(Z)V", "masking", "Lio/ktor/utils/io/pool/ObjectPool;", "Lio/ktor/utils/io/pool/ObjectPool;", "f", "()Lio/ktor/utils/io/pool/ObjectPool;", "pool", "Lkotlinx/coroutines/channels/Channel;", "", "Lkotlinx/coroutines/channels/Channel;", "queue", "Lio/ktor/websocket/Serializer;", "Lio/ktor/websocket/Serializer;", "serializer", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/Job;", "getWriteLoopJob$annotations", "writeLoopJob", "Lkotlinx/coroutines/channels/SendChannel;", "o", "()Lkotlinx/coroutines/channels/SendChannel;", "outgoing", "FlushRequest", "ktor-websockets"}, k = 1, mv = {1, 8, 0})
public final class WebSocketWriter implements CoroutineScope {

    /* renamed from: a  reason: collision with root package name */
    public final ByteWriteChannel f9145a;
    public final CoroutineContext b;
    public boolean c;
    public final ObjectPool d;
    public final Channel e;
    public final Serializer f;
    public final Job g;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\n\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\r\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lio/ktor/websocket/WebSocketWriter$FlushRequest;", "", "Lkotlinx/coroutines/Job;", "parent", "<init>", "(Lkotlinx/coroutines/Job;)V", "", "b", "()Z", "", "a", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/CompletableJob;", "Lkotlinx/coroutines/CompletableJob;", "done", "ktor-websockets"}, k = 1, mv = {1, 8, 0})
    public static final class FlushRequest {

        /* renamed from: a  reason: collision with root package name */
        public final CompletableJob f9146a;

        public FlushRequest(Job job) {
            this.f9146a = JobKt.a(job);
        }

        public final Object a(Continuation continuation) {
            Object i0 = this.f9146a.i0(continuation);
            return i0 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? i0 : Unit.INSTANCE;
        }

        public final boolean b() {
            return this.f9146a.complete();
        }
    }

    public final void d() {
        SendChannel.DefaultImpls.a(this.e, (Throwable) null, 1, (Object) null);
        while (true) {
            try {
                Object f2 = ChannelResult.f(this.e.x());
                if (f2 != null) {
                    if (!(f2 instanceof Frame.Close)) {
                        if (f2 instanceof Frame.Ping ? true : f2 instanceof Frame.Pong) {
                            continue;
                        } else if (f2 instanceof FlushRequest) {
                            ((FlushRequest) f2).b();
                        } else {
                            if (!(f2 instanceof Frame.Text ? true : f2 instanceof Frame.Binary)) {
                                throw new IllegalArgumentException("unknown message " + f2);
                            }
                        }
                    }
                } else {
                    return;
                }
            } catch (CancellationException unused) {
                return;
            }
        }
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0057 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00f8 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00a6 A[ADDED_TO_REGION, EDGE_INSN: B:64:0x00a6->B:31:0x00a6 ?: BREAK  , SYNTHETIC] */
    public final java.lang.Object e(io.ktor.websocket.Frame r7, java.nio.ByteBuffer r8, kotlin.coroutines.Continuation r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof io.ktor.websocket.WebSocketWriter$drainQueueAndSerialize$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            io.ktor.websocket.WebSocketWriter$drainQueueAndSerialize$1 r0 = (io.ktor.websocket.WebSocketWriter$drainQueueAndSerialize$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.websocket.WebSocketWriter$drainQueueAndSerialize$1 r0 = new io.ktor.websocket.WebSocketWriter$drainQueueAndSerialize$1
            r0.<init>(r6, r9)
        L_0x0018:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0044
            if (r2 != r4) goto L_0x003c
            int r6 = r0.I$0
            java.lang.Object r7 = r0.L$2
            kotlin.jvm.internal.Ref$ObjectRef r7 = (kotlin.jvm.internal.Ref.ObjectRef) r7
            java.lang.Object r8 = r0.L$1
            java.nio.ByteBuffer r8 = (java.nio.ByteBuffer) r8
            java.lang.Object r2 = r0.L$0
            io.ktor.websocket.WebSocketWriter r2 = (io.ktor.websocket.WebSocketWriter) r2
            kotlin.ResultKt.throwOnFailure(r9)
            r9 = r7
            r7 = r6
            r6 = r2
            goto L_0x00f9
        L_0x003c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r9)
            kotlin.jvm.internal.Ref$ObjectRef r9 = new kotlin.jvm.internal.Ref$ObjectRef
            r9.<init>()
            io.ktor.websocket.Serializer r2 = r6.f
            r2.a(r7)
            boolean r7 = r7 instanceof io.ktor.websocket.Frame.Close
        L_0x0053:
            T r2 = r9.element
            if (r2 != 0) goto L_0x00a6
            if (r7 != 0) goto L_0x00a6
            io.ktor.websocket.Serializer r2 = r6.f
            int r2 = r2.d()
            if (r2 <= 0) goto L_0x00a6
            kotlinx.coroutines.channels.Channel r2 = r6.e
            java.lang.Object r2 = r2.x()
            java.lang.Object r2 = kotlinx.coroutines.channels.ChannelResult.f(r2)
            if (r2 != 0) goto L_0x006e
            goto L_0x00a6
        L_0x006e:
            boolean r5 = r2 instanceof io.ktor.websocket.WebSocketWriter.FlushRequest
            if (r5 == 0) goto L_0x0075
            r9.element = r2
            goto L_0x0053
        L_0x0075:
            boolean r5 = r2 instanceof io.ktor.websocket.Frame.Close
            if (r5 == 0) goto L_0x0082
            io.ktor.websocket.Serializer r7 = r6.f
            io.ktor.websocket.Frame r2 = (io.ktor.websocket.Frame) r2
            r7.a(r2)
            r7 = r4
            goto L_0x0053
        L_0x0082:
            boolean r5 = r2 instanceof io.ktor.websocket.Frame
            if (r5 == 0) goto L_0x008e
            io.ktor.websocket.Serializer r5 = r6.f
            io.ktor.websocket.Frame r2 = (io.ktor.websocket.Frame) r2
            r5.a(r2)
            goto L_0x0053
        L_0x008e:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "unknown message "
            r7.append(r8)
            r7.append(r2)
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            throw r6
        L_0x00a6:
            if (r7 == 0) goto L_0x00ad
            kotlinx.coroutines.channels.Channel r2 = r6.e
            kotlinx.coroutines.channels.SendChannel.DefaultImpls.a(r2, r3, r4, r3)
        L_0x00ad:
            io.ktor.websocket.Serializer r2 = r6.f
            boolean r2 = r2.c()
            if (r2 != 0) goto L_0x00d7
            int r2 = r8.position()
            if (r2 == 0) goto L_0x00bc
            goto L_0x00d7
        L_0x00bc:
            io.ktor.utils.io.ByteWriteChannel r6 = r6.f9145a
            r6.flush()
            T r6 = r9.element
            io.ktor.websocket.WebSocketWriter$FlushRequest r6 = (io.ktor.websocket.WebSocketWriter.FlushRequest) r6
            if (r6 == 0) goto L_0x00ce
            boolean r6 = r6.b()
            kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
        L_0x00ce:
            if (r7 == 0) goto L_0x00d1
            goto L_0x00d2
        L_0x00d1:
            r4 = 0
        L_0x00d2:
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r6
        L_0x00d7:
            io.ktor.websocket.Serializer r2 = r6.f
            boolean r5 = r6.c
            r2.j(r5)
            io.ktor.websocket.Serializer r2 = r6.f
            r2.g(r8)
            r8.flip()
        L_0x00e6:
            io.ktor.utils.io.ByteWriteChannel r2 = r6.f9145a
            r0.L$0 = r6
            r0.L$1 = r8
            r0.L$2 = r9
            r0.I$0 = r7
            r0.label = r4
            java.lang.Object r2 = r2.l(r8, r0)
            if (r2 != r1) goto L_0x00f9
            return r1
        L_0x00f9:
            io.ktor.websocket.Serializer r2 = r6.f
            boolean r2 = r2.c()
            if (r2 != 0) goto L_0x0117
            boolean r2 = r8.hasRemaining()
            if (r2 != 0) goto L_0x0117
            T r2 = r9.element
            io.ktor.websocket.WebSocketWriter$FlushRequest r2 = (io.ktor.websocket.WebSocketWriter.FlushRequest) r2
            if (r2 == 0) goto L_0x0117
            io.ktor.utils.io.ByteWriteChannel r5 = r6.f9145a
            r5.flush()
            r2.b()
            r9.element = r3
        L_0x0117:
            T r2 = r9.element
            if (r2 != 0) goto L_0x011d
            if (r7 == 0) goto L_0x0123
        L_0x011d:
            boolean r2 = r8.hasRemaining()
            if (r2 != 0) goto L_0x00e6
        L_0x0123:
            r8.compact()
            goto L_0x0053
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.WebSocketWriter.e(io.ktor.websocket.Frame, java.nio.ByteBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final ObjectPool f() {
        return this.d;
    }

    public final void g(boolean z) {
        this.c = z;
    }

    public CoroutineContext getCoroutineContext() {
        return this.b;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007b A[Catch:{ ChannelWriteException -> 0x00b1, all -> 0x00ad }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x007c A[Catch:{ ChannelWriteException -> 0x00b1, all -> 0x00ad }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0088 A[Catch:{ ChannelWriteException -> 0x00b1, all -> 0x00ad }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a9 A[Catch:{ ChannelWriteException -> 0x00b1, all -> 0x00ad }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:51:0x00e6=Splitter:B:51:0x00e6, B:55:0x00fd=Splitter:B:55:0x00fd} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object h(java.nio.ByteBuffer r10, kotlin.coroutines.Continuation r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof io.ktor.websocket.WebSocketWriter$writeLoop$1
            if (r0 == 0) goto L_0x0013
            r0 = r11
            io.ktor.websocket.WebSocketWriter$writeLoop$1 r0 = (io.ktor.websocket.WebSocketWriter$writeLoop$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.websocket.WebSocketWriter$writeLoop$1 r0 = new io.ktor.websocket.WebSocketWriter$writeLoop$1
            r0.<init>(r9, r11)
        L_0x0018:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            java.lang.String r6 = "WebSocket closed."
            if (r2 == 0) goto L_0x0061
            if (r2 == r4) goto L_0x004d
            if (r2 != r3) goto L_0x0045
            java.lang.Object r9 = r0.L$2
            kotlinx.coroutines.channels.ChannelIterator r9 = (kotlinx.coroutines.channels.ChannelIterator) r9
            java.lang.Object r10 = r0.L$1
            java.nio.ByteBuffer r10 = (java.nio.ByteBuffer) r10
            java.lang.Object r2 = r0.L$0
            io.ktor.websocket.WebSocketWriter r2 = (io.ktor.websocket.WebSocketWriter) r2
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ ChannelWriteException -> 0x0042, all -> 0x003f }
            r8 = r0
            r0 = r9
            r9 = r2
            r2 = r8
            goto L_0x00a1
        L_0x003f:
            r9 = move-exception
            goto L_0x00e6
        L_0x0042:
            r9 = move-exception
            goto L_0x00fd
        L_0x0045:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x004d:
            java.lang.Object r9 = r0.L$2
            kotlinx.coroutines.channels.ChannelIterator r9 = (kotlinx.coroutines.channels.ChannelIterator) r9
            java.lang.Object r10 = r0.L$1
            java.nio.ByteBuffer r10 = (java.nio.ByteBuffer) r10
            java.lang.Object r2 = r0.L$0
            io.ktor.websocket.WebSocketWriter r2 = (io.ktor.websocket.WebSocketWriter) r2
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ ChannelWriteException -> 0x0042, all -> 0x003f }
            r8 = r0
            r0 = r9
            r9 = r2
        L_0x005f:
            r2 = r8
            goto L_0x0080
        L_0x0061:
            kotlin.ResultKt.throwOnFailure(r11)
            r10.clear()
            kotlinx.coroutines.channels.Channel r11 = r9.e     // Catch:{ ChannelWriteException -> 0x00b1, all -> 0x00ad }
            kotlinx.coroutines.channels.ChannelIterator r11 = r11.iterator()     // Catch:{ ChannelWriteException -> 0x00b1, all -> 0x00ad }
        L_0x006d:
            r0.L$0 = r9     // Catch:{ ChannelWriteException -> 0x00b1, all -> 0x00ad }
            r0.L$1 = r10     // Catch:{ ChannelWriteException -> 0x00b1, all -> 0x00ad }
            r0.L$2 = r11     // Catch:{ ChannelWriteException -> 0x00b1, all -> 0x00ad }
            r0.label = r4     // Catch:{ ChannelWriteException -> 0x00b1, all -> 0x00ad }
            java.lang.Object r2 = r11.a(r0)     // Catch:{ ChannelWriteException -> 0x00b1, all -> 0x00ad }
            if (r2 != r1) goto L_0x007c
            return r1
        L_0x007c:
            r8 = r0
            r0 = r11
            r11 = r2
            goto L_0x005f
        L_0x0080:
            java.lang.Boolean r11 = (java.lang.Boolean) r11     // Catch:{ ChannelWriteException -> 0x00b1, all -> 0x00ad }
            boolean r11 = r11.booleanValue()     // Catch:{ ChannelWriteException -> 0x00b1, all -> 0x00ad }
            if (r11 == 0) goto L_0x00d7
            java.lang.Object r11 = r0.next()     // Catch:{ ChannelWriteException -> 0x00b1, all -> 0x00ad }
            boolean r7 = r11 instanceof io.ktor.websocket.Frame     // Catch:{ ChannelWriteException -> 0x00b1, all -> 0x00ad }
            if (r7 == 0) goto L_0x00b5
            io.ktor.websocket.Frame r11 = (io.ktor.websocket.Frame) r11     // Catch:{ ChannelWriteException -> 0x00b1, all -> 0x00ad }
            r2.L$0 = r9     // Catch:{ ChannelWriteException -> 0x00b1, all -> 0x00ad }
            r2.L$1 = r10     // Catch:{ ChannelWriteException -> 0x00b1, all -> 0x00ad }
            r2.L$2 = r0     // Catch:{ ChannelWriteException -> 0x00b1, all -> 0x00ad }
            r2.label = r3     // Catch:{ ChannelWriteException -> 0x00b1, all -> 0x00ad }
            java.lang.Object r11 = r9.e(r11, r10, r2)     // Catch:{ ChannelWriteException -> 0x00b1, all -> 0x00ad }
            if (r11 != r1) goto L_0x00a1
            return r1
        L_0x00a1:
            java.lang.Boolean r11 = (java.lang.Boolean) r11     // Catch:{ ChannelWriteException -> 0x00b1, all -> 0x00ad }
            boolean r11 = r11.booleanValue()     // Catch:{ ChannelWriteException -> 0x00b1, all -> 0x00ad }
            if (r11 == 0) goto L_0x00aa
            goto L_0x00d7
        L_0x00aa:
            r11 = r0
            r0 = r2
            goto L_0x006d
        L_0x00ad:
            r10 = move-exception
            r2 = r9
            r9 = r10
            goto L_0x00e6
        L_0x00b1:
            r10 = move-exception
            r2 = r9
            r9 = r10
            goto L_0x00fd
        L_0x00b5:
            boolean r7 = r11 instanceof io.ktor.websocket.WebSocketWriter.FlushRequest     // Catch:{ ChannelWriteException -> 0x00b1, all -> 0x00ad }
            if (r7 == 0) goto L_0x00bf
            io.ktor.websocket.WebSocketWriter$FlushRequest r11 = (io.ktor.websocket.WebSocketWriter.FlushRequest) r11     // Catch:{ ChannelWriteException -> 0x00b1, all -> 0x00ad }
            r11.b()     // Catch:{ ChannelWriteException -> 0x00b1, all -> 0x00ad }
            goto L_0x00aa
        L_0x00bf:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException     // Catch:{ ChannelWriteException -> 0x00b1, all -> 0x00ad }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ ChannelWriteException -> 0x00b1, all -> 0x00ad }
            r0.<init>()     // Catch:{ ChannelWriteException -> 0x00b1, all -> 0x00ad }
            java.lang.String r1 = "unknown message "
            r0.append(r1)     // Catch:{ ChannelWriteException -> 0x00b1, all -> 0x00ad }
            r0.append(r11)     // Catch:{ ChannelWriteException -> 0x00b1, all -> 0x00ad }
            java.lang.String r11 = r0.toString()     // Catch:{ ChannelWriteException -> 0x00b1, all -> 0x00ad }
            r10.<init>(r11)     // Catch:{ ChannelWriteException -> 0x00b1, all -> 0x00ad }
            throw r10     // Catch:{ ChannelWriteException -> 0x00b1, all -> 0x00ad }
        L_0x00d7:
            kotlinx.coroutines.channels.Channel r10 = r9.e
            java.util.concurrent.CancellationException r11 = kotlinx.coroutines.ExceptionsKt.a(r6, r5)
            r10.h(r11)
            io.ktor.utils.io.ByteWriteChannel r10 = r9.f9145a
            io.ktor.utils.io.ByteWriteChannelKt.a(r10)
            goto L_0x0109
        L_0x00e6:
            kotlinx.coroutines.channels.Channel r10 = r2.e     // Catch:{ all -> 0x00fb }
            r10.h(r9)     // Catch:{ all -> 0x00fb }
        L_0x00eb:
            kotlinx.coroutines.channels.Channel r9 = r2.e
            java.util.concurrent.CancellationException r10 = kotlinx.coroutines.ExceptionsKt.a(r6, r5)
            r9.h(r10)
            io.ktor.utils.io.ByteWriteChannel r9 = r2.f9145a
            io.ktor.utils.io.ByteWriteChannelKt.a(r9)
            r9 = r2
            goto L_0x0109
        L_0x00fb:
            r9 = move-exception
            goto L_0x010f
        L_0x00fd:
            kotlinx.coroutines.channels.Channel r10 = r2.e     // Catch:{ all -> 0x00fb }
            java.lang.String r11 = "Failed to write to WebSocket."
            java.util.concurrent.CancellationException r9 = kotlinx.coroutines.ExceptionsKt.a(r11, r9)     // Catch:{ all -> 0x00fb }
            r10.h(r9)     // Catch:{ all -> 0x00fb }
            goto L_0x00eb
        L_0x0109:
            r9.d()
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L_0x010f:
            kotlinx.coroutines.channels.Channel r10 = r2.e
            java.util.concurrent.CancellationException r11 = kotlinx.coroutines.ExceptionsKt.a(r6, r5)
            r10.h(r11)
            io.ktor.utils.io.ByteWriteChannel r10 = r2.f9145a
            io.ktor.utils.io.ByteWriteChannelKt.a(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.WebSocketWriter.h(java.nio.ByteBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final SendChannel o() {
        return this.e;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ac A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object u(kotlin.coroutines.Continuation r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof io.ktor.websocket.WebSocketWriter$flush$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            io.ktor.websocket.WebSocketWriter$flush$1 r0 = (io.ktor.websocket.WebSocketWriter$flush$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.websocket.WebSocketWriter$flush$1 r0 = new io.ktor.websocket.WebSocketWriter$flush$1
            r0.<init>(r9, r10)
        L_0x0018:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x0055
            if (r2 == r5) goto L_0x0041
            if (r2 == r4) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x00ad
        L_0x0031:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0039:
            java.lang.Object r9 = r0.L$0
            io.ktor.websocket.WebSocketWriter$FlushRequest r9 = (io.ktor.websocket.WebSocketWriter.FlushRequest) r9
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x009d
        L_0x0041:
            java.lang.Object r9 = r0.L$2
            io.ktor.websocket.WebSocketWriter$FlushRequest r9 = (io.ktor.websocket.WebSocketWriter.FlushRequest) r9
            java.lang.Object r2 = r0.L$1
            io.ktor.websocket.WebSocketWriter$FlushRequest r2 = (io.ktor.websocket.WebSocketWriter.FlushRequest) r2
            java.lang.Object r5 = r0.L$0
            io.ktor.websocket.WebSocketWriter r5 = (io.ktor.websocket.WebSocketWriter) r5
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ ClosedSendChannelException -> 0x0053, all -> 0x0051 }
            goto L_0x009e
        L_0x0051:
            r10 = move-exception
            goto L_0x0084
        L_0x0053:
            r10 = r2
            goto L_0x0088
        L_0x0055:
            kotlin.ResultKt.throwOnFailure(r10)
            io.ktor.websocket.WebSocketWriter$FlushRequest r10 = new io.ktor.websocket.WebSocketWriter$FlushRequest
            kotlin.coroutines.CoroutineContext r2 = r9.getCoroutineContext()
            kotlinx.coroutines.Job$Key r7 = kotlinx.coroutines.Job.b0
            kotlin.coroutines.CoroutineContext$Element r2 = r2.get(r7)
            kotlinx.coroutines.Job r2 = (kotlinx.coroutines.Job) r2
            r10.<init>(r2)
            kotlinx.coroutines.channels.Channel r2 = r9.e     // Catch:{ ClosedSendChannelException -> 0x0081, all -> 0x007c }
            r0.L$0 = r9     // Catch:{ ClosedSendChannelException -> 0x0081, all -> 0x007c }
            r0.L$1 = r10     // Catch:{ ClosedSendChannelException -> 0x0081, all -> 0x007c }
            r0.L$2 = r10     // Catch:{ ClosedSendChannelException -> 0x0081, all -> 0x007c }
            r0.label = r5     // Catch:{ ClosedSendChannelException -> 0x0081, all -> 0x007c }
            java.lang.Object r9 = r2.L(r10, r0)     // Catch:{ ClosedSendChannelException -> 0x0081, all -> 0x007c }
            if (r9 != r1) goto L_0x007a
            return r1
        L_0x007a:
            r2 = r10
            goto L_0x009e
        L_0x007c:
            r9 = move-exception
            r8 = r10
            r10 = r9
            r9 = r8
            goto L_0x0084
        L_0x0081:
            r5 = r9
            r9 = r10
            goto L_0x0088
        L_0x0084:
            r9.b()
            throw r10
        L_0x0088:
            r9.b()
            kotlinx.coroutines.Job r9 = r5.g
            r0.L$0 = r10
            r0.L$1 = r6
            r0.L$2 = r6
            r0.label = r4
            java.lang.Object r9 = r9.i0(r0)
            if (r9 != r1) goto L_0x009c
            return r1
        L_0x009c:
            r9 = r10
        L_0x009d:
            r2 = r9
        L_0x009e:
            r0.L$0 = r6
            r0.L$1 = r6
            r0.L$2 = r6
            r0.label = r3
            java.lang.Object r9 = r2.a(r0)
            if (r9 != r1) goto L_0x00ad
            return r1
        L_0x00ad:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.WebSocketWriter.u(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
