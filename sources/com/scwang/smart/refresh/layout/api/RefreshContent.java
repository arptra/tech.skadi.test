package com.scwang.smart.refresh.layout.api;

import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;
import com.scwang.smart.refresh.layout.listener.ScrollBoundaryDecider;

public interface RefreshContent {
    void a(MotionEvent motionEvent);

    void b(boolean z);

    ValueAnimator.AnimatorUpdateListener c(int i);

    void d(int i, int i2, int i3);

    boolean e();

    void f(ScrollBoundaryDecider scrollBoundaryDecider);

    void g(RefreshKernel refreshKernel, View view, View view2);

    View getView();

    View h();

    boolean i();
}
