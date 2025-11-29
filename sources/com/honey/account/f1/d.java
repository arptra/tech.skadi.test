package com.honey.account.f1;

import android.graphics.Canvas;
import com.google.android.material.canvas.CanvasCompat;
import com.google.android.material.carousel.MaskableFrameLayout;

public final /* synthetic */ class d implements CanvasCompat.CanvasOperation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MaskableFrameLayout f9725a;

    public /* synthetic */ d(MaskableFrameLayout maskableFrameLayout) {
        this.f9725a = maskableFrameLayout;
    }

    public final void run(Canvas canvas) {
        this.f9725a.lambda$dispatchDraw$1(canvas);
    }
}
