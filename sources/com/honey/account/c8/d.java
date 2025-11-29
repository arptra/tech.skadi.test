package com.honey.account.c8;

import android.view.View;
import com.upuphone.xr.sapp.adapter.FeedbackCommonAdapter;

public final /* synthetic */ class d implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackCommonAdapter f4206a;
    public final /* synthetic */ int b;

    public /* synthetic */ d(FeedbackCommonAdapter feedbackCommonAdapter, int i) {
        this.f4206a = feedbackCommonAdapter;
        this.b = i;
    }

    public final void onClick(View view) {
        FeedbackCommonAdapter.i(this.f4206a, this.b, view);
    }
}
