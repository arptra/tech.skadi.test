package com.upuphone.ar.navi.lite.model;

import java.util.ArrayList;

public class INavigationManager {
    public static INavigationManager b;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList f5784a = new ArrayList();

    public static INavigationManager b() {
        if (b == null) {
            b = new INavigationManager();
        }
        return b;
    }

    public boolean a(INavigation iNavigation) {
        return this.f5784a.add(iNavigation);
    }

    public ArrayList c() {
        return this.f5784a;
    }

    public boolean d(INavigation iNavigation) {
        return this.f5784a.remove(iNavigation);
    }
}
