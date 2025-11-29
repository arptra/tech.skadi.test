package kotlinx.coroutines;

import com.honey.account.i.a;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.time.DurationKt;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import kotlinx.coroutines.internal.ThreadSafeHeap;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\b \u0018\u00002\u00020\u00012\u00020\u0002:\u0004>?@AB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J%\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0011\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00072\n\u0010\u000f\u001a\u00060\rj\u0002`\u000eH\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00152\n\u0010\u000f\u001a\u00060\rj\u0002`\u000e¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u001a\u001a\u00020\u00052\n\u0010\u0019\u001a\u00060\rj\u0002`\u000eH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0005H\u0004¢\u0006\u0004\b!\u0010\u0004J\u001b\u0010#\u001a\u00020\"2\n\u0010\u0019\u001a\u00060\rj\u0002`\u000eH\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\n\u0018\u00010\rj\u0004\u0018\u0001`\u000eH\u0002¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0005H\u0002¢\u0006\u0004\b'\u0010\u0004J\u0017\u0010(\u001a\u00020\"2\u0006\u0010\u0019\u001a\u00020\u001dH\u0002¢\u0006\u0004\b(\u0010)J\u001f\u0010+\u001a\u00020*2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0005H\u0002¢\u0006\u0004\b-\u0010\u0004R$\u0010/\u001a\u00020\"2\u0006\u0010.\u001a\u00020\"8B@BX\u000e¢\u0006\f\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0014\u00104\u001a\u00020\"8TX\u0004¢\u0006\u0006\u001a\u0004\b3\u00100R\u0014\u00106\u001a\u00020\u00078TX\u0004¢\u0006\u0006\u001a\u0004\b5\u0010\u0014R\u0013\u00109\u001a\n\u0012\u0006\u0012\u0004\u0018\u000108078\u0002X\u0004R\u000b\u0010;\u001a\u00020:8\u0002X\u0004R\u0013\u0010=\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010<078\u0002X\u0004¨\u0006B"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase;", "Lkotlinx/coroutines/EventLoopImplPlatform;", "Lkotlinx/coroutines/Delay;", "<init>", "()V", "", "shutdown", "", "timeMillis", "Lkotlinx/coroutines/CancellableContinuation;", "continuation", "scheduleResumeAfterDelay", "(JLkotlinx/coroutines/CancellableContinuation;)V", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lkotlinx/coroutines/DisposableHandle;", "T0", "(JLjava/lang/Runnable;)Lkotlinx/coroutines/DisposableHandle;", "D0", "()J", "Lkotlin/coroutines/CoroutineContext;", "context", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "task", "M0", "(Ljava/lang/Runnable;)V", "now", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "delayedTask", "R0", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)V", "Q0", "", "N0", "(Ljava/lang/Runnable;)Z", "L0", "()Ljava/lang/Runnable;", "K0", "V0", "(Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;)Z", "", "S0", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)I", "P0", "value", "isCompleted", "()Z", "U0", "(Z)V", "O0", "isEmpty", "r0", "nextTime", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "_delayed", "Lkotlinx/atomicfu/AtomicBoolean;", "_isCompleted", "", "_queue", "DelayedResumeTask", "DelayedRunnableTask", "DelayedTask", "DelayedTaskQueue", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nEventLoop.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/EventLoopImplBase\n+ 2 ThreadSafeHeap.kt\nkotlinx/coroutines/internal/ThreadSafeHeap\n+ 3 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 4 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 5 EventLoop.kt\nkotlinx/coroutines/EventLoopKt\n+ 6 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,543:1\n60#2:544\n61#2,7:550\n28#3,4:545\n20#4:549\n56#5:557\n1#6:558\n*S KotlinDebug\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/EventLoopImplBase\n*L\n269#1:544\n269#1:550,7\n269#1:545,4\n269#1:549\n280#1:557\n*E\n"})
public abstract class EventLoopImplBase extends EventLoopImplPlatform implements Delay {
    public static final AtomicReferenceFieldUpdater d;
    public static final AtomicReferenceFieldUpdater e;
    public static final AtomicIntegerFieldUpdater f;
    @Volatile
    @Nullable
    private volatile Object _delayed;
    @Volatile
    private volatile int _isCompleted = 0;
    @Volatile
    @Nullable
    private volatile Object _queue;

    @SourceDebugExtension({"SMAP\nEventLoop.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/EventLoopImplBase$DelayedResumeTask\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,543:1\n1#2:544\n*E\n"})
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedResumeTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "", "nanoTime", "Lkotlinx/coroutines/CancellableContinuation;", "", "cont", "<init>", "(Lkotlinx/coroutines/EventLoopImplBase;JLkotlinx/coroutines/CancellableContinuation;)V", "run", "()V", "", "toString", "()Ljava/lang/String;", "c", "Lkotlinx/coroutines/CancellableContinuation;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
    public final class DelayedResumeTask extends DelayedTask {
        public final CancellableContinuation c;

        public DelayedResumeTask(long j, CancellableContinuation cancellableContinuation) {
            super(j);
            this.c = cancellableContinuation;
        }

        public void run() {
            this.c.I(EventLoopImplBase.this, Unit.INSTANCE);
        }

        public String toString() {
            return super.toString() + this.c;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0018\u0010\u0006\u001a\u00060\u0004j\u0002`\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedRunnableTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "", "nanoTime", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "<init>", "(JLjava/lang/Runnable;)V", "", "run", "()V", "", "toString", "()Ljava/lang/String;", "c", "Ljava/lang/Runnable;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
    public static final class DelayedRunnableTask extends DelayedTask {
        public final Runnable c;

        public DelayedRunnableTask(long j, Runnable runnable) {
            super(j);
            this.c = runnable;
        }

        public void run() {
            this.c.run();
        }

        public String toString() {
            return super.toString() + this.c;
        }
    }

    @SourceDebugExtension({"SMAP\nEventLoop.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/EventLoopImplBase$DelayedTask\n+ 2 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 3 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 4 ThreadSafeHeap.kt\nkotlinx/coroutines/internal/ThreadSafeHeap\n*L\n1#1,543:1\n28#2,4:544\n28#2,4:550\n28#2,4:562\n20#3:548\n20#3:554\n20#3:566\n72#4:549\n73#4,7:555\n*S KotlinDebug\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/EventLoopImplBase$DelayedTask\n*L\n437#1:544,4\n439#1:550,4\n479#1:562,4\n437#1:548\n439#1:554\n479#1:566\n439#1:549\n439#1:555,7\n*E\n"})
    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\b \u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u00032\u00020\u00042\u00020\u00052\u00060\u0006j\u0002`\u0007B\u000f\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u0016\u0010\t\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010\"\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\"\u0010*\u001a\u00020\r8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R0\u00100\u001a\b\u0012\u0002\b\u0003\u0018\u00010+2\f\u0010,\u001a\b\u0012\u0002\b\u0003\u0018\u00010+8V@VX\u000e¢\u0006\f\u001a\u0004\b-\u0010.\"\u0004\b \u0010/¨\u00061"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "", "nanoTime", "<init>", "(J)V", "other", "", "g", "(Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;)I", "now", "", "i", "(J)Z", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "delayed", "Lkotlinx/coroutines/EventLoopImplBase;", "eventLoop", "h", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;Lkotlinx/coroutines/EventLoopImplBase;)I", "", "dispose", "()V", "", "toString", "()Ljava/lang/String;", "a", "J", "_heap", "Ljava/lang/Object;", "b", "I", "getIndex", "()I", "f", "(I)V", "index", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "value", "d", "()Lkotlinx/coroutines/internal/ThreadSafeHeap;", "(Lkotlinx/coroutines/internal/ThreadSafeHeap;)V", "heap", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
    public static abstract class DelayedTask implements Runnable, Comparable<DelayedTask>, DisposableHandle, ThreadSafeHeapNode {
        @Nullable
        private volatile Object _heap;

        /* renamed from: a  reason: collision with root package name */
        public long f3729a;
        public int b = -1;

        public DelayedTask(long j) {
            this.f3729a = j;
        }

        public void a(ThreadSafeHeap threadSafeHeap) {
            if (this._heap != EventLoop_commonKt.f3730a) {
                this._heap = threadSafeHeap;
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        public ThreadSafeHeap d() {
            Object obj = this._heap;
            if (obj instanceof ThreadSafeHeap) {
                return (ThreadSafeHeap) obj;
            }
            return null;
        }

        public final void dispose() {
            synchronized (this) {
                try {
                    Object obj = this._heap;
                    if (obj != EventLoop_commonKt.f3730a) {
                        DelayedTaskQueue delayedTaskQueue = obj instanceof DelayedTaskQueue ? (DelayedTaskQueue) obj : null;
                        if (delayedTaskQueue != null) {
                            delayedTaskQueue.g(this);
                        }
                        this._heap = EventLoop_commonKt.f3730a;
                        Unit unit = Unit.INSTANCE;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void f(int i) {
            this.b = i;
        }

        /* renamed from: g */
        public int compareTo(DelayedTask delayedTask) {
            int i = ((this.f3729a - delayedTask.f3729a) > 0 ? 1 : ((this.f3729a - delayedTask.f3729a) == 0 ? 0 : -1));
            if (i > 0) {
                return 1;
            }
            return i < 0 ? -1 : 0;
        }

        public int getIndex() {
            return this.b;
        }

        public final int h(long j, DelayedTaskQueue delayedTaskQueue, EventLoopImplBase eventLoopImplBase) {
            synchronized (this) {
                if (this._heap == EventLoop_commonKt.f3730a) {
                    return 2;
                }
                synchronized (delayedTaskQueue) {
                    try {
                        DelayedTask delayedTask = (DelayedTask) delayedTaskQueue.b();
                        if (eventLoopImplBase.isCompleted()) {
                            return 1;
                        }
                        if (delayedTask == null) {
                            delayedTaskQueue.c = j;
                        } else {
                            long j2 = delayedTask.f3729a;
                            if (j2 - j < 0) {
                                j = j2;
                            }
                            if (j - delayedTaskQueue.c > 0) {
                                delayedTaskQueue.c = j;
                            }
                        }
                        long j3 = this.f3729a;
                        long j4 = delayedTaskQueue.c;
                        if (j3 - j4 < 0) {
                            this.f3729a = j4;
                        }
                        delayedTaskQueue.a(this);
                        return 0;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        public final boolean i(long j) {
            return j - this.f3729a >= 0;
        }

        public String toString() {
            return "Delayed[nanos=" + this.f3729a + ']';
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "", "timeNow", "<init>", "(J)V", "c", "J", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
    public static final class DelayedTaskQueue extends ThreadSafeHeap<DelayedTask> {
        public long c;

        public DelayedTaskQueue(long j) {
            this.c = j;
        }
    }

    static {
        Class<EventLoopImplBase> cls = EventLoopImplBase.class;
        Class<Object> cls2 = Object.class;
        d = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_queue");
        e = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_delayed");
        f = AtomicIntegerFieldUpdater.newUpdater(cls, "_isCompleted");
    }

    /* access modifiers changed from: private */
    public final boolean isCompleted() {
        return f.get(this) != 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x005b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long D0() {
        /*
            r9 = this;
            boolean r0 = r9.E0()
            r1 = 0
            if (r0 == 0) goto L_0x0009
            return r1
        L_0x0009:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = e
            java.lang.Object r0 = r0.get(r9)
            kotlinx.coroutines.EventLoopImplBase$DelayedTaskQueue r0 = (kotlinx.coroutines.EventLoopImplBase.DelayedTaskQueue) r0
            if (r0 == 0) goto L_0x0051
            boolean r3 = r0.d()
            if (r3 != 0) goto L_0x0051
            kotlinx.coroutines.AbstractTimeSource r3 = kotlinx.coroutines.AbstractTimeSourceKt.a()
            if (r3 == 0) goto L_0x0024
            long r3 = r3.a()
            goto L_0x0028
        L_0x0024:
            long r3 = java.lang.System.nanoTime()
        L_0x0028:
            monitor-enter(r0)
            kotlinx.coroutines.internal.ThreadSafeHeapNode r5 = r0.b()     // Catch:{ all -> 0x0040 }
            r6 = 0
            if (r5 != 0) goto L_0x0032
            monitor-exit(r0)
            goto L_0x004a
        L_0x0032:
            kotlinx.coroutines.EventLoopImplBase$DelayedTask r5 = (kotlinx.coroutines.EventLoopImplBase.DelayedTask) r5     // Catch:{ all -> 0x0040 }
            boolean r7 = r5.i(r3)     // Catch:{ all -> 0x0040 }
            r8 = 0
            if (r7 == 0) goto L_0x0042
            boolean r5 = r9.N0(r5)     // Catch:{ all -> 0x0040 }
            goto L_0x0043
        L_0x0040:
            r9 = move-exception
            goto L_0x004f
        L_0x0042:
            r5 = r8
        L_0x0043:
            if (r5 == 0) goto L_0x0049
            kotlinx.coroutines.internal.ThreadSafeHeapNode r6 = r0.h(r8)     // Catch:{ all -> 0x0040 }
        L_0x0049:
            monitor-exit(r0)
        L_0x004a:
            kotlinx.coroutines.EventLoopImplBase$DelayedTask r6 = (kotlinx.coroutines.EventLoopImplBase.DelayedTask) r6
            if (r6 != 0) goto L_0x0028
            goto L_0x0051
        L_0x004f:
            monitor-exit(r0)
            throw r9
        L_0x0051:
            java.lang.Runnable r0 = r9.L0()
            if (r0 == 0) goto L_0x005b
            r0.run()
            return r1
        L_0x005b:
            long r0 = r9.r0()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.EventLoopImplBase.D0():long");
    }

    public final void K0() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = d;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                if (a.a(d, this, (Object) null, EventLoop_commonKt.b)) {
                    return;
                }
            } else if (obj instanceof LockFreeTaskQueueCore) {
                ((LockFreeTaskQueueCore) obj).d();
                return;
            } else if (obj != EventLoop_commonKt.b) {
                LockFreeTaskQueueCore lockFreeTaskQueueCore = new LockFreeTaskQueueCore(8, true);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                lockFreeTaskQueueCore.a((Runnable) obj);
                if (a.a(d, this, obj, lockFreeTaskQueueCore)) {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public final Runnable L0() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = d;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                return null;
            }
            if (obj instanceof LockFreeTaskQueueCore) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) obj;
                Object j = lockFreeTaskQueueCore.j();
                if (j != LockFreeTaskQueueCore.h) {
                    return (Runnable) j;
                }
                a.a(d, this, obj, lockFreeTaskQueueCore.i());
            } else if (obj == EventLoop_commonKt.b) {
                return null;
            } else {
                if (a.a(d, this, obj, (Object) null)) {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                    return (Runnable) obj;
                }
            }
        }
    }

    public void M0(Runnable runnable) {
        if (N0(runnable)) {
            I0();
        } else {
            DefaultExecutor.g.M0(runnable);
        }
    }

    public final boolean N0(Runnable runnable) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = d;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (isCompleted()) {
                return false;
            }
            if (obj == null) {
                if (a.a(d, this, (Object) null, runnable)) {
                    return true;
                }
            } else if (obj instanceof LockFreeTaskQueueCore) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) obj;
                int a2 = lockFreeTaskQueueCore.a(runnable);
                if (a2 == 0) {
                    return true;
                }
                if (a2 == 1) {
                    a.a(d, this, obj, lockFreeTaskQueueCore.i());
                } else if (a2 == 2) {
                    return false;
                }
            } else if (obj == EventLoop_commonKt.b) {
                return false;
            } else {
                LockFreeTaskQueueCore lockFreeTaskQueueCore2 = new LockFreeTaskQueueCore(8, true);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                lockFreeTaskQueueCore2.a((Runnable) obj);
                lockFreeTaskQueueCore2.a(runnable);
                if (a.a(d, this, obj, lockFreeTaskQueueCore2)) {
                    return true;
                }
            }
        }
    }

    public boolean O0() {
        if (!C0()) {
            return false;
        }
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) e.get(this);
        if (delayedTaskQueue != null && !delayedTaskQueue.d()) {
            return false;
        }
        Object obj = d.get(this);
        if (obj != null) {
            if (obj instanceof LockFreeTaskQueueCore) {
                return ((LockFreeTaskQueueCore) obj).g();
            }
            if (obj != EventLoop_commonKt.b) {
                return false;
            }
        }
        return true;
    }

    public final void P0() {
        DelayedTask delayedTask;
        AbstractTimeSource a2 = AbstractTimeSourceKt.a();
        long a3 = a2 != null ? a2.a() : System.nanoTime();
        while (true) {
            DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) e.get(this);
            if (delayedTaskQueue != null && (delayedTask = (DelayedTask) delayedTaskQueue.i()) != null) {
                H0(a3, delayedTask);
            } else {
                return;
            }
        }
    }

    public final void Q0() {
        d.set(this, (Object) null);
        e.set(this, (Object) null);
    }

    public final void R0(long j, DelayedTask delayedTask) {
        int S0 = S0(j, delayedTask);
        if (S0 != 0) {
            if (S0 == 1) {
                H0(j, delayedTask);
            } else if (S0 != 2) {
                throw new IllegalStateException("unexpected result".toString());
            }
        } else if (V0(delayedTask)) {
            I0();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: kotlinx.coroutines.EventLoopImplBase$DelayedTaskQueue} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int S0(long r4, kotlinx.coroutines.EventLoopImplBase.DelayedTask r6) {
        /*
            r3 = this;
            boolean r0 = r3.isCompleted()
            if (r0 == 0) goto L_0x0008
            r3 = 1
            return r3
        L_0x0008:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = e
            java.lang.Object r1 = r0.get(r3)
            kotlinx.coroutines.EventLoopImplBase$DelayedTaskQueue r1 = (kotlinx.coroutines.EventLoopImplBase.DelayedTaskQueue) r1
            if (r1 != 0) goto L_0x0025
            kotlinx.coroutines.EventLoopImplBase$DelayedTaskQueue r1 = new kotlinx.coroutines.EventLoopImplBase$DelayedTaskQueue
            r1.<init>(r4)
            r2 = 0
            com.honey.account.i.a.a(r0, r3, r2, r1)
            java.lang.Object r0 = r0.get(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r1 = r0
            kotlinx.coroutines.EventLoopImplBase$DelayedTaskQueue r1 = (kotlinx.coroutines.EventLoopImplBase.DelayedTaskQueue) r1
        L_0x0025:
            int r3 = r6.h(r4, r1, r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.EventLoopImplBase.S0(long, kotlinx.coroutines.EventLoopImplBase$DelayedTask):int");
    }

    public final DisposableHandle T0(long j, Runnable runnable) {
        long d2 = EventLoop_commonKt.d(j);
        if (d2 >= DurationKt.MAX_MILLIS) {
            return NonDisposableHandle.f3741a;
        }
        AbstractTimeSource a2 = AbstractTimeSourceKt.a();
        long a3 = a2 != null ? a2.a() : System.nanoTime();
        DelayedRunnableTask delayedRunnableTask = new DelayedRunnableTask(d2 + a3, runnable);
        R0(a3, delayedRunnableTask);
        return delayedRunnableTask;
    }

    public final void U0(boolean z) {
        f.set(this, z ? 1 : 0);
    }

    public final boolean V0(DelayedTask delayedTask) {
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) e.get(this);
        return (delayedTaskQueue != null ? (DelayedTask) delayedTaskQueue.e() : null) == delayedTask;
    }

    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        M0(runnable);
    }

    public DisposableHandle invokeOnTimeout(long j, Runnable runnable, CoroutineContext coroutineContext) {
        return Delay.DefaultImpls.b(this, j, runnable, coroutineContext);
    }

    public long r0() {
        DelayedTask delayedTask;
        if (super.r0() == 0) {
            return 0;
        }
        Object obj = d.get(this);
        if (obj != null) {
            if (obj instanceof LockFreeTaskQueueCore) {
                if (!((LockFreeTaskQueueCore) obj).g()) {
                    return 0;
                }
            } else if (obj == EventLoop_commonKt.b) {
                return LongCompanionObject.MAX_VALUE;
            } else {
                return 0;
            }
        }
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) e.get(this);
        if (delayedTaskQueue == null || (delayedTask = (DelayedTask) delayedTaskQueue.e()) == null) {
            return LongCompanionObject.MAX_VALUE;
        }
        long j = delayedTask.f3729a;
        AbstractTimeSource a2 = AbstractTimeSourceKt.a();
        return RangesKt.coerceAtLeast(j - (a2 != null ? a2.a() : System.nanoTime()), 0);
    }

    public void scheduleResumeAfterDelay(long j, CancellableContinuation cancellableContinuation) {
        long d2 = EventLoop_commonKt.d(j);
        if (d2 < DurationKt.MAX_MILLIS) {
            AbstractTimeSource a2 = AbstractTimeSourceKt.a();
            long a3 = a2 != null ? a2.a() : System.nanoTime();
            DelayedResumeTask delayedResumeTask = new DelayedResumeTask(d2 + a3, cancellableContinuation);
            R0(a3, delayedResumeTask);
            CancellableContinuationKt.a(cancellableContinuation, delayedResumeTask);
        }
    }

    public void shutdown() {
        ThreadLocalEventLoop.f3744a.c();
        U0(true);
        K0();
        do {
        } while (D0() <= 0);
        P0();
    }
}
