package com.upuphone.xr.interconnect.business.messenger;

import com.upuphone.xr.interconnect.common.IMessageReceiver;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.ipc.IpcClientManager;
import com.upuphone.xr.interconnect.util.HostAlienCallExtKt;
import com.upuphone.xr.interconnect.util.log.ILog;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CompletableDeferred;

@SourceDebugExtension({"SMAP\nIpcMessageDispatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IpcMessageDispatcher.kt\ncom/upuphone/xr/interconnect/business/messenger/IpcMessageDispatcher$dispatch$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,135:1\n1855#2,2:136\n1855#2,2:138\n*S KotlinDebug\n*F\n+ 1 IpcMessageDispatcher.kt\ncom/upuphone/xr/interconnect/business/messenger/IpcMessageDispatcher$dispatch$2\n*L\n114#1:136,2\n101#1:138,2\n*E\n"})
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class IpcMessageDispatcher$dispatch$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ StarryNetMessage $message;
    final /* synthetic */ CompletableDeferred<Boolean> $result;
    final /* synthetic */ IpcMessageDispatcher this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IpcMessageDispatcher$dispatch$2(StarryNetMessage starryNetMessage, IpcMessageDispatcher ipcMessageDispatcher, CompletableDeferred<Boolean> completableDeferred) {
        super(0);
        this.$message = starryNetMessage;
        this.this$0 = ipcMessageDispatcher;
        this.$result = completableDeferred;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$1(IpcMessageDispatcher ipcMessageDispatcher, StarryNetMessage starryNetMessage, Integer num, Set set) {
        Intrinsics.checkNotNullParameter(ipcMessageDispatcher, "this$0");
        Intrinsics.checkNotNullParameter(starryNetMessage, "$message");
        Intrinsics.checkNotNullParameter(num, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(set, "receivers");
        Iterator it = set.iterator();
        while (it.hasNext()) {
            HostAlienCallExtKt.safeAlienCall((IMessageReceiver) it.next(), ipcMessageDispatcher.getTag(), new IpcMessageDispatcher$dispatch$2$1$1$1(starryNetMessage));
        }
    }

    public final void invoke() {
        Integer num;
        String receiverPkg = this.$message.getReceiverPkg();
        String access$getTag = this.this$0.getTag();
        String id = this.$message.getId();
        ILog.d(access$getTag, "Dispatching message#" + id + " to " + receiverPkg + ".");
        if (Intrinsics.areEqual((Object) this.$message.getSenderPkg(), (Object) "System")) {
            this.this$0.receiverBuckets.forEach(new a(this.this$0, this.$message));
            this.$result.w(Boolean.TRUE);
        }
        if (!(receiverPkg == null || (num = IpcClientManager.INSTANCE.get(receiverPkg)) == null)) {
            Set<IMessageReceiver> set = this.this$0.receiverBuckets.get(num);
            if (!set.isEmpty()) {
                String access$getTag2 = this.this$0.getTag();
                String id2 = this.$message.getId();
                int size = set.size();
                ILog.d(access$getTag2, "Dispatching message#" + id2 + " to " + size + " receivers of " + num + ".");
                IpcMessageDispatcher ipcMessageDispatcher = this.this$0;
                StarryNetMessage starryNetMessage = this.$message;
                for (IMessageReceiver safeAlienCall : set) {
                    HostAlienCallExtKt.safeAlienCall(safeAlienCall, ipcMessageDispatcher.getTag(), new IpcMessageDispatcher$dispatch$2$2$1(starryNetMessage));
                }
                this.$result.w(Boolean.TRUE);
                return;
            }
        }
        this.$result.w(Boolean.FALSE);
    }
}
