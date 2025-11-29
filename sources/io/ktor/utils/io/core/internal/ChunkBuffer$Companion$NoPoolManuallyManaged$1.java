package io.ktor.utils.io.core.internal;

import io.ktor.utils.io.pool.NoPoolImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"io/ktor/utils/io/core/internal/ChunkBuffer$Companion$NoPoolManuallyManaged$1", "Lio/ktor/utils/io/pool/NoPoolImpl;", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "a", "()Lio/ktor/utils/io/core/internal/ChunkBuffer;", "instance", "", "b", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;)V", "ktor-io"}, k = 1, mv = {1, 8, 0})
public final class ChunkBuffer$Companion$NoPoolManuallyManaged$1 extends NoPoolImpl<ChunkBuffer> {
    /* renamed from: a */
    public ChunkBuffer h0() {
        throw new UnsupportedOperationException("This pool doesn't support borrow");
    }

    /* renamed from: b */
    public void recycle(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "instance");
    }
}
