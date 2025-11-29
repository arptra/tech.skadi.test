package kotlinx.coroutines.internal;

import com.honey.account.i.a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.internal.ConcurrentLinkedListNode;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u00020\u0002B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\fR\u0013\u0010\u0012\u001a\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0014\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000eR\u0013\u0010\u0003\u001a\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0017\u001a\u00020\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u000eR\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00028BX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u0004\u0018\u00018\u00008BX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0011R\u0014\u0010\u001e\u001a\u00028\u00008BX\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0011R\u0013\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u001f8\u0002X\u0004R\u0013\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u001f8\u0002X\u0004¨\u0006\""}, d2 = {"Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "N", "", "prev", "<init>", "(Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;)V", "value", "", "l", "(Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;)Z", "", "b", "()V", "j", "()Z", "k", "e", "()Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "next", "i", "isTail", "g", "h", "isRemoved", "f", "()Ljava/lang/Object;", "nextOrClosed", "c", "aliveSegmentLeft", "d", "aliveSegmentRight", "Lkotlinx/atomicfu/AtomicRef;", "_next", "_prev", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nConcurrentLinkedList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListNode\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,269:1\n107#1,7:270\n1#2:277\n*S KotlinDebug\n*F\n+ 1 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListNode\n*L\n115#1:270,7\n*E\n"})
public abstract class ConcurrentLinkedListNode<N extends ConcurrentLinkedListNode<N>> {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f3910a;
    public static final AtomicReferenceFieldUpdater b;
    @Volatile
    @Nullable
    private volatile Object _next;
    @Volatile
    @Nullable
    private volatile Object _prev;

    static {
        Class<ConcurrentLinkedListNode> cls = ConcurrentLinkedListNode.class;
        Class<Object> cls2 = Object.class;
        f3910a = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_next");
        b = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_prev");
    }

    public ConcurrentLinkedListNode(ConcurrentLinkedListNode concurrentLinkedListNode) {
        this._prev = concurrentLinkedListNode;
    }

    public final void b() {
        b.lazySet(this, (Object) null);
    }

    public final ConcurrentLinkedListNode c() {
        ConcurrentLinkedListNode g = g();
        while (g != null && g.h()) {
            g = (ConcurrentLinkedListNode) b.get(g);
        }
        return g;
    }

    public final ConcurrentLinkedListNode d() {
        ConcurrentLinkedListNode e;
        ConcurrentLinkedListNode e2 = e();
        Intrinsics.checkNotNull(e2);
        while (e2.h() && (e = e2.e()) != null) {
            e2 = e;
        }
        return e2;
    }

    public final ConcurrentLinkedListNode e() {
        Object a2 = f();
        if (a2 == ConcurrentLinkedListKt.f3909a) {
            return null;
        }
        return (ConcurrentLinkedListNode) a2;
    }

    public final Object f() {
        return f3910a.get(this);
    }

    public final ConcurrentLinkedListNode g() {
        return (ConcurrentLinkedListNode) b.get(this);
    }

    public abstract boolean h();

    public final boolean i() {
        return e() == null;
    }

    public final boolean j() {
        return a.a(f3910a, this, (Object) null, ConcurrentLinkedListKt.f3909a);
    }

    public final void k() {
        Object obj;
        if (!i()) {
            while (true) {
                ConcurrentLinkedListNode c = c();
                ConcurrentLinkedListNode d = d();
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b;
                do {
                    obj = atomicReferenceFieldUpdater.get(d);
                } while (!a.a(atomicReferenceFieldUpdater, d, obj, ((ConcurrentLinkedListNode) obj) == null ? null : c));
                if (c != null) {
                    f3910a.set(c, d);
                }
                if ((!d.h() || d.i()) && (c == null || !c.h())) {
                    return;
                }
            }
        }
    }

    public final boolean l(ConcurrentLinkedListNode concurrentLinkedListNode) {
        return a.a(f3910a, this, (Object) null, concurrentLinkedListNode);
    }
}
