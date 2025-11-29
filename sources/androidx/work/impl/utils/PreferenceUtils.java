package androidx.work.impl.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.Preference;

@RestrictTo
public class PreferenceUtils {

    /* renamed from: a  reason: collision with root package name */
    public final WorkDatabase f2235a;

    public PreferenceUtils(WorkDatabase workDatabase) {
        this.f2235a = workDatabase;
    }

    public static void d(Context context, SupportSQLiteDatabase supportSQLiteDatabase) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("androidx.work.util.preferences", 0);
        if (sharedPreferences.contains("reschedule_needed") || sharedPreferences.contains("last_cancel_all_time_ms")) {
            long j = 0;
            long j2 = sharedPreferences.getLong("last_cancel_all_time_ms", 0);
            if (sharedPreferences.getBoolean("reschedule_needed", false)) {
                j = 1;
            }
            supportSQLiteDatabase.f();
            try {
                supportSQLiteDatabase.W("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"last_cancel_all_time_ms", Long.valueOf(j2)});
                supportSQLiteDatabase.W("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"reschedule_needed", Long.valueOf(j)});
                sharedPreferences.edit().clear().apply();
                supportSQLiteDatabase.V();
            } finally {
                supportSQLiteDatabase.Z();
            }
        }
    }

    public long a() {
        Long b = this.f2235a.e().b("last_cancel_all_time_ms");
        if (b != null) {
            return b.longValue();
        }
        return 0;
    }

    public long b() {
        Long b = this.f2235a.e().b("last_force_stop_ms");
        if (b != null) {
            return b.longValue();
        }
        return 0;
    }

    public boolean c() {
        Long b = this.f2235a.e().b("reschedule_needed");
        return b != null && b.longValue() == 1;
    }

    public void e(long j) {
        this.f2235a.e().a(new Preference("last_cancel_all_time_ms", Long.valueOf(j)));
    }

    public void f(long j) {
        this.f2235a.e().a(new Preference("last_force_stop_ms", Long.valueOf(j)));
    }

    public void g(boolean z) {
        this.f2235a.e().a(new Preference("reschedule_needed", z));
    }
}
