package io.ktor.utils.io.streams;

import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.core.Input;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001J-\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\r\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lio/ktor/utils/io/streams/InputStreamAsInput;", "Lio/ktor/utils/io/core/Input;", "Lio/ktor/utils/io/bits/Memory;", "destination", "", "offset", "length", "N", "(Ljava/nio/ByteBuffer;II)I", "", "i", "()V", "Ljava/io/InputStream;", "Ljava/io/InputStream;", "stream", "ktor-io"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nInput.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Input.kt\nio/ktor/utils/io/streams/InputStreamAsInput\n+ 2 PrimiteArrays.kt\nio/ktor/utils/io/bits/PrimiteArraysKt\n+ 3 MemoryFactoryJvm.kt\nio/ktor/utils/io/bits/MemoryFactoryJvmKt\n*L\n1#1,40:1\n282#2:41\n283#2,3:46\n17#3,4:42\n*S KotlinDebug\n*F\n+ 1 Input.kt\nio/ktor/utils/io/streams/InputStreamAsInput\n*L\n26#1:41\n26#1:46,3\n26#1:42,4\n*E\n"})
public final class InputStreamAsInput extends Input {
    public final InputStream i;

    public int N(ByteBuffer byteBuffer, int i2, int i3) {
        Intrinsics.checkNotNullParameter(byteBuffer, RtspHeaders.Values.DESTINATION);
        if (byteBuffer.hasArray() && !byteBuffer.isReadOnly()) {
            return RangesKt.coerceAtLeast(this.i.read(byteBuffer.array(), byteBuffer.arrayOffset() + i2, i3), 0);
        }
        byte[] bArr = (byte[]) ByteArraysKt.a().h0();
        try {
            int read = this.i.read(bArr, 0, Math.min(bArr.length, i3));
            if (read == -1) {
                return 0;
            }
            ByteBuffer order = ByteBuffer.wrap(bArr, 0, read).slice().order(ByteOrder.BIG_ENDIAN);
            Intrinsics.checkNotNullExpressionValue(order, "wrap(this, offset, lengt…der(ByteOrder.BIG_ENDIAN)");
            Memory.d(Memory.c(order), byteBuffer, 0, read, i2);
            ByteArraysKt.a().recycle(bArr);
            return read;
        } finally {
            ByteArraysKt.a().recycle(bArr);
        }
    }

    public void i() {
        this.i.close();
    }
}
