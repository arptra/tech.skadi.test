package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidDataTrackApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class s0 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidDataTrackApi.DataTrackApi f7583a;

    public /* synthetic */ s0(AndroidDataTrackApi.DataTrackApi dataTrackApi) {
        this.f7583a = dataTrackApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        AndroidDataTrackApi.DataTrackApi.a(this.f7583a, obj, reply);
    }
}
