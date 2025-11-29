package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidRingStarryNetApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class s1 implements BasicMessageChannel.Reply {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidRingStarryNetApi.VoidResult f7584a;
    public final /* synthetic */ String b;

    public /* synthetic */ s1(AndroidRingStarryNetApi.VoidResult voidResult, String str) {
        this.f7584a = voidResult;
        this.b = str;
    }

    public final void reply(Object obj) {
        AndroidRingStarryNetApi.SendMessageCallback.c(this.f7584a, this.b, obj);
    }
}
