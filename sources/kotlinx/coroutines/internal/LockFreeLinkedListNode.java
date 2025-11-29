package kotlinx.coroutines.internal;

import com.honey.account.i.a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nLockFreeLinkedList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListNode\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,367:1\n73#1,3:369\n1#2:368\n*S KotlinDebug\n*F\n+ 1 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListNode\n*L\n134#1:369,3\n*E\n"})
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001:\u00012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\n\u0010\u0005\u001a\u00060\u0000j\u0002`\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u00020\t2\n\u0010\u0005\u001a\u00060\u0000j\u0002`\u0004¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\r\u001a\u00020\u00062\n\u0010\u0005\u001a\u00060\u0000j\u0002`\u00042\n\u0010\f\u001a\u00060\u0000j\u0002`\u0004H\u0001¢\u0006\u0004\b\r\u0010\u000eJ/\u0010\u0012\u001a\u00020\u00112\n\u0010\u0005\u001a\u00060\u0000j\u0002`\u00042\n\u0010\f\u001a\u00060\u0000j\u0002`\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0004H\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ \u0010\u001f\u001a\u00060\u0000j\u0002`\u00042\n\u0010\u001e\u001a\u00060\u0000j\u0002`\u0004H\u0010¢\u0006\u0004\b\u001f\u0010 J\u001b\u0010!\u001a\u00020\t2\n\u0010\f\u001a\u00060\u0000j\u0002`\u0004H\u0002¢\u0006\u0004\b!\u0010\u000bJ\"\u0010$\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00042\b\u0010#\u001a\u0004\u0018\u00010\"H\u0010¢\u0006\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u0015R\u0011\u0010\f\u001a\u00020\u00018F¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0015\u0010+\u001a\u00060\u0000j\u0002`\u00048F¢\u0006\u0006\u001a\u0004\b*\u0010\u0017R\u0015\u0010-\u001a\u00060\u0000j\u0002`\u00048F¢\u0006\u0006\u001a\u0004\b,\u0010\u0017R\u0011\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00010.8\u0002X\u0004R\u0011\u00100\u001a\b\u0012\u0004\u0012\u00020\u00000.8\u0002X\u0004R\u0013\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0.8\u0002X\u0004¨\u00063"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "", "<init>", "()V", "Lkotlinx/coroutines/internal/Node;", "node", "", "g", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Z", "", "e", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "next", "f", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Z", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "condAdd", "", "r", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;)I", "o", "()Z", "p", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/internal/Removed;", "q", "()Lkotlinx/coroutines/internal/Removed;", "current", "i", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "j", "Lkotlinx/coroutines/internal/OpDescriptor;", "op", "h", "(Lkotlinx/coroutines/internal/OpDescriptor;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "n", "isRemoved", "k", "()Ljava/lang/Object;", "l", "nextNode", "m", "prevNode", "Lkotlinx/atomicfu/AtomicRef;", "_next", "_prev", "_removedRef", "CondAddOp", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
@InternalCoroutinesApi
public class LockFreeLinkedListNode {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f3920a;
    public static final AtomicReferenceFieldUpdater b;
    public static final AtomicReferenceFieldUpdater c;
    @Volatile
    @Nullable
    private volatile Object _next = this;
    @Volatile
    @Nullable
    private volatile Object _prev = this;
    @Volatile
    @Nullable
    private volatile Object _removedRef;

    @PublishedApi
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b!\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001B\u0013\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\u000b\u001a\u00020\n2\n\u0010\u0007\u001a\u00060\u0002j\u0002`\u00032\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0006X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001e\u0010\u0010\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u000e¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "Lkotlinx/coroutines/internal/AtomicOp;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "newNode", "<init>", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "affected", "", "failure", "", "e", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Ljava/lang/Object;)V", "b", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "c", "oldNext", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
    public static abstract class CondAddOp extends AtomicOp<LockFreeLinkedListNode> {
        public final LockFreeLinkedListNode b;
        public LockFreeLinkedListNode c;

        public CondAddOp(LockFreeLinkedListNode lockFreeLinkedListNode) {
            this.b = lockFreeLinkedListNode;
        }

        /* renamed from: e */
        public void b(LockFreeLinkedListNode lockFreeLinkedListNode, Object obj) {
            boolean z = obj == null;
            LockFreeLinkedListNode lockFreeLinkedListNode2 = z ? this.b : this.c;
            if (lockFreeLinkedListNode2 != null && a.a(LockFreeLinkedListNode.f3920a, lockFreeLinkedListNode, this, lockFreeLinkedListNode2) && z) {
                LockFreeLinkedListNode lockFreeLinkedListNode3 = this.b;
                LockFreeLinkedListNode lockFreeLinkedListNode4 = this.c;
                Intrinsics.checkNotNull(lockFreeLinkedListNode4);
                lockFreeLinkedListNode3.j(lockFreeLinkedListNode4);
            }
        }
    }

    static {
        Class<LockFreeLinkedListNode> cls = LockFreeLinkedListNode.class;
        Class<Object> cls2 = Object.class;
        f3920a = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_next");
        b = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_prev");
        c = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_removedRef");
    }

    public final void e(LockFreeLinkedListNode lockFreeLinkedListNode) {
        do {
        } while (!m().f(lockFreeLinkedListNode, this));
    }

    public final boolean f(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2) {
        b.lazySet(lockFreeLinkedListNode, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3920a;
        atomicReferenceFieldUpdater.lazySet(lockFreeLinkedListNode, lockFreeLinkedListNode2);
        if (!a.a(atomicReferenceFieldUpdater, this, lockFreeLinkedListNode2, lockFreeLinkedListNode)) {
            return false;
        }
        lockFreeLinkedListNode.j(lockFreeLinkedListNode2);
        return true;
    }

    public final boolean g(LockFreeLinkedListNode lockFreeLinkedListNode) {
        b.lazySet(lockFreeLinkedListNode, this);
        f3920a.lazySet(lockFreeLinkedListNode, this);
        while (k() == this) {
            if (a.a(f3920a, this, this, lockFreeLinkedListNode)) {
                lockFreeLinkedListNode.j(this);
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: kotlinx.coroutines.internal.LockFreeLinkedListNode} */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0042, code lost:
        if (com.honey.account.i.a.a(r4, r3, r2, ((kotlinx.coroutines.internal.Removed) r5).f3928a) != false) goto L_0x0045;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlinx.coroutines.internal.LockFreeLinkedListNode h(kotlinx.coroutines.internal.OpDescriptor r9) {
        /*
            r8 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = b
            java.lang.Object r0 = r0.get(r8)
            kotlinx.coroutines.internal.LockFreeLinkedListNode r0 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r0
            r1 = 0
            r2 = r0
        L_0x000a:
            r3 = r1
        L_0x000b:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = f3920a
            java.lang.Object r5 = r4.get(r2)
            if (r5 != r8) goto L_0x0020
            if (r0 != r2) goto L_0x0016
            return r2
        L_0x0016:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = b
            boolean r0 = com.honey.account.i.a.a(r1, r8, r0, r2)
            if (r0 != 0) goto L_0x001f
            goto L_0x0000
        L_0x001f:
            return r2
        L_0x0020:
            boolean r6 = r8.n()
            if (r6 == 0) goto L_0x0027
            return r1
        L_0x0027:
            if (r5 != r9) goto L_0x002a
            return r2
        L_0x002a:
            boolean r6 = r5 instanceof kotlinx.coroutines.internal.OpDescriptor
            if (r6 == 0) goto L_0x0034
            kotlinx.coroutines.internal.OpDescriptor r5 = (kotlinx.coroutines.internal.OpDescriptor) r5
            r5.a(r2)
            goto L_0x0000
        L_0x0034:
            boolean r6 = r5 instanceof kotlinx.coroutines.internal.Removed
            if (r6 == 0) goto L_0x0050
            if (r3 == 0) goto L_0x0047
            kotlinx.coroutines.internal.Removed r5 = (kotlinx.coroutines.internal.Removed) r5
            kotlinx.coroutines.internal.LockFreeLinkedListNode r5 = r5.f3928a
            boolean r2 = com.honey.account.i.a.a(r4, r3, r2, r5)
            if (r2 != 0) goto L_0x0045
            goto L_0x0000
        L_0x0045:
            r2 = r3
            goto L_0x000a
        L_0x0047:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = b
            java.lang.Object r2 = r4.get(r2)
            kotlinx.coroutines.internal.LockFreeLinkedListNode r2 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r2
            goto L_0x000b
        L_0x0050:
            java.lang.String r3 = "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5, r3)
            r3 = r5
            kotlinx.coroutines.internal.LockFreeLinkedListNode r3 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r3
            r7 = r3
            r3 = r2
            r2 = r7
            goto L_0x000b
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.LockFreeLinkedListNode.h(kotlinx.coroutines.internal.OpDescriptor):kotlinx.coroutines.internal.LockFreeLinkedListNode");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: kotlinx.coroutines.internal.LockFreeLinkedListNode} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlinx.coroutines.internal.LockFreeLinkedListNode i(kotlinx.coroutines.internal.LockFreeLinkedListNode r1) {
        /*
            r0 = this;
        L_0x0000:
            boolean r0 = r1.n()
            if (r0 != 0) goto L_0x0007
            return r1
        L_0x0007:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = b
            java.lang.Object r0 = r0.get(r1)
            r1 = r0
            kotlinx.coroutines.internal.LockFreeLinkedListNode r1 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r1
            goto L_0x0000
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.LockFreeLinkedListNode.i(kotlinx.coroutines.internal.LockFreeLinkedListNode):kotlinx.coroutines.internal.LockFreeLinkedListNode");
    }

    public final void j(LockFreeLinkedListNode lockFreeLinkedListNode) {
        LockFreeLinkedListNode lockFreeLinkedListNode2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b;
        do {
            lockFreeLinkedListNode2 = (LockFreeLinkedListNode) atomicReferenceFieldUpdater.get(lockFreeLinkedListNode);
            if (k() != lockFreeLinkedListNode) {
                return;
            }
        } while (!a.a(b, lockFreeLinkedListNode, lockFreeLinkedListNode2, this));
        if (n()) {
            lockFreeLinkedListNode.h((OpDescriptor) null);
        }
    }

    public final Object k() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3920a;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof OpDescriptor)) {
                return obj;
            }
            ((OpDescriptor) obj).a(this);
        }
    }

    public final LockFreeLinkedListNode l() {
        return LockFreeLinkedListKt.b(k());
    }

    public final LockFreeLinkedListNode m() {
        LockFreeLinkedListNode h = h((OpDescriptor) null);
        return h == null ? i((LockFreeLinkedListNode) b.get(this)) : h;
    }

    public boolean n() {
        return k() instanceof Removed;
    }

    public boolean o() {
        return p() == null;
    }

    public final LockFreeLinkedListNode p() {
        Object k;
        LockFreeLinkedListNode lockFreeLinkedListNode;
        do {
            k = k();
            if (k instanceof Removed) {
                return ((Removed) k).f3928a;
            }
            if (k == this) {
                return (LockFreeLinkedListNode) k;
            }
            Intrinsics.checkNotNull(k, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
            lockFreeLinkedListNode = (LockFreeLinkedListNode) k;
        } while (!a.a(f3920a, this, k, lockFreeLinkedListNode.q()));
        lockFreeLinkedListNode.h((OpDescriptor) null);
        return null;
    }

    public final Removed q() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = c;
        Removed removed = (Removed) atomicReferenceFieldUpdater.get(this);
        if (removed != null) {
            return removed;
        }
        Removed removed2 = new Removed(this);
        atomicReferenceFieldUpdater.lazySet(this, removed2);
        return removed2;
    }

    public final int r(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2, CondAddOp condAddOp) {
        b.lazySet(lockFreeLinkedListNode, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3920a;
        atomicReferenceFieldUpdater.lazySet(lockFreeLinkedListNode, lockFreeLinkedListNode2);
        condAddOp.c = lockFreeLinkedListNode2;
        if (!a.a(atomicReferenceFieldUpdater, this, lockFreeLinkedListNode2, condAddOp)) {
            return 0;
        }
        return condAddOp.a(this) == null ? 1 : 2;
    }

    public String toString() {
        return new LockFreeLinkedListNode$toString$1(this) + '@' + DebugStringsKt.b(this);
    }
}
