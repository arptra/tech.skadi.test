package io.ktor.utils.io.pool;

import io.ktor.utils.io.pool.ObjectPool;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00028\u0000H$¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00028\u0000H$¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00028\u0000¢\u0006\u0004\b\f\u0010\u0007J\u0015\u0010\r\u001a\u00020\t2\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0004\b\r\u0010\u000bJ\r\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u0005¨\u0006\u000f"}, d2 = {"Lio/ktor/utils/io/pool/SingleInstancePool;", "", "T", "Lio/ktor/utils/io/pool/ObjectPool;", "<init>", "()V", "b", "()Ljava/lang/Object;", "instance", "", "a", "(Ljava/lang/Object;)V", "h0", "recycle", "dispose", "ktor-io"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nPool.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Pool.kt\nio/ktor/utils/io/pool/SingleInstancePool\n+ 2 AtomicFU.common.kt\nkotlinx/atomicfu/AtomicFU_commonKt\n*L\n1#1,166:1\n360#2,4:167\n*S KotlinDebug\n*F\n+ 1 Pool.kt\nio/ktor/utils/io/pool/SingleInstancePool\n*L\n72#1:167,4\n*E\n"})
public abstract class SingleInstancePool<T> implements ObjectPool<T> {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f9119a;
    public static final /* synthetic */ AtomicIntegerFieldUpdater b;
    @NotNull
    private volatile /* synthetic */ int borrowed = 0;
    @NotNull
    private volatile /* synthetic */ int disposed = 0;
    @NotNull
    private volatile /* synthetic */ Object instance = null;

    static {
        Class<SingleInstancePool> cls = SingleInstancePool.class;
        f9119a = AtomicIntegerFieldUpdater.newUpdater(cls, "borrowed");
        b = AtomicIntegerFieldUpdater.newUpdater(cls, "disposed");
    }

    public abstract void a(Object obj);

    public abstract Object b();

    public void close() {
        ObjectPool.DefaultImpls.a(this);
    }

    public final void dispose() {
        Object obj;
        if (b.compareAndSet(this, 0, 1) && (obj = this.instance) != null) {
            this.instance = null;
            a(obj);
        }
    }

    public final Object h0() {
        int i;
        do {
            i = this.borrowed;
            if (i != 0) {
                throw new IllegalStateException("Instance is already consumed");
            }
        } while (!f9119a.compareAndSet(this, i, 1));
        Object b2 = b();
        this.instance = b2;
        return b2;
    }

    public final void recycle(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "instance");
        if (this.instance == obj) {
            this.instance = null;
            if (b.compareAndSet(this, 0, 1)) {
                a(obj);
                return;
            }
            throw new IllegalStateException("An instance is already disposed");
        } else if (this.instance != null || this.borrowed == 0) {
            throw new IllegalStateException("Unable to recycle irrelevant instance");
        } else {
            throw new IllegalStateException("Already recycled or an irrelevant instance tried to be recycled");
        }
    }
}
