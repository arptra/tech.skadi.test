package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidAirGlassOtaApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class h implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidAirGlassOtaApi.AirGlassOtaApi f7549a;

    public /* synthetic */ h(AndroidAirGlassOtaApi.AirGlassOtaApi airGlassOtaApi) {
        this.f7549a = airGlassOtaApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        AndroidAirGlassOtaApi.AirGlassOtaApi.f(this.f7549a, obj, reply);
    }
}
