package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidRingStarryNetApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class l1 implements BasicMessageChannel.Reply {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidRingStarryNetApi.VoidResult f7563a;
    public final /* synthetic */ String b;

    public /* synthetic */ l1(AndroidRingStarryNetApi.VoidResult voidResult, String str) {
        this.f7563a = voidResult;
        this.b = str;
    }

    public final void reply(Object obj) {
        AndroidRingStarryNetApi.FlutterStarryNetApi.h(this.f7563a, this.b, obj);
    }
}
