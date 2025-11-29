package com.honey.account.q8;

import android.content.Intent;
import com.upuphone.xr.sapp.permission.PermissionFragment;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PermissionFragment f7497a;
    public final /* synthetic */ Intent b;

    public /* synthetic */ d(PermissionFragment permissionFragment, Intent intent) {
        this.f7497a = permissionFragment;
        this.b = intent;
    }

    public final void run() {
        PermissionFragment.o0(this.f7497a, this.b);
    }
}
