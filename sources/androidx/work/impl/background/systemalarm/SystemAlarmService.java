package androidx.work.impl.background.systemalarm;

import android.content.Intent;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.LifecycleService;
import androidx.work.Logger;
import androidx.work.impl.background.systemalarm.SystemAlarmDispatcher;
import androidx.work.impl.utils.WakeLocks;

@RestrictTo
public class SystemAlarmService extends LifecycleService implements SystemAlarmDispatcher.CommandsCompletedListener {
    public static final String d = Logger.i("SystemAlarmService");
    public SystemAlarmDispatcher b;
    public boolean c;

    public void b() {
        this.c = true;
        Logger.e().a(d, "All commands completed in dispatcher");
        WakeLocks.a();
        stopSelf();
    }

    public final void e() {
        SystemAlarmDispatcher systemAlarmDispatcher = new SystemAlarmDispatcher(this);
        this.b = systemAlarmDispatcher;
        systemAlarmDispatcher.m(this);
    }

    public void onCreate() {
        super.onCreate();
        e();
        this.c = false;
    }

    public void onDestroy() {
        super.onDestroy();
        this.c = true;
        this.b.k();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        if (this.c) {
            Logger.e().f(d, "Re-initializing SystemAlarmDispatcher after a request to shut-down.");
            this.b.k();
            e();
            this.c = false;
        }
        if (intent == null) {
            return 3;
        }
        this.b.a(intent, i2);
        return 3;
    }
}
