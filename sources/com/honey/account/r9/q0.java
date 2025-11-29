package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidConnectApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class q0 implements BasicMessageChannel.Reply {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidConnectApi.VoidResult f7577a;
    public final /* synthetic */ String b;

    public /* synthetic */ q0(AndroidConnectApi.VoidResult voidResult, String str) {
        this.f7577a = voidResult;
        this.b = str;
    }

    public final void reply(Object obj) {
        AndroidConnectApi.FlutterRing1ConnectApi.c(this.f7577a, this.b, obj);
    }
}
