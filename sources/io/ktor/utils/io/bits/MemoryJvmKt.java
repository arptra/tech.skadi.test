package io.ktor.utils.io.bits;

import io.netty.handler.codec.rtsp.RtspHeaders;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a7\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\t\u001a'\u0010\u000b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u001a'\u0010\r\u001a\u00020\u0007*\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\r\u0010\f\u001a#\u0010\u000e\u001a\u00020\n*\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lio/ktor/utils/io/bits/Memory;", "", "destination", "", "offset", "length", "destinationOffset", "", "b", "(Ljava/nio/ByteBuffer;[BIII)V", "Ljava/nio/ByteBuffer;", "a", "(Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;I)V", "c", "d", "(Ljava/nio/ByteBuffer;II)Ljava/nio/ByteBuffer;", "ktor-io"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nMemoryJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MemoryJvm.kt\nio/ktor/utils/io/bits/MemoryJvmKt\n+ 2 Numbers.kt\nio/ktor/utils/io/core/internal/NumbersKt\n+ 3 PrimiteArrays.kt\nio/ktor/utils/io/bits/PrimiteArraysKt\n+ 4 MemoryFactoryJvm.kt\nio/ktor/utils/io/bits/MemoryFactoryJvmKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,230:1\n208#1:244\n208#1:245\n200#1:246\n208#1:248\n204#1,5:249\n6#2,2:231\n6#2,2:233\n6#2,2:254\n282#3:235\n283#3,3:240\n17#4,4:236\n1#5:243\n1#5:247\n*S KotlinDebug\n*F\n+ 1 MemoryJvm.kt\nio/ktor/utils/io/bits/MemoryJvmKt\n*L\n200#1:244\n204#1:245\n212#1:246\n212#1:248\n212#1:249,5\n141#1:231,2\n183#1:233,2\n219#1:254,2\n191#1:235\n191#1:240,3\n191#1:236,4\n212#1:247\n*E\n"})
public final class MemoryJvmKt {
    public static final void a(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$copyTo");
        Intrinsics.checkNotNullParameter(byteBuffer2, RtspHeaders.Values.DESTINATION);
        int remaining = byteBuffer2.remaining();
        if (!byteBuffer.hasArray() || byteBuffer.isReadOnly() || !byteBuffer2.hasArray() || byteBuffer2.isReadOnly()) {
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.limit(remaining + i);
            duplicate.position(i);
            byteBuffer2.put(duplicate);
            return;
        }
        int position = byteBuffer2.position();
        System.arraycopy(byteBuffer.array(), byteBuffer.arrayOffset() + i, byteBuffer2.array(), byteBuffer2.arrayOffset() + position, remaining);
        byteBuffer2.position(position + remaining);
    }

    public static final void b(ByteBuffer byteBuffer, byte[] bArr, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$copyTo");
        Intrinsics.checkNotNullParameter(bArr, RtspHeaders.Values.DESTINATION);
        if (!byteBuffer.hasArray() || byteBuffer.isReadOnly()) {
            byteBuffer.duplicate().get(bArr, i3, i2);
        } else {
            System.arraycopy(byteBuffer.array(), byteBuffer.arrayOffset() + i, bArr, i3, i2);
        }
    }

    public static final void c(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$copyTo");
        Intrinsics.checkNotNullParameter(byteBuffer2, RtspHeaders.Values.DESTINATION);
        if (!byteBuffer.hasArray() || byteBuffer.isReadOnly()) {
            d(byteBuffer2, i, byteBuffer.remaining()).put(byteBuffer);
            return;
        }
        byte[] array = byteBuffer.array();
        Intrinsics.checkNotNullExpressionValue(array, "array()");
        int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
        int remaining = byteBuffer.remaining();
        ByteBuffer order = ByteBuffer.wrap(array, arrayOffset, remaining).slice().order(ByteOrder.BIG_ENDIAN);
        Intrinsics.checkNotNullExpressionValue(order, "wrap(this, offset, lengt…der(ByteOrder.BIG_ENDIAN)");
        Memory.d(Memory.c(order), byteBuffer2, 0, remaining, i);
        byteBuffer.position(byteBuffer.limit());
    }

    public static final ByteBuffer d(ByteBuffer byteBuffer, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        ByteBuffer duplicate = byteBuffer.duplicate();
        Intrinsics.checkNotNullExpressionValue(duplicate, "myDuplicate$lambda$1");
        duplicate.position(i);
        duplicate.limit(i + i2);
        ByteBuffer slice = duplicate.slice();
        Intrinsics.checkNotNullExpressionValue(slice, "mySlice$lambda$2");
        return slice;
    }
}
