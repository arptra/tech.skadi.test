package androidx.work.impl.foreground;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.RestrictTo;
import androidx.work.ForegroundInfo;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.ConstraintsState;
import androidx.work.impl.constraints.OnConstraintsStateChangedListener;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.constraints.WorkConstraintsTrackerKt;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.Job;

@RestrictTo
public class SystemForegroundDispatcher implements OnConstraintsStateChangedListener, ExecutionListener {
    public static final String k = Logger.i("SystemFgDispatcher");

    /* renamed from: a  reason: collision with root package name */
    public Context f2155a;
    public WorkManagerImpl b;
    public final TaskExecutor c;
    public final Object d = new Object();
    public WorkGenerationalId e;
    public final Map f;
    public final Map g;
    public final Map h;
    public final WorkConstraintsTracker i;
    public Callback j;

    public interface Callback {
        void a(int i, Notification notification);

        void c(int i, int i2, Notification notification);

        void d(int i);

        void stop();
    }

    public SystemForegroundDispatcher(Context context) {
        this.f2155a = context;
        WorkManagerImpl k2 = WorkManagerImpl.k(context);
        this.b = k2;
        this.c = k2.q();
        this.e = null;
        this.f = new LinkedHashMap();
        this.h = new HashMap();
        this.g = new HashMap();
        this.i = new WorkConstraintsTracker(this.b.o());
        this.b.m().e(this);
    }

    public static Intent e(Context context, WorkGenerationalId workGenerationalId, ForegroundInfo foregroundInfo) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction("ACTION_NOTIFY");
        intent.putExtra("KEY_NOTIFICATION_ID", foregroundInfo.c());
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", foregroundInfo.a());
        intent.putExtra("KEY_NOTIFICATION", foregroundInfo.b());
        intent.putExtra("KEY_WORKSPEC_ID", workGenerationalId.b());
        intent.putExtra("KEY_GENERATION", workGenerationalId.a());
        return intent;
    }

    public static Intent f(Context context, WorkGenerationalId workGenerationalId, ForegroundInfo foregroundInfo) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction("ACTION_START_FOREGROUND");
        intent.putExtra("KEY_WORKSPEC_ID", workGenerationalId.b());
        intent.putExtra("KEY_GENERATION", workGenerationalId.a());
        intent.putExtra("KEY_NOTIFICATION_ID", foregroundInfo.c());
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", foregroundInfo.a());
        intent.putExtra("KEY_NOTIFICATION", foregroundInfo.b());
        return intent;
    }

    public static Intent g(Context context) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction("ACTION_STOP_FOREGROUND");
        return intent;
    }

    public void c(WorkGenerationalId workGenerationalId, boolean z) {
        Map.Entry entry;
        synchronized (this.d) {
            try {
                Job job = ((WorkSpec) this.g.remove(workGenerationalId)) != null ? (Job) this.h.remove(workGenerationalId) : null;
                if (job != null) {
                    job.a((CancellationException) null);
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        ForegroundInfo foregroundInfo = (ForegroundInfo) this.f.remove(workGenerationalId);
        if (workGenerationalId.equals(this.e)) {
            if (this.f.size() > 0) {
                Iterator it = this.f.entrySet().iterator();
                Object next = it.next();
                while (true) {
                    entry = (Map.Entry) next;
                    if (!it.hasNext()) {
                        break;
                    }
                    next = it.next();
                }
                this.e = (WorkGenerationalId) entry.getKey();
                if (this.j != null) {
                    ForegroundInfo foregroundInfo2 = (ForegroundInfo) entry.getValue();
                    this.j.c(foregroundInfo2.c(), foregroundInfo2.a(), foregroundInfo2.b());
                    this.j.d(foregroundInfo2.c());
                }
            } else {
                this.e = null;
            }
        }
        Callback callback = this.j;
        if (foregroundInfo != null && callback != null) {
            Logger e2 = Logger.e();
            String str = k;
            e2.a(str, "Removing Notification (id: " + foregroundInfo.c() + ", workSpecId: " + workGenerationalId + ", notificationType: " + foregroundInfo.a());
            callback.d(foregroundInfo.c());
        }
    }

    public void d(WorkSpec workSpec, ConstraintsState constraintsState) {
        if (constraintsState instanceof ConstraintsState.ConstraintsNotMet) {
            String str = workSpec.f2184a;
            Logger e2 = Logger.e();
            String str2 = k;
            e2.a(str2, "Constraints unmet for WorkSpec " + str);
            this.b.u(WorkSpecKt.a(workSpec));
        }
    }

    public final void h(Intent intent) {
        Logger e2 = Logger.e();
        String str = k;
        e2.f(str, "Stopping foreground work for " + intent);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        if (stringExtra != null && !TextUtils.isEmpty(stringExtra)) {
            this.b.g(UUID.fromString(stringExtra));
        }
    }

    public final void i(Intent intent) {
        int i2 = 0;
        int intExtra = intent.getIntExtra("KEY_NOTIFICATION_ID", 0);
        int intExtra2 = intent.getIntExtra("KEY_FOREGROUND_SERVICE_TYPE", 0);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        WorkGenerationalId workGenerationalId = new WorkGenerationalId(stringExtra, intent.getIntExtra("KEY_GENERATION", 0));
        Notification notification = (Notification) intent.getParcelableExtra("KEY_NOTIFICATION");
        Logger e2 = Logger.e();
        String str = k;
        e2.a(str, "Notifying with (id:" + intExtra + ", workSpecId: " + stringExtra + ", notificationType :" + intExtra2 + ")");
        if (notification != null && this.j != null) {
            this.f.put(workGenerationalId, new ForegroundInfo(intExtra, notification, intExtra2));
            if (this.e == null) {
                this.e = workGenerationalId;
                this.j.c(intExtra, intExtra2, notification);
                return;
            }
            this.j.a(intExtra, notification);
            if (intExtra2 != 0) {
                for (Map.Entry value : this.f.entrySet()) {
                    i2 |= ((ForegroundInfo) value.getValue()).a();
                }
                ForegroundInfo foregroundInfo = (ForegroundInfo) this.f.get(this.e);
                if (foregroundInfo != null) {
                    this.j.c(foregroundInfo.c(), i2, foregroundInfo.b());
                }
            }
        }
    }

    public final void j(Intent intent) {
        Logger e2 = Logger.e();
        String str = k;
        e2.f(str, "Started foreground service " + intent);
        final String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        this.c.b(new Runnable() {
            public void run() {
                WorkSpec g = SystemForegroundDispatcher.this.b.m().g(stringExtra);
                if (g != null && g.i()) {
                    synchronized (SystemForegroundDispatcher.this.d) {
                        SystemForegroundDispatcher.this.g.put(WorkSpecKt.a(g), g);
                        SystemForegroundDispatcher systemForegroundDispatcher = SystemForegroundDispatcher.this;
                        SystemForegroundDispatcher.this.h.put(WorkSpecKt.a(g), WorkConstraintsTrackerKt.b(systemForegroundDispatcher.i, g, systemForegroundDispatcher.c.a(), SystemForegroundDispatcher.this));
                    }
                }
            }
        });
    }

    public void k(Intent intent) {
        Logger.e().f(k, "Stopping foreground service");
        Callback callback = this.j;
        if (callback != null) {
            callback.stop();
        }
    }

    public void l() {
        this.j = null;
        synchronized (this.d) {
            try {
                for (Job a2 : this.h.values()) {
                    a2.a((CancellationException) null);
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        this.b.m().p(this);
    }

    public void m(Intent intent) {
        String action = intent.getAction();
        if ("ACTION_START_FOREGROUND".equals(action)) {
            j(intent);
            i(intent);
        } else if ("ACTION_NOTIFY".equals(action)) {
            i(intent);
        } else if ("ACTION_CANCEL_WORK".equals(action)) {
            h(intent);
        } else if ("ACTION_STOP_FOREGROUND".equals(action)) {
            k(intent);
        }
    }

    public void n(Callback callback) {
        if (this.j != null) {
            Logger.e().c(k, "A callback already exists.");
        } else {
            this.j = callback;
        }
    }
}
