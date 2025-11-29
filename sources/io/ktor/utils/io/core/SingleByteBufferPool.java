package io.ktor.utils.io.core;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.pool.SingleInstancePool;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\f\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R#\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u00058\u0006¢\u0006\f\n\u0004\b\n\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lio/ktor/utils/io/core/SingleByteBufferPool;", "Lio/ktor/utils/io/pool/SingleInstancePool;", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "Ljava/nio/ByteBuffer;", "instance", "Lkotlin/Function1;", "", "release", "<init>", "(Ljava/nio/ByteBuffer;Lkotlin/jvm/functions/Function1;)V", "d", "()Lio/ktor/utils/io/core/internal/ChunkBuffer;", "c", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;)V", "Ljava/nio/ByteBuffer;", "getInstance", "()Ljava/nio/ByteBuffer;", "Lkotlin/jvm/functions/Function1;", "getRelease", "()Lkotlin/jvm/functions/Function1;", "ktor-io"}, k = 1, mv = {1, 8, 0})
final class SingleByteBufferPool extends SingleInstancePool<ChunkBuffer> {
    public final ByteBuffer c;
    public final Function1 d;

    public SingleByteBufferPool(ByteBuffer byteBuffer, Function1 function1) {
        Intrinsics.checkNotNullParameter(byteBuffer, "instance");
        Intrinsics.checkNotNullParameter(function1, "release");
        this.c = byteBuffer;
        this.d = function1;
    }

    /* renamed from: c */
    public void a(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "instance");
        this.d.invoke(this.c);
    }

    /* renamed from: d */
    public ChunkBuffer b() {
        return BufferUtilsJvmKt.a(this.c, this);
    }
}
