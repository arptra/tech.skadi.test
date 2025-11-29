package com.honey.account.i4;

import com.here.sdk.core.Point2D;
import com.here.sdk.gestures.TapListener;
import com.upuphone.ar.navi.lite.mapview.HereMapView;
import com.upuphone.ar.navi.lite.mapview.IMarkerClick;

public final /* synthetic */ class c implements TapListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HereMapView f4840a;
    public final /* synthetic */ IMarkerClick b;

    public /* synthetic */ c(HereMapView hereMapView, IMarkerClick iMarkerClick) {
        this.f4840a = hereMapView;
        this.b = iMarkerClick;
    }

    public final void onTap(Point2D point2D) {
        this.f4840a.u(this.b, point2D);
    }
}
