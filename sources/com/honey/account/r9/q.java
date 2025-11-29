package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidAppApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class q implements BasicMessageChannel.Reply {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidAppApi.VoidResult f7576a;
    public final /* synthetic */ String b;

    public /* synthetic */ q(AndroidAppApi.VoidResult voidResult, String str) {
        this.f7576a = voidResult;
        this.b = str;
    }

    public final void reply(Object obj) {
        AndroidAppApi.FlutterAppApi.d(this.f7576a, this.b, obj);
    }
}
