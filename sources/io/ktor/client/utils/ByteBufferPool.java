package io.ktor.client.utils;

import io.ktor.util.InternalAPI;
import io.ktor.utils.io.pool.DefaultPool;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

@InternalAPI
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/ktor/client/utils/ByteBufferPool;", "Lio/ktor/utils/io/pool/DefaultPool;", "Ljava/nio/ByteBuffer;", "u", "()Ljava/nio/ByteBuffer;", "instance", "s", "(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
@Deprecated(level = DeprecationLevel.ERROR, message = "ByteBufferPool is moved to `io` module", replaceWith = @ReplaceWith(expression = "ByteBufferPool", imports = {"io.ktor.utils.io.pool.ByteBufferPool"}))
public final class ByteBufferPool extends DefaultPool<ByteBuffer> {
    /* renamed from: s */
    public ByteBuffer c(ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(byteBuffer, "instance");
        byteBuffer.clear();
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
        return byteBuffer;
    }

    /* renamed from: u */
    public ByteBuffer i() {
        ByteBuffer allocate = ByteBuffer.allocate(4096);
        Intrinsics.checkNotNull(allocate);
        return allocate;
    }
}
