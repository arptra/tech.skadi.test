package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidAirGlassOtaApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class j implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidAirGlassOtaApi.AirGlassOtaApi f7555a;

    public /* synthetic */ j(AndroidAirGlassOtaApi.AirGlassOtaApi airGlassOtaApi) {
        this.f7555a = airGlassOtaApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        AndroidAirGlassOtaApi.AirGlassOtaApi.b(this.f7555a, obj, reply);
    }
}
