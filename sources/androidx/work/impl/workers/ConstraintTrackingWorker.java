package androidx.work.impl.workers;

import android.content.Context;
import android.os.Build;
import androidx.annotation.RestrictTo;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.ConstraintsState;
import androidx.work.impl.constraints.OnConstraintsStateChangedListener;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.constraints.WorkConstraintsTrackerKt;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.utils.SynchronousExecutor;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.honey.account.q0.a;
import com.honey.account.q0.b;
import com.honey.account.q0.c;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0016\u0010\u000fR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR8\u0010%\u001a&\u0012\f\u0012\n \"*\u0004\u0018\u00010\n0\n \"*\u0012\u0012\f\u0012\n \"*\u0004\u0018\u00010\n0\n\u0018\u00010!0!8\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R(\u0010+\u001a\u0004\u0018\u00010\u00012\b\u0010&\u001a\u0004\u0018\u00010\u00018G@BX\u000e¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*¨\u0006,"}, d2 = {"Landroidx/work/impl/workers/ConstraintTrackingWorker;", "Landroidx/work/ListenableWorker;", "Landroidx/work/impl/constraints/OnConstraintsStateChangedListener;", "Landroid/content/Context;", "appContext", "Landroidx/work/WorkerParameters;", "workerParameters", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "Lcom/google/common/util/concurrent/ListenableFuture;", "Landroidx/work/ListenableWorker$Result;", "n", "()Lcom/google/common/util/concurrent/ListenableFuture;", "", "l", "()V", "Landroidx/work/impl/model/WorkSpec;", "workSpec", "Landroidx/work/impl/constraints/ConstraintsState;", "state", "d", "(Landroidx/work/impl/model/WorkSpec;Landroidx/work/impl/constraints/ConstraintsState;)V", "s", "e", "Landroidx/work/WorkerParameters;", "", "f", "Ljava/lang/Object;", "lock", "", "g", "Z", "areConstraintsUnmet", "Landroidx/work/impl/utils/futures/SettableFuture;", "kotlin.jvm.PlatformType", "h", "Landroidx/work/impl/utils/futures/SettableFuture;", "future", "<set-?>", "i", "Landroidx/work/ListenableWorker;", "getDelegate", "()Landroidx/work/ListenableWorker;", "delegate", "work-runtime_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nConstraintTrackingWorker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConstraintTrackingWorker.kt\nandroidx/work/impl/workers/ConstraintTrackingWorker\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,167:1\n1#2:168\n*E\n"})
@RestrictTo
public final class ConstraintTrackingWorker extends ListenableWorker implements OnConstraintsStateChangedListener {
    public final WorkerParameters e;
    public final Object f = new Object();
    public volatile boolean g;
    public final SettableFuture h = SettableFuture.s();
    public ListenableWorker i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConstraintTrackingWorker(@NotNull Context context, @NotNull WorkerParameters workerParameters) {
        super(context, workerParameters);
        Intrinsics.checkNotNullParameter(context, "appContext");
        Intrinsics.checkNotNullParameter(workerParameters, "workerParameters");
        this.e = workerParameters;
    }

    public static final void t(Job job) {
        Intrinsics.checkNotNullParameter(job, "$job");
        job.a((CancellationException) null);
    }

    public static final void u(ConstraintTrackingWorker constraintTrackingWorker, ListenableFuture listenableFuture) {
        Intrinsics.checkNotNullParameter(constraintTrackingWorker, "this$0");
        Intrinsics.checkNotNullParameter(listenableFuture, "$innerFuture");
        synchronized (constraintTrackingWorker.f) {
            try {
                if (constraintTrackingWorker.g) {
                    SettableFuture settableFuture = constraintTrackingWorker.h;
                    Intrinsics.checkNotNullExpressionValue(settableFuture, "future");
                    boolean unused = ConstraintTrackingWorkerKt.e(settableFuture);
                } else {
                    constraintTrackingWorker.h.q(listenableFuture);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static final void v(ConstraintTrackingWorker constraintTrackingWorker) {
        Intrinsics.checkNotNullParameter(constraintTrackingWorker, "this$0");
        constraintTrackingWorker.s();
    }

    public void d(WorkSpec workSpec, ConstraintsState constraintsState) {
        Intrinsics.checkNotNullParameter(workSpec, "workSpec");
        Intrinsics.checkNotNullParameter(constraintsState, "state");
        Logger e2 = Logger.e();
        String a2 = ConstraintTrackingWorkerKt.f2262a;
        e2.a(a2, "Constraints changed for " + workSpec);
        if (constraintsState instanceof ConstraintsState.ConstraintsNotMet) {
            synchronized (this.f) {
                this.g = true;
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public void l() {
        super.l();
        ListenableWorker listenableWorker = this.i;
        if (listenableWorker != null && !listenableWorker.j()) {
            listenableWorker.o(Build.VERSION.SDK_INT >= 31 ? g() : 0);
        }
    }

    public ListenableFuture n() {
        b().execute(new a(this));
        SettableFuture settableFuture = this.h;
        Intrinsics.checkNotNullExpressionValue(settableFuture, "future");
        return settableFuture;
    }

    public final void s() {
        if (!this.h.isCancelled()) {
            String i2 = f().i("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME");
            Logger e2 = Logger.e();
            Intrinsics.checkNotNullExpressionValue(e2, "get()");
            if (i2 == null || i2.length() == 0) {
                e2.c(ConstraintTrackingWorkerKt.f2262a, "No worker to delegate to.");
                SettableFuture settableFuture = this.h;
                Intrinsics.checkNotNullExpressionValue(settableFuture, "future");
                boolean unused = ConstraintTrackingWorkerKt.d(settableFuture);
                return;
            }
            ListenableWorker b = i().b(a(), i2, this.e);
            this.i = b;
            if (b == null) {
                e2.a(ConstraintTrackingWorkerKt.f2262a, "No worker to delegate to.");
                SettableFuture settableFuture2 = this.h;
                Intrinsics.checkNotNullExpressionValue(settableFuture2, "future");
                boolean unused2 = ConstraintTrackingWorkerKt.d(settableFuture2);
                return;
            }
            WorkManagerImpl k = WorkManagerImpl.k(a());
            Intrinsics.checkNotNullExpressionValue(k, "getInstance(applicationContext)");
            WorkSpecDao j = k.p().j();
            String uuid = e().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "id.toString()");
            WorkSpec y = j.y(uuid);
            if (y == null) {
                SettableFuture settableFuture3 = this.h;
                Intrinsics.checkNotNullExpressionValue(settableFuture3, "future");
                boolean unused3 = ConstraintTrackingWorkerKt.d(settableFuture3);
                return;
            }
            Trackers o = k.o();
            Intrinsics.checkNotNullExpressionValue(o, "workManagerImpl.trackers");
            WorkConstraintsTracker workConstraintsTracker = new WorkConstraintsTracker(o);
            CoroutineDispatcher a2 = k.q().a();
            Intrinsics.checkNotNullExpressionValue(a2, "workManagerImpl.workTask…r.taskCoroutineDispatcher");
            this.h.addListener(new b(WorkConstraintsTrackerKt.b(workConstraintsTracker, y, a2, this)), new SynchronousExecutor());
            if (workConstraintsTracker.a(y)) {
                String a3 = ConstraintTrackingWorkerKt.f2262a;
                e2.a(a3, "Constraints met for delegate " + i2);
                try {
                    ListenableWorker listenableWorker = this.i;
                    Intrinsics.checkNotNull(listenableWorker);
                    ListenableFuture n = listenableWorker.n();
                    Intrinsics.checkNotNullExpressionValue(n, "delegate!!.startWork()");
                    n.addListener(new c(this, n), b());
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                String a4 = ConstraintTrackingWorkerKt.f2262a;
                e2.a(a4, "Constraints not met for delegate " + i2 + ". Requesting retry.");
                SettableFuture settableFuture4 = this.h;
                Intrinsics.checkNotNullExpressionValue(settableFuture4, "future");
                boolean unused4 = ConstraintTrackingWorkerKt.e(settableFuture4);
            }
        }
    }
}
