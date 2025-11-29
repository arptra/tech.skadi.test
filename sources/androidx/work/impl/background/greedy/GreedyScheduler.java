package androidx.work.impl.background.greedy;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.RestrictTo;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.RunnableScheduler;
import androidx.work.WorkInfo;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Processor;
import androidx.work.impl.Scheduler;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.StartStopTokens;
import androidx.work.impl.WorkLauncher;
import androidx.work.impl.constraints.ConstraintsState;
import androidx.work.impl.constraints.OnConstraintsStateChangedListener;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.constraints.WorkConstraintsTrackerKt;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.utils.ProcessUtils;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.meizu.common.widget.MzContactsContract;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.Job;

@RestrictTo
public class GreedyScheduler implements Scheduler, OnConstraintsStateChangedListener, ExecutionListener {
    public static final String o = Logger.i("GreedyScheduler");

    /* renamed from: a  reason: collision with root package name */
    public final Context f2115a;
    public final Map b = new HashMap();
    public DelayedWorkTracker c;
    public boolean d;
    public final Object e = new Object();
    public final StartStopTokens f = new StartStopTokens();
    public final Processor g;
    public final WorkLauncher h;
    public final Configuration i;
    public final Map j = new HashMap();
    public Boolean k;
    public final WorkConstraintsTracker l;
    public final TaskExecutor m;
    public final TimeLimiter n;

    public static class AttemptData {

        /* renamed from: a  reason: collision with root package name */
        public final int f2116a;
        public final long b;

        public AttemptData(int i, long j) {
            this.f2116a = i;
            this.b = j;
        }
    }

    public GreedyScheduler(Context context, Configuration configuration, Trackers trackers, Processor processor, WorkLauncher workLauncher, TaskExecutor taskExecutor) {
        this.f2115a = context;
        RunnableScheduler k2 = configuration.k();
        this.c = new DelayedWorkTracker(this, k2, configuration.a());
        this.n = new TimeLimiter(k2, workLauncher);
        this.m = taskExecutor;
        this.l = new WorkConstraintsTracker(trackers);
        this.i = configuration;
        this.g = processor;
        this.h = workLauncher;
    }

    public boolean a() {
        return false;
    }

    public void b(WorkSpec... workSpecArr) {
        if (this.k == null) {
            e();
        }
        if (!this.k.booleanValue()) {
            Logger.e().f(o, "Ignoring schedule request in a secondary process");
            return;
        }
        f();
        HashSet<WorkSpec> hashSet = new HashSet<>();
        HashSet hashSet2 = new HashSet();
        for (WorkSpec workSpec : workSpecArr) {
            if (!this.f.a(WorkSpecKt.a(workSpec))) {
                long max = Math.max(workSpec.c(), h(workSpec));
                long currentTimeMillis = this.i.a().currentTimeMillis();
                if (workSpec.b == WorkInfo.State.ENQUEUED) {
                    if (currentTimeMillis < max) {
                        DelayedWorkTracker delayedWorkTracker = this.c;
                        if (delayedWorkTracker != null) {
                            delayedWorkTracker.a(workSpec, max);
                        }
                    } else if (workSpec.i()) {
                        if (workSpec.j.h()) {
                            Logger.e().a(o, "Ignoring " + workSpec + ". Requires device idle.");
                        } else if (workSpec.j.e()) {
                            Logger.e().a(o, "Ignoring " + workSpec + ". Requires ContentUri triggers.");
                        } else {
                            hashSet.add(workSpec);
                            hashSet2.add(workSpec.f2184a);
                        }
                    } else if (!this.f.a(WorkSpecKt.a(workSpec))) {
                        Logger.e().a(o, "Starting work for " + workSpec.f2184a);
                        StartStopToken e2 = this.f.e(workSpec);
                        this.n.c(e2);
                        this.h.b(e2);
                    }
                }
            }
        }
        synchronized (this.e) {
            try {
                if (!hashSet.isEmpty()) {
                    String join = TextUtils.join(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA, hashSet2);
                    Logger.e().a(o, "Starting tracking for " + join);
                    for (WorkSpec workSpec2 : hashSet) {
                        WorkGenerationalId a2 = WorkSpecKt.a(workSpec2);
                        if (!this.b.containsKey(a2)) {
                            this.b.put(a2, WorkConstraintsTrackerKt.b(this.l, workSpec2, this.m.a(), this));
                        }
                    }
                }
            } finally {
            }
        }
    }

    public void c(WorkGenerationalId workGenerationalId, boolean z) {
        StartStopToken b2 = this.f.b(workGenerationalId);
        if (b2 != null) {
            this.n.b(b2);
        }
        g(workGenerationalId);
        if (!z) {
            synchronized (this.e) {
                this.j.remove(workGenerationalId);
            }
        }
    }

    public void cancel(String str) {
        if (this.k == null) {
            e();
        }
        if (!this.k.booleanValue()) {
            Logger.e().f(o, "Ignoring schedule request in non-main process");
            return;
        }
        f();
        Logger e2 = Logger.e();
        String str2 = o;
        e2.a(str2, "Cancelling work ID " + str);
        DelayedWorkTracker delayedWorkTracker = this.c;
        if (delayedWorkTracker != null) {
            delayedWorkTracker.b(str);
        }
        for (StartStopToken startStopToken : this.f.c(str)) {
            this.n.b(startStopToken);
            this.h.e(startStopToken);
        }
    }

    public void d(WorkSpec workSpec, ConstraintsState constraintsState) {
        WorkGenerationalId a2 = WorkSpecKt.a(workSpec);
        if (!(constraintsState instanceof ConstraintsState.ConstraintsMet)) {
            Logger e2 = Logger.e();
            String str = o;
            e2.a(str, "Constraints not met: Cancelling work ID " + a2);
            StartStopToken b2 = this.f.b(a2);
            if (b2 != null) {
                this.n.b(b2);
                this.h.a(b2, ((ConstraintsState.ConstraintsNotMet) constraintsState).a());
            }
        } else if (!this.f.a(a2)) {
            Logger e3 = Logger.e();
            String str2 = o;
            e3.a(str2, "Constraints met: Scheduling work ID " + a2);
            StartStopToken d2 = this.f.d(a2);
            this.n.c(d2);
            this.h.b(d2);
        }
    }

    public final void e() {
        this.k = Boolean.valueOf(ProcessUtils.b(this.f2115a, this.i));
    }

    public final void f() {
        if (!this.d) {
            this.g.e(this);
            this.d = true;
        }
    }

    public final void g(WorkGenerationalId workGenerationalId) {
        Job job;
        synchronized (this.e) {
            job = (Job) this.b.remove(workGenerationalId);
        }
        if (job != null) {
            Logger e2 = Logger.e();
            String str = o;
            e2.a(str, "Stopping tracking for " + workGenerationalId);
            job.a((CancellationException) null);
        }
    }

    public final long h(WorkSpec workSpec) {
        long max;
        synchronized (this.e) {
            try {
                WorkGenerationalId a2 = WorkSpecKt.a(workSpec);
                AttemptData attemptData = (AttemptData) this.j.get(a2);
                if (attemptData == null) {
                    attemptData = new AttemptData(workSpec.k, this.i.a().currentTimeMillis());
                    this.j.put(a2, attemptData);
                }
                max = attemptData.b + (((long) Math.max((workSpec.k - attemptData.f2116a) - 5, 0)) * 30000);
            } catch (Throwable th) {
                throw th;
            }
        }
        return max;
    }
}
