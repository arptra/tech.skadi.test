package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidAppApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class u implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidAppApi.GlassSettingApi f7588a;

    public /* synthetic */ u(AndroidAppApi.GlassSettingApi glassSettingApi) {
        this.f7588a = glassSettingApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        AndroidAppApi.GlassSettingApi.a(this.f7588a, obj, reply);
    }
}
