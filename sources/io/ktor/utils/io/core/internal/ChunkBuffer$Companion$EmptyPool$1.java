package io.ktor.utils.io.core.internal;

import io.ktor.utils.io.pool.ObjectPool;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nChunkBuffer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChunkBuffer.kt\nio/ktor/utils/io/core/internal/ChunkBuffer$Companion$EmptyPool$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,180:1\n1#2:181\n*E\n"})
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"io/ktor/utils/io/core/internal/ChunkBuffer$Companion$EmptyPool$1", "Lio/ktor/utils/io/pool/ObjectPool;", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "a", "()Lio/ktor/utils/io/core/internal/ChunkBuffer;", "instance", "", "b", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;)V", "dispose", "()V", "ktor-io"}, k = 1, mv = {1, 8, 0})
public final class ChunkBuffer$Companion$EmptyPool$1 implements ObjectPool<ChunkBuffer> {
    /* renamed from: a */
    public ChunkBuffer h0() {
        return ChunkBuffer.j.a();
    }

    /* renamed from: b */
    public void recycle(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "instance");
        if (chunkBuffer != ChunkBuffer.j.a()) {
            throw new IllegalArgumentException("Only ChunkBuffer.Empty instance could be recycled.".toString());
        }
    }

    public void close() {
        ObjectPool.DefaultImpls.a(this);
    }

    public void dispose() {
    }
}
