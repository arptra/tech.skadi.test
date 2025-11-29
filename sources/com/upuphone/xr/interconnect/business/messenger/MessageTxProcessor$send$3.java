package com.upuphone.xr.interconnect.business.messenger;

import com.upuphone.xr.interconnect.business.connect.PeerInfo;
import com.upuphone.xr.interconnect.common.IMessageSendListener;
import com.upuphone.xr.interconnect.util.log.ILog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class MessageTxProcessor$send$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ byte[] $data;
    final /* synthetic */ Integer $identifier;
    final /* synthetic */ IMessageSendListener $listener;
    final /* synthetic */ String $receiver;
    final /* synthetic */ String $receiverDeviceId;
    final /* synthetic */ String $sender;
    final /* synthetic */ String $text;
    final /* synthetic */ MessageTxProcessor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MessageTxProcessor$send$3(Integer num, MessageTxProcessor messageTxProcessor, String str, String str2, String str3, String str4, byte[] bArr, IMessageSendListener iMessageSendListener) {
        super(0);
        this.$identifier = num;
        this.this$0 = messageTxProcessor;
        this.$receiverDeviceId = str;
        this.$sender = str2;
        this.$receiver = str3;
        this.$text = str4;
        this.$data = bArr;
        this.$listener = iMessageSendListener;
    }

    public final void invoke() {
        Integer num = this.$identifier;
        int intValue = num != null ? num.intValue() : this.this$0.getIdSource();
        String access$getTag = this.this$0.getTag();
        ILog.d(access$getTag, "Sending tx remote message start identifier =" + intValue);
        PeerInfo peerInfo = this.this$0.peerDeviceStatusManager.getPeerInfo(this.$receiverDeviceId);
        if (peerInfo == null) {
            MessageTxProcessor messageTxProcessor = this.this$0;
            String str = this.$receiverDeviceId;
            IMessageSendListener iMessageSendListener = this.$listener;
            String access$getTag2 = messageTxProcessor.getTag();
            ILog.w(access$getTag2, "Cannot send message because device #" + str + " is not negotiated.");
            if (iMessageSendListener != null) {
                messageTxProcessor.safeCall(iMessageSendListener, new MessageTxProcessor$send$3$receiverInfo$1$1(intValue));
                return;
            }
            return;
        }
        this.this$0.send(intValue, peerInfo, this.$sender, this.$receiver, this.$text, this.$data, this.$listener);
    }
}
