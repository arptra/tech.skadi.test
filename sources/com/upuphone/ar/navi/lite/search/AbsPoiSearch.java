package com.upuphone.ar.navi.lite.search;

import android.content.Context;
import com.upuphone.ar.navi.lite.base.ULatLng;
import com.upuphone.ar.navi.lite.model.IPlace;
import com.upuphone.xr.interconnect.common.INaviPoiCallback;

public abstract class AbsPoiSearch {

    /* renamed from: a  reason: collision with root package name */
    public int f5800a = 1;
    public INaviPoiCallback b;

    public abstract float a(ULatLng uLatLng, ULatLng uLatLng2);

    public abstract void b(Context context, String str, String str2, ULatLng uLatLng, int i, IPlace iPlace);

    public abstract void c(Context context, ULatLng uLatLng, IPlace iPlace);

    public abstract void d(Context context, String str, String str2, String str3, ULatLng uLatLng, int i, boolean z, IPlace iPlace);

    public int e() {
        return this.f5800a;
    }

    public boolean f(String str) {
        return "[位置]".equalsIgnoreCase(str);
    }

    public abstract void g(Context context, String str);

    public void h(int i) {
        this.f5800a = i;
    }

    public void i(INaviPoiCallback iNaviPoiCallback) {
        this.b = iNaviPoiCallback;
    }
}
