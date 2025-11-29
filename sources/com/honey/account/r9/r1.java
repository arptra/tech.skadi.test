package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidRingStarryNetApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class r1 implements BasicMessageChannel.Reply {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidRingStarryNetApi.VoidResult f7581a;
    public final /* synthetic */ String b;

    public /* synthetic */ r1(AndroidRingStarryNetApi.VoidResult voidResult, String str) {
        this.f7581a = voidResult;
        this.b = str;
    }

    public final void reply(Object obj) {
        AndroidRingStarryNetApi.ScanDeviceCallback.f(this.f7581a, this.b, obj);
    }
}
