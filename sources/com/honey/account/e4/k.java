package com.honey.account.e4;

import android.view.View;
import com.upuphone.ar.navi.lite.adapter.SearchAdapter;

public final /* synthetic */ class k implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchAdapter f4346a;
    public final /* synthetic */ View b;

    public /* synthetic */ k(SearchAdapter searchAdapter, View view) {
        this.f4346a = searchAdapter;
        this.b = view;
    }

    public final void onClick(View view) {
        this.f4346a.u(this.b, view);
    }
}
