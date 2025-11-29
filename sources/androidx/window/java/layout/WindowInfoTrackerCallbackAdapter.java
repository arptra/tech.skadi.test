package androidx.window.java.layout;

import android.app.Activity;
import androidx.core.util.Consumer;
import androidx.window.layout.WindowInfoTracker;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\t\u0010\nJ+\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\r¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0012\u001a\u00020\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\r¢\u0006\u0004\b\u0012\u0010\u0013J9\u0010\u0016\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u00142\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0018\u001a\u00020\u000f2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\rH\u0002¢\u0006\u0004\b\u0018\u0010\u0013R\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u001bR$\u0010 \u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u0004\u0012\u00020\u001e0\u001d8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u001f¨\u0006!"}, d2 = {"Landroidx/window/java/layout/WindowInfoTrackerCallbackAdapter;", "Landroidx/window/layout/WindowInfoTracker;", "tracker", "<init>", "(Landroidx/window/layout/WindowInfoTracker;)V", "Landroid/app/Activity;", "activity", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/window/layout/WindowLayoutInfo;", "b", "(Landroid/app/Activity;)Lkotlinx/coroutines/flow/Flow;", "Ljava/util/concurrent/Executor;", "executor", "Landroidx/core/util/Consumer;", "consumer", "", "d", "(Landroid/app/Activity;Ljava/util/concurrent/Executor;Landroidx/core/util/Consumer;)V", "f", "(Landroidx/core/util/Consumer;)V", "T", "flow", "c", "(Ljava/util/concurrent/Executor;Landroidx/core/util/Consumer;Lkotlinx/coroutines/flow/Flow;)V", "e", "Landroidx/window/layout/WindowInfoTracker;", "Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/concurrent/locks/ReentrantLock;", "lock", "", "Lkotlinx/coroutines/Job;", "Ljava/util/Map;", "consumerToJobMap", "window-java_release"}, k = 1, mv = {1, 5, 1})
public final class WindowInfoTrackerCallbackAdapter implements WindowInfoTracker {
    public final WindowInfoTracker b;
    public final ReentrantLock c = new ReentrantLock();
    public final Map d = new LinkedHashMap();

    public WindowInfoTrackerCallbackAdapter(WindowInfoTracker windowInfoTracker) {
        Intrinsics.checkNotNullParameter(windowInfoTracker, "tracker");
        this.b = windowInfoTracker;
    }

    public Flow b(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return this.b.b(activity);
    }

    public final void c(Executor executor, Consumer consumer, Flow flow) {
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            if (this.d.get(consumer) == null) {
                this.d.put(consumer, BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(ExecutorsKt.a(executor)), (CoroutineContext) null, (CoroutineStart) null, new WindowInfoTrackerCallbackAdapter$addListener$1$1(flow, consumer, (Continuation<? super WindowInfoTrackerCallbackAdapter$addListener$1$1>) null), 3, (Object) null));
            }
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void d(Activity activity, Executor executor, Consumer consumer) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        c(executor, consumer, this.b.b(activity));
    }

    public final void e(Consumer consumer) {
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            Job job = (Job) this.d.get(consumer);
            if (job != null) {
                Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
            }
            Job job2 = (Job) this.d.remove(consumer);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void f(Consumer consumer) {
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        e(consumer);
    }
}
