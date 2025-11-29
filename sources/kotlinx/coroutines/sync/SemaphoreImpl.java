package kotlinx.coroutines.sync;

import com.honey.account.i.a;
import com.honey.account.u1.c;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.ConcurrentLinkedListKt;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.SegmentOrClosed;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0010\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u000b\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000f\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\rH\u0005¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0015\u001a\u00020\n2\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\fJ\u000f\u0010\u001a\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001c\u0010\u0018J\u0017\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0007H\u0002¢\u0006\u0004\b \u0010\tJ\u0013\u0010!\u001a\u00020\u0007*\u00020\u0013H\u0002¢\u0006\u0004\b!\u0010\"R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R \u0010(\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\n0%8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010'R\u0014\u0010*\u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u001bR\u000b\u0010,\u001a\u00020+8\u0002X\u0004R\u000b\u0010.\u001a\u00020-8\u0002X\u0004R\u000b\u0010/\u001a\u00020-8\u0002X\u0004R\u0011\u00102\u001a\b\u0012\u0004\u0012\u000201008\u0002X\u0004R\u0011\u00103\u001a\b\u0012\u0004\u0012\u000201008\u0002X\u0004\u0002\u0004\n\u0002\b\u0019¨\u00064"}, d2 = {"Lkotlinx/coroutines/sync/SemaphoreImpl;", "Lkotlinx/coroutines/sync/Semaphore;", "", "permits", "acquiredPermits", "<init>", "(II)V", "", "n", "()Z", "", "b", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/CancellableContinuation;", "waiter", "f", "(Lkotlinx/coroutines/CancellableContinuation;)V", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "", "ignoredParam", "m", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", "release", "()V", "h", "k", "()I", "j", "Lkotlinx/coroutines/Waiter;", "i", "(Lkotlinx/coroutines/Waiter;)Z", "p", "o", "(Ljava/lang/Object;)Z", "a", "I", "Lkotlin/Function1;", "", "Lkotlin/jvm/functions/Function1;", "onCancellationRelease", "l", "availablePermits", "Lkotlinx/atomicfu/AtomicInt;", "_availablePermits", "Lkotlinx/atomicfu/AtomicLong;", "deqIdx", "enqIdx", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/sync/SemaphoreSegment;", "head", "tail", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nSemaphore.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 4 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListKt\n+ 5 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreSegment\n*L\n1#1,397:1\n205#1,10:411\n205#1,10:421\n1#2:398\n332#3,12:399\n72#4,3:431\n46#4,8:434\n72#4,3:445\n46#4,8:448\n375#5:442\n375#5:443\n367#5:444\n378#5:456\n367#5:457\n375#5:458\n*S KotlinDebug\n*F\n+ 1 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreImpl\n*L\n197#1:411,10\n221#1:421,10\n187#1:399,12\n289#1:431,3\n289#1:434,8\n322#1:445,3\n322#1:448,8\n293#1:442\n299#1:443\n313#1:444\n328#1:456\n334#1:457\n337#1:458\n*E\n"})
public class SemaphoreImpl implements Semaphore {
    public static final AtomicReferenceFieldUpdater c;
    public static final AtomicLongFieldUpdater d;
    public static final AtomicReferenceFieldUpdater e;
    public static final AtomicLongFieldUpdater f;
    public static final AtomicIntegerFieldUpdater g;
    @Volatile
    private volatile int _availablePermits;

    /* renamed from: a  reason: collision with root package name */
    public final int f3980a;
    public final Function1 b;
    @Volatile
    private volatile long deqIdx;
    @Volatile
    private volatile long enqIdx;
    @Volatile
    @Nullable
    private volatile Object head;
    @Volatile
    @Nullable
    private volatile Object tail;

    static {
        Class<SemaphoreImpl> cls = SemaphoreImpl.class;
        Class<Object> cls2 = Object.class;
        c = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "head");
        d = AtomicLongFieldUpdater.newUpdater(cls, "deqIdx");
        e = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "tail");
        f = AtomicLongFieldUpdater.newUpdater(cls, "enqIdx");
        g = AtomicIntegerFieldUpdater.newUpdater(cls, "_availablePermits");
    }

    public SemaphoreImpl(int i, int i2) {
        this.f3980a = i;
        if (i <= 0) {
            throw new IllegalArgumentException(("Semaphore should have at least 1 permit, but had " + i).toString());
        } else if (i2 < 0 || i2 > i) {
            throw new IllegalArgumentException(("The number of acquired permits should be in 0.." + i).toString());
        } else {
            SemaphoreSegment semaphoreSegment = new SemaphoreSegment(0, (SemaphoreSegment) null, 2);
            this.head = semaphoreSegment;
            this.tail = semaphoreSegment;
            this._availablePermits = i - i2;
            this.b = new SemaphoreImpl$onCancellationRelease$1(this);
        }
    }

    public static /* synthetic */ Object g(SemaphoreImpl semaphoreImpl, Continuation continuation) {
        if (semaphoreImpl.k() > 0) {
            return Unit.INSTANCE;
        }
        Object h = semaphoreImpl.h(continuation);
        return h == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? h : Unit.INSTANCE;
    }

    public Object b(Continuation continuation) {
        return g(this, continuation);
    }

    public final void f(CancellableContinuation cancellableContinuation) {
        while (k() <= 0) {
            Intrinsics.checkNotNull(cancellableContinuation, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
            if (i((Waiter) cancellableContinuation)) {
                return;
            }
        }
        cancellableContinuation.m(Unit.INSTANCE, this.b);
    }

    public final Object h(Continuation continuation) {
        CancellableContinuationImpl b2 = CancellableContinuationKt.b(IntrinsicsKt.intercepted(continuation));
        try {
            if (!i(b2)) {
                f(b2);
            }
            Object u = b2.u();
            if (u == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return u == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? u : Unit.INSTANCE;
        } catch (Throwable th) {
            b2.K();
            throw th;
        }
    }

    public final boolean i(Waiter waiter) {
        Object c2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = e;
        SemaphoreSegment semaphoreSegment = (SemaphoreSegment) atomicReferenceFieldUpdater.get(this);
        long andIncrement = f.getAndIncrement(this);
        SemaphoreImpl$addAcquireToQueue$createNewSegment$1 semaphoreImpl$addAcquireToQueue$createNewSegment$1 = SemaphoreImpl$addAcquireToQueue$createNewSegment$1.INSTANCE;
        long h = andIncrement / ((long) SemaphoreKt.f);
        loop0:
        while (true) {
            c2 = ConcurrentLinkedListKt.c(semaphoreSegment, h, semaphoreImpl$addAcquireToQueue$createNewSegment$1);
            if (SegmentOrClosed.e(c2)) {
                break;
            }
            Segment c3 = SegmentOrClosed.c(c2);
            while (true) {
                Segment segment = (Segment) atomicReferenceFieldUpdater.get(this);
                if (segment.c >= c3.c) {
                    break loop0;
                } else if (c3.q()) {
                    if (a.a(atomicReferenceFieldUpdater, this, segment, c3)) {
                        if (segment.m()) {
                            segment.k();
                        }
                    } else if (c3.m()) {
                        c3.k();
                    }
                }
            }
        }
        SemaphoreSegment semaphoreSegment2 = (SemaphoreSegment) SegmentOrClosed.c(c2);
        int h2 = (int) (andIncrement % ((long) SemaphoreKt.f));
        if (c.a(semaphoreSegment2.r(), h2, (Object) null, waiter)) {
            waiter.b(semaphoreSegment2, h2);
            return true;
        }
        if (!c.a(semaphoreSegment2.r(), h2, SemaphoreKt.b, SemaphoreKt.c)) {
            return false;
        }
        if (waiter instanceof CancellableContinuation) {
            Intrinsics.checkNotNull(waiter, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            ((CancellableContinuation) waiter).m(Unit.INSTANCE, this.b);
        } else if (waiter instanceof SelectInstance) {
            ((SelectInstance) waiter).c(Unit.INSTANCE);
        } else {
            throw new IllegalStateException(("unexpected: " + waiter).toString());
        }
        return true;
    }

    /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public final void j() {
        /*
            r3 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = g
            int r1 = r0.get(r3)
            int r2 = r3.f3980a
            if (r1 <= r2) goto L_0x0010
            boolean r0 = r0.compareAndSet(r3, r1, r2)
            if (r0 == 0) goto L_0x0000
        L_0x0010:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.SemaphoreImpl.j():void");
    }

    public final int k() {
        int andDecrement;
        do {
            andDecrement = g.getAndDecrement(this);
        } while (andDecrement > this.f3980a);
        return andDecrement;
    }

    public int l() {
        return Math.max(g.get(this), 0);
    }

    public final void m(SelectInstance selectInstance, Object obj) {
        while (k() <= 0) {
            Intrinsics.checkNotNull(selectInstance, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
            if (i((Waiter) selectInstance)) {
                return;
            }
        }
        selectInstance.c(Unit.INSTANCE);
    }

    public boolean n() {
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = g;
            int i = atomicIntegerFieldUpdater.get(this);
            if (i > this.f3980a) {
                j();
            } else if (i <= 0) {
                return false;
            } else {
                if (atomicIntegerFieldUpdater.compareAndSet(this, i, i - 1)) {
                    return true;
                }
            }
        }
    }

    public final boolean o(Object obj) {
        if (obj instanceof CancellableContinuation) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            CancellableContinuation cancellableContinuation = (CancellableContinuation) obj;
            Object H = cancellableContinuation.H(Unit.INSTANCE, (Object) null, this.b);
            if (H == null) {
                return false;
            }
            cancellableContinuation.B(H);
            return true;
        } else if (obj instanceof SelectInstance) {
            return ((SelectInstance) obj).e(this, Unit.INSTANCE);
        } else {
            throw new IllegalStateException(("unexpected: " + obj).toString());
        }
    }

    public final boolean p() {
        Object c2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = c;
        SemaphoreSegment semaphoreSegment = (SemaphoreSegment) atomicReferenceFieldUpdater.get(this);
        long andIncrement = d.getAndIncrement(this);
        long h = andIncrement / ((long) SemaphoreKt.f);
        SemaphoreImpl$tryResumeNextFromQueue$createNewSegment$1 semaphoreImpl$tryResumeNextFromQueue$createNewSegment$1 = SemaphoreImpl$tryResumeNextFromQueue$createNewSegment$1.INSTANCE;
        loop0:
        while (true) {
            c2 = ConcurrentLinkedListKt.c(semaphoreSegment, h, semaphoreImpl$tryResumeNextFromQueue$createNewSegment$1);
            if (SegmentOrClosed.e(c2)) {
                break;
            }
            Segment c3 = SegmentOrClosed.c(c2);
            while (true) {
                Segment segment = (Segment) atomicReferenceFieldUpdater.get(this);
                if (segment.c >= c3.c) {
                    break loop0;
                } else if (c3.q()) {
                    if (a.a(atomicReferenceFieldUpdater, this, segment, c3)) {
                        if (segment.m()) {
                            segment.k();
                        }
                    } else if (c3.m()) {
                        c3.k();
                    }
                }
            }
        }
        SemaphoreSegment semaphoreSegment2 = (SemaphoreSegment) SegmentOrClosed.c(c2);
        semaphoreSegment2.b();
        int i = (semaphoreSegment2.c > h ? 1 : (semaphoreSegment2.c == h ? 0 : -1));
        if (i > 0) {
            return false;
        }
        int h2 = (int) (andIncrement % ((long) SemaphoreKt.f));
        Object andSet = semaphoreSegment2.r().getAndSet(h2, SemaphoreKt.b);
        if (andSet == null) {
            int f2 = SemaphoreKt.f3981a;
            for (int i2 = 0; i2 < f2; i2++) {
                if (semaphoreSegment2.r().get(h2) == SemaphoreKt.c) {
                    return true;
                }
            }
            return !c.a(semaphoreSegment2.r(), h2, SemaphoreKt.b, SemaphoreKt.d);
        } else if (andSet == SemaphoreKt.e) {
            return false;
        } else {
            return o(andSet);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void release() {
        /*
            r3 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = g
            int r0 = r0.getAndIncrement(r3)
            int r1 = r3.f3980a
            if (r0 >= r1) goto L_0x0014
            if (r0 < 0) goto L_0x000d
            return
        L_0x000d:
            boolean r0 = r3.p()
            if (r0 == 0) goto L_0x0000
            return
        L_0x0014:
            r3.j()
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "The number of released permits cannot be greater than "
            r1.append(r2)
            int r3 = r3.f3980a
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            java.lang.String r3 = r3.toString()
            r0.<init>(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.SemaphoreImpl.release():void");
    }
}
