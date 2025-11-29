package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidLocationApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class z0 implements BasicMessageChannel.Reply {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidLocationApi.VoidResult f7604a;
    public final /* synthetic */ String b;

    public /* synthetic */ z0(AndroidLocationApi.VoidResult voidResult, String str) {
        this.f7604a = voidResult;
        this.b = str;
    }

    public final void reply(Object obj) {
        AndroidLocationApi.LocationResultApi.c(this.f7604a, this.b, obj);
    }
}
