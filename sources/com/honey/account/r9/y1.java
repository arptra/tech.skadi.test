package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidRingStarryNetApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class y1 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidRingStarryNetApi.StarryNetApi f7602a;

    public /* synthetic */ y1(AndroidRingStarryNetApi.StarryNetApi starryNetApi) {
        this.f7602a = starryNetApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        AndroidRingStarryNetApi.StarryNetApi.f(this.f7602a, obj, reply);
    }
}
