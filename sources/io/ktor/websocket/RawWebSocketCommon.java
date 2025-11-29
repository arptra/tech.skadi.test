package io.ktor.websocket;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.websocket.WebSocketSession;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u00019J\u0013\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\"\u0010\u0014\u001a\u00020\r8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u001c\u001a\u00020\u00158\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0\u001d8\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010 R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u001a\u0010-\u001a\u00020)8\u0016X\u0004¢\u0006\f\n\u0004\b\u0018\u0010*\u001a\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u001a\u00104\u001a\b\u0012\u0004\u0012\u00020\u001e028VX\u0004¢\u0006\u0006\u001a\u0004\b/\u00103R\u001a\u00108\u001a\b\u0012\u0004\u0012\u00020\u001e058VX\u0004¢\u0006\u0006\u001a\u0004\b6\u00107\u0002\u0004\n\u0002\b\u0019¨\u0006:"}, d2 = {"Lio/ktor/websocket/RawWebSocketCommon;", "Lio/ktor/websocket/WebSocketSession;", "", "u", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/ByteReadChannel;", "a", "Lio/ktor/utils/io/ByteReadChannel;", "input", "Lio/ktor/utils/io/ByteWriteChannel;", "b", "Lio/ktor/utils/io/ByteWriteChannel;", "output", "", "c", "J", "z", "()J", "d0", "(J)V", "maxFrameSize", "", "d", "Z", "h", "()Z", "setMasking", "(Z)V", "masking", "Lkotlinx/coroutines/channels/Channel;", "Lio/ktor/websocket/Frame;", "e", "Lkotlinx/coroutines/channels/Channel;", "_incoming", "", "f", "_outgoing", "", "g", "I", "lastOpcode", "Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lkotlinx/coroutines/Job;", "i", "Lkotlinx/coroutines/Job;", "writerJob", "Lkotlinx/coroutines/channels/ReceiveChannel;", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "incoming", "Lkotlinx/coroutines/channels/SendChannel;", "o", "()Lkotlinx/coroutines/channels/SendChannel;", "outgoing", "FlushRequest", "ktor-websockets"}, k = 1, mv = {1, 8, 0})
public final class RawWebSocketCommon implements WebSocketSession {

    /* renamed from: a  reason: collision with root package name */
    public final ByteReadChannel f9133a;
    public final ByteWriteChannel b;
    public long c;
    public boolean d;
    public final Channel e;
    public final Channel f;
    public int g;
    public final CoroutineContext h;
    public final Job i;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\n\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\r\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lio/ktor/websocket/RawWebSocketCommon$FlushRequest;", "", "Lkotlinx/coroutines/Job;", "parent", "<init>", "(Lkotlinx/coroutines/Job;)V", "", "b", "()Z", "", "a", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/CompletableJob;", "Lkotlinx/coroutines/CompletableJob;", "done", "ktor-websockets"}, k = 1, mv = {1, 8, 0})
    public static final class FlushRequest {

        /* renamed from: a  reason: collision with root package name */
        public final CompletableJob f9134a;

        public FlushRequest(Job job) {
            this.f9134a = JobKt.a(job);
        }

        public final Object a(Continuation continuation) {
            Object i0 = this.f9134a.i0(continuation);
            return i0 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? i0 : Unit.INSTANCE;
        }

        public final boolean b() {
            return this.f9134a.complete();
        }
    }

    public void d0(long j) {
        this.c = j;
    }

    public CoroutineContext getCoroutineContext() {
        return this.h;
    }

    public boolean h() {
        return this.d;
    }

    public ReceiveChannel i() {
        return this.e;
    }

    public SendChannel o() {
        return this.f;
    }

    public Object q0(Frame frame, Continuation continuation) {
        return WebSocketSession.DefaultImpls.a(this, frame, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ac A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object u(kotlin.coroutines.Continuation r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof io.ktor.websocket.RawWebSocketCommon$flush$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            io.ktor.websocket.RawWebSocketCommon$flush$1 r0 = (io.ktor.websocket.RawWebSocketCommon$flush$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.websocket.RawWebSocketCommon$flush$1 r0 = new io.ktor.websocket.RawWebSocketCommon$flush$1
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
            io.ktor.websocket.RawWebSocketCommon$FlushRequest r9 = (io.ktor.websocket.RawWebSocketCommon.FlushRequest) r9
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x009d
        L_0x0041:
            java.lang.Object r9 = r0.L$2
            io.ktor.websocket.RawWebSocketCommon$FlushRequest r9 = (io.ktor.websocket.RawWebSocketCommon.FlushRequest) r9
            java.lang.Object r2 = r0.L$1
            io.ktor.websocket.RawWebSocketCommon$FlushRequest r2 = (io.ktor.websocket.RawWebSocketCommon.FlushRequest) r2
            java.lang.Object r5 = r0.L$0
            io.ktor.websocket.RawWebSocketCommon r5 = (io.ktor.websocket.RawWebSocketCommon) r5
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
            io.ktor.websocket.RawWebSocketCommon$FlushRequest r10 = new io.ktor.websocket.RawWebSocketCommon$FlushRequest
            kotlin.coroutines.CoroutineContext r2 = r9.getCoroutineContext()
            kotlinx.coroutines.Job$Key r7 = kotlinx.coroutines.Job.b0
            kotlin.coroutines.CoroutineContext$Element r2 = r2.get(r7)
            kotlinx.coroutines.Job r2 = (kotlinx.coroutines.Job) r2
            r10.<init>(r2)
            kotlinx.coroutines.channels.Channel r2 = r9.f     // Catch:{ ClosedSendChannelException -> 0x0081, all -> 0x007c }
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
            kotlinx.coroutines.Job r9 = r5.i
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
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.RawWebSocketCommon.u(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public long z() {
        return this.c;
    }
}
