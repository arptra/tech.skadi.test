package kotlinx.coroutines.internal;

import java.lang.Comparable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;

@SourceDebugExtension({"SMAP\nThreadSafeHeap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ThreadSafeHeap.kt\nkotlinx/coroutines/internal/ThreadSafeHeap\n+ 2 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 3 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,168:1\n28#2,4:169\n28#2,4:174\n28#2,4:179\n28#2,4:184\n28#2,4:189\n28#2,4:194\n28#2,4:199\n28#2,4:204\n20#3:173\n20#3:178\n20#3:183\n20#3:188\n20#3:193\n20#3:198\n20#3:203\n20#3:208\n1#4:209\n*S KotlinDebug\n*F\n+ 1 ThreadSafeHeap.kt\nkotlinx/coroutines/internal/ThreadSafeHeap\n*L\n35#1:169,4\n42#1:174,4\n50#1:179,4\n52#1:184,4\n60#1:189,4\n69#1:194,4\n72#1:199,4\n81#1:204,4\n35#1:173\n42#1:178\n50#1:183\n52#1:188\n60#1:193\n69#1:198\n72#1:203\n81#1:208\n*E\n"})
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u0000*\u0012\b\u0000\u0010\u0003*\u00020\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0004j\u0002`\u0005B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\n\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00028\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u000f\u001a\u0004\u0018\u00018\u0000H\u0001¢\u0006\u0004\b\u000f\u0010\tJ\u0017\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00028\u0000H\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0017\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u0010H\u0010¢\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u0019\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u0010H\u0010¢\u0006\u0004\b\u0019\u0010\u0018J\u0017\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u001aH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001e\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001e\u0010\u001fR \u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010 R$\u0010$\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00108F@BX\u000e¢\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b\u001d\u0010\u0018R\u0011\u0010'\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b%\u0010&R\u000b\u0010)\u001a\u00020(8\u0002X\u0004¨\u0006*"}, d2 = {"Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "", "T", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "<init>", "()V", "e", "()Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "i", "node", "", "g", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)Z", "b", "", "index", "h", "(I)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "", "a", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)V", "l", "(I)V", "k", "", "f", "()[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "j", "m", "(II)V", "[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "value", "c", "()I", "size", "d", "()Z", "isEmpty", "Lkotlinx/atomicfu/AtomicInt;", "_size", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
@InternalCoroutinesApi
public class ThreadSafeHeap<T extends ThreadSafeHeapNode & Comparable<? super T>> {
    public static final AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(ThreadSafeHeap.class, "_size");
    @Volatile
    private volatile int _size;

    /* renamed from: a  reason: collision with root package name */
    public ThreadSafeHeapNode[] f3936a;

    public final void a(ThreadSafeHeapNode threadSafeHeapNode) {
        threadSafeHeapNode.a(this);
        ThreadSafeHeapNode[] f = f();
        int c = c();
        j(c + 1);
        f[c] = threadSafeHeapNode;
        threadSafeHeapNode.f(c);
        l(c);
    }

    public final ThreadSafeHeapNode b() {
        ThreadSafeHeapNode[] threadSafeHeapNodeArr = this.f3936a;
        if (threadSafeHeapNodeArr != null) {
            return threadSafeHeapNodeArr[0];
        }
        return null;
    }

    public final int c() {
        return b.get(this);
    }

    public final boolean d() {
        return c() == 0;
    }

    public final ThreadSafeHeapNode e() {
        ThreadSafeHeapNode b2;
        synchronized (this) {
            b2 = b();
        }
        return b2;
    }

    public final ThreadSafeHeapNode[] f() {
        ThreadSafeHeapNode[] threadSafeHeapNodeArr = this.f3936a;
        if (threadSafeHeapNodeArr == null) {
            ThreadSafeHeapNode[] threadSafeHeapNodeArr2 = new ThreadSafeHeapNode[4];
            this.f3936a = threadSafeHeapNodeArr2;
            return threadSafeHeapNodeArr2;
        } else if (c() < threadSafeHeapNodeArr.length) {
            return threadSafeHeapNodeArr;
        } else {
            Object[] copyOf = Arrays.copyOf(threadSafeHeapNodeArr, c() * 2);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            ThreadSafeHeapNode[] threadSafeHeapNodeArr3 = (ThreadSafeHeapNode[]) copyOf;
            this.f3936a = threadSafeHeapNodeArr3;
            return threadSafeHeapNodeArr3;
        }
    }

    public final boolean g(ThreadSafeHeapNode threadSafeHeapNode) {
        boolean z;
        synchronized (this) {
            if (threadSafeHeapNode.d() == null) {
                z = false;
            } else {
                h(threadSafeHeapNode.getIndex());
                z = true;
            }
        }
        return z;
    }

    public final ThreadSafeHeapNode h(int i) {
        ThreadSafeHeapNode[] threadSafeHeapNodeArr = this.f3936a;
        Intrinsics.checkNotNull(threadSafeHeapNodeArr);
        j(c() - 1);
        if (i < c()) {
            m(i, c());
            int i2 = (i - 1) / 2;
            if (i > 0) {
                ThreadSafeHeapNode threadSafeHeapNode = threadSafeHeapNodeArr[i];
                Intrinsics.checkNotNull(threadSafeHeapNode);
                ThreadSafeHeapNode threadSafeHeapNode2 = threadSafeHeapNodeArr[i2];
                Intrinsics.checkNotNull(threadSafeHeapNode2);
                if (((Comparable) threadSafeHeapNode).compareTo(threadSafeHeapNode2) < 0) {
                    m(i, i2);
                    l(i2);
                }
            }
            k(i);
        }
        ThreadSafeHeapNode threadSafeHeapNode3 = threadSafeHeapNodeArr[c()];
        Intrinsics.checkNotNull(threadSafeHeapNode3);
        threadSafeHeapNode3.a((ThreadSafeHeap) null);
        threadSafeHeapNode3.f(-1);
        threadSafeHeapNodeArr[c()] = null;
        return threadSafeHeapNode3;
    }

    public final ThreadSafeHeapNode i() {
        ThreadSafeHeapNode h;
        synchronized (this) {
            h = c() > 0 ? h(0) : null;
        }
        return h;
    }

    public final void j(int i) {
        b.set(this, i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0028, code lost:
        if (((java.lang.Comparable) r3).compareTo(r4) < 0) goto L_0x002c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void k(int r6) {
        /*
            r5 = this;
        L_0x0000:
            int r0 = r6 * 2
            int r1 = r0 + 1
            int r2 = r5.c()
            if (r1 < r2) goto L_0x000b
            return
        L_0x000b:
            kotlinx.coroutines.internal.ThreadSafeHeapNode[] r2 = r5.f3936a
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            int r0 = r0 + 2
            int r3 = r5.c()
            if (r0 >= r3) goto L_0x002b
            r3 = r2[r0]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            java.lang.Comparable r3 = (java.lang.Comparable) r3
            r4 = r2[r1]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            int r3 = r3.compareTo(r4)
            if (r3 >= 0) goto L_0x002b
            goto L_0x002c
        L_0x002b:
            r0 = r1
        L_0x002c:
            r1 = r2[r6]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            java.lang.Comparable r1 = (java.lang.Comparable) r1
            r2 = r2[r0]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            int r1 = r1.compareTo(r2)
            if (r1 > 0) goto L_0x003f
            return
        L_0x003f:
            r5.m(r6, r0)
            r6 = r0
            goto L_0x0000
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.ThreadSafeHeap.k(int):void");
    }

    public final void l(int i) {
        while (i > 0) {
            ThreadSafeHeapNode[] threadSafeHeapNodeArr = this.f3936a;
            Intrinsics.checkNotNull(threadSafeHeapNodeArr);
            int i2 = (i - 1) / 2;
            ThreadSafeHeapNode threadSafeHeapNode = threadSafeHeapNodeArr[i2];
            Intrinsics.checkNotNull(threadSafeHeapNode);
            ThreadSafeHeapNode threadSafeHeapNode2 = threadSafeHeapNodeArr[i];
            Intrinsics.checkNotNull(threadSafeHeapNode2);
            if (((Comparable) threadSafeHeapNode).compareTo(threadSafeHeapNode2) > 0) {
                m(i, i2);
                i = i2;
            } else {
                return;
            }
        }
    }

    public final void m(int i, int i2) {
        ThreadSafeHeapNode[] threadSafeHeapNodeArr = this.f3936a;
        Intrinsics.checkNotNull(threadSafeHeapNodeArr);
        ThreadSafeHeapNode threadSafeHeapNode = threadSafeHeapNodeArr[i2];
        Intrinsics.checkNotNull(threadSafeHeapNode);
        ThreadSafeHeapNode threadSafeHeapNode2 = threadSafeHeapNodeArr[i];
        Intrinsics.checkNotNull(threadSafeHeapNode2);
        threadSafeHeapNodeArr[i] = threadSafeHeapNode;
        threadSafeHeapNodeArr[i2] = threadSafeHeapNode2;
        threadSafeHeapNode.f(i);
        threadSafeHeapNode2.f(i2);
    }
}
