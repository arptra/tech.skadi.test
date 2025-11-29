package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidNavigatorRouteApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class e1 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidNavigatorRouteApi.NavigatorRouteApi f7539a;

    public /* synthetic */ e1(AndroidNavigatorRouteApi.NavigatorRouteApi navigatorRouteApi) {
        this.f7539a = navigatorRouteApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        AndroidNavigatorRouteApi.NavigatorRouteApi.c(this.f7539a, obj, reply);
    }
}
