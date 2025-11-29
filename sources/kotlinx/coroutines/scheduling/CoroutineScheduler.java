package kotlinx.coroutines.scheduling;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.AbstractTimeSource;
import kotlinx.coroutines.AbstractTimeSourceKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.internal.ResizableAtomicArray;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 V2\u00020\u00012\u00020\u0002:\u0003WXYB+\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\b\u0018\u00010\u0011R\u00020\u0000H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0015\u001a\u00020\u00032\n\u0010\u0014\u001a\u00060\u0011R\u00020\u0000H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001d\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0003H\u0002¢\u0006\u0004\b!\u0010\"J+\u0010$\u001a\u0004\u0018\u00010\f*\b\u0018\u00010\u0011R\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0006\u0010#\u001a\u00020\u000eH\u0002¢\u0006\u0004\b$\u0010%J\u0015\u0010&\u001a\b\u0018\u00010\u0011R\u00020\u0000H\u0002¢\u0006\u0004\b&\u0010\u0013J)\u0010)\u001a\u00020\u00192\n\u0010\u0014\u001a\u00060\u0011R\u00020\u00002\u0006\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0003¢\u0006\u0004\b)\u0010*J\u0019\u0010+\u001a\u00020\u000e2\n\u0010\u0014\u001a\u00060\u0011R\u00020\u0000¢\u0006\u0004\b+\u0010,J\u001b\u00100\u001a\u00020\u00192\n\u0010/\u001a\u00060-j\u0002`.H\u0016¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\u0019H\u0016¢\u0006\u0004\b2\u00103J\u0015\u00105\u001a\u00020\u00192\u0006\u00104\u001a\u00020\u0006¢\u0006\u0004\b5\u00106J-\u0010:\u001a\u00020\u00192\n\u00107\u001a\u00060-j\u0002`.2\b\b\u0002\u00109\u001a\u0002082\b\b\u0002\u0010#\u001a\u00020\u000e¢\u0006\u0004\b:\u0010;J!\u0010<\u001a\u00020\f2\n\u00107\u001a\u00060-j\u0002`.2\u0006\u00109\u001a\u000208¢\u0006\u0004\b<\u0010=J\r\u0010>\u001a\u00020\u0019¢\u0006\u0004\b>\u00103J\u000f\u0010?\u001a\u00020\bH\u0016¢\u0006\u0004\b?\u0010@J\u0015\u0010A\u001a\u00020\u00192\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\bA\u0010BR\u0014\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010\u0005\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010DR\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0006\n\u0004\b!\u0010ER\u0014\u0010\t\u001a\u00020\b8\u0006X\u0004¢\u0006\u0006\n\u0004\b<\u0010FR\u0014\u0010J\u001a\u00020G8\u0006X\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0014\u0010L\u001a\u00020G8\u0006X\u0004¢\u0006\u0006\n\u0004\bK\u0010IR\u001e\u0010O\u001a\f\u0012\b\u0012\u00060\u0011R\u00020\u00000M8\u0006X\u0004¢\u0006\u0006\n\u0004\b&\u0010NR\u0011\u0010P\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\bP\u0010 R\u000b\u0010R\u001a\u00020Q8\u0002X\u0004R\u000b\u0010T\u001a\u00020S8\u0002X\u0004R\u000b\u0010U\u001a\u00020S8\u0002X\u0004¨\u0006Z"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "Ljava/util/concurrent/Executor;", "Ljava/io/Closeable;", "", "corePoolSize", "maxPoolSize", "", "idleWorkerKeepAliveNs", "", "schedulerName", "<init>", "(IIJLjava/lang/String;)V", "Lkotlinx/coroutines/scheduling/Task;", "task", "", "b", "(Lkotlinx/coroutines/scheduling/Task;)Z", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "r", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "worker", "o", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;)I", "stateSnapshot", "skipUnpark", "", "N", "(JZ)V", "state", "U", "(J)Z", "d0", "()Z", "c", "()I", "tailDispatch", "T", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;Lkotlinx/coroutines/scheduling/Task;Z)Lkotlinx/coroutines/scheduling/Task;", "g", "oldIndex", "newIndex", "u", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;II)V", "s", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;)Z", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "command", "execute", "(Ljava/lang/Runnable;)V", "close", "()V", "timeout", "w", "(J)V", "block", "Lkotlinx/coroutines/scheduling/TaskContext;", "taskContext", "j", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/TaskContext;Z)V", "d", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/TaskContext;)Lkotlinx/coroutines/scheduling/Task;", "S", "toString", "()Ljava/lang/String;", "v", "(Lkotlinx/coroutines/scheduling/Task;)V", "a", "I", "J", "Ljava/lang/String;", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "e", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalCpuQueue", "f", "globalBlockingQueue", "Lkotlinx/coroutines/internal/ResizableAtomicArray;", "Lkotlinx/coroutines/internal/ResizableAtomicArray;", "workers", "isTerminated", "Lkotlinx/atomicfu/AtomicBoolean;", "_isTerminated", "Lkotlinx/atomicfu/AtomicLong;", "controlState", "parkedWorkersStack", "h", "Companion", "Worker", "WorkerState", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nCoroutineScheduler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler\n+ 2 Tasks.kt\nkotlinx/coroutines/scheduling/TasksKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 5 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 6 Tasks.kt\nkotlinx/coroutines/scheduling/Task\n+ 7 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler$Worker\n*L\n1#1,1033:1\n285#1:1036\n283#1:1037\n283#1:1038\n285#1:1039\n280#1:1045\n281#1,5:1046\n291#1:1052\n283#1:1053\n284#1:1054\n283#1:1060\n284#1:1061\n280#1:1062\n288#1:1063\n283#1:1064\n283#1:1067\n284#1:1068\n285#1:1069\n93#2:1034\n93#2:1051\n1#3:1035\n28#4,4:1040\n28#4,4:1055\n20#5:1044\n20#5:1059\n90#6:1065\n610#7:1066\n*S KotlinDebug\n*F\n+ 1 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler\n*L\n281#1:1036\n288#1:1037\n289#1:1038\n298#1:1039\n347#1:1045\n375#1:1046,5\n398#1:1052\n445#1:1053\n446#1:1054\n482#1:1060\n483#1:1061\n489#1:1062\n498#1:1063\n498#1:1064\n576#1:1067\n577#1:1068\n578#1:1069\n119#1:1034\n395#1:1051\n347#1:1040,4\n478#1:1055,4\n347#1:1044\n478#1:1059\n515#1:1065\n522#1:1066\n*E\n"})
public final class CoroutineScheduler implements Executor, Closeable {
    public static final Companion h = new Companion((DefaultConstructorMarker) null);
    public static final AtomicLongFieldUpdater i;
    public static final AtomicLongFieldUpdater j;
    public static final AtomicIntegerFieldUpdater k;
    public static final Symbol l = new Symbol("NOT_IN_STACK");
    @Volatile
    private volatile int _isTerminated;

    /* renamed from: a  reason: collision with root package name */
    public final int f3959a;
    public final int b;
    public final long c;
    @Volatile
    private volatile long controlState;
    public final String d;
    public final GlobalQueue e;
    public final GlobalQueue f;
    public final ResizableAtomicArray g;
    @Volatile
    private volatile long parkedWorkersStack;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000e8\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Companion;", "", "()V", "BLOCKING_MASK", "", "BLOCKING_SHIFT", "", "CLAIMED", "CPU_PERMITS_MASK", "CPU_PERMITS_SHIFT", "CREATED_MASK", "MAX_SUPPORTED_POOL_SIZE", "MIN_SUPPORTED_POOL_SIZE", "NOT_IN_STACK", "Lkotlinx/coroutines/internal/Symbol;", "PARKED", "PARKED_INDEX_MASK", "PARKED_VERSION_INC", "PARKED_VERSION_MASK", "TERMINATED", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|3|4|5|6|7|8|9|10|11|13) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState[] r0 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r1 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.PARKING     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r1 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.BLOCKING     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r1 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.CPU_ACQUIRED     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r1 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.DORMANT     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r1 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.TERMINATED     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.CoroutineScheduler.WhenMappings.<clinit>():void");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "", "(Ljava/lang/String;I)V", "CPU_ACQUIRED", "BLOCKING", "PARKING", "DORMANT", "TERMINATED", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum WorkerState {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    static {
        Class<CoroutineScheduler> cls = CoroutineScheduler.class;
        i = AtomicLongFieldUpdater.newUpdater(cls, "parkedWorkersStack");
        j = AtomicLongFieldUpdater.newUpdater(cls, "controlState");
        k = AtomicIntegerFieldUpdater.newUpdater(cls, "_isTerminated");
    }

    public CoroutineScheduler(int i2, int i3, long j2, String str) {
        this.f3959a = i2;
        this.b = i3;
        this.c = j2;
        this.d = str;
        if (i2 < 1) {
            throw new IllegalArgumentException(("Core pool size " + i2 + " should be at least 1").toString());
        } else if (i3 < i2) {
            throw new IllegalArgumentException(("Max pool size " + i3 + " should be greater than or equals to core pool size " + i2).toString());
        } else if (i3 > 2097150) {
            throw new IllegalArgumentException(("Max pool size " + i3 + " should not exceed maximal supported number of threads 2097150").toString());
        } else if (j2 > 0) {
            this.e = new GlobalQueue();
            this.f = new GlobalQueue();
            this.g = new ResizableAtomicArray((i2 + 1) * 2);
            this.controlState = ((long) i2) << 42;
            this._isTerminated = 0;
        } else {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j2 + " must be positive").toString());
        }
    }

    public static /* synthetic */ boolean c0(CoroutineScheduler coroutineScheduler, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = j.get(coroutineScheduler);
        }
        return coroutineScheduler.U(j2);
    }

    public static /* synthetic */ void n(CoroutineScheduler coroutineScheduler, Runnable runnable, TaskContext taskContext, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            taskContext = TasksKt.g;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        coroutineScheduler.j(runnable, taskContext, z);
    }

    public final void N(long j2, boolean z) {
        if (!z && !d0() && !U(j2)) {
            d0();
        }
    }

    public final void S() {
        if (!d0() && !c0(this, 0, 1, (Object) null)) {
            d0();
        }
    }

    public final Task T(Worker worker, Task task, boolean z) {
        if (worker == null || worker.c == WorkerState.TERMINATED) {
            return task;
        }
        if (task.b.T() == 0 && worker.c == WorkerState.BLOCKING) {
            return task;
        }
        worker.g = true;
        return worker.f3960a.a(task, z);
    }

    public final boolean U(long j2) {
        if (RangesKt.coerceAtLeast(((int) (2097151 & j2)) - ((int) ((j2 & 4398044413952L) >> 21)), 0) < this.f3959a) {
            int c2 = c();
            if (c2 == 1 && this.f3959a > 1) {
                c();
            }
            if (c2 > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean b(Task task) {
        return task.b.T() == 1 ? this.f.a(task) : this.e.a(task);
    }

    public final int c() {
        synchronized (this.g) {
            try {
                if (isTerminated()) {
                    return -1;
                }
                AtomicLongFieldUpdater atomicLongFieldUpdater = j;
                long j2 = atomicLongFieldUpdater.get(this);
                int i2 = (int) (j2 & 2097151);
                int coerceAtLeast = RangesKt.coerceAtLeast(i2 - ((int) ((j2 & 4398044413952L) >> 21)), 0);
                if (coerceAtLeast >= this.f3959a) {
                    return 0;
                }
                if (i2 >= this.b) {
                    return 0;
                }
                int i3 = ((int) (j.get(this) & 2097151)) + 1;
                if (i3 <= 0 || this.g.b(i3) != null) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                Worker worker = new Worker(this, i3);
                this.g.c(i3, worker);
                if (i3 == ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this)))) {
                    int i4 = coerceAtLeast + 1;
                    worker.start();
                    return i4;
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void close() {
        w(10000);
    }

    public final Task d(Runnable runnable, TaskContext taskContext) {
        long a2 = TasksKt.f.a();
        if (!(runnable instanceof Task)) {
            return new TaskImpl(runnable, a2, taskContext);
        }
        Task task = (Task) runnable;
        task.f3962a = a2;
        task.b = taskContext;
        return task;
    }

    public final boolean d0() {
        Worker r;
        do {
            r = r();
            if (r == null) {
                return false;
            }
        } while (!Worker.j().compareAndSet(r, -1, 0));
        LockSupport.unpark(r);
        return true;
    }

    public void execute(Runnable runnable) {
        n(this, runnable, (TaskContext) null, false, 6, (Object) null);
    }

    public final Worker g() {
        Thread currentThread = Thread.currentThread();
        Worker worker = currentThread instanceof Worker ? (Worker) currentThread : null;
        if (worker == null || !Intrinsics.areEqual((Object) CoroutineScheduler.this, (Object) this)) {
            return null;
        }
        return worker;
    }

    public final boolean isTerminated() {
        return k.get(this) != 0;
    }

    public final void j(Runnable runnable, TaskContext taskContext, boolean z) {
        AbstractTimeSource a2 = AbstractTimeSourceKt.a();
        if (a2 != null) {
            a2.d();
        }
        Task d2 = d(runnable, taskContext);
        boolean z2 = false;
        boolean z3 = d2.b.T() == 1;
        long addAndGet = z3 ? j.addAndGet(this, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) : 0;
        Worker g2 = g();
        Task T = T(g2, d2, z);
        if (T == null || b(T)) {
            if (z && g2 != null) {
                z2 = true;
            }
            if (z3) {
                N(addAndGet, z2);
            } else if (!z2) {
                S();
            }
        } else {
            throw new RejectedExecutionException(this.d + " was terminated");
        }
    }

    public final int o(Worker worker) {
        Object i2 = worker.i();
        while (i2 != l) {
            if (i2 == null) {
                return 0;
            }
            Worker worker2 = (Worker) i2;
            int h2 = worker2.h();
            if (h2 != 0) {
                return h2;
            }
            i2 = worker2.i();
        }
        return -1;
    }

    public final Worker r() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = i;
        while (true) {
            long j2 = atomicLongFieldUpdater.get(this);
            Worker worker = (Worker) this.g.b((int) (2097151 & j2));
            if (worker == null) {
                return null;
            }
            long j3 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j2) & -2097152;
            int o = o(worker);
            if (o >= 0) {
                if (i.compareAndSet(this, j2, ((long) o) | j3)) {
                    worker.r(l);
                    return worker;
                }
            }
        }
    }

    public final boolean s(Worker worker) {
        long j2;
        int h2;
        if (worker.i() != l) {
            return false;
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater = i;
        do {
            j2 = atomicLongFieldUpdater.get(this);
            h2 = worker.h();
            worker.r(this.g.b((int) (2097151 & j2)));
        } while (!i.compareAndSet(this, j2, ((PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j2) & -2097152) | ((long) h2)));
        return true;
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        int a2 = this.g.a();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 1; i7 < a2; i7++) {
            Worker worker = (Worker) this.g.b(i7);
            if (worker != null) {
                int e2 = worker.f3960a.e();
                int i8 = WhenMappings.$EnumSwitchMapping$0[worker.c.ordinal()];
                if (i8 == 1) {
                    i4++;
                } else if (i8 == 2) {
                    i3++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(e2);
                    sb.append('b');
                    arrayList.add(sb.toString());
                } else if (i8 == 3) {
                    i2++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(e2);
                    sb2.append('c');
                    arrayList.add(sb2.toString());
                } else if (i8 == 4) {
                    i5++;
                    if (e2 > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(e2);
                        sb3.append('d');
                        arrayList.add(sb3.toString());
                    }
                } else if (i8 == 5) {
                    i6++;
                }
            }
        }
        long j2 = j.get(this);
        return this.d + '@' + DebugStringsKt.b(this) + "[Pool Size {core = " + this.f3959a + ", max = " + this.b + "}, Worker States {CPU = " + i2 + ", blocking = " + i3 + ", parked = " + i4 + ", dormant = " + i5 + ", terminated = " + i6 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.e.c() + ", global blocking queue size = " + this.f.c() + ", Control State {created workers= " + ((int) (2097151 & j2)) + ", blocking tasks = " + ((int) ((4398044413952L & j2) >> 21)) + ", CPUs acquired = " + (this.f3959a - ((int) ((9223367638808264704L & j2) >> 42))) + "}]";
    }

    public final void u(Worker worker, int i2, int i3) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = i;
        while (true) {
            long j2 = atomicLongFieldUpdater.get(this);
            int i4 = (int) (2097151 & j2);
            long j3 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j2) & -2097152;
            if (i4 == i2) {
                i4 = i3 == 0 ? o(worker) : i3;
            }
            if (i4 >= 0) {
                if (i.compareAndSet(this, j2, j3 | ((long) i4))) {
                    return;
                }
            }
        }
    }

    public final void v(Task task) {
        AbstractTimeSource a2;
        try {
            task.run();
            a2 = AbstractTimeSourceKt.a();
            if (a2 == null) {
                return;
            }
        } catch (Throwable th) {
            AbstractTimeSource a3 = AbstractTimeSourceKt.a();
            if (a3 != null) {
                a3.e();
            }
            throw th;
        }
        a2.e();
    }

    public final void w(long j2) {
        int i2;
        Task task;
        if (k.compareAndSet(this, 0, 1)) {
            Worker g2 = g();
            synchronized (this.g) {
                i2 = (int) (j.get(this) & 2097151);
            }
            if (1 <= i2) {
                int i3 = 1;
                while (true) {
                    Object b2 = this.g.b(i3);
                    Intrinsics.checkNotNull(b2);
                    Worker worker = (Worker) b2;
                    if (worker != g2) {
                        while (worker.isAlive()) {
                            LockSupport.unpark(worker);
                            worker.join(j2);
                        }
                        worker.f3960a.f(this.f);
                    }
                    if (i3 == i2) {
                        break;
                    }
                    i3++;
                }
            }
            this.f.b();
            this.e.b();
            while (true) {
                if (g2 != null) {
                    task = g2.g(true);
                    if (task != null) {
                        continue;
                        v(task);
                    }
                }
                task = (Task) this.e.d();
                if (task == null && (task = (Task) this.f.d()) == null) {
                    break;
                }
                v(task);
            }
            if (g2 != null) {
                g2.u(WorkerState.TERMINATED);
            }
            i.set(this, 0);
            j.set(this, 0);
        }
    }

    @SourceDebugExtension({"SMAP\nCoroutineScheduler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler$Worker\n+ 2 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Tasks.kt\nkotlinx/coroutines/scheduling/Task\n+ 5 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 6 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n*L\n1#1,1033:1\n298#2:1034\n285#2:1035\n299#2,4:1036\n304#2:1040\n294#2,2:1041\n294#2,2:1045\n280#2:1052\n289#2:1053\n283#2:1054\n280#2:1055\n1#3:1043\n90#4:1044\n28#5,4:1047\n20#6:1051\n*S KotlinDebug\n*F\n+ 1 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler$Worker\n*L\n665#1:1034\n665#1:1035\n665#1:1036,4\n679#1:1040\n753#1:1041,2\n807#1:1045,2\n855#1:1052\n881#1:1053\n881#1:1054\n963#1:1055\n790#1:1044\n851#1:1047,4\n851#1:1051\n*E\n"})
    @Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0002\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\tJ\u0017\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0017\u0010\fJ\u000f\u0010\u0018\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0018\u0010\fJ\u0017\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u0015J\u0011\u0010\u001b\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001d\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0011\u0010 \u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b \u0010\u001cJ\u001d\u0010#\u001a\u0004\u0018\u00010\u000f2\n\u0010\"\u001a\u00060\u0004j\u0002`!H\u0002¢\u0006\u0004\b#\u0010$J\u0015\u0010'\u001a\u00020\u00072\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\nH\u0016¢\u0006\u0004\b)\u0010\fJ\u0015\u0010+\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u0004¢\u0006\u0004\b+\u0010,J\u0017\u0010.\u001a\u0004\u0018\u00010\u000f2\u0006\u0010-\u001a\u00020\u0007¢\u0006\u0004\b.\u0010\u001fR*\u0010/\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00048\u0006@FX\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u0010\u0015R\u0014\u00107\u001a\u0002048\u0006X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u001c\u0010:\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f088\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u00109R\u0016\u0010<\u001a\u00020%8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010;R\u0016\u0010?\u001a\u00020=8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010>R$\u0010A\u001a\u0004\u0018\u00010@8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u0016\u0010G\u001a\u00020=8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010>R\u0016\u0010H\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u00100R\u0016\u0010-\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b.\u0010IR\b\u0010K\u001a\u00020J8\u0006¨\u0006L"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "Ljava/lang/Thread;", "<init>", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;)V", "", "index", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;I)V", "", "s", "()Z", "", "p", "()V", "t", "l", "Lkotlinx/coroutines/scheduling/Task;", "task", "d", "(Lkotlinx/coroutines/scheduling/Task;)V", "taskMode", "c", "(I)V", "b", "n", "w", "mode", "k", "f", "()Lkotlinx/coroutines/scheduling/Task;", "scanLocalQueue", "e", "(Z)Lkotlinx/coroutines/scheduling/Task;", "o", "Lkotlinx/coroutines/scheduling/StealingMode;", "stealingMode", "v", "(I)Lkotlinx/coroutines/scheduling/Task;", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "newState", "u", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;)Z", "run", "upperBound", "m", "(I)I", "mayHaveLocalTasks", "g", "indexInArray", "I", "h", "()I", "q", "Lkotlinx/coroutines/scheduling/WorkQueue;", "a", "Lkotlinx/coroutines/scheduling/WorkQueue;", "localQueue", "Lkotlin/jvm/internal/Ref$ObjectRef;", "Lkotlin/jvm/internal/Ref$ObjectRef;", "stolenTask", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "state", "", "J", "terminationDeadline", "", "nextParkedWorker", "Ljava/lang/Object;", "i", "()Ljava/lang/Object;", "r", "(Ljava/lang/Object;)V", "minDelayUntilStealableTaskNs", "rngState", "Z", "Lkotlinx/atomicfu/AtomicInt;", "workerCtl", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
    public final class Worker extends Thread {
        public static final AtomicIntegerFieldUpdater i = AtomicIntegerFieldUpdater.newUpdater(Worker.class, "workerCtl");

        /* renamed from: a  reason: collision with root package name */
        public final WorkQueue f3960a;
        public final Ref.ObjectRef b;
        public WorkerState c;
        public long d;
        public long e;
        public int f;
        public boolean g;
        private volatile int indexInArray;
        @Nullable
        private volatile Object nextParkedWorker;
        @Volatile
        private volatile int workerCtl;

        public Worker() {
            setDaemon(true);
            this.f3960a = new WorkQueue();
            this.b = new Ref.ObjectRef();
            this.c = WorkerState.DORMANT;
            this.nextParkedWorker = CoroutineScheduler.l;
            this.f = Random.Default.nextInt();
        }

        public static final AtomicIntegerFieldUpdater j() {
            return i;
        }

        public final void b(int i2) {
            if (i2 != 0) {
                CoroutineScheduler.j.addAndGet(CoroutineScheduler.this, -2097152);
                if (this.c != WorkerState.TERMINATED) {
                    this.c = WorkerState.DORMANT;
                }
            }
        }

        public final void c(int i2) {
            if (i2 != 0 && u(WorkerState.BLOCKING)) {
                CoroutineScheduler.this.S();
            }
        }

        public final void d(Task task) {
            int T = task.b.T();
            k(T);
            c(T);
            CoroutineScheduler.this.v(task);
            b(T);
        }

        public final Task e(boolean z) {
            Task o;
            Task o2;
            if (z) {
                boolean z2 = m(CoroutineScheduler.this.f3959a * 2) == 0;
                if (z2 && (o2 = o()) != null) {
                    return o2;
                }
                Task g2 = this.f3960a.g();
                if (g2 != null) {
                    return g2;
                }
                if (!z2 && (o = o()) != null) {
                    return o;
                }
            } else {
                Task o3 = o();
                if (o3 != null) {
                    return o3;
                }
            }
            return v(3);
        }

        public final Task f() {
            Task h2 = this.f3960a.h();
            if (h2 != null) {
                return h2;
            }
            Task task = (Task) CoroutineScheduler.this.f.d();
            return task == null ? v(1) : task;
        }

        public final Task g(boolean z) {
            return s() ? e(z) : f();
        }

        public final int h() {
            return this.indexInArray;
        }

        public final Object i() {
            return this.nextParkedWorker;
        }

        public final void k(int i2) {
            this.d = 0;
            if (this.c == WorkerState.PARKING) {
                this.c = WorkerState.BLOCKING;
            }
        }

        public final boolean l() {
            return this.nextParkedWorker != CoroutineScheduler.l;
        }

        public final int m(int i2) {
            int i3 = this.f;
            int i4 = i3 ^ (i3 << 13);
            int i5 = i4 ^ (i4 >> 17);
            int i6 = i5 ^ (i5 << 5);
            this.f = i6;
            int i7 = i2 - 1;
            return (i7 & i2) == 0 ? i7 & i6 : (Integer.MAX_VALUE & i6) % i2;
        }

        public final void n() {
            if (this.d == 0) {
                this.d = System.nanoTime() + CoroutineScheduler.this.c;
            }
            LockSupport.parkNanos(CoroutineScheduler.this.c);
            if (System.nanoTime() - this.d >= 0) {
                this.d = 0;
                w();
            }
        }

        public final Task o() {
            if (m(2) == 0) {
                Task task = (Task) CoroutineScheduler.this.e.d();
                return task != null ? task : (Task) CoroutineScheduler.this.f.d();
            }
            Task task2 = (Task) CoroutineScheduler.this.f.d();
            return task2 != null ? task2 : (Task) CoroutineScheduler.this.e.d();
        }

        public final void p() {
            loop0:
            while (true) {
                boolean z = false;
                while (!CoroutineScheduler.this.isTerminated() && this.c != WorkerState.TERMINATED) {
                    Task g2 = g(this.g);
                    if (g2 != null) {
                        this.e = 0;
                        d(g2);
                    } else {
                        this.g = false;
                        if (this.e == 0) {
                            t();
                        } else if (!z) {
                            z = true;
                        } else {
                            u(WorkerState.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.e);
                            this.e = 0;
                        }
                    }
                }
            }
            u(WorkerState.TERMINATED);
        }

        public final void q(int i2) {
            StringBuilder sb = new StringBuilder();
            sb.append(CoroutineScheduler.this.d);
            sb.append("-worker-");
            sb.append(i2 == 0 ? "TERMINATED" : String.valueOf(i2));
            setName(sb.toString());
            this.indexInArray = i2;
        }

        public final void r(Object obj) {
            this.nextParkedWorker = obj;
        }

        public void run() {
            p();
        }

        public final boolean s() {
            long j;
            if (this.c == WorkerState.CPU_ACQUIRED) {
                return true;
            }
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            AtomicLongFieldUpdater a2 = CoroutineScheduler.j;
            do {
                j = a2.get(coroutineScheduler);
                if (((int) ((9223367638808264704L & j) >> 42)) == 0) {
                    return false;
                }
            } while (!CoroutineScheduler.j.compareAndSet(coroutineScheduler, j, j - 4398046511104L));
            this.c = WorkerState.CPU_ACQUIRED;
            return true;
        }

        public final void t() {
            if (!l()) {
                CoroutineScheduler.this.s(this);
                return;
            }
            i.set(this, -1);
            while (l() && i.get(this) == -1 && !CoroutineScheduler.this.isTerminated() && this.c != WorkerState.TERMINATED) {
                u(WorkerState.PARKING);
                Thread.interrupted();
                n();
            }
        }

        public final boolean u(WorkerState workerState) {
            WorkerState workerState2 = this.c;
            boolean z = workerState2 == WorkerState.CPU_ACQUIRED;
            if (z) {
                CoroutineScheduler.j.addAndGet(CoroutineScheduler.this, 4398046511104L);
            }
            if (workerState2 != workerState) {
                this.c = workerState;
            }
            return z;
        }

        public final Task v(int i2) {
            int i3 = (int) (CoroutineScheduler.j.get(CoroutineScheduler.this) & 2097151);
            if (i3 < 2) {
                return null;
            }
            int m = m(i3);
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            long j = Long.MAX_VALUE;
            for (int i4 = 0; i4 < i3; i4++) {
                m++;
                if (m > i3) {
                    m = 1;
                }
                Worker worker = (Worker) coroutineScheduler.g.b(m);
                if (worker == null || worker == this) {
                    int i5 = i2;
                } else {
                    long n = worker.f3960a.n(i2, this.b);
                    if (n == -1) {
                        Ref.ObjectRef objectRef = this.b;
                        Task task = (Task) objectRef.element;
                        objectRef.element = null;
                        return task;
                    } else if (n > 0) {
                        j = Math.min(j, n);
                    }
                }
            }
            if (j == LongCompanionObject.MAX_VALUE) {
                j = 0;
            }
            this.e = j;
            return null;
        }

        public final void w() {
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            synchronized (coroutineScheduler.g) {
                try {
                    if (!coroutineScheduler.isTerminated()) {
                        if (((int) (CoroutineScheduler.j.get(coroutineScheduler) & 2097151)) > coroutineScheduler.f3959a) {
                            if (i.compareAndSet(this, -1, 1)) {
                                int i2 = this.indexInArray;
                                q(0);
                                coroutineScheduler.u(this, i2, 0);
                                int andDecrement = (int) (CoroutineScheduler.j.getAndDecrement(coroutineScheduler) & 2097151);
                                if (andDecrement != i2) {
                                    Object b2 = coroutineScheduler.g.b(andDecrement);
                                    Intrinsics.checkNotNull(b2);
                                    Worker worker = (Worker) b2;
                                    coroutineScheduler.g.c(i2, worker);
                                    worker.q(i2);
                                    coroutineScheduler.u(worker, andDecrement, i2);
                                }
                                coroutineScheduler.g.c(andDecrement, (Object) null);
                                Unit unit = Unit.INSTANCE;
                                this.c = WorkerState.TERMINATED;
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public Worker(CoroutineScheduler coroutineScheduler, int i2) {
            this();
            q(i2);
        }
    }
}
