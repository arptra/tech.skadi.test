package com.honey.account.c8;

import android.view.View;
import com.upuphone.xr.sapp.adapter.FeedBackFileAdapter;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedBackFileAdapter f4204a;
    public final /* synthetic */ int b;

    public /* synthetic */ c(FeedBackFileAdapter feedBackFileAdapter, int i) {
        this.f4204a = feedBackFileAdapter;
        this.b = i;
    }

    public final void onClick(View view) {
        FeedBackFileAdapter.n(this.f4204a, this.b, view);
    }
}
