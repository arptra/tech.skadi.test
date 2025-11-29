package androidx.work.impl.background.greedy;

import androidx.annotation.RestrictTo;
import androidx.work.Clock;
import androidx.work.Logger;
import androidx.work.RunnableScheduler;
import androidx.work.impl.Scheduler;
import androidx.work.impl.model.WorkSpec;
import java.util.HashMap;
import java.util.Map;

@RestrictTo
public class DelayedWorkTracker {
    public static final String e = Logger.i("DelayedWorkTracker");

    /* renamed from: a  reason: collision with root package name */
    public final Scheduler f2113a;
    public final RunnableScheduler b;
    public final Clock c;
    public final Map d = new HashMap();

    public DelayedWorkTracker(Scheduler scheduler, RunnableScheduler runnableScheduler, Clock clock) {
        this.f2113a = scheduler;
        this.b = runnableScheduler;
        this.c = clock;
    }

    public void a(final WorkSpec workSpec, long j) {
        Runnable runnable = (Runnable) this.d.remove(workSpec.f2184a);
        if (runnable != null) {
            this.b.a(runnable);
        }
        AnonymousClass1 r0 = new Runnable() {
            public void run() {
                Logger e = Logger.e();
                String str = DelayedWorkTracker.e;
                e.a(str, "Scheduling work " + workSpec.f2184a);
                DelayedWorkTracker.this.f2113a.b(workSpec);
            }
        };
        this.d.put(workSpec.f2184a, r0);
        this.b.b(j - this.c.currentTimeMillis(), r0);
    }

    public void b(String str) {
        Runnable runnable = (Runnable) this.d.remove(str);
        if (runnable != null) {
            this.b.a(runnable);
        }
    }
}
