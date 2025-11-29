package com.upuphone.xr.interconnect.business.messenger;

import com.upuphone.xr.interconnect.common.IMessageReceiver;
import com.upuphone.xr.interconnect.util.collection.Buckets;
import com.upuphone.xr.interconnect.util.log.ILog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class IpcMessageDispatcher$transporter$1$unregisterMessageReceiver$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $binderId;
    final /* synthetic */ int $callingPid;
    final /* synthetic */ String $objectId;
    final /* synthetic */ IMessageReceiver $receiver;
    final /* synthetic */ IpcMessageDispatcher this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IpcMessageDispatcher$transporter$1$unregisterMessageReceiver$1(IpcMessageDispatcher ipcMessageDispatcher, int i, String str, String str2, IMessageReceiver iMessageReceiver) {
        super(0);
        this.this$0 = ipcMessageDispatcher;
        this.$callingPid = i;
        this.$objectId = str;
        this.$binderId = str2;
        this.$receiver = iMessageReceiver;
    }

    public final void invoke() {
        String access$getTag = this.this$0.getTag();
        int i = this.$callingPid;
        String str = this.$objectId;
        String str2 = this.$binderId;
        ILog.d(access$getTag, "Removing " + i + " receiver " + str + " #" + str2 + ".");
        if (!this.this$0.receiverIds.contains(this.$binderId)) {
            String access$getTag2 = this.this$0.getTag();
            String str3 = this.$binderId;
            ILog.d(access$getTag2, "#" + str3 + " has already been removed.");
            return;
        }
        this.this$0.receiverIds.remove(this.$binderId);
        this.this$0.receiverBuckets.remove(Integer.valueOf(this.$callingPid), this.$receiver);
        String access$getTag3 = this.this$0.getTag();
        Buckets access$getReceiverBuckets$p = this.this$0.receiverBuckets;
        ILog.v(access$getTag3, "Receivers: " + access$getReceiverBuckets$p + ".");
    }
}
