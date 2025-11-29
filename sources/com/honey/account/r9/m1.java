package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidRingStarryNetApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class m1 implements BasicMessageChannel.Reply {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidRingStarryNetApi.VoidResult f7566a;
    public final /* synthetic */ String b;

    public /* synthetic */ m1(AndroidRingStarryNetApi.VoidResult voidResult, String str) {
        this.f7566a = voidResult;
        this.b = str;
    }

    public final void reply(Object obj) {
        AndroidRingStarryNetApi.FlutterStarryNetApi.g(this.f7566a, this.b, obj);
    }
}
