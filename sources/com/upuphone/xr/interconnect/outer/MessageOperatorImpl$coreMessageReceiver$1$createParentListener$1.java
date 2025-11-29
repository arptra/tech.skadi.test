package com.upuphone.xr.interconnect.outer;

import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.listener.MessageReceiver;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/upuphone/xr/interconnect/outer/MessageOperatorImpl$coreMessageReceiver$1$createParentListener$1", "Lcom/upuphone/xr/interconnect/listener/MessageReceiver;", "onMessageReceive", "", "msg", "Lcom/upuphone/xr/interconnect/entity/StarryNetMessage;", "Shared_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MessageOperatorImpl$coreMessageReceiver$1$createParentListener$1 extends MessageReceiver {
    final /* synthetic */ MessageOperatorImpl$coreMessageReceiver$1 this$0;

    public MessageOperatorImpl$coreMessageReceiver$1$createParentListener$1(MessageOperatorImpl$coreMessageReceiver$1 messageOperatorImpl$coreMessageReceiver$1) {
        this.this$0 = messageOperatorImpl$coreMessageReceiver$1;
    }

    public void onMessageReceive(@Nullable StarryNetMessage starryNetMessage) {
        this.this$0.callEachListener("handle message", new MessageOperatorImpl$coreMessageReceiver$1$createParentListener$1$onMessageReceive$1(starryNetMessage));
    }
}
