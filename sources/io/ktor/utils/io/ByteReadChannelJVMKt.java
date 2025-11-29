package io.ktor.utils.io;

import io.ktor.utils.io.internal.JoiningState;
import io.ktor.utils.io.internal.SequentialCopyToKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.LongCompanionObject;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\u001a'\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a'\u0010\n\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a'\u0010\f\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lio/ktor/utils/io/ByteReadChannel;", "Lio/ktor/utils/io/ByteWriteChannel;", "dst", "", "close", "", "e", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "limit", "c", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "d", "ktor-io"}, k = 2, mv = {1, 8, 0})
public final class ByteReadChannelJVMKt {
    public static final Object c(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, long j, Continuation continuation) {
        if (byteReadChannel != byteWriteChannel) {
            return j == 0 ? Boxing.boxLong(0) : (!(byteReadChannel instanceof ByteBufferChannel) || !(byteWriteChannel instanceof ByteBufferChannel)) ? (!(byteReadChannel instanceof ByteChannelSequentialBase) || !(byteWriteChannel instanceof ByteChannelSequentialBase)) ? d(byteReadChannel, byteWriteChannel, j, continuation) : SequentialCopyToKt.b((ByteChannelSequentialBase) byteReadChannel, (ByteChannelSequentialBase) byteWriteChannel, LongCompanionObject.MAX_VALUE, continuation) : ((ByteBufferChannel) byteWriteChannel).I0((ByteBufferChannel) byteReadChannel, j, (JoiningState) null, continuation);
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v8, resolved type: io.ktor.utils.io.core.internal.ChunkBuffer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v9, resolved type: io.ktor.utils.io.ByteWriteChannel} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008f A[SYNTHETIC, Splitter:B:23:0x008f] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c4 A[Catch:{ all -> 0x0048 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e8 A[SYNTHETIC, Splitter:B:37:0x00e8] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object d(io.ktor.utils.io.ByteReadChannel r19, io.ktor.utils.io.ByteWriteChannel r20, long r21, kotlin.coroutines.Continuation r23) {
        /*
            r0 = r23
            boolean r1 = r0 instanceof io.ktor.utils.io.ByteReadChannelJVMKt$copyToImpl$1
            if (r1 == 0) goto L_0x0015
            r1 = r0
            io.ktor.utils.io.ByteReadChannelJVMKt$copyToImpl$1 r1 = (io.ktor.utils.io.ByteReadChannelJVMKt$copyToImpl$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0015
            int r2 = r2 - r3
            r1.label = r2
            goto L_0x001a
        L_0x0015:
            io.ktor.utils.io.ByteReadChannelJVMKt$copyToImpl$1 r1 = new io.ktor.utils.io.ByteReadChannelJVMKt$copyToImpl$1
            r1.<init>(r0)
        L_0x001a:
            java.lang.Object r0 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r4 = 0
            r6 = 2
            r7 = 1
            if (r3 == 0) goto L_0x006b
            if (r3 == r7) goto L_0x0053
            if (r3 != r6) goto L_0x004b
            int r3 = r1.I$1
            long r8 = r1.J$1
            int r10 = r1.I$0
            long r11 = r1.J$0
            java.lang.Object r13 = r1.L$2
            io.ktor.utils.io.core.internal.ChunkBuffer r13 = (io.ktor.utils.io.core.internal.ChunkBuffer) r13
            java.lang.Object r14 = r1.L$1
            io.ktor.utils.io.ByteWriteChannel r14 = (io.ktor.utils.io.ByteWriteChannel) r14
            java.lang.Object r15 = r1.L$0
            io.ktor.utils.io.ByteReadChannel r15 = (io.ktor.utils.io.ByteReadChannel) r15
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x0048 }
            r4 = r1
            r1 = r14
            r0 = r15
            goto L_0x00e4
        L_0x0048:
            r0 = move-exception
            goto L_0x010f
        L_0x004b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0053:
            long r8 = r1.J$1
            int r3 = r1.I$0
            long r10 = r1.J$0
            java.lang.Object r12 = r1.L$2
            r13 = r12
            io.ktor.utils.io.core.internal.ChunkBuffer r13 = (io.ktor.utils.io.core.internal.ChunkBuffer) r13
            java.lang.Object r12 = r1.L$1
            r14 = r12
            io.ktor.utils.io.ByteWriteChannel r14 = (io.ktor.utils.io.ByteWriteChannel) r14
            java.lang.Object r12 = r1.L$0
            io.ktor.utils.io.ByteReadChannel r12 = (io.ktor.utils.io.ByteReadChannel) r12
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x0048 }
            goto L_0x00bb
        L_0x006b:
            kotlin.ResultKt.throwOnFailure(r0)
            io.ktor.utils.io.core.internal.ChunkBuffer$Companion r0 = io.ktor.utils.io.core.internal.ChunkBuffer.j
            io.ktor.utils.io.pool.ObjectPool r0 = r0.c()
            java.lang.Object r0 = r0.h0()
            io.ktor.utils.io.core.internal.ChunkBuffer r0 = (io.ktor.utils.io.core.internal.ChunkBuffer) r0
            boolean r3 = r20.z()
            r3 = r3 ^ r7
            r8 = r21
            r13 = r0
            r10 = r3
            r11 = r4
            r0 = r19
            r3 = r1
            r1 = r20
        L_0x0089:
            long r14 = r8 - r11
            int r16 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x0100
            int r4 = r13.f()     // Catch:{ all -> 0x00f2 }
            long r4 = (long) r4     // Catch:{ all -> 0x00f2 }
            long r4 = java.lang.Math.min(r4, r14)     // Catch:{ all -> 0x00f2 }
            int r4 = (int) r4     // Catch:{ all -> 0x00f2 }
            r13.u(r4)     // Catch:{ all -> 0x00f2 }
            r3.L$0 = r0     // Catch:{ all -> 0x00f2 }
            r3.L$1 = r1     // Catch:{ all -> 0x00f2 }
            r3.L$2 = r13     // Catch:{ all -> 0x00f2 }
            r3.J$0 = r8     // Catch:{ all -> 0x00f2 }
            r3.I$0 = r10     // Catch:{ all -> 0x00f2 }
            r3.J$1 = r11     // Catch:{ all -> 0x00f2 }
            r3.label = r7     // Catch:{ all -> 0x00f2 }
            java.lang.Object r4 = r0.v(r13, r3)     // Catch:{ all -> 0x00f2 }
            if (r4 != r2) goto L_0x00b1
            return r2
        L_0x00b1:
            r14 = r1
            r1 = r3
            r3 = r10
            r17 = r11
            r12 = r0
            r0 = r4
            r10 = r8
            r8 = r17
        L_0x00bb:
            java.lang.Number r0 = (java.lang.Number) r0     // Catch:{ all -> 0x0048 }
            int r0 = r0.intValue()     // Catch:{ all -> 0x0048 }
            r4 = -1
            if (r0 == r4) goto L_0x00fe
            r1.L$0 = r12     // Catch:{ all -> 0x0048 }
            r1.L$1 = r14     // Catch:{ all -> 0x0048 }
            r1.L$2 = r13     // Catch:{ all -> 0x0048 }
            r1.J$0 = r10     // Catch:{ all -> 0x0048 }
            r1.I$0 = r3     // Catch:{ all -> 0x0048 }
            r1.J$1 = r8     // Catch:{ all -> 0x0048 }
            r1.I$1 = r0     // Catch:{ all -> 0x0048 }
            r1.label = r6     // Catch:{ all -> 0x0048 }
            java.lang.Object r4 = r14.M(r13, r1)     // Catch:{ all -> 0x0048 }
            if (r4 != r2) goto L_0x00db
            return r2
        L_0x00db:
            r4 = r1
            r1 = r14
            r17 = r3
            r3 = r0
            r0 = r12
            r11 = r10
            r10 = r17
        L_0x00e4:
            long r14 = (long) r3
            long r8 = r8 + r14
            if (r10 == 0) goto L_0x00f5
            int r3 = r0.i()     // Catch:{ all -> 0x00f2 }
            if (r3 != 0) goto L_0x00f5
            r1.flush()     // Catch:{ all -> 0x00f2 }
            goto L_0x00f5
        L_0x00f2:
            r0 = move-exception
            r14 = r1
            goto L_0x010f
        L_0x00f5:
            r3 = r4
            r4 = 0
            r17 = r8
            r8 = r11
            r11 = r17
            goto L_0x0089
        L_0x00fe:
            r11 = r8
            goto L_0x0101
        L_0x0100:
            r14 = r1
        L_0x0101:
            java.lang.Long r0 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r11)     // Catch:{ all -> 0x0048 }
            io.ktor.utils.io.core.internal.ChunkBuffer$Companion r1 = io.ktor.utils.io.core.internal.ChunkBuffer.j
            io.ktor.utils.io.pool.ObjectPool r1 = r1.c()
            r13.F(r1)
            return r0
        L_0x010f:
            r14.h(r0)     // Catch:{ all -> 0x0113 }
            throw r0     // Catch:{ all -> 0x0113 }
        L_0x0113:
            r0 = move-exception
            io.ktor.utils.io.core.internal.ChunkBuffer$Companion r1 = io.ktor.utils.io.core.internal.ChunkBuffer.j
            io.ktor.utils.io.pool.ObjectPool r1 = r1.c()
            r13.F(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelJVMKt.d(io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteWriteChannel, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: io.ktor.utils.io.ByteWriteChannel} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object e(io.ktor.utils.io.ByteReadChannel r4, io.ktor.utils.io.ByteWriteChannel r5, boolean r6, kotlin.coroutines.Continuation r7) {
        /*
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteReadChannelJVMKt$joinToImplSuspend$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            io.ktor.utils.io.ByteReadChannelJVMKt$joinToImplSuspend$1 r0 = (io.ktor.utils.io.ByteReadChannelJVMKt$joinToImplSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteReadChannelJVMKt$joinToImplSuspend$1 r0 = new io.ktor.utils.io.ByteReadChannelJVMKt$joinToImplSuspend$1
            r0.<init>(r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            boolean r6 = r0.Z$0
            java.lang.Object r4 = r0.L$0
            r5 = r4
            io.ktor.utils.io.ByteWriteChannel r5 = (io.ktor.utils.io.ByteWriteChannel) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x004d
        L_0x0030:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r5
            r0.Z$0 = r6
            r0.label = r3
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            java.lang.Object r4 = c(r4, r5, r2, r0)
            if (r4 != r1) goto L_0x004d
            return r1
        L_0x004d:
            if (r6 == 0) goto L_0x0053
            io.ktor.utils.io.ByteWriteChannelKt.a(r5)
            goto L_0x0056
        L_0x0053:
            r5.flush()
        L_0x0056:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelJVMKt.e(io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteWriteChannel, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
