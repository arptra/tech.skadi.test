package com.honey.account.fb;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.sharedpreferences.Messages;

public final /* synthetic */ class h implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Messages.SharedPreferencesApi f7304a;

    public /* synthetic */ h(Messages.SharedPreferencesApi sharedPreferencesApi) {
        this.f7304a = sharedPreferencesApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        Messages.SharedPreferencesApi.lambda$setUp$7(this.f7304a, obj, reply);
    }
}
