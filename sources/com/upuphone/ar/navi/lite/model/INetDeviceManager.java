package com.upuphone.ar.navi.lite.model;

import java.util.ArrayList;
import java.util.List;

public class INetDeviceManager {
    public static INetDeviceManager b;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList f5785a = new ArrayList();

    public static INetDeviceManager b() {
        if (b == null) {
            b = new INetDeviceManager();
        }
        return b;
    }

    public boolean a(INetDevice iNetDevice) {
        return this.f5785a.add(iNetDevice);
    }

    public List c() {
        return this.f5785a;
    }

    public boolean d(INetDevice iNetDevice) {
        return this.f5785a.remove(iNetDevice);
    }
}
