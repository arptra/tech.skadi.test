package com.upuphone.ar.navi.lite.location;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import com.upuphone.ar.navi.lite.base.PlaceBean;
import com.upuphone.ar.navi.lite.base.ULocation;

public abstract class AbsLocation {
    public static final String l = ("NAVI-" + AbsLocation.class.getSimpleName());

    /* renamed from: a  reason: collision with root package name */
    public Context f5775a;
    public ULocation b;
    public PlaceBean c;
    public boolean d = false;
    public boolean e = false;
    public NotificationManager f = null;
    public boolean g = false;
    public int h = 0;
    public Notification i = null;
    public boolean j = false;
    public long k = 0;

    public abstract void b();

    public abstract void c(boolean z);

    public abstract void d(int i2, Notification notification);

    public abstract String e();

    public abstract String f(Context context);

    public abstract ULocation g();

    public int h() {
        return 0;
    }

    public abstract PlaceBean i();

    public abstract void j(Context context, boolean z);

    public abstract boolean k();

    public abstract boolean l();

    public abstract void m();

    public abstract void n(ULocation uLocation);

    public void o(int i2) {
    }

    public abstract void p();

    public abstract void q();

    public abstract void r();
}
