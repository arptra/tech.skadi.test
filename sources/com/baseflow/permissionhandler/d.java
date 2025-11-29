package com.baseflow.permissionhandler;

import com.baseflow.permissionhandler.PermissionManager;
import io.flutter.plugin.common.MethodChannel;
import java.util.Map;

public final /* synthetic */ class d implements PermissionManager.RequestPermissionsSuccessCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f2406a;

    public /* synthetic */ d(MethodChannel.Result result) {
        this.f2406a = result;
    }

    public final void a(Map map) {
        this.f2406a.success(map);
    }
}
