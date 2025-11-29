package com.upuphone.xr.interconnect.business.messenger;

import com.upuphone.starrynetsdk.ability.relay.RemoteListener;
import com.upuphone.xr.interconnect.common.IMessageSendListener;
import com.upuphone.xr.interconnect.util.log.ILog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, d2 = {"com/upuphone/xr/interconnect/business/messenger/MessageTxProcessor$2$result$1$1", "Lcom/upuphone/starrynetsdk/ability/relay/RemoteListener;", "onFailure", "", "uniteCode", "", "code", "", "onSuccess", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MessageTxProcessor$2$result$1$1 implements RemoteListener {
    final /* synthetic */ int $identifier;
    final /* synthetic */ IMessageSendListener $it;
    final /* synthetic */ MessageTxProcessor this$0;

    public MessageTxProcessor$2$result$1$1(MessageTxProcessor messageTxProcessor, int i, IMessageSendListener iMessageSendListener) {
        this.this$0 = messageTxProcessor;
        this.$identifier = i;
        this.$it = iMessageSendListener;
    }

    public void onFailure(@Nullable String str, int i) {
        String access$getTag = this.this$0.getTag();
        int i2 = this.$identifier;
        IMessageSendListener iMessageSendListener = this.$it;
        ILog.d(access$getTag, "Calling #" + i2 + " send failure listener " + iMessageSendListener + ". code = " + i);
        this.this$0.safeCall(this.$it, new MessageTxProcessor$2$result$1$1$onFailure$1(this.$identifier, i));
    }

    public void onSuccess(@Nullable String str) {
        String access$getTag = this.this$0.getTag();
        int i = this.$identifier;
        IMessageSendListener iMessageSendListener = this.$it;
        ILog.d(access$getTag, "Calling #" + i + " send success listener " + iMessageSendListener + ".");
        this.this$0.safeCall(this.$it, new MessageTxProcessor$2$result$1$1$onSuccess$1(this.$identifier));
    }
}
