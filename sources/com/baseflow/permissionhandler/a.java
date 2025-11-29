package com.baseflow.permissionhandler;

import com.baseflow.permissionhandler.ServiceManager;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class a implements ServiceManager.SuccessCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f2403a;

    public /* synthetic */ a(MethodChannel.Result result) {
        this.f2403a = result;
    }

    public final void onSuccess(int i) {
        this.f2403a.success(Integer.valueOf(i));
    }
}
