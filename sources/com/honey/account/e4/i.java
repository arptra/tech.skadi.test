package com.honey.account.e4;

import android.view.View;
import com.upuphone.ar.navi.lite.adapter.SearchAdapter;

public final /* synthetic */ class i implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchAdapter f4344a;
    public final /* synthetic */ View b;

    public /* synthetic */ i(SearchAdapter searchAdapter, View view) {
        this.f4344a = searchAdapter;
        this.b = view;
    }

    public final void onClick(View view) {
        this.f4344a.s(this.b, view);
    }
}
