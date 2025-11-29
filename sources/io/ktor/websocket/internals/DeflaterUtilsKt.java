package io.ktor.websocket.internals;

import io.ktor.util.cio.ByteBufferPoolKt;
import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.OutputArraysJVMKt;
import io.ktor.utils.io.core.StringsKt;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u001a\u001b\u0010\u0003\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001b\u0010\u0006\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a+\u0010\u000f\u001a\u00020\u000e*\u00020\b2\u0006\u0010\t\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010\"\u0014\u0010\u0012\u001a\u00020\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0011\"\u0014\u0010\u0013\u001a\u00020\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0011¨\u0006\u0014"}, d2 = {"Ljava/util/zip/Deflater;", "", "data", "a", "(Ljava/util/zip/Deflater;[B)[B", "Ljava/util/zip/Inflater;", "c", "(Ljava/util/zip/Inflater;[B)[B", "Lio/ktor/utils/io/core/BytePacketBuilder;", "deflater", "Ljava/nio/ByteBuffer;", "buffer", "", "flush", "", "b", "(Lio/ktor/utils/io/core/BytePacketBuilder;Ljava/util/zip/Deflater;Ljava/nio/ByteBuffer;Z)I", "[B", "PADDED_EMPTY_CHUNK", "EMPTY_CHUNK", "ktor-websockets"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nDeflaterUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeflaterUtils.kt\nio/ktor/websocket/internals/DeflaterUtilsKt\n+ 2 Builder.kt\nio/ktor/utils/io/core/BuilderKt\n+ 3 Pool.kt\nio/ktor/utils/io/pool/PoolKt\n*L\n1#1,85:1\n12#2,7:86\n19#2,4:98\n12#2,11:102\n12#2,7:113\n19#2,4:125\n159#3,5:93\n159#3,5:120\n*S KotlinDebug\n*F\n+ 1 DeflaterUtils.kt\nio/ktor/websocket/internals/DeflaterUtilsKt\n*L\n19#1:86,7\n19#1:98,4\n35#1:102,11\n45#1:113,7\n45#1:125,4\n20#1:93,5\n46#1:120,5\n*E\n"})
public final class DeflaterUtilsKt {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f9147a = {0, 0, 0, -1, -1};
    public static final byte[] b = {0, 0, -1, -1};

    public static final byte[] a(Deflater deflater, byte[] bArr) {
        ObjectPool a2;
        Object h0;
        Intrinsics.checkNotNullParameter(deflater, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "data");
        deflater.setInput(bArr);
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder((ObjectPool) null, 1, (DefaultConstructorMarker) null);
        try {
            a2 = ByteBufferPoolKt.a();
            h0 = a2.h0();
            ByteBuffer byteBuffer = (ByteBuffer) h0;
            while (!deflater.needsInput()) {
                b(bytePacketBuilder, deflater, byteBuffer, false);
            }
            do {
            } while (b(bytePacketBuilder, deflater, byteBuffer, true) != 0);
            Unit unit = Unit.INSTANCE;
            a2.recycle(h0);
            ByteReadPacket F0 = bytePacketBuilder.F0();
            if (BytePacketUtilsKt.a(F0, f9147a)) {
                byte[] b2 = StringsKt.b(F0, ((int) F0.r0()) - b.length);
                F0.release();
                return b2;
            }
            BytePacketBuilder bytePacketBuilder2 = new BytePacketBuilder((ObjectPool) null, 1, (DefaultConstructorMarker) null);
            try {
                bytePacketBuilder2.r0(F0);
                bytePacketBuilder2.i0((byte) 0);
                return StringsKt.d(bytePacketBuilder2.F0(), 0, 1, (Object) null);
            } catch (Throwable th) {
                bytePacketBuilder2.release();
                throw th;
            }
        } catch (Throwable th2) {
            bytePacketBuilder.release();
            throw th2;
        }
    }

    public static final int b(BytePacketBuilder bytePacketBuilder, Deflater deflater, ByteBuffer byteBuffer, boolean z) {
        byteBuffer.clear();
        int deflate = z ? deflater.deflate(byteBuffer.array(), byteBuffer.position(), byteBuffer.limit(), 2) : deflater.deflate(byteBuffer.array(), byteBuffer.position(), byteBuffer.limit());
        if (deflate == 0) {
            return 0;
        }
        byteBuffer.position(byteBuffer.position() + deflate);
        byteBuffer.flip();
        OutputArraysJVMKt.a(bytePacketBuilder, byteBuffer);
        return deflate;
    }

    public static final byte[] c(Inflater inflater, byte[] bArr) {
        ObjectPool a2;
        Object h0;
        Intrinsics.checkNotNullParameter(inflater, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "data");
        byte[] plus = ArraysKt.plus(bArr, b);
        inflater.setInput(plus);
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder((ObjectPool) null, 1, (DefaultConstructorMarker) null);
        try {
            a2 = ByteBufferPoolKt.a();
            h0 = a2.h0();
            ByteBuffer byteBuffer = (ByteBuffer) h0;
            long length = ((long) plus.length) + inflater.getBytesRead();
            while (inflater.getBytesRead() < length) {
                byteBuffer.clear();
                byteBuffer.position(byteBuffer.position() + inflater.inflate(byteBuffer.array(), byteBuffer.position(), byteBuffer.limit()));
                byteBuffer.flip();
                OutputArraysJVMKt.a(bytePacketBuilder, byteBuffer);
            }
            Unit unit = Unit.INSTANCE;
            a2.recycle(h0);
            return StringsKt.d(bytePacketBuilder.F0(), 0, 1, (Object) null);
        } catch (Throwable th) {
            bytePacketBuilder.release();
            throw th;
        }
    }
}
