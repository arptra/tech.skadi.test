package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidAppUpdateApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class b0 implements BasicMessageChannel.Reply {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidAppUpdateApi.VoidResult f7526a;
    public final /* synthetic */ String b;

    public /* synthetic */ b0(AndroidAppUpdateApi.VoidResult voidResult, String str) {
        this.f7526a = voidResult;
        this.b = str;
    }

    public final void reply(Object obj) {
        AndroidAppUpdateApi.FlutterAppUpdateApi.c(this.f7526a, this.b, obj);
    }
}
