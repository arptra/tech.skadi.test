package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidIntentApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class t0 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidIntentApi.IntentApi f7586a;

    public /* synthetic */ t0(AndroidIntentApi.IntentApi intentApi) {
        this.f7586a = intentApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        AndroidIntentApi.IntentApi.d(this.f7586a, obj, reply);
    }
}
