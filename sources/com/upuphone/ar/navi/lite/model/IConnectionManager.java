package com.upuphone.ar.navi.lite.model;

import java.util.ArrayList;
import java.util.List;

public class IConnectionManager {
    public static IConnectionManager b;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList f5782a = new ArrayList();

    public static IConnectionManager c() {
        if (b == null) {
            b = new IConnectionManager();
        }
        return b;
    }

    public boolean a(IConnection iConnection) {
        return this.f5782a.add(iConnection);
    }

    public List b() {
        return this.f5782a;
    }

    public boolean d(IConnection iConnection) {
        return this.f5782a.remove(iConnection);
    }
}
