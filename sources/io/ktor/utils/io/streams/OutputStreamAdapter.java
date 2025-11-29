package io.ktor.utils.io.streams;

import io.ktor.utils.io.bits.MemoryJvmKt;
import io.ktor.utils.io.core.Output;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001J-\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lio/ktor/utils/io/streams/OutputStreamAdapter;", "Lio/ktor/utils/io/core/Output;", "Lio/ktor/utils/io/bits/Memory;", "source", "", "offset", "length", "", "v", "(Ljava/nio/ByteBuffer;II)V", "u", "()V", "Ljava/io/OutputStream;", "i", "Ljava/io/OutputStream;", "stream", "ktor-io"}, k = 1, mv = {1, 8, 0})
final class OutputStreamAdapter extends Output {
    public final OutputStream i;

    public void u() {
        this.i.close();
    }

    public void v(ByteBuffer byteBuffer, int i2, int i3) {
        Intrinsics.checkNotNullParameter(byteBuffer, "source");
        if (!byteBuffer.hasArray() || byteBuffer.isReadOnly()) {
            byte[] bArr = (byte[]) ByteArraysKt.a().h0();
            ByteBuffer d = MemoryJvmKt.d(byteBuffer, i2, i3);
            while (true) {
                try {
                    int min = Math.min(d.remaining(), bArr.length);
                    if (min != 0) {
                        d.get(bArr, 0, min);
                        this.i.write(bArr, 0, min);
                    } else {
                        return;
                    }
                } finally {
                    ByteArraysKt.a().recycle(bArr);
                }
            }
        } else {
            this.i.write(byteBuffer.array(), byteBuffer.arrayOffset() + i2, i3);
        }
    }
}
