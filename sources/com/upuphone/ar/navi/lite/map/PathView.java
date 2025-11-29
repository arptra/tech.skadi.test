package com.upuphone.ar.navi.lite.map;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public class PathView extends View {

    /* renamed from: a  reason: collision with root package name */
    public PathOverlay f5779a = null;

    public PathView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onDraw(Canvas canvas) {
        this.f5779a.a(canvas);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    public void setView(PathOverlay pathOverlay) {
        this.f5779a = pathOverlay;
    }
}
