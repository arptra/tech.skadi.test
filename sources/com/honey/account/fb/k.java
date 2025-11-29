package com.honey.account.fb;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi;

public final /* synthetic */ class k implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SharedPreferencesAsyncApi f7307a;

    public /* synthetic */ k(SharedPreferencesAsyncApi sharedPreferencesAsyncApi) {
        this.f7307a = sharedPreferencesAsyncApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        SharedPreferencesAsyncApi.Companion.m1705setUp$lambda18$lambda17(this.f7307a, obj, reply);
    }
}
