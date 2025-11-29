package com.honey.account.n4;

import android.app.Activity;
import android.view.View;
import com.upuphone.ar.navi.lite.util.LocationUtil;
import com.upuphone.ar.navi.lite.view.PermissionDialog;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PermissionDialog f4956a;
    public final /* synthetic */ Activity b;
    public final /* synthetic */ int c;

    public /* synthetic */ b(PermissionDialog permissionDialog, Activity activity, int i) {
        this.f4956a = permissionDialog;
        this.b = activity;
        this.c = i;
    }

    public final void onClick(View view) {
        LocationUtil.i(this.f4956a, this.b, this.c, view);
    }
}
