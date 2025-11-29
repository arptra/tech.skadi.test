package io.ktor.utils.io.core;

import io.ktor.utils.io.bits.Allocator;
import io.ktor.utils.io.bits.DefaultAllocator;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.pool.DefaultPool;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0010\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lio/ktor/utils/io/core/DefaultBufferPool;", "Lio/ktor/utils/io/pool/DefaultPool;", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "", "bufferSize", "capacity", "Lio/ktor/utils/io/bits/Allocator;", "allocator", "<init>", "(IILio/ktor/utils/io/bits/Allocator;)V", "v", "()Lio/ktor/utils/io/core/internal/ChunkBuffer;", "instance", "", "u", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;)V", "w", "s", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;)Lio/ktor/utils/io/core/internal/ChunkBuffer;", "h", "I", "i", "Lio/ktor/utils/io/bits/Allocator;", "ktor-io"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nBufferFactory.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BufferFactory.kt\nio/ktor/utils/io/core/DefaultBufferPool\n+ 2 MemoryJvm.kt\nio/ktor/utils/io/bits/Memory\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,93:1\n15#2:94\n15#2:95\n1#3:96\n*S KotlinDebug\n*F\n+ 1 BufferFactory.kt\nio/ktor/utils/io/core/DefaultBufferPool\n*L\n75#1:94\n76#1:95\n*E\n"})
public final class DefaultBufferPool extends DefaultPool<ChunkBuffer> {
    public final int h;
    public final Allocator i;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DefaultBufferPool(int i2, int i3, Allocator allocator, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 4096 : i2, (i4 & 2) != 0 ? 1000 : i3, (i4 & 4) != 0 ? DefaultAllocator.f9084a : allocator);
    }

    /* renamed from: s */
    public ChunkBuffer c(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "instance");
        ChunkBuffer chunkBuffer2 = (ChunkBuffer) super.c(chunkBuffer);
        chunkBuffer2.J();
        chunkBuffer2.r();
        return chunkBuffer2;
    }

    /* renamed from: u */
    public void d(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "instance");
        this.i.a(chunkBuffer.h());
        super.d(chunkBuffer);
        chunkBuffer.I();
    }

    /* renamed from: v */
    public ChunkBuffer i() {
        return new ChunkBuffer(this.i.b(this.h), (ChunkBuffer) null, this, (DefaultConstructorMarker) null);
    }

    /* renamed from: w */
    public void r(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "instance");
        super.r(chunkBuffer);
        if (((long) chunkBuffer.h().limit()) != ((long) this.h)) {
            throw new IllegalStateException(("Buffer size mismatch. Expected: " + this.h + ", actual: " + ((long) chunkBuffer.h().limit())).toString());
        } else if (chunkBuffer == ChunkBuffer.j.a()) {
            throw new IllegalStateException("ChunkBuffer.Empty couldn't be recycled".toString());
        } else if (chunkBuffer == Buffer.g.a()) {
            throw new IllegalStateException("Empty instance couldn't be recycled".toString());
        } else if (chunkBuffer.E() != 0) {
            throw new IllegalStateException("Unable to clear buffer: it is still in use.".toString());
        } else if (chunkBuffer.C() != null) {
            throw new IllegalStateException("Recycled instance shouldn't be a part of a chain.".toString());
        } else if (chunkBuffer.D() != null) {
            throw new IllegalStateException("Recycled instance shouldn't be a view or another buffer.".toString());
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DefaultBufferPool(int i2, int i3, Allocator allocator) {
        super(i3);
        Intrinsics.checkNotNullParameter(allocator, "allocator");
        this.h = i2;
        this.i = allocator;
    }
}
