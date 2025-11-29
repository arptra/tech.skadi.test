package io.ktor.utils.io.jvm.javaio;

import io.ktor.utils.io.ByteReadChannel;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u001a)\u0010\u0005\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"Lio/ktor/utils/io/ByteReadChannel;", "Ljava/io/OutputStream;", "out", "", "limit", "a", "(Lio/ktor/utils/io/ByteReadChannel;Ljava/io/OutputStream;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-io"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nWriting.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Writing.kt\nio/ktor/utils/io/jvm/javaio/WritingKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,35:1\n1#2:36\n*E\n"})
public final class WritingKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: byte[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x009f A[Catch:{ all -> 0x00ad }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object a(io.ktor.utils.io.ByteReadChannel r18, java.io.OutputStream r19, long r20, kotlin.coroutines.Continuation r22) {
        /*
            r0 = r20
            r2 = r22
            boolean r3 = r2 instanceof io.ktor.utils.io.jvm.javaio.WritingKt$copyTo$1
            if (r3 == 0) goto L_0x0017
            r3 = r2
            io.ktor.utils.io.jvm.javaio.WritingKt$copyTo$1 r3 = (io.ktor.utils.io.jvm.javaio.WritingKt$copyTo$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L_0x0017
            int r4 = r4 - r5
            r3.label = r4
            goto L_0x001c
        L_0x0017:
            io.ktor.utils.io.jvm.javaio.WritingKt$copyTo$1 r3 = new io.ktor.utils.io.jvm.javaio.WritingKt$copyTo$1
            r3.<init>(r2)
        L_0x001c:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 0
            r7 = 1
            if (r5 == 0) goto L_0x0054
            if (r5 != r7) goto L_0x004c
            long r0 = r3.J$2
            long r8 = r3.J$1
            long r10 = r3.J$0
            java.lang.Object r5 = r3.L$2
            byte[] r5 = (byte[]) r5
            java.lang.Object r12 = r3.L$1
            java.io.OutputStream r12 = (java.io.OutputStream) r12
            java.lang.Object r13 = r3.L$0
            io.ktor.utils.io.ByteReadChannel r13 = (io.ktor.utils.io.ByteReadChannel) r13
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ all -> 0x0049 }
            r14 = r8
            r8 = r5
            r5 = r3
            r16 = r0
            r1 = r12
            r0 = r13
            r12 = r16
            goto L_0x0096
        L_0x0049:
            r0 = move-exception
            goto L_0x00c4
        L_0x004c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0054:
            kotlin.ResultKt.throwOnFailure(r2)
            r8 = 0
            int r2 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r2 < 0) goto L_0x00cc
            io.ktor.utils.io.pool.ObjectPool r2 = io.ktor.utils.io.pool.ByteArrayPoolKt.a()
            java.lang.Object r2 = r2.h0()
            r5 = r2
            byte[] r5 = (byte[]) r5
            int r2 = r5.length     // Catch:{ all -> 0x0049 }
            long r10 = (long) r2
            r12 = r8
            r8 = r5
            r5 = r3
            r2 = r0
            r0 = r18
            r1 = r19
        L_0x0072:
            int r9 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r9 >= 0) goto L_0x00b7
            long r14 = r2 - r12
            long r14 = java.lang.Math.min(r14, r10)     // Catch:{ all -> 0x00ad }
            int r9 = (int) r14     // Catch:{ all -> 0x00ad }
            r5.L$0 = r0     // Catch:{ all -> 0x00ad }
            r5.L$1 = r1     // Catch:{ all -> 0x00ad }
            r5.L$2 = r8     // Catch:{ all -> 0x00ad }
            r5.J$0 = r2     // Catch:{ all -> 0x00ad }
            r5.J$1 = r12     // Catch:{ all -> 0x00ad }
            r5.J$2 = r10     // Catch:{ all -> 0x00ad }
            r5.label = r7     // Catch:{ all -> 0x00ad }
            java.lang.Object r9 = r0.D(r8, r6, r9, r5)     // Catch:{ all -> 0x00ad }
            if (r9 != r4) goto L_0x0092
            return r4
        L_0x0092:
            r14 = r12
            r12 = r10
            r10 = r2
            r2 = r9
        L_0x0096:
            java.lang.Number r2 = (java.lang.Number) r2     // Catch:{ all -> 0x00ad }
            int r2 = r2.intValue()     // Catch:{ all -> 0x00ad }
            r3 = -1
            if (r2 == r3) goto L_0x00b4
            if (r2 <= 0) goto L_0x00b0
            r1.write(r8, r6, r2)     // Catch:{ all -> 0x00ad }
            long r2 = (long) r2
            long r2 = r2 + r14
            r16 = r10
            r10 = r12
            r12 = r2
            r2 = r16
            goto L_0x0072
        L_0x00ad:
            r0 = move-exception
            r5 = r8
            goto L_0x00c4
        L_0x00b0:
            r2 = r10
            r10 = r12
            r12 = r14
            goto L_0x0072
        L_0x00b4:
            r5 = r8
            r12 = r14
            goto L_0x00b8
        L_0x00b7:
            r5 = r8
        L_0x00b8:
            java.lang.Long r0 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r12)     // Catch:{ all -> 0x0049 }
            io.ktor.utils.io.pool.ObjectPool r1 = io.ktor.utils.io.pool.ByteArrayPoolKt.a()
            r1.recycle(r5)
            return r0
        L_0x00c4:
            io.ktor.utils.io.pool.ObjectPool r1 = io.ktor.utils.io.pool.ByteArrayPoolKt.a()
            r1.recycle(r5)
            throw r0
        L_0x00cc:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Limit shouldn't be negative: "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.jvm.javaio.WritingKt.a(io.ktor.utils.io.ByteReadChannel, java.io.OutputStream, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object b(ByteReadChannel byteReadChannel, OutputStream outputStream, long j, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j = LongCompanionObject.MAX_VALUE;
        }
        return a(byteReadChannel, outputStream, j, continuation);
    }
}
