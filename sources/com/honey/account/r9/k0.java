package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidConnectApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class k0 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidConnectApi.ConnectApi f7559a;

    public /* synthetic */ k0(AndroidConnectApi.ConnectApi connectApi) {
        this.f7559a = connectApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        AndroidConnectApi.ConnectApi.n(this.f7559a, obj, reply);
    }
}
