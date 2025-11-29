package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidBindingDeviceApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class e0 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidBindingDeviceApi.BindingDeviceApi f7538a;

    public /* synthetic */ e0(AndroidBindingDeviceApi.BindingDeviceApi bindingDeviceApi) {
        this.f7538a = bindingDeviceApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        AndroidBindingDeviceApi.BindingDeviceApi.i(this.f7538a, obj, reply);
    }
}
