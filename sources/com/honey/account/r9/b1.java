package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidLogApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class b1 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidLogApi.LogApi f7527a;

    public /* synthetic */ b1(AndroidLogApi.LogApi logApi) {
        this.f7527a = logApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        AndroidLogApi.LogApi.b(this.f7527a, obj, reply);
    }
}
