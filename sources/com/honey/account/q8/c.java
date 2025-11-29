package com.honey.account.q8;

import com.upuphone.xr.sapp.permission.PermissionFragment;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PermissionFragment f7496a;
    public final /* synthetic */ String[] b;

    public /* synthetic */ c(PermissionFragment permissionFragment, String[] strArr) {
        this.f7496a = permissionFragment;
        this.b = strArr;
    }

    public final void run() {
        PermissionFragment.v0(this.f7496a, this.b);
    }
}
