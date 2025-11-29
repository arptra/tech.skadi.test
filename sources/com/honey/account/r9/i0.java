package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidConnectApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class i0 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidConnectApi.ConnectApi f7553a;

    public /* synthetic */ i0(AndroidConnectApi.ConnectApi connectApi) {
        this.f7553a = connectApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        AndroidConnectApi.ConnectApi.c(this.f7553a, obj, reply);
    }
}
