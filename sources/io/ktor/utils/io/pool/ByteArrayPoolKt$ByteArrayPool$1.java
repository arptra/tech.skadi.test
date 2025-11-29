package io.ktor.utils.io.pool;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"io/ktor/utils/io/pool/ByteArrayPoolKt$ByteArrayPool$1", "Lio/ktor/utils/io/pool/DefaultPool;", "", "s", "()[B", "ktor-io"}, k = 1, mv = {1, 8, 0})
public final class ByteArrayPoolKt$ByteArrayPool$1 extends DefaultPool<byte[]> {
    public ByteArrayPoolKt$ByteArrayPool$1() {
        super(128);
    }

    /* renamed from: s */
    public byte[] i() {
        return new byte[4096];
    }
}
