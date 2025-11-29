package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidBindingDeviceApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class g0 implements BasicMessageChannel.Reply {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidBindingDeviceApi.Result f7546a;
    public final /* synthetic */ String b;

    public /* synthetic */ g0(AndroidBindingDeviceApi.Result result, String str) {
        this.f7546a = result;
        this.b = str;
    }

    public final void reply(Object obj) {
        AndroidBindingDeviceApi.FlutterRing2ConnectApi.d(this.f7546a, this.b, obj);
    }
}
