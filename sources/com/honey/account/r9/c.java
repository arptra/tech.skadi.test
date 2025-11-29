package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidAirGlassControlApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class c implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidAirGlassControlApi.AirGlassControlApi f7529a;

    public /* synthetic */ c(AndroidAirGlassControlApi.AirGlassControlApi airGlassControlApi) {
        this.f7529a = airGlassControlApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        AndroidAirGlassControlApi.AirGlassControlApi.g(this.f7529a, obj, reply);
    }
}
