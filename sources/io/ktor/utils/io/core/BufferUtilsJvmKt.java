package io.ktor.utils.io.core;

import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.bits.MemoryJvmKt;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.pool.ObjectPool;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u001a'\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001b\u0010\t\u001a\u00020\b*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\t\u0010\n\u001a!\u0010\u000f\u001a\u00020\b*\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Ljava/nio/ByteBuffer;", "buffer", "Lio/ktor/utils/io/pool/ObjectPool;", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "pool", "a", "(Ljava/nio/ByteBuffer;Lio/ktor/utils/io/pool/ObjectPool;)Lio/ktor/utils/io/core/internal/ChunkBuffer;", "child", "", "d", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;Ljava/nio/ByteBuffer;)V", "Lio/ktor/utils/io/core/Buffer;", "dst", "", "length", "c", "(Lio/ktor/utils/io/core/Buffer;Ljava/nio/ByteBuffer;I)V", "ktor-io"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nBufferUtilsJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BufferUtilsJvm.kt\nio/ktor/utils/io/core/BufferUtilsJvmKt\n+ 2 MemoryFactoryJvm.kt\nio/ktor/utils/io/bits/MemoryFactoryJvmKt\n+ 3 Buffer.kt\nio/ktor/utils/io/core/Buffer\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 BufferPrimitives.kt\nio/ktor/utils/io/core/BufferPrimitivesKt\n+ 6 Buffer.kt\nio/ktor/utils/io/core/BufferKt\n*L\n1#1,123:1\n36#2:124\n74#3:125\n69#3:149\n1#4:126\n762#5,7:127\n769#5,6:139\n777#5:147\n372#6,5:134\n377#6,2:145\n355#6:148\n372#6,7:150\n390#6,7:157\n*S KotlinDebug\n*F\n+ 1 BufferUtilsJvm.kt\nio/ktor/utils/io/core/BufferUtilsJvmKt\n*L\n12#1:124\n44#1:125\n87#1:149\n73#1:127,7\n73#1:139,6\n73#1:147\n73#1:134,5\n73#1:145,2\n86#1:148\n99#1:150,7\n115#1:157,7\n*E\n"})
public final class BufferUtilsJvmKt {
    public static final ChunkBuffer a(ByteBuffer byteBuffer, ObjectPool objectPool) {
        Intrinsics.checkNotNullParameter(byteBuffer, "buffer");
        Memory.Companion companion = Memory.b;
        ByteBuffer order = byteBuffer.slice().order(ByteOrder.BIG_ENDIAN);
        Intrinsics.checkNotNullExpressionValue(order, "buffer.slice().order(ByteOrder.BIG_ENDIAN)");
        return new ChunkBuffer(Memory.c(order), (ChunkBuffer) null, objectPool, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ChunkBuffer b(ByteBuffer byteBuffer, ObjectPool objectPool, int i, Object obj) {
        if ((i & 2) != 0) {
            objectPool = null;
        }
        return a(byteBuffer, objectPool);
    }

    /* JADX INFO: finally extract failed */
    public static final void c(Buffer buffer, ByteBuffer byteBuffer, int i) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(byteBuffer, "dst");
        ByteBuffer h = buffer.h();
        int i2 = buffer.i();
        if (buffer.k() - i2 >= i) {
            int limit = byteBuffer.limit();
            try {
                byteBuffer.limit(byteBuffer.position() + i);
                MemoryJvmKt.a(h, byteBuffer, i2);
                byteBuffer.limit(limit);
                Unit unit = Unit.INSTANCE;
                buffer.c(i);
            } catch (Throwable th) {
                byteBuffer.limit(limit);
                throw th;
            }
        } else {
            throw new EOFException("Not enough bytes to read a " + "buffer content" + " of size " + i + '.');
        }
    }

    public static final void d(ChunkBuffer chunkBuffer, ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        Intrinsics.checkNotNullParameter(byteBuffer, "child");
        chunkBuffer.u(byteBuffer.limit());
        chunkBuffer.b(byteBuffer.position());
    }
}
