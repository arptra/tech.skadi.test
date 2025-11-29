package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidAirGlassControlApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class e implements BasicMessageChannel.Reply {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidAirGlassControlApi.VoidResult f7537a;
    public final /* synthetic */ String b;

    public /* synthetic */ e(AndroidAirGlassControlApi.VoidResult voidResult, String str) {
        this.f7537a = voidResult;
        this.b = str;
    }

    public final void reply(Object obj) {
        AndroidAirGlassControlApi.FlutterAirGlassControlApi.f(this.f7537a, this.b, obj);
    }
}
