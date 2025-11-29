package com.honey.account.u3;

import android.view.View;
import android.view.ViewTreeObserver;
import com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordHistoryDetailActivity;

public final /* synthetic */ class d0 implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f5163a;
    public final /* synthetic */ FastRecordHistoryDetailActivity b;

    public /* synthetic */ d0(View view, FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity) {
        this.f5163a = view;
        this.b = fastRecordHistoryDetailActivity;
    }

    public final void onGlobalLayout() {
        FastRecordHistoryDetailActivity.globalLayoutListener$lambda$1(this.f5163a, this.b);
    }
}
