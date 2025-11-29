package com.scwang.smart.refresh.layout.api;

import android.view.View;
import com.scwang.smart.refresh.layout.constant.SpinnerStyle;
import com.scwang.smart.refresh.layout.listener.OnStateChangedListener;

public interface RefreshComponent extends OnStateChangedListener {
    void b(RefreshLayout refreshLayout, int i, int i2);

    void c(RefreshLayout refreshLayout, int i, int i2);

    void d(float f, int i, int i2);

    boolean e();

    int f(RefreshLayout refreshLayout, boolean z);

    void g(RefreshKernel refreshKernel, int i, int i2);

    SpinnerStyle getSpinnerStyle();

    View getView();

    void h(boolean z, float f, int i, int i2, int i3);

    void setPrimaryColors(int... iArr);
}
