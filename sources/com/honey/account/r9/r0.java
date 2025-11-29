package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidDataTrackApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class r0 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidDataTrackApi.DataTrackApi f7580a;

    public /* synthetic */ r0(AndroidDataTrackApi.DataTrackApi dataTrackApi) {
        this.f7580a = dataTrackApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        AndroidDataTrackApi.DataTrackApi.b(this.f7580a, obj, reply);
    }
}
