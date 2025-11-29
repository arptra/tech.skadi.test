package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidIntentApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class u0 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidIntentApi.IntentApi f7589a;

    public /* synthetic */ u0(AndroidIntentApi.IntentApi intentApi) {
        this.f7589a = intentApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        AndroidIntentApi.IntentApi.a(this.f7589a, obj, reply);
    }
}
