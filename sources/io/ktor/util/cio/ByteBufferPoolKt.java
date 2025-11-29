package io.ktor.util.cio;

import io.ktor.utils.io.pool.ByteBufferPool;
import io.ktor.utils.io.pool.ObjectPool;
import kotlin.Metadata;
import no.nordicsemi.android.dfu.DfuBaseService;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00008\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0006"}, d2 = {"Lio/ktor/utils/io/pool/ObjectPool;", "Ljava/nio/ByteBuffer;", "a", "Lio/ktor/utils/io/pool/ObjectPool;", "()Lio/ktor/utils/io/pool/ObjectPool;", "KtorDefaultPool", "ktor-utils"}, k = 2, mv = {1, 8, 0})
public final class ByteBufferPoolKt {

    /* renamed from: a  reason: collision with root package name */
    public static final ObjectPool f9041a = new ByteBufferPool(2048, DfuBaseService.ERROR_FILE_ERROR);

    public static final ObjectPool a() {
        return f9041a;
    }
}
