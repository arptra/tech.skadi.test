package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidConnectApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class o0 implements BasicMessageChannel.Reply {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidConnectApi.VoidResult f7571a;
    public final /* synthetic */ String b;

    public /* synthetic */ o0(AndroidConnectApi.VoidResult voidResult, String str) {
        this.f7571a = voidResult;
        this.b = str;
    }

    public final void reply(Object obj) {
        AndroidConnectApi.FlutterConnectApi.e(this.f7571a, this.b, obj);
    }
}
