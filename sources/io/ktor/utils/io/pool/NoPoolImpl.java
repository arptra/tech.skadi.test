package io.ktor.utils.io.pool;

import io.ktor.utils.io.pool.ObjectPool;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u0005¨\u0006\u000b"}, d2 = {"Lio/ktor/utils/io/pool/NoPoolImpl;", "", "T", "Lio/ktor/utils/io/pool/ObjectPool;", "<init>", "()V", "instance", "", "recycle", "(Ljava/lang/Object;)V", "dispose", "ktor-io"}, k = 1, mv = {1, 8, 0})
public abstract class NoPoolImpl<T> implements ObjectPool<T> {
    public void close() {
        ObjectPool.DefaultImpls.a(this);
    }

    public void dispose() {
    }

    public void recycle(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "instance");
    }
}
