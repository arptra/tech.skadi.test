package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.os.PowerManager;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.background.systemalarm.SystemAlarmDispatcher;
import androidx.work.impl.constraints.ConstraintsState;
import androidx.work.impl.constraints.OnConstraintsStateChangedListener;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.constraints.WorkConstraintsTrackerKt;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.WorkTimer;
import com.honey.account.l0.a;
import com.honey.account.l0.b;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Job;

@RestrictTo
public class DelayMetCommandHandler implements OnConstraintsStateChangedListener, WorkTimer.TimeLimitExceededListener {
    public static final String o = Logger.i("DelayMetCommandHandler");

    /* renamed from: a  reason: collision with root package name */
    public final Context f2124a;
    public final int b;
    public final WorkGenerationalId c;
    public final SystemAlarmDispatcher d;
    public final WorkConstraintsTracker e;
    public final Object f = new Object();
    public int g = 0;
    public final Executor h;
    public final Executor i;
    public PowerManager.WakeLock j;
    public boolean k = false;
    public final StartStopToken l;
    public final CoroutineDispatcher m;
    public volatile Job n;

    public DelayMetCommandHandler(Context context, int i2, SystemAlarmDispatcher systemAlarmDispatcher, StartStopToken startStopToken) {
        this.f2124a = context;
        this.b = i2;
        this.d = systemAlarmDispatcher;
        this.c = startStopToken.a();
        this.l = startStopToken;
        Trackers o2 = systemAlarmDispatcher.g().o();
        this.h = systemAlarmDispatcher.f().d();
        this.i = systemAlarmDispatcher.f().c();
        this.m = systemAlarmDispatcher.f().a();
        this.e = new WorkConstraintsTracker(o2);
    }

    public void a(WorkGenerationalId workGenerationalId) {
        Logger e2 = Logger.e();
        String str = o;
        e2.a(str, "Exceeded time limits on execution for " + workGenerationalId);
        this.h.execute(new a(this));
    }

    public void d(WorkSpec workSpec, ConstraintsState constraintsState) {
        if (constraintsState instanceof ConstraintsState.ConstraintsMet) {
            this.h.execute(new b(this));
        } else {
            this.h.execute(new a(this));
        }
    }

    public final void e() {
        synchronized (this.f) {
            try {
                if (this.n != null) {
                    this.n.a((CancellationException) null);
                }
                this.d.h().b(this.c);
                PowerManager.WakeLock wakeLock = this.j;
                if (wakeLock != null && wakeLock.isHeld()) {
                    Logger e2 = Logger.e();
                    String str = o;
                    e2.a(str, "Releasing wakelock " + this.j + "for WorkSpec " + this.c);
                    this.j.release();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void f() {
        String b2 = this.c.b();
        Context context = this.f2124a;
        this.j = WakeLocks.b(context, b2 + " (" + this.b + ")");
        Logger e2 = Logger.e();
        String str = o;
        e2.a(str, "Acquiring wakelock " + this.j + "for WorkSpec " + b2);
        this.j.acquire();
        WorkSpec y = this.d.g().p().j().y(b2);
        if (y == null) {
            this.h.execute(new a(this));
            return;
        }
        boolean i2 = y.i();
        this.k = i2;
        if (!i2) {
            Logger e3 = Logger.e();
            e3.a(str, "No constraints for " + b2);
            this.h.execute(new b(this));
            return;
        }
        this.n = WorkConstraintsTrackerKt.b(this.e, y, this.m, this);
    }

    public void g(boolean z) {
        Logger e2 = Logger.e();
        String str = o;
        e2.a(str, "onExecuted " + this.c + ", " + z);
        e();
        if (z) {
            this.i.execute(new SystemAlarmDispatcher.AddRunnable(this.d, CommandHandler.e(this.f2124a, this.c), this.b));
        }
        if (this.k) {
            this.i.execute(new SystemAlarmDispatcher.AddRunnable(this.d, CommandHandler.a(this.f2124a), this.b));
        }
    }

    public final void h() {
        if (this.g == 0) {
            this.g = 1;
            Logger e2 = Logger.e();
            String str = o;
            e2.a(str, "onAllConstraintsMet for " + this.c);
            if (this.d.e().r(this.l)) {
                this.d.h().a(this.c, 600000, this);
            } else {
                e();
            }
        } else {
            Logger e3 = Logger.e();
            String str2 = o;
            e3.a(str2, "Already started work for " + this.c);
        }
    }

    public final void i() {
        String b2 = this.c.b();
        if (this.g < 2) {
            this.g = 2;
            Logger e2 = Logger.e();
            String str = o;
            e2.a(str, "Stopping work for WorkSpec " + b2);
            this.i.execute(new SystemAlarmDispatcher.AddRunnable(this.d, CommandHandler.f(this.f2124a, this.c), this.b));
            if (this.d.e().k(this.c.b())) {
                Logger e3 = Logger.e();
                e3.a(str, "WorkSpec " + b2 + " needs to be rescheduled");
                this.i.execute(new SystemAlarmDispatcher.AddRunnable(this.d, CommandHandler.e(this.f2124a, this.c), this.b));
                return;
            }
            Logger e4 = Logger.e();
            e4.a(str, "Processor does not have WorkSpec " + b2 + ". No need to reschedule");
            return;
        }
        Logger e5 = Logger.e();
        String str2 = o;
        e5.a(str2, "Already stopped work for " + b2);
    }
}
