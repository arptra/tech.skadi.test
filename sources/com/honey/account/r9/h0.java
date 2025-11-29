package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidConnectApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class h0 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidConnectApi.ConnectApi f7550a;

    public /* synthetic */ h0(AndroidConnectApi.ConnectApi connectApi) {
        this.f7550a = connectApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        AndroidConnectApi.ConnectApi.f(this.f7550a, obj, reply);
    }
}
