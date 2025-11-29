package com.honey.account.fb;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi;

public final /* synthetic */ class m implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SharedPreferencesAsyncApi f7309a;

    public /* synthetic */ m(SharedPreferencesAsyncApi sharedPreferencesAsyncApi) {
        this.f7309a = sharedPreferencesAsyncApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        SharedPreferencesAsyncApi.Companion.m1707setUp$lambda22$lambda21(this.f7309a, obj, reply);
    }
}
