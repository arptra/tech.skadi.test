package com.honey.account.fb;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi;

public final /* synthetic */ class u implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SharedPreferencesAsyncApi f7317a;

    public /* synthetic */ u(SharedPreferencesAsyncApi sharedPreferencesAsyncApi) {
        this.f7317a = sharedPreferencesAsyncApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        SharedPreferencesAsyncApi.Companion.m1703setUp$lambda14$lambda13(this.f7317a, obj, reply);
    }
}
