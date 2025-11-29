package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidSystemPropertyApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class e2 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidSystemPropertyApi.SystemPropertyApi f7540a;

    public /* synthetic */ e2(AndroidSystemPropertyApi.SystemPropertyApi systemPropertyApi) {
        this.f7540a = systemPropertyApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        AndroidSystemPropertyApi.SystemPropertyApi.e(this.f7540a, obj, reply);
    }
}
