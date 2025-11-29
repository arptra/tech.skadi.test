package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidRingStarryNetApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class v1 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidRingStarryNetApi.StarryNetApi f7593a;

    public /* synthetic */ v1(AndroidRingStarryNetApi.StarryNetApi starryNetApi) {
        this.f7593a = starryNetApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        AndroidRingStarryNetApi.StarryNetApi.k(this.f7593a, obj, reply);
    }
}
