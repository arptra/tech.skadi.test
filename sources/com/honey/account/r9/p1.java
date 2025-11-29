package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidRingStarryNetApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class p1 implements BasicMessageChannel.Reply {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidRingStarryNetApi.VoidResult f7575a;
    public final /* synthetic */ String b;

    public /* synthetic */ p1(AndroidRingStarryNetApi.VoidResult voidResult, String str) {
        this.f7575a = voidResult;
        this.b = str;
    }

    public final void reply(Object obj) {
        AndroidRingStarryNetApi.ScanDeviceCallback.g(this.f7575a, this.b, obj);
    }
}
