package androidx.core.app;

import android.app.AlarmManager;
import android.app.PendingIntent;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

public final class AlarmManagerCompat {

    @RequiresApi
    public static class Api21Impl {
        @DoNotInline
        public static AlarmManager.AlarmClockInfo a(long j, PendingIntent pendingIntent) {
            return new AlarmManager.AlarmClockInfo(j, pendingIntent);
        }

        @DoNotInline
        public static void b(AlarmManager alarmManager, Object obj, PendingIntent pendingIntent) {
            alarmManager.setAlarmClock((AlarmManager.AlarmClockInfo) obj, pendingIntent);
        }
    }

    @RequiresApi
    public static class Api23Impl {
        @DoNotInline
        public static void a(AlarmManager alarmManager, int i, long j, PendingIntent pendingIntent) {
            alarmManager.setAndAllowWhileIdle(i, j, pendingIntent);
        }

        @DoNotInline
        public static void b(AlarmManager alarmManager, int i, long j, PendingIntent pendingIntent) {
            alarmManager.setExactAndAllowWhileIdle(i, j, pendingIntent);
        }
    }

    @RequiresApi
    public static class Api31Impl {
        @DoNotInline
        public static boolean a(AlarmManager alarmManager) {
            return alarmManager.canScheduleExactAlarms();
        }
    }

    public static void a(AlarmManager alarmManager, long j, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
        Api21Impl.b(alarmManager, Api21Impl.a(j, pendingIntent), pendingIntent2);
    }

    public static void b(AlarmManager alarmManager, int i, long j, PendingIntent pendingIntent) {
        Api23Impl.a(alarmManager, i, j, pendingIntent);
    }

    public static void c(AlarmManager alarmManager, int i, long j, PendingIntent pendingIntent) {
        alarmManager.setExact(i, j, pendingIntent);
    }

    public static void d(AlarmManager alarmManager, int i, long j, PendingIntent pendingIntent) {
        Api23Impl.b(alarmManager, i, j, pendingIntent);
    }
}
