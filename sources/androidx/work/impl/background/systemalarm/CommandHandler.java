package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.RestrictTo;
import androidx.work.Clock;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.StartStopTokens;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.SystemAlarmDispatcher;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestrictTo
public class CommandHandler implements ExecutionListener {
    public static final String f = Logger.i("CommandHandler");

    /* renamed from: a  reason: collision with root package name */
    public final Context f2119a;
    public final Map b = new HashMap();
    public final Object c = new Object();
    public final Clock d;
    public final StartStopTokens e;

    public CommandHandler(Context context, Clock clock, StartStopTokens startStopTokens) {
        this.f2119a = context;
        this.d = clock;
        this.e = startStopTokens;
    }

    public static Intent a(Context context) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_CONSTRAINTS_CHANGED");
        return intent;
    }

    public static Intent b(Context context, WorkGenerationalId workGenerationalId) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_DELAY_MET");
        return r(intent, workGenerationalId);
    }

    public static Intent d(Context context, WorkGenerationalId workGenerationalId, boolean z) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_EXECUTION_COMPLETED");
        intent.putExtra("KEY_NEEDS_RESCHEDULE", z);
        return r(intent, workGenerationalId);
    }

    public static Intent e(Context context, WorkGenerationalId workGenerationalId) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_SCHEDULE_WORK");
        return r(intent, workGenerationalId);
    }

    public static Intent f(Context context, WorkGenerationalId workGenerationalId) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_STOP_WORK");
        return r(intent, workGenerationalId);
    }

    public static Intent g(Context context, String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_STOP_WORK");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public static boolean n(Bundle bundle, String... strArr) {
        if (bundle == null || bundle.isEmpty()) {
            return false;
        }
        for (String str : strArr) {
            if (bundle.get(str) == null) {
                return false;
            }
        }
        return true;
    }

    public static WorkGenerationalId q(Intent intent) {
        return new WorkGenerationalId(intent.getStringExtra("KEY_WORKSPEC_ID"), intent.getIntExtra("KEY_WORKSPEC_GENERATION", 0));
    }

    public static Intent r(Intent intent, WorkGenerationalId workGenerationalId) {
        intent.putExtra("KEY_WORKSPEC_ID", workGenerationalId.b());
        intent.putExtra("KEY_WORKSPEC_GENERATION", workGenerationalId.a());
        return intent;
    }

    public void c(WorkGenerationalId workGenerationalId, boolean z) {
        synchronized (this.c) {
            try {
                DelayMetCommandHandler delayMetCommandHandler = (DelayMetCommandHandler) this.b.remove(workGenerationalId);
                this.e.b(workGenerationalId);
                if (delayMetCommandHandler != null) {
                    delayMetCommandHandler.g(z);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void h(Intent intent, int i, SystemAlarmDispatcher systemAlarmDispatcher) {
        Logger e2 = Logger.e();
        String str = f;
        e2.a(str, "Handling constraints changed " + intent);
        new ConstraintsCommandHandler(this.f2119a, this.d, i, systemAlarmDispatcher).a();
    }

    public final void i(Intent intent, int i, SystemAlarmDispatcher systemAlarmDispatcher) {
        synchronized (this.c) {
            try {
                WorkGenerationalId q = q(intent);
                Logger e2 = Logger.e();
                String str = f;
                e2.a(str, "Handing delay met for " + q);
                if (!this.b.containsKey(q)) {
                    DelayMetCommandHandler delayMetCommandHandler = new DelayMetCommandHandler(this.f2119a, i, systemAlarmDispatcher, this.e.d(q));
                    this.b.put(q, delayMetCommandHandler);
                    delayMetCommandHandler.f();
                } else {
                    Logger e3 = Logger.e();
                    e3.a(str, "WorkSpec " + q + " is is already being handled for ACTION_DELAY_MET");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void j(Intent intent, int i) {
        WorkGenerationalId q = q(intent);
        boolean z = intent.getExtras().getBoolean("KEY_NEEDS_RESCHEDULE");
        Logger e2 = Logger.e();
        String str = f;
        e2.a(str, "Handling onExecutionCompleted " + intent + ", " + i);
        c(q, z);
    }

    public final void k(Intent intent, int i, SystemAlarmDispatcher systemAlarmDispatcher) {
        Logger e2 = Logger.e();
        String str = f;
        e2.a(str, "Handling reschedule " + intent + ", " + i);
        systemAlarmDispatcher.g().s();
    }

    public final void l(Intent intent, int i, SystemAlarmDispatcher systemAlarmDispatcher) {
        WorkGenerationalId q = q(intent);
        Logger e2 = Logger.e();
        String str = f;
        e2.a(str, "Handling schedule work for " + q);
        WorkDatabase p = systemAlarmDispatcher.g().p();
        p.beginTransaction();
        try {
            WorkSpec y = p.j().y(q.b());
            if (y == null) {
                Logger e3 = Logger.e();
                e3.k(str, "Skipping scheduling " + q + " because it's no longer in the DB");
            } else if (y.b.isFinished()) {
                Logger e4 = Logger.e();
                e4.k(str, "Skipping scheduling " + q + "because it is finished.");
                p.endTransaction();
            } else {
                long c2 = y.c();
                if (!y.i()) {
                    Logger e5 = Logger.e();
                    e5.a(str, "Setting up Alarms for " + q + "at " + c2);
                    Alarms.c(this.f2119a, p, q, c2);
                } else {
                    Logger e6 = Logger.e();
                    e6.a(str, "Opportunistically setting an alarm for " + q + "at " + c2);
                    Alarms.c(this.f2119a, p, q, c2);
                    systemAlarmDispatcher.f().c().execute(new SystemAlarmDispatcher.AddRunnable(systemAlarmDispatcher, a(this.f2119a), i));
                }
                p.setTransactionSuccessful();
                p.endTransaction();
            }
        } finally {
            p.endTransaction();
        }
    }

    public final void m(Intent intent, SystemAlarmDispatcher systemAlarmDispatcher) {
        List<StartStopToken> list;
        Bundle extras = intent.getExtras();
        String string = extras.getString("KEY_WORKSPEC_ID");
        if (extras.containsKey("KEY_WORKSPEC_GENERATION")) {
            int i = extras.getInt("KEY_WORKSPEC_GENERATION");
            list = new ArrayList<>(1);
            StartStopToken b2 = this.e.b(new WorkGenerationalId(string, i));
            if (b2 != null) {
                list.add(b2);
            }
        } else {
            list = this.e.c(string);
        }
        for (StartStopToken startStopToken : list) {
            Logger e2 = Logger.e();
            String str = f;
            e2.a(str, "Handing stopWork work for " + string);
            systemAlarmDispatcher.i().e(startStopToken);
            Alarms.a(this.f2119a, systemAlarmDispatcher.g().p(), startStopToken.a());
            systemAlarmDispatcher.c(startStopToken.a(), false);
        }
    }

    public boolean o() {
        boolean z;
        synchronized (this.c) {
            z = !this.b.isEmpty();
        }
        return z;
    }

    public void p(Intent intent, int i, SystemAlarmDispatcher systemAlarmDispatcher) {
        String action = intent.getAction();
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action)) {
            h(intent, i, systemAlarmDispatcher);
        } else if ("ACTION_RESCHEDULE".equals(action)) {
            k(intent, i, systemAlarmDispatcher);
        } else if (!n(intent.getExtras(), "KEY_WORKSPEC_ID")) {
            Logger e2 = Logger.e();
            String str = f;
            e2.c(str, "Invalid request for " + action + " , requires " + "KEY_WORKSPEC_ID" + " .");
        } else if ("ACTION_SCHEDULE_WORK".equals(action)) {
            l(intent, i, systemAlarmDispatcher);
        } else if ("ACTION_DELAY_MET".equals(action)) {
            i(intent, i, systemAlarmDispatcher);
        } else if ("ACTION_STOP_WORK".equals(action)) {
            m(intent, systemAlarmDispatcher);
        } else if ("ACTION_EXECUTION_COMPLETED".equals(action)) {
            j(intent, i);
        } else {
            Logger e3 = Logger.e();
            String str2 = f;
            e3.k(str2, "Ignoring intent " + intent);
        }
    }
}
