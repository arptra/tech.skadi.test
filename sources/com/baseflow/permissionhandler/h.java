package com.baseflow.permissionhandler;

import com.baseflow.permissionhandler.AppSettingsManager;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class h implements AppSettingsManager.OpenAppSettingsSuccessCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f2410a;

    public /* synthetic */ h(MethodChannel.Result result) {
        this.f2410a = result;
    }

    public final void a(boolean z) {
        this.f2410a.success(Boolean.valueOf(z));
    }
}
