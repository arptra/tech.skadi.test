package com.scwang.smart.refresh.layout.api;

import android.view.ViewGroup;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;

public interface RefreshLayout {
    RefreshLayout a(boolean z);

    boolean b();

    RefreshLayout c(OnLoadMoreListener onLoadMoreListener);

    RefreshLayout d(boolean z);

    ViewGroup getLayout();
}
