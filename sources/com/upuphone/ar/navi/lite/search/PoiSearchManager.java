package com.upuphone.ar.navi.lite.search;

import android.content.Context;
import com.upuphone.ar.navi.lite.base.PlaceBean;
import com.upuphone.ar.navi.lite.base.SearchModel;
import com.upuphone.ar.navi.lite.base.ULatLng;
import com.upuphone.ar.navi.lite.manger.ManagerUtils;
import com.upuphone.ar.navi.lite.model.IPlace;
import com.upuphone.xr.interconnect.common.INaviPoiCallback;

public class PoiSearchManager implements IPoiSeach {

    /* renamed from: a  reason: collision with root package name */
    public static PoiSearchManager f5801a;

    public static PoiSearchManager f() {
        if (f5801a == null) {
            f5801a = new PoiSearchManager();
        }
        return f5801a;
    }

    public float a(ULatLng uLatLng, ULatLng uLatLng2) {
        return g().a(uLatLng, uLatLng2);
    }

    public void b(Context context, String str, String str2, ULatLng uLatLng, int i, IPlace iPlace) {
        g().b(context, str, str2, uLatLng, i, iPlace);
    }

    public void c(Context context, ULatLng uLatLng, IPlace iPlace) {
        g().c(context, uLatLng, iPlace);
    }

    public void d(Context context, String str, String str2, String str3, ULatLng uLatLng, int i, boolean z, IPlace iPlace) {
        g().d(context, str, str2, str3, uLatLng, i, z, iPlace);
    }

    public int e() {
        return g().e();
    }

    public AbsPoiSearch g() {
        return ManagerUtils.getPoiSearchManager();
    }

    public SearchModel h(PlaceBean placeBean) {
        SearchModel searchModel = new SearchModel();
        searchModel.setLongitude(placeBean.getLongitude());
        searchModel.setLatitude(placeBean.getLatitude());
        searchModel.setAddress(placeBean.getAddress());
        searchModel.setAcode(placeBean.getPoiId());
        searchModel.setName(placeBean.getPoiName());
        searchModel.setCity(placeBean.getCity());
        searchModel.setDistrict(placeBean.getDistrict());
        searchModel.setDistance(placeBean.getDistance());
        return searchModel;
    }

    public boolean i(String str) {
        return g().f(str);
    }

    public void j(Context context, String str, INaviPoiCallback iNaviPoiCallback) {
        g().i(iNaviPoiCallback);
        g().g(context, str);
    }

    public void k(int i) {
        g().h(i);
    }
}
