package com.honey.account.fb;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.sharedpreferences.Messages;

public final /* synthetic */ class e implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Messages.SharedPreferencesApi f7301a;

    public /* synthetic */ e(Messages.SharedPreferencesApi sharedPreferencesApi) {
        this.f7301a = sharedPreferencesApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        Messages.SharedPreferencesApi.lambda$setUp$4(this.f7301a, obj, reply);
    }
}
