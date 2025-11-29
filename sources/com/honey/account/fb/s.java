package com.honey.account.fb;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi;

public final /* synthetic */ class s implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SharedPreferencesAsyncApi f7315a;

    public /* synthetic */ s(SharedPreferencesAsyncApi sharedPreferencesAsyncApi) {
        this.f7315a = sharedPreferencesAsyncApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        SharedPreferencesAsyncApi.Companion.m1701setUp$lambda10$lambda9(this.f7315a, obj, reply);
    }
}
