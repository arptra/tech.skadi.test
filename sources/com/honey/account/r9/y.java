package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidAppApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class y implements BasicMessageChannel.Reply {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidAppApi.VoidResult f7600a;
    public final /* synthetic */ String b;

    public /* synthetic */ y(AndroidAppApi.VoidResult voidResult, String str) {
        this.f7600a = voidResult;
        this.b = str;
    }

    public final void reply(Object obj) {
        AndroidAppApi.TipsFlutterApi.e(this.f7600a, this.b, obj);
    }
}
