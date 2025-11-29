package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidAppApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class z implements BasicMessageChannel.Reply {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidAppApi.VoidResult f7603a;
    public final /* synthetic */ String b;

    public /* synthetic */ z(AndroidAppApi.VoidResult voidResult, String str) {
        this.f7603a = voidResult;
        this.b = str;
    }

    public final void reply(Object obj) {
        AndroidAppApi.TipsFlutterApi.f(this.f7603a, this.b, obj);
    }
}
