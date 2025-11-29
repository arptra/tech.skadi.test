package com.upuphone.ar.navi.lite.simulate;

import com.upuphone.ar.navi.lite.manger.ManagerUtils;

public class NaviSimulateManager implements INaviSimulate {

    /* renamed from: a  reason: collision with root package name */
    public static NaviSimulateManager f5806a;

    public static NaviSimulateManager d() {
        if (f5806a == null) {
            f5806a = new NaviSimulateManager();
        }
        return f5806a;
    }

    public void a() {
        c().a();
    }

    public void b() {
        c().b();
    }

    public final INaviSimulate c() {
        return ManagerUtils.getINaviSimulate();
    }
}
