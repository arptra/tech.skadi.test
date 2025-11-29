package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidLocationApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class y0 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidLocationApi.LocationApi f7601a;

    public /* synthetic */ y0(AndroidLocationApi.LocationApi locationApi) {
        this.f7601a = locationApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        AndroidLocationApi.LocationApi.h(this.f7601a, obj, reply);
    }
}
