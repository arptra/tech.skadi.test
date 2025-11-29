package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidRingStarryNetApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class t1 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidRingStarryNetApi.StarryNetApi f7587a;

    public /* synthetic */ t1(AndroidRingStarryNetApi.StarryNetApi starryNetApi) {
        this.f7587a = starryNetApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        AndroidRingStarryNetApi.StarryNetApi.b(this.f7587a, obj, reply);
    }
}
