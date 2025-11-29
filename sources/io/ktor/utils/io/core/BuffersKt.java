package io.ktor.utils.io.core;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.pool.ObjectPool;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0006\u001a#\u0010\u0004\u001a\u00020\u0003*\u0004\u0018\u00010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00000\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0013\u0010\u0006\u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a$\u0010\n\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0010¢\u0006\u0004\b\n\u0010\u000b\u001a\u0014\u0010\f\u001a\u00020\u0000*\u00020\u0000H\u0010¢\u0006\u0004\b\f\u0010\u0007\u001a\u0013\u0010\u000e\u001a\u00020\r*\u00020\u0000H\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001c\u0010\u0011\u001a\u00020\r*\u00020\u00002\u0006\u0010\u0010\u001a\u00020\rH\u0010¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lio/ktor/utils/io/core/internal/ChunkBuffer;", "Lio/ktor/utils/io/pool/ObjectPool;", "pool", "", "d", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;Lio/ktor/utils/io/pool/ObjectPool;)V", "a", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;)Lio/ktor/utils/io/core/internal/ChunkBuffer;", "head", "prev", "b", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;Lio/ktor/utils/io/core/internal/ChunkBuffer;Lio/ktor/utils/io/core/internal/ChunkBuffer;)Lio/ktor/utils/io/core/internal/ChunkBuffer;", "c", "", "e", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;)J", "n", "f", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;J)J", "ktor-io"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nBuffers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Buffers.kt\nio/ktor/utils/io/core/BuffersKt\n+ 2 Buffer.kt\nio/ktor/utils/io/core/Buffer\n+ 3 MemoryJvm.kt\nio/ktor/utils/io/bits/Memory\n*L\n1#1,121:1\n69#2:122\n69#2:123\n69#2:124\n69#2:126\n15#3:125\n*S KotlinDebug\n*F\n+ 1 Buffers.kt\nio/ktor/utils/io/core/BuffersKt\n*L\n12#1:122\n80#1:123\n88#1:124\n107#1:126\n105#1:125\n*E\n"})
public final class BuffersKt {
    public static final ChunkBuffer a(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        ChunkBuffer B = chunkBuffer.B();
        ChunkBuffer C = chunkBuffer.C();
        return C == null ? B : b(C, B, B);
    }

    public static final ChunkBuffer b(ChunkBuffer chunkBuffer, ChunkBuffer chunkBuffer2, ChunkBuffer chunkBuffer3) {
        while (true) {
            ChunkBuffer B = chunkBuffer.B();
            chunkBuffer3.H(B);
            chunkBuffer = chunkBuffer.C();
            if (chunkBuffer == null) {
                return chunkBuffer2;
            }
            chunkBuffer3 = B;
        }
    }

    public static final ChunkBuffer c(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        while (true) {
            ChunkBuffer C = chunkBuffer.C();
            if (C == null) {
                return chunkBuffer;
            }
            chunkBuffer = C;
        }
    }

    public static final void d(ChunkBuffer chunkBuffer, ObjectPool objectPool) {
        Intrinsics.checkNotNullParameter(objectPool, "pool");
        while (chunkBuffer != null) {
            ChunkBuffer A = chunkBuffer.A();
            chunkBuffer.F(objectPool);
            chunkBuffer = A;
        }
    }

    public static final long e(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        return f(chunkBuffer, 0);
    }

    public static final long f(ChunkBuffer chunkBuffer, long j) {
        do {
            j += (long) (chunkBuffer.k() - chunkBuffer.i());
            chunkBuffer = chunkBuffer.C();
        } while (chunkBuffer != null);
        return j;
    }
}
