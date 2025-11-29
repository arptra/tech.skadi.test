package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidLocationApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class w0 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidLocationApi.LocationApi f7595a;

    public /* synthetic */ w0(AndroidLocationApi.LocationApi locationApi) {
        this.f7595a = locationApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        AndroidLocationApi.LocationApi.j(this.f7595a, obj, reply);
    }
}
