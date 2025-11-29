package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidConnectApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class m0 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidConnectApi.ConnectApi f7565a;

    public /* synthetic */ m0(AndroidConnectApi.ConnectApi connectApi) {
        this.f7565a = connectApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        AndroidConnectApi.ConnectApi.j(this.f7565a, obj, reply);
    }
}
