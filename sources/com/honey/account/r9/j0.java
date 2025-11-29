package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidConnectApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class j0 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidConnectApi.ConnectApi f7556a;

    public /* synthetic */ j0(AndroidConnectApi.ConnectApi connectApi) {
        this.f7556a = connectApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        AndroidConnectApi.ConnectApi.o(this.f7556a, obj, reply);
    }
}
