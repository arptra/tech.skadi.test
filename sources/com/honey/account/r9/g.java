package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidAirGlassControlApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class g implements BasicMessageChannel.Reply {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidAirGlassControlApi.VoidResult f7545a;
    public final /* synthetic */ String b;

    public /* synthetic */ g(AndroidAirGlassControlApi.VoidResult voidResult, String str) {
        this.f7545a = voidResult;
        this.b = str;
    }

    public final void reply(Object obj) {
        AndroidAirGlassControlApi.FlutterAirGlassControlApi.h(this.f7545a, this.b, obj);
    }
}
