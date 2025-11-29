package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidLogApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class d1 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidLogApi.LogApi f7535a;

    public /* synthetic */ d1(AndroidLogApi.LogApi logApi) {
        this.f7535a = logApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        AndroidLogApi.LogApi.d(this.f7535a, obj, reply);
    }
}
