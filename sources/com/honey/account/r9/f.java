package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidAirGlassControlApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class f implements BasicMessageChannel.Reply {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidAirGlassControlApi.VoidResult f7541a;
    public final /* synthetic */ String b;

    public /* synthetic */ f(AndroidAirGlassControlApi.VoidResult voidResult, String str) {
        this.f7541a = voidResult;
        this.b = str;
    }

    public final void reply(Object obj) {
        AndroidAirGlassControlApi.FlutterAirGlassControlApi.g(this.f7541a, this.b, obj);
    }
}
