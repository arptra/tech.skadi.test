package com.upuphone.ar.navi.lite.naviview;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.upuphone.ar.navi.lite.R;
import com.upuphone.ar.navi.lite.base.ULatLng;
import com.upuphone.ar.navi.lite.base.ULocation;
import com.upuphone.ar.navi.lite.mapview.HereMapView;
import com.upuphone.ar.navi.lite.navi.NaviControlManager;
import com.upuphone.ar.navi.lite.util.NaviUtil;
import com.upuphone.ar.navi.lite.util.SensorEventHelper;

public class NaviView extends FrameLayout implements INaviView {
    public static final String c = ("NAVI-" + NaviView.class.getSimpleName());

    /* renamed from: a  reason: collision with root package name */
    public FrameLayout f5792a;
    public HereMapView b;

    public NaviView(@NonNull Context context) {
        super(context);
        e(context);
        h();
    }

    public void a(ULatLng uLatLng, int i) {
        HereMapView hereMapView = this.b;
        if (hereMapView != null) {
            hereMapView.j(uLatLng, i);
        }
    }

    public void b() {
        HereMapView hereMapView = this.b;
        if (hereMapView != null && hereMapView.isValid()) {
            this.b.m();
        }
    }

    public void c() {
        HereMapView hereMapView = this.b;
        if (hereMapView != null && hereMapView.isValid()) {
            this.b.onDestroy();
        }
    }

    public final void d() {
        this.f5792a = (FrameLayout) findViewById(R.id.map_view_layout);
        if (NaviUtil.u0()) {
            this.b = NaviControlManager.k().i().getHereMapNaviView();
        } else {
            this.b = new HereMapView(getContext().getApplicationContext());
        }
        this.b.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        ViewGroup viewGroup = (ViewGroup) this.b.getParent();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        this.f5792a.addView(this.b);
    }

    public final void e(Context context) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.navi_view_here_layout, this);
    }

    public void f() {
        HereMapView hereMapView = this.b;
        if (hereMapView != null) {
            hereMapView.q();
        }
    }

    public void g(int i, boolean z) {
    }

    public HereMapView getHereMapNaviView() {
        return this.b;
    }

    public boolean getTrafficstatus() {
        HereMapView hereMapView = this.b;
        if (hereMapView != null) {
            return hereMapView.getTrafficstatus();
        }
        return false;
    }

    public final void h() {
        d();
    }

    public void i() {
        HereMapView hereMapView = this.b;
        if (hereMapView != null) {
            hereMapView.w();
        }
    }

    public void j() {
        HereMapView hereMapView = this.b;
        if (hereMapView != null) {
            hereMapView.x();
        }
    }

    public void k(Bundle bundle) {
        if (this.b != null && !NaviUtil.u0()) {
            this.b.B(bundle);
        }
    }

    public void l() {
        HereMapView hereMapView = this.b;
        if (hereMapView != null) {
            hereMapView.onPause();
        }
    }

    public void m() {
        HereMapView hereMapView = this.b;
        if (hereMapView != null) {
            hereMapView.onResume();
        }
    }

    public boolean n(boolean z) {
        HereMapView hereMapView = this.b;
        if (hereMapView == null) {
            return false;
        }
        hereMapView.G(z);
        return false;
    }

    public void o(ULocation uLocation, SensorEventHelper sensorEventHelper, boolean z, boolean z2, boolean z3) {
        HereMapView hereMapView = this.b;
        if (hereMapView != null) {
            hereMapView.I(uLocation, sensorEventHelper, z, z2, z3);
        }
    }

    public void p(ULocation uLocation, boolean z, boolean z2) {
        HereMapView hereMapView = this.b;
        if (hereMapView != null) {
            hereMapView.J(uLocation, z, z2);
        }
    }

    public void setNaviMode(int i) {
    }

    public void setShowMode(int i) {
    }

    public NaviView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        e(context);
        h();
    }

    public NaviView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        e(context);
        h();
    }
}
