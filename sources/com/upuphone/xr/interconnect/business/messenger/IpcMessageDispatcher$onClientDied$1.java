package com.upuphone.xr.interconnect.business.messenger;

import com.upuphone.xr.interconnect.common.IMessageReceiver;
import com.upuphone.xr.interconnect.remote.BinderClient;
import com.upuphone.xr.interconnect.util.ObjectUtil;
import com.upuphone.xr.interconnect.util.collection.Buckets;
import com.upuphone.xr.interconnect.util.log.ILog;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nIpcMessageDispatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IpcMessageDispatcher.kt\ncom/upuphone/xr/interconnect/business/messenger/IpcMessageDispatcher$onClientDied$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,135:1\n1855#2,2:136\n*S KotlinDebug\n*F\n+ 1 IpcMessageDispatcher.kt\ncom/upuphone/xr/interconnect/business/messenger/IpcMessageDispatcher$onClientDied$1\n*L\n129#1:136,2\n*E\n"})
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class IpcMessageDispatcher$onClientDied$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ BinderClient $client;
    final /* synthetic */ IpcMessageDispatcher this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IpcMessageDispatcher$onClientDied$1(BinderClient binderClient, IpcMessageDispatcher ipcMessageDispatcher) {
        super(0);
        this.$client = binderClient;
        this.this$0 = ipcMessageDispatcher;
    }

    public final void invoke() {
        BinderClient binderClient = this.$client;
        Integer valueOf = binderClient != null ? Integer.valueOf(binderClient.getId()) : null;
        String access$getTag = this.this$0.getTag();
        ILog.d(access$getTag, "Removing receivers from " + valueOf + ".");
        if (valueOf != null) {
            Set<IMessageReceiver> remove = this.this$0.receiverBuckets.remove(valueOf);
            IpcMessageDispatcher ipcMessageDispatcher = this.this$0;
            for (IMessageReceiver asBinder : remove) {
                ipcMessageDispatcher.receiverIds.remove(ObjectUtil.getObjectId(asBinder.asBinder()));
            }
            String access$getTag2 = this.this$0.getTag();
            Buckets access$getReceiverBuckets$p = this.this$0.receiverBuckets;
            ILog.v(access$getTag2, "Receivers: " + access$getReceiverBuckets$p + ".");
        }
    }
}
