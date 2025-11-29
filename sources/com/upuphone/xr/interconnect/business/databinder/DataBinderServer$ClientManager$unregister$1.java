package com.upuphone.xr.interconnect.business.databinder;

import com.upuphone.xr.interconnect.business.databinder.DataBinderServer;
import com.upuphone.xr.interconnect.util.log.ILog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class DataBinderServer$ClientManager$unregister$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ int $pid;
    final /* synthetic */ DataBinderServer.ClientManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DataBinderServer$ClientManager$unregister$1(DataBinderServer.ClientManager clientManager, int i) {
        super(0);
        this.this$0 = clientManager;
        this.$pid = i;
    }

    public final void invoke() {
        String access$getTag = this.this$0.getTag();
        int i = this.$pid;
        ILog.d(access$getTag, "Removing client from " + i + ".");
        this.this$0.clientMap.remove(Integer.valueOf(this.$pid));
    }
}
