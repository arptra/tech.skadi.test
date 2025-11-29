package com.honey.account.i4;

import com.here.sdk.mapview.MapViewBase;
import com.here.sdk.mapview.PickMapContentResult;
import com.upuphone.ar.navi.lite.mapview.HereMapView;
import com.upuphone.ar.navi.lite.mapview.IPoiClickListener;

public final /* synthetic */ class d implements MapViewBase.PickMapContentCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IPoiClickListener f4841a;

    public /* synthetic */ d(IPoiClickListener iPoiClickListener) {
        this.f4841a = iPoiClickListener;
    }

    public final void onPickMapContent(PickMapContentResult pickMapContentResult) {
        HereMapView.s(this.f4841a, pickMapContentResult);
    }
}
