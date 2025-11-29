package io.ktor.util;

import java.nio.ByteBuffer;
import java.util.zip.Checksum;
import java.util.zip.Deflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0006\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\u0007\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0007\u0010\u0005\u001a\u001b\u0010\t\u001a\u00020\u0003*\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u0017\u0010\f\u001a\u00020\u0003*\u00020\u000bH@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a'\u0010\u0010\u001a\u00020\u0003*\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a5\u0010\u0015\u001a\u00020\u0003*\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H@ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a9\u0010\u001c\u001a\u00020\u0003*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000b2\b\b\u0002\u0010\u0019\u001a\u00020\u00132\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u001aH@ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\"\u001a\u0010#\u001a\u00020\u001e8\u0000X\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, d2 = {"Ljava/util/zip/Deflater;", "Ljava/nio/ByteBuffer;", "outBuffer", "", "f", "(Ljava/util/zip/Deflater;Ljava/nio/ByteBuffer;)V", "buffer", "j", "Ljava/util/zip/Checksum;", "k", "(Ljava/util/zip/Checksum;Ljava/nio/ByteBuffer;)V", "Lio/ktor/utils/io/ByteWriteChannel;", "h", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "crc", "deflater", "i", "(Lio/ktor/utils/io/ByteWriteChannel;Ljava/util/zip/Checksum;Ljava/util/zip/Deflater;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function0;", "", "predicate", "g", "(Lio/ktor/utils/io/ByteWriteChannel;Ljava/util/zip/Deflater;Ljava/nio/ByteBuffer;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/ByteReadChannel;", "destination", "gzip", "Lio/ktor/utils/io/pool/ObjectPool;", "pool", "e", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;ZLio/ktor/utils/io/pool/ObjectPool;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "a", "[B", "getGZIP_HEADER_PADDING", "()[B", "GZIP_HEADER_PADDING", "ktor-utils"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nDeflater.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Deflater.kt\nio/ktor/util/DeflaterKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ByteOrderJvm.kt\nio/ktor/utils/io/bits/ByteOrderJVMKt\n*L\n1#1,125:1\n1#2:126\n9#3:127\n15#3:128\n15#3:129\n*S KotlinDebug\n*F\n+ 1 Deflater.kt\nio/ktor/util/DeflaterKt\n*L\n37#1:127\n43#1:128\n44#1:129\n*E\n"})
public final class DeflaterKt {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f9024a = new byte[7];

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v27, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v29, resolved type: java.util.zip.Deflater} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v28, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: io.ktor.utils.io.pool.ObjectPool} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x014f A[Catch:{ all -> 0x01b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x017e A[Catch:{ all -> 0x01a5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01be A[Catch:{ all -> 0x01b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01e8 A[SYNTHETIC, Splitter:B:80:0x01e8] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x020f A[SYNTHETIC, Splitter:B:88:0x020f] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object e(io.ktor.utils.io.ByteReadChannel r17, io.ktor.utils.io.ByteWriteChannel r18, boolean r19, io.ktor.utils.io.pool.ObjectPool r20, kotlin.coroutines.Continuation r21) {
        /*
            r0 = r18
            r1 = r19
            r2 = r21
            boolean r3 = r2 instanceof io.ktor.util.DeflaterKt$deflateTo$1
            if (r3 == 0) goto L_0x0019
            r3 = r2
            io.ktor.util.DeflaterKt$deflateTo$1 r3 = (io.ktor.util.DeflaterKt$deflateTo$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L_0x0019
            int r4 = r4 - r5
            r3.label = r4
            goto L_0x001e
        L_0x0019:
            io.ktor.util.DeflaterKt$deflateTo$1 r3 = new io.ktor.util.DeflaterKt$deflateTo$1
            r3.<init>(r2)
        L_0x001e:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 5
            r7 = 4
            r8 = 3
            r9 = 2
            r10 = 0
            r11 = 1
            if (r5 == 0) goto L_0x00fe
            if (r5 == r11) goto L_0x00da
            if (r5 == r9) goto L_0x00ac
            if (r5 == r8) goto L_0x0085
            if (r5 == r7) goto L_0x005d
            if (r5 != r6) goto L_0x0055
            java.lang.Object r0 = r3.L$3
            r1 = r0
            java.nio.ByteBuffer r1 = (java.nio.ByteBuffer) r1
            java.lang.Object r0 = r3.L$2
            r4 = r0
            java.nio.ByteBuffer r4 = (java.nio.ByteBuffer) r4
            java.lang.Object r0 = r3.L$1
            r5 = r0
            java.util.zip.Deflater r5 = (java.util.zip.Deflater) r5
            java.lang.Object r0 = r3.L$0
            r3 = r0
            io.ktor.utils.io.pool.ObjectPool r3 = (io.ktor.utils.io.pool.ObjectPool) r3
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ all -> 0x0051 }
            goto L_0x0200
        L_0x0051:
            r0 = move-exception
            r13 = r3
            goto L_0x0210
        L_0x0055:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x005d:
            boolean r0 = r3.Z$0
            java.lang.Object r1 = r3.L$5
            java.nio.ByteBuffer r1 = (java.nio.ByteBuffer) r1
            java.lang.Object r5 = r3.L$4
            java.nio.ByteBuffer r5 = (java.nio.ByteBuffer) r5
            java.lang.Object r7 = r3.L$3
            java.util.zip.Deflater r7 = (java.util.zip.Deflater) r7
            java.lang.Object r8 = r3.L$2
            java.util.zip.CRC32 r8 = (java.util.zip.CRC32) r8
            java.lang.Object r9 = r3.L$1
            io.ktor.utils.io.pool.ObjectPool r9 = (io.ktor.utils.io.pool.ObjectPool) r9
            java.lang.Object r11 = r3.L$0
            io.ktor.utils.io.ByteWriteChannel r11 = (io.ktor.utils.io.ByteWriteChannel) r11
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ all -> 0x007f }
            r13 = r9
            r2 = r11
            r11 = r7
            goto L_0x01e6
        L_0x007f:
            r0 = move-exception
            r4 = r5
            r5 = r7
            r13 = r9
            goto L_0x0210
        L_0x0085:
            boolean r0 = r3.Z$0
            java.lang.Object r1 = r3.L$6
            java.nio.ByteBuffer r1 = (java.nio.ByteBuffer) r1
            java.lang.Object r5 = r3.L$5
            java.nio.ByteBuffer r5 = (java.nio.ByteBuffer) r5
            java.lang.Object r11 = r3.L$4
            java.util.zip.Deflater r11 = (java.util.zip.Deflater) r11
            java.lang.Object r12 = r3.L$3
            java.util.zip.CRC32 r12 = (java.util.zip.CRC32) r12
            java.lang.Object r13 = r3.L$2
            io.ktor.utils.io.pool.ObjectPool r13 = (io.ktor.utils.io.pool.ObjectPool) r13
            java.lang.Object r14 = r3.L$1
            io.ktor.utils.io.ByteWriteChannel r14 = (io.ktor.utils.io.ByteWriteChannel) r14
            java.lang.Object r15 = r3.L$0
            io.ktor.utils.io.ByteReadChannel r15 = (io.ktor.utils.io.ByteReadChannel) r15
        L_0x00a3:
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ all -> 0x00a7 }
            goto L_0x00f9
        L_0x00a7:
            r0 = move-exception
        L_0x00a8:
            r4 = r5
            r5 = r11
            goto L_0x0210
        L_0x00ac:
            boolean r0 = r3.Z$0
            java.lang.Object r1 = r3.L$6
            java.nio.ByteBuffer r1 = (java.nio.ByteBuffer) r1
            java.lang.Object r5 = r3.L$5
            java.nio.ByteBuffer r5 = (java.nio.ByteBuffer) r5
            java.lang.Object r11 = r3.L$4
            java.util.zip.Deflater r11 = (java.util.zip.Deflater) r11
            java.lang.Object r12 = r3.L$3
            java.util.zip.CRC32 r12 = (java.util.zip.CRC32) r12
            java.lang.Object r13 = r3.L$2
            io.ktor.utils.io.pool.ObjectPool r13 = (io.ktor.utils.io.pool.ObjectPool) r13
            java.lang.Object r14 = r3.L$1
            io.ktor.utils.io.ByteWriteChannel r14 = (io.ktor.utils.io.ByteWriteChannel) r14
            java.lang.Object r15 = r3.L$0
            io.ktor.utils.io.ByteReadChannel r15 = (io.ktor.utils.io.ByteReadChannel) r15
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ all -> 0x00a7 }
            r16 = r1
            r1 = r0
            r0 = r14
            r14 = r13
            r13 = r12
            r12 = r11
            r11 = r5
            r5 = r3
            r3 = r16
            goto L_0x0176
        L_0x00da:
            boolean r0 = r3.Z$0
            java.lang.Object r1 = r3.L$6
            java.nio.ByteBuffer r1 = (java.nio.ByteBuffer) r1
            java.lang.Object r5 = r3.L$5
            java.nio.ByteBuffer r5 = (java.nio.ByteBuffer) r5
            java.lang.Object r11 = r3.L$4
            java.util.zip.Deflater r11 = (java.util.zip.Deflater) r11
            java.lang.Object r12 = r3.L$3
            java.util.zip.CRC32 r12 = (java.util.zip.CRC32) r12
            java.lang.Object r13 = r3.L$2
            io.ktor.utils.io.pool.ObjectPool r13 = (io.ktor.utils.io.pool.ObjectPool) r13
            java.lang.Object r14 = r3.L$1
            io.ktor.utils.io.ByteWriteChannel r14 = (io.ktor.utils.io.ByteWriteChannel) r14
            java.lang.Object r15 = r3.L$0
            io.ktor.utils.io.ByteReadChannel r15 = (io.ktor.utils.io.ByteReadChannel) r15
            goto L_0x00a3
        L_0x00f9:
            r2 = r1
            r1 = r0
            r0 = r14
            goto L_0x01b2
        L_0x00fe:
            kotlin.ResultKt.throwOnFailure(r2)
            java.util.zip.CRC32 r12 = new java.util.zip.CRC32
            r12.<init>()
            java.util.zip.Deflater r5 = new java.util.zip.Deflater
            r2 = -1
            r5.<init>(r2, r11)
            java.lang.Object r2 = r20.h0()
            java.nio.ByteBuffer r2 = (java.nio.ByteBuffer) r2
            java.lang.Object r13 = r20.h0()
            java.nio.ByteBuffer r13 = (java.nio.ByteBuffer) r13
            if (r1 == 0) goto L_0x0141
            r14 = r17
            r3.L$0 = r14     // Catch:{ all -> 0x013d }
            r3.L$1 = r0     // Catch:{ all -> 0x013d }
            r15 = r20
            r3.L$2 = r15     // Catch:{ all -> 0x0137 }
            r3.L$3 = r12     // Catch:{ all -> 0x0137 }
            r3.L$4 = r5     // Catch:{ all -> 0x0137 }
            r3.L$5 = r2     // Catch:{ all -> 0x0137 }
            r3.L$6 = r13     // Catch:{ all -> 0x0137 }
            r3.Z$0 = r1     // Catch:{ all -> 0x0137 }
            r3.label = r11     // Catch:{ all -> 0x0137 }
            java.lang.Object r11 = h(r0, r3)     // Catch:{ all -> 0x0137 }
            if (r11 != r4) goto L_0x0145
            return r4
        L_0x0137:
            r0 = move-exception
        L_0x0138:
            r4 = r2
            r1 = r13
            r13 = r15
            goto L_0x0210
        L_0x013d:
            r0 = move-exception
            r15 = r20
            goto L_0x0138
        L_0x0141:
            r14 = r17
            r15 = r20
        L_0x0145:
            r11 = r5
            r5 = r2
            r2 = r13
            r13 = r15
        L_0x0149:
            boolean r15 = r14.Q()     // Catch:{ all -> 0x01b4 }
            if (r15 != 0) goto L_0x01b8
            r5.clear()     // Catch:{ all -> 0x01b4 }
            r3.L$0 = r14     // Catch:{ all -> 0x01b4 }
            r3.L$1 = r0     // Catch:{ all -> 0x01b4 }
            r3.L$2 = r13     // Catch:{ all -> 0x01b4 }
            r3.L$3 = r12     // Catch:{ all -> 0x01b4 }
            r3.L$4 = r11     // Catch:{ all -> 0x01b4 }
            r3.L$5 = r5     // Catch:{ all -> 0x01b4 }
            r3.L$6 = r2     // Catch:{ all -> 0x01b4 }
            r3.Z$0 = r1     // Catch:{ all -> 0x01b4 }
            r3.label = r9     // Catch:{ all -> 0x01b4 }
            java.lang.Object r15 = r14.u(r5, r3)     // Catch:{ all -> 0x01b4 }
            if (r15 != r4) goto L_0x016b
            return r4
        L_0x016b:
            r16 = r3
            r3 = r2
            r2 = r15
            r15 = r14
            r14 = r13
            r13 = r12
            r12 = r11
            r11 = r5
            r5 = r16
        L_0x0176:
            java.lang.Number r2 = (java.lang.Number) r2     // Catch:{ all -> 0x01a5 }
            int r2 = r2.intValue()     // Catch:{ all -> 0x01a5 }
            if (r2 <= 0) goto L_0x01ac
            r11.flip()     // Catch:{ all -> 0x01a5 }
            k(r13, r11)     // Catch:{ all -> 0x01a5 }
            j(r12, r11)     // Catch:{ all -> 0x01a5 }
            io.ktor.util.DeflaterKt$deflateTo$2 r2 = new io.ktor.util.DeflaterKt$deflateTo$2     // Catch:{ all -> 0x01a5 }
            r2.<init>(r12)     // Catch:{ all -> 0x01a5 }
            r5.L$0 = r15     // Catch:{ all -> 0x01a5 }
            r5.L$1 = r0     // Catch:{ all -> 0x01a5 }
            r5.L$2 = r14     // Catch:{ all -> 0x01a5 }
            r5.L$3 = r13     // Catch:{ all -> 0x01a5 }
            r5.L$4 = r12     // Catch:{ all -> 0x01a5 }
            r5.L$5 = r11     // Catch:{ all -> 0x01a5 }
            r5.L$6 = r3     // Catch:{ all -> 0x01a5 }
            r5.Z$0 = r1     // Catch:{ all -> 0x01a5 }
            r5.label = r8     // Catch:{ all -> 0x01a5 }
            java.lang.Object r2 = g(r0, r12, r3, r2, r5)     // Catch:{ all -> 0x01a5 }
            if (r2 != r4) goto L_0x01ac
            return r4
        L_0x01a5:
            r0 = move-exception
            r1 = r3
            r4 = r11
            r5 = r12
            r13 = r14
            goto L_0x0210
        L_0x01ac:
            r2 = r3
            r3 = r5
            r5 = r11
            r11 = r12
            r12 = r13
            r13 = r14
        L_0x01b2:
            r14 = r15
            goto L_0x0149
        L_0x01b4:
            r0 = move-exception
            r1 = r2
            goto L_0x00a8
        L_0x01b8:
            java.lang.Throwable r8 = r14.f()     // Catch:{ all -> 0x01b4 }
            if (r8 != 0) goto L_0x020f
            r11.finish()     // Catch:{ all -> 0x01b4 }
            io.ktor.util.DeflaterKt$deflateTo$4 r8 = new io.ktor.util.DeflaterKt$deflateTo$4     // Catch:{ all -> 0x01b4 }
            r8.<init>(r11)     // Catch:{ all -> 0x01b4 }
            r3.L$0 = r0     // Catch:{ all -> 0x01b4 }
            r3.L$1 = r13     // Catch:{ all -> 0x01b4 }
            r3.L$2 = r12     // Catch:{ all -> 0x01b4 }
            r3.L$3 = r11     // Catch:{ all -> 0x01b4 }
            r3.L$4 = r5     // Catch:{ all -> 0x01b4 }
            r3.L$5 = r2     // Catch:{ all -> 0x01b4 }
            r3.L$6 = r10     // Catch:{ all -> 0x01b4 }
            r3.Z$0 = r1     // Catch:{ all -> 0x01b4 }
            r3.label = r7     // Catch:{ all -> 0x01b4 }
            java.lang.Object r7 = g(r0, r11, r2, r8, r3)     // Catch:{ all -> 0x01b4 }
            if (r7 != r4) goto L_0x01df
            return r4
        L_0x01df:
            r8 = r12
            r16 = r2
            r2 = r0
            r0 = r1
            r1 = r16
        L_0x01e6:
            if (r0 == 0) goto L_0x0203
            r3.L$0 = r13     // Catch:{ all -> 0x00a7 }
            r3.L$1 = r11     // Catch:{ all -> 0x00a7 }
            r3.L$2 = r5     // Catch:{ all -> 0x00a7 }
            r3.L$3 = r1     // Catch:{ all -> 0x00a7 }
            r3.L$4 = r10     // Catch:{ all -> 0x00a7 }
            r3.L$5 = r10     // Catch:{ all -> 0x00a7 }
            r3.label = r6     // Catch:{ all -> 0x00a7 }
            java.lang.Object r0 = i(r2, r8, r11, r3)     // Catch:{ all -> 0x00a7 }
            if (r0 != r4) goto L_0x01fd
            return r4
        L_0x01fd:
            r4 = r5
            r5 = r11
            r3 = r13
        L_0x0200:
            r13 = r3
            r11 = r5
            r5 = r4
        L_0x0203:
            r11.end()
            r13.recycle(r5)
            r13.recycle(r1)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x020f:
            throw r8     // Catch:{ all -> 0x01b4 }
        L_0x0210:
            r5.end()
            r13.recycle(r4)
            r13.recycle(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.DeflaterKt.e(io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteWriteChannel, boolean, io.ktor.utils.io.pool.ObjectPool, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final void f(Deflater deflater, ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            byteBuffer.position(byteBuffer.position() + deflater.deflate(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining()));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object g(io.ktor.utils.io.ByteWriteChannel r6, java.util.zip.Deflater r7, java.nio.ByteBuffer r8, kotlin.jvm.functions.Function0 r9, kotlin.coroutines.Continuation r10) {
        /*
            boolean r0 = r10 instanceof io.ktor.util.DeflaterKt$deflateWhile$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            io.ktor.util.DeflaterKt$deflateWhile$1 r0 = (io.ktor.util.DeflaterKt$deflateWhile$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.util.DeflaterKt$deflateWhile$1 r0 = new io.ktor.util.DeflaterKt$deflateWhile$1
            r0.<init>(r10)
        L_0x0018:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0047
            if (r2 != r3) goto L_0x003f
            java.lang.Object r6 = r0.L$3
            kotlin.jvm.functions.Function0 r6 = (kotlin.jvm.functions.Function0) r6
            java.lang.Object r7 = r0.L$2
            java.nio.ByteBuffer r7 = (java.nio.ByteBuffer) r7
            java.lang.Object r8 = r0.L$1
            java.util.zip.Deflater r8 = (java.util.zip.Deflater) r8
            java.lang.Object r9 = r0.L$0
            io.ktor.utils.io.ByteWriteChannel r9 = (io.ktor.utils.io.ByteWriteChannel) r9
            kotlin.ResultKt.throwOnFailure(r10)
            r4 = r9
            r9 = r6
            r6 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L_0x004a
        L_0x003f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0047:
            kotlin.ResultKt.throwOnFailure(r10)
        L_0x004a:
            java.lang.Object r10 = r9.invoke()
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x0070
            r8.clear()
            f(r7, r8)
            r8.flip()
            r0.L$0 = r6
            r0.L$1 = r7
            r0.L$2 = r8
            r0.L$3 = r9
            r0.label = r3
            java.lang.Object r10 = r6.l(r8, r0)
            if (r10 != r1) goto L_0x004a
            return r1
        L_0x0070:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.DeflaterKt.g(io.ktor.utils.io.ByteWriteChannel, java.util.zip.Deflater, java.nio.ByteBuffer, kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0068 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0076 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object h(io.ktor.utils.io.ByteWriteChannel r6, kotlin.coroutines.Continuation r7) {
        /*
            boolean r0 = r7 instanceof io.ktor.util.DeflaterKt$putGzipHeader$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            io.ktor.util.DeflaterKt$putGzipHeader$1 r0 = (io.ktor.util.DeflaterKt$putGzipHeader$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.util.DeflaterKt$putGzipHeader$1 r0 = new io.ktor.util.DeflaterKt$putGzipHeader$1
            r0.<init>(r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0047
            if (r2 == r5) goto L_0x003f
            if (r2 == r4) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0077
        L_0x002f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0037:
            java.lang.Object r6 = r0.L$0
            io.ktor.utils.io.ByteWriteChannel r6 = (io.ktor.utils.io.ByteWriteChannel) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0069
        L_0x003f:
            java.lang.Object r6 = r0.L$0
            io.ktor.utils.io.ByteWriteChannel r6 = (io.ktor.utils.io.ByteWriteChannel) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x005c
        L_0x0047:
            kotlin.ResultKt.throwOnFailure(r7)
            r7 = -29921(0xffffffffffff8b1f, float:NaN)
            short r7 = (short) r7
            short r7 = java.lang.Short.reverseBytes(r7)
            r0.L$0 = r6
            r0.label = r5
            java.lang.Object r7 = r6.t(r7, r0)
            if (r7 != r1) goto L_0x005c
            return r1
        L_0x005c:
            r0.L$0 = r6
            r0.label = r4
            r7 = 8
            java.lang.Object r7 = r6.C(r7, r0)
            if (r7 != r1) goto L_0x0069
            return r1
        L_0x0069:
            byte[] r7 = f9024a
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r6 = io.ktor.utils.io.ByteWriteChannelKt.b(r6, r7, r0)
            if (r6 != r1) goto L_0x0077
            return r1
        L_0x0077:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.DeflaterKt.h(io.ktor.utils.io.ByteWriteChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: java.util.zip.Deflater} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object i(io.ktor.utils.io.ByteWriteChannel r7, java.util.zip.Checksum r8, java.util.zip.Deflater r9, kotlin.coroutines.Continuation r10) {
        /*
            boolean r0 = r10 instanceof io.ktor.util.DeflaterKt$putGzipTrailer$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            io.ktor.util.DeflaterKt$putGzipTrailer$1 r0 = (io.ktor.util.DeflaterKt$putGzipTrailer$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.util.DeflaterKt$putGzipTrailer$1 r0 = new io.ktor.util.DeflaterKt$putGzipTrailer$1
            r0.<init>(r10)
        L_0x0018:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0041
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0070
        L_0x002c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0034:
            java.lang.Object r7 = r0.L$1
            r9 = r7
            java.util.zip.Deflater r9 = (java.util.zip.Deflater) r9
            java.lang.Object r7 = r0.L$0
            io.ktor.utils.io.ByteWriteChannel r7 = (io.ktor.utils.io.ByteWriteChannel) r7
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x005a
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r10)
            long r5 = r8.getValue()
            int r8 = (int) r5
            int r8 = java.lang.Integer.reverseBytes(r8)
            r0.L$0 = r7
            r0.L$1 = r9
            r0.label = r4
            java.lang.Object r8 = r7.O(r8, r0)
            if (r8 != r1) goto L_0x005a
            return r1
        L_0x005a:
            int r8 = r9.getTotalIn()
            int r8 = java.lang.Integer.reverseBytes(r8)
            r9 = 0
            r0.L$0 = r9
            r0.L$1 = r9
            r0.label = r3
            java.lang.Object r7 = r7.O(r8, r0)
            if (r7 != r1) goto L_0x0070
            return r1
        L_0x0070:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.DeflaterKt.i(io.ktor.utils.io.ByteWriteChannel, java.util.zip.Checksum, java.util.zip.Deflater, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final void j(Deflater deflater, ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            deflater.setInput(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            return;
        }
        throw new IllegalArgumentException("buffer need to be array-backed".toString());
    }

    public static final void k(Checksum checksum, ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(checksum, "<this>");
        Intrinsics.checkNotNullParameter(byteBuffer, "buffer");
        if (byteBuffer.hasArray()) {
            checksum.update(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            return;
        }
        throw new IllegalArgumentException("buffer need to be array-backed".toString());
    }
}
