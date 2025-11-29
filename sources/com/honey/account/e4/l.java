package com.honey.account.e4;

import android.view.View;
import com.upuphone.ar.navi.lite.adapter.SearchAdapter;

public final /* synthetic */ class l implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchAdapter f4347a;
    public final /* synthetic */ View b;

    public /* synthetic */ l(SearchAdapter searchAdapter, View view) {
        this.f4347a = searchAdapter;
        this.b = view;
    }

    public final void onClick(View view) {
        this.f4347a.x(this.b, view);
    }
}
