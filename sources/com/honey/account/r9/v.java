package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidAppApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class v implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidAppApi.RouteGuardApi f7591a;

    public /* synthetic */ v(AndroidAppApi.RouteGuardApi routeGuardApi) {
        this.f7591a = routeGuardApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        AndroidAppApi.RouteGuardApi.c(this.f7591a, obj, reply);
    }
}
