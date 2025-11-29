package com.honey.account.e4;

import android.view.View;
import com.upuphone.ar.navi.lite.adapter.SearchAdapter;

public final /* synthetic */ class j implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchAdapter f4345a;
    public final /* synthetic */ View b;

    public /* synthetic */ j(SearchAdapter searchAdapter, View view) {
        this.f4345a = searchAdapter;
        this.b = view;
    }

    public final void onClick(View view) {
        this.f4345a.t(this.b, view);
    }
}
