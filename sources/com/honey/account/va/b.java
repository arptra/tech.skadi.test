package com.honey.account.va;

import android.widget.CompoundButton;
import flyme.support.v7.view.PermissionViewHandlerImpl23;

public final /* synthetic */ class b implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PermissionViewHandlerImpl23 f7637a;
    public final /* synthetic */ String b;

    public /* synthetic */ b(PermissionViewHandlerImpl23 permissionViewHandlerImpl23, String str) {
        this.f7637a = permissionViewHandlerImpl23;
        this.b = str;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.f7637a.lambda$addGroupItemIntl$1(this.b, compoundButton, z);
    }
}
