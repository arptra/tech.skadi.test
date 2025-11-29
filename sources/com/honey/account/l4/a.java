package com.honey.account.l4;

import com.here.sdk.core.GeoCoordinates;
import com.here.sdk.search.SearchCallback;
import com.here.sdk.search.SearchError;
import com.upuphone.ar.navi.lite.model.IPlace;
import com.upuphone.ar.navi.lite.search.HerePoiSearch;
import java.util.List;

public final /* synthetic */ class a implements SearchCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HerePoiSearch f4921a;
    public final /* synthetic */ GeoCoordinates b;
    public final /* synthetic */ IPlace c;

    public /* synthetic */ a(HerePoiSearch herePoiSearch, GeoCoordinates geoCoordinates, IPlace iPlace) {
        this.f4921a = herePoiSearch;
        this.b = geoCoordinates;
        this.c = iPlace;
    }

    public final void onSearchCompleted(SearchError searchError, List list) {
        this.f4921a.s(this.b, this.c, searchError, list);
    }
}
