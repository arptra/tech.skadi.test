package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidBindingDeviceApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class d0 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidBindingDeviceApi.BindingDeviceApi f7534a;

    public /* synthetic */ d0(AndroidBindingDeviceApi.BindingDeviceApi bindingDeviceApi) {
        this.f7534a = bindingDeviceApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        AndroidBindingDeviceApi.BindingDeviceApi.h(this.f7534a, obj, reply);
    }
}
