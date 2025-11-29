package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidAppApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class w implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidAppApi.TipsApi f7594a;

    public /* synthetic */ w(AndroidAppApi.TipsApi tipsApi) {
        this.f7594a = tipsApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        AndroidAppApi.TipsApi.b(this.f7594a, obj, reply);
    }
}
