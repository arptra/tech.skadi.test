package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidLogApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class a1 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidLogApi.LogApi f7523a;

    public /* synthetic */ a1(AndroidLogApi.LogApi logApi) {
        this.f7523a = logApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        AndroidLogApi.LogApi.n(this.f7523a, obj, reply);
    }
}
