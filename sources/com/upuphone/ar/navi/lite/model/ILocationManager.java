package com.upuphone.ar.navi.lite.model;

import java.util.ArrayList;
import java.util.List;

public class ILocationManager {
    public static ILocationManager b;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList f5783a = new ArrayList();

    public static ILocationManager b() {
        if (b == null) {
            b = new ILocationManager();
        }
        return b;
    }

    public boolean a(ILocation iLocation) {
        return this.f5783a.add(iLocation);
    }

    public List c() {
        return this.f5783a;
    }

    public boolean d(ILocation iLocation) {
        return this.f5783a.remove(iLocation);
    }
}
