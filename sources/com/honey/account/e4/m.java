package com.honey.account.e4;

import android.view.View;
import com.upuphone.ar.navi.lite.adapter.SearchCommonAdapter;

public final /* synthetic */ class m implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchCommonAdapter f4348a;
    public final /* synthetic */ int b;

    public /* synthetic */ m(SearchCommonAdapter searchCommonAdapter, int i) {
        this.f4348a = searchCommonAdapter;
        this.b = i;
    }

    public final void onClick(View view) {
        this.f4348a.h(this.b, view);
    }
}
