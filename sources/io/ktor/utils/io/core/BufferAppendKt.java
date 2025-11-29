package io.ktor.utils.io.core;

import io.ktor.utils.io.bits.Memory;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a#\u0010\u0004\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\u0006\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001b\u0010\n\u001a\u00020\t*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lio/ktor/utils/io/core/Buffer;", "other", "", "maxSize", "a", "(Lio/ktor/utils/io/core/Buffer;Lio/ktor/utils/io/core/Buffer;I)I", "c", "(Lio/ktor/utils/io/core/Buffer;Lio/ktor/utils/io/core/Buffer;)I", "writeSize", "", "b", "(Lio/ktor/utils/io/core/Buffer;I)V", "ktor-io"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nBufferAppend.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BufferAppend.kt\nio/ktor/utils/io/core/BufferAppendKt\n+ 2 Buffer.kt\nio/ktor/utils/io/core/Buffer\n+ 3 Buffer.kt\nio/ktor/utils/io/core/BufferKt\n*L\n1#1,59:1\n69#2:60\n74#2:61\n69#2:76\n74#2:77\n59#2:78\n390#3,5:62\n372#3,7:67\n395#3,2:74\n*S KotlinDebug\n*F\n+ 1 BufferAppend.kt\nio/ktor/utils/io/core/BufferAppendKt\n*L\n10#1:60\n12#1:61\n32#1:76\n49#1:77\n49#1:78\n16#1:62,5\n17#1:67,7\n16#1:74,2\n*E\n"})
public final class BufferAppendKt {
    public static final int a(Buffer buffer, Buffer buffer2, int i) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(buffer2, "other");
        int min = Math.min(buffer2.k() - buffer2.i(), i);
        if (buffer.g() - buffer.k() <= min) {
            b(buffer, min);
        }
        ByteBuffer h = buffer.h();
        int k = buffer.k();
        buffer.g();
        ByteBuffer h2 = buffer2.h();
        int i2 = buffer2.i();
        buffer2.k();
        Memory.d(h2, h, i2, min, k);
        buffer2.c(min);
        buffer.a(min);
        return min;
    }

    public static final void b(Buffer buffer, int i) {
        if ((buffer.g() - buffer.k()) + (buffer.f() - buffer.g()) < i) {
            throw new IllegalArgumentException("Can't append buffer: not enough free space at the end");
        } else if ((buffer.k() + i) - buffer.g() > 0) {
            buffer.m();
        }
    }

    public static final int c(Buffer buffer, Buffer buffer2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(buffer2, "other");
        int k = buffer2.k() - buffer2.i();
        int i = buffer.i();
        if (i >= k) {
            int i2 = i - k;
            Memory.d(buffer2.h(), buffer.h(), buffer2.i(), k, i2);
            buffer2.c(k);
            buffer.o(i2);
            return k;
        }
        throw new IllegalArgumentException("Not enough space in the beginning to prepend bytes");
    }
}
