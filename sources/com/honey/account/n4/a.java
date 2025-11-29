package com.honey.account.n4;

import android.view.View;
import com.upuphone.ar.navi.lite.util.LocationUtil;
import com.upuphone.ar.navi.lite.view.PermissionDialog;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PermissionDialog f4955a;
    public final /* synthetic */ LocationUtil.LocationCallback b;

    public /* synthetic */ a(PermissionDialog permissionDialog, LocationUtil.LocationCallback locationCallback) {
        this.f4955a = permissionDialog;
        this.b = locationCallback;
    }

    public final void onClick(View view) {
        LocationUtil.h(this.f4955a, this.b, view);
    }
}
