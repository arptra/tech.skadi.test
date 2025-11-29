package com.honey.account.i4;

import com.here.sdk.mapview.MapViewBase;
import com.here.sdk.mapview.PickMapItemsResult;
import com.upuphone.ar.navi.lite.mapview.HereMapView;
import com.upuphone.ar.navi.lite.mapview.IMarkerClick;

public final /* synthetic */ class e implements MapViewBase.PickMapItemsCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HereMapView f4842a;
    public final /* synthetic */ IMarkerClick b;

    public /* synthetic */ e(HereMapView hereMapView, IMarkerClick iMarkerClick) {
        this.f4842a = hereMapView;
        this.b = iMarkerClick;
    }

    public final void onPickMapItems(PickMapItemsResult pickMapItemsResult) {
        this.f4842a.t(this.b, pickMapItemsResult);
    }
}
