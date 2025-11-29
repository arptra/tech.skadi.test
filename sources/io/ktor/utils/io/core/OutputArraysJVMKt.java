package io.ktor.utils.io.core;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.UnsafeKt;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lio/ktor/utils/io/core/Output;", "Ljava/nio/ByteBuffer;", "bb", "", "a", "(Lio/ktor/utils/io/core/Output;Ljava/nio/ByteBuffer;)V", "ktor-io"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nOutputArraysJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OutputArraysJVM.kt\nio/ktor/utils/io/core/OutputArraysJVMKt\n+ 2 Output.kt\nio/ktor/utils/io/core/OutputKt\n+ 3 Buffer.kt\nio/ktor/utils/io/core/Buffer\n*L\n1#1,20:1\n488#2,4:21\n492#2,6:26\n74#3:25\n*S KotlinDebug\n*F\n+ 1 OutputArraysJVM.kt\nio/ktor/utils/io/core/OutputArraysJVMKt\n*L\n11#1:21,4\n11#1:26,6\n12#1:25\n*E\n"})
public final class OutputArraysJVMKt {
    public static final void a(Output output, ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(byteBuffer, "bb");
        int limit = byteBuffer.limit();
        ChunkBuffer d = UnsafeKt.d(output, 1, (ChunkBuffer) null);
        while (true) {
            try {
                byteBuffer.limit(byteBuffer.position() + Math.min(byteBuffer.remaining(), d.g() - d.k()));
                BufferPrimitivesJvmKt.a(d, byteBuffer);
                byteBuffer.limit(limit);
                if (byteBuffer.hasRemaining()) {
                    d = UnsafeKt.d(output, 1, d);
                } else {
                    return;
                }
            } finally {
                output.b();
            }
        }
    }
}
