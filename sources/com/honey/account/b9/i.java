package com.honey.account.b9;

import com.upuphone.xr.sapp.vu.ArSpaceStarterActivity;
import com.upuphone.xr.sapp.vu.arspace.OnRequestExitArSpaceListener;

public final /* synthetic */ class i implements OnRequestExitArSpaceListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArSpaceStarterActivity f7133a;

    public /* synthetic */ i(ArSpaceStarterActivity arSpaceStarterActivity) {
        this.f7133a = arSpaceStarterActivity;
    }

    public final void onRequestExit(boolean z) {
        ArSpaceStarterActivity.R0(this.f7133a, z);
    }
}
