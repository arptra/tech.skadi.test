package androidx.work.impl.utils;

import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.RunnableScheduler;
import androidx.work.impl.model.WorkGenerationalId;
import java.util.HashMap;
import java.util.Map;

@RestrictTo
public class WorkTimer {
    public static final String e = Logger.i("WorkTimer");

    /* renamed from: a  reason: collision with root package name */
    public final RunnableScheduler f2251a;
    public final Map b = new HashMap();
    public final Map c = new HashMap();
    public final Object d = new Object();

    @RestrictTo
    public interface TimeLimitExceededListener {
        void a(WorkGenerationalId workGenerationalId);
    }

    @RestrictTo
    public static class WorkTimerRunnable implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final WorkTimer f2252a;
        public final WorkGenerationalId b;

        public WorkTimerRunnable(WorkTimer workTimer, WorkGenerationalId workGenerationalId) {
            this.f2252a = workTimer;
            this.b = workGenerationalId;
        }

        public void run() {
            synchronized (this.f2252a.d) {
                try {
                    if (((WorkTimerRunnable) this.f2252a.b.remove(this.b)) != null) {
                        TimeLimitExceededListener timeLimitExceededListener = (TimeLimitExceededListener) this.f2252a.c.remove(this.b);
                        if (timeLimitExceededListener != null) {
                            timeLimitExceededListener.a(this.b);
                        }
                    } else {
                        Logger.e().a("WrkTimerRunnable", String.format("Timer with %s is already marked as complete.", new Object[]{this.b}));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public WorkTimer(RunnableScheduler runnableScheduler) {
        this.f2251a = runnableScheduler;
    }

    public void a(WorkGenerationalId workGenerationalId, long j, TimeLimitExceededListener timeLimitExceededListener) {
        synchronized (this.d) {
            Logger e2 = Logger.e();
            String str = e;
            e2.a(str, "Starting timer for " + workGenerationalId);
            b(workGenerationalId);
            WorkTimerRunnable workTimerRunnable = new WorkTimerRunnable(this, workGenerationalId);
            this.b.put(workGenerationalId, workTimerRunnable);
            this.c.put(workGenerationalId, timeLimitExceededListener);
            this.f2251a.b(j, workTimerRunnable);
        }
    }

    public void b(WorkGenerationalId workGenerationalId) {
        synchronized (this.d) {
            try {
                if (((WorkTimerRunnable) this.b.remove(workGenerationalId)) != null) {
                    Logger e2 = Logger.e();
                    String str = e;
                    e2.a(str, "Stopping timer for " + workGenerationalId);
                    this.c.remove(workGenerationalId);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
