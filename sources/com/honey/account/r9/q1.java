package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidRingStarryNetApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class q1 implements BasicMessageChannel.Reply {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidRingStarryNetApi.VoidResult f7578a;
    public final /* synthetic */ String b;

    public /* synthetic */ q1(AndroidRingStarryNetApi.VoidResult voidResult, String str) {
        this.f7578a = voidResult;
        this.b = str;
    }

    public final void reply(Object obj) {
        AndroidRingStarryNetApi.ScanDeviceCallback.e(this.f7578a, this.b, obj);
    }
}
