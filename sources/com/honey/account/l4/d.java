package com.honey.account.l4;

import com.here.sdk.search.SearchCallback;
import com.here.sdk.search.SearchError;
import com.upuphone.ar.navi.lite.model.IPlace;
import com.upuphone.ar.navi.lite.search.HerePoiSearch;
import java.util.List;

public final /* synthetic */ class d implements SearchCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HerePoiSearch f4924a;
    public final /* synthetic */ IPlace b;

    public /* synthetic */ d(HerePoiSearch herePoiSearch, IPlace iPlace) {
        this.f4924a = herePoiSearch;
        this.b = iPlace;
    }

    public final void onSearchCompleted(SearchError searchError, List list) {
        this.f4924a.t(this.b, searchError, list);
    }
}
