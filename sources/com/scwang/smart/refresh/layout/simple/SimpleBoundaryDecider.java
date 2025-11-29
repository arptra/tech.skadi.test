package com.scwang.smart.refresh.layout.simple;

import android.graphics.PointF;
import android.view.View;
import com.scwang.smart.refresh.layout.listener.ScrollBoundaryDecider;
import com.scwang.smart.refresh.layout.util.SmartUtil;

public class SimpleBoundaryDecider implements ScrollBoundaryDecider {

    /* renamed from: a  reason: collision with root package name */
    public PointF f9865a;
    public ScrollBoundaryDecider b;
    public boolean c = true;

    public boolean a(View view) {
        ScrollBoundaryDecider scrollBoundaryDecider = this.b;
        return scrollBoundaryDecider != null ? scrollBoundaryDecider.a(view) : SmartUtil.a(view, this.f9865a, this.c);
    }

    public boolean b(View view) {
        ScrollBoundaryDecider scrollBoundaryDecider = this.b;
        return scrollBoundaryDecider != null ? scrollBoundaryDecider.b(view) : SmartUtil.b(view, this.f9865a);
    }
}
