package com.honey.account.o2;

import android.content.DialogInterface;
import android.webkit.PermissionRequest;
import com.honey.account.view.web.WebActivity$onCreate$2$1;

public final /* synthetic */ class c implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PermissionRequest f9217a;

    public /* synthetic */ c(PermissionRequest permissionRequest) {
        this.f9217a = permissionRequest;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        WebActivity$onCreate$2$1.onPermissionRequest$lambda$1(this.f9217a, dialogInterface, i);
    }
}
