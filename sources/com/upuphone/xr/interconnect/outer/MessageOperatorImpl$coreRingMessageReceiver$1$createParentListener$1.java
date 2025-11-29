package com.upuphone.xr.interconnect.outer;

import com.upuphone.xr.interconnect.entity.StarryNetRingMessage;
import com.upuphone.xr.interconnect.listener.RingMessageReceiver;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/upuphone/xr/interconnect/outer/MessageOperatorImpl$coreRingMessageReceiver$1$createParentListener$1", "Lcom/upuphone/xr/interconnect/listener/RingMessageReceiver;", "onMessageReceive", "", "msg", "Lcom/upuphone/xr/interconnect/entity/StarryNetRingMessage;", "Shared_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MessageOperatorImpl$coreRingMessageReceiver$1$createParentListener$1 extends RingMessageReceiver {
    final /* synthetic */ MessageOperatorImpl$coreRingMessageReceiver$1 this$0;

    public MessageOperatorImpl$coreRingMessageReceiver$1$createParentListener$1(MessageOperatorImpl$coreRingMessageReceiver$1 messageOperatorImpl$coreRingMessageReceiver$1) {
        this.this$0 = messageOperatorImpl$coreRingMessageReceiver$1;
    }

    public void onMessageReceive(@Nullable StarryNetRingMessage starryNetRingMessage) {
        this.this$0.callEachListener("handle ring message", new MessageOperatorImpl$coreRingMessageReceiver$1$createParentListener$1$onMessageReceive$1(starryNetRingMessage));
    }
}
