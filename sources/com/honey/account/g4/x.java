package com.honey.account.g4;

import android.view.View;
import com.upuphone.ar.navi.lite.fragment.SearchFragment;
import com.upuphone.ar.navi.lite.view.CustomDialog;

public final /* synthetic */ class x implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchFragment f4460a;
    public final /* synthetic */ CustomDialog b;

    public /* synthetic */ x(SearchFragment searchFragment, CustomDialog customDialog) {
        this.f4460a = searchFragment;
        this.b = customDialog;
    }

    public final void onClick(View view) {
        this.f4460a.e3(this.b, view);
    }
}
