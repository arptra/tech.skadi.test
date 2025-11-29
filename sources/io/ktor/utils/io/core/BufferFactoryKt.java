package io.ktor.utils.io.core;

import io.ktor.utils.io.bits.Allocator;
import io.ktor.utils.io.pool.ObjectPool;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\"&\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u00008\u0000X\u0004¢\u0006\u0012\n\u0004\b\u0002\u0010\u0003\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\b"}, d2 = {"Lio/ktor/utils/io/pool/ObjectPool;", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "a", "Lio/ktor/utils/io/pool/ObjectPool;", "()Lio/ktor/utils/io/pool/ObjectPool;", "getDefaultChunkedBufferPool$annotations", "()V", "DefaultChunkedBufferPool", "ktor-io"}, k = 2, mv = {1, 8, 0})
public final class BufferFactoryKt {

    /* renamed from: a  reason: collision with root package name */
    public static final ObjectPool f9088a = new DefaultBufferPool(0, 0, (Allocator) null, 7, (DefaultConstructorMarker) null);

    public static final ObjectPool a() {
        return f9088a;
    }
}
