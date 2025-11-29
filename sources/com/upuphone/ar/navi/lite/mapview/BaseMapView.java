package com.upuphone.ar.navi.lite.mapview;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.upuphone.ar.navi.lite.R;
import com.upuphone.ar.navi.lite.base.ULatLng;
import com.upuphone.ar.navi.lite.base.ULocation;
import com.upuphone.ar.navi.lite.util.SensorEventHelper;

public class BaseMapView extends FrameLayout implements IMapOperator {

    /* renamed from: a  reason: collision with root package name */
    public HereMapView f5780a;

    public BaseMapView(@NonNull Context context) {
        super(context);
        e(context);
        g();
    }

    public void a(ULatLng uLatLng) {
        HereMapView hereMapView = this.f5780a;
        if (hereMapView != null) {
            hereMapView.i(uLatLng);
        }
    }

    public int b(ULatLng uLatLng, int i, int i2) {
        HereMapView hereMapView = this.f5780a;
        return hereMapView != null ? hereMapView.k(uLatLng, i, i2) : i;
    }

    public void c(ULatLng uLatLng) {
        HereMapView hereMapView = this.f5780a;
        if (hereMapView != null) {
            hereMapView.l(uLatLng);
        }
    }

    public void d() {
        HereMapView hereMapView = this.f5780a;
        if (hereMapView != null) {
            hereMapView.m();
        }
    }

    public final void e(Context context) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.navi_map_view_here_layout, this);
    }

    public void f() {
        HereMapView hereMapView = this.f5780a;
        if (hereMapView != null) {
            hereMapView.q();
        }
    }

    public final void g() {
        View findViewById = findViewById(R.id.c_map_view);
        if (findViewById instanceof HereMapView) {
            this.f5780a = (HereMapView) findViewById;
        }
    }

    public HereMapView getHereMapView() {
        return this.f5780a;
    }

    public void h(ULatLng uLatLng) {
        HereMapView hereMapView = this.f5780a;
        if (hereMapView != null) {
            hereMapView.y(uLatLng);
        }
    }

    public void i(Bundle bundle) {
        HereMapView hereMapView = this.f5780a;
        if (hereMapView != null) {
            hereMapView.B(bundle);
        }
    }

    public void j() {
        HereMapView hereMapView = this.f5780a;
        if (hereMapView != null) {
            hereMapView.onDestroy();
        }
    }

    public void k() {
        HereMapView hereMapView = this.f5780a;
        if (hereMapView != null) {
            hereMapView.onPause();
        }
    }

    public void l() {
        HereMapView hereMapView = this.f5780a;
        if (hereMapView != null) {
            hereMapView.onResume();
        }
    }

    public void m(Bundle bundle) {
        HereMapView hereMapView = this.f5780a;
        if (hereMapView != null) {
            hereMapView.onSaveInstanceState(bundle);
        }
    }

    public boolean n() {
        HereMapView hereMapView = this.f5780a;
        if (hereMapView != null) {
            return hereMapView.G(true);
        }
        return false;
    }

    public void o(ULocation uLocation, SensorEventHelper sensorEventHelper, boolean z, boolean z2, boolean z3) {
        HereMapView hereMapView = this.f5780a;
        if (hereMapView != null) {
            hereMapView.I(uLocation, sensorEventHelper, z, z2, z3);
        }
    }

    public void p(ULocation uLocation, boolean z, boolean z2) {
        HereMapView hereMapView = this.f5780a;
        if (hereMapView != null) {
            hereMapView.J(uLocation, z, z2);
        }
    }

    public void setCameraChangeListener(ICameraChangeListener iCameraChangeListener) {
        HereMapView hereMapView = this.f5780a;
        if (hereMapView != null) {
            hereMapView.setCameraChangeListener(iCameraChangeListener);
        }
    }

    public void setOnMarkerClickListener(IMarkerClick iMarkerClick) {
        HereMapView hereMapView = this.f5780a;
        if (hereMapView != null) {
            hereMapView.setOnMarkerClickListener(iMarkerClick);
        }
    }

    public void setPoiClickListener(IPoiClickListener iPoiClickListener) {
        HereMapView hereMapView = this.f5780a;
        if (hereMapView != null) {
            hereMapView.setPoiClickListener(iPoiClickListener);
        }
    }

    public BaseMapView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        e(context);
        g();
    }

    public BaseMapView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        e(context);
        g();
    }
}
