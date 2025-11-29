package io.ktor.utils.io.internal;

import io.ktor.utils.io.internal.ReadWriteBufferState;
import io.ktor.utils.io.pool.DefaultPool;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"io/ktor/utils/io/internal/ObjectPoolKt$BufferObjectPool$1", "Lio/ktor/utils/io/pool/DefaultPool;", "Lio/ktor/utils/io/internal/ReadWriteBufferState$Initial;", "u", "()Lio/ktor/utils/io/internal/ReadWriteBufferState$Initial;", "instance", "", "s", "(Lio/ktor/utils/io/internal/ReadWriteBufferState$Initial;)V", "ktor-io"}, k = 1, mv = {1, 8, 0})
public final class ObjectPoolKt$BufferObjectPool$1 extends DefaultPool<ReadWriteBufferState.Initial> {
    public ObjectPoolKt$BufferObjectPool$1(int i) {
        super(i);
    }

    /* renamed from: s */
    public void d(ReadWriteBufferState.Initial initial) {
        Intrinsics.checkNotNullParameter(initial, "instance");
        ObjectPoolKt.d().recycle(initial.f9103a);
    }

    /* renamed from: u */
    public ReadWriteBufferState.Initial i() {
        return new ReadWriteBufferState.Initial((ByteBuffer) ObjectPoolKt.d().h0(), 0, 2, (DefaultConstructorMarker) null);
    }
}
