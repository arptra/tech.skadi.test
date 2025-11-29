package io.ktor.utils.io;

import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a%\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"", "autoFlush", "Lio/ktor/utils/io/ByteChannel;", "a", "(Z)Lio/ktor/utils/io/ByteChannel;", "", "content", "", "offset", "length", "Lio/ktor/utils/io/ByteReadChannel;", "c", "([BII)Lio/ktor/utils/io/ByteReadChannel;", "ktor-io"}, k = 2, mv = {1, 8, 0})
public final class ByteChannelKt {
    public static final ByteChannel a(boolean z) {
        return new ByteBufferChannel(z, (ObjectPool) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ByteChannel b(boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return a(z);
    }

    public static final ByteReadChannel c(byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "content");
        ByteBuffer wrap = ByteBuffer.wrap(bArr, i, i2);
        Intrinsics.checkNotNullExpressionValue(wrap, "wrap(content, offset, length)");
        return new ByteBufferChannel(wrap);
    }
}
