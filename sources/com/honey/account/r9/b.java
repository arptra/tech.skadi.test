package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidAccountApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class b implements BasicMessageChannel.Reply {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidAccountApi.VoidResult f7525a;
    public final /* synthetic */ String b;

    public /* synthetic */ b(AndroidAccountApi.VoidResult voidResult, String str) {
        this.f7525a = voidResult;
        this.b = str;
    }

    public final void reply(Object obj) {
        AndroidAccountApi.FlutterAccountApi.c(this.f7525a, this.b, obj);
    }
}
