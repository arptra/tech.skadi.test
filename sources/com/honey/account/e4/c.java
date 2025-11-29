package com.honey.account.e4;

import android.view.View;
import com.upuphone.ar.navi.lite.adapter.HistoryListAdapter;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HistoryListAdapter f4338a;
    public final /* synthetic */ View b;

    public /* synthetic */ c(HistoryListAdapter historyListAdapter, View view) {
        this.f4338a = historyListAdapter;
        this.b = view;
    }

    public final void onClick(View view) {
        this.f4338a.p(this.b, view);
    }
}
