package io.ktor.utils.io.pool;

import java.io.Closeable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00060\u0003j\u0002`\u0004J\u000f\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00028\u0000H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lio/ktor/utils/io/pool/ObjectPool;", "", "T", "Ljava/io/Closeable;", "Lio/ktor/utils/io/core/Closeable;", "h0", "()Ljava/lang/Object;", "instance", "", "recycle", "(Ljava/lang/Object;)V", "dispose", "()V", "ktor-io"}, k = 1, mv = {1, 8, 0})
public interface ObjectPool<T> extends Closeable {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void a(ObjectPool objectPool) {
            objectPool.dispose();
        }
    }

    void dispose();

    Object h0();

    void recycle(Object obj);
}
