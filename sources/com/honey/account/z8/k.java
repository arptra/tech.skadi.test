package com.honey.account.z8;

import android.app.Activity;
import android.content.DialogInterface;
import com.upuphone.xr.sapp.vm.RoleVprintViewModel;

public final /* synthetic */ class k implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Activity f7723a;

    public /* synthetic */ k(Activity activity) {
        this.f7723a = activity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        RoleVprintViewModel.h0(this.f7723a, dialogInterface, i);
    }
}
