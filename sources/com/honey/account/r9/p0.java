package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidConnectApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class p0 implements BasicMessageChannel.Reply {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidConnectApi.VoidResult f7574a;
    public final /* synthetic */ String b;

    public /* synthetic */ p0(AndroidConnectApi.VoidResult voidResult, String str) {
        this.f7574a = voidResult;
        this.b = str;
    }

    public final void reply(Object obj) {
        AndroidConnectApi.FlutterConnectApi.g(this.f7574a, this.b, obj);
    }
}
