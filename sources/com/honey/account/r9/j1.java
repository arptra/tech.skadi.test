package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidRing2MessageApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class j1 implements BasicMessageChannel.Reply {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidRing2MessageApi.VoidResult f7557a;
    public final /* synthetic */ String b;

    public /* synthetic */ j1(AndroidRing2MessageApi.VoidResult voidResult, String str) {
        this.f7557a = voidResult;
        this.b = str;
    }

    public final void reply(Object obj) {
        AndroidRing2MessageApi.Ring2MessageReceiveApi.c(this.f7557a, this.b, obj);
    }
}
