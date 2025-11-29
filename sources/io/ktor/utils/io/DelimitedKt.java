package io.ktor.utils.io;

import io.ktor.utils.io.internal.UtilsKt;
import java.io.IOException;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a/\u0010\u0006\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a#\u0010\t\u001a\u00020\u0004*\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\t\u0010\n\u001a\u001b\u0010\u000b\u001a\u00020\u0004*\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a\u001b\u0010\r\u001a\u00020\u0004*\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\r\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lio/ktor/utils/io/ByteReadChannel;", "Ljava/nio/ByteBuffer;", "delimiter", "dst", "", "copied0", "e", "(Lio/ktor/utils/io/ByteReadChannel;Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/LookAheadSession;", "g", "(Lio/ktor/utils/io/LookAheadSession;Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;)I", "h", "(Lio/ktor/utils/io/LookAheadSession;Ljava/nio/ByteBuffer;)I", "f", "ktor-io"}, k = 2, mv = {1, 8, 0})
public final class DelimitedKt {
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b5 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object e(io.ktor.utils.io.ByteReadChannel r16, java.nio.ByteBuffer r17, java.nio.ByteBuffer r18, int r19, kotlin.coroutines.Continuation r20) {
        /*
            r7 = r16
            r8 = r18
            r0 = r20
            boolean r1 = r0 instanceof io.ktor.utils.io.DelimitedKt$readUntilDelimiterSuspend$1
            if (r1 == 0) goto L_0x001a
            r1 = r0
            io.ktor.utils.io.DelimitedKt$readUntilDelimiterSuspend$1 r1 = (io.ktor.utils.io.DelimitedKt$readUntilDelimiterSuspend$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x001a
            int r2 = r2 - r3
            r1.label = r2
        L_0x0018:
            r9 = r1
            goto L_0x0020
        L_0x001a:
            io.ktor.utils.io.DelimitedKt$readUntilDelimiterSuspend$1 r1 = new io.ktor.utils.io.DelimitedKt$readUntilDelimiterSuspend$1
            r1.<init>(r0)
            goto L_0x0018
        L_0x0020:
            java.lang.Object r0 = r9.result
            java.lang.Object r10 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.label
            r11 = 2
            r12 = 1
            if (r1 == 0) goto L_0x004f
            if (r1 == r12) goto L_0x003f
            if (r1 != r11) goto L_0x0037
            int r1 = r9.I$0
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x00a8
        L_0x0037:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x003f:
            java.lang.Object r1 = r9.L$2
            kotlin.jvm.internal.Ref$BooleanRef r1 = (kotlin.jvm.internal.Ref.BooleanRef) r1
            java.lang.Object r2 = r9.L$1
            java.nio.ByteBuffer r2 = (java.nio.ByteBuffer) r2
            java.lang.Object r3 = r9.L$0
            io.ktor.utils.io.ByteReadChannel r3 = (io.ktor.utils.io.ByteReadChannel) r3
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0081
        L_0x004f:
            kotlin.ResultKt.throwOnFailure(r0)
            java.lang.String r0 = "Failed requirement."
            r2 = r17
            if (r2 == r8) goto L_0x00cd
            if (r19 < 0) goto L_0x00c3
            kotlin.jvm.internal.Ref$BooleanRef r13 = new kotlin.jvm.internal.Ref$BooleanRef
            r13.<init>()
            io.ktor.utils.io.DelimitedKt$readUntilDelimiterSuspend$copied$1 r14 = new io.ktor.utils.io.DelimitedKt$readUntilDelimiterSuspend$copied$1
            r6 = 0
            r0 = r14
            r1 = r19
            r2 = r17
            r3 = r18
            r4 = r13
            r5 = r16
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r9.L$0 = r7
            r9.L$1 = r8
            r9.L$2 = r13
            r9.label = r12
            java.lang.Object r0 = r7.m(r14, r9)
            if (r0 != r10) goto L_0x007e
            return r10
        L_0x007e:
            r3 = r7
            r2 = r8
            r1 = r13
        L_0x0081:
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            if (r0 <= 0) goto L_0x00b5
            boolean r4 = r3.g()
            if (r4 == 0) goto L_0x00b5
            boolean r1 = r1.element
            if (r1 != 0) goto L_0x00b5
            r1 = 0
            r9.L$0 = r1
            r9.L$1 = r1
            r9.L$2 = r1
            r9.I$0 = r0
            r9.label = r11
            java.lang.Object r1 = r3.u(r2, r9)
            if (r1 != r10) goto L_0x00a5
            return r10
        L_0x00a5:
            r15 = r1
            r1 = r0
            r0 = r15
        L_0x00a8:
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            r2 = 0
            int r0 = kotlin.ranges.RangesKt.coerceAtLeast((int) r0, (int) r2)
            int r0 = r0 + r1
            goto L_0x00be
        L_0x00b5:
            if (r0 != 0) goto L_0x00be
            boolean r1 = r3.Q()
            if (r1 == 0) goto L_0x00be
            r0 = -1
        L_0x00be:
            java.lang.Integer r0 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r0)
            return r0
        L_0x00c3:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x00cd:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.DelimitedKt.e(io.ktor.utils.io.ByteReadChannel, java.nio.ByteBuffer, java.nio.ByteBuffer, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final int f(LookAheadSession lookAheadSession, ByteBuffer byteBuffer) {
        ByteBuffer a2 = lookAheadSession.a(0, 1);
        if (a2 == null) {
            return 0;
        }
        int b = UtilsKt.b(a2, byteBuffer);
        if (b != 0) {
            return -1;
        }
        int min = Math.min(a2.remaining() - b, byteBuffer.remaining());
        int remaining = byteBuffer.remaining() - min;
        if (remaining > 0) {
            ByteBuffer a3 = lookAheadSession.a(b + min, remaining);
            if (a3 == null) {
                return min;
            }
            if (!UtilsKt.f(a3, byteBuffer, min)) {
                return -1;
            }
        }
        return byteBuffer.remaining();
    }

    public static final int g(LookAheadSession lookAheadSession, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        int i;
        boolean z = false;
        ByteBuffer a2 = lookAheadSession.a(0, 1);
        if (a2 == null) {
            return 0;
        }
        int b = UtilsKt.b(a2, byteBuffer);
        if (b != -1) {
            int min = Math.min(a2.remaining() - b, byteBuffer.remaining());
            int remaining = byteBuffer.remaining() - min;
            if (remaining == 0) {
                i = UtilsKt.e(byteBuffer2, a2, a2.position() + b);
            } else {
                ByteBuffer duplicate = a2.duplicate();
                ByteBuffer a3 = lookAheadSession.a(b + min, 1);
                if (a3 == null) {
                    Intrinsics.checkNotNullExpressionValue(duplicate, "remembered");
                    i = UtilsKt.e(byteBuffer2, duplicate, duplicate.position() + b);
                } else if (!UtilsKt.f(a3, byteBuffer, min)) {
                    Intrinsics.checkNotNullExpressionValue(duplicate, "remembered");
                    i = UtilsKt.e(byteBuffer2, duplicate, duplicate.position() + b + 1);
                } else if (a3.remaining() >= remaining) {
                    Intrinsics.checkNotNullExpressionValue(duplicate, "remembered");
                    i = UtilsKt.e(byteBuffer2, duplicate, duplicate.position() + b);
                } else {
                    Intrinsics.checkNotNullExpressionValue(duplicate, "remembered");
                    i = UtilsKt.e(byteBuffer2, duplicate, duplicate.position() + b);
                }
            }
            z = true;
        } else {
            i = UtilsKt.d(byteBuffer2, a2, 0, 2, (Object) null);
        }
        lookAheadSession.r(i);
        return z ? -i : i;
    }

    public static final int h(LookAheadSession lookAheadSession, ByteBuffer byteBuffer) {
        int f = f(lookAheadSession, byteBuffer);
        if (f == -1) {
            throw new IOException("Failed to skip delimiter: actual bytes differ from delimiter bytes");
        } else if (f < byteBuffer.remaining()) {
            return f;
        } else {
            lookAheadSession.r(byteBuffer.remaining());
            return byteBuffer.remaining();
        }
    }
}
