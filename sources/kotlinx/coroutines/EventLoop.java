package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\n\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\tJ\u0019\u0010\u000e\u001a\u00020\r2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0014\u0010\u0003J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\"\u0010 \u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0018\u00010\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010\"\u001a\u00020\u00048TX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0006R\u0011\u0010$\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b#\u0010\tR\u0011\u0010&\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b%\u0010\t¨\u0006'"}, d2 = {"Lkotlinx/coroutines/EventLoop;", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "()V", "", "D0", "()J", "", "E0", "()Z", "F0", "Lkotlinx/coroutines/DispatchedTask;", "task", "", "q0", "(Lkotlinx/coroutines/DispatchedTask;)V", "unconfined", "z0", "(Z)V", "d0", "shutdown", "p0", "(Z)J", "a", "J", "useCount", "b", "Z", "shared", "Lkotlin/collections/ArrayDeque;", "c", "Lkotlin/collections/ArrayDeque;", "unconfinedQueue", "r0", "nextTime", "B0", "isUnconfinedLoopActive", "C0", "isUnconfinedQueueEmpty", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nEventLoop.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/EventLoop\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,543:1\n1#2:544\n*E\n"})
public abstract class EventLoop extends CoroutineDispatcher {

    /* renamed from: a  reason: collision with root package name */
    public long f3728a;
    public boolean b;
    public ArrayDeque c;

    public static /* synthetic */ void A0(EventLoop eventLoop, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            eventLoop.z0(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
    }

    public static /* synthetic */ void f0(EventLoop eventLoop, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            eventLoop.d0(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decrementUseCount");
    }

    public final boolean B0() {
        return this.f3728a >= p0(true);
    }

    public final boolean C0() {
        ArrayDeque arrayDeque = this.c;
        if (arrayDeque != null) {
            return arrayDeque.isEmpty();
        }
        return true;
    }

    public long D0() {
        if (!E0()) {
            return LongCompanionObject.MAX_VALUE;
        }
        return 0;
    }

    public final boolean E0() {
        DispatchedTask dispatchedTask;
        ArrayDeque arrayDeque = this.c;
        if (arrayDeque == null || (dispatchedTask = (DispatchedTask) arrayDeque.removeFirstOrNull()) == null) {
            return false;
        }
        dispatchedTask.run();
        return true;
    }

    public boolean F0() {
        return false;
    }

    public final void d0(boolean z) {
        long p0 = this.f3728a - p0(z);
        this.f3728a = p0;
        if (p0 <= 0 && this.b) {
            shutdown();
        }
    }

    public final long p0(boolean z) {
        return z ? 4294967296L : 1;
    }

    public final void q0(DispatchedTask dispatchedTask) {
        ArrayDeque arrayDeque = this.c;
        if (arrayDeque == null) {
            arrayDeque = new ArrayDeque();
            this.c = arrayDeque;
        }
        arrayDeque.addLast(dispatchedTask);
    }

    public long r0() {
        ArrayDeque arrayDeque = this.c;
        if (arrayDeque != null && !arrayDeque.isEmpty()) {
            return 0;
        }
        return LongCompanionObject.MAX_VALUE;
    }

    public void shutdown() {
    }

    public final void z0(boolean z) {
        this.f3728a += p0(z);
        if (!z) {
            this.b = true;
        }
    }
}
