package io.ktor.utils.io.core.internal;

import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.Input;
import io.ktor.utils.io.core.Output;
import io.ktor.utils.io.core.PacketJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001d\u0010\t\u001a\u0004\u0018\u00010\b*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\t\u0010\n\u001a\u001b\u0010\r\u001a\u00020\f*\u00020\u00062\u0006\u0010\u000b\u001a\u00020\bH\u0001¢\u0006\u0004\b\r\u0010\u000e\u001a\u001d\u0010\u000f\u001a\u0004\u0018\u00010\b*\u00020\u00062\u0006\u0010\u000b\u001a\u00020\bH\u0001¢\u0006\u0004\b\u000f\u0010\u0010\u001a%\u0010\u0013\u001a\u00020\b*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0000¢\u0006\u0004\b\u0013\u0010\u0014\"\u0014\u0010\u0017\u001a\u00020\u00158\u0000X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0016¨\u0006\u0018"}, d2 = {"Lio/ktor/utils/io/core/ByteReadPacket;", "Lio/ktor/utils/io/core/BytePacketBuilder;", "builder", "", "e", "(Lio/ktor/utils/io/core/ByteReadPacket;Lio/ktor/utils/io/core/BytePacketBuilder;)I", "Lio/ktor/utils/io/core/Input;", "minSize", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "b", "(Lio/ktor/utils/io/core/Input;I)Lio/ktor/utils/io/core/internal/ChunkBuffer;", "current", "", "a", "(Lio/ktor/utils/io/core/Input;Lio/ktor/utils/io/core/internal/ChunkBuffer;)V", "c", "(Lio/ktor/utils/io/core/Input;Lio/ktor/utils/io/core/internal/ChunkBuffer;)Lio/ktor/utils/io/core/internal/ChunkBuffer;", "Lio/ktor/utils/io/core/Output;", "capacity", "d", "(Lio/ktor/utils/io/core/Output;ILio/ktor/utils/io/core/internal/ChunkBuffer;)Lio/ktor/utils/io/core/internal/ChunkBuffer;", "", "[B", "EmptyByteArray", "ktor-io"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nUnsafe.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Unsafe.kt\nio/ktor/utils/io/core/internal/UnsafeKt\n+ 2 Buffer.kt\nio/ktor/utils/io/core/BufferKt\n+ 3 Buffer.kt\nio/ktor/utils/io/core/Buffer\n*L\n1#1,64:1\n355#2:65\n59#3:66\n*S KotlinDebug\n*F\n+ 1 Unsafe.kt\nio/ktor/utils/io/core/internal/UnsafeKt\n*L\n38#1:65\n39#1:66\n*E\n"})
public final class UnsafeKt {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f9096a = new byte[0];

    public static final void a(Input input, ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(chunkBuffer, "current");
        if (chunkBuffer != input) {
            if (chunkBuffer.k() <= chunkBuffer.i()) {
                input.v(chunkBuffer);
            } else if (chunkBuffer.f() - chunkBuffer.g() < 8) {
                input.S(chunkBuffer);
            } else {
                input.O0(chunkBuffer.i());
            }
        }
    }

    public static final ChunkBuffer b(Input input, int i) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        return input.E0(i);
    }

    public static final ChunkBuffer c(Input input, ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(chunkBuffer, "current");
        if (chunkBuffer != input) {
            return input.z(chunkBuffer);
        }
        if (input.g()) {
            return (ChunkBuffer) input;
        }
        return null;
    }

    public static final ChunkBuffer d(Output output, int i, ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        if (chunkBuffer != null) {
            output.b();
        }
        return output.c0(i);
    }

    public static final int e(ByteReadPacket byteReadPacket, BytePacketBuilder bytePacketBuilder) {
        Intrinsics.checkNotNullParameter(byteReadPacket, "<this>");
        Intrinsics.checkNotNullParameter(bytePacketBuilder, "builder");
        int G0 = bytePacketBuilder.G0();
        ChunkBuffer f0 = bytePacketBuilder.f0();
        if (f0 == null) {
            return 0;
        }
        if (G0 > PacketJVMKt.a() || f0.C() != null || !byteReadPacket.T0(f0)) {
            byteReadPacket.b(f0);
            return G0;
        }
        bytePacketBuilder.a();
        return G0;
    }
}
