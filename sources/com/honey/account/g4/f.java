package com.honey.account.g4;

import android.view.View;
import com.upuphone.ar.navi.lite.fragment.NaviFragment;
import com.upuphone.ar.navi.lite.view.CustomDialog;

public final /* synthetic */ class f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NaviFragment f4433a;
    public final /* synthetic */ CustomDialog b;

    public /* synthetic */ f(NaviFragment naviFragment, CustomDialog customDialog) {
        this.f4433a = naviFragment;
        this.b = customDialog;
    }

    public final void onClick(View view) {
        this.f4433a.C2(this.b, view);
    }
}
