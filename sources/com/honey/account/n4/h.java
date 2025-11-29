package com.honey.account.n4;

import android.content.DialogInterface;
import com.upuphone.ar.navi.lite.util.PermissionUtil;

public final /* synthetic */ class h implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PermissionUtil.IPermissionSettings f4962a;

    public /* synthetic */ h(PermissionUtil.IPermissionSettings iPermissionSettings) {
        this.f4962a = iPermissionSettings;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f4962a.b();
    }
}
