package io.ktor.utils.io.core;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import java.io.EOFException;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0019\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0006\u0010\u0005\u001a$\u0010\t\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0003H\u0010¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lio/ktor/utils/io/core/ByteReadPacket;", "Ljava/nio/ByteBuffer;", "dst", "", "b", "(Lio/ktor/utils/io/core/ByteReadPacket;Ljava/nio/ByteBuffer;)I", "c", "bb", "copied", "a", "(Lio/ktor/utils/io/core/ByteReadPacket;Ljava/nio/ByteBuffer;I)I", "ktor-io"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nByteBuffers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ByteBuffers.kt\nio/ktor/utils/io/core/ByteBuffersKt\n+ 2 Buffer.kt\nio/ktor/utils/io/core/Buffer\n+ 3 Output.kt\nio/ktor/utils/io/core/Output\n+ 4 BufferUtilsJvm.kt\nio/ktor/utils/io/core/BufferUtilsJvmKt\n+ 5 Buffer.kt\nio/ktor/utils/io/core/BufferKt\n+ 6 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 7 PacketDirect.kt\nio/ktor/utils/io/core/PacketDirectKt\n*L\n1#1,117:1\n80#1,5:119\n85#1:127\n69#2:118\n371#3,3:124\n374#3,5:145\n371#3,3:150\n374#3:170\n376#3,3:172\n111#4,5:128\n116#4,3:138\n120#4:142\n111#4,5:153\n116#4,3:163\n120#4:167\n95#4,5:183\n100#4,3:193\n104#4:197\n95#4,5:219\n100#4,3:229\n104#4:233\n390#5,5:133\n395#5,2:143\n390#5,5:158\n395#5,2:168\n372#5,5:188\n377#5,2:198\n372#5,5:224\n377#5,2:234\n1#6:141\n1#6:166\n1#6:171\n1#6:196\n1#6:232\n1#6:247\n9#7,8:175\n18#7,11:200\n9#7,8:211\n18#7,11:236\n*S KotlinDebug\n*F\n+ 1 ByteBuffers.kt\nio/ktor/utils/io/core/ByteBuffersKt\n*L\n63#1:119,5\n63#1:127\n31#1:118\n63#1:124,3\n63#1:145,5\n84#1:150,3\n84#1:170\n84#1:172,3\n63#1:128,5\n63#1:138,3\n63#1:142\n85#1:153,5\n85#1:163,3\n85#1:167\n96#1:183,5\n96#1:193,3\n96#1:197\n109#1:219,5\n109#1:229,3\n109#1:233\n63#1:133,5\n63#1:143,2\n85#1:158,5\n85#1:168,2\n96#1:188,5\n96#1:198,2\n109#1:224,5\n109#1:234,2\n63#1:141\n85#1:166\n84#1:171\n96#1:196\n109#1:232\n95#1:175,8\n95#1:200,11\n108#1:211,8\n108#1:236,11\n*E\n"})
public final class ByteBuffersKt {
    public static final int a(ByteReadPacket byteReadPacket, ByteBuffer byteBuffer, int i) {
        ChunkBuffer D0;
        while (byteBuffer.hasRemaining() && (D0 = byteReadPacket.D0(1)) != null) {
            int remaining = byteBuffer.remaining();
            int k = D0.k() - D0.i();
            if (remaining >= k) {
                BufferUtilsJvmKt.c(D0, byteBuffer, k);
                byteReadPacket.N0(D0);
                i += k;
            } else {
                BufferUtilsJvmKt.c(D0, byteBuffer, remaining);
                byteReadPacket.O0(D0.i());
                return i + remaining;
            }
        }
        return i;
    }

    public static final int b(ByteReadPacket byteReadPacket, ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(byteReadPacket, "<this>");
        Intrinsics.checkNotNullParameter(byteBuffer, "dst");
        return a(byteReadPacket, byteBuffer, 0);
    }

    public static final int c(ByteReadPacket byteReadPacket, ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(byteReadPacket, "<this>");
        Intrinsics.checkNotNullParameter(byteBuffer, "dst");
        int a2 = a(byteReadPacket, byteBuffer, 0);
        if (!byteBuffer.hasRemaining()) {
            return a2;
        }
        throw new EOFException("Not enough data in packet to fill buffer: " + byteBuffer.remaining() + " more bytes required");
    }
}
