package com.honey.account.l4;

import com.here.sdk.search.SearchError;
import com.here.sdk.search.SuggestCallback;
import com.upuphone.ar.navi.lite.model.IPlace;
import com.upuphone.ar.navi.lite.search.HerePoiSearch;
import java.util.List;

public final /* synthetic */ class c implements SuggestCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HerePoiSearch f4923a;
    public final /* synthetic */ IPlace b;

    public /* synthetic */ c(HerePoiSearch herePoiSearch, IPlace iPlace) {
        this.f4923a = herePoiSearch;
        this.b = iPlace;
    }

    public final void onSuggestCompleted(SearchError searchError, List list) {
        this.f4923a.r(this.b, searchError, list);
    }
}
