package com.honey.account.c5;

import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.upuphone.ar.transcribe.utils.RecycleHelper;

public final /* synthetic */ class a implements OnLoadMoreListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RecycleHelper f4198a;

    public /* synthetic */ a(RecycleHelper recycleHelper) {
        this.f4198a = recycleHelper;
    }

    public final void onLoadMore(RefreshLayout refreshLayout) {
        this.f4198a.e(refreshLayout);
    }
}
