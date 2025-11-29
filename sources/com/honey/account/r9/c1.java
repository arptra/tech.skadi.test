package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidLogApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class c1 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidLogApi.LogApi f7531a;

    public /* synthetic */ c1(AndroidLogApi.LogApi logApi) {
        this.f7531a = logApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        AndroidLogApi.LogApi.a(this.f7531a, obj, reply);
    }
}
