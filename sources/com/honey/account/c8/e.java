package com.honey.account.c8;

import android.view.View;
import com.upuphone.xr.sapp.adapter.FeedbackViewAdapter;

public final /* synthetic */ class e implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackViewAdapter f4208a;
    public final /* synthetic */ FeedbackViewAdapter.FeedbackViewHolder b;

    public /* synthetic */ e(FeedbackViewAdapter feedbackViewAdapter, FeedbackViewAdapter.FeedbackViewHolder feedbackViewHolder) {
        this.f4208a = feedbackViewAdapter;
        this.b = feedbackViewHolder;
    }

    public final void onClick(View view) {
        FeedbackViewAdapter.FeedbackViewHolder.c(this.f4208a, this.b, view);
    }
}
