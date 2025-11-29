package androidx.work.impl.background.systemalarm;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.impl.Scheduler;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;

@RestrictTo
public class SystemAlarmScheduler implements Scheduler {
    public static final String b = Logger.i("SystemAlarmScheduler");

    /* renamed from: a  reason: collision with root package name */
    public final Context f2130a;

    public boolean a() {
        return true;
    }

    public void b(WorkSpec... workSpecArr) {
        for (WorkSpec c : workSpecArr) {
            c(c);
        }
    }

    public final void c(WorkSpec workSpec) {
        Logger e = Logger.e();
        String str = b;
        e.a(str, "Scheduling work with workSpecId " + workSpec.f2184a);
        this.f2130a.startService(CommandHandler.e(this.f2130a, WorkSpecKt.a(workSpec)));
    }

    public void cancel(String str) {
        this.f2130a.startService(CommandHandler.g(this.f2130a, str));
    }
}
