package io.ktor.utils.io.pool;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lio/ktor/utils/io/pool/DirectByteBufferPool;", "Lio/ktor/utils/io/pool/DefaultPool;", "Ljava/nio/ByteBuffer;", "", "capacity", "bufferSize", "<init>", "(II)V", "u", "()Ljava/nio/ByteBuffer;", "instance", "s", "(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;", "", "v", "(Ljava/nio/ByteBuffer;)V", "h", "I", "getBufferSize", "()I", "ktor-io"}, k = 1, mv = {1, 8, 0})
public final class DirectByteBufferPool extends DefaultPool<ByteBuffer> {
    public final int h;

    public DirectByteBufferPool(int i, int i2) {
        super(i);
        this.h = i2;
    }

    /* renamed from: s */
    public ByteBuffer c(ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(byteBuffer, "instance");
        byteBuffer.clear();
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
        return byteBuffer;
    }

    /* renamed from: u */
    public ByteBuffer i() {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.h);
        Intrinsics.checkNotNull(allocateDirect);
        return allocateDirect;
    }

    /* renamed from: v */
    public void r(ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(byteBuffer, "instance");
        if (byteBuffer.capacity() != this.h) {
            throw new IllegalStateException("Check failed.".toString());
        } else if (!byteBuffer.isDirect()) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }
}
