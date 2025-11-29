package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidAppApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class n implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidAppApi.AppApi f7567a;

    public /* synthetic */ n(AndroidAppApi.AppApi appApi) {
        this.f7567a = appApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        AndroidAppApi.AppApi.o(this.f7567a, obj, reply);
    }
}
