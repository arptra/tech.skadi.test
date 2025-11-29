package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidAirGlassOtaApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class i implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidAirGlassOtaApi.AirGlassOtaApi f7552a;

    public /* synthetic */ i(AndroidAirGlassOtaApi.AirGlassOtaApi airGlassOtaApi) {
        this.f7552a = airGlassOtaApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        AndroidAirGlassOtaApi.AirGlassOtaApi.e(this.f7552a, obj, reply);
    }
}
