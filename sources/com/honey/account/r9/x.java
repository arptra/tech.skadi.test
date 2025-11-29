package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidAppApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class x implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidAppApi.TipsApi f7597a;

    public /* synthetic */ x(AndroidAppApi.TipsApi tipsApi) {
        this.f7597a = tipsApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        AndroidAppApi.TipsApi.c(this.f7597a, obj, reply);
    }
}
