package io.ktor.utils.io;

import io.ktor.utils.io.core.Buffer;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u001aq\u0010\f\u001a\u00020\u0001*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012K\u0010\u000b\u001aG\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00010\u0003HHø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a!\u0010\u000f\u001a\u0004\u0018\u00010\u000e*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a'\u0010\u0014\u001a\u00020\u0013*\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0001H@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001f\u0010\u0016\u001a\u00020\u0013*\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a%\u0010\u001a\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u0001H@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u000f\u0010\u001c\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u0018*\u00020\u0000H\u0002¢\u0006\u0004\b\u001e\u0010\u001f\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, d2 = {"Lio/ktor/utils/io/ByteWriteChannel;", "", "desiredSpace", "Lkotlin/Function3;", "Lio/ktor/utils/io/bits/Memory;", "Lkotlin/ParameterName;", "name", "freeSpace", "", "startOffset", "endExclusive", "block", "f", "(Lio/ktor/utils/io/ByteWriteChannel;ILkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/core/Buffer;", "e", "(Lio/ktor/utils/io/ByteWriteChannel;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buffer", "written", "", "c", "(Lio/ktor/utils/io/ByteWriteChannel;Lio/ktor/utils/io/core/Buffer;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "d", "(Lio/ktor/utils/io/ByteWriteChannel;Lio/ktor/utils/io/core/Buffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/WriterSuspendSession;", "session", "h", "(Lio/ktor/utils/io/WriterSuspendSession;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "g", "()Lio/ktor/utils/io/core/Buffer;", "i", "(Lio/ktor/utils/io/ByteWriteChannel;)Lio/ktor/utils/io/WriterSuspendSession;", "ktor-io"}, k = 2, mv = {1, 8, 0})
public final class WriterSessionKt {
    public static final Object c(ByteWriteChannel byteWriteChannel, Buffer buffer, int i, Continuation continuation) {
        if (byteWriteChannel instanceof HasWriteSession) {
            ((HasWriteSession) byteWriteChannel).c(i);
            return Unit.INSTANCE;
        }
        Object d = d(byteWriteChannel, buffer, continuation);
        return d == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? d : Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: io.ktor.utils.io.core.Buffer} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object d(io.ktor.utils.io.ByteWriteChannel r4, io.ktor.utils.io.core.Buffer r5, kotlin.coroutines.Continuation r6) {
        /*
            boolean r0 = r6 instanceof io.ktor.utils.io.WriterSessionKt$completeWritingFallback$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            io.ktor.utils.io.WriterSessionKt$completeWritingFallback$1 r0 = (io.ktor.utils.io.WriterSessionKt$completeWritingFallback$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.WriterSessionKt$completeWritingFallback$1 r0 = new io.ktor.utils.io.WriterSessionKt$completeWritingFallback$1
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r4 = r0.L$0
            r5 = r4
            io.ktor.utils.io.core.Buffer r5 = (io.ktor.utils.io.core.Buffer) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0048
        L_0x002e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            boolean r6 = r5 instanceof io.ktor.utils.io.core.internal.ChunkBuffer
            if (r6 == 0) goto L_0x0056
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r4 = r4.M(r5, r0)
            if (r4 != r1) goto L_0x0048
            return r1
        L_0x0048:
            io.ktor.utils.io.core.internal.ChunkBuffer r5 = (io.ktor.utils.io.core.internal.ChunkBuffer) r5
            io.ktor.utils.io.core.internal.ChunkBuffer$Companion r4 = io.ktor.utils.io.core.internal.ChunkBuffer.j
            io.ktor.utils.io.pool.ObjectPool r4 = r4.c()
            r5.F(r4)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        L_0x0056:
            java.lang.UnsupportedOperationException r4 = new java.lang.UnsupportedOperationException
            java.lang.String r5 = "Only ChunkBuffer instance is supported."
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.WriterSessionKt.d(io.ktor.utils.io.ByteWriteChannel, io.ktor.utils.io.core.Buffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Object e(ByteWriteChannel byteWriteChannel, int i, Continuation continuation) {
        WriterSuspendSession i2 = i(byteWriteChannel);
        if (i2 == null) {
            return g();
        }
        ChunkBuffer a2 = i2.a(i);
        return a2 != null ? a2 : h(i2, i, continuation);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v6, resolved type: kotlin.jvm.functions.Function3} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a7 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object f(io.ktor.utils.io.ByteWriteChannel r10, int r11, kotlin.jvm.functions.Function3 r12, kotlin.coroutines.Continuation r13) {
        /*
            boolean r0 = r13 instanceof io.ktor.utils.io.WriterSessionKt$write$1
            if (r0 == 0) goto L_0x0013
            r0 = r13
            io.ktor.utils.io.WriterSessionKt$write$1 r0 = (io.ktor.utils.io.WriterSessionKt$write$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.WriterSessionKt$write$1 r0 = new io.ktor.utils.io.WriterSessionKt$write$1
            r0.<init>(r13)
        L_0x0018:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0051
            if (r2 == r5) goto L_0x0044
            if (r2 == r4) goto L_0x003c
            if (r2 == r3) goto L_0x0033
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0033:
            java.lang.Object r10 = r0.L$0
            java.lang.Throwable r10 = (java.lang.Throwable) r10
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x00bf
        L_0x003c:
            java.lang.Object r10 = r0.L$0
            java.lang.Integer r10 = (java.lang.Integer) r10
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x00a9
        L_0x0044:
            java.lang.Object r10 = r0.L$1
            r12 = r10
            kotlin.jvm.functions.Function3 r12 = (kotlin.jvm.functions.Function3) r12
            java.lang.Object r10 = r0.L$0
            io.ktor.utils.io.ByteWriteChannel r10 = (io.ktor.utils.io.ByteWriteChannel) r10
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0061
        L_0x0051:
            kotlin.ResultKt.throwOnFailure(r13)
            r0.L$0 = r10
            r0.L$1 = r12
            r0.label = r5
            java.lang.Object r13 = e(r10, r11, r0)
            if (r13 != r1) goto L_0x0061
            return r1
        L_0x0061:
            io.ktor.utils.io.core.Buffer r13 = (io.ktor.utils.io.core.Buffer) r13
            if (r13 != 0) goto L_0x006b
            io.ktor.utils.io.core.Buffer$Companion r11 = io.ktor.utils.io.core.Buffer.g
            io.ktor.utils.io.core.Buffer r13 = r11.a()
        L_0x006b:
            r11 = 0
            r2 = 0
            java.nio.ByteBuffer r6 = r13.h()     // Catch:{ all -> 0x00ad }
            io.ktor.utils.io.bits.Memory r6 = io.ktor.utils.io.bits.Memory.b(r6)     // Catch:{ all -> 0x00ad }
            int r7 = r13.k()     // Catch:{ all -> 0x00ad }
            long r7 = (long) r7     // Catch:{ all -> 0x00ad }
            java.lang.Long r7 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r7)     // Catch:{ all -> 0x00ad }
            int r8 = r13.g()     // Catch:{ all -> 0x00ad }
            long r8 = (long) r8     // Catch:{ all -> 0x00ad }
            java.lang.Long r8 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r8)     // Catch:{ all -> 0x00ad }
            java.lang.Object r12 = r12.invoke(r6, r7, r8)     // Catch:{ all -> 0x00ad }
            java.lang.Number r12 = (java.lang.Number) r12     // Catch:{ all -> 0x00ad }
            int r2 = r12.intValue()     // Catch:{ all -> 0x00ad }
            r13.a(r2)     // Catch:{ all -> 0x00ad }
            java.lang.Integer r12 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r2)     // Catch:{ all -> 0x00ad }
            kotlin.jvm.internal.InlineMarker.finallyStart(r5)
            r0.L$0 = r12
            r0.L$1 = r11
            r0.label = r4
            java.lang.Object r10 = c(r10, r13, r2, r0)
            if (r10 != r1) goto L_0x00a8
            return r1
        L_0x00a8:
            r10 = r12
        L_0x00a9:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r5)
            return r10
        L_0x00ad:
            r12 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r5)
            r0.L$0 = r12
            r0.L$1 = r11
            r0.label = r3
            java.lang.Object r10 = c(r10, r13, r2, r0)
            if (r10 != r1) goto L_0x00be
            return r1
        L_0x00be:
            r10 = r12
        L_0x00bf:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r5)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.WriterSessionKt.f(io.ktor.utils.io.ByteWriteChannel, int, kotlin.jvm.functions.Function3, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Buffer g() {
        Object h0 = ChunkBuffer.j.c().h0();
        ChunkBuffer chunkBuffer = (ChunkBuffer) h0;
        chunkBuffer.t();
        chunkBuffer.p(8);
        return (Buffer) h0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object h(io.ktor.utils.io.WriterSuspendSession r4, int r5, kotlin.coroutines.Continuation r6) {
        /*
            boolean r0 = r6 instanceof io.ktor.utils.io.WriterSessionKt$writeBufferSuspend$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            io.ktor.utils.io.WriterSessionKt$writeBufferSuspend$1 r0 = (io.ktor.utils.io.WriterSessionKt$writeBufferSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.WriterSessionKt$writeBufferSuspend$1 r0 = new io.ktor.utils.io.WriterSessionKt$writeBufferSuspend$1
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            int r5 = r0.I$0
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.WriterSuspendSession r4 = (io.ktor.utils.io.WriterSuspendSession) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0047
        L_0x002f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r4
            r0.I$0 = r5
            r0.label = r3
            java.lang.Object r6 = r4.c(r5, r0)
            if (r6 != r1) goto L_0x0047
            return r1
        L_0x0047:
            io.ktor.utils.io.core.internal.ChunkBuffer r5 = r4.a(r5)
            if (r5 == 0) goto L_0x004e
            goto L_0x0052
        L_0x004e:
            io.ktor.utils.io.core.internal.ChunkBuffer r5 = r4.a(r3)
        L_0x0052:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.WriterSessionKt.h(io.ktor.utils.io.WriterSuspendSession, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final WriterSuspendSession i(ByteWriteChannel byteWriteChannel) {
        if (byteWriteChannel instanceof HasWriteSession) {
            return ((HasWriteSession) byteWriteChannel).L();
        }
        return null;
    }
}
