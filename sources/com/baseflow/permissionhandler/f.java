package com.baseflow.permissionhandler;

import com.baseflow.permissionhandler.PermissionManager;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class f implements PermissionManager.ShouldShowRequestPermissionRationaleSuccessCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f2408a;

    public /* synthetic */ f(MethodChannel.Result result) {
        this.f2408a = result;
    }

    public final void a(boolean z) {
        this.f2408a.success(Boolean.valueOf(z));
    }
}
