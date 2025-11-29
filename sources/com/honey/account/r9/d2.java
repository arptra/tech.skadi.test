package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidSystemPropertyApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class d2 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidSystemPropertyApi.SystemPropertyApi f7536a;

    public /* synthetic */ d2(AndroidSystemPropertyApi.SystemPropertyApi systemPropertyApi) {
        this.f7536a = systemPropertyApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        AndroidSystemPropertyApi.SystemPropertyApi.f(this.f7536a, obj, reply);
    }
}
