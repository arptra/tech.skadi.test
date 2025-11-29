package io.ktor.util;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.internal.jvm.ErrorsKt;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Ljava/nio/channels/ReadableByteChannel;", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "buffer", "", "a", "(Ljava/nio/channels/ReadableByteChannel;Lio/ktor/utils/io/core/internal/ChunkBuffer;)I", "ktor-utils"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nBufferViewJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BufferViewJvm.kt\nio/ktor/util/BufferViewJvmKt\n+ 2 Buffer.kt\nio/ktor/utils/io/core/Buffer\n+ 3 BufferUtilsJvm.kt\nio/ktor/utils/io/core/BufferUtilsJvmKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,43:1\n74#2:44\n74#2:46\n44#3:45\n45#3:47\n46#3,14:49\n21#3,14:63\n1#4:48\n*S KotlinDebug\n*F\n+ 1 BufferViewJvm.kt\nio/ktor/util/BufferViewJvmKt\n*L\n18#1:44\n21#1:46\n21#1:45\n21#1:47\n21#1:49,14\n37#1:63,14\n21#1:48\n*E\n"})
public final class BufferViewJvmKt {
    public static final int a(ReadableByteChannel readableByteChannel, ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(readableByteChannel, "<this>");
        Intrinsics.checkNotNullParameter(chunkBuffer, "buffer");
        if (chunkBuffer.g() - chunkBuffer.k() == 0) {
            return 0;
        }
        int g = chunkBuffer.g() - chunkBuffer.k();
        if (1 <= g) {
            ByteBuffer duplicate = chunkBuffer.h().duplicate();
            Intrinsics.checkNotNull(duplicate);
            int k = chunkBuffer.k();
            duplicate.limit(chunkBuffer.g());
            duplicate.position(k);
            int read = readableByteChannel.read(duplicate);
            int position = duplicate.position() - k;
            if (position < 0 || position > g) {
                ErrorsKt.a(position, 1);
                throw new KotlinNothingValueException();
            }
            chunkBuffer.a(position);
            return read;
        }
        throw new IllegalArgumentException(("size " + 1 + " is greater than buffer's remaining capacity " + g).toString());
    }
}
