package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidAppUpdateApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class a0 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidAppUpdateApi.AppUpdateApi f7522a;

    public /* synthetic */ a0(AndroidAppUpdateApi.AppUpdateApi appUpdateApi) {
        this.f7522a = appUpdateApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        AndroidAppUpdateApi.AppUpdateApi.c(this.f7522a, obj, reply);
    }
}
