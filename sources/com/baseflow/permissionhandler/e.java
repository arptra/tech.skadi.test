package com.baseflow.permissionhandler;

import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class e implements ErrorCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f2407a;

    public /* synthetic */ e(MethodChannel.Result result) {
        this.f2407a = result;
    }

    public final void a(String str, String str2) {
        this.f2407a.error(str, str2, (Object) null);
    }
}
