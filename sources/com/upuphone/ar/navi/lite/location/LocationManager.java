package com.upuphone.ar.navi.lite.location;

import android.app.Notification;
import android.content.Context;
import com.upuphone.ar.navi.lite.base.PlaceBean;
import com.upuphone.ar.navi.lite.base.ULocation;
import com.upuphone.ar.navi.lite.manger.ManagerUtils;

public class LocationManager implements ILocationOperator {

    /* renamed from: a  reason: collision with root package name */
    public static volatile LocationManager f5776a;

    public static LocationManager f() {
        if (f5776a == null) {
            synchronized (LocationManager.class) {
                try {
                    if (f5776a == null) {
                        f5776a = new LocationManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f5776a;
    }

    public void a() {
        h().b();
    }

    public void b(boolean z) {
        h().c(z);
    }

    public void c(int i, Notification notification) {
        h().d(i, notification);
    }

    public String d() {
        return h().e();
    }

    public String e(Context context) {
        return h().f(context);
    }

    public ULocation g() {
        return h().g();
    }

    public AbsLocation h() {
        return ManagerUtils.getLocationManager();
    }

    public int i() {
        return h().h();
    }

    public PlaceBean j() {
        return h().i();
    }

    public void k(Context context, boolean z) {
        h().j(context, z);
    }

    public boolean l() {
        return h().k();
    }

    public boolean m() {
        return h().l();
    }

    public void n() {
        h().m();
    }

    public void o(ULocation uLocation) {
        h().n(uLocation);
    }

    public void p(int i) {
        h().o(i);
    }

    public void q() {
        h().p();
    }

    public void r() {
        h().q();
    }

    public void s() {
        h().r();
    }
}
