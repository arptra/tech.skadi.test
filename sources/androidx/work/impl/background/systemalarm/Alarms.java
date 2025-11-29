package androidx.work.impl.background.systemalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.SystemIdInfoKt;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.utils.IdGenerator;
import com.meizu.common.widget.CircleProgressBar;
import com.xjsd.ai.assistant.protocol.VuiModelType;

@RestrictTo
class Alarms {

    /* renamed from: a  reason: collision with root package name */
    public static final String f2118a = Logger.i("Alarms");

    @RequiresApi
    public static class Api19Impl {
        @DoNotInline
        public static void a(AlarmManager alarmManager, int i, long j, PendingIntent pendingIntent) {
            alarmManager.setExact(i, j, pendingIntent);
        }
    }

    public static void a(Context context, WorkDatabase workDatabase, WorkGenerationalId workGenerationalId) {
        SystemIdInfoDao g = workDatabase.g();
        SystemIdInfo e = g.e(workGenerationalId);
        if (e != null) {
            b(context, workGenerationalId, e.c);
            Logger e2 = Logger.e();
            String str = f2118a;
            e2.a(str, "Removing SystemIdInfo for workSpecId (" + workGenerationalId + ")");
            g.c(workGenerationalId);
        }
    }

    public static void b(Context context, WorkGenerationalId workGenerationalId, int i) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(VuiModelType.ALARM);
        PendingIntent service = PendingIntent.getService(context, i, CommandHandler.b(context, workGenerationalId), 603979776);
        if (service != null && alarmManager != null) {
            Logger e = Logger.e();
            String str = f2118a;
            e.a(str, "Cancelling existing alarm with (workSpecId, systemId) (" + workGenerationalId + ", " + i + ")");
            alarmManager.cancel(service);
        }
    }

    public static void c(Context context, WorkDatabase workDatabase, WorkGenerationalId workGenerationalId, long j) {
        SystemIdInfoDao g = workDatabase.g();
        SystemIdInfo e = g.e(workGenerationalId);
        if (e != null) {
            b(context, workGenerationalId, e.c);
            d(context, workGenerationalId, e.c, j);
            return;
        }
        int c = new IdGenerator(workDatabase).c();
        g.d(SystemIdInfoKt.a(workGenerationalId, c));
        d(context, workGenerationalId, c, j);
    }

    public static void d(Context context, WorkGenerationalId workGenerationalId, int i, long j) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(VuiModelType.ALARM);
        PendingIntent service = PendingIntent.getService(context, i, CommandHandler.b(context, workGenerationalId), CircleProgressBar.RIM_COLOR_DEF);
        if (alarmManager != null) {
            Api19Impl.a(alarmManager, 0, j, service);
        }
    }
}
