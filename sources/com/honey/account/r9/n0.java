package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidConnectApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class n0 implements BasicMessageChannel.Reply {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidConnectApi.VoidResult f7568a;
    public final /* synthetic */ String b;

    public /* synthetic */ n0(AndroidConnectApi.VoidResult voidResult, String str) {
        this.f7568a = voidResult;
        this.b = str;
    }

    public final void reply(Object obj) {
        AndroidConnectApi.FlutterConnectApi.f(this.f7568a, this.b, obj);
    }
}
