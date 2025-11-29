package io.ktor.utils.io.streams;

import io.ktor.utils.io.pool.DefaultPool;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\" \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00008\u0000X\u0004¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0006"}, d2 = {"Lio/ktor/utils/io/pool/DefaultPool;", "", "a", "Lio/ktor/utils/io/pool/DefaultPool;", "()Lio/ktor/utils/io/pool/DefaultPool;", "ByteArrayPool", "ktor-io"}, k = 2, mv = {1, 8, 0})
public final class ByteArraysKt {

    /* renamed from: a  reason: collision with root package name */
    public static final DefaultPool f9120a = new ByteArraysKt$ByteArrayPool$1();

    public static final DefaultPool a() {
        return f9120a;
    }
}
