package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidBindingDeviceApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class f0 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidBindingDeviceApi.BindingDeviceApi f7542a;

    public /* synthetic */ f0(AndroidBindingDeviceApi.BindingDeviceApi bindingDeviceApi) {
        this.f7542a = bindingDeviceApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        AndroidBindingDeviceApi.BindingDeviceApi.j(this.f7542a, obj, reply);
    }
}
