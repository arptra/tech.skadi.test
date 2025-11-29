package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidRingStarryNetApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class o1 implements BasicMessageChannel.Reply {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidRingStarryNetApi.VoidResult f7572a;
    public final /* synthetic */ String b;

    public /* synthetic */ o1(AndroidRingStarryNetApi.VoidResult voidResult, String str) {
        this.f7572a = voidResult;
        this.b = str;
    }

    public final void reply(Object obj) {
        AndroidRingStarryNetApi.FlutterStarryNetApi.f(this.f7572a, this.b, obj);
    }
}
