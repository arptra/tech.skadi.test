package androidx.work.impl.utils;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.ApplicationExitInfo;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteAccessPermException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteTableLockedException;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.RestrictTo;
import androidx.core.os.UserManagerCompat;
import androidx.core.util.Consumer;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabasePathHelper;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.model.WorkProgressDao;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import com.honey.account.p0.b;
import com.upuphone.runasone.uupcast.CaptureType;
import com.upuphone.runasone.uupcast.CastErrorCode;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestrictTo
public class ForceStopRunnable implements Runnable {
    public static final String e = Logger.i("ForceStopRunnable");
    public static final long f = TimeUnit.DAYS.toMillis(3650);

    /* renamed from: a  reason: collision with root package name */
    public final Context f2229a;
    public final WorkManagerImpl b;
    public final PreferenceUtils c;
    public int d = 0;

    @RestrictTo
    public static class BroadcastReceiver extends android.content.BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        public static final String f2230a = Logger.i("ForceStopRunnable$Rcvr");

        public void onReceive(Context context, Intent intent) {
            if (intent != null && "ACTION_FORCE_STOP_RESCHEDULE".equals(intent.getAction())) {
                Logger.e().j(f2230a, "Rescheduling alarm that keeps track of force-stops.");
                ForceStopRunnable.g(context);
            }
        }
    }

    public ForceStopRunnable(Context context, WorkManagerImpl workManagerImpl) {
        this.f2229a = context.getApplicationContext();
        this.b = workManagerImpl;
        this.c = workManagerImpl.l();
    }

    public static Intent c(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, BroadcastReceiver.class));
        intent.setAction("ACTION_FORCE_STOP_RESCHEDULE");
        return intent;
    }

    public static PendingIntent d(Context context, int i) {
        return PendingIntent.getBroadcast(context, -1, c(context), i);
    }

    public static void g(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(VuiModelType.ALARM);
        PendingIntent d2 = d(context, Build.VERSION.SDK_INT >= 31 ? 167772160 : CaptureType.CAPTURE_VIRTUAL_DISPLAY_ENABLE_MAGIC_WINDOW);
        long currentTimeMillis = System.currentTimeMillis() + f;
        if (alarmManager != null) {
            alarmManager.setExact(0, currentTimeMillis, d2);
        }
    }

    public boolean a() {
        boolean h = SystemJobScheduler.h(this.f2229a, this.b.p());
        WorkDatabase p = this.b.p();
        WorkSpecDao j = p.j();
        WorkProgressDao i = p.i();
        p.beginTransaction();
        try {
            List<WorkSpec> E = j.E();
            boolean z = E != null && !E.isEmpty();
            if (z) {
                for (WorkSpec workSpec : E) {
                    j.l(WorkInfo.State.ENQUEUED, workSpec.f2184a);
                    j.c(workSpec.f2184a, CastErrorCode.SOURCE_PEER_DEVICE_NOT_ATTACHED);
                    j.A(workSpec.f2184a, -1);
                }
            }
            i.b();
            p.setTransactionSuccessful();
            p.endTransaction();
            return z || h;
        } catch (Throwable th) {
            p.endTransaction();
            throw th;
        }
    }

    public void b() {
        boolean a2 = a();
        if (h()) {
            Logger.e().a(e, "Rescheduling Workers.");
            this.b.s();
            this.b.l().g(false);
        } else if (e()) {
            Logger.e().a(e, "Application was force-stopped, rescheduling.");
            this.b.s();
            this.c.f(this.b.i().a().currentTimeMillis());
        } else if (a2) {
            Logger.e().a(e, "Found unfinished work, scheduling it.");
            Schedulers.h(this.b.i(), this.b.p(), this.b.n());
        }
    }

    public boolean e() {
        try {
            int i = Build.VERSION.SDK_INT;
            PendingIntent d2 = d(this.f2229a, i >= 31 ? 570425344 : 536870912);
            if (i >= 30) {
                if (d2 != null) {
                    d2.cancel();
                }
                List a2 = ((ActivityManager) this.f2229a.getSystemService("activity")).getHistoricalProcessExitReasons((String) null, 0, 0);
                if (a2 != null && !a2.isEmpty()) {
                    long b2 = this.c.b();
                    for (int i2 = 0; i2 < a2.size(); i2++) {
                        ApplicationExitInfo a3 = b.a(a2.get(i2));
                        if (a3.getReason() == 10 && a3.getTimestamp() >= b2) {
                            return true;
                        }
                    }
                }
            } else if (d2 == null) {
                g(this.f2229a);
                return true;
            }
            return false;
        } catch (IllegalArgumentException | SecurityException e2) {
            Logger.e().l(e, "Ignoring exception", e2);
            return true;
        }
    }

    public boolean f() {
        Configuration i = this.b.i();
        if (TextUtils.isEmpty(i.c())) {
            Logger.e().a(e, "The default process name was not specified.");
            return true;
        }
        boolean b2 = ProcessUtils.b(this.f2229a, i);
        Logger e2 = Logger.e();
        String str = e;
        e2.a(str, "Is default app process = " + b2);
        return b2;
    }

    public boolean h() {
        return this.b.l().c();
    }

    public void i(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException unused) {
        }
    }

    public void run() {
        try {
            if (!f()) {
                this.b.r();
                return;
            }
            while (true) {
                WorkDatabasePathHelper.d(this.f2229a);
                Logger.e().a(e, "Performing cleanup operations.");
                b();
                break;
            }
            this.b.r();
        } catch (SQLiteException e2) {
            Logger.e().c(e, "Unexpected SQLite exception during migrations");
            IllegalStateException illegalStateException = new IllegalStateException("Unexpected SQLite exception during migrations", e2);
            Consumer e3 = this.b.i().e();
            if (e3 != null) {
                e3.accept(illegalStateException);
            } else {
                throw illegalStateException;
            }
        } catch (SQLiteAccessPermException | SQLiteCantOpenDatabaseException | SQLiteConstraintException | SQLiteDatabaseCorruptException | SQLiteDatabaseLockedException | SQLiteDiskIOException | SQLiteTableLockedException e4) {
            int i = this.d + 1;
            this.d = i;
            if (i >= 3) {
                String str = UserManagerCompat.a(this.f2229a) ? "The file system on the device is in a bad state. WorkManager cannot access the app's internal data store." : "WorkManager can't be accessed from direct boot, because credential encrypted storage isn't accessible.\nDon't access or initialise WorkManager from directAware components. See https://developer.android.com/training/articles/direct-boot";
                Logger e5 = Logger.e();
                String str2 = e;
                e5.d(str2, str, e4);
                IllegalStateException illegalStateException2 = new IllegalStateException(str, e4);
                Consumer e6 = this.b.i().e();
                if (e6 != null) {
                    Logger.e().b(str2, "Routing exception to the specified exception handler", illegalStateException2);
                    e6.accept(illegalStateException2);
                } else {
                    throw illegalStateException2;
                }
            } else {
                Logger e7 = Logger.e();
                String str3 = e;
                e7.b(str3, "Retrying after " + (((long) i) * 300), e4);
                i(((long) this.d) * 300);
            }
        } catch (Throwable th) {
            this.b.r();
            throw th;
        }
    }
}
