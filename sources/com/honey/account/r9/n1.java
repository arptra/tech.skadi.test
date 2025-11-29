package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidRingStarryNetApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class n1 implements BasicMessageChannel.Reply {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidRingStarryNetApi.VoidResult f7569a;
    public final /* synthetic */ String b;

    public /* synthetic */ n1(AndroidRingStarryNetApi.VoidResult voidResult, String str) {
        this.f7569a = voidResult;
        this.b = str;
    }

    public final void reply(Object obj) {
        AndroidRingStarryNetApi.FlutterStarryNetApi.i(this.f7569a, this.b, obj);
    }
}
