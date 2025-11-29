package com.honey.account.g4;

import android.view.View;
import com.upuphone.ar.navi.lite.fragment.NaviFragment;
import com.upuphone.ar.navi.lite.view.CustomDialog;

public final /* synthetic */ class e implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NaviFragment f4431a;
    public final /* synthetic */ CustomDialog b;

    public /* synthetic */ e(NaviFragment naviFragment, CustomDialog customDialog) {
        this.f4431a = naviFragment;
        this.b = customDialog;
    }

    public final void onClick(View view) {
        this.f4431a.B2(this.b, view);
    }
}
