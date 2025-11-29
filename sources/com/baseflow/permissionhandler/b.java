package com.baseflow.permissionhandler;

import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class b implements ErrorCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f2404a;

    public /* synthetic */ b(MethodChannel.Result result) {
        this.f2404a = result;
    }

    public final void a(String str, String str2) {
        this.f2404a.error(str, str2, (Object) null);
    }
}
