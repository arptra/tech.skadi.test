package io.ktor.utils.io;

import io.ktor.utils.io.core.Buffer;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aq\u0010\f\u001a\u00020\u0001*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012K\u0010\u000b\u001aG\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00010\u0003HHø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a!\u0010\u000f\u001a\u0004\u0018\u00010\u000e*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a)\u0010\u0014\u001a\u00020\u0013*\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0012\u001a\u00020\u0001H@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a!\u0010\u0017\u001a\u0004\u0018\u00010\u000e*\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u0001H@ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u001f\u0010\u001a\u001a\u00020\u0019*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0010\u001a\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u0016*\u00020\u0000H\u0002¢\u0006\u0004\b\u001b\u0010\u001c\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Lio/ktor/utils/io/ByteReadChannel;", "", "desiredSize", "Lkotlin/Function3;", "Lio/ktor/utils/io/bits/Memory;", "Lkotlin/ParameterName;", "name", "source", "", "start", "endExclusive", "block", "d", "(Lio/ktor/utils/io/ByteReadChannel;ILkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/core/Buffer;", "f", "(Lio/ktor/utils/io/ByteReadChannel;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buffer", "bytesRead", "", "c", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/core/Buffer;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/SuspendableReadSession;", "h", "(Lio/ktor/utils/io/SuspendableReadSession;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "g", "e", "(Lio/ktor/utils/io/ByteReadChannel;)Lio/ktor/utils/io/SuspendableReadSession;", "ktor-io"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nReadSession.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReadSession.kt\nio/ktor/utils/io/ReadSessionKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Buffer.kt\nio/ktor/utils/io/core/Buffer\n*L\n1#1,151:1\n1#2:152\n74#3:153\n*S KotlinDebug\n*F\n+ 1 ReadSession.kt\nio/ktor/utils/io/ReadSessionKt\n*L\n133#1:153\n*E\n"})
public final class ReadSessionKt {
    public static final Object c(ByteReadChannel byteReadChannel, Buffer buffer, int i, Continuation continuation) {
        if (i >= 0) {
            SuspendableReadSession e = e(byteReadChannel);
            if (e != null) {
                e.r(i);
                if (byteReadChannel instanceof HasReadSession) {
                    ((HasReadSession) byteReadChannel).P();
                }
                return Unit.INSTANCE;
            }
            if (buffer instanceof ChunkBuffer) {
                ChunkBuffer.Companion companion = ChunkBuffer.j;
                if (buffer != companion.a()) {
                    ((ChunkBuffer) buffer).F(companion.c());
                    Object k = byteReadChannel.k((long) i, continuation);
                    return k == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? k : Unit.INSTANCE;
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException(("bytesRead shouldn't be negative: " + i).toString());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v11, resolved type: kotlin.jvm.functions.Function3} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a8 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object d(io.ktor.utils.io.ByteReadChannel r8, int r9, kotlin.jvm.functions.Function3 r10, kotlin.coroutines.Continuation r11) {
        /*
            boolean r0 = r11 instanceof io.ktor.utils.io.ReadSessionKt$read$1
            if (r0 == 0) goto L_0x0013
            r0 = r11
            io.ktor.utils.io.ReadSessionKt$read$1 r0 = (io.ktor.utils.io.ReadSessionKt$read$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ReadSessionKt$read$1 r0 = new io.ktor.utils.io.ReadSessionKt$read$1
            r0.<init>(r11)
        L_0x0018:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x005a
            if (r2 == r5) goto L_0x004d
            if (r2 == r4) goto L_0x003c
            if (r2 == r3) goto L_0x0033
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0033:
            java.lang.Object r8 = r0.L$0
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00c4
        L_0x003c:
            int r8 = r0.I$0
            java.lang.Object r9 = r0.L$1
            io.ktor.utils.io.core.Buffer r9 = (io.ktor.utils.io.core.Buffer) r9
            java.lang.Object r10 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r10 = (io.ktor.utils.io.ByteReadChannel) r10
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x004a }
            goto L_0x00ac
        L_0x004a:
            r8 = move-exception
            goto L_0x00b5
        L_0x004d:
            java.lang.Object r8 = r0.L$1
            r10 = r8
            kotlin.jvm.functions.Function3 r10 = (kotlin.jvm.functions.Function3) r10
            java.lang.Object r8 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r8 = (io.ktor.utils.io.ByteReadChannel) r8
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x006a
        L_0x005a:
            kotlin.ResultKt.throwOnFailure(r11)
            r0.L$0 = r8
            r0.L$1 = r10
            r0.label = r5
            java.lang.Object r11 = f(r8, r9, r0)
            if (r11 != r1) goto L_0x006a
            return r1
        L_0x006a:
            io.ktor.utils.io.core.Buffer r11 = (io.ktor.utils.io.core.Buffer) r11
            if (r11 != 0) goto L_0x0075
            io.ktor.utils.io.core.Buffer$Companion r9 = io.ktor.utils.io.core.Buffer.g
            io.ktor.utils.io.core.Buffer r9 = r9.a()
            goto L_0x0076
        L_0x0075:
            r9 = r11
        L_0x0076:
            java.nio.ByteBuffer r11 = r9.h()     // Catch:{ all -> 0x00b1 }
            io.ktor.utils.io.bits.Memory r11 = io.ktor.utils.io.bits.Memory.b(r11)     // Catch:{ all -> 0x00b1 }
            int r2 = r9.i()     // Catch:{ all -> 0x00b1 }
            long r5 = (long) r2     // Catch:{ all -> 0x00b1 }
            java.lang.Long r2 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r5)     // Catch:{ all -> 0x00b1 }
            int r5 = r9.k()     // Catch:{ all -> 0x00b1 }
            long r5 = (long) r5     // Catch:{ all -> 0x00b1 }
            java.lang.Long r5 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r5)     // Catch:{ all -> 0x00b1 }
            java.lang.Object r10 = r10.invoke(r11, r2, r5)     // Catch:{ all -> 0x00b1 }
            java.lang.Number r10 = (java.lang.Number) r10     // Catch:{ all -> 0x00b1 }
            int r10 = r10.intValue()     // Catch:{ all -> 0x00b1 }
            r0.L$0 = r8     // Catch:{ all -> 0x00b1 }
            r0.L$1 = r9     // Catch:{ all -> 0x00b1 }
            r0.I$0 = r10     // Catch:{ all -> 0x00b1 }
            r0.label = r4     // Catch:{ all -> 0x00b1 }
            java.lang.Object r11 = c(r8, r9, r10, r0)     // Catch:{ all -> 0x00b1 }
            if (r11 != r1) goto L_0x00a9
            return r1
        L_0x00a9:
            r7 = r10
            r10 = r8
            r8 = r7
        L_0x00ac:
            java.lang.Integer r8 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r8)     // Catch:{ all -> 0x004a }
            return r8
        L_0x00b1:
            r10 = move-exception
            r7 = r10
            r10 = r8
            r8 = r7
        L_0x00b5:
            r0.L$0 = r8
            r11 = 0
            r0.L$1 = r11
            r0.label = r3
            r11 = 0
            java.lang.Object r9 = c(r10, r9, r11, r0)
            if (r9 != r1) goto L_0x00c4
            return r1
        L_0x00c4:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ReadSessionKt.d(io.ktor.utils.io.ByteReadChannel, int, kotlin.jvm.functions.Function3, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final SuspendableReadSession e(ByteReadChannel byteReadChannel) {
        if (byteReadChannel instanceof HasReadSession) {
            return ((HasReadSession) byteReadChannel).d();
        }
        return null;
    }

    public static final Object f(ByteReadChannel byteReadChannel, int i, Continuation continuation) {
        SuspendableReadSession d = byteReadChannel instanceof SuspendableReadSession ? (SuspendableReadSession) byteReadChannel : byteReadChannel instanceof HasReadSession ? ((HasReadSession) byteReadChannel).d() : null;
        if (d == null) {
            return g(byteReadChannel, i, continuation);
        }
        ChunkBuffer a2 = d.a(RangesKt.coerceAtMost(i, 8));
        return a2 != null ? a2 : h(d, i, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object g(io.ktor.utils.io.ByteReadChannel r15, int r16, kotlin.coroutines.Continuation r17) {
        /*
            r0 = r17
            boolean r1 = r0 instanceof io.ktor.utils.io.ReadSessionKt$requestBufferFallback$1
            if (r1 == 0) goto L_0x0016
            r1 = r0
            io.ktor.utils.io.ReadSessionKt$requestBufferFallback$1 r1 = (io.ktor.utils.io.ReadSessionKt$requestBufferFallback$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0016
            int r2 = r2 - r3
            r1.label = r2
        L_0x0014:
            r12 = r1
            goto L_0x001c
        L_0x0016:
            io.ktor.utils.io.ReadSessionKt$requestBufferFallback$1 r1 = new io.ktor.utils.io.ReadSessionKt$requestBufferFallback$1
            r1.<init>(r0)
            goto L_0x0014
        L_0x001c:
            java.lang.Object r0 = r12.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r12.label
            r3 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r1 = r12.L$0
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = (io.ktor.utils.io.core.internal.ChunkBuffer) r1
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0071
        L_0x0031:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r0)
            io.ktor.utils.io.core.internal.ChunkBuffer$Companion r0 = io.ktor.utils.io.core.internal.ChunkBuffer.j
            io.ktor.utils.io.pool.ObjectPool r0 = r0.c()
            java.lang.Object r0 = r0.h0()
            io.ktor.utils.io.core.internal.ChunkBuffer r0 = (io.ktor.utils.io.core.internal.ChunkBuffer) r0
            java.nio.ByteBuffer r4 = r0.h()
            int r2 = r0.k()
            long r5 = (long) r2
            r2 = r16
            long r8 = (long) r2
            int r2 = r0.g()
            int r7 = r0.k()
            int r2 = r2 - r7
            long r10 = (long) r2
            r12.L$0 = r0
            r12.label = r3
            r13 = 0
            r2 = r15
            r3 = r4
            r4 = r5
            r6 = r13
            java.lang.Object r2 = r2.s(r3, r4, r6, r8, r10, r12)
            if (r2 != r1) goto L_0x006f
            return r1
        L_0x006f:
            r1 = r0
            r0 = r2
        L_0x0071:
            java.lang.Number r0 = (java.lang.Number) r0
            long r2 = r0.longValue()
            int r0 = (int) r2
            r1.a(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ReadSessionKt.g(io.ktor.utils.io.ByteReadChannel, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object h(io.ktor.utils.io.SuspendableReadSession r4, int r5, kotlin.coroutines.Continuation r6) {
        /*
            boolean r0 = r6 instanceof io.ktor.utils.io.ReadSessionKt$requestBufferSuspend$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            io.ktor.utils.io.ReadSessionKt$requestBufferSuspend$1 r0 = (io.ktor.utils.io.ReadSessionKt$requestBufferSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ReadSessionKt$requestBufferSuspend$1 r0 = new io.ktor.utils.io.ReadSessionKt$requestBufferSuspend$1
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.SuspendableReadSession r4 = (io.ktor.utils.io.SuspendableReadSession) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0043
        L_0x002d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r4.b(r5, r0)
            if (r5 != r1) goto L_0x0043
            return r1
        L_0x0043:
            io.ktor.utils.io.core.internal.ChunkBuffer r4 = r4.a(r3)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ReadSessionKt.h(io.ktor.utils.io.SuspendableReadSession, int, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
