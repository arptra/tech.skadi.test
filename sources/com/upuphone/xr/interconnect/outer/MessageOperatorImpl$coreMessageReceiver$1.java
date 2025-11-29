package com.upuphone.xr.interconnect.outer;

import com.upuphone.xr.interconnect.common.IMessageTransport;
import com.upuphone.xr.interconnect.listener.ListenerAggregator;
import com.upuphone.xr.interconnect.listener.MessageReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\b\u0010\u0004\u001a\u00020\u0002H\u0016¨\u0006\u0005"}, d2 = {"com/upuphone/xr/interconnect/outer/MessageOperatorImpl$coreMessageReceiver$1", "Lcom/upuphone/xr/interconnect/listener/ListenerAggregator;", "Lcom/upuphone/xr/interconnect/listener/MessageReceiver;", "Lcom/upuphone/xr/interconnect/common/IMessageTransport;", "createParentListener", "Shared_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MessageOperatorImpl$coreMessageReceiver$1 extends ListenerAggregator<MessageReceiver, IMessageTransport> {
    public MessageOperatorImpl$coreMessageReceiver$1(String str, MessageOperatorImpl$coreMessageReceiver$2 messageOperatorImpl$coreMessageReceiver$2, Function1<? super Function1<? super IMessageTransport, Unit>, Unit> function1, MessageOperatorImpl$coreMessageReceiver$4 messageOperatorImpl$coreMessageReceiver$4, MessageOperatorImpl$coreMessageReceiver$5 messageOperatorImpl$coreMessageReceiver$5) {
        super("message receive", str, messageOperatorImpl$coreMessageReceiver$2, function1, messageOperatorImpl$coreMessageReceiver$4, messageOperatorImpl$coreMessageReceiver$5);
    }

    @NotNull
    public MessageReceiver createParentListener() {
        return new MessageOperatorImpl$coreMessageReceiver$1$createParentListener$1(this);
    }
}
