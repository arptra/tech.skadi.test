package io.ktor.utils.io.pool;

import com.honey.account.u1.c;
import io.ktor.utils.io.pool.ObjectPool;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nDefaultPool.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DefaultPool.kt\nio/ktor/utils/io/pool/DefaultPool\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Atomic.kt\nio/ktor/utils/io/utils/AtomicKt\n*L\n1#1,114:1\n1#2:115\n7#3:116\n*S KotlinDebug\n*F\n+ 1 DefaultPool.kt\nio/ktor/utils/io/pool/DefaultPool\n*L\n111#1:116\n*E\n"})
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0006\b&\u0018\u0000 -*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001.B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00028\u0000H$¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00028\u00002\u0006\u0010\n\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\r2\u0006\u0010\n\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0010\u0010\u000fJ\r\u0010\u0011\u001a\u00028\u0000¢\u0006\u0004\b\u0011\u0010\tJ\u0015\u0010\u0012\u001a\u00020\r2\u0006\u0010\n\u001a\u00028\u0000¢\u0006\u0004\b\u0012\u0010\u000fJ\r\u0010\u0013\u001a\u00020\r¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\n\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0011\u0010\u0018\u001a\u0004\u0018\u00018\u0000H\u0002¢\u0006\u0004\b\u0018\u0010\tJ\u0017\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u0007J\u000f\u0010\u001b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u001cR\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010\u001eR\u0014\u0010%\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001eR\u001c\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000&8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006/"}, d2 = {"Lio/ktor/utils/io/pool/DefaultPool;", "", "T", "Lio/ktor/utils/io/pool/ObjectPool;", "", "capacity", "<init>", "(I)V", "i", "()Ljava/lang/Object;", "instance", "c", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "r", "(Ljava/lang/Object;)V", "d", "h0", "recycle", "dispose", "()V", "", "o", "(Ljava/lang/Object;)Z", "n", "index", "j", "g", "()I", "a", "I", "getCapacity", "", "top", "J", "b", "maxIndex", "shift", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "instances", "", "e", "[I", "next", "f", "Companion", "ktor-io"}, k = 1, mv = {1, 8, 0})
public abstract class DefaultPool<T> implements ObjectPool<T> {
    public static final Companion f = new Companion((DefaultConstructorMarker) null);
    public static final AtomicLongFieldUpdater g;

    /* renamed from: a  reason: collision with root package name */
    public final int f9117a;
    public final int b;
    public final int c;
    public final AtomicReferenceArray d;
    public final int[] e;
    /* access modifiers changed from: private */

    /* renamed from: top  reason: collision with root package name */
    public volatile long f9118top;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lio/ktor/utils/io/pool/DefaultPool$Companion;", "", "()V", "Top", "Ljava/util/concurrent/atomic/AtomicLongFieldUpdater;", "Lio/ktor/utils/io/pool/DefaultPool;", "ktor-io"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    static {
        AtomicLongFieldUpdater<U> newUpdater = AtomicLongFieldUpdater.newUpdater(DefaultPool.class, DefaultPool$Companion$Top$1.INSTANCE.getName());
        Intrinsics.checkNotNullExpressionValue(newUpdater, "newUpdater(Owner::class.java, p.name)");
        g = newUpdater;
    }

    public DefaultPool(int i) {
        this.f9117a = i;
        if (i <= 0) {
            throw new IllegalArgumentException(("capacity should be positive but it is " + i).toString());
        } else if (i <= 536870911) {
            int highestOneBit = Integer.highestOneBit((i * 4) - 1) * 2;
            this.b = highestOneBit;
            this.c = Integer.numberOfLeadingZeros(highestOneBit) + 1;
            this.d = new AtomicReferenceArray(highestOneBit + 1);
            this.e = new int[(highestOneBit + 1)];
        } else {
            throw new IllegalArgumentException(("capacity should be less or equal to 536870911 but it is " + i).toString());
        }
    }

    public Object c(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "instance");
        return obj;
    }

    public void close() {
        ObjectPool.DefaultImpls.a(this);
    }

    public void d(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "instance");
    }

    public final void dispose() {
        while (true) {
            Object n = n();
            if (n != null) {
                d(n);
            } else {
                return;
            }
        }
    }

    public final int g() {
        long j;
        long j2;
        int i;
        do {
            j = this.f9118top;
            if (j == 0) {
                return 0;
            }
            j2 = ((j >> 32) & 4294967295L) + 1;
            i = (int) (4294967295L & j);
            if (i == 0) {
                return 0;
            }
        } while (!g.compareAndSet(this, j, (j2 << 32) | ((long) this.e[i])));
        return i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = c(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object h0() {
        /*
            r1 = this;
            java.lang.Object r0 = r1.n()
            if (r0 == 0) goto L_0x000c
            java.lang.Object r0 = r1.c(r0)
            if (r0 != 0) goto L_0x0010
        L_0x000c:
            java.lang.Object r0 = r1.i()
        L_0x0010:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.pool.DefaultPool.h0():java.lang.Object");
    }

    public abstract Object i();

    public final void j(int i) {
        long j;
        if (i > 0) {
            do {
                j = this.f9118top;
                this.e[i] = (int) (4294967295L & j);
            } while (!g.compareAndSet(this, j, ((((j >> 32) & 4294967295L) + 1) << 32) | ((long) i)));
            return;
        }
        throw new IllegalArgumentException("index should be positive".toString());
    }

    public final Object n() {
        int g2 = g();
        if (g2 == 0) {
            return null;
        }
        return this.d.getAndSet(g2, (Object) null);
    }

    public final boolean o(Object obj) {
        int identityHashCode = ((System.identityHashCode(obj) * -1640531527) >>> this.c) + 1;
        for (int i = 0; i < 8; i++) {
            if (c.a(this.d, identityHashCode, (Object) null, obj)) {
                j(identityHashCode);
                return true;
            }
            identityHashCode--;
            if (identityHashCode == 0) {
                identityHashCode = this.b;
            }
        }
        return false;
    }

    public void r(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "instance");
    }

    public final void recycle(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "instance");
        r(obj);
        if (!o(obj)) {
            d(obj);
        }
    }
}
