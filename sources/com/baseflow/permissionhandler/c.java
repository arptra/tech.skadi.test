package com.baseflow.permissionhandler;

import com.baseflow.permissionhandler.PermissionManager;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class c implements PermissionManager.CheckPermissionsSuccessCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f2405a;

    public /* synthetic */ c(MethodChannel.Result result) {
        this.f2405a = result;
    }

    public final void onSuccess(int i) {
        this.f2405a.success(Integer.valueOf(i));
    }
}
