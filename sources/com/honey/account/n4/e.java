package com.honey.account.n4;

import android.view.View;
import com.upuphone.ar.navi.lite.util.NaviUtil;
import com.upuphone.ar.navi.lite.view.CustomDialog;

public final /* synthetic */ class e implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CustomDialog f4959a;
    public final /* synthetic */ View.OnClickListener b;

    public /* synthetic */ e(CustomDialog customDialog, View.OnClickListener onClickListener) {
        this.f4959a = customDialog;
        this.b = onClickListener;
    }

    public final void onClick(View view) {
        NaviUtil.N0(this.f4959a, this.b, view);
    }
}
