package com.upuphone.ar.navi.lite.search;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import com.here.sdk.core.GeoCoordinates;
import com.here.sdk.core.errors.InstantiationErrorException;
import com.here.sdk.search.Place;
import com.here.sdk.search.SearchCallback;
import com.here.sdk.search.SearchEngine;
import com.here.sdk.search.SearchError;
import com.here.sdk.search.SearchOptions;
import com.here.sdk.search.SuggestCallback;
import com.here.sdk.search.Suggestion;
import com.here.sdk.search.TextQuery;
import com.honey.account.l4.a;
import com.honey.account.l4.b;
import com.honey.account.l4.c;
import com.honey.account.l4.d;
import com.upuphone.ar.navi.lite.base.PlaceBean;
import com.upuphone.ar.navi.lite.base.ULatLng;
import com.upuphone.ar.navi.lite.base.ULocation;
import com.upuphone.ar.navi.lite.location.LocationManager;
import com.upuphone.ar.navi.lite.model.IPlace;
import com.upuphone.ar.navi.lite.navi.HereNaviManager;
import com.upuphone.ar.navi.lite.util.CLog;
import com.upuphone.xr.interconnect.common.INaviPoiCallback;
import com.upuphone.xr.interconnect.entity.PoiResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HerePoiSearch extends AbsPoiSearch {
    public static final String d = ("NAVI-" + HerePoiSearch.class.getSimpleName());
    public static HerePoiSearch e;
    public SearchEngine c;

    public HerePoiSearch() {
        try {
            this.c = new SearchEngine();
        } catch (InstantiationErrorException e2) {
            String str = d;
            CLog.b(str, "PoiSearchUtil() Initialization of SearchEngine failed: " + e2.error.name());
        }
    }

    public static HerePoiSearch p() {
        if (e == null) {
            e = new HerePoiSearch();
        }
        return e;
    }

    public float a(ULatLng uLatLng, ULatLng uLatLng2) {
        if (uLatLng == null || uLatLng2 == null) {
            return -1.0f;
        }
        return (float) new GeoCoordinates(uLatLng.latitude, uLatLng.longitude).distanceTo(new GeoCoordinates(uLatLng2.latitude, uLatLng2.longitude));
    }

    public void b(Context context, String str, String str2, ULatLng uLatLng, int i, IPlace iPlace) {
        GeoCoordinates geoCoordinates = new GeoCoordinates(uLatLng.latitude, uLatLng.longitude);
        SearchOptions searchOptions = new SearchOptions();
        searchOptions.languageCode = HereNaviManager.v0().y0();
        searchOptions.maxItems = 10;
        if (TextUtils.isEmpty(str2)) {
            String str3 = d;
            CLog.b(str3, "doInputquery() keyWord is empty." + str2);
            return;
        }
        this.c.suggest(new TextQuery(str2, new TextQuery.Area(geoCoordinates)), searchOptions, (SuggestCallback) new c(this, iPlace));
    }

    public void c(Context context, ULatLng uLatLng, IPlace iPlace) {
        GeoCoordinates geoCoordinates = new GeoCoordinates(uLatLng.latitude, uLatLng.longitude);
        SearchOptions searchOptions = new SearchOptions();
        searchOptions.languageCode = HereNaviManager.v0().y0();
        searchOptions.maxItems = 1;
        this.c.search(geoCoordinates, searchOptions, (SearchCallback) new a(this, geoCoordinates, iPlace));
    }

    public void d(Context context, String str, String str2, String str3, ULatLng uLatLng, int i, boolean z, IPlace iPlace) {
        String str4 = d;
        CLog.b(str4, "doSearchQuery city:" + str + " keyWord=" + str2 + " latLng=" + uLatLng.toString() + " page=" + i + " poiTypeCode=" + str3 + " sort=" + z + " currentPage=" + this.f5800a);
        if (TextUtils.isEmpty(str2)) {
            CLog.b(str4, "doSearchQuery() keyWord is empty." + str2);
            return;
        }
        TextQuery textQuery = new TextQuery(str2, new TextQuery.Area(new GeoCoordinates(uLatLng.latitude, uLatLng.longitude)));
        SearchOptions searchOptions = new SearchOptions();
        searchOptions.languageCode = HereNaviManager.v0().y0();
        searchOptions.maxItems = Integer.valueOf(i * this.f5800a * 10);
        CLog.b(str4, "doSearchQuery() searchOptions.maxItems:" + searchOptions.maxItems);
        this.c.search(textQuery, searchOptions, (SearchCallback) new d(this, iPlace));
    }

    public int e() {
        return this.f5800a;
    }

    public void g(Context context, String str) {
        if ("".equals(str)) {
            o();
        } else {
            x(context, str);
        }
    }

    public void h(int i) {
        this.f5800a = i;
    }

    public final void n(List list, List list2) {
        int i = (this.f5800a - 1) * 10;
        String str = d;
        CLog.b(str, "getPagePlace list.size():" + list.size() + " currentPage=" + this.f5800a + " startIndex=" + i);
        if (i >= list.size()) {
            CLog.b(str, "getPagePlace startIndex is inValid, no more man items can be searched.");
            return;
        }
        while (i < list.size()) {
            list2.add(q((Place) list.get(i)));
            i++;
        }
    }

    public final void o() {
        INaviPoiCallback iNaviPoiCallback = this.b;
        if (iNaviPoiCallback != null) {
            try {
                iNaviPoiCallback.poiCallback(new ArrayList());
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    public PlaceBean q(Place place) {
        PlaceBean placeBean = new PlaceBean();
        if (place != null) {
            ULocation g = LocationManager.f().g();
            int distanceTo = g != null ? (int) new GeoCoordinates(g.getLatitude(), g.getLongitude()).distanceTo(place.getGeoCoordinates()) : 0;
            placeBean.setAdCode(place.getId());
            placeBean.setAddress(place.getAddress().addressText);
            placeBean.setCity(place.getAddress().city);
            placeBean.setCityCode(place.getAddress().postalCode);
            placeBean.setDistrict(place.getAddress().district);
            placeBean.setErrorInfo("");
            placeBean.setLatitude(place.getGeoCoordinates().latitude);
            placeBean.setLongitude(place.getGeoCoordinates().longitude);
            placeBean.setPoiName(place.getTitle());
            placeBean.setProvince(place.getAddress().county);
            placeBean.setStreet(place.getAddress().street);
            placeBean.setCountry(place.getAddress().country);
            placeBean.setCountryCode(place.getAddress().countryCode);
            placeBean.setDistance(distanceTo);
            placeBean.setPoiId(place.getId());
            w(place, distanceTo);
        }
        return placeBean;
    }

    public final /* synthetic */ void r(IPlace iPlace, SearchError searchError, List list) {
        ArrayList arrayList = new ArrayList();
        if (searchError != null) {
            String str = d;
            CLog.b(str, "doInputquery Error:" + searchError.toString());
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Suggestion suggestion = (Suggestion) it.next();
                if (suggestion.getPlace() != null) {
                    arrayList.add(q(suggestion.getPlace()));
                }
            }
            list.clear();
        }
        if (iPlace != null) {
            iPlace.a(arrayList);
        }
    }

    public final /* synthetic */ void s(GeoCoordinates geoCoordinates, IPlace iPlace, SearchError searchError, List list) {
        ArrayList arrayList = new ArrayList();
        if (searchError != null) {
            String str = d;
            CLog.b(str, "doRegeocodeQuery() onSearchCompleted Error:" + searchError.toString());
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                PlaceBean q = q((Place) it.next());
                q.setLatitude(geoCoordinates.latitude);
                q.setLongitude(geoCoordinates.longitude);
                arrayList.add(q);
            }
            list.clear();
        }
        if (iPlace != null) {
            iPlace.a(arrayList);
        }
    }

    public final /* synthetic */ void t(IPlace iPlace, SearchError searchError, List list) {
        ArrayList arrayList = new ArrayList();
        if (searchError != null) {
            String str = d;
            CLog.b(str, "doSearchQuery() onSearchCompleted Error:" + searchError.toString());
        } else {
            n(list, arrayList);
            list.clear();
        }
        if (iPlace != null) {
            iPlace.a(arrayList);
        }
    }

    public final void v(List list) {
    }

    public void w(Place place, int i) {
    }

    public final void x(Context context, String str) {
        ULocation g = LocationManager.f().g();
        if (g == null) {
            o();
            return;
        }
        b(context, "", str, new ULatLng(g.getLatitude(), g.getLongitude()), 1, new b(this));
    }

    /* renamed from: y */
    public final void u(List list) {
        v(list);
        if (list == null) {
            o();
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            PlaceBean placeBean = (PlaceBean) list.get(i);
            PoiResult poiResult = new PoiResult(placeBean.getPoiName(), placeBean.getDistance(), placeBean.getAddress(), placeBean.getLatitude(), placeBean.getLongitude(), placeBean.getAdCode());
            String str = d;
            CLog.b(str, " voiceAssistantQueryResult() getName=" + poiResult.getName() + " distance=" + poiResult.getDistance());
            arrayList.add(poiResult);
        }
        try {
            INaviPoiCallback iNaviPoiCallback = this.b;
            if (iNaviPoiCallback != null) {
                iNaviPoiCallback.poiCallback(arrayList);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }
}
