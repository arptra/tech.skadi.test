package com.honey.account.n4;

import android.app.Activity;
import android.content.DialogInterface;
import com.upuphone.ar.navi.lite.util.PermissionUtil;

public final /* synthetic */ class g implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PermissionUtil.IPermissionSettings f4961a;
    public final /* synthetic */ Activity b;
    public final /* synthetic */ int c;

    public /* synthetic */ g(PermissionUtil.IPermissionSettings iPermissionSettings, Activity activity, int i) {
        this.f4961a = iPermissionSettings;
        this.b = activity;
        this.c = i;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        PermissionUtil.d(this.f4961a, this.b, this.c, dialogInterface, i);
    }
}
