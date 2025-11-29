package com.baseflow.permissionhandler;

import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class i implements ErrorCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f2411a;

    public /* synthetic */ i(MethodChannel.Result result) {
        this.f2411a = result;
    }

    public final void a(String str, String str2) {
        this.f2411a.error(str, str2, (Object) null);
    }
}
