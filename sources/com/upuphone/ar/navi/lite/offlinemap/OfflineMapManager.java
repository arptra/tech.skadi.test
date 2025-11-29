package com.upuphone.ar.navi.lite.offlinemap;

import android.content.Context;
import com.upuphone.ar.navi.lite.manger.ManagerUtils;

public class OfflineMapManager implements IOfflineMap {

    /* renamed from: a  reason: collision with root package name */
    public static OfflineMapManager f5797a;

    public static OfflineMapManager b() {
        if (f5797a == null) {
            f5797a = new OfflineMapManager();
        }
        return f5797a;
    }

    public void a() {
        c().a();
    }

    public AbsOfflineMap c() {
        return ManagerUtils.getOfflineMapManager();
    }

    public String d(Context context) {
        return c().b(context);
    }

    public void e() {
        c().c();
    }

    public void f(Context context) {
        c().d(context);
    }

    public boolean g() {
        return c().f();
    }

    public void h() {
        c().g();
    }

    public void i() {
        c().h();
    }
}
