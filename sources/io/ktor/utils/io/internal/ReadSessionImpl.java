package io.ktor.utils.io.internal;

import io.ktor.utils.io.ByteBufferChannel;
import io.ktor.utils.io.SuspendableReadSession;
import io.ktor.utils.io.core.BufferUtilsJvmKt;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"Lio/ktor/utils/io/internal/ReadSessionImpl;", "Lio/ktor/utils/io/SuspendableReadSession;", "Lio/ktor/utils/io/ByteBufferChannel;", "channel", "<init>", "(Lio/ktor/utils/io/ByteBufferChannel;)V", "", "c", "()V", "", "n", "r", "(I)I", "atLeast", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "a", "(I)Lio/ktor/utils/io/core/internal/ChunkBuffer;", "", "b", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "newView", "d", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;)V", "Lio/ktor/utils/io/ByteBufferChannel;", "I", "lastAvailable", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "lastView", "e", "()I", "availableForRead", "ktor-io"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nReadSessionImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReadSessionImpl.kt\nio/ktor/utils/io/internal/ReadSessionImpl\n+ 2 Buffer.kt\nio/ktor/utils/io/core/Buffer\n*L\n1#1,47:1\n69#2:48\n69#2:49\n*S KotlinDebug\n*F\n+ 1 ReadSessionImpl.kt\nio/ktor/utils/io/internal/ReadSessionImpl\n*L\n17#1:48\n22#1:49\n*E\n"})
public final class ReadSessionImpl implements SuspendableReadSession {
    public final ByteBufferChannel b;
    public int c;
    public ChunkBuffer d = ChunkBuffer.j.a();

    public ReadSessionImpl(ByteBufferChannel byteBufferChannel) {
        Intrinsics.checkNotNullParameter(byteBufferChannel, "channel");
        this.b = byteBufferChannel;
    }

    public ChunkBuffer a(int i) {
        ByteBuffer a2 = this.b.a(0, i);
        if (a2 == null) {
            return null;
        }
        ChunkBuffer b2 = BufferUtilsJvmKt.b(a2, (ObjectPool) null, 2, (Object) null);
        b2.s();
        d(b2);
        return b2;
    }

    public Object b(int i, Continuation continuation) {
        c();
        return this.b.b(i, continuation);
    }

    public final void c() {
        d(ChunkBuffer.j.a());
    }

    public final void d(ChunkBuffer chunkBuffer) {
        int i = this.c;
        ChunkBuffer chunkBuffer2 = this.d;
        int k = i - (chunkBuffer2.k() - chunkBuffer2.i());
        if (k > 0) {
            this.b.r(k);
        }
        this.d = chunkBuffer;
        this.c = chunkBuffer.k() - chunkBuffer.i();
    }

    public int e() {
        return this.b.i();
    }

    public int r(int i) {
        c();
        int min = Math.min(e(), i);
        this.b.r(min);
        return min;
    }
}
