package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidIntentApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class v0 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidIntentApi.IntentApi f7592a;

    public /* synthetic */ v0(AndroidIntentApi.IntentApi intentApi) {
        this.f7592a = intentApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        AndroidIntentApi.IntentApi.b(this.f7592a, obj, reply);
    }
}
