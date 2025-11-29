package io.ktor.util;

import io.netty.handler.codec.rtsp.RtspHeaders;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0006\u001a#\u0010\u0004\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0011\u0010\u0007\u001a\u00020\u0006*\u00020\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u001b\u0010\n\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Ljava/nio/ByteBuffer;", "destination", "", "limit", "c", "(Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;I)I", "", "e", "(Ljava/nio/ByteBuffer;)[B", "size", "a", "(Ljava/nio/ByteBuffer;I)Ljava/nio/ByteBuffer;", "ktor-utils"}, k = 2, mv = {1, 8, 0})
public final class NIOKt {
    public static final ByteBuffer a(ByteBuffer byteBuffer, int i) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        ByteBuffer allocate = ByteBuffer.allocate(i);
        ByteBuffer slice = byteBuffer.slice();
        Intrinsics.checkNotNullExpressionValue(slice, "this@copy.slice()");
        Intrinsics.checkNotNullExpressionValue(allocate, "this@apply");
        d(slice, allocate, 0, 2, (Object) null);
        allocate.clear();
        Intrinsics.checkNotNullExpressionValue(allocate, "allocate(size).apply {\n …ly)\n        clear()\n    }");
        return allocate;
    }

    public static /* synthetic */ ByteBuffer b(ByteBuffer byteBuffer, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = byteBuffer.remaining();
        }
        return a(byteBuffer, i);
    }

    public static final int c(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        Intrinsics.checkNotNullParameter(byteBuffer2, RtspHeaders.Values.DESTINATION);
        int min = Math.min(i, Math.min(byteBuffer.remaining(), byteBuffer2.remaining()));
        if (min == byteBuffer.remaining()) {
            byteBuffer2.put(byteBuffer);
        } else {
            int limit = byteBuffer.limit();
            byteBuffer.limit(byteBuffer.position() + min);
            byteBuffer2.put(byteBuffer);
            byteBuffer.limit(limit);
        }
        return min;
    }

    public static /* synthetic */ int d(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = Integer.MAX_VALUE;
        }
        return c(byteBuffer, byteBuffer2, i);
    }

    public static final byte[] e(ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        return bArr;
    }
}
