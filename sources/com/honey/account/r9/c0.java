package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidApplicationApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class c0 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidApplicationApi.ApplicationApi f7530a;

    public /* synthetic */ c0(AndroidApplicationApi.ApplicationApi applicationApi) {
        this.f7530a = applicationApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        AndroidApplicationApi.ApplicationApi.c(this.f7530a, obj, reply);
    }
}
