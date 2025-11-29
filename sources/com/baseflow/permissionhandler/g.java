package com.baseflow.permissionhandler;

import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class g implements ErrorCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f2409a;

    public /* synthetic */ g(MethodChannel.Result result) {
        this.f2409a = result;
    }

    public final void a(String str, String str2) {
        this.f2409a.error(str, str2, (Object) null);
    }
}
