package com.honey.account.o2;

import android.content.DialogInterface;
import android.webkit.PermissionRequest;
import com.honey.account.view.web.WebActivity$onCreate$2$1;

public final /* synthetic */ class b implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PermissionRequest f9216a;

    public /* synthetic */ b(PermissionRequest permissionRequest) {
        this.f9216a = permissionRequest;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        WebActivity$onCreate$2$1.onPermissionRequest$lambda$0(this.f9216a, dialogInterface, i);
    }
}
