package com.honey.account.c8;

import android.view.View;
import com.upuphone.xr.sapp.adapter.FeedBackFileAdapter;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedBackFileAdapter f4202a;
    public final /* synthetic */ int b;

    public /* synthetic */ b(FeedBackFileAdapter feedBackFileAdapter, int i) {
        this.f4202a = feedBackFileAdapter;
        this.b = i;
    }

    public final void onClick(View view) {
        FeedBackFileAdapter.m(this.f4202a, this.b, view);
    }
}
