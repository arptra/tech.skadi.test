package com.xjmz.myvu.flutter.pigeon.impl;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.listener.MessageReceiver;
import com.xjmz.myvu.flutter.pigeon.AndroidRing2MessageApi;
import com.xjmz.myvu.flutter.pigeon.impl.Ring2MessageApiHandler;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/xjmz/myvu/flutter/pigeon/impl/Ring2MessageApiHandler$createMessageReceiver$1", "Lcom/upuphone/xr/interconnect/listener/MessageReceiver;", "onMessageReceive", "", "msg", "Lcom/upuphone/xr/interconnect/entity/StarryNetMessage;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Ring2MessageApiHandler$createMessageReceiver$1 extends MessageReceiver {
    final /* synthetic */ String $appId;
    final /* synthetic */ Ring2MessageApiHandler this$0;

    public Ring2MessageApiHandler$createMessageReceiver$1(String str, Ring2MessageApiHandler ring2MessageApiHandler) {
        this.$appId = str;
        this.this$0 = ring2MessageApiHandler;
    }

    public void onMessageReceive(@Nullable StarryNetMessage starryNetMessage) {
        if (starryNetMessage == null) {
            ULog.Delegate delegate = ULog.f6446a;
            String str = this.$appId;
            delegate.g("Ring2MessageApiHandler", "接收到空消息 appId: " + str);
            return;
        }
        ULog.Delegate delegate2 = ULog.f6446a;
        String h = this.this$0.p(starryNetMessage);
        delegate2.g("Ring2MessageApiHandler", "接收到消息: " + h);
        AndroidRing2MessageApi.Ring2MessageReceiveApi g = this.this$0.o();
        if (g != null) {
            g.d(this.this$0.r(starryNetMessage), new Ring2MessageApiHandler.Ring2MessageResult());
        }
    }
}
