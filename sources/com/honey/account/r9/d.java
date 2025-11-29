package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidAirGlassControlApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class d implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidAirGlassControlApi.AirGlassControlApi f7533a;

    public /* synthetic */ d(AndroidAirGlassControlApi.AirGlassControlApi airGlassControlApi) {
        this.f7533a = airGlassControlApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        AndroidAirGlassControlApi.AirGlassControlApi.b(this.f7533a, obj, reply);
    }
}
