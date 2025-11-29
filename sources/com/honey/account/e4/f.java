package com.honey.account.e4;

import android.view.View;
import com.upuphone.ar.navi.lite.adapter.SearchAdapter;

public final /* synthetic */ class f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchAdapter f4341a;
    public final /* synthetic */ View b;

    public /* synthetic */ f(SearchAdapter searchAdapter, View view) {
        this.f4341a = searchAdapter;
        this.b = view;
    }

    public final void onClick(View view) {
        this.f4341a.v(this.b, view);
    }
}
