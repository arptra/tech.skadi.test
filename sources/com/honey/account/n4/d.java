package com.honey.account.n4;

import android.content.Context;
import android.view.View;
import com.upuphone.ar.navi.lite.model.ICheckPermission;
import com.upuphone.ar.navi.lite.util.NaviUtil;

public final /* synthetic */ class d implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f4958a;
    public final /* synthetic */ ICheckPermission b;
    public final /* synthetic */ Context c;

    public /* synthetic */ d(boolean z, ICheckPermission iCheckPermission, Context context) {
        this.f4958a = z;
        this.b = iCheckPermission;
        this.c = context;
    }

    public final void onClick(View view) {
        NaviUtil.M0(this.f4958a, this.b, this.c, view);
    }
}
