package io.ktor.utils.io.core;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0004¢\u0006\u0004\b\b\u0010\tJ-\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0016\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J)\u0010\u001a\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!R\u0011\u0010$\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0011\u0010(\u001a\u00020%8F¢\u0006\u0006\u001a\u0004\b&\u0010'\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006)"}, d2 = {"Lio/ktor/utils/io/core/BytePacketBuilder;", "Lio/ktor/utils/io/core/Output;", "Lio/ktor/utils/io/pool/ObjectPool;", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "pool", "<init>", "(Lio/ktor/utils/io/pool/ObjectPool;)V", "", "u", "()V", "Lio/ktor/utils/io/bits/Memory;", "source", "", "offset", "length", "v", "(Ljava/nio/ByteBuffer;II)V", "", "value", "C0", "(C)Lio/ktor/utils/io/core/BytePacketBuilder;", "", "D0", "(Ljava/lang/CharSequence;)Lio/ktor/utils/io/core/BytePacketBuilder;", "startIndex", "endIndex", "E0", "(Ljava/lang/CharSequence;II)Lio/ktor/utils/io/core/BytePacketBuilder;", "Lio/ktor/utils/io/core/ByteReadPacket;", "F0", "()Lio/ktor/utils/io/core/ByteReadPacket;", "", "toString", "()Ljava/lang/String;", "G0", "()I", "size", "", "H0", "()Z", "isEmpty", "ktor-io"}, k = 1, mv = {1, 8, 0})
public final class BytePacketBuilder extends Output {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BytePacketBuilder(ObjectPool objectPool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? ChunkBuffer.j.c() : objectPool);
    }

    /* renamed from: C0 */
    public BytePacketBuilder c(char c) {
        Output c2 = super.append(c);
        Intrinsics.checkNotNull(c2, "null cannot be cast to non-null type io.ktor.utils.io.core.BytePacketBuilder");
        return (BytePacketBuilder) c2;
    }

    /* renamed from: D0 */
    public BytePacketBuilder d(CharSequence charSequence) {
        Output d = super.append(charSequence);
        Intrinsics.checkNotNull(d, "null cannot be cast to non-null type io.ktor.utils.io.core.BytePacketBuilder");
        return (BytePacketBuilder) d;
    }

    /* renamed from: E0 */
    public BytePacketBuilder g(CharSequence charSequence, int i, int i2) {
        Output g = super.append(charSequence, i, i2);
        Intrinsics.checkNotNull(g, "null cannot be cast to non-null type io.ktor.utils.io.core.BytePacketBuilder");
        return (BytePacketBuilder) g;
    }

    public final ByteReadPacket F0() {
        int G0 = G0();
        ChunkBuffer f0 = f0();
        return f0 == null ? ByteReadPacket.i.a() : new ByteReadPacket(f0, (long) G0, J());
    }

    public final int G0() {
        return U();
    }

    public final boolean H0() {
        return U() == 0;
    }

    public String toString() {
        return "BytePacketBuilder[0x" + hashCode() + ']';
    }

    public final void u() {
    }

    public final void v(ByteBuffer byteBuffer, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteBuffer, "source");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BytePacketBuilder(ObjectPool objectPool) {
        super(objectPool);
        Intrinsics.checkNotNullParameter(objectPool, "pool");
    }
}
