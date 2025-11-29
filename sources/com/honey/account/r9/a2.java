package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidRingStarryNetApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class a2 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidRingStarryNetApi.StarryNetApi f7524a;

    public /* synthetic */ a2(AndroidRingStarryNetApi.StarryNetApi starryNetApi) {
        this.f7524a = starryNetApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        AndroidRingStarryNetApi.StarryNetApi.i(this.f7524a, obj, reply);
    }
}
