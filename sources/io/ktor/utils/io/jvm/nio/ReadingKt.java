package io.ktor.utils.io.jvm.nio;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u001a)\u0010\u0005\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"Ljava/nio/channels/ReadableByteChannel;", "Lio/ktor/utils/io/ByteWriteChannel;", "ch", "", "limit", "a", "(Ljava/nio/channels/ReadableByteChannel;Lio/ktor/utils/io/ByteWriteChannel;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-io"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nReading.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Reading.kt\nio/ktor/utils/io/jvm/nio/ReadingKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,56:1\n1#2:57\n*E\n"})
public final class ReadingKt {
    /* JADX WARNING: type inference failed for: r14v1, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object a(java.nio.channels.ReadableByteChannel r11, io.ktor.utils.io.ByteWriteChannel r12, long r13, kotlin.coroutines.Continuation r15) {
        /*
            boolean r0 = r15 instanceof io.ktor.utils.io.jvm.nio.ReadingKt$copyTo$1
            if (r0 == 0) goto L_0x0013
            r0 = r15
            io.ktor.utils.io.jvm.nio.ReadingKt$copyTo$1 r0 = (io.ktor.utils.io.jvm.nio.ReadingKt$copyTo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.jvm.nio.ReadingKt$copyTo$1 r0 = new io.ktor.utils.io.jvm.nio.ReadingKt$copyTo$1
            r0.<init>(r15)
        L_0x0018:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0048
            if (r2 != r3) goto L_0x0040
            int r11 = r0.I$0
            long r12 = r0.J$0
            java.lang.Object r14 = r0.L$3
            kotlin.jvm.functions.Function1 r14 = (kotlin.jvm.functions.Function1) r14
            java.lang.Object r2 = r0.L$2
            kotlin.jvm.internal.Ref$BooleanRef r2 = (kotlin.jvm.internal.Ref.BooleanRef) r2
            java.lang.Object r4 = r0.L$1
            kotlin.jvm.internal.Ref$LongRef r4 = (kotlin.jvm.internal.Ref.LongRef) r4
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteWriteChannel r5 = (io.ktor.utils.io.ByteWriteChannel) r5
            kotlin.ResultKt.throwOnFailure(r15)
            r10 = r14
            r13 = r12
            r12 = r5
            goto L_0x00a0
        L_0x0040:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0048:
            kotlin.ResultKt.throwOnFailure(r15)
            r4 = 0
            int r15 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r15 < 0) goto L_0x00ab
            boolean r15 = r11 instanceof java.nio.channels.SelectableChannel
            if (r15 == 0) goto L_0x0067
            r15 = r11
            java.nio.channels.SelectableChannel r15 = (java.nio.channels.SelectableChannel) r15
            boolean r15 = r15.isBlocking()
            if (r15 == 0) goto L_0x005f
            goto L_0x0067
        L_0x005f:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.String r12 = "Non-blocking channels are not supported"
            r11.<init>(r12)
            throw r11
        L_0x0067:
            kotlin.jvm.internal.Ref$LongRef r15 = new kotlin.jvm.internal.Ref$LongRef
            r15.<init>()
            kotlin.jvm.internal.Ref$BooleanRef r2 = new kotlin.jvm.internal.Ref$BooleanRef
            r2.<init>()
            io.ktor.utils.io.jvm.nio.ReadingKt$copyTo$copy$1 r10 = new io.ktor.utils.io.jvm.nio.ReadingKt$copyTo$copy$1
            r4 = r10
            r5 = r13
            r7 = r15
            r8 = r11
            r9 = r2
            r4.<init>(r5, r7, r8, r9)
            boolean r11 = r12.z()
            r11 = r11 ^ r3
            r4 = r15
        L_0x0081:
            long r5 = r4.element
            int r15 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
            if (r15 >= 0) goto L_0x00a6
            boolean r15 = r2.element
            if (r15 != 0) goto L_0x00a6
            r0.L$0 = r12
            r0.L$1 = r4
            r0.L$2 = r2
            r0.L$3 = r10
            r0.J$0 = r13
            r0.I$0 = r11
            r0.label = r3
            java.lang.Object r15 = r12.x(r3, r10, r0)
            if (r15 != r1) goto L_0x00a0
            return r1
        L_0x00a0:
            if (r11 == 0) goto L_0x0081
            r12.flush()
            goto L_0x0081
        L_0x00a6:
            java.lang.Long r11 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r5)
            return r11
        L_0x00ab:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "Limit shouldn't be negative: "
            r11.append(r12)
            r11.append(r13)
            java.lang.String r11 = r11.toString()
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.String r11 = r11.toString()
            r12.<init>(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.jvm.nio.ReadingKt.a(java.nio.channels.ReadableByteChannel, io.ktor.utils.io.ByteWriteChannel, long, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
