package com.upuphone.xr.interconnect.business.messenger;

import com.upuphone.starrynetsdk.ability.relay.BypassSendListener;
import com.upuphone.xr.interconnect.common.IMessageSendListener;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"com/upuphone/xr/interconnect/business/messenger/MessageTxProcessor$sendRingMsg$1", "Lcom/upuphone/starrynetsdk/ability/relay/BypassSendListener;", "onFail", "", "code", "", "onSuccess", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MessageTxProcessor$sendRingMsg$1 implements BypassSendListener {
    final /* synthetic */ IMessageSendListener $listener;
    final /* synthetic */ int $msgId;

    public MessageTxProcessor$sendRingMsg$1(IMessageSendListener iMessageSendListener, int i) {
        this.$listener = iMessageSendListener;
        this.$msgId = i;
    }

    public void onFail(int i) {
        IMessageSendListener iMessageSendListener = this.$listener;
        if (iMessageSendListener != null) {
            iMessageSendListener.onFail(String.valueOf(this.$msgId), i);
        }
    }

    public void onSuccess() {
        IMessageSendListener iMessageSendListener = this.$listener;
        if (iMessageSendListener != null) {
            iMessageSendListener.onSuccess(String.valueOf(this.$msgId));
        }
    }
}
