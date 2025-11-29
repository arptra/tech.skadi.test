package com.honey.account.n4;

import android.view.View;
import com.upuphone.ar.navi.lite.util.NaviUtil;
import com.upuphone.ar.navi.lite.view.CustomDialog;

public final /* synthetic */ class f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CustomDialog f4960a;
    public final /* synthetic */ View.OnClickListener b;

    public /* synthetic */ f(CustomDialog customDialog, View.OnClickListener onClickListener) {
        this.f4960a = customDialog;
        this.b = onClickListener;
    }

    public final void onClick(View view) {
        NaviUtil.O0(this.f4960a, this.b, view);
    }
}
