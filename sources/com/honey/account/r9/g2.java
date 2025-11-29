package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidViewGlassControlApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class g2 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidViewGlassControlApi.ViewGlassControlApi f7548a;

    public /* synthetic */ g2(AndroidViewGlassControlApi.ViewGlassControlApi viewGlassControlApi) {
        this.f7548a = viewGlassControlApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        AndroidViewGlassControlApi.ViewGlassControlApi.d(this.f7548a, obj, reply);
    }
}
