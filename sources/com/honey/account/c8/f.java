package com.honey.account.c8;

import android.view.View;
import com.upuphone.xr.sapp.adapter.FeedbackViewAdapter;

public final /* synthetic */ class f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackViewAdapter f4210a;
    public final /* synthetic */ FeedbackViewAdapter.FeedbackViewHolder b;

    public /* synthetic */ f(FeedbackViewAdapter feedbackViewAdapter, FeedbackViewAdapter.FeedbackViewHolder feedbackViewHolder) {
        this.f4210a = feedbackViewAdapter;
        this.b = feedbackViewHolder;
    }

    public final void onClick(View view) {
        FeedbackViewAdapter.FeedbackViewHolder.d(this.f4210a, this.b, view);
    }
}
