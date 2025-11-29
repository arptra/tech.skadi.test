package com.scwang.smart.refresh.layout.api;

import android.animation.ValueAnimator;
import com.scwang.smart.refresh.layout.constant.RefreshState;

public interface RefreshKernel {
    ValueAnimator a(int i);

    RefreshLayout b();

    RefreshKernel c();

    RefreshKernel d(int i, boolean z);

    RefreshKernel e(RefreshComponent refreshComponent, int i);

    RefreshKernel f(RefreshState refreshState);
}
