package kotlinx.coroutines.scheduling;

import com.honey.account.i.a;
import com.honey.account.u1.c;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\u0012\u001a\u00020\u00112\n\u0010\u000e\u001a\u00060\fj\u0002`\r2\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0014\u0010\u0006J\u0015\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u00042\n\u0010\u000e\u001a\u00060\fj\u0002`\rH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001e\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001f\u0010 J!\u0010\"\u001a\u0004\u0018\u00010\u00042\u0006\u0010!\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\bH\u0002¢\u0006\u0004\b\"\u0010#J+\u0010$\u001a\u00020\u00112\n\u0010\u000e\u001a\u00060\fj\u0002`\r2\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u000fH\u0002¢\u0006\u0004\b$\u0010\u0013J\u0017\u0010&\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u0015H\u0002¢\u0006\u0004\b&\u0010'J\u0011\u0010(\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b(\u0010\u0006J\u0015\u0010)\u001a\u00020\u0017*\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b)\u0010*R\u001c\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040+8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010,R\u0014\u00100\u001a\u00020\f8@X\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0014\u00102\u001a\u00020\f8BX\u0004¢\u0006\u0006\u001a\u0004\b1\u0010/R\u000b\u00104\u001a\u0002038\u0002X\u0004R\u000b\u00105\u001a\u0002038\u0002X\u0004R\u0013\u00107\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0004068\u0002X\u0004R\u000b\u00108\u001a\u0002038\u0002X\u0004¨\u00069"}, d2 = {"Lkotlinx/coroutines/scheduling/WorkQueue;", "", "<init>", "()V", "Lkotlinx/coroutines/scheduling/Task;", "g", "()Lkotlinx/coroutines/scheduling/Task;", "task", "", "fair", "a", "(Lkotlinx/coroutines/scheduling/Task;Z)Lkotlinx/coroutines/scheduling/Task;", "", "Lkotlinx/coroutines/scheduling/StealingMode;", "stealingMode", "Lkotlin/jvm/internal/Ref$ObjectRef;", "stolenTaskRef", "", "n", "(ILkotlin/jvm/internal/Ref$ObjectRef;)J", "h", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalQueue", "", "f", "(Lkotlinx/coroutines/scheduling/GlobalQueue;)V", "b", "(Lkotlinx/coroutines/scheduling/Task;)Lkotlinx/coroutines/scheduling/Task;", "l", "(I)Lkotlinx/coroutines/scheduling/Task;", "onlyBlocking", "k", "(Z)Lkotlinx/coroutines/scheduling/Task;", "index", "m", "(IZ)Lkotlinx/coroutines/scheduling/Task;", "o", "queue", "j", "(Lkotlinx/coroutines/scheduling/GlobalQueue;)Z", "i", "c", "(Lkotlinx/coroutines/scheduling/Task;)V", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "buffer", "e", "()I", "size", "d", "bufferSize", "Lkotlinx/atomicfu/AtomicInt;", "blockingTasksInBuffer", "consumerIndex", "Lkotlinx/atomicfu/AtomicRef;", "lastScheduledTask", "producerIndex", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nWorkQueue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WorkQueue.kt\nkotlinx/coroutines/scheduling/WorkQueue\n+ 2 Tasks.kt\nkotlinx/coroutines/scheduling/TasksKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 WorkQueue.kt\nkotlinx/coroutines/scheduling/WorkQueueKt\n*L\n1#1,255:1\n93#2:256\n93#2:257\n93#2:258\n93#2:261\n93#2:262\n1#3:259\n25#4:260\n*S KotlinDebug\n*F\n+ 1 WorkQueue.kt\nkotlinx/coroutines/scheduling/WorkQueue\n*L\n95#1:256\n162#1:257\n185#1:258\n205#1:261\n249#1:262\n205#1:260\n*E\n"})
public final class WorkQueue {
    public static final AtomicReferenceFieldUpdater b;
    public static final AtomicIntegerFieldUpdater c;
    public static final AtomicIntegerFieldUpdater d;
    public static final AtomicIntegerFieldUpdater e;

    /* renamed from: a  reason: collision with root package name */
    public final AtomicReferenceArray f3966a = new AtomicReferenceArray(128);
    @Volatile
    private volatile int blockingTasksInBuffer;
    @Volatile
    private volatile int consumerIndex;
    @Volatile
    @Nullable
    private volatile Object lastScheduledTask;
    @Volatile
    private volatile int producerIndex;

    static {
        Class<WorkQueue> cls = WorkQueue.class;
        b = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "lastScheduledTask");
        c = AtomicIntegerFieldUpdater.newUpdater(cls, "producerIndex");
        d = AtomicIntegerFieldUpdater.newUpdater(cls, "consumerIndex");
        e = AtomicIntegerFieldUpdater.newUpdater(cls, "blockingTasksInBuffer");
    }

    public final Task a(Task task, boolean z) {
        if (z) {
            return b(task);
        }
        Task task2 = (Task) b.getAndSet(this, task);
        if (task2 == null) {
            return null;
        }
        return b(task2);
    }

    public final Task b(Task task) {
        if (d() == 127) {
            return task;
        }
        if (task.b.T() == 1) {
            e.incrementAndGet(this);
        }
        int i = c.get(this) & 127;
        while (this.f3966a.get(i) != null) {
            Thread.yield();
        }
        this.f3966a.lazySet(i, task);
        c.incrementAndGet(this);
        return null;
    }

    public final void c(Task task) {
        if (task != null && task.b.T() == 1) {
            e.decrementAndGet(this);
        }
    }

    public final int d() {
        return c.get(this) - d.get(this);
    }

    public final int e() {
        Object obj = b.get(this);
        int d2 = d();
        return obj != null ? d2 + 1 : d2;
    }

    public final void f(GlobalQueue globalQueue) {
        Task task = (Task) b.getAndSet(this, (Object) null);
        if (task != null) {
            globalQueue.a(task);
        }
        do {
        } while (j(globalQueue));
    }

    public final Task g() {
        Task task = (Task) b.getAndSet(this, (Object) null);
        return task == null ? i() : task;
    }

    public final Task h() {
        return k(true);
    }

    public final Task i() {
        Task task;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = d;
            int i = atomicIntegerFieldUpdater.get(this);
            if (i - c.get(this) == 0) {
                return null;
            }
            int i2 = i & 127;
            if (atomicIntegerFieldUpdater.compareAndSet(this, i, i + 1) && (task = (Task) this.f3966a.getAndSet(i2, (Object) null)) != null) {
                c(task);
                return task;
            }
        }
    }

    public final boolean j(GlobalQueue globalQueue) {
        Task i = i();
        if (i == null) {
            return false;
        }
        globalQueue.a(i);
        return true;
    }

    public final Task k(boolean z) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Task task;
        do {
            atomicReferenceFieldUpdater = b;
            task = (Task) atomicReferenceFieldUpdater.get(this);
            if (task != null) {
                boolean z2 = true;
                if (task.b.T() != 1) {
                    z2 = false;
                }
                if (z2 == z) {
                }
            }
            int i = d.get(this);
            int i2 = c.get(this);
            while (i != i2) {
                if (z && e.get(this) == 0) {
                    return null;
                }
                i2--;
                Task m = m(i2, z);
                if (m != null) {
                    return m;
                }
            }
            return null;
        } while (!a.a(atomicReferenceFieldUpdater, this, task, (Object) null));
        return task;
    }

    public final Task l(int i) {
        int i2 = d.get(this);
        int i3 = c.get(this);
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        while (i2 != i3) {
            if (z && e.get(this) == 0) {
                return null;
            }
            int i4 = i2 + 1;
            Task m = m(i2, z);
            if (m != null) {
                return m;
            }
            i2 = i4;
        }
        return null;
    }

    public final Task m(int i, boolean z) {
        int i2 = i & 127;
        Task task = (Task) this.f3966a.get(i2);
        if (task != null) {
            boolean z2 = true;
            if (task.b.T() != 1) {
                z2 = false;
            }
            if (z2 == z && c.a(this.f3966a, i2, task, (Object) null)) {
                if (z) {
                    e.decrementAndGet(this);
                }
                return task;
            }
        }
        return null;
    }

    public final long n(int i, Ref.ObjectRef objectRef) {
        T i2 = i == 3 ? i() : l(i);
        if (i2 == null) {
            return o(i, objectRef);
        }
        objectRef.element = i2;
        return -1;
    }

    public final long o(int i, Ref.ObjectRef objectRef) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        T t;
        do {
            atomicReferenceFieldUpdater = b;
            t = (Task) atomicReferenceFieldUpdater.get(this);
            if (t == null) {
                return -2;
            }
            int i2 = 1;
            if (t.b.T() != 1) {
                i2 = 2;
            }
            if ((i2 & i) == 0) {
                return -2;
            }
            long a2 = TasksKt.f.a() - t.f3962a;
            long j = TasksKt.b;
            if (a2 < j) {
                return j - a2;
            }
        } while (!a.a(atomicReferenceFieldUpdater, this, t, (Object) null));
        objectRef.element = t;
        return -1;
    }
}
