package com.upuphone.ar.navi.lite.offlinemap;

import android.content.Context;
import com.upuphone.ar.navi.lite.util.CLog;
import com.upuphone.ar.navi.lite.util.DateUtils;
import java.util.Timer;
import java.util.TimerTask;

public abstract class AbsOfflineMap {
    public static final String g = ("NAVI-" + AbsOfflineMap.class.getSimpleName());

    /* renamed from: a  reason: collision with root package name */
    public Context f5793a;
    public int b = 0;
    public int c = 3;
    public Timer d = new Timer();
    public TimerTask e;
    public boolean f = true;

    public abstract void a();

    public String b(Context context) {
        String str = "/data/data/" + context.getPackageName() + "/files/" + "offlineMap";
        CLog.a(g, "[getSdCacheDir]: downloadOfflineMap! dataPath=" + str);
        return str;
    }

    public abstract void c();

    public abstract void d(Context context);

    public boolean e() {
        return DateUtils.b("02:00:00", "06:00:00");
    }

    public boolean f() {
        return this.f;
    }

    public abstract void g();

    public abstract void h();

    public void i(boolean z) {
        this.f = z;
    }
}
