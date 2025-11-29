package io.ktor.utils.io.streams;

import io.ktor.utils.io.pool.DefaultPool;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0004¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"io/ktor/utils/io/streams/ByteArraysKt$ByteArrayPool$1", "Lio/ktor/utils/io/pool/DefaultPool;", "", "s", "()[B", "instance", "", "u", "([B)V", "ktor-io"}, k = 1, mv = {1, 8, 0})
public final class ByteArraysKt$ByteArrayPool$1 extends DefaultPool<byte[]> {
    public ByteArraysKt$ByteArrayPool$1() {
        super(128);
    }

    /* renamed from: s */
    public final byte[] i() {
        return new byte[4096];
    }

    /* renamed from: u */
    public final void r(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "instance");
        if (bArr.length == 4096) {
            super.r(bArr);
            return;
        }
        throw new IllegalArgumentException(("Unable to recycle buffer of wrong size: " + bArr.length + " != 4096").toString());
    }
}
