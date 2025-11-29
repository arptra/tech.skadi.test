package io.ktor.utils.io.internal;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\u001a'\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a'\u0010\t\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a'\u0010\u000b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lio/ktor/utils/io/ByteChannelSequentialBase;", "dst", "", "closeOnEnd", "", "d", "(Lio/ktor/utils/io/ByteChannelSequentialBase;Lio/ktor/utils/io/ByteChannelSequentialBase;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "limit", "b", "(Lio/ktor/utils/io/ByteChannelSequentialBase;Lio/ktor/utils/io/ByteChannelSequentialBase;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "c", "ktor-io"}, k = 2, mv = {1, 8, 0})
public final class SequentialCopyToKt {
    /* JADX WARNING: Removed duplicated region for block: B:16:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object b(io.ktor.utils.io.ByteChannelSequentialBase r18, io.ktor.utils.io.ByteChannelSequentialBase r19, long r20, kotlin.coroutines.Continuation r22) {
        /*
            r0 = r19
            r1 = r22
            boolean r2 = r1 instanceof io.ktor.utils.io.internal.SequentialCopyToKt$copyToSequentialImpl$1
            if (r2 == 0) goto L_0x0017
            r2 = r1
            io.ktor.utils.io.internal.SequentialCopyToKt$copyToSequentialImpl$1 r2 = (io.ktor.utils.io.internal.SequentialCopyToKt$copyToSequentialImpl$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.label = r3
            goto L_0x001c
        L_0x0017:
            io.ktor.utils.io.internal.SequentialCopyToKt$copyToSequentialImpl$1 r2 = new io.ktor.utils.io.internal.SequentialCopyToKt$copyToSequentialImpl$1
            r2.<init>(r1)
        L_0x001c:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 3
            r6 = 2
            r7 = 1
            r8 = 0
            if (r4 == 0) goto L_0x006f
            if (r4 == r7) goto L_0x005d
            if (r4 == r6) goto L_0x004c
            if (r4 != r5) goto L_0x0044
            long r10 = r2.J$2
            long r12 = r2.J$1
            long r14 = r2.J$0
            java.lang.Object r0 = r2.L$1
            io.ktor.utils.io.ByteChannelSequentialBase r0 = (io.ktor.utils.io.ByteChannelSequentialBase) r0
            java.lang.Object r4 = r2.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r4 = (io.ktor.utils.io.ByteChannelSequentialBase) r4
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x00f3
        L_0x0044:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x004c:
            long r10 = r2.J$1
            long r12 = r2.J$0
            java.lang.Object r0 = r2.L$1
            io.ktor.utils.io.ByteChannelSequentialBase r0 = (io.ktor.utils.io.ByteChannelSequentialBase) r0
            java.lang.Object r4 = r2.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r4 = (io.ktor.utils.io.ByteChannelSequentialBase) r4
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x00cd
        L_0x005d:
            long r10 = r2.J$1
            long r12 = r2.J$0
            java.lang.Object r0 = r2.L$1
            io.ktor.utils.io.ByteChannelSequentialBase r0 = (io.ktor.utils.io.ByteChannelSequentialBase) r0
            java.lang.Object r4 = r2.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r4 = (io.ktor.utils.io.ByteChannelSequentialBase) r4
            kotlin.ResultKt.throwOnFailure(r1)
            r14 = r12
            r12 = r10
            goto L_0x00a7
        L_0x006f:
            kotlin.ResultKt.throwOnFailure(r1)
            r1 = r18
            if (r1 == r0) goto L_0x0109
            java.lang.Throwable r4 = r18.f()
            if (r4 == 0) goto L_0x0088
            java.lang.Throwable r1 = r18.f()
            r0.h(r1)
            java.lang.Long r0 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r8)
            return r0
        L_0x0088:
            r10 = r20
            r12 = r10
        L_0x008b:
            int r4 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r4 <= 0) goto L_0x0103
            r2.L$0 = r1
            r2.L$1 = r0
            r2.J$0 = r12
            r2.J$1 = r10
            r2.label = r7
            java.lang.Object r4 = r1.n0(r2)
            if (r4 != r3) goto L_0x00a0
            return r3
        L_0x00a0:
            r14 = r12
            r12 = r10
            r16 = r4
            r4 = r1
            r1 = r16
        L_0x00a7:
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x00b2
            r10 = r12
            r12 = r14
            goto L_0x0103
        L_0x00b2:
            long r10 = r4.p1(r0, r12)
            int r1 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r1 != 0) goto L_0x00da
            r2.L$0 = r4
            r2.L$1 = r0
            r2.J$0 = r14
            r2.J$1 = r12
            r2.label = r6
            java.lang.Object r1 = c(r4, r0, r12, r2)
            if (r1 != r3) goto L_0x00cb
            return r3
        L_0x00cb:
            r10 = r12
            r12 = r14
        L_0x00cd:
            java.lang.Number r1 = (java.lang.Number) r1
            long r14 = r1.longValue()
            int r1 = (r14 > r8 ? 1 : (r14 == r8 ? 0 : -1))
            if (r1 != 0) goto L_0x00d8
            goto L_0x0103
        L_0x00d8:
            r1 = r4
            goto L_0x00fa
        L_0x00da:
            int r1 = r0.z0()
            if (r1 != 0) goto L_0x00f3
            r2.L$0 = r4
            r2.L$1 = r0
            r2.J$0 = r14
            r2.J$1 = r12
            r2.J$2 = r10
            r2.label = r5
            java.lang.Object r1 = r0.l0(r7, r2)
            if (r1 != r3) goto L_0x00f3
            return r3
        L_0x00f3:
            r1 = r4
            r16 = r12
            r12 = r14
            r14 = r10
            r10 = r16
        L_0x00fa:
            long r10 = r10 - r14
            int r4 = (r14 > r8 ? 1 : (r14 == r8 ? 0 : -1))
            if (r4 <= 0) goto L_0x008b
            r0.flush()
            goto L_0x008b
        L_0x0103:
            long r12 = r12 - r10
            java.lang.Long r0 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r12)
            return r0
        L_0x0109:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Failed requirement."
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.internal.SequentialCopyToKt.b(io.ktor.utils.io.ByteChannelSequentialBase, io.ktor.utils.io.ByteChannelSequentialBase, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v11, resolved type: io.ktor.utils.io.core.internal.ChunkBuffer} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0081 A[Catch:{ all -> 0x0098 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x009b A[SYNTHETIC, Splitter:B:32:0x009b] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object c(io.ktor.utils.io.ByteChannelSequentialBase r8, io.ktor.utils.io.ByteChannelSequentialBase r9, long r10, kotlin.coroutines.Continuation r12) {
        /*
            boolean r0 = r12 instanceof io.ktor.utils.io.internal.SequentialCopyToKt$copyToTail$1
            if (r0 == 0) goto L_0x0013
            r0 = r12
            io.ktor.utils.io.internal.SequentialCopyToKt$copyToTail$1 r0 = (io.ktor.utils.io.internal.SequentialCopyToKt$copyToTail$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.internal.SequentialCopyToKt$copyToTail$1 r0 = new io.ktor.utils.io.internal.SequentialCopyToKt$copyToTail$1
            r0.<init>(r12)
        L_0x0018:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x004f
            if (r2 == r4) goto L_0x003e
            if (r2 != r3) goto L_0x0036
            int r8 = r0.I$0
            java.lang.Object r9 = r0.L$0
            io.ktor.utils.io.core.internal.ChunkBuffer r9 = (io.ktor.utils.io.core.internal.ChunkBuffer) r9
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x0033 }
            goto L_0x00ac
        L_0x0033:
            r8 = move-exception
            goto L_0x00bb
        L_0x0036:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x003e:
            java.lang.Object r8 = r0.L$1
            r9 = r8
            io.ktor.utils.io.core.internal.ChunkBuffer r9 = (io.ktor.utils.io.core.internal.ChunkBuffer) r9
            java.lang.Object r8 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r8 = (io.ktor.utils.io.ByteChannelSequentialBase) r8
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x0033 }
            r7 = r9
            r9 = r8
            r8 = r12
            r12 = r7
            goto L_0x0078
        L_0x004f:
            kotlin.ResultKt.throwOnFailure(r12)
            io.ktor.utils.io.core.internal.ChunkBuffer$Companion r12 = io.ktor.utils.io.core.internal.ChunkBuffer.j
            io.ktor.utils.io.pool.ObjectPool r12 = r12.c()
            java.lang.Object r12 = r12.h0()
            io.ktor.utils.io.core.internal.ChunkBuffer r12 = (io.ktor.utils.io.core.internal.ChunkBuffer) r12
            int r2 = r12.f()     // Catch:{ all -> 0x0098 }
            long r5 = (long) r2     // Catch:{ all -> 0x0098 }
            long r10 = kotlin.ranges.RangesKt.coerceAtMost((long) r10, (long) r5)     // Catch:{ all -> 0x0098 }
            int r10 = (int) r10     // Catch:{ all -> 0x0098 }
            r12.u(r10)     // Catch:{ all -> 0x0098 }
            r0.L$0 = r9     // Catch:{ all -> 0x0098 }
            r0.L$1 = r12     // Catch:{ all -> 0x0098 }
            r0.label = r4     // Catch:{ all -> 0x0098 }
            java.lang.Object r8 = r8.v(r12, r0)     // Catch:{ all -> 0x0098 }
            if (r8 != r1) goto L_0x0078
            return r1
        L_0x0078:
            java.lang.Number r8 = (java.lang.Number) r8     // Catch:{ all -> 0x0098 }
            int r8 = r8.intValue()     // Catch:{ all -> 0x0098 }
            r10 = -1
            if (r8 != r10) goto L_0x009b
            io.ktor.utils.io.core.internal.ChunkBuffer$Companion r8 = io.ktor.utils.io.core.internal.ChunkBuffer.j     // Catch:{ all -> 0x0098 }
            io.ktor.utils.io.pool.ObjectPool r9 = r8.c()     // Catch:{ all -> 0x0098 }
            r12.F(r9)     // Catch:{ all -> 0x0098 }
            r9 = 0
            java.lang.Long r9 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r9)     // Catch:{ all -> 0x0098 }
            io.ktor.utils.io.pool.ObjectPool r8 = r8.c()
            r12.F(r8)
            return r9
        L_0x0098:
            r8 = move-exception
            r9 = r12
            goto L_0x00bb
        L_0x009b:
            r0.L$0 = r12     // Catch:{ all -> 0x0098 }
            r10 = 0
            r0.L$1 = r10     // Catch:{ all -> 0x0098 }
            r0.I$0 = r8     // Catch:{ all -> 0x0098 }
            r0.label = r3     // Catch:{ all -> 0x0098 }
            java.lang.Object r9 = r9.M(r12, r0)     // Catch:{ all -> 0x0098 }
            if (r9 != r1) goto L_0x00ab
            return r1
        L_0x00ab:
            r9 = r12
        L_0x00ac:
            long r10 = (long) r8
            java.lang.Long r8 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r10)     // Catch:{ all -> 0x0033 }
            io.ktor.utils.io.core.internal.ChunkBuffer$Companion r10 = io.ktor.utils.io.core.internal.ChunkBuffer.j
            io.ktor.utils.io.pool.ObjectPool r10 = r10.c()
            r9.F(r10)
            return r8
        L_0x00bb:
            io.ktor.utils.io.core.internal.ChunkBuffer$Companion r10 = io.ktor.utils.io.core.internal.ChunkBuffer.j
            io.ktor.utils.io.pool.ObjectPool r10 = r10.c()
            r9.F(r10)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.internal.SequentialCopyToKt.c(io.ktor.utils.io.ByteChannelSequentialBase, io.ktor.utils.io.ByteChannelSequentialBase, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: io.ktor.utils.io.ByteChannelSequentialBase} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object d(io.ktor.utils.io.ByteChannelSequentialBase r4, io.ktor.utils.io.ByteChannelSequentialBase r5, boolean r6, kotlin.coroutines.Continuation r7) {
        /*
            boolean r0 = r7 instanceof io.ktor.utils.io.internal.SequentialCopyToKt$joinToImpl$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            io.ktor.utils.io.internal.SequentialCopyToKt$joinToImpl$1 r0 = (io.ktor.utils.io.internal.SequentialCopyToKt$joinToImpl$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.internal.SequentialCopyToKt$joinToImpl$1 r0 = new io.ktor.utils.io.internal.SequentialCopyToKt$joinToImpl$1
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
            io.ktor.utils.io.ByteChannelSequentialBase r5 = (io.ktor.utils.io.ByteChannelSequentialBase) r5
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
            java.lang.Object r4 = b(r4, r5, r2, r0)
            if (r4 != r1) goto L_0x004d
            return r1
        L_0x004d:
            if (r6 == 0) goto L_0x0052
            io.ktor.utils.io.ByteWriteChannelKt.a(r5)
        L_0x0052:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.internal.SequentialCopyToKt.d(io.ktor.utils.io.ByteChannelSequentialBase, io.ktor.utils.io.ByteChannelSequentialBase, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
