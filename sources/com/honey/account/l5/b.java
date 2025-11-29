package com.honey.account.l5;

import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.upuphone.ar.translation.utils.RecycleHelper;

public final /* synthetic */ class b implements OnLoadMoreListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RecycleHelper f4925a;

    public /* synthetic */ b(RecycleHelper recycleHelper) {
        this.f4925a = recycleHelper;
    }

    public final void onLoadMore(RefreshLayout refreshLayout) {
        this.f4925a.e(refreshLayout);
    }
}
