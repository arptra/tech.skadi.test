package io.ktor.utils.io.jvm.javaio;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.CoroutinesKt;
import io.ktor.utils.io.pool.ByteArrayPoolKt;
import io.ktor.utils.io.pool.ObjectPool;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\u001a)\u0010\u0005\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a)\u0010\r\u001a\u00020\f*\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\r\u0010\u000e\u001a-\u0010\u0010\u001a\u00020\f*\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00072\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u000f0\tH\u0007¢\u0006\u0004\b\u0010\u0010\u000e\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Ljava/io/InputStream;", "Lio/ktor/utils/io/ByteWriteChannel;", "channel", "", "limit", "a", "(Ljava/io/InputStream;Lio/ktor/utils/io/ByteWriteChannel;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext;", "context", "Lio/ktor/utils/io/pool/ObjectPool;", "Ljava/nio/ByteBuffer;", "pool", "Lio/ktor/utils/io/ByteReadChannel;", "b", "(Ljava/io/InputStream;Lkotlin/coroutines/CoroutineContext;Lio/ktor/utils/io/pool/ObjectPool;)Lio/ktor/utils/io/ByteReadChannel;", "", "d", "ktor-io"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nReading.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Reading.kt\nio/ktor/utils/io/jvm/javaio/ReadingKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,99:1\n1#2:100\n*E\n"})
public final class ReadingKt {
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00b5 A[EDGE_INSN: B:47:0x00b5->B:37:0x00b5 ?: BREAK  , SYNTHETIC] */
    public static final java.lang.Object a(java.io.InputStream r19, io.ktor.utils.io.ByteWriteChannel r20, long r21, kotlin.coroutines.Continuation r23) {
        /*
            r0 = r21
            r2 = r23
            boolean r3 = r2 instanceof io.ktor.utils.io.jvm.javaio.ReadingKt$copyTo$1
            if (r3 == 0) goto L_0x0017
            r3 = r2
            io.ktor.utils.io.jvm.javaio.ReadingKt$copyTo$1 r3 = (io.ktor.utils.io.jvm.javaio.ReadingKt$copyTo$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L_0x0017
            int r4 = r4 - r5
            r3.label = r4
            goto L_0x001c
        L_0x0017:
            io.ktor.utils.io.jvm.javaio.ReadingKt$copyTo$1 r3 = new io.ktor.utils.io.jvm.javaio.ReadingKt$copyTo$1
            r3.<init>(r2)
        L_0x001c:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 1
            if (r5 == 0) goto L_0x0057
            if (r5 != r6) goto L_0x004f
            int r0 = r3.I$0
            long r7 = r3.J$2
            long r9 = r3.J$1
            long r11 = r3.J$0
            java.lang.Object r1 = r3.L$2
            byte[] r1 = (byte[]) r1
            java.lang.Object r5 = r3.L$1
            io.ktor.utils.io.ByteWriteChannel r5 = (io.ktor.utils.io.ByteWriteChannel) r5
            java.lang.Object r13 = r3.L$0
            java.io.InputStream r13 = (java.io.InputStream) r13
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ all -> 0x004c }
            r16 = r5
            r5 = r1
            r1 = r16
            r17 = r7
            r7 = r3
            r2 = r11
            r11 = r17
            goto L_0x00a8
        L_0x004c:
            r0 = move-exception
            goto L_0x00c3
        L_0x004f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0057:
            kotlin.ResultKt.throwOnFailure(r2)
            r7 = 0
            int r2 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r2 < 0) goto L_0x00cb
            io.ktor.utils.io.pool.ObjectPool r2 = io.ktor.utils.io.pool.ByteArrayPoolKt.a()
            java.lang.Object r2 = r2.h0()
            byte[] r2 = (byte[]) r2
            int r5 = r2.length     // Catch:{ all -> 0x00c1 }
            long r9 = (long) r5
            r5 = r2
            r11 = r7
            r7 = r3
            r2 = r0
            r0 = r19
            r1 = r20
        L_0x0074:
            int r8 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
            if (r8 >= 0) goto L_0x00b5
            long r13 = r2 - r11
            long r13 = java.lang.Math.min(r13, r9)     // Catch:{ all -> 0x00b2 }
            int r8 = (int) r13     // Catch:{ all -> 0x00b2 }
            r13 = 0
            int r8 = r0.read(r5, r13, r8)     // Catch:{ all -> 0x00b2 }
            r14 = -1
            if (r8 != r14) goto L_0x0088
            goto L_0x00b5
        L_0x0088:
            if (r8 <= 0) goto L_0x0074
            r7.L$0 = r0     // Catch:{ all -> 0x00b2 }
            r7.L$1 = r1     // Catch:{ all -> 0x00b2 }
            r7.L$2 = r5     // Catch:{ all -> 0x00b2 }
            r7.J$0 = r2     // Catch:{ all -> 0x00b2 }
            r7.J$1 = r11     // Catch:{ all -> 0x00b2 }
            r7.J$2 = r9     // Catch:{ all -> 0x00b2 }
            r7.I$0 = r8     // Catch:{ all -> 0x00b2 }
            r7.label = r6     // Catch:{ all -> 0x00b2 }
            java.lang.Object r13 = r1.I(r5, r13, r8, r7)     // Catch:{ all -> 0x00b2 }
            if (r13 != r4) goto L_0x00a1
            return r4
        L_0x00a1:
            r13 = r0
            r0 = r8
            r16 = r9
            r9 = r11
            r11 = r16
        L_0x00a8:
            long r14 = (long) r0     // Catch:{ all -> 0x00b2 }
            long r8 = r9 + r14
            r0 = r13
            r16 = r8
            r9 = r11
            r11 = r16
            goto L_0x0074
        L_0x00b2:
            r0 = move-exception
            r1 = r5
            goto L_0x00c3
        L_0x00b5:
            java.lang.Long r0 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r11)     // Catch:{ all -> 0x00b2 }
            io.ktor.utils.io.pool.ObjectPool r1 = io.ktor.utils.io.pool.ByteArrayPoolKt.a()
            r1.recycle(r5)
            return r0
        L_0x00c1:
            r0 = move-exception
            r1 = r2
        L_0x00c3:
            io.ktor.utils.io.pool.ObjectPool r2 = io.ktor.utils.io.pool.ByteArrayPoolKt.a()
            r2.recycle(r1)
            throw r0
        L_0x00cb:
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
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.jvm.javaio.ReadingKt.a(java.io.InputStream, io.ktor.utils.io.ByteWriteChannel, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final ByteReadChannel b(InputStream inputStream, CoroutineContext coroutineContext, ObjectPool objectPool) {
        Intrinsics.checkNotNullParameter(inputStream, "<this>");
        Intrinsics.checkNotNullParameter(coroutineContext, "context");
        Intrinsics.checkNotNullParameter(objectPool, "pool");
        return CoroutinesKt.b(GlobalScope.f3732a, coroutineContext, true, new ReadingKt$toByteReadChannel$1(objectPool, inputStream, (Continuation<? super ReadingKt$toByteReadChannel$1>) null)).b();
    }

    public static /* synthetic */ ByteReadChannel c(InputStream inputStream, CoroutineContext coroutineContext, ObjectPool objectPool, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.b();
        }
        return b(inputStream, coroutineContext, objectPool);
    }

    public static final ByteReadChannel d(InputStream inputStream, CoroutineContext coroutineContext, ObjectPool objectPool) {
        Intrinsics.checkNotNullParameter(inputStream, "<this>");
        Intrinsics.checkNotNullParameter(coroutineContext, "context");
        Intrinsics.checkNotNullParameter(objectPool, "pool");
        return CoroutinesKt.b(GlobalScope.f3732a, coroutineContext, true, new ReadingKt$toByteReadChannel$2(objectPool, inputStream, (Continuation<? super ReadingKt$toByteReadChannel$2>) null)).b();
    }

    public static /* synthetic */ ByteReadChannel e(InputStream inputStream, CoroutineContext coroutineContext, ObjectPool objectPool, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.b();
        }
        if ((i & 2) != 0) {
            objectPool = ByteArrayPoolKt.a();
        }
        return d(inputStream, coroutineContext, objectPool);
    }
}
