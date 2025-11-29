package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidAccountApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class a implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidAccountApi.AccountApi f7521a;

    public /* synthetic */ a(AndroidAccountApi.AccountApi accountApi) {
        this.f7521a = accountApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        AndroidAccountApi.AccountApi.c(this.f7521a, obj, reply);
    }
}
