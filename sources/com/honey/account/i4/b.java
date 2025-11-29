package com.honey.account.i4;

import com.here.sdk.core.Point2D;
import com.here.sdk.gestures.TapListener;
import com.upuphone.ar.navi.lite.mapview.HereMapView;
import com.upuphone.ar.navi.lite.mapview.IPoiClickListener;

public final /* synthetic */ class b implements TapListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HereMapView f4839a;
    public final /* synthetic */ IPoiClickListener b;

    public /* synthetic */ b(HereMapView hereMapView, IPoiClickListener iPoiClickListener) {
        this.f4839a = hereMapView;
        this.b = iPoiClickListener;
    }

    public final void onTap(Point2D point2D) {
        this.f4839a.v(this.b, point2D);
    }
}
