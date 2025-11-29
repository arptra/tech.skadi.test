package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.RestrictTo;
import androidx.work.Clock;
import androidx.work.Logger;
import androidx.work.impl.background.systemalarm.SystemAlarmDispatcher;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import java.util.ArrayList;
import java.util.List;

@RestrictTo
class ConstraintsCommandHandler {
    public static final String f = Logger.i("ConstraintsCmdHandler");

    /* renamed from: a  reason: collision with root package name */
    public final Context f2123a;
    public final Clock b;
    public final int c;
    public final SystemAlarmDispatcher d;
    public final WorkConstraintsTracker e;

    public ConstraintsCommandHandler(Context context, Clock clock, int i, SystemAlarmDispatcher systemAlarmDispatcher) {
        this.f2123a = context;
        this.b = clock;
        this.c = i;
        this.d = systemAlarmDispatcher;
        this.e = new WorkConstraintsTracker(systemAlarmDispatcher.g().o());
    }

    public void a() {
        List<WorkSpec> w = this.d.g().p().j().w();
        ConstraintProxy.a(this.f2123a, w);
        ArrayList<WorkSpec> arrayList = new ArrayList<>(w.size());
        long currentTimeMillis = this.b.currentTimeMillis();
        for (WorkSpec workSpec : w) {
            if (currentTimeMillis >= workSpec.c() && (!workSpec.i() || this.e.a(workSpec))) {
                arrayList.add(workSpec);
            }
        }
        for (WorkSpec workSpec2 : arrayList) {
            String str = workSpec2.f2184a;
            Intent b2 = CommandHandler.b(this.f2123a, WorkSpecKt.a(workSpec2));
            Logger e2 = Logger.e();
            String str2 = f;
            e2.a(str2, "Creating a delay_met command for workSpec with id (" + str + ")");
            this.d.f().c().execute(new SystemAlarmDispatcher.AddRunnable(this.d, b2, this.c));
        }
    }
}
