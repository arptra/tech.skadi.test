package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidRingStarryNetApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class z1 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidRingStarryNetApi.StarryNetApi f7605a;

    public /* synthetic */ z1(AndroidRingStarryNetApi.StarryNetApi starryNetApi) {
        this.f7605a = starryNetApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        AndroidRingStarryNetApi.StarryNetApi.d(this.f7605a, obj, reply);
    }
}
