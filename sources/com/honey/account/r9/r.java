package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidAppApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class r implements BasicMessageChannel.Reply {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidAppApi.VoidResult f7579a;
    public final /* synthetic */ String b;

    public /* synthetic */ r(AndroidAppApi.VoidResult voidResult, String str) {
        this.f7579a = voidResult;
        this.b = str;
    }

    public final void reply(Object obj) {
        AndroidAppApi.FlutterAppApi.e(this.f7579a, this.b, obj);
    }
}
