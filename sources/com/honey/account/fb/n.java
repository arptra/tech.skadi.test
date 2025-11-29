package com.honey.account.fb;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi;

public final /* synthetic */ class n implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SharedPreferencesAsyncApi f7310a;

    public /* synthetic */ n(SharedPreferencesAsyncApi sharedPreferencesAsyncApi) {
        this.f7310a = sharedPreferencesAsyncApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        SharedPreferencesAsyncApi.Companion.m1708setUp$lambda24$lambda23(this.f7310a, obj, reply);
    }
}
