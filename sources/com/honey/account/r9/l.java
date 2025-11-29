package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidAppApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class l implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidAppApi.AppApi f7561a;

    public /* synthetic */ l(AndroidAppApi.AppApi appApi) {
        this.f7561a = appApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        AndroidAppApi.AppApi.p(this.f7561a, obj, reply);
    }
}
